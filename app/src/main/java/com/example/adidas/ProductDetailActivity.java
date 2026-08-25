package com.example.adidas;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ProductDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_product_detail);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Product product = (Product) getIntent().getSerializableExtra("PRODUCT");

        if (product != null) {
            ImageView detailImage = findViewById(R.id.detailImage);
            TextView detailName = findViewById(R.id.detailName);
            TextView detailPrice = findViewById(R.id.detailPrice);
            TextView detailDescription = findViewById(R.id.detailDescription);

            detailImage.setImageResource(product.getImageResource());
            detailName.setText(product.getName());
            detailPrice.setText(product.getPrice());
            detailDescription.setText(product.getDescription());
        }

        androidx.appcompat.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Detalhes");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }


        findViewById(R.id.btnBuy).setOnClickListener(v -> {
            if (product != null) {
                CartManager.getInstance().addProduct(product);
                Toast.makeText(this, product.getName() + " adicionado ao carrinho!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
