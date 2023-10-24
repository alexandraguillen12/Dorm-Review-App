# Design

## Design Class Diagram

```plantuml
@startuml

class Room
Room : House
Room : Floor : Integer
Room : RoomType
Room : Availability : Boolean
Room : getHouse() : House
Room : getFloor() : Integer
Room : getType() : RoomType
Room : getAvailability() : Boolean


class RoomLibrary
Room <|-- RoomLibrary
RoomLibrary : rooms : ArrayList<Room>
RoomLibrary : size()

enum House
Room "*" -- "1" House
House : MAIN
House : STRONG
House : RAYMOND
House : DAVISON
House : LATHROP
House : JEWETT
House : JOSSELYN
House : CUSHING
House : NOYES

enum RoomType
Room "*" -- "1" RoomType
RoomType : SINGLE
RoomType : DOUBLE
RoomType : TRIPLE
RoomType : QUAD
RoomType : SUITE
RoomType : TWO_ROOM_DOUBLE
RoomType : TWO_ROOM_TRIPLE

interface Filter
Filter : filter(Set<Room>) : Set<Room>

class HouseFilter
Filter <|.. HouseFilter
HouseFilter : name : House
HouseFilter : filter(Set<Room>) : Set<Room>

@enduml
```

```plantuml
@startuml
Student -> PosUI: Input search criteria 
PosUI --> Filter: House 
PosUI --> Filter: Floor
PosUI --> Filter: RoomType 
PosUI --> Filter: Availability 
Filter --> PosUI: FilteredList 
PosUI --> Student: Display FilteredList 
Student --> PosUI: Press Room 

@enduml
```