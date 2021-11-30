package com.nativepopreact;

import android.content.Intent;
import android.util.Log;

import com.facebook.react.ReactActivity;

public class MainActivity extends ReactActivity {
  private static final String TAG = "MainActivity";
  /**
   * Returns the name of the main component registered from JavaScript. This is used to schedule
   * rendering of the component.
   */
  @Override
  protected String getMainComponentName() {
    return "nativePopReact";
  }

//  @Override
//  public void invokeDefaultOnBackPressed() {
////    super.invokeDefaultOnBackPressed();
//    Log.e(TAG, "invokeDefaultOnBackPressed: ");
//    Intent intent = new Intent();
//    intent.putExtra("extraData", "data back from rn");
//    setResult(RESULT_OK, intent);
//    finish();
//  }
}
