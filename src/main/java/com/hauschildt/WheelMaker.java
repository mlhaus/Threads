/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hauschildt;

import java.time.LocalDateTime;

/**
 *
 * @author k0519415
 */
	
public class WheelMaker implements Runnable {
 
    private final Hopper hopper;
    private int wheelCount;
    private final String lineName;
    
    public WheelMaker(Hopper hopper, int wheelCount, String lineName) {
        this.hopper = hopper;
        this.wheelCount = wheelCount;
        this.lineName = lineName;
    }
    
    @Override
    public void run() {
        Wheel wheel;
        while (wheelCount > 0) {
            wheelCount--;
            wheel = new Wheel(lineName, LocalDateTime.now());
            System.out.println("Adding wheel: " + wheel);
            hopper.addItem(wheel);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ie) {
                // ignore for the moment
            }
        }
    }
 
}
