package io.appmetrica.analytics.internal.js;

import android.webkit.JavascriptInterface;
import io.appmetrica.analytics.impl.C0502p1;
/* loaded from: classes4.dex */
public class AppMetricaJsInterface {

    /* renamed from: a  reason: collision with root package name */
    private final C0502p1 f1180a;

    public AppMetricaJsInterface(C0502p1 c0502p1) {
        this.f1180a = c0502p1;
    }

    @JavascriptInterface
    public void reportEvent(String str, String str2) {
        this.f1180a.d(str, str2);
    }
}
