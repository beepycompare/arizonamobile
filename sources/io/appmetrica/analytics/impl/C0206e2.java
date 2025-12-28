package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
/* renamed from: io.appmetrica.analytics.impl.e2  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0206e2 {

    /* renamed from: a  reason: collision with root package name */
    public final C0294hc f960a;
    public final ICommonExecutor b;
    public final long c;
    public boolean d = true;
    public final Runnable e = new Runnable() { // from class: io.appmetrica.analytics.impl.e2$$ExternalSyntheticLambda0
        @Override // java.lang.Runnable
        public final void run() {
            C0206e2.a(C0206e2.this);
        }
    };

    public C0206e2(C0294hc c0294hc, IHandlerExecutor iHandlerExecutor, long j) {
        this.f960a = c0294hc;
        this.b = iHandlerExecutor;
        this.c = j;
    }

    public static final void a(C0206e2 c0206e2) {
        C0320ic c0320ic = c0206e2.f960a.f1020a;
        C0702xi c0702xi = c0320ic.h;
        c0702xi.c.a(c0320ic.b.f616a);
    }
}
