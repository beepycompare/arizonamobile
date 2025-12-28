package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.profile.UserProfile;
/* renamed from: io.appmetrica.analytics.impl.wj  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0678wj implements Ra {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UserProfile f1283a;

    public C0678wj(UserProfile userProfile) {
        this.f1283a = userProfile;
    }

    @Override // io.appmetrica.analytics.impl.Ra
    public final void a(Sa sa) {
        sa.reportUserProfile(this.f1283a);
    }
}
