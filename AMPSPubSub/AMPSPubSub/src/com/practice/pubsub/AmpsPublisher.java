package com.practice.pubsub;

import com.crankuptheamps.client.Client;
import com.crankuptheamps.client.exception.AMPSException;

public class AmpsPublisher
{
	public static void main(String[] args) throws InterruptedException {
		System.out.println("-----");
		Client client = new Client("TestPublisher-Client");
		try {
			client.connect("tcp://vm1:9007/amps/json");
			client.logon();
			for(int i=0;i<999999999;i++){
				Thread.sleep(1000);
				System.out.println(">>>>>>");
				client.publish("messages", "{ \"message\" : \"Hello, world!\" }");
			}
		}
		catch (AMPSException aex) {
			System.err.println("TestListener caught exception."+aex);
		} finally {
			client.close();
		}
	}
} 