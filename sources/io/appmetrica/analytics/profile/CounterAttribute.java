package io.appmetrica.analytics.profile;

import io.appmetrica.analytics.impl.C0545rb;
import io.appmetrica.analytics.impl.C0615u6;
import io.appmetrica.analytics.impl.Hb;
import io.appmetrica.analytics.impl.InterfaceC0254fo;
import io.appmetrica.analytics.impl.R5;
/* loaded from: classes5.dex */
public final class CounterAttribute {

    /* renamed from: a  reason: collision with root package name */
    private final C0615u6 f1415a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CounterAttribute(String str, C0545rb c0545rb, Hb hb) {
        this.f1415a = new C0615u6(str, c0545rb, hb);
    }

    public UserProfileUpdate<? extends InterfaceC0254fo> withDelta(double d) {
        return new UserProfileUpdate<>(new R5(this.f1415a.c, d));
    }
}
