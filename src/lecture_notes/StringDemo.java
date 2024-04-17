package lecture_notes;

public class StringDemo {
    public static void main(String[] args){
        String s1 = "Hello";
        String s2 = "bye";
        String s3 = "Hello";
        String s4 = s1.toLowerCase();
        System.out.println(s1.length());
        System.out.println(s1.charAt(1));
        System.out.println(s1.substring(1));
        System.out.println(s1.toLowerCase());
        if (s1.equals(s3)) {
            System.out.println("String contents are the same");
        } else {
            System.out.println("String contents not the same");
        }
        if (s1 == s3) {
            System.out.println("Strings are the same object");
        } else {
            System.out.println("Strings are not the same object");
        }
    }
}
