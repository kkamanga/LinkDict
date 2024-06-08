//Kondwani Kamanga, CSC 2720: Data Structures, Lab 11
class Main {
    public static void main(String[] args) {
        testMyHashMap();
    }

    public static void testMyHashMap() {
        MyHashMap map = new MyHashMap();
        map.put("Saskia", 90);
        map.put("Bowser", 80);
        map.put("Wolfgang", 91);
        map.put("Susanne", 100);
        map.put("Luigi", 90);
        map.put("Peter", 100);
        map.put("Trinity", 100);

        System.out.println(map);
        System.out.println(map.get("Bowser") + "\n");

        //Change grade of Trinity:
        map.put("Trinity", 1);
        System.out.println(map);
        System.out.println(map.get("Trinity")+ "\n");

    }
}
