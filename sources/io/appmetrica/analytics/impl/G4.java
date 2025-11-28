package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public final class G4 {

    /* renamed from: a  reason: collision with root package name */
    public final Mb f485a;

    public G4() {
        this(C0620ua.k().l());
    }

    public static L4 a(E4 e4) {
        return new L4(new J4(e4), e4);
    }

    public G4(Mb mb) {
        this.f485a = mb;
    }

    public final C0484on a(E4 e4, Em em) {
        C0484on c0484on = new C0484on(e4, new Ng(em));
        Mb mb = this.f485a;
        synchronized (mb) {
            mb.c.add(c0484on);
        }
        return c0484on;
    }
}
