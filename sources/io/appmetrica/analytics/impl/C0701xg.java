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
/* renamed from: io.appmetrica.analytics.impl.xg  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0701xg {

    /* renamed from: a  reason: collision with root package name */
    public final Context f1200a;
    public final SafePackageManager b;
    public final Sa c;
    public final Ec d;
    public final long e;
    public final String f;
    public final String g;

    public C0701xg(Context context, SafePackageManager safePackageManager, Sa sa) {
        this.f1200a = context;
        this.b = safePackageManager;
        this.c = sa;
        Ec ec = new Ec(0);
        ec.a(EnumC0452ng.d, 1);
        ec.a(EnumC0452ng.c, 2);
        this.d = ec;
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
    public final C0477og a(List list) {
        C0477og c0477og;
        if (list.isEmpty()) {
            return null;
        }
        if (list.size() == 1) {
            return (C0477og) list.get(0);
        }
        SafePackageManager safePackageManager = this.b;
        Context context = this.f1200a;
        PackageInfo packageInfo = safePackageManager.getPackageInfo(context, context.getPackageName(), 0);
        if (packageInfo != null) {
            long seconds = TimeUnit.MILLISECONDS.toSeconds(packageInfo.firstInstallTime);
            Iterator it = list.iterator();
            if (it.hasNext()) {
                C0477og c0477og2 = (C0477og) it.next();
                Pair pair = TuplesKt.to(c0477og2, Long.valueOf(Math.abs(c0477og2.c - seconds)));
                while (it.hasNext()) {
                    C0477og c0477og3 = (C0477og) it.next();
                    Pair pair2 = TuplesKt.to(c0477og3, Long.valueOf(Math.abs(c0477og3.c - seconds)));
                    if (ComparisonsKt.compareValues((Comparable) pair.getSecond(), (Comparable) pair2.getSecond()) > 0) {
                        pair = pair2;
                    }
                }
                c0477og = (C0477og) pair.component1();
            } else {
                throw new NoSuchElementException();
            }
        }
        c0477og = null;
        if (c0477og == null) {
            Comparator comparator = new Comparator() { // from class: io.appmetrica.analytics.impl.xg$$ExternalSyntheticLambda0
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return C0701xg.a(C0701xg.this, (C0477og) obj, (C0477og) obj2);
                }
            };
            Iterator it2 = list.iterator();
            if (!it2.hasNext()) {
                throw new NoSuchElementException();
            }
            C0477og c0477og4 = (C0477og) it2.next();
            while (it2.hasNext()) {
                C0477og c0477og5 = (C0477og) it2.next();
                if (comparator.compare(c0477og4, c0477og5) < 0) {
                    c0477og4 = c0477og5;
                }
            }
            c0477og = c0477og4;
        }
        Sa sa = this.c;
        JSONObject jSONObject = new JSONObject();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator it3 = list.iterator();
        while (it3.hasNext()) {
            C0477og c0477og6 = (C0477og) it3.next();
            arrayList.add(new JSONObject().put(Constants.REFERRER, c0477og6.f1050a).put("install_timestamp_seconds", c0477og6.c).put("click_timestamp_seconds", c0477og6.b).put("source", c0477og6.d.f1031a));
        }
        sa.reportEvent("several_filled_referrers", jSONObject.put("candidates", mo.a((Collection) arrayList) ? null : new JSONArray((Collection) arrayList)).put("chosen", new JSONObject().put(Constants.REFERRER, c0477og.f1050a).put("install_timestamp_seconds", c0477og.c).put("click_timestamp_seconds", c0477og.b).put("source", c0477og.d.f1031a)).putOpt("install_time", packageInfo != null ? Long.valueOf(packageInfo.firstInstallTime) : null).toString());
        return c0477og;
    }

    public /* synthetic */ C0701xg(Context context) {
        this(context, new SafePackageManager(), AbstractC0711y1.a());
    }

    public static final int a(C0701xg c0701xg, C0477og c0477og, C0477og c0477og2) {
        int sign = MathKt.getSign(c0477og.c - c0477og2.c);
        return sign == 0 ? ((Number) c0701xg.d.a(c0477og.d)).intValue() - ((Number) c0701xg.d.a(c0477og2.d)).intValue() : sign;
    }
}
