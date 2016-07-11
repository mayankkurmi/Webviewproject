package com.flipick.webview_testing_app;

import org.xwalk.core.XWalkView;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

@SuppressLint("SetJavaScriptEnabled")
@TargetApi(Build.VERSION_CODES.KITKAT)
public class MainActivity extends Activity implements AnimationListener,
		OnClickListener {
	// WebView browser;
	private XWalkView browser;
	private int currentApiVersion;
	String URL = "";
	String HTMLContent = "";
	EditText txt_geturl;
	Button btn_go;
	long tStart;
	long tEnd;
	private RelativeLayout layout_navigation_drawer;
	// private LinearLayout layout_discover_course;
	static Animation animation;
	boolean is_nd_showing;
	LinearLayout top_bar;
	View tp_background;
	Button btn_download;

	private Context context;

	@SuppressLint("SetJavaScriptEnabled")
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_main);
		context = this;
		currentApiVersion = android.os.Build.VERSION.SDK_INT;
		tStart = System.currentTimeMillis();
		// URL =
		// "http://app.flipick.com/CMContent/Publishers/14/Assests/Video/9953/NPTEL_Page15/NPTEL_Page15_en/NPTEL_Page15_s_001_en_main.html";

		// HTMLContent ="<!DOCTYPE html>"
		// +
		// "<html lang='en' xmlns='http://www.w3.org/1999/xhtml'><head><meta name='viewport' content='width=device-width,height=device-height, initial-scale=1'><meta charset='utf-8' /><title></title><script type='text/javascript'>function init() {var oVideo = document.createElement('video'); oVideo.preload = 'auto'; oVideo.id = 'video_preview'; oVideo.style.width = document.documentElement.clientWidth + 'px'; oVideo.style.height = document.documentElement.clientHeight + 'px'; oVideo.style.position = 'absolute'; oVideo.style.margin = 'none'; oVideo.setAttribute('controls', 'controls') ; oVideo.setAttribute('poster', '');oVideo.setAttribute('src','"
		// + VideoPath
		// +
		// "');oVideo.load();document.documentElement.appendChild(oVideo);window.setTimeout(playvideo,1000);    }    function playvideo(){document.getElementById('video_preview').play();}window.addEventListener('load', init);;function Close(){var len = document.getElementsByTagName('video').length;for (var i = 0; i < len; i++){document.getElementsByTagName('video').item(i).pause();if(document.getElementsByTagName('video').item(i).children.length>0){document.getElementsByTagName('video').item(i).children[0].src='';}}AndroidFunction.CloseWebviewPopup(); }</script>"
		// +
		// "</head><body style='margin:auto;width:100%'><div style='position: absolute; left: 0; top: 0; width: 100%; height: 30px; z-index: 2;'><img src='file:///android_asset/close_icon.png'  onclick='Close()' style='float:right'/></div>"
		// + "</body></html>";

		// androidWebview();

		crosswalkwebview();

		// browser = (XWalkView) findViewById(R.id.xwalkview_sec);
		// // browser = (WebView) findViewById(R.id.xwalkview_sec);
		// // setFullscreen();
		// //
		// getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(this);
		//
		// // browser = (WebView) findViewById(R.id.xwalkview_sec);
		// browser.clearCache(true);
		// // browser.getSettings().setJavaScriptEnabled(true);
		//
		// // browser.getSettings().setAllowUniversalAccessFromFileURLs(true);
		// // browser.setWebViewClient(new myWebClient());
		// browser.addJavascriptInterface(new jsinterface(this),
		// "AndroidFunction");
		// // Load URL
		// // String URL =
		// //
		// "file:///storage/emulated/0/FlipickCourseManager/Courses/3868/External/story.html";
		// // String URL = "file:///android_asset/External/story.html";
		//

		// // String URL =
		// //
		// "http://192.168.200.9/WebFiles/123456/SoundShare/fd_en/fd_s_001_en_main.html";
		// // String URL =
		// //
		// "http://192.168.200.9/WebFiles/prashant/issue/distp_en/distp_s_001_en_main.html";
		//
		// // browser.loadUrl(URL);
		// browser.load(URL, "");

	}

	// public void androidWebview() {
	// browser = (WebView) findViewById(R.id.xwalkview_sec);
	// browser.getSettings().setJavaScriptEnabled(true);
	// browser.getSettings().setLoadWithOverviewMode(true);
	// browser.getSettings().setUseWideViewPort(true);
	// browser.getSettings().setAllowUniversalAccessFromFileURLs(true);
	// browser.setWebViewClient(new myWebClient());
	// browser.loadUrl("http://192.168.200.9/WebFiles/testanim/2460/s16m4_01_04_01_en/s16m4_01_04_01_s_001_en_main.html");
	// }

	public void crosswalkwebview() {
		btn_download = (Button) findViewById(R.id.btn_download);
		layout_navigation_drawer = (RelativeLayout) findViewById(R.id.layout_navigation_drawer);

		tp_background = findViewById(R.id.tp_background);
		txt_geturl = (EditText) findViewById(R.id.txt_geturl);
		btn_go = (Button) findViewById(R.id.btn_go);
		top_bar = (LinearLayout) findViewById(R.id.top_bar);
		browser = (XWalkView) findViewById(R.id.xwalkview_sec);
		btn_download.setOnClickListener(this);
		Toast.makeText(getApplicationContext(), "fsfs", Toast.LENGTH_SHORT)
				.show();
		// browser.clearCache(true);
		// browser.addJavascriptInterface(new jsinterface(this),
		// "AndroidFunction");
		// browser.load(
		// "http://192.168.200.9/WebFiles/testanim/2460/s16m4_01_04_01_en/s16m4_01_04_01_s_001_en_main.html",
		// "");
		// layout_navigation_drawer.setVisibility(View.GONE);
		// btn_go.setOnClickListener(new OnClickListener() {
		//
		// @Override
		// public void onClick(View v) {
		// // TODO Auto-generated method stub
		//
		// tEnd = System.currentTimeMillis();
		// long tDelta = tEnd - tStart;
		// double elapsedSeconds = tDelta / 1000.0;
		// URL = txt_geturl.getText().toString();
		// browser.load(URL, "");
		// }
		// });
		// top_bar.setOnClickListener(this);

	}

	@Override
	public boolean dispatchKeyEvent(KeyEvent event) {
		int keyCode = event.getKeyCode();
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			finish();
			return true;
		}
		return super.dispatchKeyEvent(event);
	}

	public class myWebClient extends WebViewClient {
		@Override
		public void onPageStarted(WebView view, String url, Bitmap favicon) {
			// TODO Auto-generated method stub
			super.onPageStarted(view, url, favicon);
		}

		@Override
		public boolean shouldOverrideUrlLoading(WebView view, String url) {
			// TODO Auto-generated method stub

			view.loadUrl(url);
			return true;

		}
	}

	// @Override
	// public void onWindowFocusChanged(boolean hasFocus) {
	// super.onWindowFocusChanged(hasFocus);
	//
	// if (currentApiVersion >= Build.VERSION_CODES.KITKAT && hasFocus) {
	// getWindow().getDecorView().setSystemUiVisibility(
	// View.SYSTEM_UI_FLAG_LAYOUT_STABLE
	// | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
	// | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
	// | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
	// | View.SYSTEM_UI_FLAG_FULLSCREEN
	// | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
	// }
	//
	// }

	@Override
	public void onDestroy() {

		if (browser != null) {
			// browser.destroy();
			// browser.onDestroy();
		}
		super.onDestroy();

	}

	@Override
	public void onResume() {
		super.onResume();

		if (browser != null) {
			browser.resumeTimers();
			// browser.onShow();
		}
	}

	@Override
	public void onPause() {
		super.onPause();
		if (browser != null) {
			browser.pauseTimers();
			// browser.onHide();
		}
	}

	@Override
	public void onBackPressed() {
		tEnd = System.currentTimeMillis();
		long tDelta = tEnd - tStart;
		double elapsedSeconds = tDelta / 1000.0;
		finish();
	}

	// @Override
	// public void onSystemUiVisibilityChange(int visibility) {
	// // TODO Auto-generated method stub
	//
	// }

	// private void setFullscreen() {
	// getWindow().getDecorView().setSystemUiVisibility(
	// View.SYSTEM_UI_FLAG_LAYOUT_STABLE
	// | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
	// | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
	// | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION // hide nav bar
	// | View.SYSTEM_UI_FLAG_FULLSCREEN // hide status bar
	// | View.SYSTEM_UI_FLAG_IMMERSIVE);
	// }

	// @Override
	// public void onSystemUiVisibilityChange(int visibility) {
	// // TODO Auto-generated method stub
	// if ((visibility & View.SYSTEM_UI_FLAG_FULLSCREEN) == 0) {
	//
	// }
	// }
	public void NavigationDrawerSetupUI(final Context context) {
		// LinearLayout layout_nd_user_holder = (LinearLayout) ((Activity)
		// context).findViewById(R.id.layout_nd_user_holder);
		// LinearLayout layout_nd_course_list_holder = (LinearLayout)
		// ((Activity) context).findViewById(R.id.layout_nd_course_list_holder);
		// LinearLayout layout_nd_discover_courses_holder = (LinearLayout)
		// ((Activity)
		// context).findViewById(R.id.layout_nd_discover_courses_holder);
		// LinearLayout layout_email_holder = (LinearLayout) ((Activity)
		// context).findViewById(R.id.layout_email);

		WebView navigation_webview = (WebView) ((Activity) context)
				.findViewById(R.id.navigation_webview);
		navigation_webview.getSettings().setJavaScriptEnabled(true);
		navigation_webview.loadUrl("http://developer.android.com/index.html");

		// TextView txt_user_name = (TextView) ((Activity)
		// context).findViewById(R.id.txt_user);
		// TextView txt_user_email_id = (TextView) ((Activity)
		// context).findViewById(R.id.txt_user_email_id);
		// String name = "";

	}

	public void ShowHideNavigation(
			final RelativeLayout layout_navigation_drawer,
			final View tp_background, Context context) {

		// layout_discover_course.setVisibility(View.GONE);
		this.layout_navigation_drawer = layout_navigation_drawer;
		this.tp_background = tp_background;
		if (layout_navigation_drawer.getVisibility() != View.VISIBLE) {
			is_nd_showing = true;
			if (layout_navigation_drawer.getWidth() == 0)
				animation = new TranslateAnimation(320, 0, 0, 0);
			else
				animation = new TranslateAnimation(
						layout_navigation_drawer.getWidth(), 0, 0, 0);
			layout_navigation_drawer.setVisibility(View.VISIBLE);
			animation.setDuration(500);
			tp_background.setVisibility(View.VISIBLE);
			animation.setAnimationListener(this);
			animation.setFillAfter(true);
			layout_navigation_drawer.startAnimation(animation);

			Animation fadeIn = new AlphaAnimation(0, 1);
			fadeIn.setInterpolator(new DecelerateInterpolator());
			fadeIn.setDuration(500);
			tp_background.startAnimation(fadeIn);
			tp_background.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					hideNavigationDrawer();
				}
			});
		} else {
			hideNavigationDrawer();
		}
	}

	private void hideNavigationDrawer() {
		is_nd_showing = false;
		this.animation = new TranslateAnimation(0,
				layout_navigation_drawer.getWidth(), 0, 0);
		// layout_navigation_drawer.setVisibility(View.GONE);
		this.animation.setDuration(500);
		this.animation.setAnimationListener(this);
		this.animation.setFillAfter(true);
		layout_navigation_drawer.startAnimation(animation);

		Animation fadeOut = new AlphaAnimation(1, 0);
		fadeOut.setInterpolator(new AccelerateInterpolator());
		fadeOut.setDuration(500);
		tp_background.setVisibility(View.GONE);
		tp_background.startAnimation(fadeOut);
	}

	@Override
	public void onAnimationStart(Animation animation) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onAnimationEnd(Animation animation) {
		if (!is_nd_showing && layout_navigation_drawer != null) {
			layout_navigation_drawer.setVisibility(View.GONE);
			tp_background.setVisibility(View.GONE);
			layout_navigation_drawer.clearAnimation();
		}
	}

	@Override
	public void onAnimationRepeat(Animation animation) {
		// TODO Auto-generated method stub

	}

	public void DisplayURL(String Url) {
		Intent itnURL = new Intent(Intent.ACTION_VIEW, Uri.parse(Url));
		startActivity(itnURL);
	}

	@Override
	public void onClick(View view) {
		if (view == top_bar) {
			NavigationDrawerSetupUI(context);
			ShowHideNavigation(layout_navigation_drawer, tp_background, context);
		}
		if (view == btn_download) {
			DisplayURL("http://52.76.42.79/CMContent//Publishers/5/Assests/whiteboardrecording/8808.zip");

		}

	}
}
