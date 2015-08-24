package aoktroop.bduniversity.activity;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import oaktroop.bduniversity.R;



public class PublicFragment extends Fragment {
   private ListView listViewUni;
    private Context context;
    private String[] pubUni={ "Dhaka University",

    };
    public PublicFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
       void initilizationOfViews(View view)
      {
          listViewUni=(ListView)view.findViewById(R.id.list_view_univer);
          ArrayAdapter<String> adapter=new ArrayAdapter<String>(context,android.R.layout.simple_list_item_1,android.R.id.list,pubUni);
         // Adapter adapter=new Adapter (context,android.R.layout.simple_list_item_1,android.R.id.list,pubUni);
          listViewUni.setAdapter(adapter);
      }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_public, container, false);
        //context=container.getContext();
        initilizationOfViews(rootView);
        // Inflate the layout for this fragment
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
