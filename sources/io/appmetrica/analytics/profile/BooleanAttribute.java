package io.appmetrica.analytics.profile;

import io.appmetrica.analytics.impl.A6;
import io.appmetrica.analytics.impl.C0175cl;
import io.appmetrica.analytics.impl.C0234f3;
import io.appmetrica.analytics.impl.C0739z4;
import io.appmetrica.analytics.impl.Gi;
import io.appmetrica.analytics.impl.InterfaceC0281go;
import io.appmetrica.analytics.impl.InterfaceC0562s2;
import io.appmetrica.analytics.impl.uo;
/* loaded from: classes5.dex */
public class BooleanAttribute {

    /* renamed from: a  reason: collision with root package name */
    private final A6 f1317a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BooleanAttribute(String str, uo uoVar, InterfaceC0562s2 interfaceC0562s2) {
        this.f1317a = new A6(str, uoVar, interfaceC0562s2);
    }

    public UserProfileUpdate<? extends InterfaceC0281go> withValue(boolean z) {
        A6 a6 = this.f1317a;
        return new UserProfileUpdate<>(new C0234f3(a6.c, z, a6.f391a, new C0739z4(a6.b)));
    }

    public UserProfileUpdate<? extends InterfaceC0281go> withValueIfUndefined(boolean z) {
        A6 a6 = this.f1317a;
        return new UserProfileUpdate<>(new C0234f3(a6.c, z, a6.f391a, new C0175cl(a6.b)));
    }

    public UserProfileUpdate<? extends InterfaceC0281go> withValueReset() {
        A6 a6 = this.f1317a;
        return new UserProfileUpdate<>(new Gi(3, a6.c, a6.f391a, a6.b));
    }
}
