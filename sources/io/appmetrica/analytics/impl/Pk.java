package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.collections.CollectionsKt;
import okhttp3.internal.connection.RealConnection;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class Pk {

    /* renamed from: a  reason: collision with root package name */
    public final C0580s5 f584a;
    public final Ok b;
    public final C0555r5 c;
    public final AbstractC0276g d;
    public final AbstractC0276g e;
    public Bk f;
    public int g = 0;

    public Pk(C0580s5 c0580s5, Ok ok, C0555r5 c0555r5, Aa aa, L2 l2) {
        this.f584a = c0580s5;
        this.c = c0555r5;
        this.d = aa;
        this.e = l2;
        this.b = ok;
    }

    public final synchronized long a() {
        Bk bk;
        bk = this.f;
        return bk == null ? RealConnection.IDLE_CONNECTION_HEALTHY_NS : bk.d - 1;
    }

    public final void b(Bk bk, C0333i6 c0333i6) {
        if (bk.g && bk.d > 0) {
            C0555r5 c0555r5 = this.c;
            C0333i6 a2 = C0333i6.a(c0333i6, EnumC0636ub.EVENT_TYPE_ALIVE);
            Rk rk = new Rk();
            rk.f614a = bk.d;
            rk.d = bk.c.f413a;
            long andIncrement = bk.f.getAndIncrement();
            Sk sk = bk.b;
            sk.a(Sk.g, Long.valueOf(bk.f.get()));
            sk.b();
            rk.b = andIncrement;
            rk.c = TimeUnit.MILLISECONDS.toSeconds(Math.max(bk.i - bk.e, bk.j));
            c0555r5.f1019a.n.a(a2, rk);
            if (bk.g) {
                bk.g = false;
                Sk sk2 = bk.b;
                sk2.a(Sk.i, Boolean.FALSE);
                sk2.b();
            }
        }
        PublicLogger publicLogger = this.f584a.m;
        int ordinal = bk.c.f413a.ordinal();
        if (ordinal == 0) {
            publicLogger.info("Finish foreground session", new Object[0]);
        } else if (ordinal == 1) {
            publicLogger.info("Finish background session", new Object[0]);
        }
        synchronized (bk) {
            Sk sk3 = bk.b;
            sk3.getClass();
            sk3.c = new C0736yb();
            sk3.b();
            bk.h = null;
        }
    }

    public final synchronized void c(C0333i6 c0333i6) {
        if (this.g == 0) {
            Bk b = this.d.b();
            if (a(b, c0333i6)) {
                this.f = b;
                this.g = 3;
            } else {
                Bk b2 = this.e.b();
                if (a(b2, c0333i6)) {
                    this.f = b2;
                    this.g = 2;
                } else {
                    this.f = null;
                    this.g = 1;
                }
            }
        }
        int a2 = AbstractC0158b8.a(this.g);
        if (a2 == 0) {
            this.f = a(c0333i6);
        } else if (a2 == 1) {
            b(this.f, c0333i6);
            this.f = a(c0333i6);
        } else if (a2 == 2) {
            if (a(this.f, c0333i6)) {
                Bk bk = this.f;
                long j = c0333i6.i;
                bk.i = j;
                Sk sk = bk.b;
                sk.a(Sk.d, Long.valueOf(j));
                sk.b();
            } else {
                this.f = a(c0333i6);
            }
        }
    }

    public final Bk a(C0333i6 c0333i6) {
        this.f584a.m.info("Start foreground session", new Object[0]);
        long j = c0333i6.i;
        AbstractC0276g abstractC0276g = this.d;
        Ck ck = new Ck(j, c0333i6.j);
        abstractC0276g.getClass();
        Bk a2 = abstractC0276g.a(ck);
        this.g = 3;
        ((D5) this.f584a.p).e();
        C0555r5 c0555r5 = this.c;
        c0555r5.f1019a.n.a(C0333i6.a(c0333i6, Ga.F.h()), a(a2, j));
        return a2;
    }

    public static Rk a(Bk bk, long j) {
        Rk rk = new Rk();
        rk.f614a = bk.d;
        long andIncrement = bk.f.getAndIncrement();
        Sk sk = bk.b;
        sk.a(Sk.g, Long.valueOf(bk.f.get()));
        sk.b();
        rk.b = andIncrement;
        Sk sk2 = bk.b;
        long j2 = j - bk.e;
        bk.j = j2;
        sk2.a(Sk.e, Long.valueOf(j2));
        rk.c = TimeUnit.MILLISECONDS.toSeconds(bk.j);
        rk.d = bk.c.f413a;
        return rk;
    }

    public final synchronized Bk b(C0333i6 c0333i6) {
        if (this.g == 0) {
            Bk b = this.d.b();
            if (a(b, c0333i6)) {
                this.f = b;
                this.g = 3;
            } else {
                Bk b2 = this.e.b();
                if (a(b2, c0333i6)) {
                    this.f = b2;
                    this.g = 2;
                } else {
                    this.f = null;
                    this.g = 1;
                }
            }
        }
        if (this.g != 1 && !a(this.f, c0333i6)) {
            this.g = 1;
            this.f = null;
        }
        int a2 = AbstractC0158b8.a(this.g);
        if (a2 == 1) {
            Bk bk = this.f;
            long j = c0333i6.i;
            bk.i = j;
            Sk sk = bk.b;
            sk.a(Sk.d, Long.valueOf(j));
            sk.b();
            return this.f;
        } else if (a2 != 2) {
            this.f584a.m.info("Start background session", new Object[0]);
            this.g = 2;
            long j2 = c0333i6.i;
            AbstractC0276g abstractC0276g = this.e;
            Ck ck = new Ck(j2, c0333i6.j);
            abstractC0276g.getClass();
            Bk a3 = abstractC0276g.a(ck);
            if (this.f584a.t.c()) {
                C0555r5 c0555r5 = this.c;
                c0555r5.f1019a.n.a(C0333i6.a(c0333i6, Ga.F.h()), a(a3, c0333i6.i));
            } else {
                int i = c0333i6.d;
                EnumC0636ub enumC0636ub = EnumC0636ub.EVENT_TYPE_UNDEFINED;
                if (i == 6145) {
                    C0555r5 c0555r52 = this.c;
                    c0555r52.f1019a.n.a(c0333i6, a(a3, j2));
                    C0555r5 c0555r53 = this.c;
                    c0555r53.f1019a.n.a(C0333i6.a(c0333i6, Ga.F.h()), a(a3, j2));
                }
            }
            this.f = a3;
            return a3;
        } else {
            return this.f;
        }
    }

    public final boolean a(Bk bk, C0333i6 c0333i6) {
        boolean z;
        boolean z2;
        if (bk == null) {
            return false;
        }
        long j = c0333i6.i;
        boolean z3 = bk.d >= 0;
        if (bk.h == null) {
            synchronized (bk) {
                if (bk.h == null) {
                    try {
                        String asString = bk.f359a.e.a(bk.d, bk.c.f413a).getAsString("report_request_parameters");
                        if (!TextUtils.isEmpty(asString)) {
                            bk.h = new Qk(new JSONObject(asString));
                        }
                    } catch (Throwable unused) {
                    }
                }
            }
        }
        Qk qk = bk.h;
        if (qk == null) {
            z = false;
            break;
        }
        C0667vh c0667vh = (C0667vh) bk.f359a.k.a();
        Boolean[] boolArr = new Boolean[7];
        boolArr[0] = Boolean.valueOf(TextUtils.equals(c0667vh.getAnalyticsSdkVersionName(), qk.f597a));
        boolArr[1] = Boolean.valueOf(TextUtils.equals(c0667vh.getAnalyticsSdkBuildNumber(), qk.b));
        boolArr[2] = Boolean.valueOf(TextUtils.equals(c0667vh.getAppVersion(), qk.c));
        boolArr[3] = Boolean.valueOf(TextUtils.equals(c0667vh.getAppBuildNumber(), qk.d));
        boolArr[4] = Boolean.valueOf(TextUtils.equals(c0667vh.getOsVersion(), qk.e));
        boolArr[5] = Boolean.valueOf(qk.f == c0667vh.getOsApiLevel());
        boolArr[6] = Boolean.valueOf(qk.g == c0667vh.r);
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
        long elapsedRealtime = bk.k.elapsedRealtime();
        long j2 = bk.i;
        boolean z4 = elapsedRealtime < j2;
        long j3 = j - j2;
        long j4 = j - bk.e;
        if (!z4) {
            TimeUnit timeUnit = TimeUnit.SECONDS;
            Ek ek = bk.c;
            int i = ((C0667vh) bk.f359a.k.a()).f;
            Integer num = ek.d;
            if (num != null) {
                i = num.intValue();
            }
            if (j3 < timeUnit.toMillis(i) && j4 < timeUnit.toMillis(Fk.f432a)) {
                z2 = false;
                if (z3 || !z || z2) {
                    b(bk, c0333i6);
                    return false;
                }
                return true;
            }
        }
        z2 = true;
        if (z3) {
        }
        b(bk, c0333i6);
        return false;
    }
}
