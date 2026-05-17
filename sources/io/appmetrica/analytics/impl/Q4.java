package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.ApiKeyUtils;
/* loaded from: classes5.dex */
public class Q4 {

    /* renamed from: a  reason: collision with root package name */
    public final String f753a;
    public final String b;

    public Q4(String str, String str2) {
        this.f753a = str;
        this.b = str2;
    }

    public final String a() {
        return ApiKeyUtils.createPartialApiKey(this.b);
    }

    public final String b() {
        return this.b;
    }

    public final String c() {
        return this.f753a;
    }

    public boolean d() {
        return false;
    }

    public String e() {
        return this.f753a + "_" + ApiKeyUtils.createPartialApiKey(this.b);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            Q4 q4 = (Q4) obj;
            String str = this.f753a;
            if (str == null ? q4.f753a != null : !str.equals(q4.f753a)) {
                return false;
            }
            String str2 = this.b;
            if (str2 != null) {
                return str2.equals(q4.b);
            }
            if (q4.b == null) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.f753a;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.b;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return this.f753a + "_" + this.b;
    }
}
