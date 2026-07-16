package io.appmetrica.analytics.impl;

import java.util.HashMap;
/* loaded from: classes5.dex */
public abstract class K4 extends AbstractC0121ae {
    public final Object f;

    public K4(int i, String str, Object obj, Vo vo, W2 w2) {
        super(i, str, vo, w2);
        this.f = obj;
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0121ae, io.appmetrica.analytics.impl.Ho
    public final void a(Go go) {
        if (f()) {
            W2 w2 = this.d;
            int i = this.b;
            Io a2 = w2.a(go, (Io) ((HashMap) go.f570a.get(i)).get(this.f888a), this);
            if (a2 != null) {
                a(a2);
            }
        }
    }

    public abstract void a(Io io2);

    public final Object g() {
        return this.f;
    }
}
