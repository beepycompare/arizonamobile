package io.appmetrica.analytics.profile;

import io.appmetrica.analytics.impl.C0208dl;
import io.appmetrica.analytics.impl.C0595t3;
import io.appmetrica.analytics.impl.InterfaceC0288go;
import io.appmetrica.analytics.impl.InterfaceC0495p2;
import io.appmetrica.analytics.impl.N4;
import io.appmetrica.analytics.impl.P6;
import io.appmetrica.analytics.impl.Ti;
import io.appmetrica.analytics.impl.uo;
/* loaded from: classes4.dex */
public class BooleanAttribute {

    /* renamed from: a  reason: collision with root package name */
    private final P6 f1266a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BooleanAttribute(String str, uo uoVar, InterfaceC0495p2 interfaceC0495p2) {
        this.f1266a = new P6(str, uoVar, interfaceC0495p2);
    }

    public UserProfileUpdate<? extends InterfaceC0288go> withValue(boolean z) {
        P6 p6 = this.f1266a;
        return new UserProfileUpdate<>(new C0595t3(p6.c, z, p6.f600a, new N4(p6.b)));
    }

    public UserProfileUpdate<? extends InterfaceC0288go> withValueIfUndefined(boolean z) {
        P6 p6 = this.f1266a;
        return new UserProfileUpdate<>(new C0595t3(p6.c, z, p6.f600a, new C0208dl(p6.b)));
    }

    public UserProfileUpdate<? extends InterfaceC0288go> withValueReset() {
        P6 p6 = this.f1266a;
        return new UserProfileUpdate<>(new Ti(3, p6.c, p6.f600a, p6.b));
    }
}
