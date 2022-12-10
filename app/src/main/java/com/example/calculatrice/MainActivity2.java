package com.example.calculatrice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    Button b1s,b2s,b3s,b4s,b5s,b6s,b7s,b8s,b9s,b0s,bacs,bcs,bpluss,bminuss,bmods,bequals,bdots,bbrac1s,bbrac2s,bpis;
    TextView tvmains,tvsecs;
    Toolbar toolbar;
    Dialog myDialog;
    int sum = 0;
    String pi = "3.14159265";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        b1s = findViewById(R.id.b1s);
        b2s = findViewById(R.id.b2s);
        b3s = findViewById(R.id.b3s);
        b4s = findViewById(R.id.b4s);
        b5s = findViewById(R.id.b5s);
        b6s = findViewById(R.id.b6s);
        b7s = findViewById(R.id.b7s);
        b8s= findViewById(R.id.b8s);
        b9s = findViewById(R.id.b9s);
        b0s = findViewById(R.id.b0s);
        bacs = findViewById(R.id.bacs);
        bcs = findViewById(R.id.bcs);
        bpluss = findViewById(R.id.bpluss);
        bminuss = findViewById(R.id.bminuss);

        bmods = findViewById(R.id.bmods);
        bequals = findViewById(R.id.bequals);
        bdots = findViewById(R.id.bdots);

        bpis = findViewById(R.id.bpis);
        bbrac1s = findViewById(R.id.bbrac1s);
        bbrac2s = findViewById(R.id.bbrac2s);






        //onclick listeners
        b1s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String val = tvmains.getText().toString();
                tvmains.setText(val+b1s.getText().toString());
            }
        });
        b2s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String val = tvmains.getText().toString();
                tvmains.setText(val+b2s.getText().toString());
            }
        });
        b3s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String val = tvmains.getText().toString();
                tvmains.setText(val+b3s.getText().toString());
            }
        });
        b4s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String val = tvmains.getText().toString();
                tvmains.setText(val+b4s.getText().toString());
            }
        });
        b5s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String val = tvmains.getText().toString();
                tvmains.setText(val+b5s.getText().toString());
            }
        });
        b6s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String val = tvmains.getText().toString();
                tvmains.setText(val+b6s.getText().toString());
            }
        });
        b7s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String val = tvmains.getText().toString();
                tvmains.setText(val+b7s.getText().toString());
            }
        });
        b8s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String val = tvmains.getText().toString();
                tvmains.setText(val+b8s.getText().toString());
            }
        });
        b9s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String val = tvmains.getText().toString();
                tvmains.setText(val+b9s.getText().toString());
            }
        });
        b0s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String val = tvmains.getText().toString();
                tvmains.setText(val+b0s.getText().toString());
            }
        });
        bdots.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String val = tvmains.getText().toString();
                if (!val.contains("."))
                {
                    tvmains.setText(val+bdots.getText().toString());
                }
            }
        });
        bpluss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String val = tvmains.getText().toString();
                if (!val.equals(""))
                {
                    tvmains.setText(val+bpluss.getText().toString());
                }
            }
        });

        bminuss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String val = tvmains.getText().toString();
                char last = val.charAt(val.length() -1);
                if (last!='-')
                {
                    tvmains.setText(val+bminuss.getText().toString());
                }
            }
        });
        bmods.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String val = tvmains.getText().toString();
                char last = val.charAt(val.length() -1);
                if (!val.equals(""))
                {
                    tvmains.setText(val+bmods.getText().toString());
                }
            }
        });
        bequals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String val = tvmains.getText().toString();
                String replacedString = val.replace('÷','/').replace('×', '*');
                double result = eval(replacedString);
                String r = String.valueOf(result);
                tvmains.setText(r);
                tvsecs.setText(val);
            }
        });

    }
    public static double eval(final String str) {
        return new Object() {
            int pos = -1, ch;

            void nextChar() {
                ch = (++pos < str.length()) ? str.charAt(pos) : -1;
            }

            boolean eat(int charToEat) {
                while (ch == ' ') nextChar();
                if (ch == charToEat) {
                    nextChar();
                    return true;
                }
                return false;
            }

            double parse() {
                nextChar();
                double x = parseExpression();
                if (pos < str.length()) throw new RuntimeException("Unexpected: " + (char)ch);
                return x;
            }

            // Grammar:
            // expression = term | expression `+` term | expression `-` term
            // term = factor | term `*` factor | term `/` factor
            // factor = `+` factor | `-` factor | `(` expression `)`
            //        | number | functionName factor | factor `^` factor

            double parseExpression() {
                double x = parseTerm();
                for (;;) {
                    if      (eat('+')) x += parseTerm(); // addition
                    else if (eat('-')) x -= parseTerm(); // subtraction
                    else return x;
                }
            }

            double parseTerm() {
                double x = parseFactor();
                for (;;) {
                    if      (eat('*')) x *= parseFactor(); // multiplication
                    else if (eat('/')) x /= parseFactor(); // division
                    else return x;
                }
            }

            double parseFactor() {
                if (eat('+')) return parseFactor(); // unary plus
                if (eat('-')) return -parseFactor(); // unary minus

                double x;
                int startPos = this.pos;
                if (eat('(')) { // parentheses
                    x = parseExpression();
                    eat(')');
                } else if ((ch >= '0' && ch <= '9') || ch == '.') { // numbers
                    while ((ch >= '0' && ch <= '9') || ch == '.') nextChar();
                    x = Double.parseDouble(str.substring(startPos, this.pos));
                } else if (ch >= 'a' && ch <= 'z') { // functions
                    while (ch >= 'a' && ch <= 'z') nextChar();
                    String func = str.substring(startPos, this.pos);
                    x = parseFactor();
                    if (func.equals("sqrt")) x = Math.sqrt(x);
                    else if (func.equals("sin")) x = Math.sin(Math.toRadians(x));
                    else if (func.equals("cos")) x = Math.cos(Math.toRadians(x));
                    else if (func.equals("tan")) x = Math.tan(Math.toRadians(x));
                    else if (func.equals("log")) x = Math.log10(x);
                    else if (func.equals("ln")) x = Math.log(x);
                    else throw new RuntimeException("Unknown function: " + func);
                } else {
                    throw new RuntimeException("Unexpected: " + (char)ch);
                }

                if (eat('^')) x = Math.pow(x, parseFactor()); // exponentiation

                return x;
            }
        }.parse();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflaterr = getMenuInflater();
        inflaterr.inflate(R.menu.menu1,menu);

        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch(item.getItemId())
        {
            case R.id.scientifique:
                Toast.makeText(this, "calc scientifique", Toast.LENGTH_SHORT).show();
                Intent intent =new Intent(MainActivity2.this,MainActivity.class);
                startActivity(intent);
                return true;
            case R.id.standard:
                Toast.makeText(this, "standard", Toast.LENGTH_SHORT).show();
                Intent intentt=new Intent(MainActivity2.this,MainActivity2.class);
                startActivity(intentt);
                return true;
            case R.id.historique:
                TextView textClose;

                myDialog.setContentView(R.layout.activity_pop_hist);
                textClose = (TextView) myDialog.findViewById(R.id.close);
                textClose.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        myDialog.dismiss();

                    }
                });
                myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                myDialog.show();
                Toast.makeText(this, "historique", Toast.LENGTH_SHORT).show();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
}}