package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor;
import java.util.Objects;
/* renamed from: io.appmetrica.analytics.impl.sc  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0571sc extends C0184d5 {
    public C0571sc(Context context, R4 r4, C0489p4 c0489p4, W4 w4, C0278gm c0278gm, InterfaceC0324ih interfaceC0324ih, ICommonExecutor iCommonExecutor, int i, C0405lk c0405lk, Gb gb, InterfaceC0593t9 interfaceC0593t9) {
        super(context, r4, c0489p4, w4, c0278gm, interfaceC0324ih, iCommonExecutor, i, gb, interfaceC0593t9);
    }

    public final C0526qg a(C0522qc c0522qc) {
        C0399le c0399le = new C0399le(c0522qc);
        Objects.requireNonNull(c0522qc);
        return new C0526qg(c0399le, new C0497pc(c0522qc), c0522qc);
    }

    @Override // io.appmetrica.analytics.impl.C0184d5
    public final InterfaceC0543r9 a(InterfaceC0668w9 interfaceC0668w9, M6 m6, Rg rg, C0489p4 c0489p4, R4 r4, Xe xe) {
        return this.l.a(interfaceC0668w9, m6, rg, c0489p4, r4, xe).a();
    }
}
