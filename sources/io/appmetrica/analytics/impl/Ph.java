package io.appmetrica.analytics.impl;

import java.util.HashMap;
/* loaded from: classes5.dex */
public final class Ph {

    /* renamed from: a  reason: collision with root package name */
    public final C0242f6 f720a;
    public final boolean b;
    public final int c;
    public final HashMap d;
    public final Zh e;

    public Ph(C0242f6 c0242f6, boolean z, int i, HashMap hashMap, Zh zh) {
        this.f720a = c0242f6;
        this.b = z;
        this.c = i;
        this.d = hashMap;
        this.e = zh;
    }

    public final String toString() {
        return "ReportToSend(report=" + this.f720a + ", serviceDataReporterType=" + this.c + ", environment=" + this.e + ", isCrashReport=" + this.b + ", trimmedFields=" + this.d + ')';
    }
}
