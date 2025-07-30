package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.logger.LoggerStorage;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes4.dex */
public final class U1 implements Thread.UncaughtExceptionHandler {
    public static final AtomicBoolean e = new AtomicBoolean();

    /* renamed from: a  reason: collision with root package name */
    public final InterfaceC0127ab f663a;
    public final M6 b = C0698x4.l().n();
    public final K6 c = new K6();
    public final An d = new An();

    public U1(G6 g6) {
        this.f663a = g6;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(Thread thread, Throwable th) {
        StackTraceElement[] stackTraceElementArr;
        try {
            e.set(true);
            InterfaceC0127ab interfaceC0127ab = this.f663a;
            C0617tn apply = this.c.apply(thread);
            An an = this.d;
            Thread a2 = an.f346a.a();
            ArrayList a3 = an.a(a2, thread);
            if (thread != a2) {
                try {
                    stackTraceElementArr = an.f346a.b();
                    if (stackTraceElementArr == null) {
                        try {
                            stackTraceElementArr = a2.getStackTrace();
                        } catch (SecurityException unused) {
                        }
                    }
                } catch (SecurityException unused2) {
                    stackTraceElementArr = null;
                }
                a3.add(0, (C0617tn) an.b.apply(a2, stackTraceElementArr));
            }
            interfaceC0127ab.a(th, new U(apply, a3, this.b.b()));
        } catch (Throwable th2) {
            LoggerStorage.getMainPublicOrAnonymousLogger().error(th2, th2.getMessage(), new Object[0]);
        }
    }
}
