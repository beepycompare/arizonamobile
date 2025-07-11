package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
/* renamed from: io.appmetrica.analytics.impl.j2  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0345j2 {

    /* renamed from: a  reason: collision with root package name */
    public final C0754zc f886a;
    public final ICommonExecutor b;
    public final long c;
    public boolean d = true;
    public final Runnable e = new Runnable() { // from class: io.appmetrica.analytics.impl.j2$$ExternalSyntheticLambda0
        @Override // java.lang.Runnable
        public final void run() {
            C0345j2.a(C0345j2.this);
        }
    };

    public C0345j2(C0754zc c0754zc, IHandlerExecutor iHandlerExecutor, long j) {
        this.f886a = c0754zc;
        this.b = iHandlerExecutor;
        this.c = j;
    }

    public static final void a(C0345j2 c0345j2) {
        Ac ac = c0345j2.f886a.f1164a;
        Gi gi = ac.h;
        gi.c.a(ac.b.f797a);
    }
}
