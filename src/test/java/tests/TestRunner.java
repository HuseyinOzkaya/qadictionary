package tests;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import tests.DictionaryTester;
import utilities.ReusableMethods;

public class TestRunner {
    public static void main(String[] args) {
        ReusableMethods reusableMethods = new ReusableMethods();
        Result result = JUnitCore.runClasses(DictionaryTester.class);

        // Print failed tests
        for (Failure failure : result.getFailures()) {
           System.err.println(result.getFailures());
            System.err.println("not english word");
            //System.err.println(failure.toString());

        }

        // Print success tests
        if(result.wasSuccessful()==true)
        System.out.println("Successful: " + result.wasSuccessful() + " ran " + result.getRunCount() + " tests");

    }
}  