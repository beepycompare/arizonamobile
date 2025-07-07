package io.appmetrica.analytics.impl;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes4.dex */
public final class N3 implements InterfaceC0359j8 {

    /* renamed from: a  reason: collision with root package name */
    public final Map f547a;
    public final EnumC0335i8 b;

    public N3(Map<String, String> map, EnumC0335i8 enumC0335i8) {
        this.f547a = map;
        this.b = enumC0335i8;
    }

    public final N3 a(Map<String, String> map, EnumC0335i8 enumC0335i8) {
        return new N3(map, enumC0335i8);
    }

    public final Map<String, String> b() {
        return this.f547a;
    }

    public final EnumC0335i8 c() {
        return this.b;
    }

    public final Map<String, String> d() {
        return this.f547a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof N3) {
            N3 n3 = (N3) obj;
            return Intrinsics.areEqual(this.f547a, n3.f547a) && this.b == n3.b;
        }
        return false;
    }

    public final int hashCode() {
        Map map = this.f547a;
        return this.b.hashCode() + ((map == null ? 0 : map.hashCode()) * 31);
    }

    public final String toString() {
        return "Candidate(clids=" + this.f547a + ", source=" + this.b + ')';
    }

    public static N3 a(N3 n3, Map map, EnumC0335i8 enumC0335i8, int i, Object obj) {
        if ((i & 1) != 0) {
            map = n3.f547a;
        }
        if ((i & 2) != 0) {
            enumC0335i8 = n3.b;
        }
        n3.getClass();
        return new N3(map, enumC0335i8);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0359j8
    public final EnumC0335i8 a() {
        return this.b;
    }
}
