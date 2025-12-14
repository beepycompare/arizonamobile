package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.profile.UserProfile;
/* loaded from: classes5.dex */
public final class V0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UserProfile f814a;
    public final /* synthetic */ C0610u1 b;

    public V0(C0610u1 c0610u1, UserProfile userProfile) {
        this.b = c0610u1;
        this.f814a = userProfile;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0610u1.a(this.b).reportUserProfile(this.f814a);
    }
}
