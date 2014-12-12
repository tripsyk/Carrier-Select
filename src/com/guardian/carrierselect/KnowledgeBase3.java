package com.guardian.carrierselect;

import java.util.List;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

public class KnowledgeBase3 extends Fragment {

	private String searchTerm;
	private TextView kbtitle, kbdef, kbdef2, kbex;
	private static View rootView;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		rootView = inflater.inflate(R.layout.knowledge3, container, false);

		kbtitle = (TextView) rootView.findViewById(R.id.kb3search);
		kbdef = (TextView) rootView.findViewById(R.id.kb3def);
		kbdef2 = (TextView) rootView.findViewById(R.id.kb3def2);
		kbex = (TextView) rootView.findViewById(R.id.kb3ex);

		final SharedPreferences sharedPref = getActivity()
				.getSharedPreferences("data", Context.MODE_PRIVATE);
		searchTerm = sharedPref.getString("kb2", "");

		init();

		return rootView;
	}

	private void init() {
		ParseQuery<ParseObject> query = ParseQuery.getQuery("KnowledgeBase");
		query.whereEqualTo("Title", searchTerm);
		query.fromLocalDatastore();
		query.findInBackground(new FindCallback<ParseObject>() {
			public void done(List<ParseObject> KBResult, ParseException e) {

				if (e == null) {
					kbtitle.setText(KBResult.get(0).getString("Title"));
					kbdef.setText("\t\t"
							+ KBResult.get(0).getString("Definition"));
					kbdef2.setText("\n" + "\t\t"
							+ KBResult.get(0).getString("Definition2"));
					kbex.setText("\t\t" + KBResult.get(0).getString("Example"));

				} else {

				}
			}
		});
	}
}