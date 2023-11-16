package edu.vassar.cmpu203.myapplication.model;

import java.util.Set;
import java.util.*;
import java.util.ArrayList;

public interface Filter {

    ArrayList<Room> filter(ArrayList<Room> roomList);

}
