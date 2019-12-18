import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;

//Fragment in which different Filters Like cities,levels,board,coeducation,rating are showing
public class ListFragment extends Fragment implements View.OnClickListener {

	private OnItemSelectedListener listener;
	Button Apply;
	Button button1,button2,button3,button4,button5,button6;
	Drawable d;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.list_fragment, container, false);

		Apply = (Button)view.findViewById(R.id.Apply);

		Apply.setOnClickListener(this);
		d=Apply.getBackground();

		button1 = (Button) view.findViewById(R.id.button1); //city button
		button2 = (Button) view.findViewById(R.id.button2); //facility button
		button3 = (Button) view.findViewById(R.id.button3); //level button
		button4 = (Button) view.findViewById(R.id.button4); // board button
		button5 = (Button) view.findViewById(R.id.button5); // coeducation button
		button6 = (Button) view.findViewById(R.id.button6); // rating button




		button1.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				updateDetail("layout1");



			}
		});

		button2.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				updateDetail("layout2");


			}
		});

		button3.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				updateDetail("layout3");


			}
		});

		button4.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				updateDetail("layout4");

			}
		});

		button5.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				updateDetail("layout5");

			}
		});


		return view;
	}

	@Override
	public void onClick(View view) {
		if(R.id.Apply == view.getId())
		{
			Intent it =new Intent(getActivity(),MainActivity.class);
			check();
			startActivity(it);
		}

	}

