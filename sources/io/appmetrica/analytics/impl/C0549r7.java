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
/* renamed from: io.appmetrica.analytics.impl.r7  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0549r7 {
    public static volatile C0549r7 t;
    public final Context e;
    public C0525q7 f;
    public C0525q7 g;
    public C0471o3 h;
    public C0496p3 i;
    public C0471o3 j;
    public C0496p3 k;
    public Lb l;
    public Mb m;
    public C0441mn n;
    public C0466nn o;
    public Lb p;
    public Mb q;
    public C0579sc r;

    /* renamed from: a  reason: collision with root package name */
    public final HashMap f1022a = new HashMap();
    public final HashMap b = new HashMap();
    public final HashMap c = new HashMap();
    public final C0226e7 d = P5.a();
    public final C0599t7 s = new C0599t7();

    public C0549r7(Context context) {
        this.e = context;
    }

    public static C0549r7 a(Context context) {
        if (t == null) {
            synchronized (C0549r7.class) {
                if (t == null) {
                    t = new C0549r7(context.getApplicationContext());
                }
            }
        }
        return t;
    }

    public final synchronized InterfaceC0127ab b(C0398l5 c0398l5) {
        InterfaceC0127ab interfaceC0127ab;
        String str = new C0173c5(c0398l5).f780a;
        interfaceC0127ab = (InterfaceC0127ab) this.b.get(str);
        if (interfaceC0127ab == null) {
            interfaceC0127ab = new Lb(new C0464nl(c(c0398l5)));
            this.b.put(str, interfaceC0127ab);
        }
        return interfaceC0127ab;
    }

    public final synchronized C0525q7 c(C0398l5 c0398l5) {
        C0525q7 c0525q7;
        C0173c5 c0173c5 = new C0173c5(c0398l5);
        c0525q7 = (C0525q7) this.f1022a.get(c0173c5.f780a);
        if (c0525q7 == null) {
            Context context = this.e;
            C0599t7 c0599t7 = this.s;
            String a2 = new C0574s7(c0599t7.f1055a, c0599t7.b, false).a(context, c0173c5);
            C0226e7 c0226e7 = this.d;
            c0226e7.getClass();
            String str = c0398l5.b;
            if (str == null) {
                str = JvmProtoBufUtil.DEFAULT_MODULE_NAME;
            }
            String format = String.format("component-%s", str);
            C0217dn c0217dn = c0226e7.c;
            C0475o7 c0475o7 = c0226e7.f818a;
            C0276g7 c0276g7 = c0475o7.f970a;
            C0301h7 c0301h7 = c0475o7.b;
            Ia ia = new Ia(false);
            ia.a(112, new C0249f5());
            C0267fn c0267fn = new C0267fn(format, c0226e7.b.f551a);
            c0217dn.getClass();
            c0525q7 = new C0525q7(context, a2, new C0242en(c0276g7, c0301h7, ia, c0267fn), PublicLogger.getAnonymousInstance());
            this.f1022a.put(c0173c5.f780a, c0525q7);
        }
        return c0525q7;
    }

    public final synchronized InterfaceC0127ab d() {
        if (this.l == null) {
            this.l = new Lb(new C0464nl(h()));
        }
        return this.l;
    }

    public final IBinaryDataHelper e() {
        if (this.j == null) {
            if (this.g == null) {
                Context context = this.e;
                C0599t7 c0599t7 = this.s;
                String a2 = new C0574s7(c0599t7.f1055a, c0599t7.b, false).a(context, new B2());
                C0226e7 c0226e7 = this.d;
                c0226e7.getClass();
                HashMap hashMap = new HashMap();
                hashMap.put("binary_data", K5.f502a);
                C0217dn c0217dn = c0226e7.c;
                C0475o7 c0475o7 = c0226e7.f818a;
                C0326i7 c0326i7 = c0475o7.g;
                C0350j7 c0350j7 = c0475o7.h;
                Ia ia = new Ia(false);
                C0267fn c0267fn = new C0267fn("auto_inapp", hashMap);
                c0217dn.getClass();
                this.g = new C0525q7(context, a2, new C0242en(c0326i7, c0350j7, ia, c0267fn), PublicLogger.getAnonymousInstance());
            }
            this.j = new C0471o3(new C0464nl(this.g));
        }
        return this.j;
    }

    public final InterfaceC0127ab f() {
        C0579sc c0579sc;
        if (this.p == null) {
            synchronized (this) {
                if (this.r == null) {
                    C0599t7 c0599t7 = this.s;
                    String a2 = new C0574s7(c0599t7.f1055a, c0599t7.b, true).a(this.e, new C0347j4());
                    Context context = this.e;
                    C0226e7 c0226e7 = this.d;
                    c0226e7.getClass();
                    HashMap hashMap = new HashMap();
                    hashMap.put("preferences", M5.f530a);
                    C0217dn c0217dn = c0226e7.c;
                    C0475o7 c0475o7 = c0226e7.f818a;
                    C0375k7 c0375k7 = c0475o7.c;
                    C0400l7 c0400l7 = c0475o7.d;
                    Ia ia = new Ia(false);
                    ia.a(112, new C0372k4());
                    C0267fn c0267fn = new C0267fn("service database", hashMap);
                    c0217dn.getClass();
                    this.r = new C0579sc(context, a2, new C0552ra(a2), new C0242en(c0375k7, c0400l7, ia, c0267fn));
                }
                c0579sc = this.r;
            }
            this.p = new Lb(c0579sc);
        }
        return this.p;
    }

    public final IBinaryDataHelper g() {
        if (this.h == null) {
            this.h = new C0471o3(new C0464nl(h()));
        }
        return this.h;
    }

    public final synchronized C0525q7 h() {
        if (this.f == null) {
            Context context = this.e;
            C0599t7 c0599t7 = this.s;
            String a2 = new C0574s7(c0599t7.f1055a, c0599t7.b, true).a(context, new C0388kk());
            C0226e7 c0226e7 = this.d;
            c0226e7.getClass();
            HashMap hashMap = new HashMap();
            hashMap.put("preferences", M5.f530a);
            hashMap.put("binary_data", K5.f502a);
            hashMap.put("temp_cache", AbstractC0516pn.f996a);
            for (ModuleServicesDatabase moduleServicesDatabase : Ga.F.o().b()) {
                for (TableDescription tableDescription : moduleServicesDatabase.getTables()) {
                    hashMap.put(tableDescription.getTableName(), tableDescription.getColumnNames());
                }
            }
            C0217dn c0217dn = c0226e7.c;
            C0475o7 c0475o7 = c0226e7.f818a;
            C0425m7 c0425m7 = c0475o7.e;
            C0450n7 c0450n7 = c0475o7.f;
            Ia ia = new Ia(false);
            ia.a(114, new C0413lk());
            for (ModuleServicesDatabase moduleServicesDatabase2 : Ga.F.o().b()) {
                for (TableDescription tableDescription2 : moduleServicesDatabase2.getTables()) {
                    for (Map.Entry<Integer, DatabaseScript> entry : tableDescription2.getDatabaseProviderUpgradeScript().entrySet()) {
                        ia.a(entry.getKey(), entry.getValue());
                    }
                }
            }
            C0267fn c0267fn = new C0267fn("service database", hashMap);
            c0217dn.getClass();
            this.f = new C0525q7(context, a2, new C0242en(c0425m7, c0450n7, ia, c0267fn), PublicLogger.getAnonymousInstance());
        }
        return this.f;
    }

    public final synchronized InterfaceC0127ab b() {
        return f();
    }

    public final synchronized IBinaryDataHelper a(C0398l5 c0398l5) {
        IBinaryDataHelper iBinaryDataHelper;
        String str = new C0173c5(c0398l5).f780a;
        iBinaryDataHelper = (IBinaryDataHelper) this.c.get(str);
        if (iBinaryDataHelper == null) {
            iBinaryDataHelper = new C0471o3(new C0464nl(c(c0398l5)));
            this.c.put(str, iBinaryDataHelper);
        }
        return iBinaryDataHelper;
    }

    public final synchronized InterfaceC0127ab a() {
        if (this.q == null) {
            this.q = new Mb(f());
        }
        return this.q;
    }

    public final synchronized InterfaceC0127ab c() {
        if (this.m == null) {
            if (this.l == null) {
                this.l = new Lb(new C0464nl(h()));
            }
            this.m = new Mb(this.l);
        }
        return this.m;
    }
}
