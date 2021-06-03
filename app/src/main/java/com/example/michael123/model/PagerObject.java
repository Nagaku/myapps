package com.example.michael123.model;

/*
    10118008
    Michael Nagaku Milenn Salim
    IF1
 */


import com.example.michael123.R;

public enum PagerObject {

    satu(R.string.page_satu, R.layout.page_satu),
    dua(R.string.page_dua, R.layout.page_dua),
    tiga(R.string.page_tiga, R.layout.page_tiga);

    private int mTitleResId;
    private int mLayoutResId;

    PagerObject(int titleResId, int layoutResId) {
        mTitleResId = titleResId;
        mLayoutResId = layoutResId;
    }

    public int getTitleResId() {
        return mTitleResId;
    }

    public int getLayoutResId() {
        return mLayoutResId;
    }

}