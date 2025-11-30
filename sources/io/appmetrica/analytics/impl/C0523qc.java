package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreutils.internal.services.PackageManagerUtils;
import io.appmetrica.analytics.coreutils.internal.time.TimePassedChecker;
import io.appmetrica.analytics.internal.CounterConfigurationReporterType;
/* renamed from: io.appmetrica.analytics.impl.qc  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0523qc extends Y4 implements Na, Ma {
    public final C0427mg w;
    public final C0527qg x;
    public final F6 y;

    public C0523qc(Context context, C0279gm c0279gm, R4 r4, C0490p4 c0490p4, C0427mg c0427mg, F6 f6, W4 w4) {
        this(context, r4, c0490p4, new C0360k0(), new TimePassedChecker(), new C0572sc(context, r4, c0490p4, w4, c0279gm, new C0398lc(f6), C0471oa.k().w().c(), PackageManagerUtils.getAppVersionCodeInt(context), C0471oa.k().w(), C0471oa.k().l(), new C0243fc()), c0427mg, f6);
    }

    @Override // io.appmetrica.analytics.impl.Y4
    public final void C() {
        this.w.a(this.x);
    }

    public final boolean D() {
        boolean optBoolean;
        yo yoVar = this.t;
        synchronized (yoVar) {
            optBoolean = yoVar.f1225a.a().optBoolean("referrer_handled", false);
        }
        return optBoolean;
    }

    @Override // io.appmetrica.analytics.impl.Y4, io.appmetrica.analytics.impl.Qa, io.appmetrica.analytics.impl.Fa
    public final synchronized void a(C0490p4 c0490p4) {
        super.a(c0490p4);
        this.y.a(c0490p4.i);
    }

    @Override // io.appmetrica.analytics.impl.Y4, io.appmetrica.analytics.impl.Fa
    public final CounterConfigurationReporterType c() {
        return CounterConfigurationReporterType.MAIN;
    }

    @Override // io.appmetrica.analytics.impl.Ma
    public final void a() {
        yo yoVar = this.t;
        synchronized (yoVar) {
            zo zoVar = yoVar.f1225a;
            zoVar.a(zoVar.a().put("referrer_handled", true));
        }
    }

    public C0523qc(Context context, R4 r4, C0490p4 c0490p4, C0360k0 c0360k0, TimePassedChecker timePassedChecker, C0572sc c0572sc, C0427mg c0427mg, F6 f6) {
        super(context, r4, c0360k0, timePassedChecker, c0572sc, c0490p4);
        this.w = c0427mg;
        Y8 k = k();
        k.a(EnumC0165cb.EVENT_TYPE_REGULAR, new Ig(k.b()));
        this.x = c0572sc.a(this);
        this.y = f6;
        C0471oa.k().x().onMainReporterCreated(new C0680wk(this, c0490p4));
    }
}
