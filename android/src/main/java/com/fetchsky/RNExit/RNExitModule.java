
package com.fetchsky.RNExit;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.bridge.ReadableType;

import static android.app.Activity.RESULT_OK;

public class RNExitModule extends ReactContextBaseJavaModule {
    private final ReactApplicationContext reactContext;

    public RNExitModule(ReactApplicationContext reactContext) {
      super(reactContext);
      this.reactContext = reactContext;
    }

    @Override
    public String getName() {
      return "RNExit";
    }


    @ReactMethod
    public void exitApp(ReadableMap readableMap) {
        Intent intent = new Intent();
        ReadableMapKeySetIterator iterator = readableMap.keySetIterator();
        while (iterator.hasNextKey()) {
            String key = iterator.nextKey();
            ReadableType type = readableMap.getType(key);
            switch (type) {
                case Null:
                    intent.putExtra(key, -1);
                    break;
                case Boolean:
                    intent.putExtra(key, readableMap.getBoolean(key));
                    break;
                case Number:
                    intent.putExtra(key, readableMap.getDouble(key));
                    break;
                case String:
                    intent.putExtra(key, readableMap.getString(key));
                    break;
//                case Map:
//                    intent.putExtra(key, (Parcelable) readableMap.getMap(key));
//                    break;
//                case Array:
//                    intent.putExtra(key, readableMap.getArray(key));
//                    break;
            }
        }
        getCurrentActivity().setResult(RESULT_OK, intent);
        getCurrentActivity().finish();
    }
}