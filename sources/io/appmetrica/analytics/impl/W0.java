package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.profile.UserProfile;
/* loaded from: classes5.dex */
public final class W0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UserProfile f821a;
    public final /* synthetic */ C0644v1 b;

    public W0(C0644v1 c0644v1, UserProfile userProfile) {
        this.b = c0644v1;
        this.f821a = userProfile;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0644v1.a(this.b).reportUserProfile(this.f821a);
    }
}
