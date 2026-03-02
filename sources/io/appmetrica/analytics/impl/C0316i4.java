package io.appmetrica.analytics.impl;

import kotlin.NoWhenBranchMatchedException;
/* renamed from: io.appmetrica.analytics.impl.i4  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0316i4 {
    public static InterfaceC0264g4 a(P3 p3) {
        switch (AbstractC0290h4.f1022a[p3.e.ordinal()]) {
            case 1:
                return new C0117ac();
            case 2:
                return new C0330ij();
            case 3:
                return new C0407lj();
            case 4:
                return new Ch(new Eh());
            case 5:
                return new Ch(new Uj());
            case 6:
                return new C0400lc();
            case 7:
                return new C0400lc();
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
