package io.appmetrica.analytics.internal.js;

import android.webkit.JavascriptInterface;
import io.appmetrica.analytics.impl.C0644v1;
/* loaded from: classes5.dex */
public class AppMetricaJsInterface {

    /* renamed from: a  reason: collision with root package name */
    private final C0644v1 f1334a;

    public AppMetricaJsInterface(C0644v1 c0644v1) {
        this.f1334a = c0644v1;
    }

    @JavascriptInterface
    public void reportEvent(String str, String str2) {
        this.f1334a.d(str, str2);
    }
}
