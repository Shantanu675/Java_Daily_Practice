package Collection;

public class EnumExample {
    enum Week {
        Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday;
        //these are enum constants
        // public, static and final
        // since it final hence you can create child enums
        // type is Week

        Week() {
            System.out.println("Constructor called...." + this);
        }
        //this is not public or protected, only private or default
        // why? we dont want to create new objects

        // internally : public static final Week Monday = new Week();
    }

    public static void main(String[] args) {
        Week week;
        week = Week.Sunday;

//        for(Week day : Week.values()){
//            System.out.println(day);
//        }
        System.out.println(week.ordinal());
    }
}
