package org.example.testng;

import io.qameta.allure.Description;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class lab93 {

    @Description  ("TC#1 - Verify Get Request 1")          // This will generate allure report
    @Test
    public void getRequest (){
        System.out.println("TC");
    }

    @Description  ("TC#1 - Verify Get Request 2")
    @Test
    public void getRequest2(){
        System.out.println("TC2");
    }

    @Description  ("TC#1 - Verify Get Request 3")
    @Test
    public void getRequest3(){
        System.out.println("TC3");
    }
}






