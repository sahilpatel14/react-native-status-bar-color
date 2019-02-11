
package com.ninthsemeter.reactnative.statusBarColor;

import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactMethod;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.graphics.Color;
import android.os.Build;
import android.view.WindowManager;

import java.util.Map;
import java.util.HashMap;

import static android.view.View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR;
import static android.view.WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS;

public class RNStatusBarColorModule extends ReactContextBaseJavaModule {

  private final ReactApplicationContext reactContext;

  public RNStatusBarColorModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;
  }

  @Override
  public String getName() {
    return "RNStatusBarColor";
  }

  @Override
  public Map<String, Object> getConstants() {
    HashMap<String, Object> constants = new HashMap<String, Object>();
    constants.put("apiLevel", Build.VERSION.SDK_INT);
    return constants;
  }

  @ReactMethod
  public void setStatusBarColor(final String color, final boolean hasDarkTint) {
    final Activity activity = getCurrentActivity();
    if (activity == null)
      return;

    activity.runOnUiThread(new Runnable() {
      @Override
      public void run() {
        setStatusBarColor(activity, color);
        setStatusBarTint(activity, hasDarkTint);
      }
    });
  }

  @ReactMethod
  public void setNavigationBarColor(final String color, final boolean hasDarkTint) {
    final Activity activity = getCurrentActivity();
    if (activity == null)
      return;

    activity.runOnUiThread(new Runnable() {
      @Override
      public void run() {
        setNavigationBarColor(activity, color);
        setNavigationBarTint(activity, hasDarkTint);
      }
    });
  }

  private void setStatusBarColor(Activity activity, String color) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
      Window window = activity.getWindow();
      window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
      window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
      window.setStatusBarColor(Color.parseColor(color));
    }
  }

  private void setStatusBarTint(Activity activity, boolean hasDarkTint) {

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
      Window window = activity.getWindow();
      View view = window.getDecorView();
      int flags = view.getSystemUiVisibility();
      if (hasDarkTint) {
        flags = flags | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
      }
      view.setSystemUiVisibility(flags);
    }
  }

  private void setNavigationBarColor(Activity activity, String color) {
    if (Build.VERSION.SDK_INT >= 23) {
      Window window = activity.getWindow();
      window.setNavigationBarColor(Color.parseColor(color));
    }
  }

  private void setNavigationBarTint(Activity activity, boolean setAsDark) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
      Window window = activity.getWindow();
      View view = window.getDecorView();
      int flags = view.getSystemUiVisibility();

      if (setAsDark) {
        flags = flags | View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR;
      }

      view.setSystemUiVisibility(flags);
    }
  }
}