package com.bawei.yangxinlang.Http;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class HttpUtils {
    private static final String TAG = "HttpUtils————";
    private MyHandler myHandler = new MyHandler();
    private static final int SUCCESS = 0;
    private static final int ERROR = 1;
    private HttpUtilListener httpUtilListener;
    private static HttpUtils httpUtils = new HttpUtils();

    private HttpUtils() {

    }

    public static HttpUtils getInstance() {
        if (httpUtils == null) {
            httpUtils = new HttpUtils();
        }
        return httpUtils;
    }

    public void get(final String url) {
        new Thread() {
            @Override
            public void run() {

                try {
                    URL u = new URL(url);
                    HttpURLConnection urlConnection = (HttpURLConnection) u.openConnection();
                    urlConnection.setConnectTimeout(3000);
                    if (urlConnection.getResponseCode() == 200) {
                        InputStream inputStream = urlConnection.getInputStream();
                        String json = inputStreamToSting(inputStream);
                        Message message = myHandler.obtainMessage();
                        message.what = SUCCESS;
                        message.obj = json;
                        myHandler.sendMessage(message);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    Message message = myHandler.obtainMessage();
                    message.what = ERROR;
                    message.obj = e.getMessage();
                    myHandler.sendMessage(message);
                }
            }


        }.start();

    }

    private String inputStreamToSting(InputStream inputStream) {
        InputStreamReader streamReader = new InputStreamReader(inputStream);
        BufferedReader reader = new BufferedReader(streamReader);
        StringBuffer buffer = new StringBuffer();
        try {
            String sr = null;
            while ((sr = reader.readLine()) != null) {
                buffer.append(sr);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return buffer.toString();
    }

    class MyHandler extends Handler {

        @Override
        public void handleMessage(Message msg) {


            switch (msg.what) {
                case SUCCESS:
                    //成功
                    String json = (String) msg.obj;
                    Log.d(TAG, "handleMessage: " + json);
                    httpUtilListener.getSuccess(json);
                    break;
                case ERROR:
                    //失败
                    String error = (String) msg.obj;
                    Log.d(TAG, "handleMessage: " + error);
                    httpUtilListener.getError(error);
                    break;
            }
        }


    }

    public interface HttpUtilListener {
        void getSuccess(String json);

        void getError(String error);


    }

    public void setHttpUtilsListener(HttpUtilListener httpUtilsListener) {
        this.httpUtilListener = httpUtilsListener;
    }

    public String inputStream2String(InputStream inputStream) {
        int len = 0;
        byte[] butter = new byte[1024];
        StringBuffer stringBuffer = new StringBuffer();
        try {

            while ((len = inputStream.read(butter)) != -1) {
                String s = new String(butter, 0, len);
                stringBuffer.append(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        return stringBuffer.toString();
    }

    public void get2(String url) {
        MyTask myTask = new MyTask();
        myTask.execute(url);
    }

    class MyTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... strings) {
            try {
                String url = strings[0];
                URL u = new URL(url);
                HttpURLConnection connection = (HttpURLConnection) u.openConnection();
                connection.setConnectTimeout(3000);
                if (connection.getResponseCode() == 200) {
                    InputStream inputStream = connection.getInputStream();
                    String json = inputStream2String(inputStream);
                    return json;
                }
            } catch (Exception e) {
                e.printStackTrace();
                Log.d(TAG, "异常: " + e.getMessage());
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Log.d(TAG, "task---: " + s);
            httpUtilListener.getSuccess(s);
        }
    }
}
