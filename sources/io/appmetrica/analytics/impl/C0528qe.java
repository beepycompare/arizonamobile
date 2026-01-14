package io.appmetrica.analytics.impl;

import android.content.Context;
import java.io.File;
/* renamed from: io.appmetrica.analytics.impl.qe  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0528qe implements I6 {

    /* renamed from: a  reason: collision with root package name */
    public final File f1189a;
    public final Jg b;

    public C0528qe(File file, Jg jg) {
        this.f1189a = file;
        this.b = jg;
    }

    @Override // io.appmetrica.analytics.impl.I6
    public final File a(Context context, String str) {
        return new File(this.f1189a, this.b.a(str));
    }
}
