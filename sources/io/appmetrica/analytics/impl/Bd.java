package io.appmetrica.analytics.impl;

import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class Bd {

    /* renamed from: a  reason: collision with root package name */
    public final String f475a;
    public final boolean b;

    public Bd(String str, boolean z) {
        this.f475a = str;
        this.b = z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Bd) {
            Bd bd = (Bd) obj;
            return Intrinsics.areEqual(this.f475a, bd.f475a) && this.b == bd.b;
        }
        return false;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.b) + (this.f475a.hashCode() * 31);
    }

    public final String toString() {
        return "ModuleStatus(moduleName=" + this.f475a + ", loaded=" + this.b + ')';
    }
}
