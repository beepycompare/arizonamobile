package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.profile.UserProfile;
/* loaded from: classes4.dex */
public final class S0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UserProfile f661a;
    public final /* synthetic */ C0547r1 b;

    public S0(C0547r1 c0547r1, UserProfile userProfile) {
        this.b = c0547r1;
        this.f661a = userProfile;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0547r1.a(this.b).reportUserProfile(this.f661a);
    }
}
