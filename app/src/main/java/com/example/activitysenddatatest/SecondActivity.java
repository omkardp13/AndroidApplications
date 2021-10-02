package com.example.activitysenddatatest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private TextView ShowNum;
    private Button Add;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        setTitle("SeondActivity");

        Intent intent=getIntent();
        int Number1=intent.getIntExtra("num1",0);
        int Number2=intent.getIntExtra("num2",0);
        ShowNum=findViewById(R.id.tv_NumbersAre);
        ShowNum.setText("The First Number Is: "+ Number1 + " & Second Number Is: " + Number2);
        Add=findViewById(R.id.btn_Add);


        Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int mresult=Number1+Number2;
                Intent reusltIntent=new Intent();
                reusltIntent.putExtra("result",mresult);
                setResult(RESULT_OK,reusltIntent);
                finish();
            }
        });
    }
}