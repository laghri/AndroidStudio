package com.example.calculatrice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.time.Clock;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> values =new ArrayList<String>();
    ArrayList<Float> Resultat= new ArrayList<Float>();
    ArrayList<Float> Valuesansope= new ArrayList<Float>();
    String s;
    String t;
    float res;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView Nuqua= findViewById(R.id.resultat);
        Nuqua.setText("0");
    }
   public String  Affichertout(View view){

        s="";
       for (int i=0;i<values.size();i++){
           if(i != 0 ){
             if(!values.get(i-1).equals("+") && !values.get(i-1).equals("*") && !values.get(i-1).equals("/") &&!values.get(i-1).equals("-") )
               s+=values.get(i);
       }}
       if(s== "")
           s="0";
       return s;
   }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu1,menu);

        return true;
    }
   public String AfficherSansOper(View view ){
        s="";


        return  s;
   }
    public void  Afficher(View arg0){
        TextView Nuqua= findViewById(R.id.resultat);
        TextView opeHis=findViewById(R.id.operationHis);
        Button btn = (Button)arg0;
        if(Nuqua.getText().toString() == null) {
            Nuqua.setText("");
            values.add(btn.getText().toString());

            Nuqua.setText(btn.getText().toString());
        }
        else {

            values.add(btn.getText().toString());

            Nuqua.setText(Affichertout(arg0));
        }

    if(btn.getText().toString().equals("+") || btn.getText().toString().equals("-") || btn.getText().toString().equals("*") ||  btn.getText().toString().equals("/") ) {


        opeHis.setText(Affichertout(arg0));


    }

    }

    public void supprimer(View view){
        TextView Nuqua= findViewById(R.id.resultat);
        String s="";
        if(values.size()==0){
            Nuqua.setText("0");
        }
        else {
            values.remove(values.size() -1);
            Nuqua.setText(Affichertout(view));
        }

    }
    public void Clear(View view){
        TextView Nuqua= findViewById(R.id.resultat);
        TextView opeHis=findViewById(R.id.operationHis);
           values.clear();
         Nuqua.setText(Affichertout(view));

    }
    public void OperationHis(View view){
        TextView opeHis=findViewById(R.id.operationHis);
        Button btn = (Button)view;
        if(btn.getText().toString() == "+" || btn.getText().toString() == "*" || btn.getText().toString() == "-" || btn.getText().toString() == "/" ) {
              opeHis.setText(Affichertout(view));
        }
    }
    public void  Calculet(View view){
        TextView Nuqua= findViewById(R.id.resultat);
        t="";
        for (int i=0;i<values.size();i++) {
            t+=  values.get(i);
        }
        Clear(view);
        res=Float.parseFloat(t);
        String h=String.valueOf(res);
        Nuqua.setText(h);



    }

}