package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.profile.UserProfile;
/* loaded from: classes4.dex */
public final class S0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UserProfile f662a;
    public final /* synthetic */ C0548r1 b;

    public S0(C0548r1 c0548r1, UserProfile userProfile) {
        this.b = c0548r1;
        this.f662a = userProfile;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0548r1.a(this.b).reportUserProfile(this.f662a);
    }
}
