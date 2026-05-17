package io.appmetrica.analytics.impl;

import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.impl.bd  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0144bd {

    /* renamed from: a  reason: collision with root package name */
    public final String f924a;
    public final boolean b;

    public C0144bd(String str, boolean z) {
        this.f924a = str;
        this.b = z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C0144bd) {
            C0144bd c0144bd = (C0144bd) obj;
            return Intrinsics.areEqual(this.f924a, c0144bd.f924a) && this.b == c0144bd.b;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int hashCode = this.f924a.hashCode() * 31;
        boolean z = this.b;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return hashCode + i;
    }

    public final String toString() {
        return "ModuleStatus(moduleName=" + this.f924a + ", loaded=" + this.b + ')';
    }
}
