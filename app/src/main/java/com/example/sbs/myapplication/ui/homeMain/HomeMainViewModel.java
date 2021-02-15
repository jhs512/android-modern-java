package com.example.sbs.myapplication.ui.homeMain;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.sbs.myapplication.R;
import com.example.sbs.myapplication.databinding.ActivityMainBinding;
import com.example.sbs.myapplication.databinding.FragmentHomeMainBinding;
import com.example.sbs.myapplication.dto.Article;
import com.example.sbs.myapplication.service.ArticleService;
import com.example.sbs.myapplication.util.BaseRecyclerViewAdapter;
import com.example.sbs.myapplication.util.Util;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class HomeMainViewModel extends AndroidViewModel {
    private ArticleService articleService;
    private MutableLiveData<List<Article>> lvArticles;

    @Inject
    public HomeMainViewModel(@NonNull Application application, ArticleService articleService) {
        super(application);
        lvArticles = new MutableLiveData<>();
        this.articleService = articleService;
    }

    private void loadArticles() {
        articleService.getArticles(resultData -> {
            // 이 함수가 실행될 때는 뷰가 사라졌을 수 도 있음
            if (lvArticles == null) {
                return;
            }

            lvArticles.setValue(resultData.body.articles);
        }, throwable -> {
            Util.toast("통신오류로 게시물을 불러오지 못했습니다.");
            Util.log(throwable.getLocalizedMessage());
        });
    }

    public MutableLiveData<List<Article>> getLvArticles() {
        return lvArticles;
    }

    public void initView(FragmentHomeMainBinding binding) {
        binding.fragmentHomeMainRecyclerViewArticle.setAdapter(new BaseRecyclerViewAdapter<Article>(R.layout.item_article));

        loadArticles();
    }
}