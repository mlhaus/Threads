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
public class Axle {
    private String source;
    private LocalDateTime createDate;
 
    public Axle(String source, LocalDateTime createDate) {
        this.source = source;
        this.createDate = createDate;
    }
 
    @Override
    public String toString() {
        return "Axle[" + "source=" + source + ", created on: " + createDate + ']';
    }
 
    public String getSource() {
        return source;
    }
 
    public void setSource(String source) {
        this.source = source;
    }
 
    public LocalDateTime getCreateDate() {
        return createDate;
    }
 
    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }
 
}
