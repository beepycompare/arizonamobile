package io.appmetrica.analytics.impl;

import android.content.Context;
import java.util.Map;
import kotlin.collections.MapsKt;
/* loaded from: classes4.dex */
public final class Kk {

    /* renamed from: a  reason: collision with root package name */
    public final Ok f525a;
    public final Map b;

    public Kk(Context context, C0401l5 c0401l5) {
        c0401l5.a();
        Ok ok = new Ok(context, c0401l5);
        this.f525a = ok;
        this.b = MapsKt.toMutableMap(ok.a());
    }
}
