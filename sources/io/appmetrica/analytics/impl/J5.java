package io.appmetrica.analytics.impl;

import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes4.dex */
public final class J5 implements InterfaceC0389kd {

    /* renamed from: a  reason: collision with root package name */
    public final String f486a;

    public J5(String str) {
        this.f486a = str;
    }

    public final J5 a(String str) {
        return new J5(str);
    }

    public final String b() {
        return this.f486a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof J5) && Intrinsics.areEqual(this.f486a, ((J5) obj).f486a);
    }

    public final int hashCode() {
        return this.f486a.hashCode();
    }

    public final String toString() {
        return "ConstantModuleEntryPointProvider(className=" + this.f486a + ')';
    }

    public static J5 a(J5 j5, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = j5.f486a;
        }
        j5.getClass();
        return new J5(str);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0389kd
    public final String a() {
        return this.f486a;
    }
}
