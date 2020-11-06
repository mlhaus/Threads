/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hauschildt;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.SocketTimeoutException;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

/**
 *
 * @author k0519415
 */
public class RequestHandler implements Runnable {

    private Socket socket;

    public RequestHandler(Socket socket) {
        if (null == socket) {
            throw new IllegalArgumentException("Socket cannot be null.");
        }
        this.socket = socket;
    }

    @Override
    public void run() {
        try(
            DataInputStream inputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
        ) {
            InetAddress inetAddress = socket.getInetAddress();
            String clientAddress = inetAddress.getHostAddress();
            System.out.println("Connection from " + clientAddress);
            
            double radius = inputStream.readDouble();
            double area = radius * radius * Math.PI;
            System.out.printf("\tRadius: %10.5f Area: %10.5f\n",
                     radius, area);
                     
            outputStream.writeDouble(area);
            outputStream.flush();
            
        } catch (SocketTimeoutException ste) {
            System.out.println("\tSocket connection timed out: "
                    + ste.getMessage());
        } catch (IOException ioe) {
            System.out.println("\tIO Error: " + ioe.getMessage());
        } catch (Exception ex) {
            System.out.println("\tERROR: " + ex.getMessage());
        }
    }

}