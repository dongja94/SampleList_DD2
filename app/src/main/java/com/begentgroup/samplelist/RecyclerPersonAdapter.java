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
public class RecyclerPersonAdapter extends RecyclerView.Adapter<PersonViewHolder> implements PersonViewHolder.OnPersonItemClickListener {
    List<Person> items = new ArrayList<>();
    public void add(Person p) {
        items.add(p);
        notifyDataSetChanged();
    }

    @Override
    public PersonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.view_person_recycler, parent, false);
        PersonViewHolder holder = new PersonViewHolder(view);
        holder.setOnPersonItemClickListener(this);
        return holder;
    }

    @Override
    public void onBindViewHolder(PersonViewHolder holder, int position) {
        holder.setPerson(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public interface OnAdapterItemClickLIstener {
        public void onAdapterItemClick(View view, Person person, int position);
    }

    OnAdapterItemClickLIstener listener;
    public void setOnAdapterItemClickListener(OnAdapterItemClickLIstener listener) {
        this.listener = listener;
    }

    @Override
    public void onPersonItemClick(View view, Person person, int position) {
        if (listener != null) {
            listener.onAdapterItemClick(view, person, position);
        }
    }
}
