package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.logger.LoggerStorage;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes5.dex */
public final class P1 implements Thread.UncaughtExceptionHandler {
    public static final AtomicBoolean e = new AtomicBoolean();

    /* renamed from: a  reason: collision with root package name */
    public final Ga f727a;
    public final C0565s6 b = C0157c4.l().n();
    public final C0491p6 c = new C0491p6();
    public final En d = new En();

    public P1(C0391l6 c0391l6) {
        this.f727a = c0391l6;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(Thread thread, Throwable th) {
        StackTraceElement[] stackTraceElementArr;
        try {
            e.set(true);
            Ga ga = this.f727a;
            C0707xn apply = this.c.apply(thread);
            En en = this.d;
            Thread a2 = en.f565a.a();
            ArrayList a3 = en.a(a2, thread);
            if (thread != a2) {
                try {
                    stackTraceElementArr = en.f565a.b();
                    if (stackTraceElementArr == null) {
                        try {
                            stackTraceElementArr = a2.getStackTrace();
                        } catch (SecurityException unused) {
                        }
                    }
                } catch (SecurityException unused2) {
                    stackTraceElementArr = null;
                }
                a3.add(0, (C0707xn) en.b.apply(a2, stackTraceElementArr));
            }
            ga.a(th, new V(apply, a3, this.b.f1212a.a()));
        } catch (Throwable th2) {
            LoggerStorage.getMainPublicOrAnonymousLogger().error(th2, th2.getMessage(), new Object[0]);
        }
    }
}
