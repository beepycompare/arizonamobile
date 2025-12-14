package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.i0  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0308i0 {

    /* renamed from: a  reason: collision with root package name */
    public final String f1028a;
    public final long b;

    public C0308i0(String str, long j) {
        this.f1028a = str;
        this.b = j;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && C0308i0.class == obj.getClass()) {
            C0308i0 c0308i0 = (C0308i0) obj;
            if (this.b != c0308i0.b) {
                return false;
            }
            String str = this.f1028a;
            String str2 = c0308i0.f1028a;
            if (str == null ? str2 == null : str.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.f1028a;
        int hashCode = str != null ? str.hashCode() : 0;
        long j = this.b;
        return (hashCode * 31) + ((int) (j ^ (j >>> 32)));
    }
}
