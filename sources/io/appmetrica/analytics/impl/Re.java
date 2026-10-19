package io.appmetrica.analytics.impl;

import android.content.Context;
import java.io.File;
/* loaded from: classes5.dex */
public final class Re implements InterfaceC0107a7 {

    /* renamed from: a  reason: collision with root package name */
    public final File f751a;
    public final Zg b;

    public Re(File file, Zg zg) {
        this.f751a = file;
        this.b = zg;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0107a7
    public final File a(Context context, String str) {
        return new File(this.f751a, this.b.a(str));
    }
}
