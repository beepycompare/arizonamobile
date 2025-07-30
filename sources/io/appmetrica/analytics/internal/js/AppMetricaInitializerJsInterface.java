package io.appmetrica.analytics.internal.js;

import android.webkit.JavascriptInterface;
import io.appmetrica.analytics.impl.C0496p1;
/* loaded from: classes4.dex */
public class AppMetricaInitializerJsInterface {

    /* renamed from: a  reason: collision with root package name */
    private final C0496p1 f1184a;

    public AppMetricaInitializerJsInterface(C0496p1 c0496p1) {
        this.f1184a = c0496p1;
    }

    @JavascriptInterface
    public void init(String str) {
        this.f1184a.c(str);
    }
}
