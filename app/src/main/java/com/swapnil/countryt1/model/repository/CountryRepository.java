package com.swapnil.countryt1.model.repository;

import com.swapnil.countryt1.model.pojo.CountryApiResponse;
import com.swapnil.countryt1.model.network.service.NetworkService;
import com.swapnil.countryt1.model.pojo.CountryMainData;
import com.swapnil.countryt1.model.repository.interfaces.ViewModelCallback;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class CountryRepository {

    @Inject
    public NetworkService service;

    private ViewModelCallback viewModelCallback;

    CompositeDisposable disposable = new CompositeDisposable();

    @Inject
    public CountryRepository(ViewModelCallback viewModelCallback) {
        this.viewModelCallback = viewModelCallback;
    }

    public void getCountryData(){
        disposable.add(service.getApiResponse()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<List<CountryApiResponse>>() {
                    @Override
                    public void onSuccess(@NonNull List<CountryApiResponse> expectedRes) {
                        parseData(expectedRes);
                        disposable.dispose();
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        viewModelCallback.onResponseFailure(e.getLocalizedMessage());
                        disposable.dispose();
                    }
                })
        );
    }

    private void parseData(List<CountryApiResponse> expectedRes) {
        List<CountryMainData> mainDataList = new ArrayList<>();
        for(int i = 0; i < expectedRes.size(); i++){
            CountryApiResponse apiRes = expectedRes.get(i);
            mainDataList.add(new CountryMainData(apiRes.getName(),
                    apiRes.getFlagPNG(),apiRes.getCurrencies().get(0).getName()));
        }
        viewModelCallback.onResponseSuccess(mainDataList);
    }
}
