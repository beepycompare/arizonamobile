package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.profile.UserProfile;
/* loaded from: classes4.dex */
public final class Rj implements InterfaceC0534qb {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UserProfile f659a;

    public Rj(UserProfile userProfile) {
        this.f659a = userProfile;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0534qb
    public final void a(InterfaceC0558rb interfaceC0558rb) {
        interfaceC0558rb.reportUserProfile(this.f659a);
    }
}
