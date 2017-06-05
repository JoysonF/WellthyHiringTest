package com.bwellthy.wellthyhiringtest;

import android.content.SharedPreferences;
import com.bwellthy.wellthyhiringtest.MainContract.View;

/**
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE.txt', which is part of this source code package.
 */

public class MainPresenter implements MainContract.Presenter {
  private final static String KEY_NAME = "NAME";
  private final static String KEY_DESCRIPTION = "DESCRIPTION";
  private boolean editable;
  private View view;
  private SharedPreferences preferences;

  public MainPresenter(View view, SharedPreferences preferences) {
    this.view = view;
    this.preferences = preferences;

    view.setName(preferences.getString(KEY_NAME, ""));
    view.setDescription(preferences.getString(KEY_DESCRIPTION, ""));
    view.setEditable(editable);
  }

  @Override
  public void fabClicked() {
    editable = !editable;
    view.setEditable(editable);

    if (!editable) {
      preferences.edit().putString(KEY_NAME, view.getName()).apply();
      preferences.edit().putString(KEY_DESCRIPTION, view.getDescription()).apply();
    }
  }
}
