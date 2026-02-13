package io.appmetrica.analytics.impl;

import kotlin.NoWhenBranchMatchedException;
/* renamed from: io.appmetrica.analytics.impl.i4  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0317i4 {
    public static InterfaceC0265g4 a(P3 p3) {
        switch (AbstractC0291h4.f1022a[p3.e.ordinal()]) {
            case 1:
                return new C0118ac();
            case 2:
                return new C0331ij();
            case 3:
                return new C0408lj();
            case 4:
                return new Ch(new Eh());
            case 5:
                return new Ch(new Uj());
            case 6:
                return new C0401lc();
            case 7:
                return new C0401lc();
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
