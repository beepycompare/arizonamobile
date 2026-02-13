package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.MessageNano;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* renamed from: io.appmetrica.analytics.impl.ng  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0455ng {

    /* renamed from: a  reason: collision with root package name */
    public final String f1137a;
    public final long b;
    public final long c;
    public final EnumC0430mg d;

    public C0455ng(byte[] bArr) {
        C0480og a2 = C0480og.a(bArr);
        this.f1137a = a2.f1156a;
        this.b = a2.c;
        this.c = a2.b;
        this.d = a(a2.d);
    }

    public final byte[] a() {
        C0480og c0480og = new C0480og();
        c0480og.f1156a = this.f1137a;
        c0480og.c = this.b;
        c0480og.b = this.c;
        int ordinal = this.d.ordinal();
        int i = 1;
        if (ordinal != 1) {
            i = 2;
            if (ordinal != 2) {
                i = 0;
            }
        }
        c0480og.d = i;
        return MessageNano.toByteArray(c0480og);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && C0455ng.class == obj.getClass()) {
            C0455ng c0455ng = (C0455ng) obj;
            if (this.b == c0455ng.b && this.c == c0455ng.c && this.f1137a.equals(c0455ng.f1137a) && this.d == c0455ng.d) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        long j = this.b;
        long j2 = this.c;
        return this.d.hashCode() + (((((this.f1137a.hashCode() * 31) + ((int) (j ^ (j >>> 32)))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31);
    }

    public final String toString() {
        return "ReferrerInfo{installReferrer='" + this.f1137a + "', referrerClickTimestampSeconds=" + this.b + ", installBeginTimestampSeconds=" + this.c + ", source=" + this.d + AbstractJsonLexerKt.END_OBJ;
    }

    public C0455ng(String str, long j, long j2, EnumC0430mg enumC0430mg) {
        this.f1137a = str;
        this.b = j;
        this.c = j2;
        this.d = enumC0430mg;
    }

    public static EnumC0430mg a(int i) {
        if (i != 1) {
            if (i != 2) {
                return EnumC0430mg.b;
            }
            return EnumC0430mg.d;
        }
        return EnumC0430mg.c;
    }
}
