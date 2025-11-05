package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
/* renamed from: io.appmetrica.analytics.impl.m2  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0413m2 {

    /* renamed from: a  reason: collision with root package name */
    public final C0448nc f1001a;
    public final ICommonExecutor b;
    public final long c;
    public boolean d = true;
    public final Runnable e = new Runnable() { // from class: io.appmetrica.analytics.impl.m2$$ExternalSyntheticLambda0
        @Override // java.lang.Runnable
        public final void run() {
            C0413m2.a(C0413m2.this);
        }
    };

    public C0413m2(C0448nc c0448nc, IHandlerExecutor iHandlerExecutor, long j) {
        this.f1001a = c0448nc;
        this.b = iHandlerExecutor;
        this.c = j;
    }

    public static final void a(C0413m2 c0413m2) {
        C0473oc c0473oc = c0413m2.f1001a.f1024a;
        Bi bi = c0473oc.h;
        bi.c.a(c0473oc.b.f629a);
    }
}
