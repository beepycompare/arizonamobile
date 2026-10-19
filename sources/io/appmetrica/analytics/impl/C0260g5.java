package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.ApiKeyUtils;
/* renamed from: io.appmetrica.analytics.impl.g5  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C0260g5 {

    /* renamed from: a  reason: collision with root package name */
    public final String f998a;
    public final String b;

    public C0260g5(String str, String str2) {
        this.f998a = str;
        this.b = str2;
    }

    public final String a() {
        return ApiKeyUtils.createPartialApiKey(this.b);
    }

    public final String b() {
        return this.b;
    }

    public final String c() {
        return this.f998a;
    }

    public boolean d() {
        return false;
    }

    public String e() {
        return this.f998a + "_" + ApiKeyUtils.createPartialApiKey(this.b);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            C0260g5 c0260g5 = (C0260g5) obj;
            String str = this.f998a;
            if (str == null ? c0260g5.f998a != null : !str.equals(c0260g5.f998a)) {
                return false;
            }
            String str2 = this.b;
            if (str2 != null) {
                return str2.equals(c0260g5.b);
            }
            if (c0260g5.b == null) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.f998a;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.b;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return this.f998a + "_" + this.b;
    }
}
