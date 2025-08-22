package io.appmetrica.analytics.impl;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes4.dex */
public final class N3 implements InterfaceC0476o8 {

    /* renamed from: a  reason: collision with root package name */
    public final Map f572a;
    public final EnumC0451n8 b;

    public N3(Map<String, String> map, EnumC0451n8 enumC0451n8) {
        this.f572a = map;
        this.b = enumC0451n8;
    }

    public final N3 a(Map<String, String> map, EnumC0451n8 enumC0451n8) {
        return new N3(map, enumC0451n8);
    }

    public final Map<String, String> b() {
        return this.f572a;
    }

    public final EnumC0451n8 c() {
        return this.b;
    }

    public final Map<String, String> d() {
        return this.f572a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof N3) {
            N3 n3 = (N3) obj;
            return Intrinsics.areEqual(this.f572a, n3.f572a) && this.b == n3.b;
        }
        return false;
    }

    public final int hashCode() {
        Map map = this.f572a;
        return this.b.hashCode() + ((map == null ? 0 : map.hashCode()) * 31);
    }

    public final String toString() {
        return "Candidate(clids=" + this.f572a + ", source=" + this.b + ')';
    }

    public static N3 a(N3 n3, Map map, EnumC0451n8 enumC0451n8, int i, Object obj) {
        if ((i & 1) != 0) {
            map = n3.f572a;
        }
        if ((i & 2) != 0) {
            enumC0451n8 = n3.b;
        }
        n3.getClass();
        return new N3(map, enumC0451n8);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0476o8
    public final EnumC0451n8 a() {
        return this.b;
    }
}
