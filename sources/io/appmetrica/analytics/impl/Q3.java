package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.internal.CounterConfigurationReporterType;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* loaded from: classes5.dex */
public final class Q3 {

    /* renamed from: a  reason: collision with root package name */
    public final String f647a;
    public final String b;
    public final Integer c;
    public final String d;
    public final CounterConfigurationReporterType e;

    public Q3(String str, String str2, Integer num, String str3, CounterConfigurationReporterType counterConfigurationReporterType) {
        this.f647a = str;
        this.b = str2;
        this.c = num;
        this.d = str3;
        this.e = counterConfigurationReporterType;
    }

    public static Q3 a(I3 i3) {
        return new Q3(i3.b.getApiKey(), i3.f518a.f432a.getAsString("PROCESS_CFG_PACKAGE_NAME"), i3.f518a.f432a.getAsInteger("PROCESS_CFG_PROCESS_ID"), i3.f518a.f432a.getAsString("PROCESS_CFG_PROCESS_SESSION_ID"), i3.b.getReporterType());
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && Q3.class == obj.getClass()) {
            Q3 q3 = (Q3) obj;
            String str = this.f647a;
            if (str == null ? q3.f647a != null : !str.equals(q3.f647a)) {
                return false;
            }
            if (!this.b.equals(q3.b)) {
                return false;
            }
            Integer num = this.c;
            if (num == null ? q3.c != null : !num.equals(q3.c)) {
                return false;
            }
            String str2 = this.d;
            if (str2 == null ? q3.d != null : !str2.equals(q3.d)) {
                return false;
            }
            if (this.e == q3.e) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.f647a;
        int hashCode = (this.b.hashCode() + ((str != null ? str.hashCode() : 0) * 31)) * 31;
        Integer num = this.c;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 31;
        String str2 = this.d;
        return this.e.hashCode() + ((hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31);
    }

    public final String toString() {
        return "ClientDescription{mApiKey='" + this.f647a + "', mPackageName='" + this.b + "', mProcessID=" + this.c + ", mProcessSessionID='" + this.d + "', mReporterType=" + this.e + AbstractJsonLexerKt.END_OBJ;
    }
}
