package io.appmetrica.analytics.impl;

import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes4.dex */
public final class J5 implements InterfaceC0381kd {

    /* renamed from: a  reason: collision with root package name */
    public final String f487a;

    public J5(String str) {
        this.f487a = str;
    }

    public final J5 a(String str) {
        return new J5(str);
    }

    public final String b() {
        return this.f487a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof J5) && Intrinsics.areEqual(this.f487a, ((J5) obj).f487a);
    }

    public final int hashCode() {
        return this.f487a.hashCode();
    }

    public final String toString() {
        return "ConstantModuleEntryPointProvider(className=" + this.f487a + ')';
    }

    public static J5 a(J5 j5, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = j5.f487a;
        }
        j5.getClass();
        return new J5(str);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0381kd
    public final String a() {
        return this.f487a;
    }
}
