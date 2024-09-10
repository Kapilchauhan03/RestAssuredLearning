package ex_25062024;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(customlistner.Customlistner.class)
public class lab104 {

    //This class using listeners details


    @Test(groups ="sanity")
    public void test1(){
        System.out.println("test1");
        Assert.assertTrue(false);
    }

    @Test(groups ="sanity")
    public void test2(){
        System.out.println("test2");
        Assert.assertTrue(true);
    }
    @AfterSuite
    public void emailtoQALead(){
        System.out.println("Sending Email");
    }
}
