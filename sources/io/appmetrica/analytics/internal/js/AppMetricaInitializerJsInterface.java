package io.appmetrica.analytics.internal.js;

import android.webkit.JavascriptInterface;
import io.appmetrica.analytics.impl.C0561s1;
/* loaded from: classes5.dex */
public class AppMetricaInitializerJsInterface {

    /* renamed from: a  reason: collision with root package name */
    private final C0561s1 f1244a;

    public AppMetricaInitializerJsInterface(C0561s1 c0561s1) {
        this.f1244a = c0561s1;
    }

    @JavascriptInterface
    public void init(String str) {
        this.f1244a.c(str);
    }
}
