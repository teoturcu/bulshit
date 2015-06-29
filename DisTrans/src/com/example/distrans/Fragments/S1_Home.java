package com.example.distrans.Fragments;


import com.example.distrans.R;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class S1_Home extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View s1_homeView = inflater.inflate(R.layout.s1_home_fragm, container, false);
		Log.d("===LOAD===", "Loaded Home screen");
		return s1_homeView;
	}
	
}
