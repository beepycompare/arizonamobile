package io.appmetrica.analytics.adrevenue.other.impl;
/* loaded from: classes5.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f239a;
    public final boolean b;

    public e(boolean z, boolean z2) {
        this.f239a = z;
        this.b = z2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof e) {
            e eVar = (e) obj;
            return this.f239a == eVar.f239a && this.b == eVar.b;
        }
        return false;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.b) + (Boolean.hashCode(this.f239a) * 31);
    }

    public final String toString() {
        return "ClientSideAdRevenueOtherConfig(enabled=" + this.f239a + ", includeSource=" + this.b + ')';
    }
}
