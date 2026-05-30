package io.appmetrica.analytics.internal.js;

import android.webkit.JavascriptInterface;
import io.appmetrica.analytics.impl.C0651v1;
/* loaded from: classes5.dex */
public class AppMetricaJsInterface {

    /* renamed from: a  reason: collision with root package name */
    private final C0651v1 f1329a;

    public AppMetricaJsInterface(C0651v1 c0651v1) {
        this.f1329a = c0651v1;
    }

    @JavascriptInterface
    public void reportEvent(String str, String str2) {
        this.f1329a.d(str, str2);
    }
}
