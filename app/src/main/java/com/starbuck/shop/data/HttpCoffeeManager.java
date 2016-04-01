package com.starbuck.shop.data;
import android.app.Activity;
import com.starbuck.shop.domain.Coffee;
import com.starbuck.shop.domain.CoffeesService;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by iyubinest on 3/30/16.
 */
public class HttpCoffeeManager implements CoffeesService {
  private final Activity activity;

  public HttpCoffeeManager(Activity activity) {
    this.activity = activity;
  }

  @Override public void get(final Callback callback) {
    TimerTask timerTask = new TimerTask() {
      @Override public void run() {
        final List<Coffee> coffees = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
          coffees.add(new Coffee("Cafe " + i, 12 + i,
              "http://square.github.io/picasso/static/icon-github.png"));
        }
        activity.runOnUiThread(new Runnable() {
          @Override public void run() {
            callback.onSuccess(coffees);
          }
        });
      }
    };
    new Timer().schedule(timerTask, 2000);
  }
}
