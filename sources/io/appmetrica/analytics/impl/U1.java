package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.logger.LoggerStorage;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes4.dex */
public final class U1 implements Thread.UncaughtExceptionHandler {
    public static final AtomicBoolean e = new AtomicBoolean();

    /* renamed from: a  reason: collision with root package name */
    public final InterfaceC0172cb f670a;
    public final N6 b = C0696x4.l().n();
    public final K6 c = new K6();
    public final Fn d = new Fn();

    public U1(G6 g6) {
        this.f670a = g6;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(Thread thread, Throwable th) {
        StackTraceElement[] stackTraceElementArr;
        try {
            e.set(true);
            InterfaceC0172cb interfaceC0172cb = this.f670a;
            C0740yn apply = this.c.apply(thread);
            Fn fn = this.d;
            Thread a2 = fn.f442a.a();
            ArrayList a3 = fn.a(a2, thread);
            if (thread != a2) {
                try {
                    stackTraceElementArr = fn.f442a.b();
                    if (stackTraceElementArr == null) {
                        try {
                            stackTraceElementArr = a2.getStackTrace();
                        } catch (SecurityException unused) {
                        }
                    }
                } catch (SecurityException unused2) {
                    stackTraceElementArr = null;
                }
                a3.add(0, (C0740yn) fn.b.apply(a2, stackTraceElementArr));
            }
            interfaceC0172cb.a(th, new U(apply, a3, this.b.f574a.a()));
        } catch (Throwable th2) {
            LoggerStorage.getMainPublicOrAnonymousLogger().error(th2, th2.getMessage(), new Object[0]);
        }
    }
}
