package com.vishalkatgaye.musicplayerblueprint;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


/**
 * Created by ViSh on 20-01-2017.
 */

public class MusicFragment extends Fragment {
    private static final String ARG_TYPE = "pagetype";
    private static final String DESCRIBE = "description";

    private String[] items;
    private TextView textView;
    private ListView listView;

    public static MusicFragment newInstance(int page, String description) {
        Bundle args = new Bundle();
        args.putInt(ARG_TYPE, page);
        args.putString(DESCRIBE, description);
        MusicFragment fragment = new MusicFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_music, container, false);
        Bundle argument = this.getArguments();
        textView = (TextView) view.findViewById(R.id.text_view);
        listView = (ListView) view.findViewById(R.id.list_view);

        if (argument != null) {
            String fragmentDescription = argument.getString(DESCRIBE);
            textView.setText(fragmentDescription);
            int fragmentType = argument.getInt(ARG_TYPE);

            switch (fragmentType) {
                case 1:
                    items = new String[]{"Song 0", "Song 1", "Song 2"};
                    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            Toast.makeText(getContext(), "Playing song! ", Toast.LENGTH_SHORT).show();
                        }
                    });
                    break;

                case 2:
                    items = new String[]{"Artist 0", "Artist 1", "Artist 2"};
                    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            Intent artistIntent = new Intent(getActivity(), ArtistActivity.class);
                            startActivity(artistIntent);
                        }
                    });
                    break;

                case 3:
                    items = new String[]{"Album 0", "Album 1", "Album 2"};
                    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            Intent albumIntent = new Intent(getActivity(), AlbumActivity.class);
                            startActivity(albumIntent);
                        }
                    });
                    break;

                case 4:
                    items = new String[]{"Playlist 0", "Playlist 1", "Playlist 2"};
                    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            Intent playListIntent = new Intent(getActivity(), PlaylistActivity.class);
                            startActivity(playListIntent);
                        }
                    });
                    break;

                default:
                    items = new String[0];
            }

//            ArrayAdaper is used to set string values in ListView.
            ArrayAdapter<String> itemsAdapter = new ArrayAdapter<>(getActivity(), R.layout.layout_text, items);
            listView.setAdapter(itemsAdapter);
        }
        return view;
    }
}
