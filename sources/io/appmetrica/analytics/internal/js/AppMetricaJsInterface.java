package io.appmetrica.analytics.internal.js;

import android.webkit.JavascriptInterface;
import io.appmetrica.analytics.impl.C0589t1;
/* loaded from: classes5.dex */
public class AppMetricaJsInterface {

    /* renamed from: a  reason: collision with root package name */
    private final C0589t1 f1344a;

    public AppMetricaJsInterface(C0589t1 c0589t1) {
        this.f1344a = c0589t1;
    }

    @JavascriptInterface
    public void reportEvent(String str, String str2) {
        this.f1344a.d(str, str2);
    }
}
