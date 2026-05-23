package io.appmetrica.analytics.adrevenue.other.impl;
/* loaded from: classes5.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f236a;
    public final boolean b;

    public e(boolean z, boolean z2) {
        this.f236a = z;
        this.b = z2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof e) {
            e eVar = (e) obj;
            return this.f236a == eVar.f236a && this.b == eVar.b;
        }
        return false;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.b) + (Boolean.hashCode(this.f236a) * 31);
    }

    public final String toString() {
        return "ClientSideAdRevenueOtherConfig(enabled=" + this.f236a + ", includeSource=" + this.b + ')';
    }
}
