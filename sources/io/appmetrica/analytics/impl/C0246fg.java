package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreutils.internal.services.SafePackageManager;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.impl.fg  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0246fg {

    /* renamed from: a  reason: collision with root package name */
    public final C0426mg f974a;
    public final Aa b;
    public final C0700xg c;
    public final Lazy d = LazyKt.lazy(new C0169cg(this));
    public final Lazy e = LazyKt.lazy(new C0117ag(this));
    public final Lazy f = LazyKt.lazy(new C0220eg(this));
    public final ArrayList g = new ArrayList();

    public C0246fg(C0426mg c0426mg, C0675wg c0675wg, Aa aa, C0700xg c0700xg) {
        this.f974a = c0426mg;
        this.b = aa;
        this.c = c0700xg;
    }

    public static final Xf a(C0246fg c0246fg) {
        return (Xf) c0246fg.d.getValue();
    }

    public static final void a(C0246fg c0246fg, C0476og c0476og, Xf xf) {
        boolean areEqual;
        c0246fg.g.add(c0476og);
        C0700xg c0700xg = c0246fg.c;
        if (c0476og == null) {
            c0700xg.getClass();
        } else {
            SafePackageManager safePackageManager = c0700xg.b;
            Context context = c0700xg.f1283a;
            String installerPackageName = safePackageManager.getInstallerPackageName(context, context.getPackageName());
            int ordinal = c0476og.d.ordinal();
            if (ordinal == 1) {
                areEqual = Intrinsics.areEqual(c0700xg.f, installerPackageName);
            } else if (ordinal == 2) {
                areEqual = Intrinsics.areEqual(c0700xg.g, installerPackageName);
            }
            if (areEqual) {
                c0246fg.a(c0476og);
                return;
            }
        }
        xf.a();
    }

    public final void a(C0476og c0476og) {
        C0426mg c0426mg = this.f974a;
        synchronized (c0426mg) {
            c0426mg.b = c0476og;
            c0426mg.c = true;
            c0426mg.d.a(c0476og);
            c0426mg.d.d();
            c0426mg.a(c0426mg.b);
        }
    }
}
