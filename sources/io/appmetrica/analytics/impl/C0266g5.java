package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.ApiKeyUtils;
/* renamed from: io.appmetrica.analytics.impl.g5  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C0266g5 {

    /* renamed from: a  reason: collision with root package name */
    public final String f995a;
    public final String b;

    public C0266g5(String str, String str2) {
        this.f995a = str;
        this.b = str2;
    }

    public final String a() {
        return ApiKeyUtils.createPartialApiKey(this.b);
    }

    public final String b() {
        return this.b;
    }

    public final String c() {
        return this.f995a;
    }

    public boolean d() {
        return false;
    }

    public String e() {
        return this.f995a + "_" + ApiKeyUtils.createPartialApiKey(this.b);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            C0266g5 c0266g5 = (C0266g5) obj;
            String str = this.f995a;
            if (str == null ? c0266g5.f995a != null : !str.equals(c0266g5.f995a)) {
                return false;
            }
            String str2 = this.b;
            if (str2 != null) {
                return str2.equals(c0266g5.b);
            }
            if (c0266g5.b == null) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.f995a;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.b;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return this.f995a + "_" + this.b;
    }
}
