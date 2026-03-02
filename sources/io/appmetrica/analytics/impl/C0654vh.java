package io.appmetrica.analytics.impl;

import java.util.HashMap;
/* renamed from: io.appmetrica.analytics.impl.vh  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0654vh {

    /* renamed from: a  reason: collision with root package name */
    public final P5 f1272a;
    public final boolean b;
    public final int c;
    public final HashMap d;
    public final Fh e;

    public C0654vh(P5 p5, boolean z, int i, HashMap hashMap, Fh fh) {
        this.f1272a = p5;
        this.b = z;
        this.c = i;
        this.d = hashMap;
        this.e = fh;
    }

    public final String toString() {
        return "ReportToSend(report=" + this.f1272a + ", serviceDataReporterType=" + this.c + ", environment=" + this.e + ", isCrashReport=" + this.b + ", trimmedFields=" + this.d + ')';
    }
}
