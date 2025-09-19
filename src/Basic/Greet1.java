package Basic;

public class Greet1 {
    public static void main(String[] args) {
        String name = new String("Kunal");
        greet(name);
        System.out.println(name);
    }

    public static void greet(String naam) {
        System.out.println(naam);
        naam.replace('l', 'm');
        System.out.println(naam);
    }
}
