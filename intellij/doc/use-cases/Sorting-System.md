# Use case name, Sorting-System

## 1. Primary actor and goals
--Students--:- Their goals are to search for a specific room that accompany them the most like how big is that or is it a single or not.

## 2. Preconditions

_-Students searching for a room that they filtered as their most high choose_:
* All rooms that are filtered are available to use.

## 4. Postconditions

* All chosen rooms should show up for -: Sorting-System-:

* Room is available.
* Just the favourite rooms.
* Show the filtered rooms.
* show the most high viewed rooms.


## 4. Workflow


```plantuml
@startuml

skin rose

title Students Searching for a room (casual level)

'define the lanes
|#application|Student|
|#implementation|System Management|

|Student|
start
:user name;
:Home page;
:Choose the house and the sorted room Single, Double, Triplets;
|Student|
if (Single)
elseif (Double)
elseif (Triplets)
elseif (Suite)
endif
:Searching other room 

|System Management|
  :Enter House;
  :Choose the floor;
  :Choose the single or the doubles or any other prefrences;
  
  |Student| 
  : Check the reviews;
  if (Do they like it) is (yes)
  : Favorite room;
  else (No)
 
  endif 
   : Searching other room;
  : Exit the app;
  

stop
@enduml