package io.appmetrica.analytics.internal.js;

import android.webkit.JavascriptInterface;
import io.appmetrica.analytics.impl.C0548r1;
/* loaded from: classes4.dex */
public class AppMetricaJsInterface {

    /* renamed from: a  reason: collision with root package name */
    private final C0548r1 f1204a;

    public AppMetricaJsInterface(C0548r1 c0548r1) {
        this.f1204a = c0548r1;
    }

    @JavascriptInterface
    public void reportEvent(String str, String str2) {
        this.f1204a.d(str, str2);
    }
}
