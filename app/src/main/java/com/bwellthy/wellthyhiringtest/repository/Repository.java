package com.bwellthy.wellthyhiringtest.repository;

/**
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE.txt', which is part of this source code package.
 */

public interface Repository {
  String getName();
  void storeName(String name);
  String getDescription();
  void storeDescription(String description);
}
