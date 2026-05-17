package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.profile.UserProfile;
/* renamed from: io.appmetrica.analytics.impl.vj  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0656vj implements Qa {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UserProfile f1278a;

    public C0656vj(UserProfile userProfile) {
        this.f1278a = userProfile;
    }

    @Override // io.appmetrica.analytics.impl.Qa
    public final void a(Ra ra) {
        ra.reportUserProfile(this.f1278a);
    }
}
