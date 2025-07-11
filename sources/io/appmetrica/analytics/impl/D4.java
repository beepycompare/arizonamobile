package io.appmetrica.analytics.impl;

import kotlin.NoWhenBranchMatchedException;
/* loaded from: classes4.dex */
public final class D4 {
    public static B4 a(C0397l4 c0397l4) {
        switch (C4.f366a[c0397l4.e.ordinal()]) {
            case 1:
                return new C0604tc();
            case 2:
                return new C0586sj();
            case 3:
                return new C0661vj();
            case 4:
                return new Nh(new Ph());
            case 5:
                return new Nh(new C0162bk());
            case 6:
                return new Ec();
            case 7:
                return new Ec();
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
