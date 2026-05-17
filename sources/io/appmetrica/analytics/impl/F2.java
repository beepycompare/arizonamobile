package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public abstract class F2 {

    /* renamed from: a  reason: collision with root package name */
    public final Ff f582a;
    public final Ea b;

    public F2(Ff ff, Ea ea) {
        this.f582a = ff;
        this.b = ea;
    }

    public final boolean a(P5 p5, E2 e2) {
        for (Object obj : ((V8) this.f582a.a(p5.d)).f829a) {
            if (e2.a(obj, p5)) {
                return true;
            }
        }
        return false;
    }

    public final Ff b() {
        return this.f582a;
    }

    public final Ea a() {
        return this.b;
    }
}
