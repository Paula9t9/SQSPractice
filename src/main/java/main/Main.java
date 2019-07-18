package main;

import client.Client;
import publisher.Publisher;

import java.util.Timer;

public class Main {

    public static void main(String [] args){

        // Used Geeks for Geeks to figure out Timer, courtesy of Devon:
        // https://www.geeksforgeeks.org/java-util-timer-class-java/
        Timer timer = new Timer();
        Timer clientTimer = new Timer();
        Long interval = 1000L;
        Long clientInterval = 1L;
        Publisher publisher = new Publisher();
        Client client = new Client();

        timer.schedule(publisher,interval, interval);

        clientTimer.schedule(client,clientInterval, clientInterval);





    }
}
