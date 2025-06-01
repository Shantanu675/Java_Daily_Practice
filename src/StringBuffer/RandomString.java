package StringBuffer;

public class RandomString {
    public static void main(String[] args) {
        System.out.println(generate(8));

        String sentence = "Hi h  hjh  hjkso  slowi    w ";
        System.out.println(sentence);
        System.out.println(sentence.replace("\s",""));
    }

    static String generate(int size){
        StringBuffer randStr = new StringBuffer();
        for(int i=0; i < size; i++) {
            char randChar = (char) ((int) (System.nanoTime() % 26) + 97);
            randStr.append(randChar);
        }
        return randStr.toString();
    }
}
