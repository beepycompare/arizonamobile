package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.ApiKeyUtils;
/* renamed from: io.appmetrica.analytics.impl.l5  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C0398l5 {

    /* renamed from: a  reason: collision with root package name */
    public final String f918a;
    public final String b;

    public C0398l5(String str, String str2) {
        this.f918a = str;
        this.b = str2;
    }

    public final String a() {
        return ApiKeyUtils.createPartialApiKey(this.b);
    }

    public final String b() {
        return this.b;
    }

    public final String c() {
        return this.f918a;
    }

    public boolean d() {
        return false;
    }

    public String e() {
        return this.f918a + "_" + ApiKeyUtils.createPartialApiKey(this.b);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            C0398l5 c0398l5 = (C0398l5) obj;
            String str = this.f918a;
            if (str == null ? c0398l5.f918a != null : !str.equals(c0398l5.f918a)) {
                return false;
            }
            String str2 = this.b;
            String str3 = c0398l5.b;
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
        String str = this.f918a;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.b;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return this.f918a + "_" + this.b;
    }
}
