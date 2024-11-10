package com.example.healthgeneration;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.Firebase;

public class TelaMatriculaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_matricula);

    }

    public void proximo5(View view){
        Intent in = new Intent(TelaMatriculaActivity.this, CadastroActivity.class);
        startActivity(in);
    }

    public void proximo6(View view){
        Intent in = new Intent(TelaMatriculaActivity.this, LoginActivity.class);
        startActivity(in);
    }
}