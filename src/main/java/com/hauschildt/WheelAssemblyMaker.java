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
public class WheelAssemblyMaker implements Runnable {

    private final Hopper<Wheel> wheelHopper;
    private final Hopper<Axle> axleHopper;
    private final Hopper<WheelAssembly> assemblyHopper;
    private int assemblyCount;
    private final String lineName;

    public WheelAssemblyMaker(Hopper<Wheel> wheelHopper, Hopper<Axle> axleHopper,
            Hopper<WheelAssembly> assemblyHopper, int assemblyCount, String lineName) {
        this.wheelHopper = wheelHopper;
        this.axleHopper = axleHopper;
        this.assemblyHopper = assemblyHopper;
        this.assemblyCount = assemblyCount;
        this.lineName = lineName;
    }

    @Override
    public void run() {
        Axle axle;
        Wheel leftWheel;
        Wheel rightWheel;
        WheelAssembly wheelAssembly;
        boolean needAxle;
        boolean needLeftWheel;
        boolean needRightWheel;
        while (assemblyCount > 0) {
            // clear the variables
            axle = null;
            leftWheel = null;
            rightWheel = null;

            // Get the axle
            needAxle = true;
            while (needAxle) {
                axle = axleHopper.getItem();
                if (null == axle) {
                    System.out.println(
                            "WheelAssemblyMaker "
                            + lineName
                            + " waiting on an axle."
                    );
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                    }
                } else {
                    System.out.println(
                            "WheelAssemblyMaker "
                            + lineName
                            + " got axle."
                    );
                    needAxle = false;
                }
            }

            // Get the leftWheel
            needLeftWheel = true;
            while (needLeftWheel) {
                leftWheel = wheelHopper.getItem();
                if (null == leftWheel) {
                    System.out.println(
                            "WheelAssemblyMaker "
                            + lineName
                            + " waiting on an left wheel."
                    );
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                    }
                } else {
                    System.out.println(
                            "WheelAssemblyMaker "
                            + lineName
                            + " got left wheel."
                    );
                    needLeftWheel = false;
                }
            }

            // Get the rightWheel
            needRightWheel = true;
            while (needRightWheel) {
                rightWheel = wheelHopper.getItem();
                if (null == rightWheel) {
                    System.out.println(
                            "WheelAssemblyMaker "
                            + lineName
                            + " waiting on an right wheel."
                    );
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                    }
                } else {
                    System.out.println(
                            "WheelAssemblyMaker "
                            + lineName
                            + " got right wheel."
                    );
                    needRightWheel = false;
                }
            }

            wheelAssembly = new WheelAssembly(leftWheel, rightWheel, axle, lineName, LocalDateTime.now());
            System.out.println("Adding wheel assembly: " + wheelAssembly);
            assemblyHopper.addItem(wheelAssembly);
            assemblyCount--;
            try {
                Thread.sleep(500);
            } catch (InterruptedException ie) {
                // ignore for the moment
            }
        }
    }

}
