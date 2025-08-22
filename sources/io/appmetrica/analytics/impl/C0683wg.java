package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreutils.internal.services.SafePackageManager;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.impl.wg  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0683wg {

    /* renamed from: a  reason: collision with root package name */
    public final Dg f1123a;
    public final Wa b;
    public final Og c;
    public final Lazy d = LazyKt.lazy(new C0608tg(this));
    public final Lazy e = LazyKt.lazy(new C0558rg(this));
    public final Lazy f = LazyKt.lazy(new C0658vg(this));
    public final ArrayList g = new ArrayList();

    public C0683wg(Dg dg, Ng ng, Wa wa, Og og) {
        this.f1123a = dg;
        this.b = wa;
        this.c = og;
    }

    public static final InterfaceC0484og a(C0683wg c0683wg) {
        return (InterfaceC0484og) c0683wg.d.getValue();
    }

    public static final void a(C0683wg c0683wg, Fg fg, InterfaceC0484og interfaceC0484og) {
        boolean areEqual;
        c0683wg.g.add(fg);
        Og og = c0683wg.c;
        if (fg == null) {
            og.getClass();
        } else {
            SafePackageManager safePackageManager = og.b;
            Context context = og.f590a;
            String installerPackageName = safePackageManager.getInstallerPackageName(context, context.getPackageName());
            int ordinal = fg.d.ordinal();
            if (ordinal == 1) {
                areEqual = Intrinsics.areEqual(og.f, installerPackageName);
            } else if (ordinal == 2) {
                areEqual = Intrinsics.areEqual(og.g, installerPackageName);
            }
            if (areEqual) {
                c0683wg.a(fg);
                return;
            }
        }
        interfaceC0484og.a();
    }

    public final void a(Fg fg) {
        Dg dg = this.f1123a;
        synchronized (dg) {
            dg.b = fg;
            dg.c = true;
            dg.d.a(fg);
            dg.d.d();
            dg.a(dg.b);
        }
    }
}
