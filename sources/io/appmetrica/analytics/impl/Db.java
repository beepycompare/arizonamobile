package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public final class Db implements InterfaceC0156c {

    /* renamed from: a  reason: collision with root package name */
    public final InterfaceC0260g0 f553a;
    public final Dn b = new Dn();

    public Db(InterfaceC0260g0 interfaceC0260g0) {
        this.f553a = interfaceC0260g0;
    }

    public static final void a(Db db, V v) {
        db.f553a.a(v);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0156c
    public final void onAppNotResponding() {
        StackTraceElement[] stackTraceElementArr;
        Dn dn = this.b;
        Thread a2 = dn.f561a.a();
        try {
            stackTraceElementArr = dn.f561a.b();
            if (stackTraceElementArr == null) {
                try {
                    stackTraceElementArr = a2.getStackTrace();
                } catch (SecurityException unused) {
                }
            }
        } catch (SecurityException unused2) {
            stackTraceElementArr = null;
        }
        final V v = new V((C0685wn) dn.b.apply(a2, stackTraceElementArr), dn.a(a2, null), dn.c.a());
        ((C0746z9) C0135b4.l().c.a()).b.post(new Runnable() { // from class: io.appmetrica.analytics.impl.Db$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                Db.a(Db.this, v);
            }
        });
    }
}
