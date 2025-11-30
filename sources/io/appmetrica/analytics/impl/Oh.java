package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.profile.UserProfile;
/* loaded from: classes5.dex */
public final class Oh implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UserProfile f622a;
    public final /* synthetic */ C0301hi b;

    public Oh(C0301hi c0301hi, UserProfile userProfile) {
        this.b = c0301hi;
        this.f622a = userProfile;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0301hi c0301hi = this.b;
        C0301hi.a(c0301hi.f926a, c0301hi.d, c0301hi.e).reportUserProfile(this.f622a);
    }
}
