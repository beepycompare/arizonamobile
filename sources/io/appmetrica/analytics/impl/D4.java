package io.appmetrica.analytics.impl;

import kotlin.NoWhenBranchMatchedException;
/* loaded from: classes4.dex */
public final class D4 {
    public static B4 a(C0400l4 c0400l4) {
        switch (C4.f370a[c0400l4.e.ordinal()]) {
            case 1:
                return new C0657vc();
            case 2:
                return new C0664vj();
            case 3:
                return new C0739yj();
            case 4:
                return new Ph(new Rh());
            case 5:
                return new Ph(new C0240ek());
            case 6:
                return new Gc();
            case 7:
                return new Gc();
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
