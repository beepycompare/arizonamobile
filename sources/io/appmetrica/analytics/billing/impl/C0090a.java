package io.appmetrica.analytics.billing.impl;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.billing.impl.a  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0090a {

    /* renamed from: a  reason: collision with root package name */
    public final List f264a;
    public final boolean b;

    public C0090a(List list, boolean z) {
        this.f264a = list;
        this.b = z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C0090a) {
            C0090a c0090a = (C0090a) obj;
            return Intrinsics.areEqual(this.f264a, c0090a.f264a) && this.b == c0090a.b;
        }
        return false;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.b) + (this.f264a.hashCode() * 31);
    }

    public final String toString() {
        return "AutoInappCollectingInfo(billingInfos=" + this.f264a + ", firstInappCheckOccurred=" + this.b + ')';
    }
}
