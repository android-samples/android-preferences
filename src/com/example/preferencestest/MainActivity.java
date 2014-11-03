package com.example.preferencestest;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.os.Build;

public class MainActivity extends Activity {

	// 情報のセーブ
	public void buttonMethodSave(View button){
		// 入力テキストを取得
		EditText edit = (EditText)
				findViewById(R.id.editText1);
		String t = edit.getText().toString();
		// テキストを保存
		// まずはSharedPreferencesのインスタンスを取得
		SharedPreferences pref =
			getSharedPreferences("test",
					MODE_PRIVATE);
		// 設定編集用のインスタンスを作る
		SharedPreferences.Editor e =
				pref.edit();
		// パラメータ編集 (IntentのputExtraっぽい感じ)
		e.putString("input", t);
		e.putString("input2", "aaaaaa");
		e.putString("input3", "aaaaaa");
		e.putInt("aaaa", 0);
		// 編集を確定する
		e.commit();
	}
	
	// 情報のロード
	public void buttonMethodLoad(View button){
		// 取得
		SharedPreferences pref =
				getSharedPreferences("test",
						MODE_PRIVATE);
		String t = pref.getString("input", "");
		// 表示
		EditText edit = (EditText)
				findViewById(R.id.editText1);
		edit.setText(t);
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			Intent intent = new Intent(
					this, SettingActivity.class);
			startActivity(intent);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
