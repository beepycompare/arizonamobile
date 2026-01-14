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
/* renamed from: io.appmetrica.analytics.impl.yk  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0733yk {

    /* renamed from: a  reason: collision with root package name */
    public final C0113a7 f1324a;
    public Y6 b;
    public S2 c;
    public T2 d;
    public C0574sb e;
    public C0599tb f;
    public C0586sn g;
    public C0611tn h;
    public final LinkedHashMap i = new LinkedHashMap();
    public final LinkedHashMap j = new LinkedHashMap();
    public final LinkedHashMap k = new LinkedHashMap();

    public C0733yk(File file) {
        this.f1324a = new C0113a7(file);
    }

    public final IBinaryDataHelper a(Context context) {
        S2 s2 = this.c;
        if (s2 == null) {
            S2 s22 = new S2(new C0535ql(f(context)), "binary_data");
            this.c = s22;
            return s22;
        }
        return s2;
    }

    public final synchronized IBinaryDataHelper b(Context context) {
        T2 t2;
        t2 = this.d;
        if (t2 == null) {
            t2 = new T2(a(context));
            this.d = t2;
        }
        return t2;
    }

    public final synchronized IBinaryDataHelper c(Context context) {
        return a(context);
    }

    public final synchronized Ha d(Context context) {
        C0599tb c0599tb;
        c0599tb = this.f;
        if (c0599tb == null) {
            C0574sb c0574sb = this.e;
            if (c0574sb == null) {
                c0574sb = new C0574sb(new C0535ql(f(context)));
                this.e = c0574sb;
            }
            c0599tb = new C0599tb(c0574sb);
            this.f = c0599tb;
        }
        return c0599tb;
    }

    public final synchronized Ha e(Context context) {
        C0574sb c0574sb;
        c0574sb = this.e;
        if (c0574sb == null) {
            c0574sb = new C0574sb(new C0535ql(f(context)));
            this.e = c0574sb;
        }
        return c0574sb;
    }

    public final synchronized Y6 f(Context context) {
        Y6 y6;
        y6 = this.b;
        if (y6 == null) {
            C0113a7 c0113a7 = this.f1324a;
            String a2 = new Z6(c0113a7.f901a, c0113a7.b, true).a(context, new C0255fk());
            M6 m6 = AbstractC0668w5.c;
            m6.getClass();
            HashMap hashMap = new HashMap();
            hashMap.put("preferences", InterfaceC0593t5.f1231a);
            hashMap.put("binary_data", AbstractC0543r5.f1202a);
            hashMap.put("temp_cache", AbstractC0661vn.f1277a);
            for (ModuleServicesDatabase moduleServicesDatabase : C0449na.I.p().b()) {
                for (TableDescription tableDescription : moduleServicesDatabase.getTables()) {
                    hashMap.put(tableDescription.getTableName(), tableDescription.getColumnNames());
                }
            }
            C0310hn c0310hn = m6.c;
            W6 w6 = m6.f688a;
            U6 u6 = w6.e;
            V6 v6 = w6.f;
            C0499pa c0499pa = new C0499pa(false);
            c0499pa.a(114, new C0281gk());
            for (ModuleServicesDatabase moduleServicesDatabase2 : C0449na.I.p().b()) {
                for (TableDescription tableDescription2 : moduleServicesDatabase2.getTables()) {
                    for (Map.Entry<Integer, DatabaseScript> entry : tableDescription2.getDatabaseProviderUpgradeScript().entrySet()) {
                        c0499pa.a(entry.getKey(), entry.getValue());
                    }
                }
            }
            C0387kn c0387kn = new C0387kn("service database", hashMap);
            c0310hn.getClass();
            y6 = new Y6(context, a2, new C0335in(u6, v6, c0499pa, c0387kn), PublicLogger.getAnonymousInstance());
            this.b = y6;
        }
        return y6;
    }

    public final synchronized Y6 c(Context context, Q4 q4) {
        Object obj;
        String str = new H4(q4).f609a;
        LinkedHashMap linkedHashMap = this.i;
        obj = linkedHashMap.get(str);
        if (obj == null) {
            C0113a7 c0113a7 = this.f1324a;
            String a2 = new Z6(c0113a7.f901a, c0113a7.b, false).a(context, new H4(q4));
            M6 m6 = AbstractC0668w5.c;
            m6.getClass();
            String str2 = q4.b;
            if (str2 == null) {
                str2 = JvmProtoBufUtil.DEFAULT_MODULE_NAME;
            }
            String format = String.format("component-%s", str2);
            C0310hn c0310hn = m6.c;
            W6 w6 = m6.f688a;
            O6 o6 = w6.f838a;
            P6 p6 = w6.b;
            C0499pa c0499pa = new C0499pa(false);
            c0499pa.a(112, new K4());
            C0387kn c0387kn = new C0387kn(format, m6.b.f1252a);
            c0310hn.getClass();
            obj = new Y6(context, a2, new C0335in(o6, p6, c0499pa, c0387kn), PublicLogger.getAnonymousInstance());
            linkedHashMap.put(str, obj);
        }
        return (Y6) obj;
    }

    public final synchronized IBinaryDataHelper a(Context context, Q4 q4) {
        Object obj;
        String str = new H4(q4).f609a;
        LinkedHashMap linkedHashMap = this.k;
        obj = linkedHashMap.get(str);
        if (obj == null) {
            obj = new S2(new C0535ql(c(context, q4)), "binary_data");
            linkedHashMap.put(str, obj);
        }
        return (IBinaryDataHelper) obj;
    }

    public final synchronized Ha b(Context context, Q4 q4) {
        Object obj;
        String str = new H4(q4).f609a;
        LinkedHashMap linkedHashMap = this.j;
        obj = linkedHashMap.get(str);
        if (obj == null) {
            obj = new C0574sb(new C0535ql(c(context, q4)));
            linkedHashMap.put(str, obj);
        }
        return (Ha) obj;
    }
}
