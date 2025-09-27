package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.collections.CollectionsKt;
import okhttp3.internal.connection.RealConnection;
import org.json.JSONObject;
/* renamed from: io.appmetrica.analytics.impl.bl  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0156bl {

    /* renamed from: a  reason: collision with root package name */
    public final C0651v5 f815a;
    public final C0130al b;
    public final C0626u5 c;
    public final AbstractC0263g d;
    public final AbstractC0263g e;
    public Nk f;
    public int g = 0;

    public C0156bl(C0651v5 c0651v5, C0130al c0130al, C0626u5 c0626u5, Ha ha, O2 o2) {
        this.f815a = c0651v5;
        this.c = c0626u5;
        this.d = ha;
        this.e = o2;
        this.b = c0130al;
    }

    public final synchronized long a() {
        Nk nk;
        nk = this.f;
        return nk == null ? RealConnection.IDLE_CONNECTION_HEALTHY_NS : nk.d - 1;
    }

    public final void b(Nk nk, C0477o6 c0477o6) {
        if (nk.g && nk.d > 0) {
            C0626u5 c0626u5 = this.c;
            C0477o6 a2 = C0477o6.a(c0477o6, Bb.EVENT_TYPE_ALIVE);
            C0208dl c0208dl = new C0208dl();
            c0208dl.f850a = nk.d;
            c0208dl.d = nk.c.f644a;
            long andIncrement = nk.f.getAndIncrement();
            C0233el c0233el = nk.b;
            c0233el.a(C0233el.g, Long.valueOf(nk.f.get()));
            c0233el.b();
            c0208dl.b = andIncrement;
            c0208dl.c = TimeUnit.MILLISECONDS.toSeconds(Math.max(nk.i - nk.e, nk.j));
            c0626u5.f1106a.n.a(a2, c0208dl);
            if (nk.g) {
                nk.g = false;
                C0233el c0233el2 = nk.b;
                c0233el2.a(C0233el.i, Boolean.FALSE);
                c0233el2.b();
            }
        }
        PublicLogger publicLogger = this.f815a.m;
        int ordinal = nk.c.f644a.ordinal();
        if (ordinal == 0) {
            publicLogger.info("Finish foreground session", new Object[0]);
        } else if (ordinal == 1) {
            publicLogger.info("Finish background session", new Object[0]);
        }
        synchronized (nk) {
            C0233el c0233el3 = nk.b;
            c0233el3.getClass();
            c0233el3.c = new Fb();
            c0233el3.b();
            nk.h = null;
        }
    }

    public final synchronized void c(C0477o6 c0477o6) {
        if (this.g == 0) {
            Nk b = this.d.b();
            if (a(b, c0477o6)) {
                this.f = b;
                this.g = 3;
            } else {
                Nk b2 = this.e.b();
                if (a(b2, c0477o6)) {
                    this.f = b2;
                    this.g = 2;
                } else {
                    this.f = null;
                    this.g = 1;
                }
            }
        }
        int a2 = AbstractC0324i8.a(this.g);
        if (a2 == 0) {
            this.f = a(c0477o6);
        } else if (a2 == 1) {
            b(this.f, c0477o6);
            this.f = a(c0477o6);
        } else if (a2 == 2) {
            if (a(this.f, c0477o6)) {
                Nk nk = this.f;
                long j = c0477o6.i;
                nk.i = j;
                C0233el c0233el = nk.b;
                c0233el.a(C0233el.d, Long.valueOf(j));
                c0233el.b();
            } else {
                this.f = a(c0477o6);
            }
        }
    }

    public final Nk a(C0477o6 c0477o6) {
        this.f815a.m.info("Start foreground session", new Object[0]);
        long j = c0477o6.i;
        AbstractC0263g abstractC0263g = this.d;
        Ok ok = new Ok(j, c0477o6.j);
        abstractC0263g.getClass();
        Nk a2 = abstractC0263g.a(ok);
        this.g = 3;
        ((I5) this.f815a.p).e();
        C0626u5 c0626u5 = this.c;
        c0626u5.f1106a.n.a(C0477o6.a(c0477o6, Na.F.h()), a(a2, j));
        return a2;
    }

    public static C0208dl a(Nk nk, long j) {
        C0208dl c0208dl = new C0208dl();
        c0208dl.f850a = nk.d;
        long andIncrement = nk.f.getAndIncrement();
        C0233el c0233el = nk.b;
        c0233el.a(C0233el.g, Long.valueOf(nk.f.get()));
        c0233el.b();
        c0208dl.b = andIncrement;
        C0233el c0233el2 = nk.b;
        long j2 = j - nk.e;
        nk.j = j2;
        c0233el2.a(C0233el.e, Long.valueOf(j2));
        c0208dl.c = TimeUnit.MILLISECONDS.toSeconds(nk.j);
        c0208dl.d = nk.c.f644a;
        return c0208dl;
    }

    public final synchronized Nk b(C0477o6 c0477o6) {
        if (this.g == 0) {
            Nk b = this.d.b();
            if (a(b, c0477o6)) {
                this.f = b;
                this.g = 3;
            } else {
                Nk b2 = this.e.b();
                if (a(b2, c0477o6)) {
                    this.f = b2;
                    this.g = 2;
                } else {
                    this.f = null;
                    this.g = 1;
                }
            }
        }
        if (this.g != 1 && !a(this.f, c0477o6)) {
            this.g = 1;
            this.f = null;
        }
        int a2 = AbstractC0324i8.a(this.g);
        if (a2 == 1) {
            Nk nk = this.f;
            long j = c0477o6.i;
            nk.i = j;
            C0233el c0233el = nk.b;
            c0233el.a(C0233el.d, Long.valueOf(j));
            c0233el.b();
            return this.f;
        } else if (a2 != 2) {
            this.f815a.m.info("Start background session", new Object[0]);
            this.g = 2;
            long j2 = c0477o6.i;
            AbstractC0263g abstractC0263g = this.e;
            Ok ok = new Ok(j2, c0477o6.j);
            abstractC0263g.getClass();
            Nk a3 = abstractC0263g.a(ok);
            if (this.f815a.t.c()) {
                C0626u5 c0626u5 = this.c;
                c0626u5.f1106a.n.a(C0477o6.a(c0477o6, Na.F.h()), a(a3, c0477o6.i));
            } else {
                int i = c0477o6.d;
                Bb bb = Bb.EVENT_TYPE_UNDEFINED;
                if (i == 6145) {
                    C0626u5 c0626u52 = this.c;
                    c0626u52.f1106a.n.a(c0477o6, a(a3, j2));
                    C0626u5 c0626u53 = this.c;
                    c0626u53.f1106a.n.a(C0477o6.a(c0477o6, Na.F.h()), a(a3, j2));
                }
            }
            this.f = a3;
            return a3;
        } else {
            return this.f;
        }
    }

    public final boolean a(Nk nk, C0477o6 c0477o6) {
        boolean z;
        boolean z2;
        if (nk == null) {
            return false;
        }
        long j = c0477o6.i;
        boolean z3 = nk.d >= 0;
        if (nk.h == null) {
            synchronized (nk) {
                if (nk.h == null) {
                    try {
                        String asString = nk.f600a.e.a(nk.d, nk.c.f644a).getAsString("report_request_parameters");
                        if (!TextUtils.isEmpty(asString)) {
                            nk.h = new C0182cl(new JSONObject(asString));
                        }
                    } catch (Throwable unused) {
                    }
                }
            }
        }
        C0182cl c0182cl = nk.h;
        if (c0182cl == null) {
            z = false;
            break;
        }
        Gh gh = (Gh) nk.f600a.k.a();
        Boolean[] boolArr = new Boolean[7];
        boolArr[0] = Boolean.valueOf(TextUtils.equals(gh.getAnalyticsSdkVersionName(), c0182cl.f829a));
        boolArr[1] = Boolean.valueOf(TextUtils.equals(gh.getAnalyticsSdkBuildNumber(), c0182cl.b));
        boolArr[2] = Boolean.valueOf(TextUtils.equals(gh.getAppVersion(), c0182cl.c));
        boolArr[3] = Boolean.valueOf(TextUtils.equals(gh.getAppBuildNumber(), c0182cl.d));
        boolArr[4] = Boolean.valueOf(TextUtils.equals(gh.getOsVersion(), c0182cl.e));
        boolArr[5] = Boolean.valueOf(c0182cl.f == gh.getOsApiLevel());
        boolArr[6] = Boolean.valueOf(c0182cl.g == gh.r);
        List<Boolean> listOf = CollectionsKt.listOf((Object[]) boolArr);
        if (!(listOf instanceof Collection) || !listOf.isEmpty()) {
            for (Boolean bool : listOf) {
                if (!bool.booleanValue()) {
                    z = false;
                    break;
                }
            }
        }
        z = true;
        long elapsedRealtime = nk.k.elapsedRealtime();
        long j2 = nk.i;
        boolean z4 = elapsedRealtime < j2;
        long j3 = j - j2;
        long j4 = j - nk.e;
        if (!z4) {
            TimeUnit timeUnit = TimeUnit.SECONDS;
            Qk qk = nk.c;
            int i = ((Gh) nk.f600a.k.a()).f;
            Integer num = qk.d;
            if (num != null) {
                i = num.intValue();
            }
            if (j3 < timeUnit.toMillis(i) && j4 < timeUnit.toMillis(Rk.f660a)) {
                z2 = false;
                if (z3 || !z || z2) {
                    b(nk, c0477o6);
                    return false;
                }
                return true;
            }
        }
        z2 = true;
        if (z3) {
        }
        b(nk, c0477o6);
        return false;
    }
}
