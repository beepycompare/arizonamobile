package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.internal.CounterConfigurationReporterType;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes4.dex */
public final class C0 {

    /* renamed from: a  reason: collision with root package name */
    public final String f362a;
    public final String b;
    public final CounterConfigurationReporterType c;
    public final int d;
    public final String e;
    public final String f;

    public C0(String str, String str2, CounterConfigurationReporterType counterConfigurationReporterType, int i, String str3, String str4) {
        this.f362a = str;
        this.b = str2;
        this.c = counterConfigurationReporterType;
        this.d = i;
        this.e = str3;
        this.f = str4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C0) {
            C0 c0 = (C0) obj;
            return Intrinsics.areEqual(this.f362a, c0.f362a) && Intrinsics.areEqual(this.b, c0.b) && this.c == c0.c && this.d == c0.d && Intrinsics.areEqual(this.e, c0.e) && Intrinsics.areEqual(this.f, c0.f);
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.b.hashCode();
        int hashCode2 = this.c.hashCode();
        int hashCode3 = (this.e.hashCode() + ((Integer.hashCode(this.d) + ((hashCode2 + ((hashCode + (this.f362a.hashCode() * 31)) * 31)) * 31)) * 31)) * 31;
        String str = this.f;
        return hashCode3 + (str == null ? 0 : str.hashCode());
    }

    public final String toString() {
        return "AppMetricaNativeCrashMetadata(apiKey=" + this.f362a + ", packageName=" + this.b + ", reporterType=" + this.c + ", processID=" + this.d + ", processSessionID=" + this.e + ", errorEnvironment=" + this.f + ')';
    }
}
