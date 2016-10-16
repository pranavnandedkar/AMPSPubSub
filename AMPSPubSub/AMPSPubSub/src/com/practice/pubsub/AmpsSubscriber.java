package com.practice.pubsub;

import com.crankuptheamps.client.Client;
import com.crankuptheamps.client.Client.Bookmarks;
import com.crankuptheamps.client.CommandId;
import com.crankuptheamps.client.Message;
import com.crankuptheamps.client.MessageHandler;
import com.crankuptheamps.client.exception.AMPSException;
import com.crankuptheamps.client.fields.BookmarkField;

public class AmpsSubscriber
{
	public static void main(String[] args) {
		System.out.println("--sub--");
		Client client = new Client("TestSub-Client");
		try {
			client.connect("tcp://vm1:9007/amps/json");
			client.logon();
			MessageHandler messageHandler=null;
			client.bookmarkSubscribe(messageHandler, "messages", "test", CommandId.nextIdentifier(), Bookmarks.NOW, Message.Options.None, 5000);
			for(Message m:client.subscribe("messages")){
				System.out.println("------------>"+m.getData());
			}
//			client.publish("messages", "{ \"message\" : \"Hello, world!\" }");
		}
		catch (AMPSException aex) {
			System.err.println("TestListener caught exception."+aex);
		} finally {
			client.close();
		}
	}
}