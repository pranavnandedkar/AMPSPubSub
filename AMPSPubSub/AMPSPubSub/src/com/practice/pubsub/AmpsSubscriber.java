package com.practice.pubsub;

import com.crankuptheamps.client.Client;
import com.crankuptheamps.client.Message;
import com.crankuptheamps.client.exception.AMPSException;

public class AmpsSubscriber
{
	public static void main(String[] args) {
		System.out.println("--sub--");
		Client client = new Client("TestSub-Client");
		try {
			client.connect("tcp://192.168.40.135:9007/amps/json");
			client.logon();
			for(Message m:client.subscribe("messages")){
				System.out.println("------------>"+m.getData());
			}
			client.publish("messages", "{ \"message\" : \"Hello, world!\" }");
		}
		catch (AMPSException aex) {
			System.err.println("TestListener caught exception."+aex);
		} finally {
			client.close();
		}
	}
}