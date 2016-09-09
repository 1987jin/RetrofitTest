package com.shine.retrofittest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.shine.wechat.WeChatApi;

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	public void getInfo(View v){
		WeChatApi.instance.getHotArticleRxJack(2,1,"android",1,"");
		WeChatApi.instance.getHotArticleRxString(2,1,"android",1,"");
	}
}
