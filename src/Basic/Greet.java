package Basic;

public class Greet {
    public static void main(String[] args) {
        String name = "Kunal";
        greet(name);
        System.out.println(name);
    }

    public static void greet(String naam) {
        System.out.println(naam);
        naam = "Rahul";
        System.out.println(naam);
    }
}
