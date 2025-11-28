package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.MessageNano;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* renamed from: io.appmetrica.analytics.impl.sg  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0576sg {

    /* renamed from: a  reason: collision with root package name */
    public final String f1114a;
    public final long b;
    public final long c;
    public final EnumC0551rg d;

    public C0576sg(byte[] bArr) {
        C0601tg a2 = C0601tg.a(bArr);
        this.f1114a = a2.f1134a;
        this.b = a2.c;
        this.c = a2.b;
        this.d = a(a2.d);
    }

    public final byte[] a() {
        C0601tg c0601tg = new C0601tg();
        c0601tg.f1134a = this.f1114a;
        c0601tg.c = this.b;
        c0601tg.b = this.c;
        int ordinal = this.d.ordinal();
        int i = 1;
        if (ordinal != 1) {
            i = 2;
            if (ordinal != 2) {
                i = 0;
            }
        }
        c0601tg.d = i;
        return MessageNano.toByteArray(c0601tg);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && C0576sg.class == obj.getClass()) {
            C0576sg c0576sg = (C0576sg) obj;
            if (this.b == c0576sg.b && this.c == c0576sg.c && this.f1114a.equals(c0576sg.f1114a) && this.d == c0576sg.d) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        long j = this.b;
        long j2 = this.c;
        return this.d.hashCode() + (((((this.f1114a.hashCode() * 31) + ((int) (j ^ (j >>> 32)))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31);
    }

    public final String toString() {
        return "ReferrerInfo{installReferrer='" + this.f1114a + "', referrerClickTimestampSeconds=" + this.b + ", installBeginTimestampSeconds=" + this.c + ", source=" + this.d + AbstractJsonLexerKt.END_OBJ;
    }

    public C0576sg(String str, long j, long j2, EnumC0551rg enumC0551rg) {
        this.f1114a = str;
        this.b = j;
        this.c = j2;
        this.d = enumC0551rg;
    }

    public static EnumC0551rg a(int i) {
        if (i != 1) {
            if (i != 2) {
                return EnumC0551rg.b;
            }
            return EnumC0551rg.d;
        }
        return EnumC0551rg.c;
    }
}
