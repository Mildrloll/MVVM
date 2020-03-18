package com.example.mvvm.model;

import java.util.Observable;

public class Model extends Observable {
    private String data;

    public Model() {
        data = "Hello";
    }

    public String getData() {
        return data;
    }

    public String setData(String data) {
        this.data = data;
        super.setChanged();
        super.notifyObservers();
    }
}
