package com.example.sbs.myapplication.dto;


import androidx.lifecycle.ViewModel;

import com.example.sbs.myapplication.R;
import com.example.sbs.myapplication.util.BaseRecyclerViewAdapter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Article implements BaseRecyclerViewAdapter.HaveItemViewModel {
    public int id;
    public int userId;
    public String title;
    public boolean completed;
    public ViewModel articleViewModel;

    public ViewModel getItemViewModel(int layoutId) {
        if (articleViewModel == null) {
            if (layoutId == R.layout.item_article) {
                articleViewModel = new ArticleType1ViewModel(this);
            }
        }

        return articleViewModel;
    }
}