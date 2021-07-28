package com.example.android.assigament_app;

public class ItemModel {
    public String header, subHeader, temp, img, action;
    public String type;

    public ItemModel(String header, String subHeader, String temp, String img, String type, String action) {
        this.header = header;
        this.subHeader = subHeader;
        this.temp = temp;
        this.img = img;
        this.type = type;
        this.action = action;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getSubHeader() {
        return subHeader;
    }

    public void setSubHeader(String subHeader) {
        this.subHeader = subHeader;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}
