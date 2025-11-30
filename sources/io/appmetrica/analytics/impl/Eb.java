package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public final class Eb implements InterfaceC0153c {

    /* renamed from: a  reason: collision with root package name */
    public final InterfaceC0257g0 f459a;
    public final En b = new En();

    public Eb(InterfaceC0257g0 interfaceC0257g0) {
        this.f459a = interfaceC0257g0;
    }

    public static final void a(Eb eb, V v) {
        eb.f459a.a(v);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0153c
    public final void onAppNotResponding() {
        StackTraceElement[] stackTraceElementArr;
        En en = this.b;
        Thread a2 = en.f467a.a();
        try {
            stackTraceElementArr = en.f467a.b();
            if (stackTraceElementArr == null) {
                try {
                    stackTraceElementArr = a2.getStackTrace();
                } catch (SecurityException unused) {
                }
            }
        } catch (SecurityException unused2) {
            stackTraceElementArr = null;
        }
        final V v = new V((C0708xn) en.b.apply(a2, stackTraceElementArr), en.a(a2, null), en.c.a());
        ((A9) C0158c4.l().c.a()).b.post(new Runnable() { // from class: io.appmetrica.analytics.impl.Eb$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                Eb.a(Eb.this, v);
            }
        });
    }
}
