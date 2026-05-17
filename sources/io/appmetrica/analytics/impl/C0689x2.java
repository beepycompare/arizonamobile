package io.appmetrica.analytics.impl;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* renamed from: io.appmetrica.analytics.impl.x2  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0689x2 {

    /* renamed from: a  reason: collision with root package name */
    public final EnumC0664w2 f1301a;
    public final Boolean b;

    public C0689x2(EnumC0664w2 enumC0664w2, Boolean bool) {
        this.f1301a = enumC0664w2;
        this.b = bool;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && C0689x2.class == obj.getClass()) {
            C0689x2 c0689x2 = (C0689x2) obj;
            if (this.f1301a != c0689x2.f1301a) {
                return false;
            }
            Boolean bool = this.b;
            if (bool != null) {
                return bool.equals(c0689x2.b);
            }
            if (c0689x2.b == null) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        EnumC0664w2 enumC0664w2 = this.f1301a;
        int hashCode = (enumC0664w2 != null ? enumC0664w2.hashCode() : 0) * 31;
        Boolean bool = this.b;
        return hashCode + (bool != null ? bool.hashCode() : 0);
    }

    public final String toString() {
        return "BackgroundRestrictionsState{mAppStandByBucket=" + this.f1301a + ", mBackgroundRestricted=" + this.b + AbstractJsonLexerKt.END_OBJ;
    }
}
