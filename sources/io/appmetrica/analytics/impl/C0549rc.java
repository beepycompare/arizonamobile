package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor;
import java.util.Objects;
/* renamed from: io.appmetrica.analytics.impl.rc  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0549rc extends C0162c5 {
    public C0549rc(Context context, Q4 q4, C0467o4 c0467o4, V4 v4, C0256fm c0256fm, InterfaceC0303hh interfaceC0303hh, ICommonExecutor iCommonExecutor, int i, C0383kk c0383kk, Fb fb, InterfaceC0571s9 interfaceC0571s9) {
        super(context, q4, c0467o4, v4, c0256fm, interfaceC0303hh, iCommonExecutor, i, fb, interfaceC0571s9);
    }

    public final C0504pg a(C0500pc c0500pc) {
        C0377ke c0377ke = new C0377ke(c0500pc);
        Objects.requireNonNull(c0500pc);
        return new C0504pg(c0377ke, new C0475oc(c0500pc), c0500pc);
    }

    @Override // io.appmetrica.analytics.impl.C0162c5
    public final InterfaceC0522q9 a(InterfaceC0646v9 interfaceC0646v9, L6 l6, Qg qg, C0467o4 c0467o4, Q4 q4, We we) {
        return this.l.a(interfaceC0646v9, l6, qg, c0467o4, q4, we).a();
    }
}
