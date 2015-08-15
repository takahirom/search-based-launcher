package com.ideasfrombrain.searchbasedlauncher;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

public class SearchText implements TextWatcher, Colorful {
    public static final String EMPTY = "";
    public static final String SPACE = " ";
    public static final String REGEX_MATCH_ALL = ".*";
    final MainActivity mainActivity;
    final EditText editText;

    public SearchText (MainActivity mainActivity) {
        this.mainActivity = mainActivity;
        editText = (EditText) mainActivity.findViewById(R.id.searchText);
        editText.addTextChangedListener(this);
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        mainActivity.getAppsManager().refreshView();
    }

    @Override
    public View getView() {
        return editText;
    }

    public void clearText() {
        editText.setText(EMPTY);
    }

    public void setSpaceCharacterToText() {
        editText.setText(SPACE);
    }

    public String getFilterText () {
        return editText.getText().toString().toLowerCase().replace(SPACE, REGEX_MATCH_ALL) + REGEX_MATCH_ALL;
    }
}