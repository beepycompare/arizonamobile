package io.appmetrica.analytics.impl;

import android.os.Process;
/* renamed from: io.appmetrica.analytics.impl.be  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0149be implements InterfaceC0362jl {

    /* renamed from: a  reason: collision with root package name */
    public final int f807a;

    public C0149be(int i) {
        this.f807a = i;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0362jl
    public final boolean a(String str) {
        return this.f807a != Process.myPid();
    }
}
