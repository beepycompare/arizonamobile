package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.v4  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0648v4 {

    /* renamed from: a  reason: collision with root package name */
    public final String f1095a;
    public final Integer b;
    public final String c;

    public C0648v4(String str, Integer num, String str2) {
        this.f1095a = str;
        this.b = num;
        this.c = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && C0648v4.class == obj.getClass()) {
            C0648v4 c0648v4 = (C0648v4) obj;
            if (!this.f1095a.equals(c0648v4.f1095a)) {
                return false;
            }
            Integer num = this.b;
            if (num == null ? c0648v4.b != null : !num.equals(c0648v4.b)) {
                return false;
            }
            String str = this.c;
            String str2 = c0648v4.c;
            if (str != null) {
                return str.equals(str2);
            }
            if (str2 == null) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.f1095a.hashCode() * 31;
        Integer num = this.b;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 31;
        String str = this.c;
        return hashCode2 + (str != null ? str.hashCode() : 0);
    }
}
