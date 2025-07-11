package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.profile.UserProfile;
/* loaded from: classes4.dex */
public final class Q0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UserProfile f588a;
    public final /* synthetic */ C0494p1 b;

    public Q0(C0494p1 c0494p1, UserProfile userProfile) {
        this.b = c0494p1;
        this.f588a = userProfile;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0494p1.a(this.b).reportUserProfile(this.f588a);
    }
}
