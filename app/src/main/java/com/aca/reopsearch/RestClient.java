package com.aca.reopsearch;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestClient {

	private static RestClient instance;

	private ApiService apiService;

	private RestClient(){
		init();
	}

	public static RestClient getInstance(){
		if (instance== null){
			instance = new RestClient();
		}
		return instance;
	}

	private void init(){
		Gson gson = new GsonBuilder()
				.setDateFormat("yyyy-MM-dd'T'HH:mm:ss")
				.create();

		Retrofit retrofit = new Retrofit.Builder()
				.baseUrl("https://api.github.com")
				.addConverterFactory(GsonConverterFactory.create(gson))
				.build();

		apiService = retrofit.create(ApiService.class);
	}



	public ApiService getApiService() {
		return apiService;
	}
}
