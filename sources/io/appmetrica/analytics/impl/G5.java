package io.appmetrica.analytics.impl;

import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class G5 {

    /* renamed from: a  reason: collision with root package name */
    public final String f560a;

    public G5(String str) {
        this.f560a = str;
    }

    public final String a() {
        return this.f560a;
    }

    public final String b() {
        return this.f560a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof G5) && Intrinsics.areEqual(this.f560a, ((G5) obj).f560a);
    }

    public final int hashCode() {
        return this.f560a.hashCode();
    }

    public final String toString() {
        return "ConstantModuleEntryPointProvider(className=" + this.f560a + ')';
    }

    public final G5 a(String str) {
        return new G5(str);
    }

    public static G5 a(G5 g5, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = g5.f560a;
        }
        g5.getClass();
        return new G5(str);
    }
}
