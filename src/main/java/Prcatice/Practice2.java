package Prcatice;

import java.util.concurrent.ThreadLocalRandom;

public
class Practice2 {
    public static
    void main(String[] args) throws InterruptedException {
        int a= ThreadLocalRandom.current().nextInt(1,15);
        System.out.println(a);
        if (a>10){
            System.out.println("Discount given");

        } else if (a>11 & a<15) {
            System.out.println("Flat 1% Discount is given");
        } else {
            System.out.println("Discount not given");
        }

    }
}
