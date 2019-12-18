import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;


import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.schoolapp.R;

import java.util.ArrayList;

//Fragment for frontpage which is showing multiple cardview
public class CardViewFragment extends Fragment {

    CardView mCardView;
    private RecyclerView mRecyclerView;
    private MyRecyclerViewAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private static String LOG_TAG = "CardViewActivity";
    public static CardViewFragment newInstance() {
        CardViewFragment fragment = new CardViewFragment();
        fragment.setRetainInstance(true);
        return fragment;
    }

    public CardViewFragment() {
        // singleton
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.card_view_main, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new MyRecyclerViewAdapter(getDataSet());


            mRecyclerView.addOnItemTouchListener(
                    (RecyclerView.OnItemTouchListener) new RecyclerItemClickListener(view.getContext(), new RecyclerItemClickListener.OnItemClickListener() {
                        @Override
                        public void onItemClick(View view, int position) {
                            // do whatever
                            if (position == 0) {
                                Intent i = new Intent(view.getContext(), MainActivity.class);

                                startActivity(i);
                            }
                            if (position == 1) {
                                Intent i = new Intent(view.getContext(), MainActivity.class);

                                startActivity(i);
                            }
                            if (position == 2) {
                                Intent i = new Intent(view.getContext(), MainActivity.class);

                                startActivity(i);
                            }
                            if (position == 3) {
                                Intent i = new Intent(view.getContext(), MainActivity.class);

                                startActivity(i);
                            }
                            if (position == 4) {
                                Intent i = new Intent(view.getContext(), MainActivity.class);

                                startActivity(i);
                            }
                        }
                    })
            );


        // Code to Add an item with default animation
        //((MyRecyclerViewAdapter) mAdapter).addItem(obj, index);

        // Code to remove an item with default animation
        //((MyRecyclerViewAdapter) mAdapter).deleteItem(index);
    return view;
    }
    @Override
    public void onResume() {
        super.onResume();
        ((MyRecyclerViewAdapter) mAdapter).setOnItemClickListener(new MyRecyclerViewAdapter
                .MyClickListener() {
            @Override
            public void onItemClick(int position, View v) {
                Log.i(LOG_TAG, " Clicked on Item " + position);
            }
        });
    }

    private ArrayList<DataObject> getDataSet() {
        ArrayList results = new ArrayList<DataObject>();
        for (int index = 0; index < 5; index++) {
            if(index==0) {
                DataObject obj = new DataObject("Top Schools in Delhi",
                        "Secondary " + index);
                results.add(index, obj);
            }

            if(index==1) {
                DataObject obj = new DataObject("Top Schools in Noida",
                        "Secondary " + index);
                results.add(index, obj);
            }

            if(index==2) {
                DataObject obj = new DataObject("Top Schools in Pune",
                        "Secondary " + index);
                results.add(index, obj);
            }

            if(index==3) {
                DataObject obj = new DataObject("Top Schools in Mumbai",
                        "Secondary " + index);
                results.add(index, obj);
            }

            if(index==4) {
                DataObject obj = new DataObject("Top Schools in Ahemdabad",
                        "Secondary " + index);
                results.add(index, obj);
            }
        }
        return results;
    }
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mCardView = (CardView) view.findViewById(R.id.card_view);
    }

}