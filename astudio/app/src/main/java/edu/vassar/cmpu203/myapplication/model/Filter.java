package edu.vassar.cmpu203.myapplication.model;

import java.util.Set;
import java.util.*;
import java.util.ArrayList;

/**
 * Interface that defines the methods for a class that filters through a given room list.
 */
public interface Filter {

    ArrayList<Room> filter(ArrayList<Room> roomList);

}
