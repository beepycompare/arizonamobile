package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.logger.LoggerStorage;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
/* renamed from: io.appmetrica.analytics.impl.b2  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0135b2 implements Thread.UncaughtExceptionHandler {
    public static final AtomicBoolean e = new AtomicBoolean();

    /* renamed from: a  reason: collision with root package name */
    public final InterfaceC0299hb f900a;
    public final J6 b = C0576s4.l().n();
    public final F6 c = new F6();
    public final C0286go d = new C0286go();

    public C0135b2(A6 a6) {
        this.f900a = a6;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(Thread thread, Throwable th) {
        StackTraceElement[] stackTraceElementArr;
        try {
            e.set(true);
            InterfaceC0299hb interfaceC0299hb = this.f900a;
            Zn apply = this.c.apply(thread);
            C0286go c0286go = this.d;
            Thread a2 = c0286go.f1005a.a();
            ArrayList a3 = c0286go.a(a2, thread);
            if (thread != a2) {
                try {
                    stackTraceElementArr = c0286go.f1005a.b();
                    if (stackTraceElementArr == null) {
                        try {
                            stackTraceElementArr = a2.getStackTrace();
                        } catch (SecurityException unused) {
                        }
                    }
                } catch (SecurityException unused2) {
                    stackTraceElementArr = null;
                }
                a3.add(0, (Zn) c0286go.b.apply(a2, stackTraceElementArr));
            }
            interfaceC0299hb.a(th, new X(apply, a3, this.b.f609a.a()));
        } catch (Throwable th2) {
            LoggerStorage.getMainPublicOrAnonymousLogger().error(th2, th2.getMessage(), new Object[0]);
        }
    }
}
