package com.example.prostaappka;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class LicznikHandling extends ViewModel {
   private MutableLiveData<Integer> licznik;

    public MutableLiveData<Integer> getLicznik() {
        if (licznik == null) {
            licznik = new MutableLiveData<>();
            licznik.setValue(0);
        }
        return licznik;
    }

    public void setLicznik(int naCoZmienic) {
        if (licznik.getValue() != naCoZmienic) {
            licznik.setValue(naCoZmienic);
        }
        if (licznik.getValue() == null){
            licznik.setValue(0);
        }

    }
    public void dodajDoLicznika(int ileDodac){
        if(licznik.getValue()!=null){
            licznik.setValue(licznik.getValue()+ileDodac);
        }
    }

}
