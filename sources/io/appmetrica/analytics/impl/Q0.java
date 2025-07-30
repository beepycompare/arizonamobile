package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.profile.UserProfile;
/* loaded from: classes4.dex */
public final class Q0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UserProfile f605a;
    public final /* synthetic */ C0496p1 b;

    public Q0(C0496p1 c0496p1, UserProfile userProfile) {
        this.b = c0496p1;
        this.f605a = userProfile;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0496p1.a(this.b).reportUserProfile(this.f605a);
    }
}
