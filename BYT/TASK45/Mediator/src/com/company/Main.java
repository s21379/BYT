package com.company;

public class Main {

    public static void main(String[] args) {
        Chat1 Chat = new Chat1();

	User admin = new Admin(Chat, "Admin");
	User user1 = new AllUsers(Chat, "User1");
	User user2 = new AllUsers(Chat, "User2");
	User user3 = new AllUsers(Chat, "User3");

	Chat.setAdmin(admin);
	Chat.addUserToChat(user1);
	Chat.addUserToChat(user2);
	Chat.addUserToChat(user3);

	user1.sendMessage("Hello");
	admin.sendMessage("I am admin");
	user2.sendMessage("I am User");

    }
}
