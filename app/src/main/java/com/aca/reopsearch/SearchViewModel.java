package com.aca.reopsearch;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchViewModel extends ViewModel {

	private MutableLiveData<GitResponse> gitResponseMutableLiveData =
			new MutableLiveData<>();
	public LiveData<GitResponse> gitLiveDate =
			gitResponseMutableLiveData;

	public void search(String query){
		RestClient.getInstance()
				.getApiService()
				.searchRepo(query)
				.enqueue(new Callback<GitResponse>() {
					@Override
					public void onResponse(Call<GitResponse> call, Response<GitResponse> response) {
						gitResponseMutableLiveData.setValue(response.body());
					}

					@Override
					public void onFailure(Call<GitResponse> call, Throwable t) {

					}
				});
	}
}
