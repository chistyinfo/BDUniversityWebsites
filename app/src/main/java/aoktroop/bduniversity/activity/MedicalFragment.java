package aoktroop.bduniversity.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import oaktroop.bduniversity.R;



public class MedicalFragment extends Fragment {
    private ListView listViewUni;
    private Context context;

    String[] uniName ={
            "Dhaka Medical College",
            "Sir Salimullah Medical College",
            "Shaheed Suhrawardy Medical College",
            "Mymensingh Medical College",
            "Chittagong Medical College",
            "Rajshahi Medical College",
            "MAG Osmani Medical College",
            "Sher-e-Bangla Medical College",
            "Rangpur Medical College",
            "Comilla Medical College",
            "Shaheed Ziaur Rahman Medical College ",
            "Dinajpur Medical College",
            "Cox's Bazar Medical College"

    };


    String[] urlStrArray={"http://www.dmc.edu.bd/",
            "http://www.ssmcbd.com/",
            "http://www.shsmc.edu.bd/",
            "http://mmc.gov.bd/",
            "http://cmc.edu.bd/",
            "http://www.rmc.ac.bd/",
            "http://www.magosmanimedical.com/",
            "http://www.sbmc.edu.bd/",
            "http://rangpurmedical.webs.com/",
            "http://www.comc.edu.bd/",
            "http://www.szmcbd.org/",
            "http://www.dinajmc.org/",
            "http://www.coxmc.edu.bd/"

    };

    public MedicalFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_medical, container, false);
        CustomListAdapter adapter = new CustomListAdapter( getActivity()
                ,uniName,null);
        listViewUni=(ListView)rootView.findViewById(R.id.list_view_medical);
        listViewUni.setAdapter(adapter);


        listViewUni.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                Intent intent = new Intent(getActivity(), WebActivity.class);
                intent.putExtra("uniName", uniName[position]);
                intent.putExtra("url", urlStrArray[position]);

                startActivity(intent);


            }
        });
        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
