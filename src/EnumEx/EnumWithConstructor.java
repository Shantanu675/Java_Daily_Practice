package EnumEx;

enum Laptops{
    MacBook(100000), XPS(80000), Lenovo(64000), Hp(75000);

    private int price;

    Laptops(int price){
        this.price = price;
    }

    public void setPrice(int price){
        this.price = price;
    }

    public int getPrice(){
        return this.price;
    }
}

public class EnumWithConstructor {
    public static void main(String[] args) {
        Laptops lap = Laptops.XPS;
        System.out.println(lap.getPrice());
    }
}
