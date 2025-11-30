package io.appmetrica.analytics.profile;

import io.appmetrica.analytics.impl.C0546rb;
import io.appmetrica.analytics.impl.C0616u6;
import io.appmetrica.analytics.impl.Hb;
import io.appmetrica.analytics.impl.InterfaceC0255fo;
import io.appmetrica.analytics.impl.R5;
/* loaded from: classes5.dex */
public final class CounterAttribute {

    /* renamed from: a  reason: collision with root package name */
    private final C0616u6 f1317a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CounterAttribute(String str, C0546rb c0546rb, Hb hb) {
        this.f1317a = new C0616u6(str, c0546rb, hb);
    }

    public UserProfileUpdate<? extends InterfaceC0255fo> withDelta(double d) {
        return new UserProfileUpdate<>(new R5(this.f1317a.c, d));
    }
}
