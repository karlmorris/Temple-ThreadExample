package edu.temple.mythreadexample;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

	int countdownStart = 10;
	TextView countdownDisplay;
	
	private Handler countdownHandler = new Handler(new Handler.Callback() {
		
		@Override
		public boolean handleMessage(Message msg) {
			
			countdownDisplay.setText(String.valueOf(msg.arg1));
			
			return false;
		}
	});
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Button startButton = (Button) findViewById(R.id.start_button);
		countdownDisplay = (TextView) findViewById(R.id.countdown_display);
		
		
		startButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Thread t = new Thread(){
					@Override
					public void run (){
						for (int i = countdownStart; i >= 0 ; i--){
							Message msg = Message.obtain();
							msg.arg1 = i;
							//countdownHandler.sendMessage(msg);
							countdownDisplay.setText("gfdf");
							
							try {
								Thread.sleep(2500);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
					}
				};
				t.start();
			}
		});
	
	}
	
	
	
}
