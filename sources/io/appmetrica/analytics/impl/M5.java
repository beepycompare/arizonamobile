package io.appmetrica.analytics.impl;

import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes4.dex */
public final class M5 implements InterfaceC0481od {

    /* renamed from: a  reason: collision with root package name */
    public final String f555a;

    public M5(String str) {
        this.f555a = str;
    }

    public final M5 a(String str) {
        return new M5(str);
    }

    public final String b() {
        return this.f555a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof M5) && Intrinsics.areEqual(this.f555a, ((M5) obj).f555a);
    }

    public final int hashCode() {
        return this.f555a.hashCode();
    }

    public final String toString() {
        return "ConstantModuleEntryPointProvider(className=" + this.f555a + ')';
    }

    public static M5 a(M5 m5, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = m5.f555a;
        }
        m5.getClass();
        return new M5(str);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0481od
    public final String a() {
        return this.f555a;
    }
}
