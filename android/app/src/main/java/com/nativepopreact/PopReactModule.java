package com.nativepopreact;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.modules.core.DeviceEventManagerModule;

import org.jetbrains.annotations.NotNull;

public class PopReactModule extends ReactContextBaseJavaModule implements LifecycleEventListener {
    private static final String TAG = "PopReactModule";
    private final ReactApplicationContext mReactContext;

    public PopReactModule(@Nullable @org.jetbrains.annotations.Nullable ReactApplicationContext reactContext) {
        super(reactContext);
        reactContext.addLifecycleEventListener(this);
        mReactContext = reactContext;
    }

    @Override
    public void onHostResume() {
        Log.d(TAG, "onHostResume: ");
    }

    @Override
    public void onHostPause() {
        Log.d(TAG, "onHostPause: ");
    }

    @Override
    public void onHostDestroy() {
        // pop 出去的时候传递数据给 native
        Log.d(TAG, "onHostDestroy: ");
        sendEvent("push", "onHostDestroy");
    }

    @NonNull
    @NotNull
    @Override
    public String getName() {
        return "PopReactModule";
    }

    public void sendEvent(String eventName, String msg) {
        mReactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class).emit(eventName, msg);
    }

    @ReactMethod
    public void testMethod(Promise promise) {
        int n = 0;
        for (int i = 0; i < 1000000000; i++) {
            n++;
        }
        Log.d(TAG, "testMethod: " + n);
//        promise.resolve(n);
    }
}
