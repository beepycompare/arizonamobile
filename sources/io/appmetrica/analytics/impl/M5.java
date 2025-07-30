package io.appmetrica.analytics.impl;

import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes4.dex */
public final class M5 implements InterfaceC0433md {

    /* renamed from: a  reason: collision with root package name */
    public final String f544a;

    public M5(String str) {
        this.f544a = str;
    }

    public final M5 a(String str) {
        return new M5(str);
    }

    public final String b() {
        return this.f544a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof M5) && Intrinsics.areEqual(this.f544a, ((M5) obj).f544a);
    }

    public final int hashCode() {
        return this.f544a.hashCode();
    }

    public final String toString() {
        return "ConstantModuleEntryPointProvider(className=" + this.f544a + ')';
    }

    public static M5 a(M5 m5, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = m5.f544a;
        }
        m5.getClass();
        return new M5(str);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0433md
    public final String a() {
        return this.f544a;
    }
}
