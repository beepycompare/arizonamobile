package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.MessageNano;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* loaded from: classes4.dex */
public final class Jg {

    /* renamed from: a  reason: collision with root package name */
    public final String f519a;
    public final long b;
    public final long c;
    public final Ig d;

    public Jg(byte[] bArr) {
        Kg a2 = Kg.a(bArr);
        this.f519a = a2.f540a;
        this.b = a2.c;
        this.c = a2.b;
        this.d = a(a2.d);
    }

    public final byte[] a() {
        Kg kg = new Kg();
        kg.f540a = this.f519a;
        kg.c = this.b;
        kg.b = this.c;
        int ordinal = this.d.ordinal();
        int i = 1;
        if (ordinal != 1) {
            i = 2;
            if (ordinal != 2) {
                i = 0;
            }
        }
        kg.d = i;
        return MessageNano.toByteArray(kg);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && Jg.class == obj.getClass()) {
            Jg jg = (Jg) obj;
            if (this.b == jg.b && this.c == jg.c && this.f519a.equals(jg.f519a) && this.d == jg.d) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        long j = this.b;
        long j2 = this.c;
        return this.d.hashCode() + (((((this.f519a.hashCode() * 31) + ((int) (j ^ (j >>> 32)))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31);
    }

    public final String toString() {
        return "ReferrerInfo{installReferrer='" + this.f519a + "', referrerClickTimestampSeconds=" + this.b + ", installBeginTimestampSeconds=" + this.c + ", source=" + this.d + AbstractJsonLexerKt.END_OBJ;
    }

    public Jg(String str, long j, long j2, Ig ig) {
        this.f519a = str;
        this.b = j;
        this.c = j2;
        this.d = ig;
    }

    public static Ig a(int i) {
        if (i != 1) {
            if (i != 2) {
                return Ig.b;
            }
            return Ig.d;
        }
        return Ig.c;
    }
}
