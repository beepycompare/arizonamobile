package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
import io.appmetrica.analytics.coreutils.internal.time.SystemTimeProvider;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
/* renamed from: io.appmetrica.analytics.impl.dd  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0193dd {

    /* renamed from: a  reason: collision with root package name */
    public final Executor f850a;
    public final InterfaceC0656vl b;
    public final String c;
    public final SystemTimeProvider d;

    public C0193dd(IHandlerExecutor iHandlerExecutor, AbstractC0748zd abstractC0748zd, String str, SystemTimeProvider systemTimeProvider) {
        this.f850a = iHandlerExecutor;
        this.b = abstractC0748zd;
        this.c = str;
        this.d = systemTimeProvider;
    }

    public static final void a(C0193dd c0193dd, List list) {
        Rj rj = AbstractC0505pj.f1071a;
        C0244fd c0244fd = new C0244fd(c0193dd.b, c0193dd.c, c0193dd.d, list);
        rj.getClass();
        rj.a(new Fj(c0244fd));
    }

    public final void a(final ArrayList arrayList) {
        this.f850a.execute(new Runnable() { // from class: io.appmetrica.analytics.impl.dd$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                C0193dd.a(C0193dd.this, arrayList);
            }
        });
    }
}
