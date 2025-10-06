package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.logger.LoggerStorage;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes4.dex */
public final class W1 implements Thread.UncaughtExceptionHandler {
    public static final AtomicBoolean e = new AtomicBoolean();

    /* renamed from: a  reason: collision with root package name */
    public final InterfaceC0250fb f721a;
    public final Q6 b = A4.l().n();
    public final N6 c = new N6();
    public final Jn d = new Jn();

    public W1(J6 j6) {
        this.f721a = j6;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(Thread thread, Throwable th) {
        StackTraceElement[] stackTraceElementArr;
        try {
            e.set(true);
            InterfaceC0250fb interfaceC0250fb = this.f721a;
            Cn apply = this.c.apply(thread);
            Jn jn = this.d;
            Thread a2 = jn.f526a.a();
            ArrayList a3 = jn.a(a2, thread);
            if (thread != a2) {
                try {
                    stackTraceElementArr = jn.f526a.b();
                    if (stackTraceElementArr == null) {
                        try {
                            stackTraceElementArr = a2.getStackTrace();
                        } catch (SecurityException unused) {
                        }
                    }
                } catch (SecurityException unused2) {
                    stackTraceElementArr = null;
                }
                a3.add(0, (Cn) jn.b.apply(a2, stackTraceElementArr));
            }
            interfaceC0250fb.a(th, new U(apply, a3, this.b.f637a.a()));
        } catch (Throwable th2) {
            LoggerStorage.getMainPublicOrAnonymousLogger().error(th2, th2.getMessage(), new Object[0]);
        }
    }
}
