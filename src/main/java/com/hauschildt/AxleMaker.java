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
public class AxleMaker implements Runnable {
 
    private final Hopper hopper;
    private int axleCount;
    private final String lineName;
    
    public AxleMaker(Hopper hopper, int axleCount, String lineName) {
        this.hopper = hopper;
        this.axleCount = axleCount;
        this.lineName = lineName;
    }
 
    @Override
    public void run() {
        Axle axle;
        while (axleCount > 0) {
            axleCount--;
            axle = new Axle(lineName, LocalDateTime.now());
            System.out.println("Adding axle: " + axle);
            hopper.addItem(axle);
            try {
                Thread.sleep(500);
            } catch (InterruptedException ie) {
                // ignore for the moment
            }
        }
    }
}
