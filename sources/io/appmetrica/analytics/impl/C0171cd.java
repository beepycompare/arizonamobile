package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
import io.appmetrica.analytics.coreutils.internal.time.SystemTimeProvider;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
/* renamed from: io.appmetrica.analytics.impl.cd  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0171cd {

    /* renamed from: a  reason: collision with root package name */
    public final Executor f937a;
    public final InterfaceC0634ul b;
    public final String c;
    public final SystemTimeProvider d;

    public C0171cd(IHandlerExecutor iHandlerExecutor, AbstractC0726yd abstractC0726yd, String str, SystemTimeProvider systemTimeProvider) {
        this.f937a = iHandlerExecutor;
        this.b = abstractC0726yd;
        this.c = str;
        this.d = systemTimeProvider;
    }

    public static final void a(C0171cd c0171cd, List list) {
        Qj qj = AbstractC0483oj.f1158a;
        C0222ed c0222ed = new C0222ed(c0171cd.b, c0171cd.c, c0171cd.d, list);
        qj.getClass();
        qj.a(new Ej(c0222ed));
    }

    public final void a(final ArrayList arrayList) {
        this.f937a.execute(new Runnable() { // from class: io.appmetrica.analytics.impl.cd$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                C0171cd.a(C0171cd.this, arrayList);
            }
        });
    }
}
