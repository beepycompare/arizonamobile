package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.data.IBinaryDataHelper;
import io.appmetrica.analytics.coreapi.internal.db.DatabaseScript;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import io.appmetrica.analytics.modulesapi.internal.common.TableDescription;
import io.appmetrica.analytics.modulesapi.internal.service.ModuleServicesDatabase;
import java.util.HashMap;
import java.util.Map;
import kotlinx.metadata.internal.metadata.jvm.deserialization.JvmProtoBufUtil;
/* renamed from: io.appmetrica.analytics.impl.v7  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0649v7 {
    public static volatile C0649v7 t;
    public final Context e;
    public C0624u7 f;
    public C0624u7 g;
    public C0471o3 h;
    public C0496p3 i;
    public C0471o3 j;
    public C0496p3 k;
    public Pb l;
    public Qb m;
    public C0640un n;
    public C0665vn o;
    public Pb p;
    public Qb q;
    public C0679wc r;

    /* renamed from: a  reason: collision with root package name */
    public final HashMap f1100a = new HashMap();
    public final HashMap b = new HashMap();
    public final HashMap c = new HashMap();
    public final C0323i7 d = S5.a();
    public final C0699x7 s = new C0699x7();

    public C0649v7(Context context) {
        this.e = context;
    }

    public static C0649v7 a(Context context) {
        if (t == null) {
            synchronized (C0649v7.class) {
                if (t == null) {
                    t = new C0649v7(context.getApplicationContext());
                }
            }
        }
        return t;
    }

    public final synchronized InterfaceC0223eb b(C0398l5 c0398l5) {
        InterfaceC0223eb interfaceC0223eb;
        String str = new C0166c5(c0398l5).f805a;
        interfaceC0223eb = (InterfaceC0223eb) this.b.get(str);
        if (interfaceC0223eb == null) {
            interfaceC0223eb = new Pb(new C0663vl(c(c0398l5)));
            this.b.put(str, interfaceC0223eb);
        }
        return interfaceC0223eb;
    }

    public final synchronized C0624u7 c(C0398l5 c0398l5) {
        C0624u7 c0624u7;
        C0166c5 c0166c5 = new C0166c5(c0398l5);
        c0624u7 = (C0624u7) this.f1100a.get(c0166c5.f805a);
        if (c0624u7 == null) {
            Context context = this.e;
            C0699x7 c0699x7 = this.s;
            String a2 = new C0674w7(c0699x7.f1137a, c0699x7.b, false).a(context, c0166c5);
            C0323i7 c0323i7 = this.d;
            c0323i7.getClass();
            String str = c0398l5.b;
            if (str == null) {
                str = JvmProtoBufUtil.DEFAULT_MODULE_NAME;
            }
            String format = String.format("component-%s", str);
            C0416ln c0416ln = c0323i7.c;
            C0574s7 c0574s7 = c0323i7.f902a;
            C0374k7 c0374k7 = c0574s7.f1056a;
            C0400l7 c0400l7 = c0574s7.b;
            Ma ma = new Ma(false);
            ma.a(112, new C0243f5());
            C0466nn c0466nn = new C0466nn(format, c0323i7.b.f631a);
            c0416ln.getClass();
            c0624u7 = new C0624u7(context, a2, new C0441mn(c0374k7, c0400l7, ma, c0466nn), PublicLogger.getAnonymousInstance());
            this.f1100a.put(c0166c5.f805a, c0624u7);
        }
        return c0624u7;
    }

    public final synchronized InterfaceC0223eb d() {
        if (this.l == null) {
            this.l = new Pb(new C0663vl(h()));
        }
        return this.l;
    }

    public final IBinaryDataHelper e() {
        if (this.j == null) {
            if (this.g == null) {
                Context context = this.e;
                C0699x7 c0699x7 = this.s;
                String a2 = new C0674w7(c0699x7.f1137a, c0699x7.b, false).a(context, new B2());
                C0323i7 c0323i7 = this.d;
                c0323i7.getClass();
                HashMap hashMap = new HashMap();
                hashMap.put("binary_data", N5.f573a);
                C0416ln c0416ln = c0323i7.c;
                C0574s7 c0574s7 = c0323i7.f902a;
                C0425m7 c0425m7 = c0574s7.g;
                C0450n7 c0450n7 = c0574s7.h;
                Ma ma = new Ma(false);
                C0466nn c0466nn = new C0466nn("auto_inapp", hashMap);
                c0416ln.getClass();
                this.g = new C0624u7(context, a2, new C0441mn(c0425m7, c0450n7, ma, c0466nn), PublicLogger.getAnonymousInstance());
            }
            this.j = new C0471o3(new C0663vl(this.g));
        }
        return this.j;
    }

    public final InterfaceC0223eb f() {
        C0679wc c0679wc;
        if (this.p == null) {
            synchronized (this) {
                if (this.r == null) {
                    C0699x7 c0699x7 = this.s;
                    String a2 = new C0674w7(c0699x7.f1137a, c0699x7.b, true).a(this.e, new C0345j4());
                    Context context = this.e;
                    C0323i7 c0323i7 = this.d;
                    c0323i7.getClass();
                    HashMap hashMap = new HashMap();
                    hashMap.put("preferences", P5.f599a);
                    C0416ln c0416ln = c0323i7.c;
                    C0574s7 c0574s7 = c0323i7.f902a;
                    C0475o7 c0475o7 = c0574s7.c;
                    C0500p7 c0500p7 = c0574s7.d;
                    Ma ma = new Ma(false);
                    ma.a(112, new C0371k4());
                    C0466nn c0466nn = new C0466nn("service database", hashMap);
                    c0416ln.getClass();
                    this.r = new C0679wc(context, a2, new C0652va(a2), new C0441mn(c0475o7, c0500p7, ma, c0466nn));
                }
                c0679wc = this.r;
            }
            this.p = new Pb(c0679wc);
        }
        return this.p;
    }

    public final IBinaryDataHelper g() {
        if (this.h == null) {
            this.h = new C0471o3(new C0663vl(h()));
        }
        return this.h;
    }

    public final synchronized C0624u7 h() {
        if (this.f == null) {
            Context context = this.e;
            C0699x7 c0699x7 = this.s;
            String a2 = new C0674w7(c0699x7.f1137a, c0699x7.b, true).a(context, new C0587sk());
            C0323i7 c0323i7 = this.d;
            c0323i7.getClass();
            HashMap hashMap = new HashMap();
            hashMap.put("preferences", P5.f599a);
            hashMap.put("binary_data", N5.f573a);
            hashMap.put("temp_cache", AbstractC0715xn.f1146a);
            for (ModuleServicesDatabase moduleServicesDatabase : Ka.F.o().b()) {
                for (TableDescription tableDescription : moduleServicesDatabase.getTables()) {
                    hashMap.put(tableDescription.getTableName(), tableDescription.getColumnNames());
                }
            }
            C0416ln c0416ln = c0323i7.c;
            C0574s7 c0574s7 = c0323i7.f902a;
            C0525q7 c0525q7 = c0574s7.e;
            C0549r7 c0549r7 = c0574s7.f;
            Ma ma = new Ma(false);
            ma.a(114, new C0612tk());
            for (ModuleServicesDatabase moduleServicesDatabase2 : Ka.F.o().b()) {
                for (TableDescription tableDescription2 : moduleServicesDatabase2.getTables()) {
                    for (Map.Entry<Integer, DatabaseScript> entry : tableDescription2.getDatabaseProviderUpgradeScript().entrySet()) {
                        ma.a(entry.getKey(), entry.getValue());
                    }
                }
            }
            C0466nn c0466nn = new C0466nn("service database", hashMap);
            c0416ln.getClass();
            this.f = new C0624u7(context, a2, new C0441mn(c0525q7, c0549r7, ma, c0466nn), PublicLogger.getAnonymousInstance());
        }
        return this.f;
    }

    public final synchronized InterfaceC0223eb b() {
        return f();
    }

    public final synchronized IBinaryDataHelper a(C0398l5 c0398l5) {
        IBinaryDataHelper iBinaryDataHelper;
        String str = new C0166c5(c0398l5).f805a;
        iBinaryDataHelper = (IBinaryDataHelper) this.c.get(str);
        if (iBinaryDataHelper == null) {
            iBinaryDataHelper = new C0471o3(new C0663vl(c(c0398l5)));
            this.c.put(str, iBinaryDataHelper);
        }
        return iBinaryDataHelper;
    }

    public final synchronized InterfaceC0223eb a() {
        if (this.q == null) {
            this.q = new Qb(f());
        }
        return this.q;
    }

    public final synchronized InterfaceC0223eb c() {
        if (this.m == null) {
            if (this.l == null) {
                this.l = new Pb(new C0663vl(h()));
            }
            this.m = new Qb(this.l);
        }
        return this.m;
    }
}
