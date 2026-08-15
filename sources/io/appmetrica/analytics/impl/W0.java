package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.profile.UserProfile;
/* loaded from: classes5.dex */
public final class W0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UserProfile f818a;
    public final /* synthetic */ C0650v1 b;

    public W0(C0650v1 c0650v1, UserProfile userProfile) {
        this.b = c0650v1;
        this.f818a = userProfile;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0650v1.a(this.b).reportUserProfile(this.f818a);
    }
}
