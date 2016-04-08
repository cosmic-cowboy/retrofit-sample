package com.slgerkamp.retrofit.sample.generic.domain.api;

import java.io.IOException;
import java.util.List;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.slgerkamp.retrofit.sample.generic.domain.api.response.Commit;
import com.slgerkamp.retrofit.sample.generic.domain.api.response.Contributor;
import com.slgerkamp.retrofit.sample.infra.http.Client;

import retrofit2.Call;


@Component
public class GitHubService {
	
	@Value("${api.access.url}")
	private String url;
	
	public List<Contributor> contributors(final String owner, final String repo) throws IOException {

		return getClient(t -> t.contributors(owner, repo));
	}

	public List<Commit> commits(final String owner, final String repo) throws IOException {

		return getClient(t -> t.commits(owner, repo));
	}

	private <R> List<R> getClient(final Function<GitHub, Call<List<R>>> function) throws IOException {
	
		return Client.getClient(url, GitHub.class, function);
	}



	

}
