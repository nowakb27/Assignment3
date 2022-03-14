package edu.wctc;

public class Main {

    public static void main(String[] args) {
        String carby = "carby";
        String tomatoey = "tomatoey";
        String cheesy = "cheesy";

        String evens = "evens";
        String primes = "primes";
        String fibonnacis = "fibonnacis";

        edu.wctc.VennDiagram<String> foodDiagram = new edu.wctc.VennDiagram<>(carby, tomatoey, cheesy);
        edu.wctc.VennDiagram<String> numberDiagram = new edu.wctc.VennDiagram<>(evens, primes, fibonnacis);

        foodDiagram.add("Croissant", carby);
        foodDiagram.add("Roll", carby);
        foodDiagram.add("Toast", carby);
        foodDiagram.add("Grilled Cheese", carby, cheesy);
        foodDiagram.add("Mac and Cheese", carby, cheesy);
        foodDiagram.add("Cheese and Crackers", carby, cheesy);
        foodDiagram.add("Bagel and Cream Cheese", carby, cheesy);
        foodDiagram.add("Spaghetti Marinara", carby, tomatoey);
        foodDiagram.add("Tomato Sandwich", carby, tomatoey);
        foodDiagram.add("Lasagna", carby, tomatoey, cheesy);
        foodDiagram.add("Tomato Soup and Goldfish Crackers", carby, tomatoey, cheesy);
        foodDiagram.add("Pizza Margherita", carby, tomatoey, cheesy);
        foodDiagram.add("Tomato and Mozzarella Sandwich", carby, tomatoey, cheesy);
        foodDiagram.add("Tomato Slices", tomatoey);
        foodDiagram.add("Tomato Wedges", tomatoey);
        foodDiagram.add("Grape Tomatoes", tomatoey);
        foodDiagram.add("Caprese Salad", tomatoey, cheesy);
        foodDiagram.add("Greek Salad", tomatoey, cheesy);
        foodDiagram.add("Mozzarella Sticks", cheesy);
        foodDiagram.add("String Cheese", cheesy);
        foodDiagram.add("Cheese Cubes", cheesy);
        foodDiagram.add("Fresh Mozzarella", cheesy);

        // carby OR tomatoey
        System.out.println(foodDiagram.unionOf(carby, tomatoey));
        // tomatoey AND cheesy
        System.out.println(foodDiagram.intersectionOf(tomatoey, cheesy));
        // cheesy but NOT carby
        System.out.println(foodDiagram.complementOf(cheesy, carby));
        // all three
        System.out.println(foodDiagram.diagramCenter());

        numberDiagram.add(String.valueOf(1), primes, fibonnacis);
        numberDiagram.add(String.valueOf(2), evens, primes);
        numberDiagram.add(String.valueOf(3), primes, fibonnacis);
        numberDiagram.add(String.valueOf(4), evens);
        numberDiagram.add(String.valueOf(5), primes, fibonnacis);
        numberDiagram.add(String.valueOf(6), evens);
        numberDiagram.add(String.valueOf(7), primes);
        numberDiagram.add(String.valueOf(8), evens, fibonnacis);
        numberDiagram.add(String.valueOf(9));
        numberDiagram.add(String.valueOf(10), evens);


        System.out.println(numberDiagram.unionOf(primes, evens));
        System.out.println(numberDiagram.intersectionOf(primes, fibonnacis));
        System.out.println(numberDiagram.complementOf(fibonnacis, evens));
        System.out.println(numberDiagram.diagramCenter());
    }
}