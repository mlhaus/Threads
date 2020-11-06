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
	
	
public class MyThread implements Runnable {
    public Thread thread;
    public static SumArray sa = new SumArray();
    int[] a;
    int answer;
    
    public MyThread(String name, int[] nums) {
        thread = new Thread(this, name);
        a = nums;
    }
    
    public static MyThread createAndStart(String name, int[] nums) {
        MyThread mt = new MyThread(name, nums);
        mt.thread.start();
        return mt;
    }
    
    @Override
    public void run() {
        int sum;
        System.out.println(thread.getName() + " thread starting with priority: " + thread.getPriority() + ".");
        answer = sa.sumArray(a);
        System.out.println("Sum for " + thread.getName() + " is " + answer);
        System.out.println(thread.getName() + " thread ending");
    }
}
