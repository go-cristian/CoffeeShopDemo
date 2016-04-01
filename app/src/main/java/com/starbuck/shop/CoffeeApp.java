package com.starbuck.shop;
import android.app.Application;

/**
 * Created by iyubinest on 3/30/16.
 */
public class CoffeeApp extends Application {
  private DefaultCoffeeCachemanager cache;

  @Override public void onCreate() {
    super.onCreate();
    cache = new DefaultCoffeeCachemanager();
  }

  public DefaultCoffeeCachemanager getCache() {
    return cache;
  }
}
