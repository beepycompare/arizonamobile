package io.appmetrica.analytics.billing.impl;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.billing.impl.a  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0095a {

    /* renamed from: a  reason: collision with root package name */
    public final List f307a;
    public final boolean b;

    public C0095a(List list, boolean z) {
        this.f307a = list;
        this.b = z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C0095a) {
            C0095a c0095a = (C0095a) obj;
            return Intrinsics.areEqual(this.f307a, c0095a.f307a) && this.b == c0095a.b;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int hashCode = this.f307a.hashCode() * 31;
        boolean z = this.b;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return hashCode + i;
    }

    public final String toString() {
        return "AutoInappCollectingInfo(billingInfos=" + this.f307a + ", firstInappCheckOccurred=" + this.b + ')';
    }
}
