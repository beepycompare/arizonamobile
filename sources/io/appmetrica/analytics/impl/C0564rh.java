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
public final class C0564rh extends AbstractC0463nh {
    public final SafePackageManager b;

    public C0564rh(C0652v5 c0652v5) {
        this(c0652v5, new SafePackageManager());
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x004d A[Catch: all -> 0x00d0, TryCatch #0 {all -> 0x00d0, blocks: (B:15:0x0043, B:17:0x004d, B:18:0x005d, B:19:0x0066, B:21:0x006c, B:23:0x008f, B:24:0x0094, B:25:0x0098), top: B:28:0x0043 }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x005d A[Catch: all -> 0x00d0, TryCatch #0 {all -> 0x00d0, blocks: (B:15:0x0043, B:17:0x004d, B:18:0x005d, B:19:0x0066, B:21:0x006c, B:23:0x008f, B:24:0x0094, B:25:0x0098), top: B:28:0x0043 }] */
    @Override // io.appmetrica.analytics.impl.AbstractC0463nh
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean a(C0478o6 c0478o6) {
        HashSet hashSet;
        ArrayList b;
        C0652v5 c0652v5 = this.f1006a;
        if (c0652v5.t.c() && c0652v5.y()) {
            C0538qf c0538qf = c0652v5.c;
            String e = this.f1006a.c.e();
            try {
                if (!TextUtils.isEmpty(e)) {
                    try {
                        hashSet = new HashSet();
                        JSONArray jSONArray = new JSONArray(e);
                        for (int i = 0; i < jSONArray.length(); i++) {
                            hashSet.add(new C0557ra(jSONArray.getJSONObject(i)));
                        }
                    } catch (Throwable unused) {
                        hashSet = null;
                    }
                    b = b();
                    if (!CollectionUtils.areCollectionsEqual(hashSet, b)) {
                        K9 k9 = c0652v5.n;
                        int i2 = k9.k;
                        k9.m = i2;
                        k9.f537a.a(i2).b();
                    } else {
                        JSONArray jSONArray2 = new JSONArray();
                        Iterator it = b.iterator();
                        while (it.hasNext()) {
                            C0557ra c0557ra = (C0557ra) it.next();
                            c0557ra.getClass();
                            JSONObject put = new JSONObject().put("name", c0557ra.f1065a).put("required", c0557ra.c);
                            int i3 = c0557ra.b;
                            if (i3 != -1) {
                                put.put(NativeProtocol.PLATFORM_PROVIDER_VERSION_COLUMN, i3);
                            }
                            jSONArray2.put(put);
                        }
                        C0478o6 a2 = C0478o6.a(c0478o6, new JSONObject().put("features", jSONArray2).toString());
                        K9 k92 = c0652v5.n;
                        k92.a(a2, C0157bl.a(k92.c.b(a2), a2.i));
                        int i4 = k92.k;
                        k92.m = i4;
                        k92.f537a.a(i4).b();
                        c0538qf.i(jSONArray2.toString());
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
        AbstractC0533qa c0508pa;
        FeatureInfo[] featureInfoArr;
        try {
            C0652v5 c0652v5 = this.f1006a;
            SafePackageManager safePackageManager = this.b;
            Context context = c0652v5.f1120a;
            PackageInfo packageInfo = safePackageManager.getPackageInfo(context, context.getPackageName(), 16384);
            ArrayList arrayList = new ArrayList();
            if (AndroidUtils.isApiAchieved(24)) {
                c0508pa = new C0482oa();
            } else {
                c0508pa = new C0508pa();
            }
            if (packageInfo != null && (featureInfoArr = packageInfo.reqFeatures) != null) {
                for (FeatureInfo featureInfo : featureInfoArr) {
                    arrayList.add(c0508pa.a(featureInfo));
                }
            }
            return arrayList;
        } catch (Throwable unused) {
            return null;
        }
    }

    public C0564rh(C0652v5 c0652v5, SafePackageManager safePackageManager) {
        super(c0652v5);
        this.b = safePackageManager;
    }
}
