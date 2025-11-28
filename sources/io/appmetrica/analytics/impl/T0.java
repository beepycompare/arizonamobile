package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.profile.UserProfile;
/* loaded from: classes5.dex */
public final class T0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UserProfile f693a;
    public final /* synthetic */ C0561s1 b;

    public T0(C0561s1 c0561s1, UserProfile userProfile) {
        this.b = c0561s1;
        this.f693a = userProfile;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0561s1.a(this.b).reportUserProfile(this.f693a);
    }
}
