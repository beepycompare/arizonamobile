package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
/* renamed from: io.appmetrica.analytics.impl.j2  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0353j2 {

    /* renamed from: a  reason: collision with root package name */
    public final C0762zc f885a;
    public final ICommonExecutor b;
    public final long c;
    public boolean d = true;
    public final Runnable e = new Runnable() { // from class: io.appmetrica.analytics.impl.j2$$ExternalSyntheticLambda0
        @Override // java.lang.Runnable
        public final void run() {
            C0353j2.a(C0353j2.this);
        }
    };

    public C0353j2(C0762zc c0762zc, IHandlerExecutor iHandlerExecutor, long j) {
        this.f885a = c0762zc;
        this.b = iHandlerExecutor;
        this.c = j;
    }

    public static final void a(C0353j2 c0353j2) {
        Ac ac = c0353j2.f885a.f1163a;
        Gi gi = ac.h;
        gi.c.a(ac.b.f796a);
    }
}
