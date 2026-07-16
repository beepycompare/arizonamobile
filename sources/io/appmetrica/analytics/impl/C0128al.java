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
/* renamed from: io.appmetrica.analytics.impl.al  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0128al {

    /* renamed from: a  reason: collision with root package name */
    public final C0553r7 f893a;
    public C0502p7 b;
    public C0239f3 c;
    public C0265g3 d;
    public Ub e;
    public Vb f;
    public Un g;
    public Vn h;
    public final LinkedHashMap i = new LinkedHashMap();
    public final LinkedHashMap j = new LinkedHashMap();
    public final LinkedHashMap k = new LinkedHashMap();

    public C0128al(File file) {
        this.f893a = new C0553r7(file);
    }

    public final IBinaryDataHelper a(Context context) {
        C0239f3 c0239f3 = this.c;
        if (c0239f3 == null) {
            C0239f3 c0239f32 = new C0239f3(new Vl(f(context)), "binary_data");
            this.c = c0239f32;
            return c0239f32;
        }
        return c0239f3;
    }

    public final synchronized IBinaryDataHelper b(Context context) {
        C0265g3 c0265g3;
        c0265g3 = this.d;
        if (c0265g3 == null) {
            c0265g3 = new C0265g3(a(context));
            this.d = c0265g3;
        }
        return c0265g3;
    }

    public final synchronized IBinaryDataHelper c(Context context) {
        return a(context);
    }

    public final synchronized InterfaceC0350jb d(Context context) {
        Vb vb;
        vb = this.f;
        if (vb == null) {
            Ub ub = this.e;
            if (ub == null) {
                ub = new Ub("preferences", new Vl(f(context)), Na.I.d.e());
                this.e = ub;
            }
            vb = new Vb(ub);
            this.f = vb;
        }
        return vb;
    }

    public final synchronized InterfaceC0350jb e(Context context) {
        Ub ub;
        ub = this.e;
        if (ub == null) {
            ub = new Ub("preferences", new Vl(f(context)), Na.I.d.e());
            this.e = ub;
        }
        return ub;
    }

    public final synchronized C0502p7 f(Context context) {
        C0502p7 c0502p7;
        c0502p7 = this.b;
        if (c0502p7 == null) {
            C0553r7 c0553r7 = this.f893a;
            String a2 = new C0528q7(c0553r7.f1181a, c0553r7.b, true).a(context, new Hk());
            C0192d7 c0192d7 = M5.c;
            c0192d7.getClass();
            HashMap hashMap = new HashMap();
            hashMap.put("preferences", J5.f608a);
            hashMap.put("binary_data", H5.f574a);
            hashMap.put("temp_cache", Yn.f865a);
            for (ModuleServicesDatabase moduleServicesDatabase : Na.I.p().a()) {
                for (TableDescription tableDescription : moduleServicesDatabase.getTables()) {
                    hashMap.put(tableDescription.getTableName(), tableDescription.getColumnNames());
                }
            }
            In in = c0192d7.c;
            C0450n7 c0450n7 = c0192d7.f942a;
            C0398l7 c0398l7 = c0450n7.e;
            C0424m7 c0424m7 = c0450n7.f;
            Sa sa = new Sa(false);
            sa.a(114, new Ik());
            for (ModuleServicesDatabase moduleServicesDatabase2 : Na.I.p().a()) {
                for (TableDescription tableDescription2 : moduleServicesDatabase2.getTables()) {
                    for (Map.Entry<Integer, DatabaseScript> entry : tableDescription2.getDatabaseProviderUpgradeScript().entrySet()) {
                        sa.a(entry.getKey(), entry.getValue());
                    }
                }
            }
            Ln ln = new Ln("service database", hashMap);
            in.getClass();
            c0502p7 = new C0502p7(context, a2, new Jn(c0398l7, c0424m7, sa, ln), PublicLogger.getAnonymousInstance());
            this.b = c0502p7;
        }
        return c0502p7;
    }

    public final synchronized C0502p7 c(Context context, C0267g5 c0267g5) {
        Object obj;
        String str = new X4(c0267g5).f838a;
        LinkedHashMap linkedHashMap = this.i;
        obj = linkedHashMap.get(str);
        if (obj == null) {
            C0553r7 c0553r7 = this.f893a;
            String a2 = new C0528q7(c0553r7.f1181a, c0553r7.b, false).a(context, new X4(c0267g5));
            C0192d7 c0192d7 = M5.c;
            c0192d7.getClass();
            String str2 = c0267g5.b;
            if (str2 == null) {
                str2 = JvmProtoBufUtil.DEFAULT_MODULE_NAME;
            }
            String format = String.format("component-%s", str2);
            In in = c0192d7.c;
            C0450n7 c0450n7 = c0192d7.f942a;
            C0243f7 c0243f7 = c0450n7.f1113a;
            C0269g7 c0269g7 = c0450n7.b;
            Sa sa = new Sa(false);
            sa.a(112, new C0112a5());
            Ln ln = new Ln(format, c0192d7.b.f662a);
            in.getClass();
            obj = new C0502p7(context, a2, new Jn(c0243f7, c0269g7, sa, ln), PublicLogger.getAnonymousInstance());
            linkedHashMap.put(str, obj);
        }
        return (C0502p7) obj;
    }

    public final synchronized IBinaryDataHelper a(Context context, C0267g5 c0267g5) {
        Object obj;
        String str = new X4(c0267g5).f838a;
        LinkedHashMap linkedHashMap = this.k;
        obj = linkedHashMap.get(str);
        if (obj == null) {
            obj = new C0239f3(new Vl(c(context, c0267g5)), "binary_data");
            linkedHashMap.put(str, obj);
        }
        return (IBinaryDataHelper) obj;
    }

    public final synchronized InterfaceC0350jb b(Context context, C0267g5 c0267g5) {
        Object obj;
        String str = new X4(c0267g5).f838a;
        LinkedHashMap linkedHashMap = this.j;
        obj = linkedHashMap.get(str);
        if (obj == null) {
            obj = new Ub("preferences", new Vl(c(context, c0267g5)), Na.I.d.e());
            linkedHashMap.put(str, obj);
        }
        return (InterfaceC0350jb) obj;
    }
}
