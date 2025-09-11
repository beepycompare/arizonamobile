package io.appmetrica.analytics.internal.js;

import android.webkit.JavascriptInterface;
import io.appmetrica.analytics.impl.C0547r1;
/* loaded from: classes4.dex */
public class AppMetricaInitializerJsInterface {

    /* renamed from: a  reason: collision with root package name */
    private final C0547r1 f1202a;

    public AppMetricaInitializerJsInterface(C0547r1 c0547r1) {
        this.f1202a = c0547r1;
    }

    @JavascriptInterface
    public void init(String str) {
        this.f1202a.c(str);
    }
}
