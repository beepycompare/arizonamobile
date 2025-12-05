package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.MessageNano;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* renamed from: io.appmetrica.analytics.impl.og  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0476og {

    /* renamed from: a  reason: collision with root package name */
    public final String f1133a;
    public final long b;
    public final long c;
    public final EnumC0451ng d;

    public C0476og(byte[] bArr) {
        C0501pg a2 = C0501pg.a(bArr);
        this.f1133a = a2.f1152a;
        this.b = a2.c;
        this.c = a2.b;
        this.d = a(a2.d);
    }

    public final byte[] a() {
        C0501pg c0501pg = new C0501pg();
        c0501pg.f1152a = this.f1133a;
        c0501pg.c = this.b;
        c0501pg.b = this.c;
        int ordinal = this.d.ordinal();
        int i = 1;
        if (ordinal != 1) {
            i = 2;
            if (ordinal != 2) {
                i = 0;
            }
        }
        c0501pg.d = i;
        return MessageNano.toByteArray(c0501pg);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && C0476og.class == obj.getClass()) {
            C0476og c0476og = (C0476og) obj;
            if (this.b == c0476og.b && this.c == c0476og.c && this.f1133a.equals(c0476og.f1133a) && this.d == c0476og.d) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        long j = this.b;
        long j2 = this.c;
        return this.d.hashCode() + (((((this.f1133a.hashCode() * 31) + ((int) (j ^ (j >>> 32)))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31);
    }

    public final String toString() {
        return "ReferrerInfo{installReferrer='" + this.f1133a + "', referrerClickTimestampSeconds=" + this.b + ", installBeginTimestampSeconds=" + this.c + ", source=" + this.d + AbstractJsonLexerKt.END_OBJ;
    }

    public C0476og(String str, long j, long j2, EnumC0451ng enumC0451ng) {
        this.f1133a = str;
        this.b = j;
        this.c = j2;
        this.d = enumC0451ng;
    }

    public static EnumC0451ng a(int i) {
        if (i != 1) {
            if (i != 2) {
                return EnumC0451ng.b;
            }
            return EnumC0451ng.d;
        }
        return EnumC0451ng.c;
    }
}
