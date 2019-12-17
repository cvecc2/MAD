package com.example.madburritofinal;

public class FoodShops {
    private String restaurantName;
    private String restaurantURL;

    private void setFoodInfo(Integer foodLocation){
        switch (foodLocation){
            case 0:
                restaurantName ="Illegal Petes";
                restaurantURL ="https://www.illegalpetes.com";
                break;
            case 1:
                restaurantName ="Chipotle";
                restaurantURL ="http://www.chipotle.com";
                break;
            case 2:
                restaurantName ="Bartaco";
                restaurantURL ="https://www.bartaco.com";
                break;
            default:
                restaurantName ="none";
                restaurantURL ="https://www.google.com/search?q=boulder+tacos+burritos&ie=utf-8&oe=utf-8";
        }
    }

    public String getRestaurantName(){
        return restaurantName;
    }

    public String getRestaurantURL(){
        return restaurantURL;
    }

    public void setRestaurantName(Integer foodLocation){
        setFoodInfo(foodLocation);
    }

    public void setRestaurantURL(Integer foodLocation){
        setFoodInfo(foodLocation);
    }

}
