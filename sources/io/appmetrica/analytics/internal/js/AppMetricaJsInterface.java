package io.appmetrica.analytics.internal.js;

import android.webkit.JavascriptInterface;
import io.appmetrica.analytics.impl.C0497p1;
/* loaded from: classes4.dex */
public class AppMetricaJsInterface {

    /* renamed from: a  reason: collision with root package name */
    private final C0497p1 f1184a;

    public AppMetricaJsInterface(C0497p1 c0497p1) {
        this.f1184a = c0497p1;
    }

    @JavascriptInterface
    public void reportEvent(String str, String str2) {
        this.f1184a.d(str, str2);
    }
}
