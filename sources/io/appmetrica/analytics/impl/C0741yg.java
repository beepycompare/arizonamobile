package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.MessageNano;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* renamed from: io.appmetrica.analytics.impl.yg  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0741yg {

    /* renamed from: a  reason: collision with root package name */
    public final String f1146a;
    public final long b;
    public final long c;
    public final EnumC0716xg d;

    public C0741yg(byte[] bArr) {
        C0766zg a2 = C0766zg.a(bArr);
        this.f1146a = a2.f1167a;
        this.b = a2.c;
        this.c = a2.b;
        this.d = a(a2.d);
    }

    public final byte[] a() {
        C0766zg c0766zg = new C0766zg();
        c0766zg.f1167a = this.f1146a;
        c0766zg.c = this.b;
        c0766zg.b = this.c;
        int ordinal = this.d.ordinal();
        int i = 1;
        if (ordinal != 1) {
            i = 2;
            if (ordinal != 2) {
                i = 0;
            }
        }
        c0766zg.d = i;
        return MessageNano.toByteArray(c0766zg);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && C0741yg.class == obj.getClass()) {
            C0741yg c0741yg = (C0741yg) obj;
            if (this.b == c0741yg.b && this.c == c0741yg.c && this.f1146a.equals(c0741yg.f1146a) && this.d == c0741yg.d) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        long j = this.b;
        long j2 = this.c;
        return this.d.hashCode() + (((((this.f1146a.hashCode() * 31) + ((int) (j ^ (j >>> 32)))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31);
    }

    public final String toString() {
        return "ReferrerInfo{installReferrer='" + this.f1146a + "', referrerClickTimestampSeconds=" + this.b + ", installBeginTimestampSeconds=" + this.c + ", source=" + this.d + AbstractJsonLexerKt.END_OBJ;
    }

    public C0741yg(String str, long j, long j2, EnumC0716xg enumC0716xg) {
        this.f1146a = str;
        this.b = j;
        this.c = j2;
        this.d = enumC0716xg;
    }

    public static EnumC0716xg a(int i) {
        if (i != 1) {
            if (i != 2) {
                return EnumC0716xg.b;
            }
            return EnumC0716xg.d;
        }
        return EnumC0716xg.c;
    }
}
