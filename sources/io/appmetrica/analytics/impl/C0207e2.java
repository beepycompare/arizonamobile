package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
/* renamed from: io.appmetrica.analytics.impl.e2  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0207e2 {

    /* renamed from: a  reason: collision with root package name */
    public final C0295hc f862a;
    public final ICommonExecutor b;
    public final long c;
    public boolean d = true;
    public final Runnable e = new Runnable() { // from class: io.appmetrica.analytics.impl.e2$$ExternalSyntheticLambda0
        @Override // java.lang.Runnable
        public final void run() {
            C0207e2.a(C0207e2.this);
        }
    };

    public C0207e2(C0295hc c0295hc, IHandlerExecutor iHandlerExecutor, long j) {
        this.f862a = c0295hc;
        this.b = iHandlerExecutor;
        this.c = j;
    }

    public static final void a(C0207e2 c0207e2) {
        C0321ic c0321ic = c0207e2.f862a.f922a;
        C0703xi c0703xi = c0321ic.h;
        c0703xi.c.a(c0321ic.b.f518a);
    }
}
