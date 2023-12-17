class FoodRatings {
    
    Map<String, PriorityQueue<Food>> cuisinesMap;
    Map<String, Food> foodMap;

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        cuisinesMap = new HashMap<>();
        foodMap = new HashMap<>();
        
        for(int i = 0; i < foods.length; i++){
            String food = foods[i];
            String cuisine = cuisines[i];
            int rating = ratings[i];
            
            Food foodObj = new Food(food, rating, cuisine);
            if(!cuisinesMap.containsKey(cuisine)){
                PriorityQueue<Food> pq = new PriorityQueue<>((a, b) -> a.rate == b.rate ? a.name.compareTo(b.name) : b.rate - a.rate);
                cuisinesMap.put(cuisine, pq);
            }
            
            cuisinesMap.get(cuisine).offer(foodObj);
            foodMap.put(food, foodObj);
        }
    }
    
    public void changeRating(String food, int newRating) {
        Food foodObj = foodMap.get(food);
        foodObj.rate = newRating;
        PriorityQueue<Food> pq = cuisinesMap.get(foodObj.cuisine);
        pq.remove(foodObj);
        pq.offer(foodObj);
    }
    
    public String highestRated(String cuisine) {
        PriorityQueue<Food> pq = cuisinesMap.get(cuisine);
        return pq.peek().name;
    }
    
    class Food{
        String name;
        int rate;
        String cuisine;
        
        Food(String n, int r, String c){
            this.name = n;
            this.rate = r;
            this.cuisine = c;
        }
    }
}