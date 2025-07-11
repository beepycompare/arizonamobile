package io.appmetrica.analytics.profile;

import io.appmetrica.analytics.impl.C0595t3;
import io.appmetrica.analytics.impl.InterfaceC0495p2;
import io.appmetrica.analytics.impl.L6;
import io.appmetrica.analytics.impl.Li;
import io.appmetrica.analytics.impl.N4;
import io.appmetrica.analytics.impl.Vk;
import io.appmetrica.analytics.impl.Yn;
import io.appmetrica.analytics.impl.mo;
/* loaded from: classes4.dex */
public class BooleanAttribute {

    /* renamed from: a  reason: collision with root package name */
    private final L6 f1253a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BooleanAttribute(String str, mo moVar, InterfaceC0495p2 interfaceC0495p2) {
        this.f1253a = new L6(str, moVar, interfaceC0495p2);
    }

    public UserProfileUpdate<? extends Yn> withValue(boolean z) {
        L6 l6 = this.f1253a;
        return new UserProfileUpdate<>(new C0595t3(l6.c, z, l6.f514a, new N4(l6.b)));
    }

    public UserProfileUpdate<? extends Yn> withValueIfUndefined(boolean z) {
        L6 l6 = this.f1253a;
        return new UserProfileUpdate<>(new C0595t3(l6.c, z, l6.f514a, new Vk(l6.b)));
    }

    public UserProfileUpdate<? extends Yn> withValueReset() {
        L6 l6 = this.f1253a;
        return new UserProfileUpdate<>(new Li(3, l6.c, l6.f514a, l6.b));
    }
}
