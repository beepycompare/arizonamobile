package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.profile.UserProfile;
/* loaded from: classes5.dex */
public final class U0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UserProfile f806a;
    public final /* synthetic */ C0589t1 b;

    public U0(C0589t1 c0589t1, UserProfile userProfile) {
        this.b = c0589t1;
        this.f806a = userProfile;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0589t1.a(this.b).reportUserProfile(this.f806a);
    }
}
