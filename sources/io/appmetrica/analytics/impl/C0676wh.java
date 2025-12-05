package io.appmetrica.analytics.impl;

import java.util.HashMap;
/* renamed from: io.appmetrica.analytics.impl.wh  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0676wh {

    /* renamed from: a  reason: collision with root package name */
    public final Q5 f1267a;
    public final boolean b;
    public final int c;
    public final HashMap d;
    public final Gh e;

    public C0676wh(Q5 q5, boolean z, int i, HashMap hashMap, Gh gh) {
        this.f1267a = q5;
        this.b = z;
        this.c = i;
        this.d = hashMap;
        this.e = gh;
    }

    public final String toString() {
        return "ReportToSend(report=" + this.f1267a + ", serviceDataReporterType=" + this.c + ", environment=" + this.e + ", isCrashReport=" + this.b + ", trimmedFields=" + this.d + ')';
    }
}
