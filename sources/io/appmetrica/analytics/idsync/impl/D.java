package io.appmetrica.analytics.idsync.impl;

import java.util.Map;
/* loaded from: classes3.dex */
public final class D {

    /* renamed from: a  reason: collision with root package name */
    public final String f460a;
    public final boolean b;
    public final String c;
    public final boolean d;
    public final int e;
    public final byte[] f;
    public final Map g;

    public D(String str, boolean z, String str2, boolean z2, int i, byte[] bArr, Map map) {
        this.f460a = str;
        this.b = z;
        this.c = str2;
        this.d = z2;
        this.e = i;
        this.f = bArr;
        this.g = map;
    }

    public final String toString() {
        return "RequestResult(type='" + this.f460a + "', isCompleted=" + this.b + ", url=" + this.c + ", responseCodeIsValid=" + this.d + ", responseCode=" + this.e + ", responseBody=" + this.f + ", responseHeaders=" + this.g + ')';
    }
}
