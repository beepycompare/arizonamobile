package io.appmetrica.analytics.impl;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* loaded from: classes4.dex */
public final class J4 {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f509a;
    public final boolean b;
    public final boolean c;
    public final boolean d;
    public final boolean e;
    public final Boolean f;

    public J4(H4 h4) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        Boolean bool;
        z = h4.f471a;
        this.f509a = z;
        z2 = h4.b;
        this.b = z2;
        z3 = h4.c;
        this.c = z3;
        z4 = h4.d;
        this.d = z4;
        z5 = h4.e;
        this.e = z5;
        bool = h4.f;
        this.f = bool;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && J4.class == obj.getClass()) {
            J4 j4 = (J4) obj;
            if (this.f509a != j4.f509a || this.b != j4.b || this.c != j4.c || this.d != j4.d || this.e != j4.e) {
                return false;
            }
            Boolean bool = this.f;
            Boolean bool2 = j4.f;
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
        int i = (((((((((this.f509a ? 1 : 0) * 31) + (this.b ? 1 : 0)) * 31) + (this.c ? 1 : 0)) * 31) + (this.d ? 1 : 0)) * 31) + (this.e ? 1 : 0)) * 31;
        Boolean bool = this.f;
        return i + (bool != null ? bool.hashCode() : 0);
    }

    public final String toString() {
        return "CollectingFlags{permissionsCollectingEnabled=" + this.f509a + ", featuresCollectingEnabled=" + this.b + ", googleAid=" + this.c + ", simInfo=" + this.d + ", huaweiOaid=" + this.e + ", sslPinning=" + this.f + AbstractJsonLexerKt.END_OBJ;
    }
}
