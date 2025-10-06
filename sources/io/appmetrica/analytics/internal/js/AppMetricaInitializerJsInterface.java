package io.appmetrica.analytics.internal.js;

import android.webkit.JavascriptInterface;
import io.appmetrica.analytics.impl.C0548r1;
/* loaded from: classes4.dex */
public class AppMetricaInitializerJsInterface {

    /* renamed from: a  reason: collision with root package name */
    private final C0548r1 f1203a;

    public AppMetricaInitializerJsInterface(C0548r1 c0548r1) {
        this.f1203a = c0548r1;
    }

    @JavascriptInterface
    public void init(String str) {
        this.f1203a.c(str);
    }
}
