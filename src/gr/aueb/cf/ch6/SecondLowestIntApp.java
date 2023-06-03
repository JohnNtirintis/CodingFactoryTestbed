package gr.aueb.cf.ch6;

/**
 * Using a function it finds and returns the 2nd lowest int in an array
 *
 * @author Ntirintis John
 */
public class SecondLowestIntApp {
    public static void main(String[] args) {

        // Random arr for testing purposes
        int[] arr = {56, 44 ,2 ,4, 2, 6, 1 ,88, 4 , -5};

        int lowest = getSecondLowest(arr);

        System.out.println(lowest);
    }

    /**
     *
     * @param arr   the given array
     * @return      returns the 2nd lowest in that array
     */
    public static int getSecondLowest(int[] arr){
        if (arr == null) return -1;

        int min = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE - 1;
        // We are assigning an int minPos to store the position of the min number,
        // then when we traverse the array for the 2nd time to find the 2nd lowest number, we can use the position
        // to skip the lowest and find the 2nd lowest number.
        int minPos = 0;

        for(int i = 0; i < arr.length; i++){
            if(min > arr[i]){
                min = arr[i];
                minPos = i;
            }
        }

        for(int i = 0; i < arr.length; i++){
            // Checks to see if the given array position is different from the position of the lowest number
            if(i != minPos && secondMin > arr[i]){
                secondMin = arr[i];
            }
        }

        return secondMin;
    }
}
