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
/* loaded from: classes4.dex */
public final class Og {

    /* renamed from: a  reason: collision with root package name */
    public final Context f590a;
    public final SafePackageManager b;
    public final InterfaceC0479ob c;
    public final C0122ad d;
    public final long e;
    public final String f;
    public final String g;

    public Og(Context context, SafePackageManager safePackageManager, InterfaceC0479ob interfaceC0479ob) {
        this.f590a = context;
        this.b = safePackageManager;
        this.c = interfaceC0479ob;
        C0122ad c0122ad = new C0122ad(0);
        c0122ad.a(Eg.d, 1);
        c0122ad.a(Eg.c, 2);
        this.d = c0122ad;
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
    public final Fg a(List list) {
        Fg fg;
        if (list.isEmpty()) {
            return null;
        }
        if (list.size() == 1) {
            return (Fg) list.get(0);
        }
        SafePackageManager safePackageManager = this.b;
        Context context = this.f590a;
        PackageInfo packageInfo = safePackageManager.getPackageInfo(context, context.getPackageName(), 0);
        if (packageInfo != null) {
            long seconds = TimeUnit.MILLISECONDS.toSeconds(packageInfo.firstInstallTime);
            Iterator it = list.iterator();
            if (it.hasNext()) {
                Fg fg2 = (Fg) it.next();
                Pair pair = TuplesKt.to(fg2, Long.valueOf(Math.abs(fg2.c - seconds)));
                while (it.hasNext()) {
                    Fg fg3 = (Fg) it.next();
                    Pair pair2 = TuplesKt.to(fg3, Long.valueOf(Math.abs(fg3.c - seconds)));
                    if (ComparisonsKt.compareValues((Comparable) pair.getSecond(), (Comparable) pair2.getSecond()) > 0) {
                        pair = pair2;
                    }
                }
                fg = (Fg) pair.component1();
            } else {
                throw new NoSuchElementException();
            }
        }
        fg = null;
        if (fg == null) {
            Comparator comparator = new Comparator() { // from class: io.appmetrica.analytics.impl.Og$$ExternalSyntheticLambda0
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return Og.a(Og.this, (Fg) obj, (Fg) obj2);
                }
            };
            Iterator it2 = list.iterator();
            if (!it2.hasNext()) {
                throw new NoSuchElementException();
            }
            Fg fg4 = (Fg) it2.next();
            while (it2.hasNext()) {
                Fg fg5 = (Fg) it2.next();
                if (comparator.compare(fg4, fg5) < 0) {
                    fg4 = fg5;
                }
            }
            fg = fg4;
        }
        InterfaceC0479ob interfaceC0479ob = this.c;
        JSONObject jSONObject = new JSONObject();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator it3 = list.iterator();
        while (it3.hasNext()) {
            Fg fg6 = (Fg) it3.next();
            arrayList.add(new JSONObject().put(Constants.REFERRER, fg6.f436a).put("install_timestamp_seconds", fg6.c).put("click_timestamp_seconds", fg6.b).put("source", fg6.d.f415a));
        }
        interfaceC0479ob.reportEvent("several_filled_referrers", jSONObject.put("candidates", no.a((Collection) arrayList) ? null : new JSONArray((Collection) arrayList)).put("chosen", new JSONObject().put(Constants.REFERRER, fg.f436a).put("install_timestamp_seconds", fg.c).put("click_timestamp_seconds", fg.b).put("source", fg.d.f415a)).putOpt("install_time", packageInfo != null ? Long.valueOf(packageInfo.firstInstallTime) : null).toString());
        return fg;
    }

    public /* synthetic */ Og(Context context) {
        this(context, new SafePackageManager(), AbstractC0593t1.a());
    }

    public static final int a(Og og, Fg fg, Fg fg2) {
        int sign = MathKt.getSign(fg.c - fg2.c);
        return sign == 0 ? ((Number) og.d.a(fg.d)).intValue() - ((Number) og.d.a(fg2.d)).intValue() : sign;
    }
}
