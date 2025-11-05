package io.appmetrica.analytics.impl;

import java.util.HashMap;
/* loaded from: classes3.dex */
public final class Ah {

    /* renamed from: a  reason: collision with root package name */
    public final W5 f397a;
    public final boolean b;
    public final int c;
    public final HashMap d;
    public final Kh e;

    public Ah(W5 w5, boolean z, int i, HashMap hashMap, Kh kh) {
        this.f397a = w5;
        this.b = z;
        this.c = i;
        this.d = hashMap;
        this.e = kh;
    }

    public final String toString() {
        return "ReportToSend(report=" + this.f397a + ", serviceDataReporterType=" + this.c + ", environment=" + this.e + ", isCrashReport=" + this.b + ", trimmedFields=" + this.d + ')';
    }
}
