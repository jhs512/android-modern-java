package com.example.sbs.myapplication.dto;

public class ResultData<BodyType> {
    public String resultCode;
    public String msg;
    public BodyType body;

    public boolean isSuccess() {
        return resultCode.startsWith("S-");
    }

    public boolean isFail() {
        return !isSuccess();
    }
}
