package io.appmetrica.analytics.impl;

import kotlin.NoWhenBranchMatchedException;
/* renamed from: io.appmetrica.analytics.impl.p4  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0490p4 {
    public static InterfaceC0440n4 a(X3 x3) {
        switch (AbstractC0465o4.f1034a[x3.e.ordinal()]) {
            case 1:
                return new C0295hc();
            case 2:
                return new C0455nj();
            case 3:
                return new C0530qj();
            case 4:
                return new Hh(new Jh());
            case 5:
                return new Hh(new Zj());
            case 6:
                return new C0572sc();
            case 7:
                return new C0572sc();
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
