package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.g0  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0277g0 {

    /* renamed from: a  reason: collision with root package name */
    public final String f846a;
    public final long b;

    public C0277g0(String str, long j) {
        this.f846a = str;
        this.b = j;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && C0277g0.class == obj.getClass()) {
            C0277g0 c0277g0 = (C0277g0) obj;
            if (this.b != c0277g0.b) {
                return false;
            }
            String str = this.f846a;
            String str2 = c0277g0.f846a;
            if (str == null ? str2 == null : str.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.f846a;
        int hashCode = str != null ? str.hashCode() : 0;
        long j = this.b;
        return (hashCode * 31) + ((int) (j ^ (j >>> 32)));
    }
}
