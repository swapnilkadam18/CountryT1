package com.swapnil.countryt1.di;

import com.swapnil.countryt1.model.repository.interfaces.ViewModelCallback;
import com.swapnil.countryt1.viewmodel.CountryViewModel;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ViewModelComponent;
import dagger.hilt.android.scopes.ViewModelScoped;

@Module
@InstallIn(ViewModelComponent.class)
public class ViewModelModule {

    @Provides
    @ViewModelScoped
    static ViewModelCallback provideCallBackInstance(){
        return new CountryViewModel();
    }
}
