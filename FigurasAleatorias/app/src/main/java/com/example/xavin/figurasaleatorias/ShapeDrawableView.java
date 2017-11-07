package com.example.xavin.figurasaleatorias;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ShapeDrawable;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xavin on 07/11/2017.
 */

public class ShapeDrawableView extends View{
    private List<ShapeDrawable> shapes = new ArrayList<ShapeDrawable>();
    private Integer[] mColors =
            {Color.BLACK, Color.BLUE, Color.GREEN, Color.RED};
    public ShapeDrawableView(Context context) {
        super(context);
    }
    
}
