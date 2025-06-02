package HashMaps;

public class KarpRabin{
    private final int PRIME = 101;

    public double hashValue(String a){
        double hash = 0;

        for (int i = 0; i < a.length(); i++) {
            hash = hash + a.charAt(i) * Math.pow(PRIME, i);
        }
        return hash;
    }

//    public double updatedHashValue(double prevHash, char oldChar, char newChar, int patternLength){
//        return ((prevHash - oldChar)/PRIME) + (newChar + Math.pow(PRIME, patternLength-1));
//    }

    public double updatedHashValue(double prevHash, char oldChar, char newChar, int patternLength) {
        prevHash -= oldChar;
        prevHash /= PRIME;
        prevHash += newChar * Math.pow(PRIME, patternLength - 1);
        return prevHash;
    }

    public void search(String text, String pattern){
        int textLength = text.length();
        int patternLength = pattern.length();
        double patternHash = hashValue(pattern);
        double stripHash = hashValue(text.substring(0,patternLength));

        for (int i = 0; i <= textLength-patternLength; i++) {
            if(patternHash == stripHash){
                if(pattern.equals(text.substring(i, i+patternLength))){
                    System.out.println("Pattern found at index "+i);
                }
            }
            if(i < textLength - patternLength) {
                stripHash = updatedHashValue(stripHash, text.charAt(i), text.charAt(i + patternLength), patternLength);
            }
        }
    }

    public static void main(String[] args) {
        KarpRabin also = new KarpRabin();
        also.search("aKunalRahul","Kunal");
    }
}
