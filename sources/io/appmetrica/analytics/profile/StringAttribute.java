package io.appmetrica.analytics.profile;

import io.appmetrica.analytics.impl.A6;
import io.appmetrica.analytics.impl.C0125an;
import io.appmetrica.analytics.impl.C0151bn;
import io.appmetrica.analytics.impl.C0175cl;
import io.appmetrica.analytics.impl.C0739z4;
import io.appmetrica.analytics.impl.Gi;
import io.appmetrica.analytics.impl.InterfaceC0281go;
import io.appmetrica.analytics.impl.InterfaceC0562s2;
import io.appmetrica.analytics.impl.Nn;
import io.appmetrica.analytics.impl.uo;
/* loaded from: classes3.dex */
public class StringAttribute {

    /* renamed from: a  reason: collision with root package name */
    private final Nn f1322a;
    private final A6 b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public StringAttribute(String str, C0125an c0125an, uo uoVar, InterfaceC0562s2 interfaceC0562s2) {
        this.b = new A6(str, uoVar, interfaceC0562s2);
        this.f1322a = c0125an;
    }

    public UserProfileUpdate<? extends InterfaceC0281go> withValue(String str) {
        A6 a6 = this.b;
        return new UserProfileUpdate<>(new C0151bn(a6.c, str, this.f1322a, a6.f391a, new C0739z4(a6.b)));
    }

    public UserProfileUpdate<? extends InterfaceC0281go> withValueIfUndefined(String str) {
        A6 a6 = this.b;
        return new UserProfileUpdate<>(new C0151bn(a6.c, str, this.f1322a, a6.f391a, new C0175cl(a6.b)));
    }

    public UserProfileUpdate<? extends InterfaceC0281go> withValueReset() {
        A6 a6 = this.b;
        return new UserProfileUpdate<>(new Gi(0, a6.c, a6.f391a, a6.b));
    }
}
