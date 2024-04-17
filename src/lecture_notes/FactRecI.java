package lecture_notes;

public class FactRecI {
    public static void main(String[] args){
        int k = 20;
        System.out.println("factorial("+k+") = " + factorial(k));
    }
    public static double factorial(int n) {
        if (n == 0) {
            return (1);
        }
        else {
            double result = n * factorial(n-1);
            return (result);
        }
    }
}
