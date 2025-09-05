package io.appmetrica.analytics.impl;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes4.dex */
public final class Q3 implements InterfaceC0554r8 {

    /* renamed from: a  reason: collision with root package name */
    public final Map f630a;
    public final EnumC0530q8 b;

    public Q3(Map<String, String> map, EnumC0530q8 enumC0530q8) {
        this.f630a = map;
        this.b = enumC0530q8;
    }

    public final Q3 a(Map<String, String> map, EnumC0530q8 enumC0530q8) {
        return new Q3(map, enumC0530q8);
    }

    public final Map<String, String> b() {
        return this.f630a;
    }

    public final EnumC0530q8 c() {
        return this.b;
    }

    public final Map<String, String> d() {
        return this.f630a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Q3) {
            Q3 q3 = (Q3) obj;
            return Intrinsics.areEqual(this.f630a, q3.f630a) && this.b == q3.b;
        }
        return false;
    }

    public final int hashCode() {
        Map map = this.f630a;
        return this.b.hashCode() + ((map == null ? 0 : map.hashCode()) * 31);
    }

    public final String toString() {
        return "Candidate(clids=" + this.f630a + ", source=" + this.b + ')';
    }

    public static Q3 a(Q3 q3, Map map, EnumC0530q8 enumC0530q8, int i, Object obj) {
        if ((i & 1) != 0) {
            map = q3.f630a;
        }
        if ((i & 2) != 0) {
            enumC0530q8 = q3.b;
        }
        q3.getClass();
        return new Q3(map, enumC0530q8);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0554r8
    public final EnumC0530q8 a() {
        return this.b;
    }
}
