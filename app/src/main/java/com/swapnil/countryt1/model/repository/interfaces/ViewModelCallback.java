package com.swapnil.countryt1.model.repository.interfaces;

import com.swapnil.countryt1.model.pojo.CountryMainData;

import java.util.List;

public interface ViewModelCallback {
    void onResponseSuccess(List<CountryMainData> countryData);

    void onResponseFailure(String errorReason);
}
