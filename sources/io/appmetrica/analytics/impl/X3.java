package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.internal.CounterConfigurationReporterType;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* loaded from: classes5.dex */
public final class X3 {

    /* renamed from: a  reason: collision with root package name */
    public final String f751a;
    public final String b;
    public final Integer c;
    public final String d;
    public final CounterConfigurationReporterType e;

    public X3(String str, String str2, Integer num, String str3, CounterConfigurationReporterType counterConfigurationReporterType) {
        this.f751a = str;
        this.b = str2;
        this.c = num;
        this.d = str3;
        this.e = counterConfigurationReporterType;
    }

    public static X3 a(P3 p3) {
        return new X3(p3.b.getApiKey(), p3.f629a.f492a.getAsString("PROCESS_CFG_PACKAGE_NAME"), p3.f629a.f492a.getAsInteger("PROCESS_CFG_PROCESS_ID"), p3.f629a.f492a.getAsString("PROCESS_CFG_PROCESS_SESSION_ID"), p3.b.getReporterType());
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && X3.class == obj.getClass()) {
            X3 x3 = (X3) obj;
            String str = this.f751a;
            if (str == null ? x3.f751a != null : !str.equals(x3.f751a)) {
                return false;
            }
            if (!this.b.equals(x3.b)) {
                return false;
            }
            Integer num = this.c;
            if (num == null ? x3.c != null : !num.equals(x3.c)) {
                return false;
            }
            String str2 = this.d;
            if (str2 == null ? x3.d != null : !str2.equals(x3.d)) {
                return false;
            }
            if (this.e == x3.e) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.f751a;
        int hashCode = (this.b.hashCode() + ((str != null ? str.hashCode() : 0) * 31)) * 31;
        Integer num = this.c;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 31;
        String str2 = this.d;
        return this.e.hashCode() + ((hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31);
    }

    public final String toString() {
        return "ClientDescription{mApiKey='" + this.f751a + "', mPackageName='" + this.b + "', mProcessID=" + this.c + ", mProcessSessionID='" + this.d + "', mReporterType=" + this.e + AbstractJsonLexerKt.END_OBJ;
    }
}
