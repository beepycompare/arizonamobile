package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public final class Yb implements InterfaceC0168c {

    /* renamed from: a  reason: collision with root package name */
    public final InterfaceC0220e0 f732a;
    public final An b = new An();

    public Yb(InterfaceC0220e0 interfaceC0220e0) {
        this.f732a = interfaceC0220e0;
    }

    public static final void a(Yb yb, U u) {
        yb.f732a.a(u);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0168c
    public final void onAppNotResponding() {
        StackTraceElement[] stackTraceElementArr;
        An an = this.b;
        Thread a2 = an.f345a.a();
        try {
            stackTraceElementArr = an.f345a.b();
            if (stackTraceElementArr == null) {
                try {
                    stackTraceElementArr = a2.getStackTrace();
                } catch (SecurityException unused) {
                }
            }
        } catch (SecurityException unused2) {
            stackTraceElementArr = null;
        }
        final U u = new U((C0618tn) an.b.apply(a2, stackTraceElementArr), an.a(a2, null), an.c.b());
        ((U9) C0699x4.l().c.a()).b.post(new Runnable() { // from class: io.appmetrica.analytics.impl.Yb$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                Yb.a(Yb.this, u);
            }
        });
    }
}
