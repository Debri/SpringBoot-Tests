package com.jms.domain;

/**
 * Created by Liuqi
 * Date: 2017/5/17.
 */
public class Email {
    private String receiver;
    private String content;

    public String getContent() {
        return content;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public Email(String receiver, String content) {
        this.receiver = receiver;
        this.content = content;
    }

    public Email() {
    }

    @Override
    public String toString() {
        return "Email{" +
                "receiver='" + receiver + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
