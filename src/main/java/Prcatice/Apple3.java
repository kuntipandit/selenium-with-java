package Prcatice;

public
class Apple3 {
    int count =2;
    Apple3(){
        count++;
        System.out.println(count);
    }

    public static
    void main(String[] args) {
        Apple3 a1= new Apple3();
        Apple3 a2= new Apple3();
        Apple3 a3= new Apple3();
    }
}
