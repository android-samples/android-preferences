package com.example.preferencestest;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.os.Build;

public class SettingActivity extends Activity {

	public void checkMethod(View chk){
		CheckBox c = (CheckBox)chk;
		boolean b = c.isChecked();
		SharedPreferences pref = 
				getSharedPreferences("setting",
						MODE_PRIVATE);
		SharedPreferences.Editor e =
				pref.edit();
		e.putBoolean("mute", b);
		e.commit();
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_setting);

		// 現在の設定を取得
		SharedPreferences pref = 
				getSharedPreferences("setting",
						MODE_PRIVATE);
		boolean bMute = pref.getBoolean("mute",
				false);
		// チェック状態に反映させる
		CheckBox check = (CheckBox)
				findViewById(R.id.checkBox1);
		check.setChecked(bMute);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.setting, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
