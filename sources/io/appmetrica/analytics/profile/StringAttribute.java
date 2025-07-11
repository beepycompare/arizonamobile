package io.appmetrica.analytics.profile;

import io.appmetrica.analytics.impl.Fn;
import io.appmetrica.analytics.impl.InterfaceC0495p2;
import io.appmetrica.analytics.impl.L6;
import io.appmetrica.analytics.impl.Li;
import io.appmetrica.analytics.impl.N4;
import io.appmetrica.analytics.impl.Tm;
import io.appmetrica.analytics.impl.Um;
import io.appmetrica.analytics.impl.Vk;
import io.appmetrica.analytics.impl.Yn;
import io.appmetrica.analytics.impl.mo;
/* loaded from: classes4.dex */
public class StringAttribute {

    /* renamed from: a  reason: collision with root package name */
    private final Fn f1258a;
    private final L6 b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public StringAttribute(String str, Tm tm, mo moVar, InterfaceC0495p2 interfaceC0495p2) {
        this.b = new L6(str, moVar, interfaceC0495p2);
        this.f1258a = tm;
    }

    public UserProfileUpdate<? extends Yn> withValue(String str) {
        L6 l6 = this.b;
        return new UserProfileUpdate<>(new Um(l6.c, str, this.f1258a, l6.f514a, new N4(l6.b)));
    }

    public UserProfileUpdate<? extends Yn> withValueIfUndefined(String str) {
        L6 l6 = this.b;
        return new UserProfileUpdate<>(new Um(l6.c, str, this.f1258a, l6.f514a, new Vk(l6.b)));
    }

    public UserProfileUpdate<? extends Yn> withValueReset() {
        L6 l6 = this.b;
        return new UserProfileUpdate<>(new Li(0, l6.c, l6.f514a, l6.b));
    }
}
