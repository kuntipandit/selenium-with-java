package Prcatice;

public
class Arrayloop1 {
    public static
    void main(String[] args) {
        int b[] = {2,3,4};
        for (int num: b){
            System.out.println(num);
        }
        int count=20;
        switch (count){
            case 10:
            System.out.println("Discount is 10%");
            break;
            case 20:
                System.out.println("Discount is 20%");
                break;

            default:
                System.out.println("No discount");

        }

    }
}
