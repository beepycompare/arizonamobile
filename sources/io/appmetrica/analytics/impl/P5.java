package io.appmetrica.analytics.impl;

import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes4.dex */
public final class P5 implements InterfaceC0559rd {

    /* renamed from: a  reason: collision with root package name */
    public final String f616a;

    public P5(String str) {
        this.f616a = str;
    }

    public final P5 a(String str) {
        return new P5(str);
    }

    public final String b() {
        return this.f616a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof P5) && Intrinsics.areEqual(this.f616a, ((P5) obj).f616a);
    }

    public final int hashCode() {
        return this.f616a.hashCode();
    }

    public final String toString() {
        return "ConstantModuleEntryPointProvider(className=" + this.f616a + ')';
    }

    public static P5 a(P5 p5, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = p5.f616a;
        }
        p5.getClass();
        return new P5(str);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0559rd
    public final String a() {
        return this.f616a;
    }
}
