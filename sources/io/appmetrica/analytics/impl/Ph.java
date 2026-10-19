package io.appmetrica.analytics.impl;

import java.util.HashMap;
/* loaded from: classes5.dex */
public final class Ph {

    /* renamed from: a  reason: collision with root package name */
    public final C0235f6 f723a;
    public final boolean b;
    public final int c;
    public final HashMap d;
    public final Zh e;

    public Ph(C0235f6 c0235f6, boolean z, int i, HashMap hashMap, Zh zh) {
        this.f723a = c0235f6;
        this.b = z;
        this.c = i;
        this.d = hashMap;
        this.e = zh;
    }

    public final String toString() {
        return "ReportToSend(report=" + this.f723a + ", serviceDataReporterType=" + this.c + ", environment=" + this.e + ", isCrashReport=" + this.b + ", trimmedFields=" + this.d + ')';
    }
}
