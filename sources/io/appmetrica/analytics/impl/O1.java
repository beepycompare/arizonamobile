package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.logger.LoggerStorage;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes5.dex */
public final class O1 implements Thread.UncaughtExceptionHandler {
    public static final AtomicBoolean e = new AtomicBoolean();

    /* renamed from: a  reason: collision with root package name */
    public final Fa f723a;
    public final C0543r6 b = C0135b4.l().n();
    public final C0469o6 c = new C0469o6();
    public final Dn d = new Dn();

    public O1(C0369k6 c0369k6) {
        this.f723a = c0369k6;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(Thread thread, Throwable th) {
        StackTraceElement[] stackTraceElementArr;
        try {
            e.set(true);
            Fa fa = this.f723a;
            C0685wn apply = this.c.apply(thread);
            Dn dn = this.d;
            Thread a2 = dn.f561a.a();
            ArrayList a3 = dn.a(a2, thread);
            if (thread != a2) {
                try {
                    stackTraceElementArr = dn.f561a.b();
                    if (stackTraceElementArr == null) {
                        try {
                            stackTraceElementArr = a2.getStackTrace();
                        } catch (SecurityException unused) {
                        }
                    }
                } catch (SecurityException unused2) {
                    stackTraceElementArr = null;
                }
                a3.add(0, (C0685wn) dn.b.apply(a2, stackTraceElementArr));
            }
            fa.a(th, new V(apply, a3, this.b.f1207a.a()));
        } catch (Throwable th2) {
            LoggerStorage.getMainPublicOrAnonymousLogger().error(th2, th2.getMessage(), new Object[0]);
        }
    }
}
