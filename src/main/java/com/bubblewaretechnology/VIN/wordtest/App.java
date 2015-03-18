package com.bubblewaretechnology.VIN.wordtest;


/**
 * Application to parse a sentence and turn it into words with the the first letter the number of unique letters and the last letter.
 * 
 * Build with "mvn clean install" and run with below command:
 * java -cp /path/to/target/directory/wordtest-0.0.1-SNAPSHOT-jar-with-dependencies.jar com.bubblewaretechnology.VIN.wordtest.App
 * 
 * You will need both en-sent.bin and en-token.bin in the target directory to run. These are found in the resources and attached separately in this project.
 * 
 * @author davidgill
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	//Could easily be modified to accept command line parameters by using args[0], however this was not in instructions
    	String sentence = "But how did the origins of language influence action, and can words actually change human behavior, even alter the course of history?";
    	
    	String numberedSentence = SentenceWordParser.sentenceToWordsWithNumbers(sentence);
        
        System.out.println(numberedSentence);
    }
}
