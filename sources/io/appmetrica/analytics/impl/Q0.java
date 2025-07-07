package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.profile.UserProfile;
/* loaded from: classes4.dex */
public final class Q0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UserProfile f587a;
    public final /* synthetic */ C0502p1 b;

    public Q0(C0502p1 c0502p1, UserProfile userProfile) {
        this.b = c0502p1;
        this.f587a = userProfile;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0502p1.a(this.b).reportUserProfile(this.f587a);
    }
}
