package io.appmetrica.analytics.profile;

import io.appmetrica.analytics.impl.C0589t4;
import io.appmetrica.analytics.impl.C0616u6;
import io.appmetrica.analytics.impl.Ci;
import io.appmetrica.analytics.impl.InterfaceC0255fo;
import io.appmetrica.analytics.impl.InterfaceC0362k2;
import io.appmetrica.analytics.impl.Y2;
import io.appmetrica.analytics.impl.Yk;
import io.appmetrica.analytics.impl.to;
/* loaded from: classes5.dex */
public class BooleanAttribute {

    /* renamed from: a  reason: collision with root package name */
    private final C0616u6 f1316a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BooleanAttribute(String str, to toVar, InterfaceC0362k2 interfaceC0362k2) {
        this.f1316a = new C0616u6(str, toVar, interfaceC0362k2);
    }

    public UserProfileUpdate<? extends InterfaceC0255fo> withValue(boolean z) {
        C0616u6 c0616u6 = this.f1316a;
        return new UserProfileUpdate<>(new Y2(c0616u6.c, z, c0616u6.f1144a, new C0589t4(c0616u6.b)));
    }

    public UserProfileUpdate<? extends InterfaceC0255fo> withValueIfUndefined(boolean z) {
        C0616u6 c0616u6 = this.f1316a;
        return new UserProfileUpdate<>(new Y2(c0616u6.c, z, c0616u6.f1144a, new Yk(c0616u6.b)));
    }

    public UserProfileUpdate<? extends InterfaceC0255fo> withValueReset() {
        C0616u6 c0616u6 = this.f1316a;
        return new UserProfileUpdate<>(new Ci(3, c0616u6.c, c0616u6.f1144a, c0616u6.b));
    }
}
