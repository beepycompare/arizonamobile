package io.appmetrica.analytics.internal.js;

import android.webkit.JavascriptInterface;
import io.appmetrica.analytics.impl.C0561s1;
/* loaded from: classes5.dex */
public class AppMetricaJsInterface {

    /* renamed from: a  reason: collision with root package name */
    private final C0561s1 f1245a;

    public AppMetricaJsInterface(C0561s1 c0561s1) {
        this.f1245a = c0561s1;
    }

    @JavascriptInterface
    public void reportEvent(String str, String str2) {
        this.f1245a.d(str, str2);
    }
}
