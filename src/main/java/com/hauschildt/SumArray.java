/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hauschildt;

/**
 *
 * @author k0519415
 */
public class SumArray {
    private int sum;
    
    public synchronized int sumArray(int[] nums) {
        sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            System.out.println("Running total for " + Thread.currentThread().getName() + " is " + sum);
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                System.out.println("Thread interruped");
            }
        }
        return sum;
    }
}