package com.example.adidas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        View cardShoes = findViewById(R.id.cardShoes);
        View cardClothing = findViewById(R.id.cardClothing);
        View cardAccessories = findViewById(R.id.cardAccessories);
        View cardCart = findViewById(R.id.cardCart);

        cardShoes.setOnClickListener(v -> openProductList("Calçados"));
        cardClothing.setOnClickListener(v -> openProductList("Roupas"));
        cardAccessories.setOnClickListener(v -> openProductList("Acessórios"));
        cardCart.setOnClickListener(v -> startActivity(new Intent(this, CartActivity.class)));

        setupNewItems();
    }

    private void setupNewItems() {
        View item1 = findViewById(R.id.itemNew1);
        View item2 = findViewById(R.id.itemNew2);
        View item3 = findViewById(R.id.itemNew3);

        updateProductItem(item1, "Samba OG", "R$ 649,99", R.drawable.samba_og);
        updateProductItem(item2, "Ultraboost Light", "R$ 1.199,99", R.drawable.ultraboost_light);
        updateProductItem(item3, "Camisa Flamengo", "R$ 349,99", R.drawable.camisa_flamengo);
    }

    private void updateProductItem(View itemView, String name, String price, int imageRes) {
        android.widget.TextView tvName = itemView.findViewById(R.id.productName);
        android.widget.TextView tvPrice = itemView.findViewById(R.id.productPrice);
        android.widget.ImageView imgProduct = itemView.findViewById(R.id.productImage);

        tvName.setText(name);
        tvPrice.setText(price);
        imgProduct.setImageResource(imageRes);
    }

    private void openProductList(String category) {
        Intent intent = new Intent(this, ProductListActivity.class);
        intent.putExtra("CATEGORY_NAME", category);
        startActivity(intent);
    }
}
