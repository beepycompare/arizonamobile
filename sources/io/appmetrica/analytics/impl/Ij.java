package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.profile.UserProfile;
/* loaded from: classes4.dex */
public final class Ij implements InterfaceC0407lb {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UserProfile f492a;

    public Ij(UserProfile userProfile) {
        this.f492a = userProfile;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0407lb
    public final void a(InterfaceC0432mb interfaceC0432mb) {
        interfaceC0432mb.reportUserProfile(this.f492a);
    }
}
