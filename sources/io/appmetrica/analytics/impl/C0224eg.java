package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreutils.internal.services.SafePackageManager;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.impl.eg  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0224eg {

    /* renamed from: a  reason: collision with root package name */
    public final C0404lg f983a;
    public final C0747za b;
    public final C0678wg c;
    public final Lazy d = LazyKt.lazy(new C0147bg(this));
    public final Lazy e = LazyKt.lazy(new Zf(this));
    public final Lazy f = LazyKt.lazy(new C0199dg(this));
    public final ArrayList g = new ArrayList();

    public C0224eg(C0404lg c0404lg, C0653vg c0653vg, C0747za c0747za, C0678wg c0678wg) {
        this.f983a = c0404lg;
        this.b = c0747za;
        this.c = c0678wg;
    }

    public static final Wf a(C0224eg c0224eg) {
        return (Wf) c0224eg.d.getValue();
    }

    public static final void a(C0224eg c0224eg, C0454ng c0454ng, Wf wf) {
        boolean areEqual;
        c0224eg.g.add(c0454ng);
        C0678wg c0678wg = c0224eg.c;
        if (c0454ng == null) {
            c0678wg.getClass();
        } else {
            SafePackageManager safePackageManager = c0678wg.b;
            Context context = c0678wg.f1292a;
            String installerPackageName = safePackageManager.getInstallerPackageName(context, context.getPackageName());
            int ordinal = c0454ng.d.ordinal();
            if (ordinal == 1) {
                areEqual = Intrinsics.areEqual(c0678wg.f, installerPackageName);
            } else if (ordinal == 2) {
                areEqual = Intrinsics.areEqual(c0678wg.g, installerPackageName);
            }
            if (areEqual) {
                c0224eg.a(c0454ng);
                return;
            }
        }
        wf.a();
    }

    public final void a(C0454ng c0454ng) {
        C0404lg c0404lg = this.f983a;
        synchronized (c0404lg) {
            c0404lg.b = c0454ng;
            c0404lg.c = true;
            c0404lg.d.a(c0454ng);
            c0404lg.d.d();
            c0404lg.a(c0404lg.b);
        }
    }
}
