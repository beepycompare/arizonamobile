package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.profile.UserProfile;
/* renamed from: io.appmetrica.analytics.impl.ji  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0360ji implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UserProfile f941a;
    public final /* synthetic */ Ci b;

    public RunnableC0360ji(Ci ci, UserProfile userProfile) {
        this.b = ci;
        this.f941a = userProfile;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Ci ci = this.b;
        Ci.a(ci.f393a, ci.d, ci.e).reportUserProfile(this.f941a);
    }
}
