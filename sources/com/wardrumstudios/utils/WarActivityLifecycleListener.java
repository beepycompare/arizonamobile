package com.wardrumstudios.utils;

import android.content.Intent;
/* loaded from: classes4.dex */
public interface WarActivityLifecycleListener {
    void onActivityResult(int i, int i2, Intent intent);

    void onDestroy();

    void onPause();

    void onResume();

    void onStart();

    void onStop();
}
