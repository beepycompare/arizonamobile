package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor;
import io.appmetrica.analytics.coreutils.internal.services.SafePackageManager;
import io.appmetrica.analytics.coreutils.internal.time.SystemTimeProvider;
import java.util.LinkedHashMap;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
/* renamed from: io.appmetrica.analytics.impl.c5  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C0162c5 {

    /* renamed from: a  reason: collision with root package name */
    public final C0110a5 f930a;
    public final C0136b5 b;
    protected final Context c;
    public final Q4 d;
    public final C0467o4 e;
    public final V4 f;
    protected final C0256fm g;
    public final InterfaceC0303hh h;
    public final H8 i;
    public final ICommonExecutor j;
    public final Fb k;
    public final InterfaceC0571s9 l;
    public final int m;

    public C0162c5(Context context, Q4 q4, C0467o4 c0467o4, V4 v4, C0256fm c0256fm, InterfaceC0303hh interfaceC0303hh, ICommonExecutor iCommonExecutor, int i, Fb fb, InterfaceC0571s9 interfaceC0571s9) {
        this(context, q4, c0467o4, v4, c0256fm, interfaceC0303hh, iCommonExecutor, new H8(), i, new C0110a5(c0467o4.f1146a), new C0136b5(context, q4), fb, interfaceC0571s9);
    }

    public static X8 c(X4 x4) {
        return new X8(x4);
    }

    public final M8 a() {
        Context context = this.c;
        Q4 q4 = this.d;
        return new M8(new R8(context, q4), this.m);
    }

    public final L6 b(X4 x4) {
        return new L6(x4, C0448na.I.B().c(this.c, this.d), new H6(x4.c()), new C0241f7());
    }

    public final C0110a5 d() {
        return this.f930a;
    }

    public final C0136b5 e() {
        return this.b;
    }

    public final xo f() {
        xo xoVar;
        Bo c0141ba;
        Ao D = C0448na.I.D();
        Q4 q4 = this.d;
        synchronized (D) {
            String valueOf = String.valueOf(q4);
            LinkedHashMap linkedHashMap = D.b;
            Object obj = linkedHashMap.get(valueOf);
            if (obj == null) {
                We we = new We(C0448na.I.B().b(D.f504a, q4));
                if (q4.d()) {
                    String str = "appmetrica_vital_" + q4.b + ".dat";
                    c0141ba = new C0265g5(CollectionsKt.listOf((Object[]) new Pair[]{TuplesKt.to(str, new C0141ba(D.f504a, str)), TuplesKt.to("appmetrica_vital_main.dat", new C0141ba(D.f504a, "appmetrica_vital_main.dat"))}));
                } else {
                    c0141ba = new C0141ba(D.f504a, "appmetrica_vital_" + q4.b + ".dat");
                }
                obj = new xo(we, c0141ba, valueOf);
                linkedHashMap.put(valueOf, obj);
            }
            xoVar = (xo) obj;
        }
        return xoVar;
    }

    public C0162c5(Context context, Q4 q4, C0467o4 c0467o4, V4 v4, C0256fm c0256fm, InterfaceC0303hh interfaceC0303hh, ICommonExecutor iCommonExecutor, H8 h8, int i, C0110a5 c0110a5, C0136b5 c0136b5, Fb fb, InterfaceC0571s9 interfaceC0571s9) {
        this.c = context;
        this.d = q4;
        this.e = c0467o4;
        this.f = v4;
        this.g = c0256fm;
        this.h = interfaceC0303hh;
        this.j = iCommonExecutor;
        this.i = h8;
        this.m = i;
        this.f930a = c0110a5;
        this.b = c0136b5;
        this.k = fb;
        this.l = interfaceC0571s9;
    }

    public final Jk c() {
        return new Jk(this.c, this.d);
    }

    public final C0655vi d(X4 x4) {
        C0655vi c0655vi = new C0655vi(x4, this.f.a(), this.j);
        Fb fb = this.k;
        synchronized (fb) {
            fb.c.add(c0655vi);
        }
        return c0655vi;
    }

    public final Qg a(X4 x4) {
        return new Qg(new C0328ih(x4, this.h, new C3()), this.g, new C0251fh(this.e));
    }

    public static Rk a(X4 x4, xo xoVar, W4 w4) {
        Qk qk = new Qk(xoVar);
        return new Rk(x4, qk, w4, new C0296ha(x4, qk, new Uk(x4.h(), "foreground"), AbstractC0688x1.a(), new SystemTimeProvider()), new C0739z2(x4, qk, new Uk(x4.h(), C0739z2.g), AbstractC0688x1.a(), new SystemTimeProvider()));
    }

    public static S4 b() {
        return new S4();
    }

    public final C0416m3 b(We we) {
        Context context = this.c;
        return new C0416m3(context, we, context.getPackageName(), new SafePackageManager());
    }

    public final C0372k9 a(We we, xo xoVar, Rk rk, L6 l6, C0337j0 c0337j0, Jk jk, C0655vi c0655vi) {
        return new C0372k9(we, xoVar, rk, l6, c0337j0, this.i, jk, this.m, new Z4(c0655vi), new SystemTimeProvider());
    }

    public static C0605ti a(X4 x4, X8 x8) {
        return new C0605ti(x8, x4);
    }

    public InterfaceC0522q9 a(InterfaceC0646v9 interfaceC0646v9, L6 l6, Qg qg, C0467o4 c0467o4, Q4 q4, We we) {
        return this.l.a(interfaceC0646v9, l6, qg, c0467o4, q4, we).a();
    }

    public final C0490p2 a(We we) {
        return new C0490p2(this.d, we);
    }
}
