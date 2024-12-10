package com.example.mycalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    String str="";
    String operation;
    Double firstNo;
    Button btnClr,btnPls,btnEql,btnMul,btnMinus,btnDiv;
    EditText tbx;
    int operFlag=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnClr =findViewById(R.id.btnClr);
        btnEql=findViewById(R.id.btnEql);
        btnPls=findViewById(R.id.btnplus);
        btnMul=findViewById(R.id.btnMul);
        btnMinus=findViewById(R.id.btnminus);
        btnDiv=findViewById(R.id.btnDiv);
        btnEql.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {

                       Double secondNo = Double.parseDouble(tbx.getText().toString());
                        double result = 0;
                        switch (operation) {
                            case "+":
                                result = firstNo + secondNo;
                                break;
                            case "-":
                                result = firstNo - secondNo;
                                break;
                            case "×":
                                result = firstNo * secondNo;
                                break;
                            case "÷":
                                result = firstNo / secondNo;
                                break;
                            default:
                                Toast.makeText(getApplicationContext(), "Something Went Wrong INSIDE", Toast.LENGTH_SHORT).show();
                        }
                        tbx.setText(String.valueOf(result));

                } catch (NullPointerException e) {
                    Toast.makeText(getApplicationContext(),"Please Enter Any Value",Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "Something Went Wrong", Toast.LENGTH_SHORT).show();
                }

            }

        });
        btnClr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firstNo=null;
                tbx.setText(null);
                str="";
            }
        });

        ArrayList<Button> oper=new ArrayList<>();
        oper.add(btnPls);
        oper.add(btnMinus);
        oper.add(btnMul);
        oper.add(btnDiv);
        for (Button b : oper){
            b.setOnClickListener(view ->{
                firstNo=Double.parseDouble(tbx.getText().toString());
                operation=b.getText().toString();
                tbx.setText("");
                str="";

                operFlag++;
            });
        }

    }


    public void myFunc(View view) {
        Button b1=(Button)findViewById(view.getId());
        tbx=findViewById(R.id.editTextText);

        switch(Integer.parseInt(b1.getText().toString()))
        {
            case 1:
                str+="1";
                break;
            case 2:
                str+="2";
                break;
            case 3:
                str+="3";
                break;
            case 4:
                str+="4";
                break;
            case 5:
                str+="5";
                break;
            case 6:
                str+="6";
                break;
            case 7:
                str+="7";
                break;
            case 8:
                str+="8";
                break;
            case 9:
                str+="9";
                break;
            case 0:
                str+="0";
                break;
            default:
                Toast.makeText(getApplicationContext(),"Something Went Wrong",Toast.LENGTH_SHORT).show();
        }
        tbx.setText(str);
    }

}