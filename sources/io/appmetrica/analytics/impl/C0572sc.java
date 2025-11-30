package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor;
import java.util.Objects;
/* renamed from: io.appmetrica.analytics.impl.sc  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0572sc extends C0185d5 {
    public C0572sc(Context context, R4 r4, C0490p4 c0490p4, W4 w4, C0279gm c0279gm, InterfaceC0325ih interfaceC0325ih, ICommonExecutor iCommonExecutor, int i, C0406lk c0406lk, Gb gb, InterfaceC0594t9 interfaceC0594t9) {
        super(context, r4, c0490p4, w4, c0279gm, interfaceC0325ih, iCommonExecutor, i, gb, interfaceC0594t9);
    }

    public final C0527qg a(C0523qc c0523qc) {
        C0400le c0400le = new C0400le(c0523qc);
        Objects.requireNonNull(c0523qc);
        return new C0527qg(c0400le, new C0498pc(c0523qc), c0523qc);
    }

    @Override // io.appmetrica.analytics.impl.C0185d5
    public final InterfaceC0544r9 a(InterfaceC0669w9 interfaceC0669w9, M6 m6, Rg rg, C0490p4 c0490p4, R4 r4, Xe xe) {
        return this.l.a(interfaceC0669w9, m6, rg, c0490p4, r4, xe).a();
    }
}
