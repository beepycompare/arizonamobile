package io.appmetrica.analytics.impl;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* renamed from: io.appmetrica.analytics.impl.x2  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0690x2 {

    /* renamed from: a  reason: collision with root package name */
    public final EnumC0665w2 f1297a;
    public final Boolean b;

    public C0690x2(EnumC0665w2 enumC0665w2, Boolean bool) {
        this.f1297a = enumC0665w2;
        this.b = bool;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && C0690x2.class == obj.getClass()) {
            C0690x2 c0690x2 = (C0690x2) obj;
            if (this.f1297a != c0690x2.f1297a) {
                return false;
            }
            Boolean bool = this.b;
            if (bool != null) {
                return bool.equals(c0690x2.b);
            }
            if (c0690x2.b == null) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        EnumC0665w2 enumC0665w2 = this.f1297a;
        int hashCode = (enumC0665w2 != null ? enumC0665w2.hashCode() : 0) * 31;
        Boolean bool = this.b;
        return hashCode + (bool != null ? bool.hashCode() : 0);
    }

    public final String toString() {
        return "BackgroundRestrictionsState{mAppStandByBucket=" + this.f1297a + ", mBackgroundRestricted=" + this.b + AbstractJsonLexerKt.END_OBJ;
    }
}
