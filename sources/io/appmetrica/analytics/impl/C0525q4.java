package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.q4  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0525q4 {

    /* renamed from: a  reason: collision with root package name */
    public final String f1159a;
    public final Integer b;
    public final String c;

    public C0525q4(String str, Integer num, String str2) {
        this.f1159a = str;
        this.b = num;
        this.c = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && C0525q4.class == obj.getClass()) {
            C0525q4 c0525q4 = (C0525q4) obj;
            if (!this.f1159a.equals(c0525q4.f1159a)) {
                return false;
            }
            Integer num = this.b;
            if (num == null ? c0525q4.b != null : !num.equals(c0525q4.b)) {
                return false;
            }
            String str = this.c;
            if (str != null) {
                return str.equals(c0525q4.c);
            }
            if (c0525q4.c == null) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.f1159a.hashCode() * 31;
        Integer num = this.b;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 31;
        String str = this.c;
        return hashCode2 + (str != null ? str.hashCode() : 0);
    }
}
