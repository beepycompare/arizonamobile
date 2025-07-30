package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.ApiKeyUtils;
/* renamed from: io.appmetrica.analytics.impl.l5  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C0400l5 {

    /* renamed from: a  reason: collision with root package name */
    public final String f935a;
    public final String b;

    public C0400l5(String str, String str2) {
        this.f935a = str;
        this.b = str2;
    }

    public final String a() {
        return ApiKeyUtils.createPartialApiKey(this.b);
    }

    public final String b() {
        return this.b;
    }

    public final String c() {
        return this.f935a;
    }

    public boolean d() {
        return false;
    }

    public String e() {
        return this.f935a + "_" + ApiKeyUtils.createPartialApiKey(this.b);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            C0400l5 c0400l5 = (C0400l5) obj;
            String str = this.f935a;
            if (str == null ? c0400l5.f935a != null : !str.equals(c0400l5.f935a)) {
                return false;
            }
            String str2 = this.b;
            String str3 = c0400l5.b;
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
        String str = this.f935a;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.b;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return this.f935a + "_" + this.b;
    }
}
