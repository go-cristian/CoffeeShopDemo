package com.starbuck.shop.domain;
import java.util.List;

/**
 * Created by iyubinest on 3/30/16.
 */
public class CoffeeListInteractor {
  private final CoffeesCache coffeesCache;
  private final CoffeesService coffeesService;

  public CoffeeListInteractor(CoffeesCache coffeesCache, CoffeesService coffeesService) {
    this.coffeesCache = coffeesCache;
    this.coffeesService = coffeesService;
  }

  public void getCoffees(final Callback callback) {
    coffeesCache.get(new CoffeesCache.Callback() {
      @Override public void onSucess(List<Coffee> coffees) {
        callback.onSuccess(coffees);
      }

      @Override public void onFailure() {
        coffeesService.get(new CoffeesService.Callback() {
          @Override public void onSucess(List<Coffee> coffees) {
            callback.onSuccess(coffees);
            coffeesCache.set(coffees);
          }

          @Override public void onFailure() {
            callback.onFailure();
          }
        });
      }
    });
  }

  interface Callback {
    void onSuccess(List<Coffee> coffees);

    void onFailure();
  }
}
