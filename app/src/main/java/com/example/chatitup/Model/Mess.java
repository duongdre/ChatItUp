package com.example.chatitup.Model;

public class Mess {
    private String fromWho;
    private String toWho;
    private String mess;

    public Mess(String fromWho, String toWho, String mess) {
        this.fromWho = fromWho;
        this.toWho = toWho;
        this.mess = mess;
    }

    public Mess() {
    }

    public String getFromWho() {
        return fromWho;
    }

    public void setFromWho(String fromWho) {
        this.fromWho = fromWho;
    }

    public String getToWho() {
        return toWho;
    }

    public void setToWho(String toWho) {
        this.toWho = toWho;
    }

    public String getMess() {
        return mess;
    }

    public void setMess(String mess) {
        this.mess = mess;
    }
}
