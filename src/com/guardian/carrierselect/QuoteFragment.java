package com.guardian.carrierselect;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

@SuppressLint("ClickableViewAccessibility")
public class QuoteFragment extends Fragment {

	private Handler mHandler;
	private static View rootView;
	private TextView eSmart, eBasic, eData, eTab, eMifi;
	private int discount, temp;
	private View current;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		rootView = inflater.inflate(R.layout.quote_layout, container, false);

		// init animations for '-' and '+'
		final Animation animScale = AnimationUtils.loadAnimation(
				rootView.getContext(), R.anim.scale);
		final Animation animScalet = AnimationUtils.loadAnimation(
				rootView.getContext(), R.anim.scaleinput);

		// init SeekBar and value TV
		final TextView disValue = (TextView) rootView
				.findViewById(R.id.dis_value);
		final SeekBar discBar = (SeekBar) rootView
				.findViewById(R.id.discount_bar);

		// init TVs for retrieving values
		eSmart = (TextView) rootView.findViewById(R.id.sphone_input);
		eBasic = (TextView) rootView.findViewById(R.id.bphone_input);
		eData = (TextView) rootView.findViewById(R.id.data_input);
		eTab = (TextView) rootView.findViewById(R.id.tab_input);
		eMifi = (TextView) rootView.findViewById(R.id.mifi_input);

		// init buttons for - and +
		final Button sphonem = (Button) rootView.findViewById(R.id.sphone_m);
		final Button sphonep = (Button) rootView.findViewById(R.id.sphone_p);
		final Button bphonem = (Button) rootView.findViewById(R.id.bphone_m);
		final Button bphonep = (Button) rootView.findViewById(R.id.bphone_p);
		final Button datam = (Button) rootView.findViewById(R.id.data_m);
		final Button datap = (Button) rootView.findViewById(R.id.data_p);
		final Button tabm = (Button) rootView.findViewById(R.id.tab_m);
		final Button tabp = (Button) rootView.findViewById(R.id.tab_p);
		final Button mifim = (Button) rootView.findViewById(R.id.mifi_m);
		final Button mifip = (Button) rootView.findViewById(R.id.mifi_p);
		final Button send = (Button) rootView.findViewById(R.id.next);

		discBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

			public void onStopTrackingTouch(SeekBar bar) {

			}

			public void onStartTrackingTouch(SeekBar bar) {
			}

