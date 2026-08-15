package io.appmetrica.analytics.impl;

import android.content.Context;
import java.io.File;
/* loaded from: classes5.dex */
public final class Re implements InterfaceC0113a7 {

    /* renamed from: a  reason: collision with root package name */
    public final File f748a;
    public final Zg b;

    public Re(File file, Zg zg) {
        this.f748a = file;
        this.b = zg;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0113a7
    public final File a(Context context, String str) {
        return new File(this.f748a, this.b.a(str));
    }
}
