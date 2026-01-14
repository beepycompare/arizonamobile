package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreutils.internal.services.SafePackageManager;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.impl.eg  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0225eg {

    /* renamed from: a  reason: collision with root package name */
    public final C0405lg f979a;
    public final C0748za b;
    public final C0679wg c;
    public final Lazy d = LazyKt.lazy(new C0148bg(this));
    public final Lazy e = LazyKt.lazy(new Zf(this));
    public final Lazy f = LazyKt.lazy(new C0200dg(this));
    public final ArrayList g = new ArrayList();

    public C0225eg(C0405lg c0405lg, C0654vg c0654vg, C0748za c0748za, C0679wg c0679wg) {
        this.f979a = c0405lg;
        this.b = c0748za;
        this.c = c0679wg;
    }

    public static final Wf a(C0225eg c0225eg) {
        return (Wf) c0225eg.d.getValue();
    }

    public static final void a(C0225eg c0225eg, C0455ng c0455ng, Wf wf) {
        boolean areEqual;
        c0225eg.g.add(c0455ng);
        C0679wg c0679wg = c0225eg.c;
        if (c0455ng == null) {
            c0679wg.getClass();
        } else {
            SafePackageManager safePackageManager = c0679wg.b;
            Context context = c0679wg.f1288a;
            String installerPackageName = safePackageManager.getInstallerPackageName(context, context.getPackageName());
            int ordinal = c0455ng.d.ordinal();
            if (ordinal == 1) {
                areEqual = Intrinsics.areEqual(c0679wg.f, installerPackageName);
            } else if (ordinal == 2) {
                areEqual = Intrinsics.areEqual(c0679wg.g, installerPackageName);
            }
            if (areEqual) {
                c0225eg.a(c0455ng);
                return;
            }
        }
        wf.a();
    }

    public final void a(C0455ng c0455ng) {
        C0405lg c0405lg = this.f979a;
        synchronized (c0405lg) {
            c0405lg.b = c0455ng;
            c0405lg.c = true;
            c0405lg.d.a(c0455ng);
            c0405lg.d.d();
            c0405lg.a(c0405lg.b);
        }
    }
}
