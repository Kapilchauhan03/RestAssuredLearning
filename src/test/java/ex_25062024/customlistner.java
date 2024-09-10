package ex_25062024;

import org.testng.IExecutionListener;
import org.testng.ISuiteListener;

public class customlistner {

    public class Customlistner implements IExecutionListener, ISuiteListener{

        @Override
        public void onExecutionStart() {
            System.out.println("onExecutionstart");
        }

        @Override
        public void onExecutionFinish() {
            System.out.println("onExecutionFinish");
        }
    }
}
