package io.appmetrica.analytics.impl;

import java.util.HashMap;
/* loaded from: classes4.dex */
public final class Ih {

    /* renamed from: a  reason: collision with root package name */
    public final C0401l6 f492a;
    public final boolean b;
    public final int c;
    public final HashMap d;
    public final Sh e;

    public Ih(C0401l6 c0401l6, boolean z, int i, HashMap hashMap, Sh sh) {
        this.f492a = c0401l6;
        this.b = z;
        this.c = i;
        this.d = hashMap;
        this.e = sh;
    }

    public final String toString() {
        return "ReportToSend(report=" + this.f492a + ", serviceDataReporterType=" + this.c + ", environment=" + this.e + ", isCrashReport=" + this.b + ", trimmedFields=" + this.d + ')';
    }
}
