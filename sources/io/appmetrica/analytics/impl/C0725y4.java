package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.y4  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0725y4 {

    /* renamed from: a  reason: collision with root package name */
    public final String f1164a;
    public final Integer b;
    public final String c;

    public C0725y4(String str, Integer num, String str2) {
        this.f1164a = str;
        this.b = num;
        this.c = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && C0725y4.class == obj.getClass()) {
            C0725y4 c0725y4 = (C0725y4) obj;
            if (!this.f1164a.equals(c0725y4.f1164a)) {
                return false;
            }
            Integer num = this.b;
            if (num == null ? c0725y4.b != null : !num.equals(c0725y4.b)) {
                return false;
            }
            String str = this.c;
            String str2 = c0725y4.c;
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
        int hashCode = this.f1164a.hashCode() * 31;
        Integer num = this.b;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 31;
        String str = this.c;
        return hashCode2 + (str != null ? str.hashCode() : 0);
    }
}
