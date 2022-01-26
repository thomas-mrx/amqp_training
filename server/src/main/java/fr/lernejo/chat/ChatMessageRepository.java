package fr.lernejo.chat;

import java.util.ArrayList;
import java.util.List;

public class ChatMessageRepository {
    private static final List<String> messages = new ArrayList<>();

    static void addChatMessage(String message) {
        messages.add(message);
    }

    static List<String> getLastTenMessages(){
        return messages.subList(Math.max(messages.size() - 10, 0), messages.size());
    }
}
