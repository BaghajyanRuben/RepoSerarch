package com.aca.reopsearch;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

public class SearchFragment extends Fragment {

	private SearchViewModel viewModel;
	private View loadingView;
	private View bottomLoadingView;
	private EditText searchInput;
	private View buttonView;
	private TextView errorText;
	private RecyclerView recyclerView;
	private int spanCount;
	private RepoAdapter adapter;

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		viewModel = ViewModelProviders.of(this).get(SearchViewModel.class);
	}

	@Nullable
	@Override
	public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_search_alyout, container, false);
	}


	@Override
	public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);

		spanCount = getResources().getInteger(R.integer.span_count);

		recyclerView = view.findViewById(R.id.recycler_view);

		adapter = new RepoAdapter();
		recyclerView.setAdapter(adapter);

		recyclerView.setLayoutManager(new StaggeredGridLayoutManager(spanCount,
				StaggeredGridLayoutManager.VERTICAL));

		loadingView = view.findViewById(R.id.loading_view);
		bottomLoadingView = view.findViewById(R.id.load_more_view);
		errorText = view.findViewById(R.id.error_text);

		viewModel.gitLiveDate.observe(this, new Observer<GitResponse>() {
			@Override
			public void onChanged(GitResponse gitResponse) {
				loadingView.setVisibility(View.GONE);
				errorText.setVisibility(gitResponse.items.isEmpty() ? View.VISIBLE : View.GONE);
				adapter.setRepos(gitResponse.items);
				Log.d("GiteRepo", " total " + gitResponse.totalCount + " items " + gitResponse.items.size());
			}
		});

	}

	public void search(String query) {
		loadingView.setVisibility(View.VISIBLE);
		viewModel.search(query);
		adapter.clear();
	}
}
