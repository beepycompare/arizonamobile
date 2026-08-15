package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
import io.appmetrica.analytics.coreutils.internal.time.SystemTimeProvider;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
/* loaded from: classes5.dex */
public final class Cd {

    /* renamed from: a  reason: collision with root package name */
    public final Executor f497a;
    public final Zl b;
    public final String c;
    public final SystemTimeProvider d;

    public Cd(IHandlerExecutor iHandlerExecutor, Yd yd, String str, SystemTimeProvider systemTimeProvider) {
        this.f497a = iHandlerExecutor;
        this.b = yd;
        this.c = str;
        this.d = systemTimeProvider;
    }

    public static final void a(Cd cd, List list) {
        C0540qk c0540qk = Oj.f708a;
        Ed ed = new Ed(cd.b, cd.c, cd.d, list);
        c0540qk.getClass();
        c0540qk.a(new C0229ek(ed));
    }

    public final void a(final ArrayList arrayList) {
        this.f497a.execute(new Runnable() { // from class: io.appmetrica.analytics.impl.Cd$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                Cd.a(Cd.this, arrayList);
            }
        });
    }
}
