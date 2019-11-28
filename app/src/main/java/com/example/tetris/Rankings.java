package com.example.tetris;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Rankings extends AppCompatActivity {
    private TextView textoRanking1,textoRanking2,textoRanking3,textoRanking4,textoRanking5,textoRanking6,mostrarPunt1,mostrarPunt2,mostrarPunt3,mostrarPunt4,mostrarPunt5,mostrarPunt6;
    private SQLiteDatabase BaseDeDatos;
    private AdminSQLiteOpenHelper BBDD;
    private int modo;
    private String tipoBBDD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Bundle p = this.getIntent().getExtras();
        modo = p.getInt("modo");
        BBDD = new AdminSQLiteOpenHelper(this, "RankingJugadores", null, 1);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rankings);

        Button restEstadisticas =  findViewById(R.id.restablecerEstadisticas);
        Button menu= findViewById(R.id.goMenu);

        textoRanking1 = findViewById(R.id.mostrarRanking1);
        textoRanking2 = findViewById(R.id.mostrarRanking2);
        textoRanking3 = findViewById(R.id.mostrarRanking3);
        textoRanking4 = findViewById(R.id.mostrarRanking4);
        textoRanking5 = findViewById(R.id.mostrarRanking5);
        textoRanking6 = findViewById(R.id.mostrarRanking6);

        mostrarPunt1= findViewById(R.id.textpunt1);
        mostrarPunt2= findViewById(R.id.textpunt2);
        mostrarPunt3= findViewById(R.id.textpunt3);
        mostrarPunt4= findViewById(R.id.textpunt4);
        mostrarPunt5= findViewById(R.id.textpunt5);
        mostrarPunt6= findViewById(R.id.textpunt6);

        mostrarTop5();

        restEstadisticas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                restablecerEstadiaticas(v);
            }
        });

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentMenu = new Intent(Rankings.this, Inicio.class);
                startActivity(intentMenu);
            }
        });

    }


    public void mostrarTop5 (){
        BaseDeDatos = BBDD.getWritableDatabase();
        String columnas[] = new String[]{"nombre","puntuacion"};//,"puntuacion"
        String j1="",j2="",j3="",j4="",j5="",j6="",p1="",p2="",p3="",p4="",p5="",p6="";

        //********************** AMBAS FUNCIONAN
        //-----1 forma
        if(modo==0){
            tipoBBDD = "rankingNormal";
        }else{
            tipoBBDD = "rankingHard";
        }
        Cursor fila1 =BaseDeDatos.rawQuery("select * from "+tipoBBDD+"  order by puntuacion DESC",null);

        //-----2 forma
        //Cursor fila2 = BaseDeDatos.query("rankingNormal", columnas, null, null, null, null, "puntuacion"+" DESC");
        if(fila1.moveToFirst()){
            //mostrarRanking.setText(fila1.getString(0)+fila1.getString(1));

            j1 = fila1.getString(0);
            p1 = fila1.getString(1);

            if (fila1.moveToNext()) {
                j2 = fila1.getString(0);
                p2 = fila1.getString(1);
            }
            if (fila1.moveToNext()) {
                j3 = fila1.getString(0);
                p3 = fila1.getString(1);
            }
            if (fila1.moveToNext()) {
                j4 = fila1.getString(0);
                p4 = fila1.getString(1);
            }
            if (fila1.moveToNext()) {
                j5 = fila1.getString(0);
                p5 = fila1.getString(1);
            }
            if (fila1.moveToNext()) {
                j6 = fila1.getString(0);
                p6= fila1.getString(1);
            }


        }else {

            j1="";
            j2="";
            j3="";
            j4="";
            j5="";
            j6="";
            p1="";
            p2="";
            p3="";
            p4="";
            p5="";
            p6="";
        }

        textoRanking1.setText(j1);
        textoRanking2.setText(j2);
        textoRanking3.setText(j3);
        textoRanking4.setText(j4);
        textoRanking5.setText(j5);
        textoRanking6.setText(j6);

        mostrarPunt1.setText(p1);
        mostrarPunt2.setText(p2);
        mostrarPunt3.setText(p3);
        mostrarPunt4.setText(p4);
        mostrarPunt5.setText(p5);
        mostrarPunt6.setText(p6);

        BaseDeDatos.close();
    }

    public void restablecerEstadiaticas (View view){
        BaseDeDatos = BBDD.getWritableDatabase();

        if(modo==0){
            tipoBBDD = "rankingNormal";
        }else{
            tipoBBDD = "rankingHard";
        }
        BaseDeDatos.execSQL("DELETE FROM "+tipoBBDD);
        Toast.makeText(this, "Estadisticas restablecidas", Toast.LENGTH_SHORT).show();
        BaseDeDatos.close();
        mostrarTop5();
    }

}