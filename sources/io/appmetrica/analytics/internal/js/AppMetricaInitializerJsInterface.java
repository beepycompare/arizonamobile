package io.appmetrica.analytics.internal.js;

import android.webkit.JavascriptInterface;
import io.appmetrica.analytics.impl.C0494p1;
/* loaded from: classes4.dex */
public class AppMetricaInitializerJsInterface {

    /* renamed from: a  reason: collision with root package name */
    private final C0494p1 f1180a;

    public AppMetricaInitializerJsInterface(C0494p1 c0494p1) {
        this.f1180a = c0494p1;
    }

    @JavascriptInterface
    public void init(String str) {
        this.f1180a.c(str);
    }
}
