package com.aca.reopsearch;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

public class RepoApplication extends Application {

	@Override
	public void onCreate() {
		super.onCreate();
		Fresco.initialize(this);
	}
}
