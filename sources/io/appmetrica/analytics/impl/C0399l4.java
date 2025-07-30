package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.internal.CounterConfigurationReporterType;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* renamed from: io.appmetrica.analytics.impl.l4  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0399l4 {

    /* renamed from: a  reason: collision with root package name */
    public final String f934a;
    public final String b;
    public final Integer c;
    public final String d;
    public final CounterConfigurationReporterType e;

    public C0399l4(String str, String str2, Integer num, String str3, CounterConfigurationReporterType counterConfigurationReporterType) {
        this.f934a = str;
        this.b = str2;
        this.c = num;
        this.d = str3;
        this.e = counterConfigurationReporterType;
    }

    public static C0399l4 a(C0198d4 c0198d4) {
        return new C0399l4(c0198d4.b.getApiKey(), c0198d4.f812a.f596a.getAsString("PROCESS_CFG_PACKAGE_NAME"), c0198d4.f812a.f596a.getAsInteger("PROCESS_CFG_PROCESS_ID"), c0198d4.f812a.f596a.getAsString("PROCESS_CFG_PROCESS_SESSION_ID"), c0198d4.b.getReporterType());
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && C0399l4.class == obj.getClass()) {
            C0399l4 c0399l4 = (C0399l4) obj;
            String str = this.f934a;
            if (str == null ? c0399l4.f934a != null : !str.equals(c0399l4.f934a)) {
                return false;
            }
            if (!this.b.equals(c0399l4.b)) {
                return false;
            }
            Integer num = this.c;
            if (num == null ? c0399l4.c != null : !num.equals(c0399l4.c)) {
                return false;
            }
            String str2 = this.d;
            if (str2 == null ? c0399l4.d != null : !str2.equals(c0399l4.d)) {
                return false;
            }
            if (this.e == c0399l4.e) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.f934a;
        int hashCode = (this.b.hashCode() + ((str != null ? str.hashCode() : 0) * 31)) * 31;
        Integer num = this.c;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 31;
        String str2 = this.d;
        return this.e.hashCode() + ((hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31);
    }

    public final String toString() {
        return "ClientDescription{mApiKey='" + this.f934a + "', mPackageName='" + this.b + "', mProcessID=" + this.c + ", mProcessSessionID='" + this.d + "', mReporterType=" + this.e + AbstractJsonLexerKt.END_OBJ;
    }
}
