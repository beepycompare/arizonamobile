package io.appmetrica.analytics.impl;

import android.content.Context;
import android.os.ResultReceiver;
/* renamed from: io.appmetrica.analytics.impl.u4  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0616u4 implements InterfaceC0238f4 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f1253a;
    public final C0691x4 b;
    public final ResultReceiver c;

    public C0616u4(Context context, C0691x4 c0691x4, C0492p4 c0492p4) {
        this.f1253a = context;
        this.b = c0691x4;
        this.c = c0492p4.c;
        c0691x4.a(this);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0238f4
    public final void a(P5 p5, C0492p4 c0492p4) {
        this.b.a(c0492p4.b);
        this.b.a(p5, this);
    }

    public final C0691x4 b() {
        return this.b;
    }

    public final Context c() {
        return this.f1253a;
    }

    public final ResultReceiver d() {
        return this.c;
    }

    public final void a(S3 s3) {
        B6.a(this.c, s3);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0238f4
    public final void a() {
        this.b.b(this);
    }
}
