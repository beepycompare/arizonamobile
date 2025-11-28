package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
import io.appmetrica.analytics.coreutils.internal.time.SystemTimeProvider;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
/* renamed from: io.appmetrica.analytics.impl.jd  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0347jd {

    /* renamed from: a  reason: collision with root package name */
    public final Executor f953a;
    public final InterfaceC0731yl b;
    public final String c;
    public final SystemTimeProvider d;

    public C0347jd(IHandlerExecutor iHandlerExecutor, Fd fd, String str, SystemTimeProvider systemTimeProvider) {
        this.f953a = iHandlerExecutor;
        this.b = fd;
        this.c = str;
        this.d = systemTimeProvider;
    }

    public static final void a(C0347jd c0347jd, List list) {
        Vj vj = AbstractC0604tj.f1136a;
        C0399ld c0399ld = new C0399ld(c0347jd.b, c0347jd.c, c0347jd.d, list);
        vj.getClass();
        vj.a(new Jj(c0399ld));
    }

    public final void a(final ArrayList arrayList) {
        this.f953a.execute(new Runnable() { // from class: io.appmetrica.analytics.impl.jd$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                C0347jd.a(C0347jd.this, arrayList);
            }
        });
    }
}
