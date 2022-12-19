package com.example.calculadoranotas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;


public class MainActivity extends AppCompatActivity {

    public Button btn_add;
    public Button btn_listado;
    public Button btn_calcular;
    calcularprom promedio = new calcularprom();
    EditText name;
    EditText secondname;
    EditText n1;
    EditText n2;
    EditText n3;
    TextView prom;
    int nota1, nota2, nota3;
    String enota1, enota2, enota3, nombre_, apellido_;
    private FirebaseFirestore mfirestore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_add = findViewById(R.id.btn_add);
        btn_listado = findViewById(R.id.btn_listado);
        btn_calcular = findViewById(R.id.btn_calcular);
        mfirestore = FirebaseFirestore.getInstance();

        btn_listado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ListadoNotas.class));
            }
        });


        btn_calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                n1 = (EditText) findViewById(R.id.nota1);
                n2 = (EditText) findViewById(R.id.nota2);
                n3 = (EditText) findViewById(R.id.nota3);
                prom = (TextView) findViewById(R.id.tx_prom);
                enota1 = n1.getText().toString();
                enota2 = n2.getText().toString();
                enota3 = n3.getText().toString();
                nota1 = Integer.parseInt(enota1);
                nota2 = Integer.parseInt(enota2);
                nota3 = Integer.parseInt(enota3);
                name = findViewById(R.id.tx_nombre);
                secondname = findViewById(R.id.tx_apellido);
                nombre_ = name.getText().toString();
                apellido_ = secondname.getText().toString();
                prom.setText(nombre_ + apellido_ + promedio.calcular(nota1, nota2, nota3));
            }
        });

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nombre_ = name.getText().toString();
                apellido_ = secondname.getText().toString();

                if (nombre_.isEmpty() && apellido_.isEmpty()){
                    Toast.makeText(getApplicationContext(),"Ingresar los datos",Toast.LENGTH_SHORT);
                }else{
                    nombres(nombre_, apellido_,nota1,nota2,nota3);
                }
            }
        });
    }

    private void nombres(String nombre_, String apellido_, int nota1, int nota2, int nota3) {
        this.nombre_ = nombre_;
        this.apellido_ = apellido_;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
        Map<String,Object> map = new HashMap<>();
        map.put("nombre", nombre_);
        map.put("apellido", apellido_);
        map.put("nota1", nota1);
        map.put("nota2", nota2);
        map.put("nota3", nota3);

        mfirestore.collection("alumnos").add(map).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            @Override
            public void onSuccess(DocumentReference documentReference) {
                Toast.makeText(getApplicationContext(), "Creado Exitoso", Toast.LENGTH_SHORT).show();
                finish();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getApplicationContext(), "error al ingresar", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

