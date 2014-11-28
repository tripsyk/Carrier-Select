package com.guardian.carrierselect;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;

public class CustomFrameLayout extends FrameLayout {  
	public CustomFrameLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}

	public float getXFraction() {  
         final int width = getWidth();  
           
         if(width != 0)  
         {  
              return getX() / getWidth();  
         }  
         else  
         {  
              return getX();  
         }  
    }  
 
    public void setXFraction(float xFraction) {      
         final int width = getWidth();  
         setX((width > 0) ? (xFraction * width) : -9999);  
    }  
}  