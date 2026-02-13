package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.profile.UserProfile;
/* renamed from: io.appmetrica.analytics.impl.vj  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0657vj implements Qa {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UserProfile f1273a;

    public C0657vj(UserProfile userProfile) {
        this.f1273a = userProfile;
    }

    @Override // io.appmetrica.analytics.impl.Qa
    public final void a(Ra ra) {
        ra.reportUserProfile(this.f1273a);
    }
}
