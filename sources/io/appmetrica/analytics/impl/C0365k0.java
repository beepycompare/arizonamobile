package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.k0  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0365k0 {

    /* renamed from: a  reason: collision with root package name */
    public final String f1059a;
    public final long b;

    public C0365k0(String str, long j) {
        this.f1059a = str;
        this.b = j;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && C0365k0.class == obj.getClass()) {
            C0365k0 c0365k0 = (C0365k0) obj;
            if (this.b != c0365k0.b) {
                return false;
            }
            String str = this.f1059a;
            if (str == null ? c0365k0.f1059a == null : str.equals(c0365k0.f1059a)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.f1059a;
        int hashCode = str != null ? str.hashCode() : 0;
        long j = this.b;
        return (hashCode * 31) + ((int) (j ^ (j >>> 32)));
    }
}
