package com.aca.reopsearch;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RepoAdapter extends RecyclerView.Adapter<RepoViewHolder> {

	private List<Repo> repos;

	public RepoAdapter() {
		repos = new ArrayList<>();
	}

	public void setRepos(List<Repo> repos) {
		this.repos.clear();
		this.repos.addAll(repos);
		notifyDataSetChanged();
	}

	@NonNull
	@Override
	public RepoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.repo_item_layout, parent, false);
		return new RepoViewHolder(view);
	}

	@Override
	public void onBindViewHolder(@NonNull RepoViewHolder holder, int position) {
		holder.bind(repos.get(position));

	}

	@Override
	public int getItemCount() {
		return repos.size();
	}

	public void clear() {
		repos.clear();
		notifyDataSetChanged();
	}
}
