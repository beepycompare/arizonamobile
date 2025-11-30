package io.appmetrica.analytics.profile;

import io.appmetrica.analytics.impl.C0271ge;
import io.appmetrica.analytics.impl.C0440n4;
import io.appmetrica.analytics.impl.C0546rb;
import io.appmetrica.analytics.impl.C0589t4;
import io.appmetrica.analytics.impl.C0616u6;
import io.appmetrica.analytics.impl.Ci;
import io.appmetrica.analytics.impl.Hb;
import io.appmetrica.analytics.impl.InterfaceC0255fo;
import io.appmetrica.analytics.impl.Yk;
/* loaded from: classes5.dex */
public final class NumberAttribute {

    /* renamed from: a  reason: collision with root package name */
    private final C0616u6 f1323a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public NumberAttribute(String str, C0546rb c0546rb, Hb hb) {
        this.f1323a = new C0616u6(str, c0546rb, hb);
    }

    public UserProfileUpdate<? extends InterfaceC0255fo> withValue(double d) {
        return new UserProfileUpdate<>(new C0271ge(this.f1323a.c, d, new C0546rb(), new C0589t4(new Hb(new C0440n4(100)))));
    }

    public UserProfileUpdate<? extends InterfaceC0255fo> withValueIfUndefined(double d) {
        return new UserProfileUpdate<>(new C0271ge(this.f1323a.c, d, new C0546rb(), new Yk(new Hb(new C0440n4(100)))));
    }

    public UserProfileUpdate<? extends InterfaceC0255fo> withValueReset() {
        return new UserProfileUpdate<>(new Ci(1, this.f1323a.c, new C0546rb(), new Hb(new C0440n4(100))));
    }
}
