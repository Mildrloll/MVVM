package com.example.mvvm.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.mvvm.R;

public class AndroidView extends AppCompatActivity {
    private AndroidLowerCaseViewModel lowerCaseViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        observeViewModel();
        final Button button = findViewById(R.id.enterButton);
        final EditText editText = findViewById(R.id.inputText);
        editText.setText(lowerCaseViewModel.getPresentableData().getValue());
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String input = editText.getText().toString();
                lowerCaseViewModel.setData(input);
            }
        });
    }

    private void observeViewModel() {
        lowerCaseViewModel = new ViewModelProvider(this).get(AndroidLowerCaseViewModel.class);
        final Observer<String> stringObserver = new Observer<String>() {
            @Override
            public void onChanged(String s) {
                TextView textView = findViewById(R.id.outputView);
                textView.setText(s);
            }
        };
        lowerCaseViewModel.getPresentableData().observe(this, stringObserver);
    }
}
