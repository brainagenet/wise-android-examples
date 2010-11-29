package com.clagu.testandroid;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ComposePathEffect;
import android.graphics.CornerPathEffect;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Path.Direction;
import android.graphics.PathDashPathEffect;
import android.graphics.PathEffect;
import android.graphics.Shader;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

public class TestAndroid extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MyView(this));
    }
	public class MyView extends View
	{
		int mWidth = 480;
		int mHeight = 800;
		
		Paint mPaint;
		Path mPath;
		PathEffect mPathEffect;
		
		int mGap = 0;
		int mGapShape = 0;
		int mShapeType = 0;
		int mPathType = 0;
		
		public MyView( Context c )
		{
			super( c );
            mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
            mPaint.setStyle(Paint.Style.STROKE);
            mPaint.setStrokeWidth(5);
            mPaint.setShader(makeLinear());
            
            init();
		}
		
		public void init()
		{
            mPath = getMakePath();
//            int r = (int)(Math.random()*100);
//            int g = (int)(Math.random()*100);
//            int b = (int)(Math.random()*100);
//            mPaint.setColor(Color.argb(255, r, g, b));
            mPaint.setShader(makeLinear());
            mPathType = (int)(System.currentTimeMillis()%4);
            mShapeType = (int)(System.currentTimeMillis()%6);
		}
		
		public Path getMakePath()
		{
			Path p = new Path();
			if(mPathType == 0)
			{
				//circle
				int radius = mWidth/3;
				if(mWidth > mHeight)
				{
					radius = mHeight/3;
				}
				p.addCircle(mWidth/2, mHeight/2, radius, Direction.CW);
			}else if(mPathType == 1)
			{
				//triangle
				p.moveTo(mWidth/2, mHeight/8);
				p.lineTo(mWidth/5, mHeight*7/8);
				p.lineTo(mWidth*4/5, mHeight*7/8);
				p.lineTo(mWidth/2, mHeight/8);
			}else if(mPathType == 2)
			{
				//rectangle
				p.moveTo(mWidth/5, mHeight/5);
				p.lineTo(mWidth/5, mHeight*4/5);
				p.lineTo(mWidth*4/5, mHeight*4/5);
				p.lineTo(mWidth*4/5, mHeight/5);
				p.lineTo(mWidth/5, mHeight/5);
			}else if(mPathType == 3)
			{
				//star
            	float radius = mWidth/3;
            	if(mWidth > mHeight)
            	{
            		radius = mHeight/3;
            	}
            	p.moveTo(mWidth/2+starsin(0)*radius/2, mHeight/2+starcos(0)*radius/2);
            	for(int i=0; i<11; i++)
            	{
            		if(i%2 == 1)
            		{
            			p.lineTo(mWidth/2+starsin(i)*radius, mHeight/2+starcos(i)*radius);
            		}else
            		{
            			p.lineTo(mWidth/2+starsin(i)*radius/2, mHeight/2+starcos(i)*radius/2);
            		}
            	}
			}
			return p;
		}
		
        public Path makePathShapeDash() {
            Path p = new Path();
            if(mShapeType == 0)
            {
            	//arrow
	            p.moveTo(0, 0);
	            p.lineTo(4, -4);
	            p.lineTo(12, -4);
	            p.lineTo(8, 0);
	            p.lineTo(12, 4);
	            p.lineTo(4, 4);
	            mGapShape = 15;
            }else if(mShapeType == 1)
            {
            	//fish
    	   		RectF rec = new RectF(0,0,15,10);
            	p.moveTo(0, 0);
            	p.addArc(rec, 180, 150);
            	p.lineTo(20, -2);
            	p.lineTo(20, 0);
            	p.moveTo(0, 0);
            	p.addArc(rec, 180, -150);
            	p.lineTo(20, 10);
            	p.lineTo(20, 0);
	            mGapShape = 25;
            }else if(mShapeType == 2)
            {
            	//KIN
	            p.moveTo(0, 0);
	            p.lineTo(0, 10);
	            p.lineTo(4, 10);
	            p.lineTo(4, 3);
	            p.lineTo(12, 10);
	            p.lineTo(12, 6);
	            p.lineTo(6, 0);
	            p.lineTo(12, -6);
	            p.lineTo(12, -10);
	            p.lineTo(4, -3);
	            p.lineTo(4, -10);
	            p.lineTo(0, -10);
	            p.moveTo(14, 0);
	            p.lineTo(14, 10);
	            p.lineTo(18, 10);
	            p.lineTo(18, -10);
	            p.lineTo(14, -10);
	            p.moveTo(20, 0);
	            p.lineTo(20, 10);
	            p.lineTo(24, 10);
	            p.lineTo(24, -4);
	            p.lineTo(30, 10);
	            p.lineTo(34, 10);
	            p.lineTo(34, -10);
	            p.lineTo(30, -10);
	            p.lineTo(30, 4);
	            p.lineTo(24, -10);
	            p.lineTo(20, -10);
	            p.lineTo(20, 0);
	            mGapShape = 40;
            }else if(mShapeType == 3)
            {
            	//cane
            	p.moveTo(5, 0);
            	p.toggleInverseFillType();
    	   		RectF rec = new RectF(-2.5f, -2.5f, 2.5f, 2.5f);
    	   		p.arcTo(rec, 0, -180);
    	   		rec = new RectF(-7.5f, -2.5f, -2.5f, 2.5f);
    	   		p.arcTo(rec, 0, 180);
    	   		rec = new RectF(-7.5f, -7.5f, 7.5f, 7.5f);
    	   		p.arcTo(rec, 180, 180);
    	   		p.lineTo(7.5f, 15f);
    	   		rec = new RectF(2.5f, 12.5f, 7.5f, 17.5f);
    	   		p.arcTo(rec, 0, 180);
    	   		p.lineTo(2.5f, 0);
	            mGapShape = 30;
            }else if(mShapeType == 4)
            {
            	//heart
            	p.moveTo(0, 0);
            	RectF rec = new RectF(-10,-10,0,0);
            	p.arcTo(rec, 0, -180);
            	p.lineTo(0, 10);
            	rec = new RectF(0,-10, 10,0);
            	p.arcTo(rec, 0, -180);
            	mGapShape = 30;
            }else
            {
            	//star
            	float radius = 10.0f;
            	p.moveTo(starsin(0)*radius, starcos(0)*radius);
            	for(int i=0; i<10; i++)
            	{
            		if(i%2 == 0)
            		{
            			p.lineTo(starsin(i)*radius, starcos(i)*radius);
            		}else
            		{
            			p.lineTo(starsin(i)*radius*0.3f, starcos(i)*radius*0.3f);
            		}
            	}
            	mGapShape = 25;
            }
            return p;
        }
        
        public float starsin(double i)
        {
        	return (float)Math.sin( 0.2*i*Math.PI );
        }
        
        public float starcos(double i)
        {
        	return (float)Math.cos( 0.2*i*Math.PI );
        }
		
        private Shader makeLinear() {
            return new LinearGradient(0, 0, 70, 70,
                    	new int[] { 0xFFFF0000, 0xFFFFFF00, 0xFF00FF00, 0xFF00FFFF, 0xFF0000FF, 0xFFFF00FF },
                        null, Shader.TileMode.REPEAT );
            //new int[] { 0xFFFF0000, 0xFFFFFF00, 0xFF00FF00, 0xFF00FFFF, 0xFF0000FF, 0xFFFF00FF },
        }

        @Override
		protected void onSizeChanged( int w, int h, int oldw, int oldh )
		{
			mWidth = w;
			mHeight = h;
            mPath = getMakePath();
			super.onSizeChanged( w, h, oldw, oldh );
		}

		protected void onDraw( Canvas canvas )
		{
            canvas.drawColor(0xFFFFFFFF);
//            mPathEffect = new ComposePathEffect(new DashPathEffect(new float[] {10, 5, 5, 5}, mGap),
//					new CornerPathEffect(10));
            mPathEffect = new ComposePathEffect(
            				new PathDashPathEffect(makePathShapeDash(), mGapShape, mGap, PathDashPathEffect.Style.ROTATE), 
            				new CornerPathEffect(10)
            			);
			mGap++;
            invalidate();
			mPaint.setPathEffect(mPathEffect);
			canvas.drawPath(mPath, mPaint);
		}
		
		public boolean onTouchEvent(MotionEvent event)
		{
			if(event.getAction() == MotionEvent.ACTION_DOWN)
			{
				init();
			}
			return super.onTouchEvent(event);
		}
	}
}