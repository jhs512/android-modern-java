package com.example.sbs.myapplication.dto;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ArticleType1ViewModel extends ViewModel {
    public Article article;
    public MutableLiveData<Boolean> checked;

    public ArticleType1ViewModel(Article article) {
        this.article = article;
        checked = new MutableLiveData<>(article.completed);
    }

    public MutableLiveData<Boolean> getChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked.postValue(checked);
    }
}