package io.appmetrica.analytics.impl;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* loaded from: classes4.dex */
public final class G4 {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f437a;
    public final boolean b;
    public final boolean c;
    public final boolean d;
    public final boolean e;
    public final Boolean f;

    public G4(E4 e4) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        Boolean bool;
        z = e4.f400a;
        this.f437a = z;
        z2 = e4.b;
        this.b = z2;
        z3 = e4.c;
        this.c = z3;
        z4 = e4.d;
        this.d = z4;
        z5 = e4.e;
        this.e = z5;
        bool = e4.f;
        this.f = bool;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && G4.class == obj.getClass()) {
            G4 g4 = (G4) obj;
            if (this.f437a != g4.f437a || this.b != g4.b || this.c != g4.c || this.d != g4.d || this.e != g4.e) {
                return false;
            }
            Boolean bool = this.f;
            Boolean bool2 = g4.f;
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
        int i = (((((((((this.f437a ? 1 : 0) * 31) + (this.b ? 1 : 0)) * 31) + (this.c ? 1 : 0)) * 31) + (this.d ? 1 : 0)) * 31) + (this.e ? 1 : 0)) * 31;
        Boolean bool = this.f;
        return i + (bool != null ? bool.hashCode() : 0);
    }

    public final String toString() {
        return "CollectingFlags{permissionsCollectingEnabled=" + this.f437a + ", featuresCollectingEnabled=" + this.b + ", googleAid=" + this.c + ", simInfo=" + this.d + ", huaweiOaid=" + this.e + ", sslPinning=" + this.f + AbstractJsonLexerKt.END_OBJ;
    }
}
