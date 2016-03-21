package com.slgerkamp.retrofit.sample.generic.domain.api.response;

public class Commit {

	public final String url;
	public final String sha;
	public final String html_url;
	public final String comments_url;
	
	public Commit(String url, String sha, String html_url, String comments_url) {
		this.url = url;
		this.sha = sha;
		this.html_url = html_url;
		this.comments_url = comments_url;
	}

}
