package edu.vassar.cmpu203.myapplication.model;

import java.util.*;

public class HouseFilter implements Filter {

    House name;


    public HouseFilter(House name){
        this.name = name;
    }
    /*
    public void add
    */

    public ArrayList<Room> filter(ArrayList<Room> roomList){
        ArrayList<Room> filteredList = new ArrayList<Room>();
        for (Room r : roomList) {
            if (this.name == r.getHouse()) {
                filteredList.add(r);
            }
        }
        return filteredList;
    }
}
