package io.appmetrica.analytics.impl;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public final class K7 {

    /* renamed from: a  reason: collision with root package name */
    public final Map f649a;
    public final String b;
    public final String c;

    public K7(String str, HashMap hashMap, String str2) {
        this.b = str;
        this.f649a = hashMap;
        this.c = str2;
    }

    public final String toString() {
        return "DeferredDeeplinkState{mParameters=" + this.f649a + ", mDeeplink='" + this.b + "', mUnparsedReferrer='" + this.c + "'}";
    }
}
