package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.internal.CounterConfigurationReporterType;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* loaded from: classes5.dex */
public final class P3 {

    /* renamed from: a  reason: collision with root package name */
    public final String f735a;
    public final String b;
    public final Integer c;
    public final String d;
    public final CounterConfigurationReporterType e;

    public P3(String str, String str2, Integer num, String str3, CounterConfigurationReporterType counterConfigurationReporterType) {
        this.f735a = str;
        this.b = str2;
        this.c = num;
        this.d = str3;
        this.e = counterConfigurationReporterType;
    }

    public static P3 a(H3 h3) {
        return new P3(h3.b.getApiKey(), h3.f607a.f520a.getAsString("PROCESS_CFG_PACKAGE_NAME"), h3.f607a.f520a.getAsInteger("PROCESS_CFG_PROCESS_ID"), h3.f607a.f520a.getAsString("PROCESS_CFG_PROCESS_SESSION_ID"), h3.b.getReporterType());
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && P3.class == obj.getClass()) {
            P3 p3 = (P3) obj;
            String str = this.f735a;
            if (str == null ? p3.f735a != null : !str.equals(p3.f735a)) {
                return false;
            }
            if (!this.b.equals(p3.b)) {
                return false;
            }
            Integer num = this.c;
            if (num == null ? p3.c != null : !num.equals(p3.c)) {
                return false;
            }
            String str2 = this.d;
            if (str2 == null ? p3.d != null : !str2.equals(p3.d)) {
                return false;
            }
            if (this.e == p3.e) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.f735a;
        int hashCode = (this.b.hashCode() + ((str != null ? str.hashCode() : 0) * 31)) * 31;
        Integer num = this.c;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 31;
        String str2 = this.d;
        return this.e.hashCode() + ((hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31);
    }

    public final String toString() {
        return "ClientDescription{mApiKey='" + this.f735a + "', mPackageName='" + this.b + "', mProcessID=" + this.c + ", mProcessSessionID='" + this.d + "', mReporterType=" + this.e + AbstractJsonLexerKt.END_OBJ;
    }
}
