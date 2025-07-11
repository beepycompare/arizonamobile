package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.MessageNano;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* renamed from: io.appmetrica.analytics.impl.yg  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0733yg {

    /* renamed from: a  reason: collision with root package name */
    public final String f1147a;
    public final long b;
    public final long c;
    public final EnumC0708xg d;

    public C0733yg(byte[] bArr) {
        C0758zg a2 = C0758zg.a(bArr);
        this.f1147a = a2.f1168a;
        this.b = a2.c;
        this.c = a2.b;
        this.d = a(a2.d);
    }

    public final byte[] a() {
        C0758zg c0758zg = new C0758zg();
        c0758zg.f1168a = this.f1147a;
        c0758zg.c = this.b;
        c0758zg.b = this.c;
        int ordinal = this.d.ordinal();
        int i = 1;
        if (ordinal != 1) {
            i = 2;
            if (ordinal != 2) {
                i = 0;
            }
        }
        c0758zg.d = i;
        return MessageNano.toByteArray(c0758zg);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && C0733yg.class == obj.getClass()) {
            C0733yg c0733yg = (C0733yg) obj;
            if (this.b == c0733yg.b && this.c == c0733yg.c && this.f1147a.equals(c0733yg.f1147a) && this.d == c0733yg.d) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        long j = this.b;
        long j2 = this.c;
        return this.d.hashCode() + (((((this.f1147a.hashCode() * 31) + ((int) (j ^ (j >>> 32)))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31);
    }

    public final String toString() {
        return "ReferrerInfo{installReferrer='" + this.f1147a + "', referrerClickTimestampSeconds=" + this.b + ", installBeginTimestampSeconds=" + this.c + ", source=" + this.d + AbstractJsonLexerKt.END_OBJ;
    }

    public C0733yg(String str, long j, long j2, EnumC0708xg enumC0708xg) {
        this.f1147a = str;
        this.b = j;
        this.c = j2;
        this.d = enumC0708xg;
    }

    public static EnumC0708xg a(int i) {
        if (i != 1) {
            if (i != 2) {
                return EnumC0708xg.b;
            }
            return EnumC0708xg.d;
        }
        return EnumC0708xg.c;
    }
}
