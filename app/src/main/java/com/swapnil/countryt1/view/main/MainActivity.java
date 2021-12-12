package com.swapnil.countryt1.view.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.swapnil.countryt1.R;
import com.swapnil.countryt1.model.pojo.CountryMainData;
import com.swapnil.countryt1.viewmodel.CountryViewModel;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity implements View.OnClickListener, MainAdapter.OnItemClickListener {

    private Button goToFav;

    private CountryViewModel viewModel;
    private MainAdapter adapter;
    private RecyclerView countryList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewModel = new ViewModelProvider(this).get(CountryViewModel.class);
        adapter = new MainAdapter();
        countryList = findViewById(R.id.rvCountry);
        goToFav = findViewById(R.id.btnGoToFav);

        countryList.setAdapter(adapter);
        adapter.setOnItemClickListener(this);
        goToFav.setOnClickListener(this);
        observeData();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    private void observeData() {
        viewModel.listData.observe(this,countryMainData -> {
            adapter.updateList(countryMainData);
            adapter.notifyDataSetChanged();
        });

        viewModel.isLoading.observe(this, isLoading ->{
            Log.e("TEST", "isLoading: "+isLoading );

        });

        viewModel.errorFromRepo.observe(this, isError -> {
            Log.e("TEST", "errorFromRepo: "+isError );
        });
    }

    @Override
    public void onClick(View view) {
        viewModel.getCountryData();
    }

    @Override
    public void onItemClick(CountryMainData selectedData) {

    }
}