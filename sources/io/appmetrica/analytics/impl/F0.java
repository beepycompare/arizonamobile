package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.internal.CounterConfigurationReporterType;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes3.dex */
public final class F0 {

    /* renamed from: a  reason: collision with root package name */
    public final String f468a;
    public final String b;
    public final CounterConfigurationReporterType c;
    public final int d;
    public final String e;
    public final String f;

    public F0(String str, String str2, CounterConfigurationReporterType counterConfigurationReporterType, int i, String str3, String str4) {
        this.f468a = str;
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
        if (obj instanceof F0) {
            F0 f0 = (F0) obj;
            return Intrinsics.areEqual(this.f468a, f0.f468a) && Intrinsics.areEqual(this.b, f0.b) && this.c == f0.c && this.d == f0.d && Intrinsics.areEqual(this.e, f0.e) && Intrinsics.areEqual(this.f, f0.f);
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.b.hashCode();
        int hashCode2 = this.c.hashCode();
        int hashCode3 = (this.e.hashCode() + ((Integer.hashCode(this.d) + ((hashCode2 + ((hashCode + (this.f468a.hashCode() * 31)) * 31)) * 31)) * 31)) * 31;
        String str = this.f;
        return hashCode3 + (str == null ? 0 : str.hashCode());
    }

    public final String toString() {
        return "AppMetricaNativeCrashMetadata(apiKey=" + this.f468a + ", packageName=" + this.b + ", reporterType=" + this.c + ", processID=" + this.d + ", processSessionID=" + this.e + ", errorEnvironment=" + this.f + ')';
    }
}
