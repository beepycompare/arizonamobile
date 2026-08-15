package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.profile.UserProfile;
/* loaded from: classes5.dex */
public final class Vj implements InterfaceC0479ob {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UserProfile f813a;

    public Vj(UserProfile userProfile) {
        this.f813a = userProfile;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0479ob
    public final void a(InterfaceC0505pb interfaceC0505pb) {
        interfaceC0505pb.reportUserProfile(this.f813a);
    }
}
