package io.appmetrica.analytics.impl;

import android.os.Process;
/* renamed from: io.appmetrica.analytics.impl.ge  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0276ge implements Fl {

    /* renamed from: a  reason: collision with root package name */
    public final int f997a;

    public C0276ge(int i) {
        this.f997a = i;
    }

    @Override // io.appmetrica.analytics.impl.Fl
    public final boolean a(String str) {
        return this.f997a != Process.myPid();
    }
}
