package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.data.IBinaryDataHelper;
import io.appmetrica.analytics.coreapi.internal.db.DatabaseScript;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import io.appmetrica.analytics.modulesapi.internal.common.TableDescription;
import io.appmetrica.analytics.modulesapi.internal.service.ModuleServicesDatabase;
import java.io.File;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlinx.metadata.internal.metadata.jvm.deserialization.JvmProtoBufUtil;
/* renamed from: io.appmetrica.analytics.impl.zk  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0755zk {

    /* renamed from: a  reason: collision with root package name */
    public final C0135b7 f1235a;
    public Z6 b;
    public T2 c;
    public U2 d;
    public C0596tb e;
    public C0621ub f;
    public C0608tn g;
    public C0633un h;
    public final LinkedHashMap i = new LinkedHashMap();
    public final LinkedHashMap j = new LinkedHashMap();
    public final LinkedHashMap k = new LinkedHashMap();

    public C0755zk(File file) {
        this.f1235a = new C0135b7(file);
    }

    public final IBinaryDataHelper a(Context context) {
        T2 t2 = this.c;
        if (t2 == null) {
            T2 t22 = new T2(new C0556rl(f(context)), "binary_data");
            this.c = t22;
            return t22;
        }
        return t2;
    }

    public final synchronized IBinaryDataHelper b(Context context) {
        U2 u2;
        u2 = this.d;
        if (u2 == null) {
            u2 = new U2(a(context));
            this.d = u2;
        }
        return u2;
    }

    public final synchronized IBinaryDataHelper c(Context context) {
        return a(context);
    }

    public final synchronized Ia d(Context context) {
        C0621ub c0621ub;
        c0621ub = this.f;
        if (c0621ub == null) {
            C0596tb c0596tb = this.e;
            if (c0596tb == null) {
                c0596tb = new C0596tb(new C0556rl(f(context)));
                this.e = c0596tb;
            }
            c0621ub = new C0621ub(c0596tb);
            this.f = c0621ub;
        }
        return c0621ub;
    }

    public final synchronized Ia e(Context context) {
        C0596tb c0596tb;
        c0596tb = this.e;
        if (c0596tb == null) {
            c0596tb = new C0596tb(new C0556rl(f(context)));
            this.e = c0596tb;
        }
        return c0596tb;
    }

    public final synchronized Z6 f(Context context) {
        Z6 z6;
        z6 = this.b;
        if (z6 == null) {
            C0135b7 c0135b7 = this.f1235a;
            String a2 = new C0109a7(c0135b7.f813a, c0135b7.b, true).a(context, new C0277gk());
            N6 n6 = AbstractC0690x5.c;
            n6.getClass();
            HashMap hashMap = new HashMap();
            hashMap.put("preferences", InterfaceC0615u5.f1143a);
            hashMap.put("binary_data", AbstractC0565s5.f1113a);
            hashMap.put("temp_cache", AbstractC0683wn.f1188a);
            for (ModuleServicesDatabase moduleServicesDatabase : C0471oa.I.p().b()) {
                for (TableDescription tableDescription : moduleServicesDatabase.getTables()) {
                    hashMap.put(tableDescription.getTableName(), tableDescription.getColumnNames());
                }
            }
            C0331in c0331in = n6.c;
            X6 x6 = n6.f599a;
            V6 v6 = x6.e;
            W6 w6 = x6.f;
            C0521qa c0521qa = new C0521qa(false);
            c0521qa.a(114, new C0303hk());
            for (ModuleServicesDatabase moduleServicesDatabase2 : C0471oa.I.p().b()) {
                for (TableDescription tableDescription2 : moduleServicesDatabase2.getTables()) {
                    for (Map.Entry<Integer, DatabaseScript> entry : tableDescription2.getDatabaseProviderUpgradeScript().entrySet()) {
                        c0521qa.a(entry.getKey(), entry.getValue());
                    }
                }
            }
            C0409ln c0409ln = new C0409ln("service database", hashMap);
            c0331in.getClass();
            z6 = new Z6(context, a2, new C0357jn(v6, w6, c0521qa, c0409ln), PublicLogger.getAnonymousInstance());
            this.b = z6;
        }
        return z6;
    }

    public final synchronized Z6 c(Context context, R4 r4) {
        Object obj;
        String str = new I4(r4).f519a;
        LinkedHashMap linkedHashMap = this.i;
        obj = linkedHashMap.get(str);
        if (obj == null) {
            C0135b7 c0135b7 = this.f1235a;
            String a2 = new C0109a7(c0135b7.f813a, c0135b7.b, false).a(context, new I4(r4));
            N6 n6 = AbstractC0690x5.c;
            n6.getClass();
            String str2 = r4.b;
            if (str2 == null) {
                str2 = JvmProtoBufUtil.DEFAULT_MODULE_NAME;
            }
            String format = String.format("component-%s", str2);
            C0331in c0331in = n6.c;
            X6 x6 = n6.f599a;
            P6 p6 = x6.f748a;
            Q6 q6 = x6.b;
            C0521qa c0521qa = new C0521qa(false);
            c0521qa.a(112, new L4());
            C0409ln c0409ln = new C0409ln(format, n6.b.f1164a);
            c0331in.getClass();
            obj = new Z6(context, a2, new C0357jn(p6, q6, c0521qa, c0409ln), PublicLogger.getAnonymousInstance());
            linkedHashMap.put(str, obj);
        }
        return (Z6) obj;
    }

    public final synchronized IBinaryDataHelper a(Context context, R4 r4) {
        Object obj;
        String str = new I4(r4).f519a;
        LinkedHashMap linkedHashMap = this.k;
        obj = linkedHashMap.get(str);
        if (obj == null) {
            obj = new T2(new C0556rl(c(context, r4)), "binary_data");
            linkedHashMap.put(str, obj);
        }
        return (IBinaryDataHelper) obj;
    }

    public final synchronized Ia b(Context context, R4 r4) {
        Object obj;
        String str = new I4(r4).f519a;
        LinkedHashMap linkedHashMap = this.j;
        obj = linkedHashMap.get(str);
        if (obj == null) {
            obj = new C0596tb(new C0556rl(c(context, r4)));
            linkedHashMap.put(str, obj);
        }
        return (Ia) obj;
    }
}
