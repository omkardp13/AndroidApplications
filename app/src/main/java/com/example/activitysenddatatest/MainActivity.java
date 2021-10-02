package com.example.activitysenddatatest;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button Show;
    private TextView Result;
    private EditText Number1,Number2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Show=findViewById(R.id.btn_Second_Activity);
        Number1=findViewById(R.id.edt_First);
        Number2=findViewById(R.id.edt_Num2);
        Result=findViewById(R.id.tv_Result);

        Show.setOnClickListener(new View.OnClickListener() {
            Intent intent=new Intent(MainActivity.this,SecondActivity.class);
            @Override
            public void onClick(View v) {
                if (Number1.getText().toString().equals("")||Number2.getText().toString().equals(""))
                {
                    Toast.makeText(getApplicationContext(),"Plese Enter Numbers",Toast.LENGTH_LONG).show();

                }
                else
                {
                    int Num1=Integer.parseInt(Number1.getText().toString());
                    int Num2=Integer.parseInt(Number2.getText().toString());
                    Intent intent = new Intent(getApplicationContext(),SecondActivity.class);

                    intent.putExtra("num1",Num1);
                    intent.putExtra("num2",Num2);

                    startActivityForResult(intent,1);
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,Intent data ) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==1)
        {
            if (resultCode==RESULT_OK)
            {
                int result=data.getIntExtra("result",0);
                Result.setText("Result is:"+result);
            }
        }
    }
}