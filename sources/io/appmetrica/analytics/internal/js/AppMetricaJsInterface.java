package io.appmetrica.analytics.internal.js;

import android.webkit.JavascriptInterface;
import io.appmetrica.analytics.impl.C0650v1;
/* loaded from: classes5.dex */
public class AppMetricaJsInterface {

    /* renamed from: a  reason: collision with root package name */
    private final C0650v1 f1331a;

    public AppMetricaJsInterface(C0650v1 c0650v1) {
        this.f1331a = c0650v1;
    }

    @JavascriptInterface
    public void reportEvent(String str, String str2) {
        this.f1331a.d(str, str2);
    }
}
