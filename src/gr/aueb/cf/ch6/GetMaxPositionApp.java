package gr.aueb.cf.ch6;

/**
 * Finds the position of the max num in an array
 *
 * @author Ntirintis John
 */
public class GetMaxPositionApp {
    public static void main(String[] args) {

        //Random arr for testing purposes
        int[] arr = {56, 44 ,2 ,4, 2, 6, 1 ,88, 4 , -5};

        int tmp = getMaxPosition(arr);

        System.out.println(tmp);
    }

    public static int getMaxPosition(int[] arr){
        if (arr == null) return -1;


        int tmp = Integer.MIN_VALUE;
        int pos = 0;

        for(int i = 0; i < arr.length; i++){
            if(arr[i] > tmp){
                tmp = arr[i];
                pos = i;
            }
        }

        return pos;
    }
}
