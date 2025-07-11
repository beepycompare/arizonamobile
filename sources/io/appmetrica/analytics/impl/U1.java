package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.logger.LoggerStorage;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes4.dex */
public final class U1 implements Thread.UncaughtExceptionHandler {
    public static final AtomicBoolean e = new AtomicBoolean();

    /* renamed from: a  reason: collision with root package name */
    public final Ya f651a;
    public final J6 b = C0696x4.l().n();
    public final H6 c = new H6();
    public final C0715xn d = new C0715xn();

    public U1(D6 d6) {
        this.f651a = d6;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(Thread thread, Throwable th) {
        StackTraceElement[] stackTraceElementArr;
        try {
            e.set(true);
            Ya ya = this.f651a;
            C0541qn apply = this.c.apply(thread);
            C0715xn c0715xn = this.d;
            Thread a2 = c0715xn.f1133a.a();
            ArrayList a3 = c0715xn.a(a2, thread);
            if (thread != a2) {
                try {
                    stackTraceElementArr = c0715xn.f1133a.b();
                    if (stackTraceElementArr == null) {
                        try {
                            stackTraceElementArr = a2.getStackTrace();
                        } catch (SecurityException unused) {
                        }
                    }
                } catch (SecurityException unused2) {
                    stackTraceElementArr = null;
                }
                a3.add(0, (C0541qn) c0715xn.b.apply(a2, stackTraceElementArr));
            }
            ya.a(th, new U(apply, a3, this.b.b()));
        } catch (Throwable th2) {
            LoggerStorage.getMainPublicOrAnonymousLogger().error(th2, th2.getMessage(), new Object[0]);
        }
    }
}
