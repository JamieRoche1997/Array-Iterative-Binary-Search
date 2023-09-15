import java.util.Random;
import java.util.Arrays;
import java.util.Scanner;

/**
 * This class performs a binary search on an array of 20 random integers in the 
 * range 1 to 100 to discover whether or not it contains an integer input from
 * the keyboard.
 *
 * @author Jing Hua Ye
 * @date Nov/6/2021
 * @version 1.0
 */
 class BinarySearchTest {
     public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random generator = new Random();

        //Task: create an array of 20 random integers between 1 to 100
         int[] anArray = generator.ints(20, 1, 100).toArray();

        //to-complete

        //Task: which method should be used in Arrays class to make sure data in a sorted 
        //order
         Arrays.sort(anArray);
        //to-complete
                
        //Task: display array as below: for example [-1, 10, 40, 30]
        //Hint: use the Arrays class, which method should we use to output data in a such 
        //format?
         System.out.println(Arrays.toString(anArray));
        //to-complete
        
        //Task: repeatedly input an integer from user: -1 terminates the program
         int searchKey = 0;
         while (true) {
             System.out.println("Please enter an integer value (-1 to quit): ");
             searchKey = input.nextInt();
             if (searchKey == -1)
                 break;
             System.out.printf("%d exists at index %d", searchKey, binarySearch(anArray, searchKey));
             System.out.println();
         }
        //after reading an input of search key, we perform a binary search on 
        //data with this search key. Finally print out the result of the binary search as the
        //sample outputs provided in the task specification
         //printPass(anArray, searchKey, searchKey);
        //to-complete
     }
/* =============================================================================
                           HELPER METHODS 
   =============================================================================
 */

    private static void printPass(int[] data, int pass, int index)
    {   System.out.printf("after pass%2d: ", pass);

        for (int i = 0; i < index; i++)
            System.out.printf("%d ", data[i]);

        System.out.printf("%d* ", data[index]);

        for (int i = index + 1; i < data.length; i++)
            System.out.printf("%d ", data[i]);

        //for alignment
        System.out.printf("%n               ");

        System.out.println();
    }
/**
 * To perform a binary search on an array of data
 *
 * @param data a static array of integers
 * @param searchKey the search key of performing the search
 * @return -1 if the searchKey is not found in the data, otherwise the position 
 * of the searchKey in the data
 */
 private static int binarySearch(int[] data, int searchKey)
 {
     int low = 0;
     int high = data.length-1;
     int i = 0;

     while (low<=high) {

         int mid = (low + high) / 2;
         if(data[mid] == searchKey){
             i++;
             printPass(data, i, mid);
             return mid;
         } if (data[mid] < searchKey) {
            low = mid+1;
         }else{
             high = mid-1;
         }
         i++;
         printPass(data, i, mid);
     }
     //to-complete

     return -1;
 }
  
  //you may need to consider to define some other helper methods to format the final outputs

/* ============================================================================
                            CLASS VARIABLES
   ============================================================================
 */
     //the maximum size of the static array
     private static final int MAX_SIZE = 20; 
}
