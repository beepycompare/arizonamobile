package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.g0  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0272g0 {

    /* renamed from: a  reason: collision with root package name */
    public final String f855a;
    public final long b;

    public C0272g0(String str, long j) {
        this.f855a = str;
        this.b = j;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && C0272g0.class == obj.getClass()) {
            C0272g0 c0272g0 = (C0272g0) obj;
            if (this.b != c0272g0.b) {
                return false;
            }
            String str = this.f855a;
            String str2 = c0272g0.f855a;
            if (str == null ? str2 == null : str.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.f855a;
        int hashCode = str != null ? str.hashCode() : 0;
        long j = this.b;
        return (hashCode * 31) + ((int) (j ^ (j >>> 32)));
    }
}
