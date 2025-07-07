package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public final class Wb implements InterfaceC0175c {

    /* renamed from: a  reason: collision with root package name */
    public final InterfaceC0227e0 f685a;
    public final C0723xn b = new C0723xn();

    public Wb(InterfaceC0227e0 interfaceC0227e0) {
        this.f685a = interfaceC0227e0;
    }

    public static final void a(Wb wb, U u) {
        wb.f685a.a(u);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0175c
    public final void onAppNotResponding() {
        StackTraceElement[] stackTraceElementArr;
        C0723xn c0723xn = this.b;
        Thread a2 = c0723xn.f1132a.a();
        try {
            stackTraceElementArr = c0723xn.f1132a.b();
            if (stackTraceElementArr == null) {
                try {
                    stackTraceElementArr = a2.getStackTrace();
                } catch (SecurityException unused) {
                }
            }
        } catch (SecurityException unused2) {
            stackTraceElementArr = null;
        }
        final U u = new U((C0549qn) c0723xn.b.apply(a2, stackTraceElementArr), c0723xn.a(a2, null), c0723xn.c.b());
        ((S9) C0704x4.l().c.a()).b.post(new Runnable() { // from class: io.appmetrica.analytics.impl.Wb$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                Wb.a(Wb.this, u);
            }
        });
    }
}
