package com.example.adidas;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ProductListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_product_list);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        String category = getIntent().getStringExtra("CATEGORY_NAME");
        
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(category.toUpperCase());
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        RecyclerView recyclerView = findViewById(R.id.recyclerViewProducts);
        // Usar Grid de 2 colunas para um visual profissional
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        List<Product> products = getMockProducts(category);
        ProductAdapter adapter = new ProductAdapter(products, product -> {
            Intent intent = new Intent(ProductListActivity.this, ProductDetailActivity.class);
            intent.putExtra("PRODUCT", product);
            startActivity(intent);
        });
        recyclerView.setAdapter(adapter);
    }

    private List<Product> getMockProducts(String category) {
        List<Product> list = new ArrayList<>();
        if ("Calçados".equals(category)) {
            list.add(new Product("Samba OG", "O clássico atemporal da cultura urbana.", "R$ 649,99", R.drawable.samba_og));
            list.add(new Product("Campus 00s", "Design chunky inspirado nos anos 2000.", "R$ 699,99", R.drawable.ultraboost_light)); // Campus not found, using Ultraboost as placeholder or keeping adidaslogo? User didn't have campus_00s.jpg in the list_files output.
            list.add(new Product("Ultraboost Light", "Nosso Ultraboost mais leve de todos os tempos.", "R$ 1.199,99", R.drawable.ultraboost_light));
            list.add(new Product("Gazelle Indoor", "O ícone dos anos 70 reinventado.", "R$ 799,99", R.drawable.gazelle_indoor));
            list.add(new Product("Superstar", "O clássico das quadras e das ruas.", "R$ 499,99", R.drawable.superstar));
            list.add(new Product("Forum Low", "Estilo vintage de basquete.", "R$ 699,99", R.drawable.forum_low));
        } else if ("Roupas".equals(category)) {
            list.add(new Product("Camisa Flamengo 24/25", "Manto sagrado versão torcedor.", "R$ 349,99", R.drawable.camisa_flamengo));
            list.add(new Product("Jaqueta Firebird", "O clássico das 3 listras em cores novas.", "R$ 499,99", R.drawable.jaqueta_firebird));
            list.add(new Product("Calça Tracksuit Adicolor", "Conforto e estilo Originals.", "R$ 399,99", R.drawable.calca_tracksuit));
            list.add(new Product("Camiseta Trefoil", "Essencial para o seu guarda-roupa.", "R$ 129,99", R.drawable.camiseta_trefoil));
            list.add(new Product("Shorts Tiro 23", "Performance e ventilação para o treino.", "R$ 179,99", R.drawable.short_tiro));
        } else {
            list.add(new Product("Mochila Power VI", "Espaçosa e resistente para o dia a dia.", "R$ 249,99", R.drawable.mochila_power));
            list.add(new Product("Boné Trefoil Baseball", "Ajuste perfeito e estilo clássico.", "R$ 129,99", R.drawable.bone_trefoil));
            list.add(new Product("Adilette Slides", "O chinelo mais icônico do mundo.", "R$ 199,99", R.drawable.adilette_slides));
            list.add(new Product("Meias Cushioned 3-Pack", "Amortecimento onde você mais precisa.", "R$ 59,99", R.drawable.meias_cushioned));
        }
        return list;
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
