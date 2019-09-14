package com.aca.reopsearch;

import com.google.gson.annotations.SerializedName;

class Owner {

	public String login;

	public long id;

	@SerializedName("node_id")
	public String nodeId;

	@SerializedName("avatar_url")
	public String avatar;

	@SerializedName("html_url")
	public String accountUrl;

}
