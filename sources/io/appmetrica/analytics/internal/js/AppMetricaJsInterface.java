package io.appmetrica.analytics.internal.js;

import android.webkit.JavascriptInterface;
import io.appmetrica.analytics.impl.C0494p1;
/* loaded from: classes4.dex */
public class AppMetricaJsInterface {

    /* renamed from: a  reason: collision with root package name */
    private final C0494p1 f1181a;

    public AppMetricaJsInterface(C0494p1 c0494p1) {
        this.f1181a = c0494p1;
    }

    @JavascriptInterface
    public void reportEvent(String str, String str2) {
        this.f1181a.d(str, str2);
    }
}
