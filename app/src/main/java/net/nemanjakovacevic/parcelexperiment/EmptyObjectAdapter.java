package net.nemanjakovacevic.parcelexperiment;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by nemanja on 3/21/15.
 */
public class EmptyObjectAdapter extends RecyclerView.Adapter<EmptyObjectAdapter.EmptyObjectViewHolder> {

    ArrayList<EmptyObject> list;

    public EmptyObjectAdapter(ArrayList<EmptyObject> list){
        this.list = list;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void onBindViewHolder(EmptyObjectViewHolder emptyObjectViewHolder, int i) {
        EmptyObject eo = list.get(i);
        emptyObjectViewHolder.textView.setText(eo.toString().replace("net.nemanjakovacevic.parcelexperiment.", ""));
    }

    @Override
    public EmptyObjectViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(android.R.layout.simple_list_item_1, viewGroup, false);

        return new EmptyObjectViewHolder(itemView);
    }

    public static class EmptyObjectViewHolder extends RecyclerView.ViewHolder {

        protected TextView textView;

        public EmptyObjectViewHolder(View v) {
            super(v);
            textView =  (TextView) v.findViewById(android.R.id.text1);
        }
    }

}
