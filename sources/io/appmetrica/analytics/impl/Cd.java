package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
import io.appmetrica.analytics.coreutils.internal.time.SystemTimeProvider;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
/* loaded from: classes5.dex */
public final class Cd {

    /* renamed from: a  reason: collision with root package name */
    public final Executor f495a;
    public final Zl b;
    public final String c;
    public final SystemTimeProvider d;

    public Cd(IHandlerExecutor iHandlerExecutor, Yd yd, String str, SystemTimeProvider systemTimeProvider) {
        this.f495a = iHandlerExecutor;
        this.b = yd;
        this.c = str;
        this.d = systemTimeProvider;
    }

    public static final void a(Cd cd, List list) {
        C0541qk c0541qk = Oj.f706a;
        Ed ed = new Ed(cd.b, cd.c, cd.d, list);
        c0541qk.getClass();
        c0541qk.a(new C0230ek(ed));
    }

    public final void a(final ArrayList arrayList) {
        this.f495a.execute(new Runnable() { // from class: io.appmetrica.analytics.impl.Cd$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                Cd.a(Cd.this, arrayList);
            }
        });
    }
}
