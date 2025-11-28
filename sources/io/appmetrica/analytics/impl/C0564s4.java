package io.appmetrica.analytics.impl;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* renamed from: io.appmetrica.analytics.impl.s4  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0564s4 {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f1105a;
    public final boolean b;
    public final boolean c;
    public final boolean d;
    public final boolean e;
    public final Boolean f;

    public C0564s4(C0515q4 c0515q4) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        Boolean bool;
        z = c0515q4.f1065a;
        this.f1105a = z;
        z2 = c0515q4.b;
        this.b = z2;
        z3 = c0515q4.c;
        this.c = z3;
        z4 = c0515q4.d;
        this.d = z4;
        z5 = c0515q4.e;
        this.e = z5;
        bool = c0515q4.f;
        this.f = bool;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && C0564s4.class == obj.getClass()) {
            C0564s4 c0564s4 = (C0564s4) obj;
            if (this.f1105a != c0564s4.f1105a || this.b != c0564s4.b || this.c != c0564s4.c || this.d != c0564s4.d || this.e != c0564s4.e) {
                return false;
            }
            Boolean bool = this.f;
            Boolean bool2 = c0564s4.f;
            if (bool != null) {
                return bool.equals(bool2);
            }
            if (bool2 == null) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = (((((((((this.f1105a ? 1 : 0) * 31) + (this.b ? 1 : 0)) * 31) + (this.c ? 1 : 0)) * 31) + (this.d ? 1 : 0)) * 31) + (this.e ? 1 : 0)) * 31;
        Boolean bool = this.f;
        return i + (bool != null ? bool.hashCode() : 0);
    }

    public final String toString() {
        return "CollectingFlags{permissionsCollectingEnabled=" + this.f1105a + ", featuresCollectingEnabled=" + this.b + ", googleAid=" + this.c + ", simInfo=" + this.d + ", huaweiOaid=" + this.e + ", sslPinning=" + this.f + AbstractJsonLexerKt.END_OBJ;
    }
}
