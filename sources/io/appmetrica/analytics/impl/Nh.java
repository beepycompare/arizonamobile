package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.profile.UserProfile;
/* loaded from: classes5.dex */
public final class Nh implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UserProfile f710a;
    public final /* synthetic */ C0279gi b;

    public Nh(C0279gi c0279gi, UserProfile userProfile) {
        this.b = c0279gi;
        this.f710a = userProfile;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0279gi c0279gi = this.b;
        C0279gi.a(c0279gi.f1015a, c0279gi.d, c0279gi.e).reportUserProfile(this.f710a);
    }
}
