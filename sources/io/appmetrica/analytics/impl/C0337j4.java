package io.appmetrica.analytics.impl;

import kotlin.NoWhenBranchMatchedException;
/* renamed from: io.appmetrica.analytics.impl.j4  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0337j4 {
    public static InterfaceC0286h4 a(Q3 q3) {
        switch (AbstractC0312i4.f1017a[q3.e.ordinal()]) {
            case 1:
                return new C0139bc();
            case 2:
                return new C0352jj();
            case 3:
                return new C0429mj();
            case 4:
                return new Dh(new Fh());
            case 5:
                return new Dh(new Vj());
            case 6:
                return new C0422mc();
            case 7:
                return new C0422mc();
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
