package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.z4  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0741z4 {

    /* renamed from: a  reason: collision with root package name */
    public final Fb f1333a;

    public C0741z4() {
        this(C0448na.k().l());
    }

    public static E4 a(C0691x4 c0691x4) {
        return new E4(new C4(c0691x4), c0691x4);
    }

    public C0741z4(Fb fb) {
        this.f1333a = fb;
    }

    public final C0411ln a(C0691x4 c0691x4, Am am) {
        C0411ln c0411ln = new C0411ln(c0691x4, new Ig(am));
        Fb fb = this.f1333a;
        synchronized (fb) {
            fb.c.add(c0411ln);
        }
        return c0411ln;
    }
}
