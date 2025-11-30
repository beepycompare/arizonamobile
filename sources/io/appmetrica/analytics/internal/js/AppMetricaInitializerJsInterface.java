package io.appmetrica.analytics.internal.js;

import android.webkit.JavascriptInterface;
import io.appmetrica.analytics.impl.C0611u1;
/* loaded from: classes5.dex */
public class AppMetricaInitializerJsInterface {

    /* renamed from: a  reason: collision with root package name */
    private final C0611u1 f1243a;

    public AppMetricaInitializerJsInterface(C0611u1 c0611u1) {
        this.f1243a = c0611u1;
    }

    @JavascriptInterface
    public void init(String str) {
        this.f1243a.c(str);
    }
}
