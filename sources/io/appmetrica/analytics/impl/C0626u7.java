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
/* renamed from: io.appmetrica.analytics.impl.u7  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0626u7 {
    public static volatile C0626u7 t;
    public final Context e;
    public C0601t7 f;
    public C0601t7 g;
    public C0473o3 h;
    public C0498p3 i;
    public C0473o3 j;
    public C0498p3 k;
    public Nb l;
    public Ob m;
    public C0518pn n;
    public C0543qn o;
    public Nb p;
    public Ob q;
    public C0631uc r;

    /* renamed from: a  reason: collision with root package name */
    public final HashMap f1079a = new HashMap();
    public final HashMap b = new HashMap();
    public final HashMap c = new HashMap();
    public final C0303h7 d = S5.a();
    public final C0676w7 s = new C0676w7();

    public C0626u7(Context context) {
        this.e = context;
    }

    public static C0626u7 a(Context context) {
        if (t == null) {
            synchronized (C0626u7.class) {
                if (t == null) {
                    t = new C0626u7(context.getApplicationContext());
                }
            }
        }
        return t;
    }

    public final synchronized InterfaceC0179cb b(C0400l5 c0400l5) {
        InterfaceC0179cb interfaceC0179cb;
        String str = new C0173c5(c0400l5).f793a;
        interfaceC0179cb = (InterfaceC0179cb) this.b.get(str);
        if (interfaceC0179cb == null) {
            interfaceC0179cb = new Nb(new C0541ql(c(c0400l5)));
            this.b.put(str, interfaceC0179cb);
        }
        return interfaceC0179cb;
    }

    public final synchronized C0601t7 c(C0400l5 c0400l5) {
        C0601t7 c0601t7;
        C0173c5 c0173c5 = new C0173c5(c0400l5);
        c0601t7 = (C0601t7) this.f1079a.get(c0173c5.f793a);
        if (c0601t7 == null) {
            Context context = this.e;
            C0676w7 c0676w7 = this.s;
            String a2 = new C0651v7(c0676w7.f1115a, c0676w7.b, false).a(context, c0173c5);
            C0303h7 c0303h7 = this.d;
            c0303h7.getClass();
            String str = c0400l5.b;
            if (str == null) {
                str = JvmProtoBufUtil.DEFAULT_MODULE_NAME;
            }
            String format = String.format("component-%s", str);
            C0294gn c0294gn = c0303h7.c;
            C0551r7 c0551r7 = c0303h7.f879a;
            C0352j7 c0352j7 = c0551r7.f1033a;
            C0377k7 c0377k7 = c0551r7.b;
            Ka ka = new Ka(false);
            ka.a(112, new C0250f5());
            C0343in c0343in = new C0343in(format, c0303h7.b.f609a);
            c0294gn.getClass();
            c0601t7 = new C0601t7(context, a2, new C0319hn(c0352j7, c0377k7, ka, c0343in), PublicLogger.getAnonymousInstance());
            this.f1079a.put(c0173c5.f793a, c0601t7);
        }
        return c0601t7;
    }

    public final synchronized InterfaceC0179cb d() {
        if (this.l == null) {
            this.l = new Nb(new C0541ql(h()));
        }
        return this.l;
    }

    public final IBinaryDataHelper e() {
        if (this.j == null) {
            if (this.g == null) {
                Context context = this.e;
                C0676w7 c0676w7 = this.s;
                String a2 = new C0651v7(c0676w7.f1115a, c0676w7.b, false).a(context, new B2());
                C0303h7 c0303h7 = this.d;
                c0303h7.getClass();
                HashMap hashMap = new HashMap();
                hashMap.put("binary_data", N5.f559a);
                C0294gn c0294gn = c0303h7.c;
                C0551r7 c0551r7 = c0303h7.f879a;
                C0402l7 c0402l7 = c0551r7.g;
                C0427m7 c0427m7 = c0551r7.h;
                Ka ka = new Ka(false);
                C0343in c0343in = new C0343in("auto_inapp", hashMap);
                c0294gn.getClass();
                this.g = new C0601t7(context, a2, new C0319hn(c0402l7, c0427m7, ka, c0343in), PublicLogger.getAnonymousInstance());
            }
            this.j = new C0473o3(new C0541ql(this.g));
        }
        return this.j;
    }

    public final InterfaceC0179cb f() {
        C0631uc c0631uc;
        if (this.p == null) {
            synchronized (this) {
                if (this.r == null) {
                    C0676w7 c0676w7 = this.s;
                    String a2 = new C0651v7(c0676w7.f1115a, c0676w7.b, true).a(this.e, new C0349j4());
                    Context context = this.e;
                    C0303h7 c0303h7 = this.d;
                    c0303h7.getClass();
                    HashMap hashMap = new HashMap();
                    hashMap.put("preferences", P5.f589a);
                    C0294gn c0294gn = c0303h7.c;
                    C0551r7 c0551r7 = c0303h7.f879a;
                    C0452n7 c0452n7 = c0551r7.c;
                    C0477o7 c0477o7 = c0551r7.d;
                    Ka ka = new Ka(false);
                    ka.a(112, new C0374k4());
                    C0343in c0343in = new C0343in("service database", hashMap);
                    c0294gn.getClass();
                    this.r = new C0631uc(context, a2, new C0604ta(a2), new C0319hn(c0452n7, c0477o7, ka, c0343in));
                }
                c0631uc = this.r;
            }
            this.p = new Nb(c0631uc);
        }
        return this.p;
    }

    public final IBinaryDataHelper g() {
        if (this.h == null) {
            this.h = new C0473o3(new C0541ql(h()));
        }
        return this.h;
    }

    public final synchronized C0601t7 h() {
        if (this.f == null) {
            Context context = this.e;
            C0676w7 c0676w7 = this.s;
            String a2 = new C0651v7(c0676w7.f1115a, c0676w7.b, true).a(context, new C0465nk());
            C0303h7 c0303h7 = this.d;
            c0303h7.getClass();
            HashMap hashMap = new HashMap();
            hashMap.put("preferences", P5.f589a);
            hashMap.put("binary_data", N5.f559a);
            hashMap.put("temp_cache", AbstractC0592sn.f1057a);
            for (ModuleServicesDatabase moduleServicesDatabase : Ia.F.o().b()) {
                for (TableDescription tableDescription : moduleServicesDatabase.getTables()) {
                    hashMap.put(tableDescription.getTableName(), tableDescription.getColumnNames());
                }
            }
            C0294gn c0294gn = c0303h7.c;
            C0551r7 c0551r7 = c0303h7.f879a;
            C0502p7 c0502p7 = c0551r7.e;
            C0527q7 c0527q7 = c0551r7.f;
            Ka ka = new Ka(false);
            ka.a(114, new C0490ok());
            for (ModuleServicesDatabase moduleServicesDatabase2 : Ia.F.o().b()) {
                for (TableDescription tableDescription2 : moduleServicesDatabase2.getTables()) {
                    for (Map.Entry<Integer, DatabaseScript> entry : tableDescription2.getDatabaseProviderUpgradeScript().entrySet()) {
                        ka.a(entry.getKey(), entry.getValue());
                    }
                }
            }
            C0343in c0343in = new C0343in("service database", hashMap);
            c0294gn.getClass();
            this.f = new C0601t7(context, a2, new C0319hn(c0502p7, c0527q7, ka, c0343in), PublicLogger.getAnonymousInstance());
        }
        return this.f;
    }

    public final synchronized InterfaceC0179cb b() {
        return f();
    }

    public final synchronized IBinaryDataHelper a(C0400l5 c0400l5) {
        IBinaryDataHelper iBinaryDataHelper;
        String str = new C0173c5(c0400l5).f793a;
        iBinaryDataHelper = (IBinaryDataHelper) this.c.get(str);
        if (iBinaryDataHelper == null) {
            iBinaryDataHelper = new C0473o3(new C0541ql(c(c0400l5)));
            this.c.put(str, iBinaryDataHelper);
        }
        return iBinaryDataHelper;
    }

    public final synchronized InterfaceC0179cb a() {
        if (this.q == null) {
            this.q = new Ob(f());
        }
        return this.q;
    }

    public final synchronized InterfaceC0179cb c() {
        if (this.m == null) {
            if (this.l == null) {
                this.l = new Nb(new C0541ql(h()));
            }
            this.m = new Ob(this.l);
        }
        return this.m;
    }
}
