package com.guardian.carrierselect;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MenuListAdapter extends ArrayAdapter<String> {

	private LayoutInflater inflater;
	private String[] mMenuItems;
	private int[] mIcon;

	public MenuListAdapter(Context ctx, int id, String[] menuItems, int[] icon) {

		super(ctx, id);
		inflater = (LayoutInflater) ctx
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		mMenuItems = menuItems;
		this.mIcon = icon;
	}

	public int getCount() {
		return mMenuItems.length;
	}

	@SuppressLint("InflateParams")
	public View getView(int position, View convertView, ViewGroup parent) {

		ViewHolder holder;

		holder = new ViewHolder();

		if (convertView == null) {
			convertView = inflater.inflate(R.layout.drawer_list_item, null);
			holder.icon = (ImageView) convertView.findViewById(R.id.icon);
			holder.menuTitle = (TextView) convertView
					.findViewById(R.id.menuTitle);

			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		holder.menuTitle.setText(mMenuItems[position]);
		holder.icon.setImageResource(mIcon[position]);

		return convertView;
	}

	static class ViewHolder {
		TextView menuTitle;
		ImageView icon;
	}

}