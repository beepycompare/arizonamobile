package io.appmetrica.analytics.internal.js;

import android.webkit.JavascriptInterface;
import io.appmetrica.analytics.impl.C0610u1;
/* loaded from: classes5.dex */
public class AppMetricaInitializerJsInterface {

    /* renamed from: a  reason: collision with root package name */
    private final C0610u1 f1341a;

    public AppMetricaInitializerJsInterface(C0610u1 c0610u1) {
        this.f1341a = c0610u1;
    }

    @JavascriptInterface
    public void init(String str) {
        this.f1341a.c(str);
    }
}
