package io.appmetrica.analytics.adrevenue.other.impl;
/* loaded from: classes5.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f237a;
    public final boolean b;

    public e(boolean z, boolean z2) {
        this.f237a = z;
        this.b = z2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof e) {
            e eVar = (e) obj;
            return this.f237a == eVar.f237a && this.b == eVar.b;
        }
        return false;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.b) + (Boolean.hashCode(this.f237a) * 31);
    }

    public final String toString() {
        return "ClientSideAdRevenueOtherConfig(enabled=" + this.f237a + ", includeSource=" + this.b + ')';
    }
}
