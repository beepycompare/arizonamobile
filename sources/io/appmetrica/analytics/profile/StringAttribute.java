package io.appmetrica.analytics.profile;

import io.appmetrica.analytics.impl.C0589t4;
import io.appmetrica.analytics.impl.C0616u6;
import io.appmetrica.analytics.impl.Ci;
import io.appmetrica.analytics.impl.InterfaceC0255fo;
import io.appmetrica.analytics.impl.InterfaceC0362k2;
import io.appmetrica.analytics.impl.Mn;
import io.appmetrica.analytics.impl.Yk;
import io.appmetrica.analytics.impl.Ym;
import io.appmetrica.analytics.impl.Zm;
import io.appmetrica.analytics.impl.to;
/* loaded from: classes5.dex */
public class StringAttribute {

    /* renamed from: a  reason: collision with root package name */
    private final Mn f1324a;
    private final C0616u6 b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public StringAttribute(String str, Ym ym, to toVar, InterfaceC0362k2 interfaceC0362k2) {
        this.b = new C0616u6(str, toVar, interfaceC0362k2);
        this.f1324a = ym;
    }

    public UserProfileUpdate<? extends InterfaceC0255fo> withValue(String str) {
        C0616u6 c0616u6 = this.b;
        return new UserProfileUpdate<>(new Zm(c0616u6.c, str, this.f1324a, c0616u6.f1144a, new C0589t4(c0616u6.b)));
    }

    public UserProfileUpdate<? extends InterfaceC0255fo> withValueIfUndefined(String str) {
        C0616u6 c0616u6 = this.b;
        return new UserProfileUpdate<>(new Zm(c0616u6.c, str, this.f1324a, c0616u6.f1144a, new Yk(c0616u6.b)));
    }

    public UserProfileUpdate<? extends InterfaceC0255fo> withValueReset() {
        C0616u6 c0616u6 = this.b;
        return new UserProfileUpdate<>(new Ci(0, c0616u6.c, c0616u6.f1144a, c0616u6.b));
    }
}
