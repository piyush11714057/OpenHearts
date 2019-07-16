package com.example.openhearts;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CustomSwipeAdapter extends PagerAdapter {

   private int[] image_resources ={R.drawable.akshay,R.drawable.bankimoon,R.drawable.oldagehome,R.drawable.teresa,R.drawable.oprah,R.drawable.orphanage_books_smile,R.drawable.orphanage_thnankyou};
   private Context context;
   private LayoutInflater layoutInflater;
   public CustomSwipeAdapter(Context context)
   {
       this.context=context;

   }

   @Override
    public int getCount() {
        return image_resources.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return (view==(LinearLayout)o);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
       layoutInflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
       View Itemview= layoutInflater.inflate(R.layout.swipe_layout,container,false);
       ImageView imageView=(ImageView) Itemview.findViewById(R.id.iv_1);
        TextView textView= (TextView) Itemview.findViewById(R.id.tv_1);
        imageView.setImageResource(image_resources[position]);
        textView.setText("Image"+position);
        container.addView(Itemview);
        return Itemview;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

   container.removeView((LinearLayout)object);
   }
}
