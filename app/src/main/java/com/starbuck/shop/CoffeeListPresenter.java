package com.starbuck.shop;
import com.starbuck.shop.domain.Coffee;
import com.starbuck.shop.domain.CoffeeListInteractor;
import java.util.List;

/**
 * Created by iyubinest on 3/30/16.
 */
public class CoffeeListPresenter {
  public CoffeeListPresenter(CoffeeListInteractor interactor, final CoffeeListView view) {
    view.showLoading();
    interactor.getCoffees(new CoffeeListInteractor.Callback() {
      @Override public void onSuccess(List<Coffee> coffees) {
        view.renderCoffees(coffees);
        view.showTitle(coffees.size() + " found");
      }

      @Override public void onFailure() {
        view.showError();
      }
    });
  }
}
