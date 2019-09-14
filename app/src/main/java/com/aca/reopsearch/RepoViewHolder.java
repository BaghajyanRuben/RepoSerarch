package com.aca.reopsearch;

import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class RepoViewHolder extends RecyclerView.ViewHolder {
	private TextView repoName;
	private TextView repoFullName;
	private TextView description;
	private ImageView privacy;
	private SimpleDraweeView ownerAvatar;
	private TextView ownerName;
	private TextView createdAt;
	private TextView updatedAt;
	private SimpleDateFormat simpleDateFormat;


	public RepoViewHolder(@NonNull View itemView) {
		super(itemView);

		repoName = itemView.findViewById(R.id.repo_name);
		repoFullName = itemView.findViewById(R.id.repo_full_name);
		description = itemView.findViewById(R.id.des);
		privacy = itemView.findViewById(R.id.iv_privacy);

		ownerAvatar = itemView.findViewById(R.id.avatar);
		ownerName = itemView.findViewById(R.id.owner_name);

		createdAt = itemView.findViewById(R.id.created_at);
		updatedAt = itemView.findViewById(R.id.updated_at);
		simpleDateFormat = new SimpleDateFormat("dd.mm.yyyy HH:MM", Locale.US);
	}


	public void bind(Repo repo) {
		repoFullName.setText(repo.name);
		repoName.setText(repo.fullName);
		description.setText(repo.description);

		privacy.setImageResource(repo.isPrivate ? R.drawable.ic_private : R.drawable.ic_public);

		ownerAvatar.setImageURI(Uri.parse(repo.owner.avatar));
		ownerName.setText(repo.owner.login);

		String created = simpleDateFormat.format(repo.createdAt);
		String updated = simpleDateFormat.format(repo.updatedAt);

		createdAt.setText(String.format(createdAt.getContext().getString(R.string.created_at), created));
		updatedAt.setText(String.format(createdAt.getContext().getString(R.string.updated_at), updated));
	}
}
