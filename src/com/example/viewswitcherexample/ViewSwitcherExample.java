package com.example.viewswitcherexample;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ViewSwitcher;

public class ViewSwitcherExample extends Activity implements OnClickListener{

	private Animation inAnimRight, outAnimLeft, inAnimLeft, outAnimRight;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_switcher_example);
        init();
    }
    
    private void init(){
		inAnimRight = AnimationUtils.loadAnimation(getApplicationContext(),
				R.anim.slide_in_right);
		outAnimLeft = AnimationUtils.loadAnimation(getApplicationContext(),
				R.anim.slide_out_left);
		inAnimLeft = AnimationUtils.loadAnimation(getApplicationContext(),
				R.anim.slide_in_left);
		outAnimRight = AnimationUtils.loadAnimation(getApplicationContext(),
				R.anim.slide_out_right);

    	
    	Button prev = (Button)findViewById(R.id.Previous);
    	prev.setOnClickListener(this);
    	Button next = (Button)findViewById(R.id.Next);
    	next.setOnClickListener(this);
    }

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		ViewSwitcher viewSwitcher = (ViewSwitcher)findViewById(R.id.viewSwitcher);
		switch(v.getId()){
			case R.id.Previous:
				viewSwitcher.setInAnimation(inAnimLeft);
				viewSwitcher.setOutAnimation(outAnimRight);
				viewSwitcher.showPrevious();
				break;
			case R.id.Next:
				viewSwitcher.setInAnimation(inAnimRight);
				viewSwitcher.setOutAnimation(outAnimLeft);
				viewSwitcher.showNext();
				break;
		}
	}
}
