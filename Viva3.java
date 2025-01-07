package viva.pkg3;

class Vehicle{
    public String vehicleID, type, brand;
    private int rentalRate, fuelLevel, rentalDays, fuelCharge;
    private double totalCost;
    
    //Constructor without any parameters
    public Vehicle (){
        this.vehicleID = "0000";
        this.type = "Car";
        this.brand = "Myvi";
        this.rentalRate = 100;
        this.fuelLevel = 100;
    }
    
    //Constructor with parameters
    public Vehicle (String id, String t, String b, int rate, int fuel){
        this.vehicleID = id;
        this.type = t;
        this.brand = b;
        this.rentalRate = rate;
        this.fuelLevel = fuel;
    }
    
    //Accessor and mutator methods for each instance variables
    public String getVehicleID(){
        return vehicleID;
    }
    public void setVehicleID(String x){
        vehicleID = x;
    }
    
    public String getType(){
        return type;
    }
    public void setType(String x){
        type = x;
    }
    
    public String getBrand(){
        return brand;
    }
    public void setBrand(String x){
        brand = x;
    }
    
    public int getRentalRate(){
        return rentalRate;
    }
    public void setRentalRate(int x){
        rentalRate = x;
    }
    
    public int getFuelLevel(){
        return fuelLevel;
    }
    public void setFuelLevel(int x){
        fuelLevel = x;
    }
    
    //method that calculates and returns rental rate based on vehicle type
    public double calculateRentalRate(){
        if (type.equals("Van"))
            rentalRate *= 1.20;
        else if (type.equals("Motorcycle"))
            rentalRate *= 0.75;
        return rentalRate;
    }
    
    //method to calculate rental cost based on rental duration and rental rate
    public double calculateRentalCost(int input){
        rentalDays = input;
        totalCost = input * rentalRate;
        if(input>=7 && input<=14)
            totalCost *= 0.95;
        else if (input>14)
            totalCost *= 0.10;
        return totalCost;
    }
    
    //method that calculates fuel charge if fuel level is below 50%
    public double calculateFuelCharge(){
        if (fuelLevel<=50)
            fuelCharge = 50;
        else
            fuelCharge = 0;
        return fuelCharge;
    }
    
    //To override the pre-written toString(0 method in the Object class
    @Override
    //method to display all th erental informations and return a string
    public String toString(){
        String x = null;
        x += ("Vehicle ID: " + vehicleID);
        x += ("\nType: " + type);
        x += ("\nBrand: " + brand);
        x += ("\nRental Rate: $" + rentalRate);
        x += ("\nFuel Level: " + fuelLevel + "%");
        x += ("\nRental Days: " + rentalDays);
        x += ("\nTotal Cost: RM" + (totalCost+fuelCharge));
        return x;
    }
}

public class Viva3 {
    public static void main(String[] args) {
        //create a new object from Vehicle class
        Vehicle abc = new Vehicle();
        //change the fuel value manually
        abc.setFuelLevel(50);
        //perform calculations
        abc.calculateRentalRate();
        abc.calculateRentalCost(11);
        abc.calculateFuelCharge();
        //display the rental informations
        System.out.println(abc.toString());
        
        System.out.println("");
        
        //create second object from class Vehicle using another constructor
        Vehicle def = new Vehicle("0011", "Van", "Toyota", 100, 100);
        def.setFuelLevel(50);
        //perform calculations
        def.calculateRentalRate();
        def.calculateRentalCost(14);
        def.calculateFuelCharge();
        //dislay rental infromations
        System.out.println(def.toString());
        
        System.out.println("");
        
        //alter the varibales in vehicle abd
        abc.setType("Van");
        abc.setBrand("Toyota");
        abc.calculateRentalRate();
        abc.calculateRentalCost(2);
        abc.calculateFuelCharge();
        System.out.println(abc.toString());
    }
    
}
