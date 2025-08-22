package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.ac  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0121ac implements InterfaceC0160c {

    /* renamed from: a  reason: collision with root package name */
    public final InterfaceC0212e0 f775a;
    public final Fn b = new Fn();

    public C0121ac(InterfaceC0212e0 interfaceC0212e0) {
        this.f775a = interfaceC0212e0;
    }

    public static final void a(C0121ac c0121ac, U u) {
        c0121ac.f775a.a(u);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0160c
    public final void onAppNotResponding() {
        StackTraceElement[] stackTraceElementArr;
        Fn fn = this.b;
        Thread a2 = fn.f442a.a();
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
        final U u = new U((C0740yn) fn.b.apply(a2, stackTraceElementArr), fn.a(a2, null), fn.c.a());
        ((W9) C0696x4.l().c.a()).b.post(new Runnable() { // from class: io.appmetrica.analytics.impl.ac$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                C0121ac.a(C0121ac.this, u);
            }
        });
    }
}
