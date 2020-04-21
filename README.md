# SER316 Design Patterns Plan


Implement four design patterns together

- Factory pattern for farms
  Requirements Fullfilled by Factory Pattern
  - A world must start with at least 1 farm
  - Farms can be of 3 different types (Hybrid, Animal, Crop)
  - Farms start with up to 6 farmers, more being hired each cycle
  
- Observer to notify different elements of each tick and how they should act accordingly
  - Runs on cycles based on user input
  - Farms automatically upgrade when required currency is obtained
  - New farms are created when a farm reaches greater than 10 population
  - Notifies all farms of day or night rotation, leveling up, gaining farmers, and increasing gold.
  
- Decorator to define currency and product increases dynamically

- Builder will be used to represent the animals throughout the farms
