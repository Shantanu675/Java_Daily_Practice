package Basic;

import java.util.Date;

public class PrettyPrinting {
    public static void main(String[] args) {
        float a = 12.82929f;
        System.out.printf("%.2f\n",a);
        System.out.println(Math.PI);
        System.out.printf("Hello My name is %s\n", "Shantanu");
        System.out.printf("First letter in English Alphabet is %c\n", 'A');
        System.out.printf("exponential form is %e\n", 2.755);
        System.out.printf("octal form is %o\n", 231339);
        System.out.printf("hexadecimal form is %x\n", 231339);
        System.out.printf("decimal form is %d\n", 231339);
//        System.out.printf("hexadecimal form is %i\n", 8);
        System.out.printf("boolean form is %b\n", (Object) null);
        System.out.printf("boolean form is %b\n", 0);
        System.out.printf("boolean form is %b%n", -1);


        Date now = new Date(); // Get the current date and time

        // Format and print various date/time components
        System.out.printf("Current time: %tH:%tM:%tS%n", now, now, now); // Hour:Minute:Second
        System.out.printf("Current date: %tA, %tB %td, %tY%n", now, now, now, now); // Day of week, Month Day, Year
        System.out.printf("Full date and time: %tc%n", now); // Complete date and time

//        System.out.printf("This is unsigned number %u");

    }
}
