package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreutils.internal.services.PackageManagerUtils;
import io.appmetrica.analytics.coreutils.internal.time.TimePassedChecker;
/* loaded from: classes5.dex */
public final class Eh extends Y4 {
    public final String w;
    public final F6 x;

    public Eh(Context context, R4 r4, C0489p4 c0489p4, F6 f6, C0278gm c0278gm, W4 w4, InterfaceC0593t9 interfaceC0593t9) {
        this(context, r4, new C0359k0(), new TimePassedChecker(), new C0184d5(context, r4, c0489p4, w4, c0278gm, new C0751zh(f6), C0470oa.k().w().c(), PackageManagerUtils.getAppVersionCodeInt(context), C0470oa.k().l(), interfaceC0593t9), f6, c0489p4);
    }

    @Override // io.appmetrica.analytics.impl.Y4, io.appmetrica.analytics.impl.Qa, io.appmetrica.analytics.impl.Fa
    public final synchronized void a(C0489p4 c0489p4) {
        super.a(c0489p4);
        this.x.a(this.w, c0489p4.i);
    }

    public Eh(Context context, R4 r4, C0359k0 c0359k0, TimePassedChecker timePassedChecker, C0184d5 c0184d5, F6 f6, C0489p4 c0489p4) {
        super(context, r4, c0359k0, timePassedChecker, c0184d5, c0489p4);
        this.w = r4.b();
        this.x = f6;
    }
}
