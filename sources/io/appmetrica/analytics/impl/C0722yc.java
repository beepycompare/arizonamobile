package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor;
import java.util.Objects;
/* renamed from: io.appmetrica.analytics.impl.yc  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0722yc extends C0339j5 {
    public C0722yc(Context context, X4 x4, C0639v4 c0639v4, AbstractC0159c5 abstractC0159c5, C0356jm c0356jm, InterfaceC0428mh interfaceC0428mh, ICommonExecutor iCommonExecutor, int i, C0481ok c0481ok, Mb mb, InterfaceC0744z9 interfaceC0744z9) {
        super(context, x4, c0639v4, abstractC0159c5, c0356jm, interfaceC0428mh, iCommonExecutor, i, mb, interfaceC0744z9);
    }

    public final C0626ug a(C0672wc c0672wc) {
        C0549re c0549re = new C0549re(c0672wc);
        Objects.requireNonNull(c0672wc);
        return new C0626ug(c0549re, new C0647vc(c0672wc), c0672wc);
    }

    @Override // io.appmetrica.analytics.impl.C0339j5
    public final InterfaceC0694x9 a(C9 c9, S6 s6, Vg vg, C0639v4 c0639v4, X4 x4, C0143bf c0143bf) {
        return this.l.a(c9, s6, vg, c0639v4, x4, c0143bf).a();
    }
}
