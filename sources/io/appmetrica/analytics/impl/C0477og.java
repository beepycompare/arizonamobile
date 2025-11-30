package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.MessageNano;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* renamed from: io.appmetrica.analytics.impl.og  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0477og {

    /* renamed from: a  reason: collision with root package name */
    public final String f1050a;
    public final long b;
    public final long c;
    public final EnumC0452ng d;

    public C0477og(byte[] bArr) {
        C0502pg a2 = C0502pg.a(bArr);
        this.f1050a = a2.f1069a;
        this.b = a2.c;
        this.c = a2.b;
        this.d = a(a2.d);
    }

    public final byte[] a() {
        C0502pg c0502pg = new C0502pg();
        c0502pg.f1069a = this.f1050a;
        c0502pg.c = this.b;
        c0502pg.b = this.c;
        int ordinal = this.d.ordinal();
        int i = 1;
        if (ordinal != 1) {
            i = 2;
            if (ordinal != 2) {
                i = 0;
            }
        }
        c0502pg.d = i;
        return MessageNano.toByteArray(c0502pg);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && C0477og.class == obj.getClass()) {
            C0477og c0477og = (C0477og) obj;
            if (this.b == c0477og.b && this.c == c0477og.c && this.f1050a.equals(c0477og.f1050a) && this.d == c0477og.d) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        long j = this.b;
        long j2 = this.c;
        return this.d.hashCode() + (((((this.f1050a.hashCode() * 31) + ((int) (j ^ (j >>> 32)))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31);
    }

    public final String toString() {
        return "ReferrerInfo{installReferrer='" + this.f1050a + "', referrerClickTimestampSeconds=" + this.b + ", installBeginTimestampSeconds=" + this.c + ", source=" + this.d + AbstractJsonLexerKt.END_OBJ;
    }

    public C0477og(String str, long j, long j2, EnumC0452ng enumC0452ng) {
        this.f1050a = str;
        this.b = j;
        this.c = j2;
        this.d = enumC0452ng;
    }

    public static EnumC0452ng a(int i) {
        if (i != 1) {
            if (i != 2) {
                return EnumC0452ng.b;
            }
            return EnumC0452ng.d;
        }
        return EnumC0452ng.c;
    }
}
