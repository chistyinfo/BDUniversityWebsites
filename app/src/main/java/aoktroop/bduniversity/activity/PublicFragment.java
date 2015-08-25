package aoktroop.bduniversity.activity;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import oaktroop.bduniversity.R;



public class PublicFragment extends Fragment {
   private ListView listViewUni;
    private Context context;

    String[] itemname ={
            "NorthSouth University",
            "Indepent University",

    };
//
//    Integer[] imgid= {
//            R.drawable.pic1,
//            R.drawable.pic2,
//    };

    String[] urlStrArray={"http://www.northsouth.edu/",
            "http://www.iub.edu.bd/",

    };
    public PublicFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_public, container, false);
        CustomListAdapter adapter = new CustomListAdapter( getActivity()
                ,itemname,null);
        listViewUni=(ListView)rootView.findViewById(R.id.list_view_univer);
        listViewUni.setAdapter(adapter);


        listViewUni.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                String Slecteditem = itemname[+position];
                Intent intent = new Intent(getActivity(), WebActivity.class);
                intent.putExtra("url", urlStrArray[position]);
                startActivity(intent);


            }
        });
        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        context=activity;
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
