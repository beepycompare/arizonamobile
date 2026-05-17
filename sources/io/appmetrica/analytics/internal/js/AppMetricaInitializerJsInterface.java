package io.appmetrica.analytics.internal.js;

import android.webkit.JavascriptInterface;
import io.appmetrica.analytics.impl.C0588t1;
/* loaded from: classes5.dex */
public class AppMetricaInitializerJsInterface {

    /* renamed from: a  reason: collision with root package name */
    private final C0588t1 f1348a;

    public AppMetricaInitializerJsInterface(C0588t1 c0588t1) {
        this.f1348a = c0588t1;
    }

    @JavascriptInterface
    public void init(String str) {
        this.f1348a.c(str);
    }
}
