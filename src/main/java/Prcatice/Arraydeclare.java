package Prcatice;

public
class Arraydeclare {
    public static
    void main(String[] args) {
        int a[]= new int[4]; //here[4] is fix length.if you go beyond 4 length it shows index out of bound in array.

        a[0]= 5;
        a[1]= 7;
        a[2]= 9;
        a[3]=8;

        for(int i=0; i<a.length; i++){ //for catching first index.(forward loop)
            System.out.println(a[i]);
        }
        for (int i= a.length-1; i>=0; i--){  //for catching from last index.(backward loop)
            System.out.println(a[i]);
        }

    }
}
