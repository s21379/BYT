package com.company;

public class AllUsers implements User{
    Chat chat;
    String name;

    public AllUsers(Chat chat, String name) {
        this.chat = chat;
        this.name = name;
    }


    @Override
    public void sendMessage(String message) {
    chat.sendMessage(message, this);
    }

    @Override
    public void getMessage(String message) {
        System.out.println(this.name + " receiving message: " + message + ".");
    }
}
