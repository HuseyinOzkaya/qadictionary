package tests;

import static org.mockito.Mockito.when;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import utilities.ConfigReader;
import utilities.ReusableMethods;


// @RunWith attaches a runner with the test class to initialize the test data
@RunWith(DataProviderRunner.class)

public class DictionaryTester {
ReusableMethods reusableMethods = new ReusableMethods();

    @Before
    public void setUp() {
        reusableMethods.setUp();
    }


    @Test
    public void validateWord() {
        when(reusableMethods.dictService.isEnglishWord(reusableMethods.testWord)).thenReturn(reusableMethods.isThisEnglish(reusableMethods.testWord));
        Assert.assertTrue(reusableMethods.dictionary.isEnglishWord(reusableMethods.testWord));
        // Print all possible words
        reusableMethods.dictionary.findPossibleWords(reusableMethods.testWord);
    }


    @DataProvider
    public static Object[][] groupOfTestWords() {
        return ReusableMethods.testData() ;
    }

    @Test
    @UseDataProvider("groupOfTestWords")
    public void validateWords(String testWord){
        when(reusableMethods.dictService.isEnglishWord(testWord)).thenReturn(reusableMethods.isThisEnglish(testWord));
        Assert.assertTrue(reusableMethods.dictionary.isEnglishWord(testWord));
        // Print all possible words
        reusableMethods.dictionary.findPossibleWords(testWord);

    }

}
