package edu.vassar.cmpu203.myapplication.model;

import java.util.Set;
import java.util.*;

public interface Filter {

    Set<Room> filter(Set<Room> roomList);

}
