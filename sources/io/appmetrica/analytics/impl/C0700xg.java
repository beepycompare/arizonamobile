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
public final class C0700xg {

    /* renamed from: a  reason: collision with root package name */
    public final Context f1283a;
    public final SafePackageManager b;
    public final Sa c;
    public final Ec d;
    public final long e;
    public final String f;
    public final String g;

    public C0700xg(Context context, SafePackageManager safePackageManager, Sa sa) {
        this.f1283a = context;
        this.b = safePackageManager;
        this.c = sa;
        Ec ec = new Ec(0);
        ec.a(EnumC0451ng.d, 1);
        ec.a(EnumC0451ng.c, 2);
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
    public final C0476og a(List list) {
        C0476og c0476og;
        if (list.isEmpty()) {
            return null;
        }
        if (list.size() == 1) {
            return (C0476og) list.get(0);
        }
        SafePackageManager safePackageManager = this.b;
        Context context = this.f1283a;
        PackageInfo packageInfo = safePackageManager.getPackageInfo(context, context.getPackageName(), 0);
        if (packageInfo != null) {
            long seconds = TimeUnit.MILLISECONDS.toSeconds(packageInfo.firstInstallTime);
            Iterator it = list.iterator();
            if (it.hasNext()) {
                C0476og c0476og2 = (C0476og) it.next();
                Pair pair = TuplesKt.to(c0476og2, Long.valueOf(Math.abs(c0476og2.c - seconds)));
                while (it.hasNext()) {
                    C0476og c0476og3 = (C0476og) it.next();
                    Pair pair2 = TuplesKt.to(c0476og3, Long.valueOf(Math.abs(c0476og3.c - seconds)));
                    if (ComparisonsKt.compareValues((Comparable) pair.getSecond(), (Comparable) pair2.getSecond()) > 0) {
                        pair = pair2;
                    }
                }
                c0476og = (C0476og) pair.component1();
            } else {
                throw new NoSuchElementException();
            }
        }
        c0476og = null;
        if (c0476og == null) {
            Comparator comparator = new Comparator() { // from class: io.appmetrica.analytics.impl.xg$$ExternalSyntheticLambda0
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return C0700xg.a(C0700xg.this, (C0476og) obj, (C0476og) obj2);
                }
            };
            Iterator it2 = list.iterator();
            if (!it2.hasNext()) {
                throw new NoSuchElementException();
            }
            C0476og c0476og4 = (C0476og) it2.next();
            while (it2.hasNext()) {
                C0476og c0476og5 = (C0476og) it2.next();
                if (comparator.compare(c0476og4, c0476og5) < 0) {
                    c0476og4 = c0476og5;
                }
            }
            c0476og = c0476og4;
        }
        Sa sa = this.c;
        JSONObject jSONObject = new JSONObject();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator it3 = list.iterator();
        while (it3.hasNext()) {
            C0476og c0476og6 = (C0476og) it3.next();
            arrayList.add(new JSONObject().put(Constants.REFERRER, c0476og6.f1133a).put("install_timestamp_seconds", c0476og6.c).put("click_timestamp_seconds", c0476og6.b).put("source", c0476og6.d.f1114a));
        }
        sa.reportEvent("several_filled_referrers", jSONObject.put("candidates", mo.a((Collection) arrayList) ? null : new JSONArray((Collection) arrayList)).put("chosen", new JSONObject().put(Constants.REFERRER, c0476og.f1133a).put("install_timestamp_seconds", c0476og.c).put("click_timestamp_seconds", c0476og.b).put("source", c0476og.d.f1114a)).putOpt("install_time", packageInfo != null ? Long.valueOf(packageInfo.firstInstallTime) : null).toString());
        return c0476og;
    }

    public /* synthetic */ C0700xg(Context context) {
        this(context, new SafePackageManager(), AbstractC0710y1.a());
    }

    public static final int a(C0700xg c0700xg, C0476og c0476og, C0476og c0476og2) {
        int sign = MathKt.getSign(c0476og.c - c0476og2.c);
        return sign == 0 ? ((Number) c0700xg.d.a(c0476og.d)).intValue() - ((Number) c0700xg.d.a(c0476og2.d)).intValue() : sign;
    }
}
