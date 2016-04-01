package com.starbuck.shop.ui;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.starbuck.shop.CoffeeApp;
import com.starbuck.shop.data.HttpCoffeeManager;
import com.starbuck.shop.R;
import com.starbuck.shop.domain.Coffee;
import com.starbuck.shop.domain.CoffeeListInteractor;
import java.util.List;

public class CoffeeListActivity extends AppCompatActivity implements CoffeeListView {
  private View loadingView;
  private View errorView;
  private CoffeesView coffessView;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_coffee_list);
    loadingView = findViewById(R.id.loading);
    errorView = findViewById(R.id.error);
    coffessView = (CoffeesView) findViewById(R.id.coffees);
    new CoffeeListPresenter(getInteractor(), this);
  }

  private CoffeeListInteractor getInteractor() {
    return new CoffeeListInteractor(((CoffeeApp) getApplication()).getCache(),
        new HttpCoffeeManager(this));
  }

  @Override public void showLoading() {
    show(loadingView);
  }

  @Override public void renderCoffees(List<Coffee> coffees) {
    coffessView.with(coffees);
    show(coffessView);
  }

  @Override public void showTitle(String title) {
    if (getSupportActionBar() != null) getSupportActionBar().setTitle(title);
  }

  @Override public void showError() {
    show(errorView);
  }

  private void show(View view) {
    loadingView.setVisibility(View.GONE);
    errorView.setVisibility(View.GONE);
    coffessView.setVisibility(View.GONE);
    view.setVisibility(View.VISIBLE);
  }
}
