package com.example.ugs.people;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

public class MyDraw extends View {

	ArrayList objects = new ArrayList();
	Man man;

	public MyDraw(Context context, AttributeSet attrs) {
		super(context, attrs);
        Bitmap pic =BitmapFactory.decodeResource(getResources(),R.drawable.sprite);
		this.man= new Man (200,200,0,pic);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		man.draw(canvas);
		invalidate();
	}

}
