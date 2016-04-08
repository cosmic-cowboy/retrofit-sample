package com.slgerkamp.retrofit.sample.generic.domain.api;

import java.util.List;

import com.slgerkamp.retrofit.sample.generic.domain.api.response.Commit;
import com.slgerkamp.retrofit.sample.generic.domain.api.response.Contributor;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * <p>define GitHub API interface</p> 
 *
 */
public interface GitHub {
	
	@GET("/repos/{owner}/{repo}/contributors")
	Call<List<Contributor>> contributors(
		@Path("owner") String owner,
		@Path("repo") String repo);

	@GET("/repos/{owner}/{repo}/commits")
	Call<List<Commit>> commits(
		@Path("owner") String owner,
		@Path("repo") String repo);


}
