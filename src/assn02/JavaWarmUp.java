package assn02;
import java.sql.SQLOutput;
import java.util.Scanner;

public class JavaWarmUp {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        String[] categoriesList = {"phone", "laptop", "smart_watch"};

        int n = s.nextInt();
        // Date Time1 Category Fee Quantity Time2 AsmCost
        String date[] = new String[n];
        String time1[] = new String[n];
        String category[] = new String[n];
        double fee[] = new double[n];
        int quantity[] = new int[n];
        double time2[] = new double[n];
        double asmCost[] = new double[n];

        for (int i = 0; i < n; i++) {
            date[i] = s.next();
            time1[i] = s.next();
            category[i] = s.next();
            fee[i] = Double.valueOf(s.next());
            quantity[i] = Integer.valueOf(s.next());
            time2[i] = Double.valueOf(s.next());
            asmCost[i] = Double.valueOf(s.next());
        }

        // Find items with highest and lowest price per unit
        int highestItemIndex = getMaxPriceIndex(fee);
        int lowestItemIndex = getMinPriceIndex(fee);

        // Print information for items with highest and lowest price per unit
        System.out.println(date[highestItemIndex]);
        System.out.println(time1[highestItemIndex]);
        System.out.println(category[highestItemIndex]);
        System.out.println(fee[highestItemIndex]);
        System.out.println(date[lowestItemIndex]);
        System.out.println(time1[lowestItemIndex]);
        System.out.println(category[lowestItemIndex]);
        System.out.println(fee[lowestItemIndex]);

        // Calculate the # of batches, total Fee, total Quantity, total Labor and Assembly costs by category.
        // Maintain following category-wise total stats in the following Category Arrays
        int[] numOfBatchesC = new int[categoriesList.length];// so numOfBatchesC[0] = # of batches in category categoriesList[0]
        double[] totFeeC = new double[categoriesList.length]; // total fee of each category = sum(fee * qty)
        int[] totQuantityC = new int[categoriesList.length];    // total qty of each category = sum (qty)
        double[] totLaborCostC = new double[categoriesList.length]; // total labor cost of each category = sum(time2 x 16)
        double[] totAsmCostC = new double[categoriesList.length]; // total Assembly cost of each category = sum(AsmCost)

        for (int i = 0; i < n; i++) {
            int catIndex = 0;
            for (catIndex = 0; catIndex < categoriesList.length; catIndex++) {
                if (category[i].equals(categoriesList[catIndex])) {
                    numOfBatchesC[catIndex]++;
                    totFeeC[catIndex] += (fee[i] * quantity[i]);
                    totQuantityC[catIndex] += quantity[i];
                    totLaborCostC[catIndex] += (time2[i] * 16);
                    totAsmCostC[catIndex] += asmCost[i];
                }
            }
        }

		// Calculate & Print Category-wise Statistics
        for (int j = 0; j < categoriesList.length; j++) {
            if (numOfBatchesC[j] > 0) {
                double avgAsmFee = totFeeC[j]/totQuantityC[j];
                double avgNetProfit = ((totFeeC[j] - totLaborCostC[j] - totAsmCostC[j]) / totQuantityC[j]); //totQuantityC[j];
                System.out.println(categoriesList[j]);
                System.out.println(totQuantityC[j]);
                System.out.printf("%.2f%n", avgAsmFee);
                System.out.printf("%.2f%n", avgNetProfit);

            }
        }
    }

    // Find index of item with the highest price per unit.
    static int getMaxPriceIndex(double[] priceT){
		// Your code starts here:
        int numFees = priceT.length;
        double maxPrice = priceT[0];
        int maxPriceIndex = 0;
        for (int idx = 0; idx < numFees; idx++) {
            if (priceT[idx] >= maxPrice) {
                maxPrice = priceT[idx];
                maxPriceIndex = idx;
            }
        }
        return(maxPriceIndex);
		// Your code ends here.
    }

    // Find index of item with the lowest price per unit.
    static int getMinPriceIndex(double[] priceT){
		// Your code starts here:
        int numFees = priceT.length;
        double minPrice = priceT[0];
        int minPriceIndex = 0;
        for (int idx = 0; idx < numFees; idx++) {
            if (priceT[idx] <= minPrice) {
                minPrice = priceT[idx];
                minPriceIndex = idx;
            }
        }
        return(minPriceIndex);
    }
}