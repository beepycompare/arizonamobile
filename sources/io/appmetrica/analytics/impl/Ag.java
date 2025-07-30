package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.MessageNano;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* loaded from: classes4.dex */
public final class Ag {

    /* renamed from: a  reason: collision with root package name */
    public final String f340a;
    public final long b;
    public final long c;
    public final EnumC0760zg d;

    public Ag(byte[] bArr) {
        Bg a2 = Bg.a(bArr);
        this.f340a = a2.f360a;
        this.b = a2.c;
        this.c = a2.b;
        this.d = a(a2.d);
    }

    public final byte[] a() {
        Bg bg = new Bg();
        bg.f360a = this.f340a;
        bg.c = this.b;
        bg.b = this.c;
        int ordinal = this.d.ordinal();
        int i = 1;
        if (ordinal != 1) {
            i = 2;
            if (ordinal != 2) {
                i = 0;
            }
        }
        bg.d = i;
        return MessageNano.toByteArray(bg);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && Ag.class == obj.getClass()) {
            Ag ag = (Ag) obj;
            if (this.b == ag.b && this.c == ag.c && this.f340a.equals(ag.f340a) && this.d == ag.d) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        long j = this.b;
        long j2 = this.c;
        return this.d.hashCode() + (((((this.f340a.hashCode() * 31) + ((int) (j ^ (j >>> 32)))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31);
    }

    public final String toString() {
        return "ReferrerInfo{installReferrer='" + this.f340a + "', referrerClickTimestampSeconds=" + this.b + ", installBeginTimestampSeconds=" + this.c + ", source=" + this.d + AbstractJsonLexerKt.END_OBJ;
    }

    public Ag(String str, long j, long j2, EnumC0760zg enumC0760zg) {
        this.f340a = str;
        this.b = j;
        this.c = j2;
        this.d = enumC0760zg;
    }

    public static EnumC0760zg a(int i) {
        if (i != 1) {
            if (i != 2) {
                return EnumC0760zg.b;
            }
            return EnumC0760zg.d;
        }
        return EnumC0760zg.c;
    }
}
