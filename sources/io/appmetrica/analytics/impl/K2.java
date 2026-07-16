package io.appmetrica.analytics.impl;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* loaded from: classes5.dex */
public final class K2 {

    /* renamed from: a  reason: collision with root package name */
    public final J2 f625a;
    public final Boolean b;

    public K2(J2 j2, Boolean bool) {
        this.f625a = j2;
        this.b = bool;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && K2.class == obj.getClass()) {
            K2 k2 = (K2) obj;
            if (this.f625a != k2.f625a) {
                return false;
            }
            Boolean bool = this.b;
            if (bool != null) {
                return bool.equals(k2.b);
            }
            if (k2.b == null) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        J2 j2 = this.f625a;
        int hashCode = (j2 != null ? j2.hashCode() : 0) * 31;
        Boolean bool = this.b;
        return hashCode + (bool != null ? bool.hashCode() : 0);
    }

    public final String toString() {
        return "BackgroundRestrictionsState{mAppStandByBucket=" + this.f625a + ", mBackgroundRestricted=" + this.b + AbstractJsonLexerKt.END_OBJ;
    }
}
