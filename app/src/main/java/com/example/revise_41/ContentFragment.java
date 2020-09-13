package com.example.revise_41;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ContentFragment extends Fragment {
    private View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.content,container,false);
        return view;
    }
    public void refresh(String title,String content){
        View view1 = view.findViewById(R.id.content_linearLayout);
        view1.setVisibility(View.VISIBLE);
        TextView textView = (TextView)view.findViewById(R.id.content_title);
        TextView textView1 = (TextView)view.findViewById(R.id.content_message);
        textView.setText(title);
        textView1.setText(content);
    }
}
