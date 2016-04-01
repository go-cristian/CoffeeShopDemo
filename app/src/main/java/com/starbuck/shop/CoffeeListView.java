package com.starbuck.shop;
import com.starbuck.shop.domain.Coffee;
import java.util.List;

/**
 * Created by iyubinest on 3/30/16.
 */
public interface CoffeeListView {
  void showLoading();

  void renderCoffees(List<Coffee> coffees);

  void showTitle(String title);

  void showError();
}
