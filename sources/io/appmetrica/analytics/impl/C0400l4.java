package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.internal.CounterConfigurationReporterType;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* renamed from: io.appmetrica.analytics.impl.l4  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0400l4 {

    /* renamed from: a  reason: collision with root package name */
    public final String f933a;
    public final String b;
    public final Integer c;
    public final String d;
    public final CounterConfigurationReporterType e;

    public C0400l4(String str, String str2, Integer num, String str3, CounterConfigurationReporterType counterConfigurationReporterType) {
        this.f933a = str;
        this.b = str2;
        this.c = num;
        this.d = str3;
        this.e = counterConfigurationReporterType;
    }

    public static C0400l4 a(C0199d4 c0199d4) {
        return new C0400l4(c0199d4.b.getApiKey(), c0199d4.f811a.f595a.getAsString("PROCESS_CFG_PACKAGE_NAME"), c0199d4.f811a.f595a.getAsInteger("PROCESS_CFG_PROCESS_ID"), c0199d4.f811a.f595a.getAsString("PROCESS_CFG_PROCESS_SESSION_ID"), c0199d4.b.getReporterType());
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && C0400l4.class == obj.getClass()) {
            C0400l4 c0400l4 = (C0400l4) obj;
            String str = this.f933a;
            if (str == null ? c0400l4.f933a != null : !str.equals(c0400l4.f933a)) {
                return false;
            }
            if (!this.b.equals(c0400l4.b)) {
                return false;
            }
            Integer num = this.c;
            if (num == null ? c0400l4.c != null : !num.equals(c0400l4.c)) {
                return false;
            }
            String str2 = this.d;
            if (str2 == null ? c0400l4.d != null : !str2.equals(c0400l4.d)) {
                return false;
            }
            if (this.e == c0400l4.e) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.f933a;
        int hashCode = (this.b.hashCode() + ((str != null ? str.hashCode() : 0) * 31)) * 31;
        Integer num = this.c;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 31;
        String str2 = this.d;
        return this.e.hashCode() + ((hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31);
    }

    public final String toString() {
        return "ClientDescription{mApiKey='" + this.f933a + "', mPackageName='" + this.b + "', mProcessID=" + this.c + ", mProcessSessionID='" + this.d + "', mReporterType=" + this.e + AbstractJsonLexerKt.END_OBJ;
    }
}
