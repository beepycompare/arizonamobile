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
/* renamed from: io.appmetrica.analytics.impl.rh  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0563rh extends AbstractC0462nh {
    public final SafePackageManager b;

    public C0563rh(C0651v5 c0651v5) {
        this(c0651v5, new SafePackageManager());
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x004d A[Catch: all -> 0x00d0, TryCatch #0 {all -> 0x00d0, blocks: (B:15:0x0043, B:17:0x004d, B:18:0x005d, B:19:0x0066, B:21:0x006c, B:23:0x008f, B:24:0x0094, B:25:0x0098), top: B:28:0x0043 }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x005d A[Catch: all -> 0x00d0, TryCatch #0 {all -> 0x00d0, blocks: (B:15:0x0043, B:17:0x004d, B:18:0x005d, B:19:0x0066, B:21:0x006c, B:23:0x008f, B:24:0x0094, B:25:0x0098), top: B:28:0x0043 }] */
    @Override // io.appmetrica.analytics.impl.AbstractC0462nh
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean a(C0477o6 c0477o6) {
        HashSet hashSet;
        ArrayList b;
        C0651v5 c0651v5 = this.f1001a;
        if (c0651v5.t.c() && c0651v5.y()) {
            C0537qf c0537qf = c0651v5.c;
            String e = this.f1001a.c.e();
            try {
                if (!TextUtils.isEmpty(e)) {
                    try {
                        hashSet = new HashSet();
                        JSONArray jSONArray = new JSONArray(e);
                        for (int i = 0; i < jSONArray.length(); i++) {
                            hashSet.add(new C0556ra(jSONArray.getJSONObject(i)));
                        }
                    } catch (Throwable unused) {
                        hashSet = null;
                    }
                    b = b();
                    if (!CollectionUtils.areCollectionsEqual(hashSet, b)) {
                        K9 k9 = c0651v5.n;
                        int i2 = k9.k;
                        k9.m = i2;
                        k9.f532a.a(i2).b();
                    } else {
                        JSONArray jSONArray2 = new JSONArray();
                        Iterator it = b.iterator();
                        while (it.hasNext()) {
                            C0556ra c0556ra = (C0556ra) it.next();
                            c0556ra.getClass();
                            JSONObject put = new JSONObject().put("name", c0556ra.f1060a).put("required", c0556ra.c);
                            int i3 = c0556ra.b;
                            if (i3 != -1) {
                                put.put(NativeProtocol.PLATFORM_PROVIDER_VERSION_COLUMN, i3);
                            }
                            jSONArray2.put(put);
                        }
                        C0477o6 a2 = C0477o6.a(c0477o6, new JSONObject().put("features", jSONArray2).toString());
                        K9 k92 = c0651v5.n;
                        k92.a(a2, C0156bl.a(k92.c.b(a2), a2.i));
                        int i4 = k92.k;
                        k92.m = i4;
                        k92.f532a.a(i4).b();
                        c0537qf.i(jSONArray2.toString());
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
        AbstractC0532qa c0507pa;
        FeatureInfo[] featureInfoArr;
        try {
            C0651v5 c0651v5 = this.f1001a;
            SafePackageManager safePackageManager = this.b;
            Context context = c0651v5.f1115a;
            PackageInfo packageInfo = safePackageManager.getPackageInfo(context, context.getPackageName(), 16384);
            ArrayList arrayList = new ArrayList();
            if (AndroidUtils.isApiAchieved(24)) {
                c0507pa = new C0481oa();
            } else {
                c0507pa = new C0507pa();
            }
            if (packageInfo != null && (featureInfoArr = packageInfo.reqFeatures) != null) {
                for (FeatureInfo featureInfo : featureInfoArr) {
                    arrayList.add(c0507pa.a(featureInfo));
                }
            }
            return arrayList;
        } catch (Throwable unused) {
            return null;
        }
    }

    public C0563rh(C0651v5 c0651v5, SafePackageManager safePackageManager) {
        super(c0651v5);
        this.b = safePackageManager;
    }
}
