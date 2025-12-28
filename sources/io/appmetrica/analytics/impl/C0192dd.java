package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
import io.appmetrica.analytics.coreutils.internal.time.SystemTimeProvider;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
/* renamed from: io.appmetrica.analytics.impl.dd  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0192dd {

    /* renamed from: a  reason: collision with root package name */
    public final Executor f948a;
    public final InterfaceC0655vl b;
    public final String c;
    public final SystemTimeProvider d;

    public C0192dd(IHandlerExecutor iHandlerExecutor, AbstractC0747zd abstractC0747zd, String str, SystemTimeProvider systemTimeProvider) {
        this.f948a = iHandlerExecutor;
        this.b = abstractC0747zd;
        this.c = str;
        this.d = systemTimeProvider;
    }

    public static final void a(C0192dd c0192dd, List list) {
        Rj rj = AbstractC0504pj.f1169a;
        C0243fd c0243fd = new C0243fd(c0192dd.b, c0192dd.c, c0192dd.d, list);
        rj.getClass();
        rj.a(new Fj(c0243fd));
    }

    public final void a(final ArrayList arrayList) {
        this.f948a.execute(new Runnable() { // from class: io.appmetrica.analytics.impl.dd$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                C0192dd.a(C0192dd.this, arrayList);
            }
        });
    }
}
