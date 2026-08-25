package com.example.adidas;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.Locale;

public class CartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cart);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        RecyclerView recyclerView = findViewById(R.id.recyclerViewCart);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<Product> cartItems = CartManager.getInstance().getCartItems();
        ProductAdapter adapter = new ProductAdapter(cartItems, product -> {
            Intent intent = new Intent(CartActivity.this, ProductDetailActivity.class);
            intent.putExtra("PRODUCT", product);
            startActivity(intent);
        });
        recyclerView.setAdapter(adapter);

        updateTotal();

        findViewById(R.id.btnCheckout).setOnClickListener(v -> {
            if (cartItems.isEmpty()) {
                Toast.makeText(this, "Seu carrinho está vazio!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Compra finalizada com sucesso!", Toast.LENGTH_LONG).show();
                CartManager.getInstance().clearCart();
                finish();
            }
        });
    }

    private void updateTotal() {
        TextView tvTotal = findViewById(R.id.cartTotal);
        double total = CartManager.getInstance().getTotalPrice();
        tvTotal.setText(String.format(Locale.getDefault(), "R$ %.2f", total));
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
