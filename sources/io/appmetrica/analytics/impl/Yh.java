package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.profile.UserProfile;
/* loaded from: classes4.dex */
public final class Yh implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UserProfile f724a;
    public final /* synthetic */ C0560ri b;

    public Yh(C0560ri c0560ri, UserProfile userProfile) {
        this.b = c0560ri;
        this.f724a = userProfile;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0560ri c0560ri = this.b;
        C0560ri.a(c0560ri.f1029a, c0560ri.d, c0560ri.e).reportUserProfile(this.f724a);
    }
}
