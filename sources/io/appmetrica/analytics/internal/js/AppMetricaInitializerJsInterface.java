package io.appmetrica.analytics.internal.js;

import android.webkit.JavascriptInterface;
import io.appmetrica.analytics.impl.C0497p1;
/* loaded from: classes4.dex */
public class AppMetricaInitializerJsInterface {

    /* renamed from: a  reason: collision with root package name */
    private final C0497p1 f1183a;

    public AppMetricaInitializerJsInterface(C0497p1 c0497p1) {
        this.f1183a = c0497p1;
    }

    @JavascriptInterface
    public void init(String str) {
        this.f1183a.c(str);
    }
}
