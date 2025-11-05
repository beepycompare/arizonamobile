package io.appmetrica.analytics.impl;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* loaded from: classes3.dex */
public final class F2 {

    /* renamed from: a  reason: collision with root package name */
    public final E2 f470a;
    public final Boolean b;

    public F2(E2 e2, Boolean bool) {
        this.f470a = e2;
        this.b = bool;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && F2.class == obj.getClass()) {
            F2 f2 = (F2) obj;
            if (this.f470a != f2.f470a) {
                return false;
            }
            Boolean bool = this.b;
            if (bool != null) {
                return bool.equals(f2.b);
            }
            if (f2.b == null) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        E2 e2 = this.f470a;
        int hashCode = (e2 != null ? e2.hashCode() : 0) * 31;
        Boolean bool = this.b;
        return hashCode + (bool != null ? bool.hashCode() : 0);
    }

    public final String toString() {
        return "BackgroundRestrictionsState{mAppStandByBucket=" + this.f470a + ", mBackgroundRestricted=" + this.b + AbstractJsonLexerKt.END_OBJ;
    }
}
