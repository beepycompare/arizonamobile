package io.appmetrica.analytics.impl;

import kotlin.NoWhenBranchMatchedException;
/* loaded from: classes4.dex */
public final class D4 {
    public static B4 a(C0397l4 c0397l4) {
        switch (C4.f373a[c0397l4.e.ordinal()]) {
            case 1:
                return new C0704xc();
            case 2:
                return new Aj();
            case 3:
                return new Dj();
            case 4:
                return new Uh(new Wh());
            case 5:
                return new Uh(new C0361jk());
            case 6:
                return new Ic();
            case 7:
                return new Ic();
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
