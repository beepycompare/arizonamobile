package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.profile.UserProfile;
/* loaded from: classes5.dex */
public final class Oh implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UserProfile f719a;
    public final /* synthetic */ C0300hi b;

    public Oh(C0300hi c0300hi, UserProfile userProfile) {
        this.b = c0300hi;
        this.f719a = userProfile;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0300hi c0300hi = this.b;
        C0300hi.a(c0300hi.f1023a, c0300hi.d, c0300hi.e).reportUserProfile(this.f719a);
    }
}
