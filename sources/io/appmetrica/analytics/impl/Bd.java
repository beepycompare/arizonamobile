package io.appmetrica.analytics.impl;

import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class Bd {

    /* renamed from: a  reason: collision with root package name */
    public final String f481a;
    public final boolean b;

    public Bd(String str, boolean z) {
        this.f481a = str;
        this.b = z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Bd) {
            Bd bd = (Bd) obj;
            return Intrinsics.areEqual(this.f481a, bd.f481a) && this.b == bd.b;
        }
        return false;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.b) + (this.f481a.hashCode() * 31);
    }

    public final String toString() {
        return "ModuleStatus(moduleName=" + this.f481a + ", loaded=" + this.b + ')';
    }
}
