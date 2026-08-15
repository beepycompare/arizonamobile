package io.appmetrica.analytics.profile;

import io.appmetrica.analytics.impl.An;
import io.appmetrica.analytics.impl.C0776zn;
import io.appmetrica.analytics.impl.Cl;
import io.appmetrica.analytics.impl.Ho;
import io.appmetrica.analytics.impl.InterfaceC0492oo;
import io.appmetrica.analytics.impl.InterfaceC0677w2;
import io.appmetrica.analytics.impl.J4;
import io.appmetrica.analytics.impl.L6;
import io.appmetrica.analytics.impl.Vi;
import io.appmetrica.analytics.impl.Vo;
/* loaded from: classes5.dex */
public class StringAttribute {

    /* renamed from: a  reason: collision with root package name */
    private final InterfaceC0492oo f1420a;
    private final L6 b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public StringAttribute(String str, C0776zn c0776zn, Vo vo, InterfaceC0677w2 interfaceC0677w2) {
        this.b = new L6(str, vo, interfaceC0677w2);
        this.f1420a = c0776zn;
    }

    public UserProfileUpdate<? extends Ho> withValue(String str) {
        L6 l6 = this.b;
        return new UserProfileUpdate<>(new An(l6.c, str, this.f1420a, l6.f644a, new J4(l6.b)));
    }

    public UserProfileUpdate<? extends Ho> withValueIfUndefined(String str) {
        L6 l6 = this.b;
        return new UserProfileUpdate<>(new An(l6.c, str, this.f1420a, l6.f644a, new Cl(l6.b)));
    }

    public UserProfileUpdate<? extends Ho> withValueReset() {
        L6 l6 = this.b;
        return new UserProfileUpdate<>(new Vi(0, l6.c, l6.f644a, l6.b));
    }
}
