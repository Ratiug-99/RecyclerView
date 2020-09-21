package com.ratiug.dev.courrsera_recyclerview;

public class MessageRowType implements RowType {
    private String mUserName, mMessageText;

    public MessageRowType(String username, String message){
        this.mUserName = username;
        this.mMessageText = message;
    }

    public String getMessageText() {
        return mMessageText;
    }

    public String getUsername() {
        return mUserName;
    }
}
