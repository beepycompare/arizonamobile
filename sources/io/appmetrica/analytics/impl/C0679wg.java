package io.appmetrica.analytics.impl;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.adjust.sdk.Constants;
import io.appmetrica.analytics.coreutils.internal.services.SafePackageManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.math.MathKt;
import org.json.JSONArray;
import org.json.JSONObject;
/* renamed from: io.appmetrica.analytics.impl.wg  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0679wg {

    /* renamed from: a  reason: collision with root package name */
    public final Context f1287a;
    public final SafePackageManager b;
    public final Ra c;
    public final Dc d;
    public final long e;
    public final String f;
    public final String g;

    public C0679wg(Context context, SafePackageManager safePackageManager, Ra ra) {
        this.f1287a = context;
        this.b = safePackageManager;
        this.c = ra;
        Dc dc = new Dc(0);
        dc.a(EnumC0430mg.d, 1);
        dc.a(EnumC0430mg.c, 2);
        this.d = dc;
        this.e = TimeUnit.DAYS.toSeconds(1L);
        this.f = "com.android.vending";
        this.g = "com.huawei.appmarket";
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x008f, code lost:
        if (((java.lang.Number) r5.component2()).longValue() < r13.e) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final C0455ng a(List list) {
        C0455ng c0455ng;
        if (list.isEmpty()) {
            return null;
        }
        if (list.size() == 1) {
            return (C0455ng) list.get(0);
        }
        SafePackageManager safePackageManager = this.b;
        Context context = this.f1287a;
        PackageInfo packageInfo = safePackageManager.getPackageInfo(context, context.getPackageName(), 0);
        if (packageInfo != null) {
            long seconds = TimeUnit.MILLISECONDS.toSeconds(packageInfo.firstInstallTime);
            Iterator it = list.iterator();
            if (it.hasNext()) {
                C0455ng c0455ng2 = (C0455ng) it.next();
                Pair pair = TuplesKt.to(c0455ng2, Long.valueOf(Math.abs(c0455ng2.c - seconds)));
                while (it.hasNext()) {
                    C0455ng c0455ng3 = (C0455ng) it.next();
                    Pair pair2 = TuplesKt.to(c0455ng3, Long.valueOf(Math.abs(c0455ng3.c - seconds)));
                    if (ComparisonsKt.compareValues((Comparable) pair.getSecond(), (Comparable) pair2.getSecond()) > 0) {
                        pair = pair2;
                    }
                }
                c0455ng = (C0455ng) pair.component1();
            } else {
                throw new NoSuchElementException();
            }
        }
        c0455ng = null;
        if (c0455ng == null) {
            Comparator comparator = new Comparator() { // from class: io.appmetrica.analytics.impl.wg$$ExternalSyntheticLambda0
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return C0679wg.a(C0679wg.this, (C0455ng) obj, (C0455ng) obj2);
                }
            };
            Iterator it2 = list.iterator();
            if (!it2.hasNext()) {
                throw new NoSuchElementException();
            }
            C0455ng c0455ng4 = (C0455ng) it2.next();
            while (it2.hasNext()) {
                C0455ng c0455ng5 = (C0455ng) it2.next();
                if (comparator.compare(c0455ng4, c0455ng5) < 0) {
                    c0455ng4 = c0455ng5;
                }
            }
            c0455ng = c0455ng4;
        }
        Ra ra = this.c;
        JSONObject jSONObject = new JSONObject();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator it3 = list.iterator();
        while (it3.hasNext()) {
            C0455ng c0455ng6 = (C0455ng) it3.next();
            arrayList.add(new JSONObject().put(Constants.REFERRER, c0455ng6.f1137a).put("install_timestamp_seconds", c0455ng6.c).put("click_timestamp_seconds", c0455ng6.b).put("source", c0455ng6.d.f1118a));
        }
        ra.reportEvent("several_filled_referrers", jSONObject.put("candidates", lo.a((Collection) arrayList) ? null : new JSONArray((Collection) arrayList)).put("chosen", new JSONObject().put(Constants.REFERRER, c0455ng.f1137a).put("install_timestamp_seconds", c0455ng.c).put("click_timestamp_seconds", c0455ng.b).put("source", c0455ng.d.f1118a)).putOpt("install_time", packageInfo != null ? Long.valueOf(packageInfo.firstInstallTime) : null).toString());
        return c0455ng;
    }

    public /* synthetic */ C0679wg(Context context) {
        this(context, new SafePackageManager(), AbstractC0689x1.a());
    }

    public static final int a(C0679wg c0679wg, C0455ng c0455ng, C0455ng c0455ng2) {
        int sign = MathKt.getSign(c0455ng.c - c0455ng2.c);
        return sign == 0 ? ((Number) c0679wg.d.a(c0455ng.d)).intValue() - ((Number) c0679wg.d.a(c0455ng2.d)).intValue() : sign;
    }
}
