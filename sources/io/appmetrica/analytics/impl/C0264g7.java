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
/* renamed from: io.appmetrica.analytics.impl.g7  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0264g7 {
    public static volatile C0264g7 q;
    public final Context e;
    public C0238f7 f;
    public C0105a3 g;
    public C0131b3 h;
    public C0746zb i;
    public Ab j;
    public C0633un k;
    public C0658vn l;
    public C0746zb m;
    public Ab n;
    public C0269gc o;

    /* renamed from: a  reason: collision with root package name */
    public final HashMap f889a = new HashMap();
    public final HashMap b = new HashMap();
    public final HashMap c = new HashMap();
    public final T6 d = D5.a();
    public final C0316i7 p = new C0316i7();

    public C0264g7(Context context) {
        this.e = context;
    }

    public static C0264g7 a(Context context) {
        if (q == null) {
            synchronized (C0264g7.class) {
                if (q == null) {
                    q = new C0264g7(context.getApplicationContext());
                }
            }
        }
        return q;
    }

    public final synchronized Oa b(X4 x4) {
        Oa oa;
        String str = new O4(x4).f616a;
        oa = (Oa) this.b.get(str);
        if (oa == null) {
            oa = new C0746zb(new C0631ul(c(x4)));
            this.b.put(str, oa);
        }
        return oa;
    }

    public final synchronized C0238f7 c(X4 x4) {
        C0238f7 c0238f7;
        O4 o4 = new O4(x4);
        c0238f7 = (C0238f7) this.f889a.get(o4.f616a);
        if (c0238f7 == null) {
            Context context = this.e;
            C0316i7 c0316i7 = this.p;
            String a2 = new C0290h7(c0316i7.f927a, c0316i7.b, false).a(context, o4);
            T6 t6 = this.d;
            t6.getClass();
            String str = x4.b;
            if (str == null) {
                str = JvmProtoBufUtil.DEFAULT_MODULE_NAME;
            }
            String format = String.format("component-%s", str);
            C0383kn c0383kn = t6.c;
            C0187d7 c0187d7 = t6.f699a;
            V6 v6 = c0187d7.f843a;
            W6 w6 = c0187d7.b;
            C0670wa c0670wa = new C0670wa(false);
            c0670wa.a(112, new R4());
            C0459nn c0459nn = new C0459nn(format, t6.b.f423a);
            c0383kn.getClass();
            c0238f7 = new C0238f7(context, a2, new C0409ln(v6, w6, c0670wa, c0459nn), PublicLogger.getAnonymousInstance());
            this.f889a.put(o4.f616a, c0238f7);
        }
        return c0238f7;
    }

    public final synchronized Oa d() {
        if (this.i == null) {
            this.i = new C0746zb(new C0631ul(h()));
        }
        return this.i;
    }

    public final Oa e() {
        C0269gc c0269gc;
        if (this.m == null) {
            synchronized (this) {
                if (this.o == null) {
                    C0316i7 c0316i7 = this.p;
                    String a2 = new C0290h7(c0316i7.f927a, c0316i7.b, true).a(this.e, new V3());
                    Context context = this.e;
                    T6 t6 = this.d;
                    t6.getClass();
                    HashMap hashMap = new HashMap();
                    hashMap.put("preferences", A5.f390a);
                    C0383kn c0383kn = t6.c;
                    C0187d7 c0187d7 = t6.f699a;
                    Z6 z6 = c0187d7.c;
                    C0109a7 c0109a7 = c0187d7.d;
                    C0670wa c0670wa = new C0670wa(false);
                    c0670wa.a(112, new W3());
                    C0459nn c0459nn = new C0459nn("service database", hashMap);
                    c0383kn.getClass();
                    this.o = new C0269gc(context, a2, new C0241fa(a2), new C0409ln(z6, c0109a7, c0670wa, c0459nn));
                }
                c0269gc = this.o;
            }
            this.m = new C0746zb(c0269gc);
        }
        return this.m;
    }

    public final IBinaryDataHelper f() {
        if (this.g == null) {
            this.g = new C0105a3(new C0631ul(h()), "binary_data");
        }
        return this.g;
    }

    public final synchronized IBinaryDataHelper g() {
        if (this.h == null) {
            this.h = new C0131b3(f());
        }
        return this.h;
    }

    public final synchronized C0238f7 h() {
        if (this.f == null) {
            Context context = this.e;
            C0316i7 c0316i7 = this.p;
            String a2 = new C0290h7(c0316i7.f927a, c0316i7.b, true).a(context, new C0380kk());
            T6 t6 = this.d;
            t6.getClass();
            HashMap hashMap = new HashMap();
            hashMap.put("preferences", A5.f390a);
            hashMap.put("binary_data", AbstractC0715y5.f1209a);
            hashMap.put("temp_cache", AbstractC0708xn.f1205a);
            for (ModuleServicesDatabase moduleServicesDatabase : C0620ua.H.p().b()) {
                for (TableDescription tableDescription : moduleServicesDatabase.getTables()) {
                    hashMap.put(tableDescription.getTableName(), tableDescription.getColumnNames());
                }
            }
            C0383kn c0383kn = t6.c;
            C0187d7 c0187d7 = t6.f699a;
            C0135b7 c0135b7 = c0187d7.e;
            C0161c7 c0161c7 = c0187d7.f;
            C0670wa c0670wa = new C0670wa(false);
            c0670wa.a(114, new C0406lk());
            for (ModuleServicesDatabase moduleServicesDatabase2 : C0620ua.H.p().b()) {
                for (TableDescription tableDescription2 : moduleServicesDatabase2.getTables()) {
                    for (Map.Entry<Integer, DatabaseScript> entry : tableDescription2.getDatabaseProviderUpgradeScript().entrySet()) {
                        c0670wa.a(entry.getKey(), entry.getValue());
                    }
                }
            }
            C0459nn c0459nn = new C0459nn("service database", hashMap);
            c0383kn.getClass();
            this.f = new C0238f7(context, a2, new C0409ln(c0135b7, c0161c7, c0670wa, c0459nn), PublicLogger.getAnonymousInstance());
        }
        return this.f;
    }

    public final synchronized Oa b() {
        return e();
    }

    public final synchronized IBinaryDataHelper a(X4 x4) {
        IBinaryDataHelper iBinaryDataHelper;
        String str = new O4(x4).f616a;
        iBinaryDataHelper = (IBinaryDataHelper) this.c.get(str);
        if (iBinaryDataHelper == null) {
            iBinaryDataHelper = new C0105a3(new C0631ul(c(x4)), "binary_data");
            this.c.put(str, iBinaryDataHelper);
        }
        return iBinaryDataHelper;
    }

    public final synchronized Oa a() {
        if (this.n == null) {
            this.n = new Ab(e());
        }
        return this.n;
    }

    public final synchronized Oa c() {
        if (this.j == null) {
            if (this.i == null) {
                this.i = new C0746zb(new C0631ul(h()));
            }
            this.j = new Ab(this.i);
        }
        return this.j;
    }
}
