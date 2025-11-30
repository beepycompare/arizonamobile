package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public abstract class G2 {

    /* renamed from: a  reason: collision with root package name */
    public final Gf f489a;
    public final Fa b;

    public G2(Gf gf, Fa fa) {
        this.f489a = gf;
        this.b = fa;
    }

    public final boolean a(Q5 q5, F2 f2) {
        for (Object obj : ((W8) this.f489a.a(q5.d)).f736a) {
            if (f2.a(obj, q5)) {
                return true;
            }
        }
        return false;
    }

    public final Gf b() {
        return this.f489a;
    }

    public final Fa a() {
        return this.b;
    }
}
