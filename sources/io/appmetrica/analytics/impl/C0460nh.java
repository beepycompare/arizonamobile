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
/* renamed from: io.appmetrica.analytics.impl.nh  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0460nh extends AbstractC0358jh {
    public final SafePackageManager b;

    public C0460nh(C0572s5 c0572s5) {
        this(c0572s5, new SafePackageManager());
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x004d A[Catch: all -> 0x00d0, TryCatch #0 {all -> 0x00d0, blocks: (B:15:0x0043, B:17:0x004d, B:18:0x005d, B:19:0x0066, B:21:0x006c, B:23:0x008f, B:24:0x0094, B:25:0x0098), top: B:28:0x0043 }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x005d A[Catch: all -> 0x00d0, TryCatch #0 {all -> 0x00d0, blocks: (B:15:0x0043, B:17:0x004d, B:18:0x005d, B:19:0x0066, B:21:0x006c, B:23:0x008f, B:24:0x0094, B:25:0x0098), top: B:28:0x0043 }] */
    @Override // io.appmetrica.analytics.impl.AbstractC0358jh
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean a(C0399l6 c0399l6) {
        HashSet hashSet;
        ArrayList b;
        C0572s5 c0572s5 = this.f925a;
        if (c0572s5.t.c() && c0572s5.x()) {
            C0433mf c0433mf = c0572s5.c;
            String e = this.f925a.c.e();
            try {
                if (!TextUtils.isEmpty(e)) {
                    try {
                        hashSet = new HashSet();
                        JSONArray jSONArray = new JSONArray(e);
                        for (int i = 0; i < jSONArray.length(); i++) {
                            hashSet.add(new C0478oa(jSONArray.getJSONObject(i)));
                        }
                    } catch (Throwable unused) {
                        hashSet = null;
                    }
                    b = b();
                    if (!CollectionUtils.areCollectionsEqual(hashSet, b)) {
                        H9 h9 = c0572s5.n;
                        int i2 = h9.k;
                        h9.m = i2;
                        h9.f474a.a(i2).b();
                    } else {
                        JSONArray jSONArray2 = new JSONArray();
                        Iterator it = b.iterator();
                        while (it.hasNext()) {
                            C0478oa c0478oa = (C0478oa) it.next();
                            c0478oa.getClass();
                            JSONObject put = new JSONObject().put("name", c0478oa.f998a).put("required", c0478oa.c);
                            int i3 = c0478oa.b;
                            if (i3 != -1) {
                                put.put(NativeProtocol.PLATFORM_PROVIDER_VERSION_COLUMN, i3);
                            }
                            jSONArray2.put(put);
                        }
                        C0399l6 a2 = C0399l6.a(c0399l6, new JSONObject().put("features", jSONArray2).toString());
                        H9 h92 = c0572s5.n;
                        h92.a(a2, Xk.a(h92.c.b(a2), a2.i));
                        int i4 = h92.k;
                        h92.m = i4;
                        h92.f474a.a(i4).b();
                        c0433mf.i(jSONArray2.toString());
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
        AbstractC0453na c0428ma;
        FeatureInfo[] featureInfoArr;
        try {
            C0572s5 c0572s5 = this.f925a;
            SafePackageManager safePackageManager = this.b;
            Context context = c0572s5.f1054a;
            PackageInfo packageInfo = safePackageManager.getPackageInfo(context, context.getPackageName(), 16384);
            ArrayList arrayList = new ArrayList();
            if (AndroidUtils.isApiAchieved(24)) {
                c0428ma = new C0403la();
            } else {
                c0428ma = new C0428ma();
            }
            if (packageInfo != null && (featureInfoArr = packageInfo.reqFeatures) != null) {
                for (FeatureInfo featureInfo : featureInfoArr) {
                    arrayList.add(c0428ma.a(featureInfo));
                }
            }
            return arrayList;
        } catch (Throwable unused) {
            return null;
        }
    }

    public C0460nh(C0572s5 c0572s5, SafePackageManager safePackageManager) {
        super(c0572s5);
        this.b = safePackageManager;
    }
}
