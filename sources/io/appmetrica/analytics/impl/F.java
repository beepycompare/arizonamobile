package io.appmetrica.analytics.impl;

import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes4.dex */
public final class F {

    /* renamed from: a  reason: collision with root package name */
    public final int f430a;
    public final int b;
    public final int c;

    public F(int i, int i2, int i3) {
        this.f430a = i;
        this.b = i2;
        this.c = i3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (Intrinsics.areEqual(F.class, obj != null ? obj.getClass() : null)) {
            if (obj != null) {
                F f = (F) obj;
                return this.f430a == f.f430a && this.b == f.b && this.c == f.c;
            }
            throw new NullPointerException("null cannot be cast to non-null type io.appmetrica.analytics.impl.id.AdvIdGetterController.CanTrackIdentifiers");
        }
        return false;
    }

    public final int hashCode() {
        int a2 = AbstractC0324i8.a(this.b);
        return AbstractC0324i8.a(this.c) + ((a2 + (AbstractC0324i8.a(this.f430a) * 31)) * 31);
    }

    public final String toString() {
        return "CanTrackIdentifiers(canTrackGaid=" + G.a(this.f430a) + ", canTrackHoaid=" + G.a(this.b) + ", canTrackYandexAdvId=" + G.a(this.c) + ')';
    }
}
