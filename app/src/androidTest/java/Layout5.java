import android.app.Fragment;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ListView;

import java.util.ArrayList;

//Layot For coeducation in com.example.sony.quote.Filter
public class Layout5 extends Fragment {



	ListView list;


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// TODO Auto-generated method stub

		Filter.filtercolor = 5;
		ActivityCommunicator t = (ActivityCommunicator)getActivity();
		t.passDataToActivity(Filter.filtercolor);
		View view = inflater.inflate(R.layout.layout5, container, false);
		list = (ListView) view.findViewById(R.id.coeducation);



		list.setAdapter(new adapter(this.getActivity()));

		return view;
	}



	class SingleRow {
		String title;


		SingleRow(String title) {
			this.title = title;
		}
	}

	class adapter extends BaseAdapter {
		ArrayList<SingleRow> list;
		Context context;

		//constructer
		adapter(Context c) {
			context = c;
			list = new ArrayList<SingleRow>();
			Resources res = c.getResources();
			String[] titles = res.getStringArray(R.array.rating);
			for (int i = 0; i < 5; i++) {
				list.add(new SingleRow(titles[i]));
			}
		}

		@Override
		public int getCount() {
			return list.size();
		}

		@Override
		public Object getItem(int i) {
			return list.get(i);
		}

		@Override
		public long getItemId(int i) {
			return i;
		}

		@Override
		public View getView(int i, View view, ViewGroup viewGroup) {
			LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			View row = inflater.inflate(R.layout.city, viewGroup, false);


			CheckBox cb1 = (CheckBox) row.findViewById(R.id.checkBox1);

			cb1.setOnClickListener( new View.OnClickListener(){


				@Override
				public void onClick(View view) {
					CheckBox cb = (CheckBox) view;

			//		Toast.makeText(getActivity().getApplicationContext(),
			//				"Clicked on Checkbox: " + cb.getText() +
			//						" is " + cb.isChecked(), Toast.LENGTH_SHORT).show();
				}
			});

			SingleRow temp = list.get(i);

			if(Filter.girls_only!=null&&Filter.girls_only && i ==0)
			{
				cb1.setChecked(true);
			}
			if(Filter.boys_only!=null&&Filter.boys_only&& i == 1)
			{
				cb1.setChecked(true);
			}
			if(Filter.coed!=null&&Filter.coed && i ==2)
			{
				cb1.setChecked(true);
			}

			cb1.setText(temp.title);

			return row;
		}
	}
}