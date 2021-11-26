import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {
    public static void main(String[] args) {
        ReusableMethods reusableMethods = new ReusableMethods();
        Result result = JUnitCore.runClasses(DictionaryTester.class);

        // Print failed tests
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
            System.err.println(reusableMethods.testWord + " is not English word");
        }

        // Print success tests
        if(result.wasSuccessful()==true)
        System.out.println("Successful: " + result.wasSuccessful() + " ran " + result.getRunCount() + " tests");

    }
}  