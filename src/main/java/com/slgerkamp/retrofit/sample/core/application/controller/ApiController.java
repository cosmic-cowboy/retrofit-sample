package com.slgerkamp.retrofit.sample.core.application.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.slgerkamp.retrofit.sample.generic.domain.api.GitHubService;
import com.slgerkamp.retrofit.sample.generic.domain.api.response.Commit;
import com.slgerkamp.retrofit.sample.generic.domain.api.response.Contributor;


@RestController
@RequestMapping("/")
public class ApiController {
	
	@Autowired
	public GitHubService gitHub;
	
	@RequestMapping(value = "contributors")
	public List<Contributor> contributors() throws IOException {
		
		// Fetch and print a list of the contributors to the library.
		List<Contributor> contributors = gitHub.contributors("square", "retrofit");
		return contributors;	    
    
	}
	
	@RequestMapping(value = "commits")
	public List<Commit> commits() throws IOException {
		
		// Fetch and print a list of the commits to the library.
		List<Commit> contributors = gitHub.commits("square", "retrofit");
		return contributors;	    
    
	}

}
