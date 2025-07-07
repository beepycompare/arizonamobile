package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.profile.UserProfile;
/* loaded from: classes4.dex */
public final class Yh implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UserProfile f723a;
    public final /* synthetic */ C0568ri b;

    public Yh(C0568ri c0568ri, UserProfile userProfile) {
        this.b = c0568ri;
        this.f723a = userProfile;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0568ri c0568ri = this.b;
        C0568ri.a(c0568ri.f1028a, c0568ri.d, c0568ri.e).reportUserProfile(this.f723a);
    }
}
