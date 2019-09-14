package com.aca.reopsearch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.SearchView;

public class MainActivity extends AppCompatActivity {

	private SearchFragment searchFragment;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		searchFragment = (SearchFragment) getSupportFragmentManager().findFragmentById(R.id.search_fragment);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.search_menu, menu);
		final MenuItem searchItem = menu.findItem(R.id.search);
		SearchView searchView = (SearchView) searchItem.getActionView();
		searchView.setQueryHint(getString(R.string.search_title));
		searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

			@Override
			public boolean onQueryTextChange(String newText) {
				Log.e("onQueryTextChange", "called");
				return false;
			}

			@Override
			public boolean onQueryTextSubmit(String query) {
				searchFragment.search(query);
				return false;
			}

		});
		return true;
	}


}
