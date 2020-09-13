package com.example.revise_41;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class TitleFragment extends Fragment {
    private boolean isTwoPane;
    private List<News> list = new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.title,container,false);
        addlist();
        RecyclerView recyclerView = (RecyclerView)view.findViewById(R.id.title_recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        MyAdapt adapt = new MyAdapt(list);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapt);
        return view;
    }

    private void addlist() {
        for(int i = 1; i < 50; i++){
            String title = "这是第"+i+"个新闻";
            String message = title + title + title + title +title+title+"";
            News news = new News(title,message);
            list.add(news);
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if(getActivity().findViewById(R.id.content_FrameLayout)!=null){
            isTwoPane = true;
        }
        else
            isTwoPane = false;
    }

    class MyAdapt extends RecyclerView.Adapter<MyAdapt.ViewHolder>{

        private List<News> list;
        public MyAdapt(List<News> l){
            list = l;
        }

        class ViewHolder extends RecyclerView.ViewHolder{
            TextView textView;
            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                textView = (TextView)itemView.findViewById(R.id.title_item_textView);
            }
        }
        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.title_item,parent,false);
            final ViewHolder viewHolder = new ViewHolder(view);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    News news = list.get(viewHolder.getAdapterPosition());      //获取此时的news实例
                    if(isTwoPane){
                       ContentFragment contentFragment = (ContentFragment)getFragmentManager().findFragmentById(R.id.content_fragment);
                       contentFragment.refresh(news.getTitle(),news.getContent());
                    }else{
                        MainActivity2.actionStart(getActivity(),news.getTitle(),news.getContent());
                    }
                }
            });
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            News news = list.get(position);
            holder.textView.setText(news.getTitle());
        }

        @Override
        public int getItemCount() {
            return list.size();
        }

    }
}
