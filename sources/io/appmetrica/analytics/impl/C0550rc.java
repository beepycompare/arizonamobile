package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor;
import java.util.Objects;
/* renamed from: io.appmetrica.analytics.impl.rc  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0550rc extends C0163c5 {
    public C0550rc(Context context, Q4 q4, C0468o4 c0468o4, V4 v4, C0257fm c0257fm, InterfaceC0304hh interfaceC0304hh, ICommonExecutor iCommonExecutor, int i, C0384kk c0384kk, Fb fb, InterfaceC0572s9 interfaceC0572s9) {
        super(context, q4, c0468o4, v4, c0257fm, interfaceC0304hh, iCommonExecutor, i, fb, interfaceC0572s9);
    }

    public final C0505pg a(C0501pc c0501pc) {
        C0378ke c0378ke = new C0378ke(c0501pc);
        Objects.requireNonNull(c0501pc);
        return new C0505pg(c0378ke, new C0476oc(c0501pc), c0501pc);
    }

    @Override // io.appmetrica.analytics.impl.C0163c5
    public final InterfaceC0523q9 a(InterfaceC0647v9 interfaceC0647v9, L6 l6, Qg qg, C0468o4 c0468o4, Q4 q4, We we) {
        return this.l.a(interfaceC0647v9, l6, qg, c0468o4, q4, we).a();
    }
}
