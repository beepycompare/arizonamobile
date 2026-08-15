package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.fc  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0247fc implements InterfaceC0157c {

    /* renamed from: a  reason: collision with root package name */
    public final InterfaceC0313i0 f980a;
    public final C0285go b = new C0285go();

    public C0247fc(InterfaceC0313i0 interfaceC0313i0) {
        this.f980a = interfaceC0313i0;
    }

    public static final void a(C0247fc c0247fc, X x) {
        c0247fc.f980a.a(x);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0157c
    public final void onAppNotResponding() {
        StackTraceElement[] stackTraceElementArr;
        C0285go c0285go = this.b;
        Thread a2 = c0285go.f1005a.a();
        try {
            stackTraceElementArr = c0285go.f1005a.b();
            if (stackTraceElementArr == null) {
                try {
                    stackTraceElementArr = a2.getStackTrace();
                } catch (SecurityException unused) {
                }
            }
        } catch (SecurityException unused2) {
            stackTraceElementArr = null;
        }
        final X x = new X((Zn) c0285go.b.apply(a2, stackTraceElementArr), c0285go.a(a2, null), c0285go.c.a());
        ((U9) C0575s4.l().c.a()).b.post(new Runnable() { // from class: io.appmetrica.analytics.impl.fc$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                C0247fc.a(C0247fc.this, x);
            }
        });
    }
}
