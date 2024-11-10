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

public class LoginActivity extends AppCompatActivity {
    private EditText emailEditText;
    private EditText passwordEditText;
    private DatabaseHelper db; // Assume que você já criou essa classe para gerenciar o SQLite

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        // Inicializa os campos de entrada e o banco de dados
        emailEditText = findViewById(R.id.LoginEmail);
        passwordEditText = findViewById(R.id.LoginSenha);
        db = new DatabaseHelper(this); // Inicializa o helper do banco de dados
    }

    public void proximo(View view) {
        String email = emailEditText.getText().toString();
        String password = passwordEditText.getText().toString();

        // Verifica se os campos estão preenchidos
        if (email.isEmpty()) {
            Toast.makeText(this, "Por favor, preencha o campo de e-mail.", Toast.LENGTH_SHORT).show();
            return;
        }
        if (password.isEmpty()) {
            Toast.makeText(this, "Por favor, preencha o campo de senha.", Toast.LENGTH_SHORT).show();
            return;
        }

        // Verifica se o e-mail e senha correspondem a um usuário cadastrado no banco
        if (db.checkUser(email, password)) {
            Toast.makeText(this, "Login bem-sucedido!", Toast.LENGTH_SHORT).show();
            // Inicia a tela principal
            Intent in = new Intent(LoginActivity.this, PrincipalActivity.class);
            startActivity(in);
        } else if (!db.isEmailRegistered(email)) {
            // Exibe mensagem sem redirecionar
            Toast.makeText(this, "E-mail não cadastrado. Por favor, cadastre-se.", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Senha incorreta. Tente novamente.", Toast.LENGTH_SHORT).show();
        }

    }

    public void proximo2(View view){
        Intent in = new Intent(LoginActivity.this, CadastroActivity.class);
        startActivity(in);
    }
}

