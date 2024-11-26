package com.example.healthgeneration;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class NovoExercicio2Activity extends AppCompatActivity {

    private CheckBox checkHiper, checkDefi, checkEma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_novo_exercicio2);

        // Inicializando os elementos do layout
        checkHiper = findViewById(R.id.checkHiper);
        checkDefi = findViewById(R.id.checkDefi);
        checkEma = findViewById(R.id.checkEma);
    }

    // Método chamado ao clicar no botão "Continuar"
    public void next(View view) {
        if (validarSelecoes()) {
            // Navegar para a próxima tela se ao menos uma opção foi selecionada
            Intent in = new Intent(NovoExercicio2Activity.this, NovoExercicio3Activity.class);
            startActivity(in);
        } else {
            // Mostrar mensagem de erro se nenhuma opção foi selecionada
            Toast.makeText(this, "Por favor, selecione pelo menos um objetivo!", Toast.LENGTH_LONG).show();
        }
    }

    // Método para validar as seleções
    private boolean validarSelecoes() {
        // Retorna verdadeiro se pelo menos um dos checkboxes ou o radiobutton foi selecionado
        return checkHiper.isChecked() || checkDefi.isChecked() || checkEma.isChecked();
    }
}
