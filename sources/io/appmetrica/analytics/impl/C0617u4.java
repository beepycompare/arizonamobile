package io.appmetrica.analytics.impl;

import android.content.Context;
import android.os.ResultReceiver;
/* renamed from: io.appmetrica.analytics.impl.u4  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0617u4 implements InterfaceC0239f4 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f1248a;
    public final C0692x4 b;
    public final ResultReceiver c;

    public C0617u4(Context context, C0692x4 c0692x4, C0493p4 c0493p4) {
        this.f1248a = context;
        this.b = c0692x4;
        this.c = c0493p4.c;
        c0692x4.a(this);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0239f4
    public final void a(P5 p5, C0493p4 c0493p4) {
        this.b.a(c0493p4.b);
        this.b.a(p5, this);
    }

    public final C0692x4 b() {
        return this.b;
    }

    public final Context c() {
        return this.f1248a;
    }

    public final ResultReceiver d() {
        return this.c;
    }

    public final void a(S3 s3) {
        B6.a(this.c, s3);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0239f4
    public final void a() {
        this.b.b(this);
    }
}
