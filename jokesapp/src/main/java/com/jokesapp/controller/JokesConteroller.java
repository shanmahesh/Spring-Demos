package com.jokesapp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.jokesapp.service.JokeService;

@Controller
public class JokesConteroller {

	private JokeService jokeService;
		
	public JokesConteroller(JokeService jokeService) {
		this.jokeService = jokeService;
	}

	@RequestMapping(value= {"/",""})
	public String getJoke(Model model) {
		model.addAttribute("joke",jokeService.getJoke());
		return "chucknorris";
	}
}
