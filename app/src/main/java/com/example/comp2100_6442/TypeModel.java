package com.example.comp2100_6442;

public class TypeModel {
    private String name;
    private int sets;
    private String url;
    
public TypeModel(){
    //for firebase
}
    public TypeModel(String name, int sets, String url) {
        this.name = name;
        this.sets = sets;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSets() {
        return sets;
    }

    public void setSets(int sets) {
        this.sets = sets;
    }

    public String geturl() {
        return url;
    }

    public void seturl(String url) {
        this.url = url;
    }
}
