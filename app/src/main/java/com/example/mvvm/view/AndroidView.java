package com.example.mvvm.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.mvvm.R;
import com.example.mvvm.model.Model;

import java.util.Observable;
import java.util.Observer;

public class AndroidView extends AppCompatActivity {
    private Model model = new Model();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        observeModel(model);
        final Button button = findViewById(R.id.enterButton);
        final EditText editText = findViewById(R.id.inputText);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String input = editText.getText().toString();
                model.setData(input);
            }
        });
    }

    private void observeModel(Model model) {
        model.addObserver(new Observer() {
            @Override
            public void update(Observable observable, Object o) {
                if (observable instanceof Model) {
                    String data = ((Model) observable).getData();
                    final TextView textView = findViewById(R.id.outputView);
                    textView.setText(data);
                }
            }
        });
    }
}
