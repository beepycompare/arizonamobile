package io.appmetrica.analytics.impl;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* renamed from: io.appmetrica.analytics.impl.y2  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0711y2 {

    /* renamed from: a  reason: collision with root package name */
    public final EnumC0686x2 f1307a;
    public final Boolean b;

    public C0711y2(EnumC0686x2 enumC0686x2, Boolean bool) {
        this.f1307a = enumC0686x2;
        this.b = bool;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && C0711y2.class == obj.getClass()) {
            C0711y2 c0711y2 = (C0711y2) obj;
            if (this.f1307a != c0711y2.f1307a) {
                return false;
            }
            Boolean bool = this.b;
            if (bool != null) {
                return bool.equals(c0711y2.b);
            }
            if (c0711y2.b == null) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        EnumC0686x2 enumC0686x2 = this.f1307a;
        int hashCode = (enumC0686x2 != null ? enumC0686x2.hashCode() : 0) * 31;
        Boolean bool = this.b;
        return hashCode + (bool != null ? bool.hashCode() : 0);
    }

    public final String toString() {
        return "BackgroundRestrictionsState{mAppStandByBucket=" + this.f1307a + ", mBackgroundRestricted=" + this.b + AbstractJsonLexerKt.END_OBJ;
    }
}
