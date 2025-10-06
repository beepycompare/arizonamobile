package io.appmetrica.analytics.impl;

import java.util.HashMap;
/* loaded from: classes4.dex */
public final class Rh {

    /* renamed from: a  reason: collision with root package name */
    public final C0478o6 f658a;
    public final boolean b;
    public final int c;
    public final HashMap d;
    public final C0154bi e;

    public Rh(C0478o6 c0478o6, boolean z, int i, HashMap hashMap, C0154bi c0154bi) {
        this.f658a = c0478o6;
        this.b = z;
        this.c = i;
        this.d = hashMap;
        this.e = c0154bi;
    }

    public final String toString() {
        return "ReportToSend(report=" + this.f658a + ", serviceDataReporterType=" + this.c + ", environment=" + this.e + ", isCrashReport=" + this.b + ", trimmedFields=" + this.d + ')';
    }
}
