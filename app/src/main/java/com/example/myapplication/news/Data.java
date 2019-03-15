package com.example.myapplication.news;

public class Data {
    private String new_title;
    private String new_content;
    private int new_icon;

    public Data(String new_title, String new_content, int new_icon) {
        this.new_title = new_title;
        this.new_content = new_content;
        this.new_icon = new_icon;
    }

    public Data() {
    }

    public String getNew_title() {
        return new_title;
    }

    public void setNew_title(String new_title) {
        this.new_title = new_title;
    }

    public String getNew_content() {
        return new_content;
    }

    public void setNew_content(String new_content) {
        this.new_content = new_content;
    }

    public int getNew_icon() {
        return new_icon;
    }

    public void setNew_icon(int new_icon) {
        this.new_icon = new_icon;
    }
}
