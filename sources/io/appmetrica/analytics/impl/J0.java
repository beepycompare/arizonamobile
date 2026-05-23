package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.internal.CounterConfigurationReporterType;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class J0 {

    /* renamed from: a  reason: collision with root package name */
    public final String f601a;
    public final String b;
    public final CounterConfigurationReporterType c;
    public final int d;
    public final String e;
    public final String f;

    public J0(String str, String str2, CounterConfigurationReporterType counterConfigurationReporterType, int i, String str3, String str4) {
        this.f601a = str;
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
        if (obj instanceof J0) {
            J0 j0 = (J0) obj;
            return Intrinsics.areEqual(this.f601a, j0.f601a) && Intrinsics.areEqual(this.b, j0.b) && this.c == j0.c && this.d == j0.d && Intrinsics.areEqual(this.e, j0.e) && Intrinsics.areEqual(this.f, j0.f);
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.b.hashCode();
        int hashCode2 = this.c.hashCode();
        int hashCode3 = (this.e.hashCode() + ((Integer.hashCode(this.d) + ((hashCode2 + ((hashCode + (this.f601a.hashCode() * 31)) * 31)) * 31)) * 31)) * 31;
        String str = this.f;
        return hashCode3 + (str == null ? 0 : str.hashCode());
    }

    public final String toString() {
        return "AppMetricaNativeCrashMetadata(apiKey=" + this.f601a + ", packageName=" + this.b + ", reporterType=" + this.c + ", processID=" + this.d + ", processSessionID=" + this.e + ", errorEnvironment=" + this.f + ')';
    }
}
