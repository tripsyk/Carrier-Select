package com.guardian.carrierselect;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class MenuListAdapter extends ArrayAdapter<String> {

	private LayoutInflater inflater;
	private String[] mMenuItems;
	private Context mContext;
	int[] micons;

	public MenuListAdapter(Context ctx, int id, String[] menuItems,
			int[] myicons) {

		super(ctx, id);
		inflater = (LayoutInflater) ctx
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		mMenuItems = menuItems;
		mContext = ctx;
		micons = myicons;
	}

	public int getCount() {
		return mMenuItems.length;
	}

	public View getView(int position, View convertView, ViewGroup parent) {

		ViewHolder holder;

		holder = new ViewHolder();

		if (convertView == null) {
			convertView = inflater.inflate(R.layout.drawer_list_item, null);
			holder.menuTitle = (TextView) convertView
					.findViewById(R.id.menuTitle);

			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		holder.menuTitle
				.setCompoundDrawablesWithIntrinsicBounds(mContext
						.getResources().getDrawable(micons[position]), null,
						null, null);

		holder.menuTitle.setText(mMenuItems[position]);

		return convertView;
	}

	static class ViewHolder {
		TextView menuTitle;
	}

}