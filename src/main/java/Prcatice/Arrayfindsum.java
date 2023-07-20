package Prcatice;

public
class Arrayfindsum {
    public static
    void main(String[] args) {
        int num = 4567;
      int  sum = 0;
      while (num>0){
          sum= sum + num % 10;
         // System.out.println(sum);

          num = num/10;
      }
        System.out.println(sum);
    }
}
