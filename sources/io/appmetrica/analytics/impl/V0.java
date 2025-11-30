package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.profile.UserProfile;
/* loaded from: classes5.dex */
public final class V0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UserProfile f717a;
    public final /* synthetic */ C0611u1 b;

    public V0(C0611u1 c0611u1, UserProfile userProfile) {
        this.b = c0611u1;
        this.f717a = userProfile;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0611u1.a(this.b).reportUserProfile(this.f717a);
    }
}
