package com.guardian.carrierselect;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class MenuListAdapter extends ArrayAdapter<String> {

	private LayoutInflater inflater;
	private String[] mMenuItems;
	private int[] mIcon;

	public MenuListAdapter(Context ctx, int id, String[] menuItems, int[] icon) {

		super(ctx, id);
		inflater = (LayoutInflater) ctx
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		this.mMenuItems = menuItems;
		this.mIcon = icon;
	}

	public int getCount() {
		return mMenuItems.length;
	}

	@SuppressLint("InflateParams")
	public View getView(int position, View v, ViewGroup parent) {

		ViewHolder holder = new ViewHolder();

		if (v == null) {
			v = inflater.inflate(R.layout.drawer_list_item, null);
			holder.menuTitle = (TextView) v.findViewById(R.id.menuTitle);
			v.setTag(holder);
		} else {
			holder = (ViewHolder) v.getTag();
		}

		holder.menuTitle.setText(mMenuItems[position]);
		holder.menuTitle.setCompoundDrawablesWithIntrinsicBounds(
				mIcon[position], 0, 0, 0);

		return v;
	}

	static class ViewHolder {
		TextView menuTitle;
		int icon;
	}

}