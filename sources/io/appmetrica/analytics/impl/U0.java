package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.profile.UserProfile;
/* loaded from: classes5.dex */
public final class U0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UserProfile f805a;
    public final /* synthetic */ C0588t1 b;

    public U0(C0588t1 c0588t1, UserProfile userProfile) {
        this.b = c0588t1;
        this.f805a = userProfile;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0588t1.a(this.b).reportUserProfile(this.f805a);
    }
}
