package com.github.williamdlm.camel_simple_examples.model;

public class MyDataType {
    private String data;

    public MyDataType(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "MyDataType{" +
                "data='" + data + '\'' +
                '}';
    }
}
