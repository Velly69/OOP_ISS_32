package toy.room;

import toy.room.toys.Toy;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Room {
    private String name = "";
    private List<Toy> toys;
    private Children typeOfRoom;
    private double moneyLimit;

    public Room(String name) {
        this.name = name;
        toys = new ArrayList<>();
        typeOfRoom = Children.DEFAULT;
        moneyLimit = 1000;
    }

    public Room(String name, double moneyLimit, List<Toy> newToys, Children typeOfRoom) {
        this.name = name;
        this.moneyLimit = moneyLimit;
        this.toys = new ArrayList<>();
        if(canAddToysToRoom(newToys)){
            this.toys.addAll(newToys);
        } else {
            System.out.println("You can't add new toys because of money limit.");
        }
        this.typeOfRoom = typeOfRoom;
    }

    private boolean canAddToysToRoom(List<Toy> toys) {
        double wholeSummaOfToys = 0;
        for(Toy toy: toys){
            wholeSummaOfToys += toy.getPrice();
        }
        return wholeSummaOfToys <= this.getMoneyLimit();
    }

    public Room(String name, List<Toy> toys) {
        this.name = name;
        this.toys = new ArrayList<>();
        if(canAddToysToRoom(toys)){
            this.toys.addAll(toys);
        }
    }

    public Room(){
        this.toys = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Toy> getToys() {
        return toys;
    }

    public Children getTypeOfRoom() {
        return typeOfRoom;
    }

    public double getMoneyLimit() {
        return moneyLimit;
    }

    public void setToys(List<Toy> toys) {
        this.toys = toys;
    }

    public void changeTypeOfRoom(Children typeOfRoom) {
        this.typeOfRoom = typeOfRoom;
    }

    public void changeMoneyLimit(double moneyLimit) {
        this.moneyLimit = moneyLimit;
    }

    public void renameRoom(String name){
        this.name = name;
    }

    public void addToy(Toy toy){
        if(calculateCurrentValueOfToys() + toy.getPrice() <= this.getMoneyLimit()){
            toys.add(toy);
            this.moneyLimit += toy.getPrice();
        }
    }

    private double calculateCurrentValueOfToys(){
        double summa = 0;
        for(Toy toy: this.getToys()){
            summa += toy.getPrice();
        }
        return summa;
    }

    public void removeToy(String toyName){
        toys.removeIf(toy -> toyName.equals(toy.getName()));
    }

    public void sortToys(Comparator<Toy> comparator){
        toys.sort(comparator);
    }

    public List<Toy> findToysInPriceInterval(double low, double high){
        List<Toy> result = new ArrayList<>();
        for(Toy toy: toys){
            if(toy.getPrice() >= low && toy.getPrice() <= high){
                result.add(toy);
            }
        }
        return result;
    }
}
