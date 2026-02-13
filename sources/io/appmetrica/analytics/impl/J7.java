package io.appmetrica.analytics.impl;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public final class J7 {

    /* renamed from: a  reason: collision with root package name */
    public final Map f640a;
    public final String b;
    public final String c;

    public J7(String str, HashMap hashMap, String str2) {
        this.b = str;
        this.f640a = hashMap;
        this.c = str2;
    }

    public final String toString() {
        return "DeferredDeeplinkState{mParameters=" + this.f640a + ", mDeeplink='" + this.b + "', mUnparsedReferrer='" + this.c + "'}";
    }
}
