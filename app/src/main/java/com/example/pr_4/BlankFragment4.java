package com.example.pr_4;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class BlankFragment4 extends Fragment {
    private Context context;
    private final int duration = Toast.LENGTH_SHORT;

    private static final String TAG = "BlankFragment4";
    public BlankFragment4() {
        super(R.layout.fragment_blank4);
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_blank4, container, false);
    }


    ArrayList<BookInfo> books = new ArrayList<BookInfo>();

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
            setInitialData();
            RecyclerView recyclerView = view.findViewById(R.id.list);
            BookRecycleAdapter.OnBookClickListener bookClickListener = new BookRecycleAdapter.OnBookClickListener() {
                @Override
                public void onBookClick(BookInfo state, int position) {

                    Toast.makeText(getContext(), "Был выбран пункт " + state.getName(),
                            Toast.LENGTH_SHORT).show();
                    Log.i("TAG", "Был выбран пункт: " + state.getName());
                }
            };
            BookRecycleAdapter adapter = new BookRecycleAdapter(getContext(), books, bookClickListener);
            recyclerView.setAdapter(adapter);
        }


    private void setInitialData(){
        for(int i=1; i<=200;i++){
            books.add(new BookInfo (String.valueOf(i), R.drawable.book_svgrepo_com));
        }

    }




}
