package com.flipick.webview_testing_app;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import android.content.Context;
import android.os.Environment;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

public class jsinterface {
    Context mContext;

    /** Instantiate the interface and set the context */
    jsinterface(Context c) {
        mContext = c;
    }

    /** Show a toast from the web page */
    @JavascriptInterface
    public void showToast(String toast) {
        Toast.makeText(mContext, toast, Toast.LENGTH_SHORT).show();
    }
    @JavascriptInterface
    public void SavePage(String HTML) throws IOException {
    	String ContentRootPath = Environment.getExternalStorageDirectory().toString() + "/FlipickMath1";
    	File EPUBDirectory = new File(ContentRootPath);
		if (!EPUBDirectory.exists()) EPUBDirectory.mkdirs();
		
		String FilePath=ContentRootPath +"/test_2.html";
		
		WriteHTMLFileText(FilePath,HTML);
		
    	String A=HTML;
        String B=A;
    }
    public String WriteHTMLFileText(String FilePath, String html_text) throws IOException
	{
		FileWriter fWriter;
		fWriter = new FileWriter(FilePath);
		fWriter.write(html_text);
		fWriter.flush();
		fWriter.close();
		return "";
	}

    
}