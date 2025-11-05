package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.logger.LoggerStorage;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes3.dex */
public final class X1 implements Thread.UncaughtExceptionHandler {
    public static final AtomicBoolean e = new AtomicBoolean();

    /* renamed from: a  reason: collision with root package name */
    public final Ma f749a;
    public final C0716y6 b = C0338j4.l().n();
    public final C0641v6 c = new C0641v6();
    public final Fn d = new Fn();

    public X1(C0541r6 c0541r6) {
        this.f749a = c0541r6;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(Thread thread, Throwable th) {
        StackTraceElement[] stackTraceElementArr;
        try {
            e.set(true);
            Ma ma = this.f749a;
            C0733yn apply = this.c.apply(thread);
            Fn fn = this.d;
            Thread a2 = fn.f480a.a();
            ArrayList a3 = fn.a(a2, thread);
            if (thread != a2) {
                try {
                    stackTraceElementArr = fn.f480a.b();
                    if (stackTraceElementArr == null) {
                        try {
                            stackTraceElementArr = a2.getStackTrace();
                        } catch (SecurityException unused) {
                        }
                    }
                } catch (SecurityException unused2) {
                    stackTraceElementArr = null;
                }
                a3.add(0, (C0733yn) fn.b.apply(a2, stackTraceElementArr));
            }
            ma.a(th, new V(apply, a3, this.b.f1210a.a()));
        } catch (Throwable th2) {
            LoggerStorage.getMainPublicOrAnonymousLogger().error(th2, th2.getMessage(), new Object[0]);
        }
    }
}
