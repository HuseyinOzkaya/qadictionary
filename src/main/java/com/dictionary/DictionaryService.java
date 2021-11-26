package com.dictionary;

import java.util.List;

public interface DictionaryService {
    List<String> readDictionary();
    boolean isEnglishWord(String word);
}
