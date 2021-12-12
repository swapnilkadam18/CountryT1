package com.swapnil.countryt1.model.network.service;

import com.swapnil.countryt1.model.pojo.CountryApiResponse;
import com.swapnil.countryt1.model.network.interfaces.NetworkServiceApi;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;

public class NetworkService {

    @Inject
    public NetworkServiceApi api;

    @Inject
    public NetworkService() {
    }

    public Single<List<CountryApiResponse>> getApiResponse(){
        return api.getApiResponse();
    }
}
