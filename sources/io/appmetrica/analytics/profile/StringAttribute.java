package io.appmetrica.analytics.profile;

import io.appmetrica.analytics.impl.C0588t4;
import io.appmetrica.analytics.impl.C0615u6;
import io.appmetrica.analytics.impl.Ci;
import io.appmetrica.analytics.impl.InterfaceC0254fo;
import io.appmetrica.analytics.impl.InterfaceC0361k2;
import io.appmetrica.analytics.impl.Mn;
import io.appmetrica.analytics.impl.Yk;
import io.appmetrica.analytics.impl.Ym;
import io.appmetrica.analytics.impl.Zm;
import io.appmetrica.analytics.impl.to;
/* loaded from: classes5.dex */
public class StringAttribute {

    /* renamed from: a  reason: collision with root package name */
    private final Mn f1422a;
    private final C0615u6 b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public StringAttribute(String str, Ym ym, to toVar, InterfaceC0361k2 interfaceC0361k2) {
        this.b = new C0615u6(str, toVar, interfaceC0361k2);
        this.f1422a = ym;
    }

    public UserProfileUpdate<? extends InterfaceC0254fo> withValue(String str) {
        C0615u6 c0615u6 = this.b;
        return new UserProfileUpdate<>(new Zm(c0615u6.c, str, this.f1422a, c0615u6.f1242a, new C0588t4(c0615u6.b)));
    }

    public UserProfileUpdate<? extends InterfaceC0254fo> withValueIfUndefined(String str) {
        C0615u6 c0615u6 = this.b;
        return new UserProfileUpdate<>(new Zm(c0615u6.c, str, this.f1422a, c0615u6.f1242a, new Yk(c0615u6.b)));
    }

    public UserProfileUpdate<? extends InterfaceC0254fo> withValueReset() {
        C0615u6 c0615u6 = this.b;
        return new UserProfileUpdate<>(new Ci(0, c0615u6.c, c0615u6.f1242a, c0615u6.b));
    }
}
