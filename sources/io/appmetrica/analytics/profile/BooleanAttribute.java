package io.appmetrica.analytics.profile;

import io.appmetrica.analytics.impl.C0588t4;
import io.appmetrica.analytics.impl.C0615u6;
import io.appmetrica.analytics.impl.Ci;
import io.appmetrica.analytics.impl.InterfaceC0254fo;
import io.appmetrica.analytics.impl.InterfaceC0361k2;
import io.appmetrica.analytics.impl.Y2;
import io.appmetrica.analytics.impl.Yk;
import io.appmetrica.analytics.impl.to;
/* loaded from: classes5.dex */
public class BooleanAttribute {

    /* renamed from: a  reason: collision with root package name */
    private final C0615u6 f1399a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BooleanAttribute(String str, to toVar, InterfaceC0361k2 interfaceC0361k2) {
        this.f1399a = new C0615u6(str, toVar, interfaceC0361k2);
    }

    public UserProfileUpdate<? extends InterfaceC0254fo> withValue(boolean z) {
        C0615u6 c0615u6 = this.f1399a;
        return new UserProfileUpdate<>(new Y2(c0615u6.c, z, c0615u6.f1227a, new C0588t4(c0615u6.b)));
    }

    public UserProfileUpdate<? extends InterfaceC0254fo> withValueIfUndefined(boolean z) {
        C0615u6 c0615u6 = this.f1399a;
        return new UserProfileUpdate<>(new Y2(c0615u6.c, z, c0615u6.f1227a, new Yk(c0615u6.b)));
    }

    public UserProfileUpdate<? extends InterfaceC0254fo> withValueReset() {
        C0615u6 c0615u6 = this.f1399a;
        return new UserProfileUpdate<>(new Ci(3, c0615u6.c, c0615u6.f1227a, c0615u6.b));
    }
}
