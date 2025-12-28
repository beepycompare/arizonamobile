package io.appmetrica.analytics.internal.js;

import android.webkit.JavascriptInterface;
import io.appmetrica.analytics.impl.C0610u1;
/* loaded from: classes5.dex */
public class AppMetricaJsInterface {

    /* renamed from: a  reason: collision with root package name */
    private final C0610u1 f1342a;

    public AppMetricaJsInterface(C0610u1 c0610u1) {
        this.f1342a = c0610u1;
    }

    @JavascriptInterface
    public void reportEvent(String str, String str2) {
        this.f1342a.d(str, str2);
    }
}
