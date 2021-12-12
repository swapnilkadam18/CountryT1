package com.swapnil.countryt1.model.network.interfaces;

import com.swapnil.countryt1.model.pojo.CountryApiResponse;
import com.swapnil.countryt1.model.utils.Constants;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface NetworkServiceApi {

    @GET(Constants.COUNTRIES_URL)
    Single<List<CountryApiResponse>> getApiResponse();

}
