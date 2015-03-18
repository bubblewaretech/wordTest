package com.bubblewaretechnology.VIN.wordtest;

import com.bubblewaretechnology.NLP.NLPInterface;

/**
 * Sentence parser to split a sentence into words with unique number of characters.
 * Future enhancements could use easily parse multiple sentences and could be switched to initialize NLP only once.
 * 
 * @author davidgill
 *
 */
public class SentenceWordParser {

	public static String sentenceToWordsWithNumbers(String sentence){
        String[] sentenceTokens = NLPInterface.tokenizeSentence(sentence);
        
        for (int j = 0; j < sentenceTokens.length; j++){
        	String numberedWord = shortenWordToContainNumbers(sentenceTokens[j].trim());
        	sentence = sentence.replace(sentenceTokens[j], numberedWord);
        }
        
        return sentence;
	}
	
	private static String shortenWordToContainNumbers(String word){
		if (word.length() < 2)
    	{
    		return word;
    	}

		String shortenedWord = word.substring(1, word.length()-1);
		long wordCountUnique = countUniqueCharacters(shortenedWord);
		
    	String numberedWord = word.charAt(0) + new String().valueOf(wordCountUnique) + word.charAt(word.length()-1);
    	return numberedWord;
	}
	
	public static long countUniqueCharacters(String input) {
	    return input.chars()
	            .distinct()
	            .count();
	}
}
