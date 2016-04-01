package com.starbuck.shop;
import com.starbuck.shop.domain.Coffee;
import com.starbuck.shop.domain.CoffeesCache;
import java.util.List;

/**
 * Created by iyubinest on 3/30/16.
 */
public class DefaultCoffeeCachemanager implements CoffeesCache {
  private List<Coffee> coffees;

  @Override public void get(Callback callback) {
    if (coffees == null) {
      callback.onFailure();
    } else {
      callback.onSucess(coffees);
    }
  }

  @Override public void set(List<Coffee> coffees) {
    this.coffees = coffees;
  }
}
