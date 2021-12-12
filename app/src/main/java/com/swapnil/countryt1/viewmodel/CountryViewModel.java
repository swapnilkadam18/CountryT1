package com.swapnil.countryt1.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.swapnil.countryt1.model.pojo.CountryMainData;
import com.swapnil.countryt1.model.repository.CountryRepository;
import com.swapnil.countryt1.model.repository.interfaces.ViewModelCallback;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;
@HiltViewModel
public class CountryViewModel extends ViewModel implements ViewModelCallback {
    public MutableLiveData<List<CountryMainData>> listData = new MutableLiveData<>();
    public MutableLiveData<Boolean> isLoading = new MutableLiveData<>();
    public MutableLiveData<Boolean> errorFromRepo = new MutableLiveData<>();

    @Inject
    public CountryRepository repository;

    @Inject
    public CountryViewModel() {
    }

    public void getCountryData(){
        isLoading.setValue(true);
        repository.getCountryData();
    }

    @Override
    public void onResponseSuccess(List<CountryMainData> countryData) {
        isLoading.setValue(false);
        errorFromRepo.setValue(false);
        listData.setValue(countryData);
    }

    @Override
    public void onResponseFailure(String errorReason) {
        isLoading.setValue(false);
        errorFromRepo.setValue(true);
    }
}
