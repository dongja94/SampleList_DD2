package com.begentgroup.samplelist;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.begentgroup.samplelist.data.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016-07-15.
 */
public class RecyclerPersonAdapter extends RecyclerView.Adapter<PersonViewHolder> {
    List<Person> items = new ArrayList<>();
    public void add(Person p) {
        items.add(p);
        notifyDataSetChanged();
    }

    @Override
    public PersonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.view_person_recycler, parent, false);
        return new PersonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PersonViewHolder holder, int position) {
        holder.setPerson(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
