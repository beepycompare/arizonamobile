package io.appmetrica.analytics.impl;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* renamed from: io.appmetrica.analytics.impl.l4  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0392l4 {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f1095a;
    public final boolean b;
    public final boolean c;
    public final boolean d;
    public final boolean e;
    public final Boolean f;

    public C0392l4(C0341j4 c0341j4) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        Boolean bool;
        z = c0341j4.f1060a;
        this.f1095a = z;
        z2 = c0341j4.b;
        this.b = z2;
        z3 = c0341j4.c;
        this.c = z3;
        z4 = c0341j4.d;
        this.d = z4;
        z5 = c0341j4.e;
        this.e = z5;
        bool = c0341j4.f;
        this.f = bool;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && C0392l4.class == obj.getClass()) {
            C0392l4 c0392l4 = (C0392l4) obj;
            if (this.f1095a != c0392l4.f1095a || this.b != c0392l4.b || this.c != c0392l4.c || this.d != c0392l4.d || this.e != c0392l4.e) {
                return false;
            }
            Boolean bool = this.f;
            if (bool != null) {
                return bool.equals(c0392l4.f);
            }
            if (c0392l4.f == null) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = (((((((((this.f1095a ? 1 : 0) * 31) + (this.b ? 1 : 0)) * 31) + (this.c ? 1 : 0)) * 31) + (this.d ? 1 : 0)) * 31) + (this.e ? 1 : 0)) * 31;
        Boolean bool = this.f;
        return i + (bool != null ? bool.hashCode() : 0);
    }

    public final String toString() {
        return "CollectingFlags{permissionsCollectingEnabled=" + this.f1095a + ", featuresCollectingEnabled=" + this.b + ", googleAid=" + this.c + ", simInfo=" + this.d + ", huaweiOaid=" + this.e + ", sslPinning=" + this.f + AbstractJsonLexerKt.END_OBJ;
    }
}
