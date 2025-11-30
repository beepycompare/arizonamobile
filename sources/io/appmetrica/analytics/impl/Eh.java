package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreutils.internal.services.PackageManagerUtils;
import io.appmetrica.analytics.coreutils.internal.time.TimePassedChecker;
/* loaded from: classes5.dex */
public final class Eh extends Y4 {
    public final String w;
    public final F6 x;

    public Eh(Context context, R4 r4, C0490p4 c0490p4, F6 f6, C0279gm c0279gm, W4 w4, InterfaceC0594t9 interfaceC0594t9) {
        this(context, r4, new C0360k0(), new TimePassedChecker(), new C0185d5(context, r4, c0490p4, w4, c0279gm, new C0752zh(f6), C0471oa.k().w().c(), PackageManagerUtils.getAppVersionCodeInt(context), C0471oa.k().l(), interfaceC0594t9), f6, c0490p4);
    }

    @Override // io.appmetrica.analytics.impl.Y4, io.appmetrica.analytics.impl.Qa, io.appmetrica.analytics.impl.Fa
    public final synchronized void a(C0490p4 c0490p4) {
        super.a(c0490p4);
        this.x.a(this.w, c0490p4.i);
    }

    public Eh(Context context, R4 r4, C0360k0 c0360k0, TimePassedChecker timePassedChecker, C0185d5 c0185d5, F6 f6, C0490p4 c0490p4) {
        super(context, r4, c0360k0, timePassedChecker, c0185d5, c0490p4);
        this.w = r4.b();
        this.x = f6;
    }
}
