package io.appmetrica.analytics.impl;

import android.content.Context;
import java.io.File;
/* renamed from: io.appmetrica.analytics.impl.re  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0548re implements J6 {

    /* renamed from: a  reason: collision with root package name */
    public final File f1199a;
    public final Kg b;

    public C0548re(File file, Kg kg) {
        this.f1199a = file;
        this.b = kg;
    }

    @Override // io.appmetrica.analytics.impl.J6
    public final File a(Context context, String str) {
        return new File(this.f1199a, this.b.a(str));
    }
}
