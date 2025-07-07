package io.appmetrica.analytics.internal.js;

import android.webkit.JavascriptInterface;
import io.appmetrica.analytics.impl.C0502p1;
/* loaded from: classes4.dex */
public class AppMetricaInitializerJsInterface {

    /* renamed from: a  reason: collision with root package name */
    private final C0502p1 f1179a;

    public AppMetricaInitializerJsInterface(C0502p1 c0502p1) {
        this.f1179a = c0502p1;
    }

    @JavascriptInterface
    public void init(String str) {
        this.f1179a.c(str);
    }
}
