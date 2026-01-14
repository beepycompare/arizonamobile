package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.z4  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0742z4 {

    /* renamed from: a  reason: collision with root package name */
    public final Fb f1329a;

    public C0742z4() {
        this(C0449na.k().l());
    }

    public static E4 a(C0692x4 c0692x4) {
        return new E4(new C4(c0692x4), c0692x4);
    }

    public C0742z4(Fb fb) {
        this.f1329a = fb;
    }

    public final C0412ln a(C0692x4 c0692x4, Am am) {
        C0412ln c0412ln = new C0412ln(c0692x4, new Ig(am));
        Fb fb = this.f1329a;
        synchronized (fb) {
            fb.c.add(c0412ln);
        }
        return c0412ln;
    }
}
