package hassanzerouali.ioc.cat.eac3_p1_zerouali_hassan;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import hassanzerouali.ioc.cat.eac3_p1_zerouali_hassan.data.DataUtils;



public class DetailFragment extends Fragment {


    public DataUtils.Recept mRecept;


    public DetailFragment() {
        // Required empty public constructor
    }

    public static DetailFragment newInstance(int selectedRecept) {
        DetailFragment fragment = new DetailFragment();
        Bundle arguments = new Bundle();
        arguments.putInt(DataUtils.RECEPT_ID_KEY, selectedRecept);
        fragment.setArguments(arguments);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments().containsKey(DataUtils.RECEPT_ID_KEY)) {
            // Load the content specified by the fragment arguments.
            mRecept = DataUtils.RECEPT_ITEMS.get(getArguments()
                    .getInt(DataUtils.RECEPT_ID_KEY));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.recept_detail,
                container, false);

        // Show the detail information in a TextView.
        if (mRecept != null) {
            ((TextView) rootView.findViewById(R.id.song_detail))
                    .setText(mRecept.details);
        }

        return rootView;
    }



}
