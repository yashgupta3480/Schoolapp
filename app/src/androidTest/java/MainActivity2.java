import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;

public class MainActivity2 extends Activity implements
		ListFragment.OnItemSelectedListener ,ActivityCommunicator{
	String j;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main3);



		Filter.numberofschoolselected = 0;
		Filter.school1 = -1;
		Filter.school2 = -1;
		Filter.name1 = "";
		Filter.name2 = "";
		//MainActivity.actorList.clear();
		Filter.id1 = -1;
		Filter.id2 = -1;


	}

	@Override
	public void passDataToActivity(int filtercolor) {
		FragmentManager manager = getFragmentManager();
		ListFragment f2	=(ListFragment)manager.findFragmentById(R.id.listFragment);
		f2.changeButtonColor(filtercolor);

	}

	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.Apply) {
			Intent i=new Intent(MainActivity2.this,MainActivity2.class);
			i.putExtra("text",j);
			startActivity(i);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	@Override
	public void onRssItemSelected(String link) {
		// TODO Auto-generated method stub
		FragmentManager fragmentManager = getFragmentManager();
		FragmentTransaction fragmentTransaction = fragmentManager
				.beginTransaction();

		Layout1 layout1; // Fragment 1 = city
		Layout2 layout2; // Fragment 2 = facility
		Layout3 layout3; // Fragment 3 = level
		Layout4 layout4; // Fragment 4 = board
		Layout5 layout5; // Fragment 5 = coeducation
		Layout6 layout6; // Fragment 6 = rating

		if (link.equals("layout1")) {
			check();     // whenever new filter option(city,level,facilties) is selected the values are saved using check function
			layout1 = new Layout1();
			fragmentTransaction.replace(R.id.detailFragment, layout1);
			fragmentTransaction.commit();
		} else if (link.equals("layout2")) {
			check();
			layout2 = new Layout2();
			fragmentTransaction.replace(R.id.detailFragment, layout2);
			fragmentTransaction.commit();
		} else if (link.equals("layout3")) {
			check();
			layout3 = new Layout3();
			fragmentTransaction.replace(R.id.detailFragment, layout3);
			fragmentTransaction.commit();
		} else if (link.equals("layout4")) {
			check();
			layout4 = new Layout4();
			fragmentTransaction.replace(R.id.detailFragment, layout4);
			fragmentTransaction.commit();
		} else if (link.equals("layout5")) {
			check();
			layout5 = new Layout5();
			fragmentTransaction.replace(R.id.detailFragment, layout5);
			fragmentTransaction.commit();
		} else if (link.equals("layout6")) {
			check();
			layout6 = new Layout6();
			fragmentTransaction.replace(R.id.detailFragment, layout6);
			fragmentTransaction.commit();
		}


	}

	//this is the same check function used in listfragment to save values when apply button is clicked
	//we need to save the checked options in the various filter option(city,coeducation,facility etc)
	// also when we go from one filter to other therefor we save it here also using the check function


	public void check()
	{


		 if(Filter.filtercolor == 2) {
			FragmentManager manager = getFragmentManager();
			Layout2 layout2 = (Layout2) manager.findFragmentById(R.id.detailFragment);
			 if(layout2 != null ) {
				 View v;
				 CheckBox cbedit;

				 for (int i = 0; i < 5; i++) {


					 v = layout2.list.getChildAt(i);
					 cbedit = (CheckBox) v.findViewById(R.id.checkBox1);
					 if (i == 0 && cbedit.isChecked()) {
						 Filter.AC = true;
					 }
					 else if (i ==0 && !cbedit.isChecked())
					 {
						 Filter.AC = null;
					 }
					 if (i == 1 && cbedit.isChecked()) {
						 Filter.Wifi = true;
					 }
					 else if (i ==1 && !cbedit.isChecked())
					 {
						 Filter.Wifi = null;
					 }
					 if (i == 2 && cbedit.isChecked()) {
						 Filter.EducationalTrips = true;

					 }else if (i ==2 && !cbedit.isChecked())
					 {
						 Filter.EducationalTrips = null;
					 }
					 if (i == 3 && cbedit.isChecked()) {
						 Filter.auditorium = true;
					 }
					 else if (i ==3 && !cbedit.isChecked())
					 {
						 Filter.auditorium = null;
					 }
					 if (i == 4 && cbedit.isChecked()) {
						 Filter.hostel = true;

					 }
					 else if (i ==4 && !cbedit.isChecked())
					 {
						 Filter.hostel = null;
					 }
				 }
			 }
		//	Toast.makeText(getApplicationContext(), "Saving facilities", Toast.LENGTH_SHORT).show();
		}
		else if(Filter.filtercolor == 3) {
			 FragmentManager manager = getFragmentManager();
			 Layout3 layout3 = (Layout3) manager.findFragmentById(R.id.detailFragment);
			 if (layout3 != null) {
				 View v;
				 CheckBox cbedit;
		//		 Toast.makeText(getApplicationContext(), "Saving Level ", Toast.LENGTH_SHORT).show();
				 for (int i = 0; i < 3; i++) {

					 v = layout3.list.getChildAt(i);
					 cbedit = (CheckBox) v.findViewById(R.id.checkBox1);
					 if (i == 0 && cbedit.isChecked()) {
						 Filter.primary = true;
						 Filter.levelAL[0] = "primary";  // we made an array because we have to send values in array in json format.
					 }
					 else if(i == 0 && !cbedit.isChecked())
					 {
						 Filter.primary = false;
						 Filter.levelAL[0] = null;
					 }
					 if (i == 1 && cbedit.isChecked()) {
						 Filter.senior_secondary = true;
						 Filter.levelAL[1] = "senior-secondary";
					 }
					 else if(i == 1 && !cbedit.isChecked()){
						 Filter.senior_secondary = false;
						 Filter.levelAL[1] = null;
					 }
					 if (i == 2 && cbedit.isChecked()) {
						 Filter.play_school = true;
						 Filter.levelAL[2] = "play-school";
					 }
					 else if(i ==2 && !cbedit.isChecked())
					 {
						 Filter.play_school =false;
						 Filter.levelAL[2] = null;

					 }
				 }
			 }
		 }
		else if(Filter.filtercolor == 4) {
			 FragmentManager manager = getFragmentManager();
			 Layout4 layout4 = (Layout4) manager.findFragmentById(R.id.detailFragment);
			 if (layout4 != null) {
				 View v;
				 CheckBox cbedit;
				// Toast.makeText(getApplicationContext(), "Saving Board", Toast.LENGTH_SHORT).show();
				 for (int i = 0; i < 4; i++) {
					 v = layout4.list.getChildAt(i);
					 cbedit = (CheckBox) v.findViewById(R.id.checkBox1);
					 if (i == 0 && cbedit.isChecked()) {
						 Filter.CBSE = true;
						 Filter.boardAL[0] = "CBSE";  // we made an array because we have to send values in array in json format.
					 }
					 else if (i == 0 && !cbedit.isChecked())
					 {
						Filter.CBSE = false;
						  Filter.boardAL[0] =  null;

					 }
					 if (i == 1 && cbedit.isChecked()) {
						 Filter.ICSE = true;
						 Filter.boardAL[1] = "ICSE";
					 }
					 else if(i == 1 && !cbedit.isChecked())
					 {
						 Filter.ICSE = false;
						 Filter.boardAL[1] = null;

					 }
					 if (i == 2 && cbedit.isChecked()) {
						 Filter.IGCSE = true;
						 Filter.boardAL[2] = "IGCSE";
					 }
					 else if(i == 2 && !cbedit.isChecked())
					 {
						 Filter.IGCSE = false;
						 Filter.boardAL[2] = null;
					 }
					 if (i == 3 && cbedit.isChecked()) {
						 Filter.SSC = true;
						 Filter.boardAL[3] = "SSC";
					 }
					 else if(i == 3 && !cbedit.isChecked())
					 {
						 Filter.SSC = false;
						 Filter.boardAL[3] = null;

					 }

				 }
			 }
		 }
		else if(Filter.filtercolor == 5) {
			 FragmentManager manager = getFragmentManager();
			 Layout5 layout5 = (Layout5) manager.findFragmentById(R.id.detailFragment);
			 if (layout5 != null) {
				 View v;
				 CheckBox cbedit;
				// Toast.makeText(getApplicationContext(), "Saving Coeducation", Toast.LENGTH_SHORT).show();
				 for (int i = 0; i < 3; i++) {


					 v = layout5.list.getChildAt(i);
					 cbedit = (CheckBox) v.findViewById(R.id.checkBox1);
					 if (i == 0 && cbedit.isChecked()) {
						 Filter.boys_only = true;
						 Filter.coeducationAL[0] = "1";   // we made an array because we have to send values in array in json format.
					 }
					 else if(i ==0 && !cbedit.isChecked())
					 {
						 Filter.boys_only = false;
						 Filter.coeducationAL[0] = null;
					 }
					 if (i == 1 && cbedit.isChecked()) {
						 Filter.girls_only = true;
						 Filter.coeducationAL[1] = "2";
					 }
					 else if(i == 1 && !cbedit.isChecked())
					 {
						 Filter.girls_only = false;
						 Filter.coeducationAL[1] = null;
					 }
					 if (i == 2 && cbedit.isChecked()) {
						 Filter.coed = true;
						 Filter.coeducationAL[2] = "3";
					 }
					 else if(i == 2 &&! cbedit.isChecked())
					 {
						 Filter.coed = false;
						 Filter.coeducationAL[2] = null;
					 }


				 }

			 }
		 }

		else if(Filter.filtercolor == 6)
		{
			FragmentManager manager = getFragmentManager();
			Layout6 layout6 = (Layout6) manager.findFragmentById(R.id.detailFragment);

			View v;
			CheckBox cbedit;
		//	Toast.makeText(getApplicationContext(), "Rating Submitted", Toast.LENGTH_SHORT).show();
			for(int i = 0 ; i < layout6.list.getCount();i++)
			{


				v = layout6.list.getChildAt(i);
				cbedit = (CheckBox)v.findViewById(R.id.checkBox1);
				if(i==0&&cbedit.isChecked())
				{
					Filter.star_1 = true;
					Filter.ratingAL[0]="1";    // we made an array because we have to send values in array in json format.
				}
				if(i==1&&cbedit.isChecked())
				{
					Filter.star_2 = true;
					Filter.ratingAL[1]="2";
				}
				if(i==2&&cbedit.isChecked())
				{
					Filter.star_3 = true;
					Filter.ratingAL[2]="3";

				}
				if(i==3&&cbedit.isChecked())
				{
					Filter.star_4 = true;
					Filter.ratingAL[3]="4";
				}
				if(i==4&&cbedit.isChecked())
				{
					Filter.star_5 = true;
					Filter.ratingAL[4]="5";
				}

			}
		}
	}



}