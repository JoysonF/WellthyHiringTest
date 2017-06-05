package com.bwellthy.wellthyhiringtest.repository;

import android.content.SharedPreferences;

/**
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE.txt', which is part of this source code package.
 */

public class RepositoryImpl implements Repository {
  private final static String KEY_NAME = "NAME";
  private final static String KEY_DESCRIPTION = "DESCRIPTION";

  private SharedPreferences sharedPreferences;

  public RepositoryImpl(SharedPreferences sharedPreferences) {
    this.sharedPreferences = sharedPreferences;
  }

  @Override
  public String getName() {
    return sharedPreferences.getString(KEY_NAME, "");
  }

  @Override
  public void storeName(String name) {
    sharedPreferences.edit().putString(KEY_NAME, name).apply();
  }

  @Override
  public String getDescription() {
    return sharedPreferences.getString(KEY_DESCRIPTION, "");
  }

  @Override
  public void storeDescription(String description) {
    sharedPreferences.edit().putString(KEY_DESCRIPTION, description).apply();
  }
}
