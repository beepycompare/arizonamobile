package io.appmetrica.analytics.impl;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class I3 implements InterfaceC0425m8 {

    /* renamed from: a  reason: collision with root package name */
    public final Map f586a;
    public final EnumC0399l8 b;

    public I3(Map<String, String> map, EnumC0399l8 enumC0399l8) {
        this.f586a = map;
        this.b = enumC0399l8;
    }

    public final I3 a(Map<String, String> map, EnumC0399l8 enumC0399l8) {
        return new I3(map, enumC0399l8);
    }

    public final Map<String, String> b() {
        return this.f586a;
    }

    public final EnumC0399l8 c() {
        return this.b;
    }

    public final Map<String, String> d() {
        return this.f586a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof I3) {
            I3 i3 = (I3) obj;
            return Intrinsics.areEqual(this.f586a, i3.f586a) && this.b == i3.b;
        }
        return false;
    }

    public final int hashCode() {
        Map map = this.f586a;
        return this.b.hashCode() + ((map == null ? 0 : map.hashCode()) * 31);
    }

    public final String toString() {
        return "Candidate(clids=" + this.f586a + ", source=" + this.b + ')';
    }

    public static I3 a(I3 i3, Map map, EnumC0399l8 enumC0399l8, int i, Object obj) {
        if ((i & 1) != 0) {
            map = i3.f586a;
        }
        if ((i & 2) != 0) {
            enumC0399l8 = i3.b;
        }
        i3.getClass();
        return new I3(map, enumC0399l8);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0425m8
    public final EnumC0399l8 a() {
        return this.b;
    }
}
