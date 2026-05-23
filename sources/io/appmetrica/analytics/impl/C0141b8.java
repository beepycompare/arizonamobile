package io.appmetrica.analytics.impl;

import java.util.HashMap;
import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.b8  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0141b8 {

    /* renamed from: a  reason: collision with root package name */
    public final Map f903a;
    public final String b;
    public final String c;

    public C0141b8(String str, HashMap hashMap, String str2) {
        this.b = str;
        this.f903a = hashMap;
        this.c = str2;
    }

    public final String toString() {
        return "DeferredDeeplinkState{mParameters=" + this.f903a + ", mDeeplink='" + this.b + "', mUnparsedReferrer='" + this.c + "'}";
    }
}
