package io.appmetrica.analytics.impl;

import android.os.Process;
/* renamed from: io.appmetrica.analytics.impl.be  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0150be implements InterfaceC0363jl {

    /* renamed from: a  reason: collision with root package name */
    public final int f812a;

    public C0150be(int i) {
        this.f812a = i;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0363jl
    public final boolean a(String str) {
        return this.f812a != Process.myPid();
    }
}
