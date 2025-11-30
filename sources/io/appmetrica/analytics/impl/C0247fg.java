package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreutils.internal.services.SafePackageManager;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.impl.fg  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0247fg {

    /* renamed from: a  reason: collision with root package name */
    public final C0427mg f891a;
    public final Aa b;
    public final C0701xg c;
    public final Lazy d = LazyKt.lazy(new C0170cg(this));
    public final Lazy e = LazyKt.lazy(new C0118ag(this));
    public final Lazy f = LazyKt.lazy(new C0221eg(this));
    public final ArrayList g = new ArrayList();

    public C0247fg(C0427mg c0427mg, C0676wg c0676wg, Aa aa, C0701xg c0701xg) {
        this.f891a = c0427mg;
        this.b = aa;
        this.c = c0701xg;
    }

    public static final Xf a(C0247fg c0247fg) {
        return (Xf) c0247fg.d.getValue();
    }

    public static final void a(C0247fg c0247fg, C0477og c0477og, Xf xf) {
        boolean areEqual;
        c0247fg.g.add(c0477og);
        C0701xg c0701xg = c0247fg.c;
        if (c0477og == null) {
            c0701xg.getClass();
        } else {
            SafePackageManager safePackageManager = c0701xg.b;
            Context context = c0701xg.f1200a;
            String installerPackageName = safePackageManager.getInstallerPackageName(context, context.getPackageName());
            int ordinal = c0477og.d.ordinal();
            if (ordinal == 1) {
                areEqual = Intrinsics.areEqual(c0701xg.f, installerPackageName);
            } else if (ordinal == 2) {
                areEqual = Intrinsics.areEqual(c0701xg.g, installerPackageName);
            }
            if (areEqual) {
                c0247fg.a(c0477og);
                return;
            }
        }
        xf.a();
    }

    public final void a(C0477og c0477og) {
        C0427mg c0427mg = this.f891a;
        synchronized (c0427mg) {
            c0427mg.b = c0477og;
            c0427mg.c = true;
            c0427mg.d.a(c0477og);
            c0427mg.d.d();
            c0427mg.a(c0427mg.b);
        }
    }
}
