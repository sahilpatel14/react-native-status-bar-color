
package com.ninthsemeter.reactnative.statusBarColor;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;

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
}