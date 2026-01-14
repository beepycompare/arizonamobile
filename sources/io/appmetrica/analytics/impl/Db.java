package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public final class Db implements InterfaceC0157c {

    /* renamed from: a  reason: collision with root package name */
    public final InterfaceC0261g0 f549a;
    public final Dn b = new Dn();

    public Db(InterfaceC0261g0 interfaceC0261g0) {
        this.f549a = interfaceC0261g0;
    }

    public static final void a(Db db, V v) {
        db.f549a.a(v);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0157c
    public final void onAppNotResponding() {
        StackTraceElement[] stackTraceElementArr;
        Dn dn = this.b;
        Thread a2 = dn.f557a.a();
        try {
            stackTraceElementArr = dn.f557a.b();
            if (stackTraceElementArr == null) {
                try {
                    stackTraceElementArr = a2.getStackTrace();
                } catch (SecurityException unused) {
                }
            }
        } catch (SecurityException unused2) {
            stackTraceElementArr = null;
        }
        final V v = new V((C0686wn) dn.b.apply(a2, stackTraceElementArr), dn.a(a2, null), dn.c.a());
        ((C0747z9) C0136b4.l().c.a()).b.post(new Runnable() { // from class: io.appmetrica.analytics.impl.Db$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                Db.a(Db.this, v);
            }
        });
    }
}
