package io.appmetrica.analytics.impl;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* renamed from: io.appmetrica.analytics.impl.y2  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0712y2 {

    /* renamed from: a  reason: collision with root package name */
    public final EnumC0687x2 f1209a;
    public final Boolean b;

    public C0712y2(EnumC0687x2 enumC0687x2, Boolean bool) {
        this.f1209a = enumC0687x2;
        this.b = bool;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && C0712y2.class == obj.getClass()) {
            C0712y2 c0712y2 = (C0712y2) obj;
            if (this.f1209a != c0712y2.f1209a) {
                return false;
            }
            Boolean bool = this.b;
            if (bool != null) {
                return bool.equals(c0712y2.b);
            }
            if (c0712y2.b == null) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        EnumC0687x2 enumC0687x2 = this.f1209a;
        int hashCode = (enumC0687x2 != null ? enumC0687x2.hashCode() : 0) * 31;
        Boolean bool = this.b;
        return hashCode + (bool != null ? bool.hashCode() : 0);
    }

    public final String toString() {
        return "BackgroundRestrictionsState{mAppStandByBucket=" + this.f1209a + ", mBackgroundRestricted=" + this.b + AbstractJsonLexerKt.END_OBJ;
    }
}
