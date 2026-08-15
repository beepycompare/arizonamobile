package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.MessageNano;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* loaded from: classes5.dex */
public final class Bg {

    /* renamed from: a  reason: collision with root package name */
    public final String f480a;
    public final long b;
    public final long c;
    public final int d;

    public Bg(byte[] bArr) {
        Cg a2 = Cg.a(bArr);
        this.f480a = a2.f500a;
        this.b = a2.c;
        this.c = a2.b;
        this.d = a(a2.d);
    }

    public static int a(int i) {
        if (i != 1) {
            if (i != 2) {
                return i != 3 ? 1 : 4;
            }
            return 3;
        }
        return 2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && Bg.class == obj.getClass()) {
            Bg bg = (Bg) obj;
            if (this.b == bg.b && this.c == bg.c && this.f480a.equals(bg.f480a) && this.d == bg.d) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        long j = this.b;
        long j2 = this.c;
        return AbstractC0166c8.a(this.d) + (((((this.f480a.hashCode() * 31) + ((int) (j ^ (j >>> 32)))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31);
    }

    public final String toString() {
        return "ReferrerInfo{installReferrer='" + this.f480a + "', referrerClickTimestampSeconds=" + this.b + ", installBeginTimestampSeconds=" + this.c + ", source=" + Ag.b(this.d) + AbstractJsonLexerKt.END_OBJ;
    }

    public final byte[] a() {
        Cg cg = new Cg();
        cg.f500a = this.f480a;
        cg.c = this.b;
        cg.b = this.c;
        int a2 = AbstractC0166c8.a(this.d);
        int i = 1;
        if (a2 != 1) {
            i = 2;
            if (a2 != 2) {
                i = 3;
                if (a2 != 3) {
                    i = 0;
                }
            }
        }
        cg.d = i;
        return MessageNano.toByteArray(cg);
    }

    public Bg(String str, long j, long j2, int i) {
        this.f480a = str;
        this.b = j;
        this.c = j2;
        this.d = i;
    }
}
