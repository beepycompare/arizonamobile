package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.dc  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0200dc implements InterfaceC0161c {

    /* renamed from: a  reason: collision with root package name */
    public final InterfaceC0239f0 f842a;
    public final Jn b = new Jn();

    public C0200dc(InterfaceC0239f0 interfaceC0239f0) {
        this.f842a = interfaceC0239f0;
    }

    public static final void a(C0200dc c0200dc, U u) {
        c0200dc.f842a.a(u);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0161c
    public final void onAppNotResponding() {
        StackTraceElement[] stackTraceElementArr;
        Jn jn = this.b;
        Thread a2 = jn.f526a.a();
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
        final U u = new U((Cn) jn.b.apply(a2, stackTraceElementArr), jn.a(a2, null), jn.c.a());
        ((Z9) A4.l().c.a()).b.post(new Runnable() { // from class: io.appmetrica.analytics.impl.dc$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                C0200dc.a(C0200dc.this, u);
            }
        });
    }
}
