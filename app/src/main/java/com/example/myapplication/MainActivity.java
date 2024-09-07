package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
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

        EditText notaA1 = findViewById(R.id.a1);
        EditText notaA2 = findViewById(R.id.a2);
        EditText notaA3 = findViewById(R.id.a3);
        Button btnCalcular = findViewById(R.id.btnCalculo);
        TextView result = findViewById(R.id.textResult);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (notaA1.getText().toString().isEmpty() ||
                    notaA2.getText().toString().isEmpty() ||
                    notaA3.getText().toString().isEmpty()) {

                    result.setText("Por favor, preencha todos os campos.");
                    return;
                }

                Integer nota1 = Integer.valueOf(notaA1.getText().toString());
                Integer nota2 = Integer.valueOf(notaA2.getText().toString());
                Integer nota3 = Integer.valueOf(notaA3.getText().toString());

                if (nota1 > 100 || nota2 > 100 || nota3 > 100) {
                    result.setText("Por favor, insira números até 100");
                    return;
                }

                float media = (float) (nota1 + nota2 + nota3) / 3;

                if (media < 70) {
                    result.setText("Você ficou abaixo da média. Resultado: " + String.format("%.2f", (float) media));
                }
                else{
                    result.setText("Você foi aprovado. Resultado: " + String.format("%.2f", (float) media));
                }
            }
        });
    }
}