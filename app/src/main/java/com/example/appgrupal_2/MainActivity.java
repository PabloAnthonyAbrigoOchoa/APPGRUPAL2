package com.example.appgrupal_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText txtValorIngresado;
    private Spinner spnOpciones;
    private Button btnConvertir;
    private TextView txtResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        txtValorIngresado=(EditText) findViewById(R.id.editTextValor);
        spnOpciones=(Spinner) findViewById(R.id.spnOpciones);
        btnConvertir=(Button) findViewById(R.id.btnConvertir);
        txtResultado=(TextView) findViewById(R.id.textViewResultado);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public double deCelsiusAFarenheit(){
        int celsius = Integer.valueOf(txtValorIngresado.getText().toString());
        celsius = celsius*2-celsius/5;
        celsius = celsius+32;
        return celsius;
    }

    public double deCelsiusAKelvin(){
        int celsius = Integer.valueOf(txtValorIngresado.getText().toString());
        double result = celsius + 273.15;
        return result;
    }

    @Override
    public void onClick(View v) {
        if (v==btnConvertir){
            if(txtValorIngresado.getText().toString().isEmpty()){
                txtValorIngresado.setError("Escriba un Valor");
            }else{
                enviarResultado();
            }
        }
    }
    public void enviarResultado(){
        if (spnOpciones.getSelectedItemPosition()==0){
            txtResultado.setText("El Resultado es: "+deCelsiusAFarenheit()+"Grados Farenheit");
        }else{
            txtResultado.setText("El Resultado es: "+deCelsiusAKelvin()+"Grados Kelvin");
        }
    }

}