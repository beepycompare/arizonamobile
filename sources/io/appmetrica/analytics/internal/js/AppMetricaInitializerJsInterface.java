package io.appmetrica.analytics.internal.js;

import android.webkit.JavascriptInterface;
import io.appmetrica.analytics.impl.C0651v1;
/* loaded from: classes5.dex */
public class AppMetricaInitializerJsInterface {

    /* renamed from: a  reason: collision with root package name */
    private final C0651v1 f1330a;

    public AppMetricaInitializerJsInterface(C0651v1 c0651v1) {
        this.f1330a = c0651v1;
    }

    @JavascriptInterface
    public void init(String str) {
        this.f1330a.c(str);
    }
}
