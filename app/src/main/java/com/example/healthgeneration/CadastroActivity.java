package com.example.healthgeneration;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CadastroActivity extends AppCompatActivity {
    private EditText nomeEditText;
    private EditText emailEditText;
    private EditText senhaEditText;
    private DatabaseHelper db; // Assume que você já criou essa classe para gerenciar o SQLite

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cadastro);

        // Inicializa os campos de entrada e o banco de dados
        nomeEditText = findViewById(R.id.Cadastronome);
        emailEditText = findViewById(R.id.Cadastroemail);
        senhaEditText = findViewById(R.id.Cadastrosenha);
        db = new DatabaseHelper(this); // Inicializa o helper do banco de dados
    }

    public void proximo(View view) {
        String nome = nomeEditText.getText().toString();
        String email = emailEditText.getText().toString();
        String senha = senhaEditText.getText().toString();

        // Verifica se os campos estão preenchidos
        if (nome.isEmpty()) {
            Toast.makeText(this, "Por favor, preencha o campo de nome.", Toast.LENGTH_SHORT).show();
            return;
        }
        if (email.isEmpty()) {
            Toast.makeText(this, "Por favor, preencha o campo de e-mail.", Toast.LENGTH_SHORT).show();
            return;
        }
        if (senha.isEmpty()) {
            Toast.makeText(this, "Por favor, preencha o campo de senha.", Toast.LENGTH_SHORT).show();
            return;
        }

        // Verifica se o e-mail já está registrado
        if (!db.isEmailRegistered(email)) {
            // Se não estiver, insere o novo usuário no banco de dados
            db.addUser(nome, email, senha);
            Toast.makeText(this, "Cadastro bem-sucedido!", Toast.LENGTH_SHORT).show();
            // Não redireciona para a tela principal
        } else {
            Toast.makeText(this, "E-mail já cadastrado. Tente outro.", Toast.LENGTH_SHORT).show();
        }
    }
}

