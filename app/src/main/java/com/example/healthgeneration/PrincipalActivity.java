package com.example.healthgeneration;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class PrincipalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        // Define o fragmento inicial
        loadFragment(new MenuFragment());

        // Listener para navegação no BottomNavigation
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment = null;

                if (item.getItemId() == R.id.nav_menu) {
                    selectedFragment = new MenuFragment();
                } else if (item.getItemId() == R.id.nav_relatorio) {
                    selectedFragment = new RelatorioFragment();
                } else if (item.getItemId() == R.id.nav_perfil) {
                    selectedFragment = new PerfilFragment();
                }

                if (selectedFragment != null) {
                    loadFragment(selectedFragment);
                }
                return true;
            }
        });
    }

    // Método para carregar fragments
    private void loadFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit();
    }

    // Método para navegação via Intent
    public void proximo4(View view) {
        Intent intent = new Intent(PrincipalActivity.this, NovoExercicioActivity.class);
        startActivity(intent);
    }
}
