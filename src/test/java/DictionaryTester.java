

import static org.mockito.Mockito.when;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;


// @RunWith attaches a runner with the test class to initialize the test data
@RunWith(MockitoJUnitRunner.class)
public class DictionaryTester {
ReusableMethods reusableMethods = new ReusableMethods();

    @Before
    public void setUp() {
        reusableMethods.setUp();
    }


    @Test
    public void validateWorkingWord() {
        when(reusableMethods.dictService.isEnglishWord(reusableMethods.testWord)).thenReturn(reusableMethods.isThisEnglish(reusableMethods.testWord));
        Assert.assertTrue(reusableMethods.dictionary.isEnglishWord(reusableMethods.testWord));
        // Print all possible words
        reusableMethods.dictionary.findPossibleWords(reusableMethods.testWord);
    }
}
