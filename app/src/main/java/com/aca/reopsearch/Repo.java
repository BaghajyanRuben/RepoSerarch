package com.aca.reopsearch;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class Repo {

	public long id;

	@SerializedName("node_id")
	public String nodeId;

	public String name;

	@SerializedName("full_name")
	public String fullName;

	@SerializedName("private")
	public boolean isPrivate;

	public Owner owner;

	@SerializedName("html_url")
	public String url;

	public String description;

	@SerializedName("created_at")
	public Date createdAt;

	@SerializedName("updated_at")
	public Date updatedAt;

	@SerializedName("pushed_at")
	public Date pushedAt;

}
