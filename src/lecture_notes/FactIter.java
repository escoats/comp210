package lecture_notes;

public class FactIter {
    public static void main(String[] args){
        int k = 5;
        System.out.println("factorial("+k+") = " + fact(k));
    }
    public static double fact(int n) {
        double result = 1;
        for (int i = 1; i <= n; i ++){
            result = result * i;
        }
        return result;
    }
}
