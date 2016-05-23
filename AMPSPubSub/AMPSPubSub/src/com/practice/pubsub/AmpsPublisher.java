package com.practice.pubsub;

import com.crankuptheamps.client.Client;
import com.crankuptheamps.client.exception.AMPSException;

public class AmpsPublisher
{
	public static void main(String[] args) {
		System.out.println("-----");
		Client client = new Client("TestPublisher-Client");
		try {
			client.connect("tcp://192.168.40.135:9007/amps/json");
			client.logon();
			client.publish("messages", "{ \"message\" : \"Hello, world!\" }");
		}
		catch (AMPSException aex) {
			System.err.println("TestListener caught exception."+aex);
		} finally {
			client.close();
		}
	}
}