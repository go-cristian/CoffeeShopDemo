package com.starbuck.shop.domain;
import java.util.List;

/**
 * Created by iyubinest on 3/30/16.
 */
public interface CoffeesService {
  void get(Callback callback);

  public interface Callback {
    void onSucess(List<Coffee> coffees);

    void onFailure();
  }
}
