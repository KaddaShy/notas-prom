package com.example.calculadoranotas;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class calcularprom extends AppCompatActivity {
    EditText name;
    EditText secondname;
    EditText n1;
    EditText n2;
    EditText n3;
    TextView prom;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = (EditText) findViewById(R.id.tx_nombre);
        secondname = (EditText) findViewById(R.id.tx_apellido);
        n1 = (EditText) findViewById(R.id.nota1);
        n2 = (EditText) findViewById(R.id.nota2);
        n3 = (EditText) findViewById(R.id.nota3);
        prom = (TextView) findViewById(R.id.tx_prom);
    }




    public String calcular(int n1, int n2, int n3) {
        double promedio = (n1 * 0.15 + n2 * 0.35 + n3 * 0.50);
        if (promedio >= 40.0) {
            return "Alumno Aprobado con un: " + promedio;
        } else {
            return "Alumno reprobado con un: " + promedio;

        }
    }
}