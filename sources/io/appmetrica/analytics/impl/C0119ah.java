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
/* renamed from: io.appmetrica.analytics.impl.ah  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0119ah extends Wg {
    public final SafePackageManager b;

    public C0119ah(C0210e5 c0210e5) {
        this(c0210e5, new SafePackageManager());
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x004d A[Catch: all -> 0x00d1, TryCatch #0 {all -> 0x00d1, blocks: (B:15:0x0043, B:17:0x004d, B:18:0x005d, B:19:0x0066, B:21:0x006c, B:23:0x008f, B:24:0x0095, B:25:0x0099), top: B:28:0x0043 }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x005d A[Catch: all -> 0x00d1, TryCatch #0 {all -> 0x00d1, blocks: (B:15:0x0043, B:17:0x004d, B:18:0x005d, B:19:0x0066, B:21:0x006c, B:23:0x008f, B:24:0x0095, B:25:0x0099), top: B:28:0x0043 }] */
    @Override // io.appmetrica.analytics.impl.Wg
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean a(W5 w5) {
        HashSet hashSet;
        ArrayList b;
        C0210e5 c0210e5 = this.f744a;
        if (c0210e5.t.c() && c0210e5.y()) {
            C0143bf c0143bf = c0210e5.c;
            String e = this.f744a.c.e();
            try {
                if (!TextUtils.isEmpty(e)) {
                    try {
                        hashSet = new HashSet();
                        JSONArray jSONArray = new JSONArray(e);
                        for (int i = 0; i < jSONArray.length(); i++) {
                            hashSet.add(new Y9(jSONArray.getJSONObject(i)));
                        }
                    } catch (Throwable unused) {
                        hashSet = null;
                    }
                    b = b();
                    if (!CollectionUtils.areCollectionsEqual(hashSet, b)) {
                        C0544r9 c0544r9 = c0210e5.n;
                        int i2 = c0544r9.k;
                        c0544r9.m = i2;
                        c0544r9.f1091a.a(i2).b();
                    } else {
                        JSONArray jSONArray2 = new JSONArray();
                        Iterator it = b.iterator();
                        while (it.hasNext()) {
                            Y9 y9 = (Y9) it.next();
                            y9.getClass();
                            JSONObject put = new JSONObject().put("name", y9.f769a).put("required", y9.c);
                            int i3 = y9.b;
                            if (i3 != -1) {
                                put.put(NativeProtocol.PLATFORM_PROVIDER_VERSION_COLUMN, i3);
                            }
                            jSONArray2.put(put);
                        }
                        W5 a2 = W5.a(w5, new JSONObject().put("features", jSONArray2).toString());
                        C0544r9 c0544r92 = c0210e5.n;
                        c0544r92.a(a2, Wk.a(c0544r92.c.b(a2), a2.i));
                        int i4 = c0544r92.k;
                        c0544r92.m = i4;
                        c0544r92.f1091a.a(i4).b();
                        c0143bf.i(jSONArray2.toString());
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
        X9 w9;
        FeatureInfo[] featureInfoArr;
        try {
            C0210e5 c0210e5 = this.f744a;
            SafePackageManager safePackageManager = this.b;
            Context context = c0210e5.f857a;
            PackageInfo packageInfo = safePackageManager.getPackageInfo(context, context.getPackageName(), 16384);
            ArrayList arrayList = new ArrayList();
            if (AndroidUtils.isApiAchieved(24)) {
                w9 = new V9();
            } else {
                w9 = new W9();
            }
            if (packageInfo != null && (featureInfoArr = packageInfo.reqFeatures) != null) {
                for (FeatureInfo featureInfo : featureInfoArr) {
                    arrayList.add(w9.a(featureInfo));
                }
            }
            return arrayList;
        } catch (Throwable unused) {
            return null;
        }
    }

    public C0119ah(C0210e5 c0210e5, SafePackageManager safePackageManager) {
        super(c0210e5);
        this.b = safePackageManager;
    }
}
