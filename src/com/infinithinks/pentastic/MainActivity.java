package com.infinithinks.pentastic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.infinithinks.others.AndroidOnlyInterface;
import com.infinithinks.others.Constant;
import com.sec.chaton.clientapi.MessageAPI;
import com.sec.chaton.clientapi.UtilityAPI;

public class MainActivity extends AndroidApplication implements AndroidOnlyInterface{
	
	private static String level;
	private static String time;
	
	ArrayList<Map<String,String>> appParamInfo = new ArrayList<Map<String,String>>();
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        AndroidApplicationConfiguration cfg = new AndroidApplicationConfiguration();
        cfg.useGL20 = true;
        
        appParamInfo.add(createParameter());
        initialize(new PENtasticMain(this), cfg);
    }
    
    protected Handler handler = new Handler(){
    	@Override
    	public void handleMessage(Message msg) {
    		switch (msg.what) {
			case Constant.SHARETIME:
				
				if(UtilityAPI.isChatONInstalled(MainActivity.this))
				{
					MessageAPI.sendAppLinkMessage(MainActivity.this, "Finished level "+level+" On 'Pentastic' Game With Time "+time+" . Beat me if you can!", "Pentastic", "1.2.1", appParamInfo);
				}else
				{
					Toast.makeText(MainActivity.this, "ChatON is not installed !!", Toast.LENGTH_SHORT).show();
				}
				break;
			case Constant.SHAREGAMELINK:
				
				if(UtilityAPI.isChatONInstalled(MainActivity.this))
				{
					MessageAPI.sendAppLinkMessage(MainActivity.this, "Play 'Pentastic' now for FREE!", "Pentastic", "1.2.1", appParamInfo);
				}else
				{
					Toast.makeText(MainActivity.this, "ChatON is not installed !!", Toast.LENGTH_SHORT).show();
				}
				
				break;

			default:
				break;
			}
    		
    	}
    };

	@Override
	public void shareChatOn(int message,String param1,String param2) {
		level = param1;
		time = param2;
		handler.sendEmptyMessage(message);
	}
	
	public HashMap<String, String> createParameter()
	{
		HashMap<String,String> param = new HashMap<String,String>();
		param.put("id", "com.infinithinks.pentastic");
		param.put("OS", "android");
		param.put("deviceType", "phone");
		param.put("installUrl", "http://www.samsungapps.com/appquery/appDetail.as?appId=com.infinithinks.pentastic");
		param.put("executeUri", "pentastic://launch");
		
		return param;
	}
	

}