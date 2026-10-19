package io.appmetrica.analytics.identifiers.impl;

import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public final String f404a;
    public final String b;
    public final Boolean c;

    public a(String str, String str2, Boolean bool) {
        this.f404a = str;
        this.b = str2;
        this.c = bool;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof a) {
            a aVar = (a) obj;
            return Intrinsics.areEqual(this.f404a, aVar.f404a) && Intrinsics.areEqual(this.b, aVar.b) && Intrinsics.areEqual(this.c, aVar.c);
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.f404a.hashCode() * 31;
        String str = this.b;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        Boolean bool = this.c;
        return hashCode2 + (bool != null ? bool.hashCode() : 0);
    }

    public final String toString() {
        return "AdvIdInfo(provider=" + this.f404a + ", advId=" + this.b + ", limitedAdTracking=" + this.c + ')';
    }
}
