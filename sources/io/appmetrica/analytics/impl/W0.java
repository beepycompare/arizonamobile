package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.profile.UserProfile;
/* loaded from: classes5.dex */
public final class W0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UserProfile f815a;
    public final /* synthetic */ C0651v1 b;

    public W0(C0651v1 c0651v1, UserProfile userProfile) {
        this.b = c0651v1;
        this.f815a = userProfile;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0651v1.a(this.b).reportUserProfile(this.f815a);
    }
}
