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
	
public class WheelAssembly {
 
    private Wheel leftWheel;
    private Wheel rightWheel;
    private Axle axle;
    private String source;
    private LocalDateTime createdDate;
    
    public WheelAssembly(Wheel leftWheel, Wheel rightWheel, Axle axle,
             String source, LocalDateTime createdDate) {
        this.leftWheel = leftWheel;
        this.rightWheel = rightWheel;
        this.axle = axle;
        this.source = source;
        this.createdDate = createdDate;
    }
 
    @Override
    public String toString() {
        return "WheelAssembly[" + "source=" + source
                + ", created on " + createdDate + ']';
    }
 
    public Wheel getLeftWheel() {
        return leftWheel;
    }
 
    public void setLeftWheel(Wheel leftWheel) {
        this.leftWheel = leftWheel;
    }
 
    public Wheel getRightWheel() {
        return rightWheel;
    }
 
    public void setRightWheel(Wheel rightWheel) {
        this.rightWheel = rightWheel;
    }
 
    public Axle getAxle() {
        return axle;
    }
 
    public void setAxle(Axle axle) {
        this.axle = axle;
    }
 
    public String getSource() {
        return source;
    }
 
    public void setSource(String source) {
        this.source = source;
    }
 
    public LocalDateTime getCreatedDate() {
        return createdDate;
    }
 
    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }
 
}
