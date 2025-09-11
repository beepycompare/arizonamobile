package io.appmetrica.analytics.impl;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* loaded from: classes4.dex */
public final class M2 {

    /* renamed from: a  reason: collision with root package name */
    public final L2 f569a;
    public final Boolean b;

    public M2(L2 l2, Boolean bool) {
        this.f569a = l2;
        this.b = bool;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && M2.class == obj.getClass()) {
            M2 m2 = (M2) obj;
            if (this.f569a != m2.f569a) {
                return false;
            }
            Boolean bool = this.b;
            if (bool != null) {
                return bool.equals(m2.b);
            }
            if (m2.b == null) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        L2 l2 = this.f569a;
        int hashCode = (l2 != null ? l2.hashCode() : 0) * 31;
        Boolean bool = this.b;
        return hashCode + (bool != null ? bool.hashCode() : 0);
    }

    public final String toString() {
        return "BackgroundRestrictionsState{mAppStandByBucket=" + this.f569a + ", mBackgroundRestricted=" + this.b + AbstractJsonLexerKt.END_OBJ;
    }
}
