package io.appmetrica.analytics.internal.js;

import android.webkit.JavascriptInterface;
import io.appmetrica.analytics.impl.C0644v1;
/* loaded from: classes5.dex */
public class AppMetricaInitializerJsInterface {

    /* renamed from: a  reason: collision with root package name */
    private final C0644v1 f1333a;

    public AppMetricaInitializerJsInterface(C0644v1 c0644v1) {
        this.f1333a = c0644v1;
    }

    @JavascriptInterface
    public void init(String str) {
        this.f1333a.c(str);
    }
}
