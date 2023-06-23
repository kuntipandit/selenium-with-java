package org.exampleselenium;

import org.testng.annotations.*;

public
class Testselenium1 {
    @BeforeTest
    public void beforetest(){
        System.out.println("this is before test");
    }
    @Test (priority = 1)
    public void firsttest (){
        int i = 100;
        assert 2<i;
    }
    @AfterMethod
    public void aftermethod(){
        System.out.println("this is after method");
    }
    @Test (priority = 0)
    public void secondtest(){
        int i = 100;
        assert 2<i;
    }
@BeforeMethod
public void beforemethod(){
    System.out.println("this is before method");
}

    @AfterTest
    public void aftertest(){
        System.out.println("this is after test");
    }
}
