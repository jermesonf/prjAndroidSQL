package com.example.projaulasql;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.SQLException;

public class MainActivity extends AppCompatActivity {

    Acessa objA = new Acessa();
    TextView texto1, texto2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        texto1 = findViewById(R.id.txt1);
        texto2 = findViewById(R.id.txt2);



    }

    public void consultar()
    {
        try{

            objA.RS = objA.stmt.executeQuery("SELECT * FROM login ORDER BY usuario");

        }catch (SQLException ex){

            Toast.makeText(this, "Table fail", Toast.LENGTH_SHORT).show();

        }
    }

    public void preencher()
    {
        try{

            texto1.setText(objA.RS.getString("usuario"));
            texto2.setText(objA.RS.getString("senha"));

        }catch (SQLException ex){

            Toast.makeText(this, "textos fails", Toast.LENGTH_SHORT).show();

        }
    }

    public void avancar(View v)
    {

        try
        {
            if (objA.RS.next())
            {
                preencher();
            }
        }
        catch (SQLException ex)
        {

        }

    }

    public void avancarF(View v)
    {

        try
        {
            if (objA.RS.last())
            {
                preencher();
            }
        }
        catch (SQLException ex)
        {

        }

    }

    public void voltar(View v)
    {

        try
        {
            if (objA.RS.previous())
            {
                preencher();
            }
        }
        catch (SQLException ex)
        {

        }

    }

    public void inicio(View v)
    {

        try
        {
            if (objA.RS.first())
            {
                preencher();
            }
        }
        catch (SQLException ex)
        {

        }

    }

    public void conectar (View x)
    {
        objA.entBanco(this);
        consultar();

        try{
            if(objA.RS.next())
            {
                preencher();
            }
        }catch (SQLException ex){

            Toast.makeText(this, "Erro " + ex, Toast.LENGTH_SHORT).show();

        }
    }

}