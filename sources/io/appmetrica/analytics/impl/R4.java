package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.ApiKeyUtils;
/* loaded from: classes5.dex */
public class R4 {

    /* renamed from: a  reason: collision with root package name */
    public final String f659a;
    public final String b;

    public R4(String str, String str2) {
        this.f659a = str;
        this.b = str2;
    }

    public final String a() {
        return ApiKeyUtils.createPartialApiKey(this.b);
    }

    public final String b() {
        return this.b;
    }

    public final String c() {
        return this.f659a;
    }

    public boolean d() {
        return false;
    }

    public String e() {
        return this.f659a + "_" + ApiKeyUtils.createPartialApiKey(this.b);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            R4 r4 = (R4) obj;
            String str = this.f659a;
            if (str == null ? r4.f659a != null : !str.equals(r4.f659a)) {
                return false;
            }
            String str2 = this.b;
            String str3 = r4.b;
            if (str2 != null) {
                return str2.equals(str3);
            }
            if (str3 == null) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.f659a;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.b;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return this.f659a + "_" + this.b;
    }
}
