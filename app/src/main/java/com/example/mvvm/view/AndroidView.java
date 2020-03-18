package com.example.mvvm.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.mvvm.R;

public class AndroidView extends AppCompatActivity {
    // TODO [milepæl 3] AndroidView skal indholde en instans af Model

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button button = findViewById(R.id.enterButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO [milepæl 2] outputView skal opdateres med indholdet fra inputText
                // TODO [milepæl 3] Instansen af Model skal opdateres med indholdet fra inputText
                // TODO [milepæl 3] outputView skal opdateres med indholdet fra instansen af Model
            }
        });
    }

    // TODO Denne metode bliver aldrig brugt (slet)
    public void enterData(View view) {
        EditText editText = (EditText) findViewById(R.id.inputText);
        String input = editText.getText().toString();
    }
}
