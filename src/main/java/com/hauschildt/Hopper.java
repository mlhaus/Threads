/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hauschildt;
import java.util.ArrayList;

/**
 *
 * @author k0519415
 */
	
public class Hopper<T> {
 
    private final ArrayList<T> items;
 
    public Hopper() {
        items = new ArrayList<>();
    }
 
    public synchronized ArrayList<T> getList(){
        return items;
    }
 
    public synchronized T getItem(){
        T item = null;
        if(!items.isEmpty()){
            item = items.get(0);
            items.remove(item);
        }
        return item;
    }
 
    public synchronized void addItem(T item){
        items.add(item);
    }
 
    public synchronized boolean isEmpty(){
        return items.isEmpty();
    }
}
