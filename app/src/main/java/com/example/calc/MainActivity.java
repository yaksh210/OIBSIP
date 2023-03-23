package com.example.calc;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

public class MainActivity extends AppCompatActivity {

    Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b0,bc,ba,bd,bm,bmi,beq,blb,brb,bdot;
    TextView tin,tout;
    String data;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1=findViewById(R.id.btn_1);
        b2=findViewById(R.id.btn_2);
        b3=findViewById(R.id.btn_3);
        b4=findViewById(R.id.btn_4);
        b5=findViewById(R.id.btn_5);
        b6=findViewById(R.id.btn_6);
        b7=findViewById(R.id.btn_7);
        b8=findViewById(R.id.btn_8);
        b9=findViewById(R.id.btn_9);
        b0=findViewById(R.id.btn_0);
        bc=findViewById(R.id.btn_clr);
        ba=findViewById(R.id.add);
        bd=findViewById(R.id.div);
        bm=findViewById(R.id.mul);
        bmi=findViewById(R.id.minus);
        beq=findViewById(R.id.equal);
        brb=findViewById(R.id.mod);
        bdot=findViewById(R.id.dot);

        tin=findViewById(R.id.input);
        tout=findViewById(R.id.output);



        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                data=tin.getText().toString();
                tin.setText(data+"1");
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                data=tin.getText().toString();
                tin.setText(data+"2");
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                data=tin.getText().toString();
                tin.setText(data+"3");
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                data=tin.getText().toString();
                tin.setText(data+"4");
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                data=tin.getText().toString();
                tin.setText(data+"5");
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                data=tin.getText().toString();
                tin.setText(data+"6");
            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                data=tin.getText().toString();
                tin.setText(data+"7");
            }
        });
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                data=tin.getText().toString();
                tin.setText(data+"8");
            }
        });
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                data=tin.getText().toString();
                tin.setText(data+"9");
            }
        });
        b0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                data=tin.getText().toString();
                tin.setText(data+"0");
            }
        });

        bc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tin.setText("");
                tout.setText("");
            }
        });

        ba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data=tin.getText().toString();
                tin.setText(data+"+");
            }
        });

        bd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data=tin.getText().toString();
                tin.setText(data+"÷");
            }
        });

        bm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data=tin.getText().toString();
                tin.setText(data+"×");
            }
        });

        bmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data=tin.getText().toString();
                tin.setText(data+"-");
            }
        });
        brb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data=tin.getText().toString();
                tin.setText(data+"%");
            }
        });


        beq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                data=tin.getText().toString();

                data=data.replaceAll("×","*");
                data=data.replaceAll("%","/100");
                data=data.replaceAll("÷","/");

                Context rhino=Context.enter();
                rhino.setOptimizationLevel(-1);

                String finalResult=" ";

                Scriptable scriptable=rhino.initStandardObjects();
                finalResult = rhino.evaluateString(scriptable,data,"javsscript",1,null).toString();

                tout.setText(finalResult);



            }
        });



        bdot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                data=tin.getText().toString();
                tin.setText(data+".");
            }
        });


    }
}