package primr.apps.eurakacachet.com.rhyme.view;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import primr.apps.eurakacachet.com.rhyme.model.Artist;
import primr.apps.eurakacachet.com.rhyme.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FavoriteArtistsFragment extends Fragment {

    private ArrayList<Artist> mArtistList;

    public FavoriteArtistsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        mArtistList = new ArrayList<>();
        mArtistList.add(new Artist("Shatta Walle"));
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_favorite_artists, container, false);

        FragmentManager fragmentManager = getChildFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Fragment artistListDisplayFragment = fragmentManager.findFragmentById
                (R.id.favorite_artist_list_display_fragment_container);
        if(artistListDisplayFragment == null){
            artistListDisplayFragment = ArtistListDisplayFragment.newInstance(mArtistList);
            fragmentTransaction.add(R.id.favorite_artist_list_display_fragment_container,
                    artistListDisplayFragment).commit();
        }
        return rootView;
    }


}