// check is a function to check what values are checked(selected values) in filters for the categories like city , facility , coeducation , board and rating
//
	public void check()
	{
		if(Filter.filtercolor==1)
		{
			int radiobuttonId = Layout1.citiesRG.getCheckedRadioButtonId();
			RadioButton radioButton = (RadioButton)Layout1.citiesRG.findViewById(radiobuttonId);
			int index = Layout1.citiesRG.indexOfChild(radioButton);
			Filter.city = radioButton.getText().toString();
			Filter.index = index;
			//Toast.makeText(getActivity(), "index = " + index + "com.example.sony.quote.Filter.city = " + com.example.sony.quote.Filter.city, Toast.LENGTH_SHORT).show();
		}
		if(Filter.filtercolor == 2) {
			FragmentManager manager = getFragmentManager();
			Layout2 layout2 = (Layout2) manager.findFragmentById(R.id.detailFragment);
			View v;
			CheckBox cbedit;
			if(layout2 !=null) {
				for (int i = 0; i < layout2.list.getCount(); i++) {
					v = layout2.list.getChildAt(i);
					cbedit = (CheckBox) v.findViewById(R.id.checkBox1);
					if (i == 0 && cbedit.isChecked()) {
						Filter.AC = true;
					}
					if (i == 1 && cbedit.isChecked()) {
						Filter.Wifi = true;
					}
					if (i == 2 && cbedit.isChecked()) {
						Filter.EducationalTrips = true;
					}
					if (i == 3 && cbedit.isChecked()) {
						Filter.auditorium = true;
					}
					if (i == 4 && cbedit.isChecked()) {
						Filter.hostel = true;
					}
				}
			}
		//	Toast.makeText(getActivity(), "Saving facilities", Toast.LENGTH_SHORT).show();
		}
		else if(Filter.filtercolor == 3) {
			FragmentManager manager = getFragmentManager();
			Layout3 layout3 = (Layout3) manager.findFragmentById(R.id.detailFragment);
			View v;
			CheckBox cbedit;
			//Toast.makeText(getActivity(), "Saving Level ", Toast.LENGTH_SHORT).show();
			if (layout3 != null) {
				for (int i = 0; i < layout3.list.getCount(); i++) {
					v = layout3.list.getChildAt(i);
					cbedit = (CheckBox) v.findViewById(R.id.checkBox1);
					if (i == 0 && cbedit.isChecked()) {
						Filter.primary = true;
					}
					if (i == 1 && cbedit.isChecked()) {
						Filter.senior_secondary = true;
					}
					if (i == 2 && cbedit.isChecked()) {
						Filter.play_school = true;
					}
				}
			}
		}
		else if(Filter.filtercolor == 4) {
			FragmentManager manager = getFragmentManager();
			Layout4 layout4 = (Layout4) manager.findFragmentById(R.id.detailFragment);
			View v;
			CheckBox cbedit;
			//Toast.makeText(getActivity(), "Saving Board", Toast.LENGTH_SHORT).show();
			if (layout4 != null) {
				for (int i = 0; i < layout4.list.getCount(); i++) {
					v = layout4.list.getChildAt(i);
					cbedit = (CheckBox) v.findViewById(R.id.checkBox1);
					if (i == 0 && cbedit.isChecked()) {
						Filter.CBSE = true;
					}
					if (i == 1 && cbedit.isChecked()) {
						Filter.ICSE = true;
					}
					if (i == 2 && cbedit.isChecked()) {
						Filter.IGCSE = true;
					}
					if (i == 3 && cbedit.isChecked()) {
						Filter.SSC = true;
					}
				}
			}
		}
		else if(Filter.filtercolor == 5) {
			FragmentManager manager = getFragmentManager();
			Layout5 layout5 = (Layout5) manager.findFragmentById(R.id.detailFragment);
			View v;
			CheckBox cbedit;
		//	Toast.makeText(getActivity(), "Saving Coeducation", Toast.LENGTH_SHORT).show();
			if (layout5 != null) {
				for (int i = 0; i < layout5.list.getCount(); i++) {
					v = layout5.list.getChildAt(i);
					cbedit = (CheckBox) v.findViewById(R.id.checkBox1);
					if (i == 0 && cbedit.isChecked()) {
						Filter.boys_only = true;
					}
					if (i == 1 && cbedit.isChecked()) {
						Filter.girls_only = true;
					}
					if (i == 2 && cbedit.isChecked()) {
						Filter.coed = true;
					}
				}
			}
		}
		else if(Filter.filtercolor == 6) {
			FragmentManager manager = getFragmentManager();
			Layout6 layout6 = (Layout6) manager.findFragmentById(R.id.detailFragment);
			View v;
			CheckBox cbedit;
			//Toast.makeText(getActivity(), "Rating Submitted", Toast.LENGTH_SHORT).show();
			if (layout6 != null) {
				for (int i = 0; i < layout6.list.getCount(); i++) {
					v = layout6.list.getChildAt(i);
					cbedit = (CheckBox) v.findViewById(R.id.checkBox1);
					if (i == 0 && cbedit.isChecked()) {
						Filter.star_1 = true;
					}
					if (i == 1 && cbedit.isChecked()) {
						Filter.star_2 = true;
					}
					if (i == 2 && cbedit.isChecked()) {
						Filter.star_3 = true;
					}
					if (i == 3 && cbedit.isChecked()) {
						Filter.star_4 = true;
					}
					if (i == 4 && cbedit.isChecked()) {
						Filter.star_5 = true;
					}
				}
			}
		}
	}






	public interface OnItemSelectedListener {
		void onRssItemSelected(String link);
	}

	public void changeButtonColor(int filtercolor)
	{
		if(filtercolor == 1)
		{
			button1.setBackgroundResource(R.drawable.draw_shape);
			button3.setBackgroundDrawable(d);
			button2.setBackgroundDrawable(d);
			button4.setBackgroundDrawable(d);
			button5.setBackgroundDrawable(d);
			button6.setBackgroundDrawable(d);
		}
		else if(filtercolor == 2)
		{
			button2.setBackgroundResource(R.drawable.draw_shape);
			button1.setBackgroundDrawable(d);
			button3.setBackgroundDrawable(d);
			button4.setBackgroundDrawable(d);
			button5.setBackgroundDrawable(d);
			button6.setBackgroundDrawable(d);
		}
		else if(filtercolor == 3)
		{
			button3.setBackgroundResource(R.drawable.draw_shape);
			button1.setBackgroundDrawable(d);
			button2.setBackgroundDrawable(d);
			button4.setBackgroundDrawable(d);
			button5.setBackgroundDrawable(d);
			button6.setBackgroundDrawable(d);
		}
		else if(filtercolor == 4)
		{
			button1.setBackgroundDrawable(d);
			button2.setBackgroundDrawable(d);
			button3.setBackgroundDrawable(d);
			button4.setBackgroundResource(R.drawable.draw_shape);
			button5.setBackgroundDrawable(d);
			button6.setBackgroundDrawable(d);
		}
		else if(filtercolor ==5)
		{
			button1.setBackgroundDrawable(d);
			button2.setBackgroundDrawable(d);
			button3.setBackgroundDrawable(d);
			button4.setBackgroundDrawable(d);
			button5.setBackgroundResource(R.drawable.draw_shape);
			button6.setBackgroundDrawable(d);
		}
		else if(filtercolor ==6)
		{
			button1.setBackgroundDrawable(d);
			button2.setBackgroundDrawable(d);
			button3.setBackgroundDrawable(d);
			button4.setBackgroundDrawable(d);
			button5.setBackgroundDrawable(d);
			button6.setBackgroundResource(R.drawable.draw_shape);
		}

	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		if (activity instanceof OnItemSelectedListener) {
			listener = (OnItemSelectedListener) activity;
		} else {
			throw new ClassCastException(activity.toString()
					+ " must implemenet MyListFragment.OnItemSelectedListener");
		}
	}

	// May also be triggered from the Activity
	public void updateDetail(String s) {

		listener.onRssItemSelected(s);
	}
}
