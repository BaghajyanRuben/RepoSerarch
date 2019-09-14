package com.aca.reopsearch;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {

	@GET("/search/repositories")
	Call<GitResponse> searchRepo(@Query("q") String query);

	@GET("/users/{username}")
	Call<Owner> getUser(@Path("username") String username);

	@GET("users/{username}/repos")
	Call<List<Repo>> getUserRepos(@Path("username") String username);
}
