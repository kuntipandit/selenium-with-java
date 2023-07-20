package Prcatice;

public
class Arrayifclass {
    public static
    void main(String[] args) {
        int[] arr = new int[]{5, 7, 9, 11, 15, 25};
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max)
                max = arr[i];

        }
        // int max = Utilis.findLargestValueinArray(arr);
        System.out.println("Largest number present in given integer:" + max);

    }

}

