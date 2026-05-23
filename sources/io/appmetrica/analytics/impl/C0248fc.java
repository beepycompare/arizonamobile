package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.fc  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0248fc implements InterfaceC0158c {

    /* renamed from: a  reason: collision with root package name */
    public final InterfaceC0314i0 f977a;
    public final C0286go b = new C0286go();

    public C0248fc(InterfaceC0314i0 interfaceC0314i0) {
        this.f977a = interfaceC0314i0;
    }

    public static final void a(C0248fc c0248fc, X x) {
        c0248fc.f977a.a(x);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0158c
    public final void onAppNotResponding() {
        StackTraceElement[] stackTraceElementArr;
        C0286go c0286go = this.b;
        Thread a2 = c0286go.f1002a.a();
        try {
            stackTraceElementArr = c0286go.f1002a.b();
            if (stackTraceElementArr == null) {
                try {
                    stackTraceElementArr = a2.getStackTrace();
                } catch (SecurityException unused) {
                }
            }
        } catch (SecurityException unused2) {
            stackTraceElementArr = null;
        }
        final X x = new X((Zn) c0286go.b.apply(a2, stackTraceElementArr), c0286go.a(a2, null), c0286go.c.a());
        ((U9) C0576s4.l().c.a()).b.post(new Runnable() { // from class: io.appmetrica.analytics.impl.fc$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                C0248fc.a(C0248fc.this, x);
            }
        });
    }
}
