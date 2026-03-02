package io.appmetrica.analytics.impl;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.impl.r3  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0540r3 implements T7 {

    /* renamed from: a  reason: collision with root package name */
    public final Map f1199a;
    public final S7 b;

    public C0540r3(Map<String, String> map, S7 s7) {
        this.f1199a = map;
        this.b = s7;
    }

    public final C0540r3 a(Map<String, String> map, S7 s7) {
        return new C0540r3(map, s7);
    }

    public final Map<String, String> b() {
        return this.f1199a;
    }

    public final S7 c() {
        return this.b;
    }

    public final Map<String, String> d() {
        return this.f1199a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C0540r3) {
            C0540r3 c0540r3 = (C0540r3) obj;
            return Intrinsics.areEqual(this.f1199a, c0540r3.f1199a) && this.b == c0540r3.b;
        }
        return false;
    }

    public final int hashCode() {
        Map map = this.f1199a;
        return this.b.hashCode() + ((map == null ? 0 : map.hashCode()) * 31);
    }

    public final String toString() {
        return "Candidate(clids=" + this.f1199a + ", source=" + this.b + ')';
    }

    public static C0540r3 a(C0540r3 c0540r3, Map map, S7 s7, int i, Object obj) {
        if ((i & 1) != 0) {
            map = c0540r3.f1199a;
        }
        if ((i & 2) != 0) {
            s7 = c0540r3.b;
        }
        c0540r3.getClass();
        return new C0540r3(map, s7);
    }

    @Override // io.appmetrica.analytics.impl.T7
    public final S7 a() {
        return this.b;
    }
}
