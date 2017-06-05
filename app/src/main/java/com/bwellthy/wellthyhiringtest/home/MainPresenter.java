package com.bwellthy.wellthyhiringtest.home;

import com.bwellthy.wellthyhiringtest.home.MainContract.View;
import com.bwellthy.wellthyhiringtest.repository.Repository;

/**
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE.txt', which is part of this source code package.
 */

public class MainPresenter implements MainContract.Presenter {
  private boolean editable;
  private View view;
  private Repository repository;

  public MainPresenter(View view, Repository repository) {
    this.view = view;
    this.repository = repository;

    view.setName(repository.getName());
    view.setDescription(repository.getDescription());
    view.setEditable(editable);
  }

  @Override
  public void fabClicked() {
    editable = !editable;
    view.setEditable(editable);

    if (!editable) {
      repository.storeName(view.getName());
      repository.storeDescription(view.getDescription());
    }
  }
}
