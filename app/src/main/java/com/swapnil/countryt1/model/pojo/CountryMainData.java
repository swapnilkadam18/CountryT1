package com.swapnil.countryt1.model.pojo;

public class CountryMainData {

    private String countryName;
    private String countryFlag;
    private String countryCurrency;
    private boolean isFav = false;

    public CountryMainData(String countryName, String countryFlag, String countryCurrency) {
        this.countryName = countryName;
        this.countryFlag = countryFlag;
        this.countryCurrency = countryCurrency;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryFlag() {
        return countryFlag;
    }

    public void setCountryFlag(String countryFlag) {
        this.countryFlag = countryFlag;
    }

    public String getCountryCurrency() {
        return countryCurrency;
    }

    public void setCountryCurrency(String countryCurrency) {
        this.countryCurrency = countryCurrency;
    }

    public boolean isFav() {
        return isFav;
    }

    public void setFav(boolean fav) {
        isFav = fav;
    }
}
