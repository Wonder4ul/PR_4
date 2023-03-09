package com.example.pr_4;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class BlankFragment2 extends Fragment {
    private Context context;
    private final int duration = Toast.LENGTH_SHORT;

    private static final String TAG = "BlankFragment2";
    public BlankFragment2() {
        super(R.layout.fragment_blank2);
    }


    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Random r = new Random();
        int randomNumber = (int)(Math.random()*100000);
        TextView ticket = view.findViewById(R.id.ticket);
        ticket.setText(String.valueOf(randomNumber));

        Button button = view.findViewById(R.id.buttonToList1);
        button.setOnClickListener(v -> {
            Bundle result = new Bundle();
            result.putString("bundleKey", String.valueOf(randomNumber));
            getParentFragmentManager().setFragmentResult("requestKey", result);
                        getParentFragmentManager().beginTransaction().replace(R.id.fragment_container_view,
                                BlankFragment3.class, null)
                                .commit();
        });
        Button button2 = view.findViewById(R.id.buttonToList2);
        button2.setOnClickListener(v -> {
            Bundle result = new Bundle();
            result.putString("bundleKey", String.valueOf(randomNumber));
            getParentFragmentManager().setFragmentResult("requestKey", result);
                        getParentFragmentManager().beginTransaction().replace(R.id.fragment_container_view,
                                BlankFragment4.class, null)
                                .commit();
        });
    }
}