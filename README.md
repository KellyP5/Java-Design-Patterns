# SER316 Design Patterns Plan

#ScreenCast
https://youtu.be/pfz02icI90Q

- Factory pattern for farms
  Requirements Fullfilled by Factory Pattern
  - A world must start with at least 1 farm
  - Farms can be of 3 different types (Hybrid, Animal, Crop)
  - Farms start with up to 6 farmers, more being hired each cycle
  - Farms only gain money after 24 hours have cycled
  - Farms gain money based their money skill
  
- Observer to notify different elements of each tick and how they should act accordingly
  - Runs on cycles based on user input
  - Farms automatically upgrade when required currency is obtained
  - New farms are created when a farm reaches greater than 10 population
  - Notifies all farms of day or night rotation, leveling up, gaining farmers, and increasing gold.
  
- Strategy Pattern to define the Barn and Crops
  - Crops are harvested every 3 days
  - Predators come out at night and kill animals or crops at a 10% chance
  - Animals breed every 4 cycles if there are two and they aren't killed
  - 10% of money is saved and either spent on animals or crops depending on the farm

