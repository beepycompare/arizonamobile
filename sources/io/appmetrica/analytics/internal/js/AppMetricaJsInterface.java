package io.appmetrica.analytics.internal.js;

import android.webkit.JavascriptInterface;
import io.appmetrica.analytics.impl.C0611u1;
/* loaded from: classes5.dex */
public class AppMetricaJsInterface {

    /* renamed from: a  reason: collision with root package name */
    private final C0611u1 f1244a;

    public AppMetricaJsInterface(C0611u1 c0611u1) {
        this.f1244a = c0611u1;
    }

    @JavascriptInterface
    public void reportEvent(String str, String str2) {
        this.f1244a.d(str, str2);
    }
}
