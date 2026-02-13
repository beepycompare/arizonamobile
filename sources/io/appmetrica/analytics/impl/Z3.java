package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public final class Z3 {

    /* renamed from: a  reason: collision with root package name */
    public final String f877a;
    public final Integer b;
    public final String c;

    public Z3(String str, Integer num, String str2) {
        this.f877a = str;
        this.b = num;
        this.c = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && Z3.class == obj.getClass()) {
            Z3 z3 = (Z3) obj;
            if (!this.f877a.equals(z3.f877a)) {
                return false;
            }
            Integer num = this.b;
            if (num == null ? z3.b != null : !num.equals(z3.b)) {
                return false;
            }
            String str = this.c;
            String str2 = z3.c;
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
        int hashCode = this.f877a.hashCode() * 31;
        Integer num = this.b;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 31;
        String str = this.c;
        return hashCode2 + (str != null ? str.hashCode() : 0);
    }
}
