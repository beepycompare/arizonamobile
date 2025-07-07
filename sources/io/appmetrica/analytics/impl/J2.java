package io.appmetrica.analytics.impl;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* loaded from: classes4.dex */
public final class J2 {

    /* renamed from: a  reason: collision with root package name */
    public final I2 f484a;
    public final Boolean b;

    public J2(I2 i2, Boolean bool) {
        this.f484a = i2;
        this.b = bool;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && J2.class == obj.getClass()) {
            J2 j2 = (J2) obj;
            if (this.f484a != j2.f484a) {
                return false;
            }
            Boolean bool = this.b;
            if (bool != null) {
                return bool.equals(j2.b);
            }
            if (j2.b == null) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        I2 i2 = this.f484a;
        int hashCode = (i2 != null ? i2.hashCode() : 0) * 31;
        Boolean bool = this.b;
        return hashCode + (bool != null ? bool.hashCode() : 0);
    }

    public final String toString() {
        return "BackgroundRestrictionsState{mAppStandByBucket=" + this.f484a + ", mBackgroundRestricted=" + this.b + AbstractJsonLexerKt.END_OBJ;
    }
}
