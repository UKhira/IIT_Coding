/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.tutorial01messagepassing;

import java.util.logging.Logger;

/**
 *
 * @author Hamed
 */
// Receiver class to receive and process a message
public class Receiver {

    private static final Logger logger = Logger.getLogger(Receiver.class.getName());

    public void receiveMessage(Message message) {
        logger.info("Message received: " + message.getContent());
//        System.out.println("Message received: " + message.getContent());
    }
}