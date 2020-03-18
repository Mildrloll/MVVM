package com.example.mvvm.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.mvvm.R;
import com.example.mvvm.model.Model;

public class AndroidView extends AppCompatActivity {
    // TODO [milepæl 3] AndroidView skal indholde en instans af Model
    private Model model = new Model();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button button = findViewById(R.id.enterButton);
        final EditText editText = findViewById(R.id.inputText);
        final TextView textView = findViewById(R.id.outputView);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String input = editText.getText().toString();
                textView.setText(input);
                // TODO [milepæl 3] Instansen af Model skal opdateres med indholdet fra inputText
                model.setData(input);
                // TODO [milepæl 3] outputView skal opdateres med indholdet fra instansen af Model
                textView.setText(model.getData());
            }
        });
    }
}
