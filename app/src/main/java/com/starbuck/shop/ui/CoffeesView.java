package com.starbuck.shop.ui;
import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import com.starbuck.shop.R;
import com.starbuck.shop.domain.Coffee;
import java.util.List;

/**
 * Created by iyubinest on 3/30/16.
 */
public class CoffeesView extends ListView {
  private CoffeAdapter adapter;

  public CoffeesView(Context context) {
    super(context);
    init();
  }

  public CoffeesView(Context context, AttributeSet attrs) {
    super(context, attrs);
    init();
  }

  public CoffeesView(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    init();
  }

  @TargetApi(Build.VERSION_CODES.LOLLIPOP)
  public CoffeesView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
    super(context, attrs, defStyleAttr, defStyleRes);
    init();
  }

  private void init() {
    adapter = new CoffeAdapter(getContext());
    setAdapter(adapter);
  }

  public void with(List<Coffee> coffees) {
    adapter.addAll(coffees);
    adapter.notifyDataSetChanged();
  }

  private class CoffeAdapter extends ArrayAdapter<Coffee> {
    public CoffeAdapter(Context context) {
      super(context, R.layout.coffee);
    }

    @Override public View getView(int position, View convertView, ViewGroup parent) {
      View view = LayoutInflater.from(getContext()).inflate(R.layout.coffee, parent, false);
      ImageView coffeeImage = (ImageView) view.findViewById(R.id.coffee_image);
      TextView coffeeName = (TextView) view.findViewById(R.id.coffee_name);
      TextView coffeePrice = (TextView) view.findViewById(R.id.coffee_price);
      Coffee coffee = getItem(position);
      coffeeName.setText(coffee.getName());
      coffeePrice.setText(String.format("$ %s", coffee.getPrice()));
      Picasso.with(getContext())
          .load(coffee.getImageurl())
          .fit()
          .placeholder(R.mipmap.ic_launcher)
          .into(coffeeImage);
      return view;
    }
  }
}
