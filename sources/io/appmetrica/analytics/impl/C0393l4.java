package io.appmetrica.analytics.impl;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* renamed from: io.appmetrica.analytics.impl.l4  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0393l4 {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f1090a;
    public final boolean b;
    public final boolean c;
    public final boolean d;
    public final boolean e;
    public final Boolean f;

    public C0393l4(C0342j4 c0342j4) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        Boolean bool;
        z = c0342j4.f1055a;
        this.f1090a = z;
        z2 = c0342j4.b;
        this.b = z2;
        z3 = c0342j4.c;
        this.c = z3;
        z4 = c0342j4.d;
        this.d = z4;
        z5 = c0342j4.e;
        this.e = z5;
        bool = c0342j4.f;
        this.f = bool;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && C0393l4.class == obj.getClass()) {
            C0393l4 c0393l4 = (C0393l4) obj;
            if (this.f1090a != c0393l4.f1090a || this.b != c0393l4.b || this.c != c0393l4.c || this.d != c0393l4.d || this.e != c0393l4.e) {
                return false;
            }
            Boolean bool = this.f;
            Boolean bool2 = c0393l4.f;
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
        int i = (((((((((this.f1090a ? 1 : 0) * 31) + (this.b ? 1 : 0)) * 31) + (this.c ? 1 : 0)) * 31) + (this.d ? 1 : 0)) * 31) + (this.e ? 1 : 0)) * 31;
        Boolean bool = this.f;
        return i + (bool != null ? bool.hashCode() : 0);
    }

    public final String toString() {
        return "CollectingFlags{permissionsCollectingEnabled=" + this.f1090a + ", featuresCollectingEnabled=" + this.b + ", googleAid=" + this.c + ", simInfo=" + this.d + ", huaweiOaid=" + this.e + ", sslPinning=" + this.f + AbstractJsonLexerKt.END_OBJ;
    }
}
