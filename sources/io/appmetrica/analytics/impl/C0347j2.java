package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
/* renamed from: io.appmetrica.analytics.impl.j2  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0347j2 {

    /* renamed from: a  reason: collision with root package name */
    public final Bc f910a;
    public final ICommonExecutor b;
    public final long c;
    public boolean d = true;
    public final Runnable e = new Runnable() { // from class: io.appmetrica.analytics.impl.j2$$ExternalSyntheticLambda0
        @Override // java.lang.Runnable
        public final void run() {
            C0347j2.a(C0347j2.this);
        }
    };

    public C0347j2(Bc bc, IHandlerExecutor iHandlerExecutor, long j) {
        this.f910a = bc;
        this.b = iHandlerExecutor;
        this.c = j;
    }

    public static final void a(C0347j2 c0347j2) {
        Cc cc = c0347j2.f910a.f355a;
        Ji ji = cc.h;
        ji.c.a(cc.b.f811a);
    }
}
