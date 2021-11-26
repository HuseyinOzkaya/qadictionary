

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.dictionary.Dictionary;
import com.dictionary.DictionaryService;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ReusableMethods {
    public Dictionary dictionary;
    public DictionaryService dictService;
    List<String> dictionaryList;


    public String testWord = "work";


    /**
     * Create String list based on the Dictionary file (EnglishWords in this case) to mock the dictionary service
     * @return String list with the dictionary content
     */
    static List<String> createDictionaryArray() {
        List<String> listDictionary = new ArrayList<String>();
        BufferedReader reader;

        try {
            ClassLoader loader = DictionaryTester.class.getClassLoader();
            File file = new File(loader.getResource("EnglishWords").getFile());
            reader = new BufferedReader(new FileReader(file));
            //reader = new BufferedReader(new FileReader("EnglishWords"));
            String line = reader.readLine();
            while (line != null) {
                listDictionary.add(line);
                line = reader.readLine(); // read next line
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listDictionary;
    }


    public void setUp() {
        dictionary = new Dictionary();
        dictService = mock(DictionaryService.class);
        dictionary.setDictionaryService(dictService);
        // I'm adding a mocked dictionary here
        when(dictService.readDictionary()).thenReturn(ReusableMethods.createDictionaryArray());
        dictionaryList = dictService.readDictionary();
    }

    /**
     * Validate if given word exists in the dictionary (EnglishWords in this case) to mock the isEnglishWord function
     * @param word
     * @return boolean based if the word was found in the dictionary
     */
    public boolean isThisEnglish(String word) {
        for (String w : dictionaryList) {
            if (w.equals(word.toLowerCase())) {
                System.out.println(word + " is a valid english word");
                return true;
            }
        }
        return false;
    }
}
