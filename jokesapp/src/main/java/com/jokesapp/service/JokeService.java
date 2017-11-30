package com.jokesapp.service;

import org.springframework.stereotype.Service;

import guru.springframework.norris.chuck.ChuckNorrisQuotes;

@Service
public class JokeService {

	private ChuckNorrisQuotes chuckNorrisQuotes;
	
	
	
	//public JokeService(ChuckNorrisQuotes chuckNorrisQuotes) {
	//	this.chuckNorrisQuotes = chuckNorrisQuotes;
	//}


	public String getJoke() {
		chuckNorrisQuotes = new ChuckNorrisQuotes();
		return chuckNorrisQuotes.getRandomQuote();
	}
	
	
}