			public void onProgressChanged(SeekBar bar, int paramInt,
					boolean paramBoolean) {
				discount = paramInt;
				disValue.setText(paramInt + "%");
			}
		});

		OnTouchListener longAdj = new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				current = v;
				switch (event.getAction()) {
				case MotionEvent.ACTION_DOWN:
					if (mHandler != null)
						return true;
					mHandler = new Handler();
					mHandler.postDelayed(mAction, 200);
					break;
				case MotionEvent.ACTION_UP:
					if (mHandler == null)
						return true;
					mHandler.removeCallbacks(mAction);
					mHandler = null;
					break;
				}
				return false;
			}

			Runnable mAction = new Runnable() {
				@Override
				public void run() {
					switch (current.getId()) {
					case R.id.sphone_p:
						eSmart.setText(String.valueOf(Integer.parseInt(eSmart
								.getText().toString()) + 1));
						eSmart.startAnimation(animScalet);
						break;

					case R.id.bphone_p:
						eBasic.setText(String.valueOf(Integer.parseInt(eBasic
								.getText().toString()) + 1));
						eBasic.startAnimation(animScalet);
						break;

					case R.id.data_p:
						eData.setText(String.valueOf(Integer.parseInt(eData
								.getText().toString()) + 1));
						eData.startAnimation(animScalet);
						break;

					case R.id.tab_p:
						eTab.setText(String.valueOf(Integer.parseInt(eTab
								.getText().toString()) + 1));
						eTab.startAnimation(animScalet);
						break;

					case R.id.mifi_p:
						eMifi.setText(String.valueOf(Integer.parseInt(eMifi
								.getText().toString()) + 1));
						eMifi.startAnimation(animScalet);
						break;
					case R.id.sphone_m:
						temp = Integer.parseInt(eSmart.getText().toString());
						if (temp > 0) {
							eSmart.setText(String.valueOf(temp - 1));
						}
						eSmart.startAnimation(animScalet);
						break;

					case R.id.bphone_m:
						temp = Integer.parseInt(eBasic.getText().toString());
						if (temp > 0) {
							eBasic.setText(String.valueOf(temp - 1));
						}
						eBasic.startAnimation(animScalet);
						break;

					case R.id.data_m:
						temp = Integer.parseInt(eData.getText().toString());
						if (temp > 0) {
							eData.setText(String.valueOf(temp - 1));
						}
						eData.startAnimation(animScalet);
						break;

					case R.id.tab_m:
						temp = Integer.parseInt(eTab.getText().toString());
						if (temp > 0) {
							eTab.setText(String.valueOf(temp - 1));
						}
						eTab.startAnimation(animScalet);
						break;

					case R.id.mifi_m:
						temp = Integer.parseInt(eMifi.getText().toString());
						if (temp > 0) {
							eMifi.setText(String.valueOf(temp - 1));
						}
						eMifi.startAnimation(animScalet);
						break;

					}
					mHandler.postDelayed(this, 200);
				}
			};
		};

		OnClickListener oneAdj = new OnClickListener() {
			@Override
			public void onClick(View v) {

				v.startAnimation(animScale);

				switch (v.getId()) {
				case R.id.sphone_p:
					eSmart.setText(String.valueOf(Integer.parseInt(eSmart
							.getText().toString()) + 1));
					v.startAnimation(animScale);
					eSmart.startAnimation(animScalet);
					break;

				case R.id.bphone_p:
					eBasic.setText(String.valueOf(Integer.parseInt(eBasic
							.getText().toString()) + 1));
					v.startAnimation(animScale);
					eBasic.startAnimation(animScalet);
					break;

				case R.id.data_p:
					eData.setText(String.valueOf(Integer.parseInt(eData
							.getText().toString()) + 1));
					v.startAnimation(animScale);
					eData.startAnimation(animScalet);
					break;

				case R.id.tab_p:
					eTab.setText(String.valueOf(Integer.parseInt(eTab.getText()
							.toString()) + 1));
					v.startAnimation(animScale);
					eTab.startAnimation(animScalet);
					break;

				case R.id.mifi_p:
					eMifi.setText(String.valueOf(Integer.parseInt(eMifi
							.getText().toString()) + 1));
					v.startAnimation(animScale);
					eMifi.startAnimation(animScalet);
					break;

				case R.id.sphone_m:
					temp = Integer.parseInt(eSmart.getText().toString());
					if (temp > 0) {
						eSmart.setText(String.valueOf(temp - 1));
					}
					eSmart.startAnimation(animScalet);
					break;

				case R.id.bphone_m:
					temp = Integer.parseInt(eBasic.getText().toString());
					if (temp > 0) {
						eBasic.setText(String.valueOf(temp - 1));
					}
					eBasic.startAnimation(animScalet);
					break;

				case R.id.data_m:
					temp = Integer.parseInt(eData.getText().toString());
					if (temp > 0) {
						eData.setText(String.valueOf(temp - 1));
					}
					eData.startAnimation(animScalet);
					break;

				case R.id.tab_m:
					temp = Integer.parseInt(eTab.getText().toString());
					if (temp > 0) {
						eTab.setText(String.valueOf(temp - 1));
					}
					eTab.startAnimation(animScalet);
					break;

				case R.id.mifi_m:
					temp = Integer.parseInt(eMifi.getText().toString());
					if (temp > 0) {
						eMifi.setText(String.valueOf(temp - 1));
					}
					eMifi.startAnimation(animScalet);
					break;

				case R.id.next:
					if (Integer.valueOf(eSmart.getText().toString())
							+ Integer.valueOf(eBasic.getText().toString()) == 0) {
						Toast.makeText(rootView.getContext(),
								"You must have at least 1 phone on a plan.",
								Toast.LENGTH_SHORT).show();
					} else
						next();
					break;
				}

			}
		};

		sphonep.setOnTouchListener(longAdj);
		bphonep.setOnTouchListener(longAdj);
		datap.setOnTouchListener(longAdj);
		tabp.setOnTouchListener(longAdj);
		mifip.setOnTouchListener(longAdj);
		sphonep.setOnClickListener(oneAdj);
		bphonep.setOnClickListener(oneAdj);
		datap.setOnClickListener(oneAdj);
		tabp.setOnClickListener(oneAdj);
		mifip.setOnClickListener(oneAdj);
		send.setOnClickListener(oneAdj);

		sphonem.setOnTouchListener(longAdj);
		bphonem.setOnTouchListener(longAdj);
		datam.setOnTouchListener(longAdj);
		tabm.setOnTouchListener(longAdj);
		mifim.setOnTouchListener(longAdj);
		sphonem.setOnClickListener(oneAdj);
		bphonem.setOnClickListener(oneAdj);
		datam.setOnClickListener(oneAdj);
		tabm.setOnClickListener(oneAdj);
		mifim.setOnClickListener(oneAdj);

		return rootView;
	}

	private void next() {

		boolean twoyear;

		// assign twoyear boolean
		final CheckBox checkBox = (CheckBox) rootView
				.findViewById(R.id.twoyear);
		if (checkBox.isChecked()) {
			twoyear = true;
		} else {
			twoyear = true;
		}

		// retrieve final values from user input
		final EditText installet = (EditText) rootView
				.findViewById(R.id.installs);

		double installments;

		if (installet.getText().toString().matches("")) {
			installments = 0;
		} else {
			installments = Double.parseDouble(installet.getText().toString());
		}

		// begin fragment trans
		final FragmentTransaction ft = getActivity()
				.getSupportFragmentManager().beginTransaction();
		ft.setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left,
				R.anim.slide_in_left, R.anim.slide_out_right);
		ft.replace(R.id.fragment_container, DisplayMessageFragment.create(
				twoyear, Integer.parseInt(eSmart.getText().toString()),
				Integer.parseInt(eBasic.getText().toString()),
				Integer.parseInt(eData.getText().toString()),
				Integer.parseInt(eTab.getText().toString()),
				Integer.parseInt(eMifi.getText().toString()), discount,
				installments));
		ft.addToBackStack(null);
		ft.commit();
	}

	public void onDestroy() {
		super.onDestroy();
	}

}
