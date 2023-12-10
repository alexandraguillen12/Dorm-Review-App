# Design

## Design Class Diagram

```plantuml
@startuml

class Room 
Review <|-- Room
Room : House
Room : Floor : Integer
Room : RoomType
Room : Availability : Boolean
Room : getHouse() : House
Room : getFloor() : Integer
Room : getType() : RoomType
Room : getAvailability() : Boolean

class FireStore 
Filter <|.. HouseFilter
FireStore : name : saveReview
FireStore : filter(Set<Room>) : Set<Room>
Review <|-- FireStore
Ipersistance <|-- FireStore


class RoomLibrary
Room <|-- RoomLibrary
RoomLibrary : rooms : ArrayList<Room>
RoomLibrary : size()

interface Filter
Filter : filter(Set<Room>) : Set<Room>

interface Ipersistance
Ipersistance <|-- Controller

interface ISearchView
ISearchView <|-- Controller
ISearchView <|-- SearchFragment 

interface IRoomSelectionView
IRoomSelectionView <|-- Controller
IRoomSelectionView : onSelectionDone(position)
RoomSelectionFragment <|-- IRoomSelectionView 
RoomSelectionFragment : RoomSelectionFragment(curResults, listener)
RoomSelectionFragment : onViewCreated(view, savedInstanceState)
RoomSelectionFragment : onClick(view, onNewSearch)
MyAdapter <|-- RoomSelectionFragment
MyAdapter : MyAdapter(context, Set<Room> rooms)
MyAdapter : SetOnItemClickListener(OnItemClickListener, listener)
MyAdapter : onBindViewHolder(MyViewHolder holder, position)

MyViewHolder <|-- MyAdapter
MyViewHolder : MyViewHolder(view, itemView)

interface IRoomProfileView
IRoomProfileView <|-- Controller
IRoomProfileView <|-- RoomProfileFragment
PhotoPagerAdapter <|-- RoomProfileFragment

interface IWriteReview 
IWriteReview <|-- Controller
IWriteReview <|-- WriteReviewFragment
ReviewAdapter <|-- WriteReviewFragment

interface IManinView
IManinView <|-- Controller
IManinView : getRootView()
IManinView : displayFragment(fragment, reversible, name)

class HouseFilter
Filter <|.. HouseFilter
HouseFilter : name : House
HouseFilter : filter(Set<Room>) : Set<Room>


class FloorFilter 
FloorFilter <|-- Search 
FloorFilter : FloorFilter(floor)
FloorFilter : filter(ArrayList<Room> roomList) : Set(<filteredList>)
Filter <|.. FloorFilter
RoomTypeFilter <|-- Search
RoomTypeFilter : RoomTypeFilter(type)
RoomTypeFilter : filter(ArrayList<Room> roomList) : (Set<filteredList>)
Filter <|.. RoomTypeFilter
AvailabilityFilter <|-- Search
AvailabilityFilter : AvailabilityFilter(boolean available)
AvailabilityFilter : filter(ArrayList<Room> roomList) : (Set<filteredList>)
Filter <|.. AvailabilityFilter 
HouseFilter <|-- Search

RoomLibrary <|-- Search
Search <|-- Controller
Search : addFilters(name, floor, type, availability)
Search : getFilterCount(filterSet.size)
Search : filter(ArrayList<Room> roomList) : (Set<filteredList>)
Room <|-- Controller
FireStore <|-- Controller

@enduml
```

```plantuml
@startuml
Student -> PosUI: Specify House Name 
Student -> PosUI: Specify Floor
Student -> PosUI: Specify roomType
Student -> PosUI: Specify Availability
PosUI --> Controller: SetSearchCriteria (HouseName) 
create HouseFilter
Controller --> HouseFilter: create 
PosUI --> Controller: setSearchCriteria (FloorNumber)
create FloorFilter 
Controller --> FloorFilter
PosUI --> Controller: setSearchCriteria (roomTypeFilter)
create RoomTypeFilter 
Controller --> RoomTypeFilter 
PosUI --> Controller: setSearchCriteria (Availability)
create AvailabilityFilter 
Controller --> AvailabilityFilter
Controller --> RoomLibrary: Search(filterSet)
RoomLibrary --> RoomLibrary: do search  
RoomLibrary --> Controller: return roomList  
Controller --> PosUI: display(roomList) 
PosUI --> Student: Show results 
Student -> PosUI: View Room 
Student --> PosUI: Press Room 
PosUI --> Controller: selectRoom(id)
PosUI --> Controller: Set Rating marks
create WriteReview
Controller --> WriteReview
Student --> PosUI: WriteReview
Student --> PosUI: Press Button 
PosUI --> Controller: Set Rating marks 
Controller --> RoomLibrary: Choosing the rating value 
PosUI --> Controller: Adding headline
Controller --> RoomLibrary: Writing down the topic
PosUI --> Controller: Adding review 
Controller --> RoomLibrary: Writing down the review 
RoomLibrary --> RoomLibrary: AddReview
RoomLibrary --> Controller: return WriteReview
Controller --> PosUI: display WriteReview
PosUI--> Student: ShowResults
Student --> PosUI: Press Button
PosUI --> Controller: Done with the review
Controller --> RoomLibrary: going back to previous page
RoomLibrary --> RoomLibrary: back
@enduml
```