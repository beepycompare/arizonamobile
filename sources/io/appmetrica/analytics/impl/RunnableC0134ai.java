package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.profile.UserProfile;
/* renamed from: io.appmetrica.analytics.impl.ai  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0134ai implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UserProfile f770a;
    public final /* synthetic */ C0612ti b;

    public RunnableC0134ai(C0612ti c0612ti, UserProfile userProfile) {
        this.b = c0612ti;
        this.f770a = userProfile;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0612ti c0612ti = this.b;
        C0612ti.a(c0612ti.f1068a, c0612ti.d, c0612ti.e).reportUserProfile(this.f770a);
    }
}
