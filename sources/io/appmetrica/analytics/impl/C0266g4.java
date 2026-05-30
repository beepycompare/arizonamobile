package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.internal.CounterConfigurationReporterType;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* renamed from: io.appmetrica.analytics.impl.g4  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0266g4 {

    /* renamed from: a  reason: collision with root package name */
    public final String f992a;
    public final String b;
    public final Integer c;
    public final String d;
    public final CounterConfigurationReporterType e;

    public C0266g4(String str, String str2, Integer num, String str3, CounterConfigurationReporterType counterConfigurationReporterType) {
        this.f992a = str;
        this.b = str2;
        this.c = num;
        this.d = str3;
        this.e = counterConfigurationReporterType;
    }

    public static C0266g4 a(Y3 y3) {
        return new C0266g4(y3.b.getApiKey(), y3.f850a.f928a.getAsString("PROCESS_CFG_PACKAGE_NAME"), y3.f850a.f928a.getAsInteger("PROCESS_CFG_PROCESS_ID"), y3.f850a.f928a.getAsString("PROCESS_CFG_PROCESS_SESSION_ID"), y3.b.getReporterType());
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && C0266g4.class == obj.getClass()) {
            C0266g4 c0266g4 = (C0266g4) obj;
            String str = this.f992a;
            if (str == null ? c0266g4.f992a != null : !str.equals(c0266g4.f992a)) {
                return false;
            }
            if (!this.b.equals(c0266g4.b)) {
                return false;
            }
            Integer num = this.c;
            if (num == null ? c0266g4.c != null : !num.equals(c0266g4.c)) {
                return false;
            }
            String str2 = this.d;
            if (str2 == null ? c0266g4.d != null : !str2.equals(c0266g4.d)) {
                return false;
            }
            if (this.e == c0266g4.e) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.f992a;
        int hashCode = (this.b.hashCode() + ((str != null ? str.hashCode() : 0) * 31)) * 31;
        Integer num = this.c;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 31;
        String str2 = this.d;
        return this.e.hashCode() + ((hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31);
    }

    public final String toString() {
        return "ClientDescription{mApiKey='" + this.f992a + "', mPackageName='" + this.b + "', mProcessID=" + this.c + ", mProcessSessionID='" + this.d + "', mReporterType=" + this.e + AbstractJsonLexerKt.END_OBJ;
    }
}
