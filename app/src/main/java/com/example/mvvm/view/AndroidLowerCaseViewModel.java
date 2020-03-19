package com.example.mvvm.view;

import com.example.mvvm.model.Model;

import java.util.Observable;
import java.util.Observer;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AndroidLowerCaseViewModel extends ViewModel {
    private MutableLiveData<String> presentableData = new MutableLiveData<>();
    private Model model = new Model();

    public AndroidLowerCaseViewModel() {
        observeModel(model);
        presentableData.setValue(getTransformedData(model.getData()));
    }

    private void observeModel(Model model) {
        model.addObserver(new Observer() {
            @Override
            public void update(Observable observable, Object o) {
                if (observable instanceof Model) {
                    String data = ((Model) observable).getData();
                    presentableData.setValue(getTransformedData(data));
                }
            }
        });
    }

    private String getTransformedData(String data) {
        return data.toLowerCase();
    }

    public MutableLiveData<String> getPresentableData() {
        return presentableData;
    }

    public void setData(String data) {
        model.setData(data);
    }
}
