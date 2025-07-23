package io.appmetrica.analytics.impl;

import java.util.HashMap;
import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.d8  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0202d8 {

    /* renamed from: a  reason: collision with root package name */
    public final Map f813a;
    public final String b;
    public final String c;

    public C0202d8(String str, HashMap hashMap, String str2) {
        this.b = str;
        this.f813a = hashMap;
        this.c = str2;
    }

    public final String toString() {
        return "DeferredDeeplinkState{mParameters=" + this.f813a + ", mDeeplink='" + this.b + "', mUnparsedReferrer='" + this.c + "'}";
    }
}
