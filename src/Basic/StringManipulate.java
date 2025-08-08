package Basic;

public class StringManipulate {
    public static void main(String[] args) {
        String sentence = "bgkllmn4 9hhf4  jilv";
        String mod = "9123026996";
        System.out.println(sentence.replaceAll("[\\S]", ""));
    }
}
