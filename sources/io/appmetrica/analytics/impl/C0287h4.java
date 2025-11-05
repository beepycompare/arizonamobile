package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.h4  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0287h4 {

    /* renamed from: a  reason: collision with root package name */
    public final String f904a;
    public final Integer b;
    public final String c;

    public C0287h4(String str, Integer num, String str2) {
        this.f904a = str;
        this.b = num;
        this.c = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && C0287h4.class == obj.getClass()) {
            C0287h4 c0287h4 = (C0287h4) obj;
            if (!this.f904a.equals(c0287h4.f904a)) {
                return false;
            }
            Integer num = this.b;
            if (num == null ? c0287h4.b != null : !num.equals(c0287h4.b)) {
                return false;
            }
            String str = this.c;
            String str2 = c0287h4.c;
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
        int hashCode = this.f904a.hashCode() * 31;
        Integer num = this.b;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 31;
        String str = this.c;
        return hashCode2 + (str != null ? str.hashCode() : 0);
    }
}
