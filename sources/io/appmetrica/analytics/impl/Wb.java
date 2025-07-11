package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public final class Wb implements InterfaceC0167c {

    /* renamed from: a  reason: collision with root package name */
    public final InterfaceC0219e0 f686a;
    public final C0715xn b = new C0715xn();

    public Wb(InterfaceC0219e0 interfaceC0219e0) {
        this.f686a = interfaceC0219e0;
    }

    public static final void a(Wb wb, U u) {
        wb.f686a.a(u);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0167c
    public final void onAppNotResponding() {
        StackTraceElement[] stackTraceElementArr;
        C0715xn c0715xn = this.b;
        Thread a2 = c0715xn.f1133a.a();
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
        final U u = new U((C0541qn) c0715xn.b.apply(a2, stackTraceElementArr), c0715xn.a(a2, null), c0715xn.c.b());
        ((S9) C0696x4.l().c.a()).b.post(new Runnable() { // from class: io.appmetrica.analytics.impl.Wb$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                Wb.a(Wb.this, u);
            }
        });
    }
}
