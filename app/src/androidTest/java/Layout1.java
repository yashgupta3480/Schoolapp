import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

//Layout for cities in com.example.sony.quote.Filter
public class Layout1 extends Fragment  {
static int checkcityfetcheddata=1;
	int x = 0;
static	RadioGroup citiesRG;
	ListView list;



	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

		//com.example.sony.quote.Filter.filtercolor =1  means first layout i.e. the filter for cities is selected.
		Filter.filtercolor = 1;
		View view = inflater.inflate(R.layout.main, container, false);



		ActivityCommunicator t = (ActivityCommunicator) getActivity();
		t.passDataToActivity(Filter.filtercolor);

		//com.example.sony.quote.Filter.flag = 0 means when the app opens only once the post request is made, after that the same data is used.
		if(Filter.flag == 0 ) {
			Filter.cities.add("Quotes");

			Filter.flag = 1; //Flag value updated after the first post request
		}


		//dynamic radio group and radio buttons for city
		citiesRG = (RadioGroup)view.findViewById(R.id.citiesRG);
		RadioButton button;
		for(Integer  i= 0 ; i <Filter.cities.size();i++ )
		{
			button = new RadioButton(this.getActivity());
			button.setText(Filter.cities.get(i));
			button.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {

				}
			});
			citiesRG.addView(button);
			if(Filter.index == i )
			{
				button.setChecked(true);
			}

		}





		// TODO Auto-generated method stub




		return view;
	}


}
