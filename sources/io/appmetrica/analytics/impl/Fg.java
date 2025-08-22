package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.MessageNano;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* loaded from: classes4.dex */
public final class Fg {

    /* renamed from: a  reason: collision with root package name */
    public final String f436a;
    public final long b;
    public final long c;
    public final Eg d;

    public Fg(byte[] bArr) {
        Gg a2 = Gg.a(bArr);
        this.f436a = a2.f458a;
        this.b = a2.c;
        this.c = a2.b;
        this.d = a(a2.d);
    }

    public final byte[] a() {
        Gg gg = new Gg();
        gg.f458a = this.f436a;
        gg.c = this.b;
        gg.b = this.c;
        int ordinal = this.d.ordinal();
        int i = 1;
        if (ordinal != 1) {
            i = 2;
            if (ordinal != 2) {
                i = 0;
            }
        }
        gg.d = i;
        return MessageNano.toByteArray(gg);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && Fg.class == obj.getClass()) {
            Fg fg = (Fg) obj;
            if (this.b == fg.b && this.c == fg.c && this.f436a.equals(fg.f436a) && this.d == fg.d) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        long j = this.b;
        long j2 = this.c;
        return this.d.hashCode() + (((((this.f436a.hashCode() * 31) + ((int) (j ^ (j >>> 32)))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31);
    }

    public final String toString() {
        return "ReferrerInfo{installReferrer='" + this.f436a + "', referrerClickTimestampSeconds=" + this.b + ", installBeginTimestampSeconds=" + this.c + ", source=" + this.d + AbstractJsonLexerKt.END_OBJ;
    }

    public Fg(String str, long j, long j2, Eg eg) {
        this.f436a = str;
        this.b = j;
        this.c = j2;
        this.d = eg;
    }

    public static Eg a(int i) {
        if (i != 1) {
            if (i != 2) {
                return Eg.b;
            }
            return Eg.d;
        }
        return Eg.c;
    }
}
