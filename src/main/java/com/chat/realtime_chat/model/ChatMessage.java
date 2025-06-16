package com.chat.realtime_chat.model;
import lombok.*;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChatMessage {
	private String sender;
	private String content;
	private MessageType type;
	
	 public enum MessageType {
	        CHAT,
	        JOIN,
	        LEAVE
	    }

}
