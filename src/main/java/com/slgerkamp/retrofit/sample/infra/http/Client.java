package com.slgerkamp.retrofit.sample.infra.http;

import java.io.IOException;
import java.util.List;
import java.util.function.Function;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public final class Client {

	/**
	 * @param url
	 * @param service
	 * @param function
	 * @return
	 * @throws IOException
	 */
	public static <T, R> List<R> getClient(
			final String url,
			final Class<T> service, 
			final Function<T, Call<List<R>>> function) throws IOException {
		
		// Create a adapter which points the API.
		Retrofit retrofit = new Retrofit.Builder()
			.baseUrl(url)
			.addConverterFactory(GsonConverterFactory.create())
			.build();
		
		System.out.println(retrofit.toString());
		// Create an instance of API interface.
		T t = retrofit.create(service);
		// Create a call instance for looking up method.
		Call<List<R>> call = function.apply(t);
		// call api
		return call.execute().body();
	}
}
