package com.swapnil.countryt1.view.main;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.swapnil.countryt1.R;
import com.swapnil.countryt1.model.pojo.CountryMainData;

import java.util.ArrayList;
import java.util.List;

public class MainAdapter extends
        RecyclerView.Adapter<MainAdapter.ViewHolder> {

    private final List<CountryMainData> dataList = new ArrayList<>();
    private OnItemClickListener clickListener;

    public MainAdapter() {

    }

    public void updateList(List<CountryMainData> updatedList) {
        dataList.clear();
        dataList.addAll(updatedList);
        notifyDataSetChanged();
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        clickListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(R.layout.country_list_item, parent, false);

        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        CountryMainData item = dataList.get(position);
        holder.bind(item);
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public interface OnItemClickListener {
        void onItemClick(CountryMainData selectedData);
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ImageView flag;
        private ImageView isFav;
        private TextView name;
        private TextView currency;
        public ViewHolder(View itemView) {
            super(itemView);
            flag = itemView.findViewById(R.id.ivCountryFlag);
            isFav = itemView.findViewById(R.id.ivCountryFav);
            name = itemView.findViewById(R.id.tvCountryName);
            currency = itemView.findViewById(R.id.tvCountryCurrency);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int pos = getLayoutPosition();
            clickListener.onItemClick(dataList.get(pos));
        }


        public void bind(final CountryMainData model) {
            name.setText(model.getCountryName());
            currency.setText(model.getCountryCurrency());
        }
    }

}
