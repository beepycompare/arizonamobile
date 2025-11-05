package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.profile.UserProfile;
/* loaded from: classes3.dex */
public final class Sh implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UserProfile f685a;
    public final /* synthetic */ C0404li b;

    public Sh(C0404li c0404li, UserProfile userProfile) {
        this.b = c0404li;
        this.f685a = userProfile;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0404li c0404li = this.b;
        C0404li.a(c0404li.f993a, c0404li.d, c0404li.e).reportUserProfile(this.f685a);
    }
}
