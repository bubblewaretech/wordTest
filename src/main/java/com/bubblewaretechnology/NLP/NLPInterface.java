package com.bubblewaretechnology.NLP;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import opennlp.tools.postag.POSModel;
import opennlp.tools.postag.POSTaggerME;
import opennlp.tools.sentdetect.SentenceDetectorME;
import opennlp.tools.sentdetect.SentenceModel;
import opennlp.tools.tokenize.Tokenizer;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;

public class NLPInterface {
	
	private static String PATH_FOR_TESTING = "";
	
	//TODO: You can manually edit this path for testing, your en-token.bin and en-sent.bin should be there
	//private static String PATH_FOR_TESTING = "/Users/davidgill/Documents/Lisn/ImportParsePodcasts/src/main/resources/";
	
	public static String[] tokenizeSentence(String sentence){
		InputStream modelIn = null;
		String tokens[] = new String[]{};
		try {
		  modelIn = new FileInputStream(PATH_FOR_TESTING + "en-token.bin");
		  TokenizerModel model = new TokenizerModel(modelIn);
		  Tokenizer tokenizer = new TokenizerME(model);
		  
		  tokens = tokenizer.tokenize(sentence);
		}
		catch (IOException e) {
		  e.printStackTrace();
		}
		finally {
		  if (modelIn != null) {
		    try {
		      modelIn.close();
		    }
		    catch (IOException e) {
		    }
		  }
		}
		
		return tokens;
	}
	

	
	public static String getFirstSentence(String paragraph){
		String[] sentences = getSentences(paragraph);
		if (sentences.length > 0)
			return sentences[0];
		
		return "";
	}
	
	public static String[] getSentences(String paragraph){
		InputStream modelIn = null;
		try {
			modelIn = new FileInputStream(PATH_FOR_TESTING + "en-sent.bin");
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		SentenceModel model = null;
		try {
		  model = new SentenceModel(modelIn);
		}
		catch (IOException e) {
		  e.printStackTrace();
		}
		finally {
		  if (modelIn != null) {
		    try {
		      modelIn.close();
		    }
		    catch (IOException e) {
		    }
		  }
		}
		
		SentenceDetectorME sentenceDetector = new SentenceDetectorME(model);
		String sentences[] = sentenceDetector.sentDetect(paragraph);
		
		return sentences;
	}

}
