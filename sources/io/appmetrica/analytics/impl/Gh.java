package io.appmetrica.analytics.impl;

import java.util.HashMap;
/* loaded from: classes4.dex */
public final class Gh {

    /* renamed from: a  reason: collision with root package name */
    public final C0325i6 f446a;
    public final boolean b;
    public final int c;
    public final HashMap d;
    public final Qh e;

    public Gh(C0325i6 c0325i6, boolean z, int i, HashMap hashMap, Qh qh) {
        this.f446a = c0325i6;
        this.b = z;
        this.c = i;
        this.d = hashMap;
        this.e = qh;
    }

    public final String toString() {
        return "ReportToSend(report=" + this.f446a + ", serviceDataReporterType=" + this.c + ", environment=" + this.e + ", isCrashReport=" + this.b + ", trimmedFields=" + this.d + ')';
    }
}
