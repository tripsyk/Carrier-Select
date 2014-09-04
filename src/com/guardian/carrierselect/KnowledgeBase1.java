package com.guardian.carrierselect;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Animation.AnimationListener;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

public class KnowledgeBase1 extends Fragment {

	private TextView search;
	private EditText searchTerm;
	private static View rootView;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		rootView = inflater.inflate(R.layout.knowledge1, container, false);
		
		getActivity().getActionBar().setTitle("Knowledge Base");
		// Load in animations.
		final Animation righttoleft = AnimationUtils.loadAnimation(rootView.getContext(),
				R.anim.right_to_left);
		final Animation lefttoright = AnimationUtils.loadAnimation(rootView.getContext(),
				R.anim.left_to_right);
		
		search = (TextView) rootView.findViewById(R.id.kbsearchgo);
		searchTerm = (EditText) rootView.findViewById(R.id.searchTerm);

		// Begin startup flow.
		rootView.startAnimation(lefttoright);
		
		search.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View view) {
				
				rootView.startAnimation(righttoleft);

				InputMethodManager imm = (InputMethodManager) rootView
						.getContext().getSystemService(
								Context.INPUT_METHOD_SERVICE);
				imm.hideSoftInputFromWindow(searchTerm.getWindowToken(), 0);

			}
		});
		
		searchTerm.setOnEditorActionListener(new OnEditorActionListener() {
			@Override
			public boolean onEditorAction(TextView v, int actionId,
					KeyEvent event) {
				if (actionId == EditorInfo.IME_ACTION_DONE) {
					// do something
				}
				return false;
			}
		});
		
		righttoleft.setAnimationListener(new AnimationListener() {

			@Override
			public void onAnimationEnd(Animation arg0) {
				final FragmentTransaction fragmenttran = getFragmentManager()
						.beginTransaction();
				fragmenttran.replace(R.id.fragment_container,
						KnowledgeBase2.create(searchTerm.getText().toString()));
				fragmenttran.addToBackStack(null);
				fragmenttran.commit();
				getFragmentManager().executePendingTransactions();

			}

			@Override
			public void onAnimationRepeat(Animation arg0) {
			}

			@Override
			public void onAnimationStart(Animation arg0) {
			}
		});
		
		
		
		return rootView;
	}
}