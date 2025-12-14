package io.appmetrica.analytics.profile;

import io.appmetrica.analytics.impl.C0270ge;
import io.appmetrica.analytics.impl.C0439n4;
import io.appmetrica.analytics.impl.C0545rb;
import io.appmetrica.analytics.impl.C0588t4;
import io.appmetrica.analytics.impl.C0615u6;
import io.appmetrica.analytics.impl.Ci;
import io.appmetrica.analytics.impl.Hb;
import io.appmetrica.analytics.impl.InterfaceC0254fo;
import io.appmetrica.analytics.impl.Yk;
/* loaded from: classes5.dex */
public final class NumberAttribute {

    /* renamed from: a  reason: collision with root package name */
    private final C0615u6 f1420a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public NumberAttribute(String str, C0545rb c0545rb, Hb hb) {
        this.f1420a = new C0615u6(str, c0545rb, hb);
    }

    public UserProfileUpdate<? extends InterfaceC0254fo> withValue(double d) {
        return new UserProfileUpdate<>(new C0270ge(this.f1420a.c, d, new C0545rb(), new C0588t4(new Hb(new C0439n4(100)))));
    }

    public UserProfileUpdate<? extends InterfaceC0254fo> withValueIfUndefined(double d) {
        return new UserProfileUpdate<>(new C0270ge(this.f1420a.c, d, new C0545rb(), new Yk(new Hb(new C0439n4(100)))));
    }

    public UserProfileUpdate<? extends InterfaceC0254fo> withValueReset() {
        return new UserProfileUpdate<>(new Ci(1, this.f1420a.c, new C0545rb(), new Hb(new C0439n4(100))));
    }
}
