package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
import io.appmetrica.analytics.coreutils.internal.time.SystemTimeProvider;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
/* renamed from: io.appmetrica.analytics.impl.cd  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0170cd {

    /* renamed from: a  reason: collision with root package name */
    public final Executor f937a;
    public final InterfaceC0633ul b;
    public final String c;
    public final SystemTimeProvider d;

    public C0170cd(IHandlerExecutor iHandlerExecutor, AbstractC0725yd abstractC0725yd, String str, SystemTimeProvider systemTimeProvider) {
        this.f937a = iHandlerExecutor;
        this.b = abstractC0725yd;
        this.c = str;
        this.d = systemTimeProvider;
    }

    public static final void a(C0170cd c0170cd, List list) {
        Qj qj = AbstractC0482oj.f1158a;
        C0221ed c0221ed = new C0221ed(c0170cd.b, c0170cd.c, c0170cd.d, list);
        qj.getClass();
        qj.a(new Ej(c0221ed));
    }

    public final void a(final ArrayList arrayList) {
        this.f937a.execute(new Runnable() { // from class: io.appmetrica.analytics.impl.cd$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                C0170cd.a(C0170cd.this, arrayList);
            }
        });
    }
}
