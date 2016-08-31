package com.example.justhfranklin.imposto;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickBtCalc(View view) {
        EditText edtSal = (EditText) findViewById(R.id.edtSal);

        double vlBruto = Double.parseDouble(edtSal.getText().toString());

        double vlSemInss = getVlInss(vlBruto);

        double vlLiquido = vlBruto - getVlInss(vlBruto) - getVlIR(vlSemInss);

        TextView txtSal = (TextView) findViewById(R.id.txtSal);

        NumberFormat textoFormatado = NumberFormat.getCurrencyInstance();

        txtSal.setText("Salário Líquido: "+ textoFormatado.format(vlLiquido));
    }

    public double getVlInss(double vlBruto){

        double result = 0;

        if (vlBruto <= 1556.94){
            result = (vlBruto * 8)/100;
        }
        else if (vlBruto <= 2594.92){
            result = (vlBruto * 9)/100;
        }
        else if (vlBruto <= 5189.82){
            result = (vlBruto * 11)/100;
        }
        else{
            result = (5189.82 * 11)/100;
        }

        return result;

    }

    public double getVlIR(double vlSemInss){

        double result = 0;

        if (vlSemInss <= 1903.98){
            result = 0;
        }
        else if (vlSemInss <= 2826.65){
            result = ((vlSemInss * 7.5)/100)-142.80;
        }
        else if (vlSemInss <= 3751.05){
            result = ((vlSemInss * 15)/100)-354.80;
        }
        else if (vlSemInss <= 4664.68){
            result = ((vlSemInss * 22.5)/100)-636.13;

        }
        else {
            result = ((vlSemInss * 27.5)/100)-869.36;
        }

        return result;
    }

}
