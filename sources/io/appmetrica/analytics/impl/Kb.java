package io.appmetrica.analytics.impl;
/* loaded from: classes3.dex */
public final class Kb implements InterfaceC0153c {

    /* renamed from: a  reason: collision with root package name */
    public final InterfaceC0257g0 f559a;
    public final Fn b = new Fn();

    public Kb(InterfaceC0257g0 interfaceC0257g0) {
        this.f559a = interfaceC0257g0;
    }

    public static final void a(Kb kb, V v) {
        kb.f559a.a(v);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0153c
    public final void onAppNotResponding() {
        StackTraceElement[] stackTraceElementArr;
        Fn fn = this.b;
        Thread a2 = fn.f480a.a();
        try {
            stackTraceElementArr = fn.f480a.b();
            if (stackTraceElementArr == null) {
                try {
                    stackTraceElementArr = a2.getStackTrace();
                } catch (SecurityException unused) {
                }
            }
        } catch (SecurityException unused2) {
            stackTraceElementArr = null;
        }
        final V v = new V((C0733yn) fn.b.apply(a2, stackTraceElementArr), fn.a(a2, null), fn.c.a());
        ((G9) C0338j4.l().c.a()).b.post(new Runnable() { // from class: io.appmetrica.analytics.impl.Kb$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                Kb.a(Kb.this, v);
            }
        });
    }
}
