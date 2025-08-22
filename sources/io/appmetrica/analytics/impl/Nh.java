package io.appmetrica.analytics.impl;

import java.util.HashMap;
/* loaded from: classes4.dex */
public final class Nh {

    /* renamed from: a  reason: collision with root package name */
    public final C0399l6 f580a;
    public final boolean b;
    public final int c;
    public final HashMap d;
    public final Xh e;

    public Nh(C0399l6 c0399l6, boolean z, int i, HashMap hashMap, Xh xh) {
        this.f580a = c0399l6;
        this.b = z;
        this.c = i;
        this.d = hashMap;
        this.e = xh;
    }

    public final String toString() {
        return "ReportToSend(report=" + this.f580a + ", serviceDataReporterType=" + this.c + ", environment=" + this.e + ", isCrashReport=" + this.b + ", trimmedFields=" + this.d + ')';
    }
}
