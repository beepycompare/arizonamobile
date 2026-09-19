package io.appmetrica.analytics.impl;

import android.content.Context;
import android.content.pm.FeatureInfo;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.facebook.internal.NativeProtocol;
import io.appmetrica.analytics.coreutils.internal.AndroidUtils;
import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
import io.appmetrica.analytics.coreutils.internal.services.SafePackageManager;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
/* renamed from: io.appmetrica.analytics.impl.mh  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0432mh extends AbstractC0303hh {
    public final SafePackageManager b;

    public C0432mh(C0446n5 c0446n5) {
        this(c0446n5, new SafePackageManager());
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x004d A[Catch: all -> 0x00c0, TryCatch #0 {all -> 0x00c0, blocks: (B:15:0x0043, B:17:0x004d, B:18:0x0051, B:19:0x005a, B:21:0x0060, B:23:0x0083, B:24:0x0088, B:25:0x008c), top: B:28:0x0043 }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0051 A[Catch: all -> 0x00c0, TryCatch #0 {all -> 0x00c0, blocks: (B:15:0x0043, B:17:0x004d, B:18:0x0051, B:19:0x005a, B:21:0x0060, B:23:0x0083, B:24:0x0088, B:25:0x008c), top: B:28:0x0043 }] */
    @Override // io.appmetrica.analytics.impl.AbstractC0303hh
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean a(C0240f6 c0240f6) {
        HashSet hashSet;
        ArrayList b;
        C0446n5 c0446n5 = this.f1019a;
        if (c0446n5.t.c() && c0446n5.y()) {
            C0689wf c0689wf = c0446n5.c;
            String e = this.f1019a.c.e();
            try {
                if (!TextUtils.isEmpty(e)) {
                    try {
                        hashSet = new HashSet();
                        JSONArray jSONArray = new JSONArray(e);
                        for (int i = 0; i < jSONArray.length(); i++) {
                            hashSet.add(new C0425ma(jSONArray.getJSONObject(i)));
                        }
                    } catch (Throwable unused) {
                        hashSet = null;
                    }
                    b = b();
                    if (!CollectionUtils.areCollectionsEqual(hashSet, b)) {
                        c0446n5.v();
                    } else {
                        JSONArray jSONArray2 = new JSONArray();
                        Iterator it = b.iterator();
                        while (it.hasNext()) {
                            C0425ma c0425ma = (C0425ma) it.next();
                            c0425ma.getClass();
                            JSONObject put = new JSONObject().put("name", c0425ma.f1096a).put("required", c0425ma.c);
                            int i2 = c0425ma.b;
                            if (i2 != -1) {
                                put.put(NativeProtocol.PLATFORM_PROVIDER_VERSION_COLUMN, i2);
                            }
                            jSONArray2.put(put);
                        }
                        C0240f6 a2 = C0240f6.a(c0240f6, new JSONObject().put("features", jSONArray2).toString());
                        E9 e9 = c0446n5.n;
                        e9.a(a2, C0669vl.a(e9.c.b(a2), a2.i));
                        int i3 = e9.j;
                        e9.l = i3;
                        e9.f527a.a(i3);
                        c0689wf.i(jSONArray2.toString());
                    }
                }
                b = b();
                if (!CollectionUtils.areCollectionsEqual(hashSet, b)) {
                }
            } catch (Throwable unused2) {
            }
            hashSet = null;
        }
        return false;
    }

    public final ArrayList b() {
        AbstractC0399la c0373ka;
        FeatureInfo[] featureInfoArr;
        try {
            C0446n5 c0446n5 = this.f1019a;
            SafePackageManager safePackageManager = this.b;
            Context context = c0446n5.f1111a;
            PackageInfo packageInfo = safePackageManager.getPackageInfo(context, context.getPackageName(), 16384);
            ArrayList arrayList = new ArrayList();
            if (AndroidUtils.isApiAchieved(24)) {
                c0373ka = new C0347ja();
            } else {
                c0373ka = new C0373ka();
            }
            if (packageInfo != null && (featureInfoArr = packageInfo.reqFeatures) != null) {
                for (FeatureInfo featureInfo : featureInfoArr) {
                    arrayList.add(c0373ka.a(featureInfo));
                }
            }
            return arrayList;
        } catch (Throwable unused) {
            return null;
        }
    }

    public C0432mh(C0446n5 c0446n5, SafePackageManager safePackageManager) {
        super(c0446n5);
        this.b = safePackageManager;
    }
}
