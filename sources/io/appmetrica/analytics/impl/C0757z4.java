package io.appmetrica.analytics.impl;

import kotlin.NoWhenBranchMatchedException;
/* renamed from: io.appmetrica.analytics.impl.z4  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0757z4 {
    public static InterfaceC0705x4 a(C0265g4 c0265g4) {
        switch (AbstractC0731y4.f1289a[c0265g4.e.ordinal()]) {
            case 1:
                return new Cc();
            case 2:
                return new Ij();
            case 3:
                return new Lj();
            case 4:
                return new Wh(new Yh());
            case 5:
                return new Wh(new C0643uk());
            case 6:
                return new Nc();
            case 7:
                return new Nc();
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
