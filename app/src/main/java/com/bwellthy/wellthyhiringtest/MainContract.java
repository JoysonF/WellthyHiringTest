package com.bwellthy.wellthyhiringtest;

/**
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE.txt', which is part of this source code package.
 */

public interface MainContract {
  interface View {
    void setName(String name);
    String getName();
    void setDescription(String description);
    String getDescription();
    void setEditable(boolean editable);
  }

  interface Presenter {
    void fabClicked();
  }
}
