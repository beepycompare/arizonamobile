package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.profile.UserProfile;
/* loaded from: classes5.dex */
public final class Nh implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UserProfile f710a;
    public final /* synthetic */ C0278gi b;

    public Nh(C0278gi c0278gi, UserProfile userProfile) {
        this.b = c0278gi;
        this.f710a = userProfile;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0278gi c0278gi = this.b;
        C0278gi.a(c0278gi.f1015a, c0278gi.d, c0278gi.e).reportUserProfile(this.f710a);
    }
}
