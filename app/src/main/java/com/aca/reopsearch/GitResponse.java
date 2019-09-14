package com.aca.reopsearch;

import com.google.gson.annotations.SerializedName;

import java.util.List;

class GitResponse {

	@SerializedName("total_count")
	public int totalCount;

	public List<Repo> items;


}
