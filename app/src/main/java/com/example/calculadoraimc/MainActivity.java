package com.example.calculadoraimc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private ImageView img;
    private Button btnCalcular;
    private EditText peso;
    private EditText altura;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCalcular = findViewById(R.id.calcularImc);
        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                img = findViewById(R.id.imgPeso);
                double imc = calcularImc();
                int idIco = definirImagemImc(imc);
                img.setImageResource(idIco);
            }
        });

    }

    /**
     * Metodo ira definir qual imagem sera exibida na ImageView
     * Dependera do resultado do IMC
     * @param imc
     * @return
     */
    private int definirImagemImc(double imc){
        int idRImage = 0;

        DecimalFormat frmt = new DecimalFormat("00.00");
        double imc2 = Double.parseDouble(frmt.format(imc));
        if (imc2 <= 18.5) {
            idRImage = R.drawable.imc_baixo_peso;
        } else if(imc2 >= 18.6 && imc <=24.9){
            idRImage = R.drawable.imc_peso_normal;
        } else if(imc2 >= 25 && imc <= 29.9){
            idRImage = R.drawable.imc_sobre_peso;
        } else if(imc2 >= 30){
            idRImage = R.drawable.imc_sobre_peso;
        }

        return idRImage;
    }

    /**
     * Calcula o IMC
     * @return
     */
    private double calcularImc(){

        peso = findViewById(R.id.editPeso);
        altura = findViewById(R.id.editAltura);

        double vPeso = Double.parseDouble(peso.getText().toString());
        double vAltura = Double.parseDouble(altura.getText().toString());

        double imc = vPeso/(vAltura*vAltura);
        return imc;
    }
}