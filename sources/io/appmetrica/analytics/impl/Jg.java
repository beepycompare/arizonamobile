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
public final class Jg {

    /* renamed from: a  reason: collision with root package name */
    public final Context f507a;
    public final SafePackageManager b;
    public final InterfaceC0431mb c;
    public final Yc d;
    public final long e;
    public final String f;
    public final String g;

    public Jg(Context context, SafePackageManager safePackageManager, InterfaceC0431mb interfaceC0431mb) {
        this.f507a = context;
        this.b = safePackageManager;
        this.c = interfaceC0431mb;
        Yc yc = new Yc(0);
        yc.a(EnumC0760zg.d, 1);
        yc.a(EnumC0760zg.c, 2);
        this.d = yc;
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
    public final Ag a(List list) {
        Ag ag;
        if (list.isEmpty()) {
            return null;
        }
        if (list.size() == 1) {
            return (Ag) list.get(0);
        }
        SafePackageManager safePackageManager = this.b;
        Context context = this.f507a;
        PackageInfo packageInfo = safePackageManager.getPackageInfo(context, context.getPackageName(), 0);
        if (packageInfo != null) {
            long seconds = TimeUnit.MILLISECONDS.toSeconds(packageInfo.firstInstallTime);
            Iterator it = list.iterator();
            if (it.hasNext()) {
                Ag ag2 = (Ag) it.next();
                Pair pair = TuplesKt.to(ag2, Long.valueOf(Math.abs(ag2.c - seconds)));
                while (it.hasNext()) {
                    Ag ag3 = (Ag) it.next();
                    Pair pair2 = TuplesKt.to(ag3, Long.valueOf(Math.abs(ag3.c - seconds)));
                    if (ComparisonsKt.compareValues((Comparable) pair.getSecond(), (Comparable) pair2.getSecond()) > 0) {
                        pair = pair2;
                    }
                }
                ag = (Ag) pair.component1();
            } else {
                throw new NoSuchElementException();
            }
        }
        ag = null;
        if (ag == null) {
            Comparator comparator = new Comparator() { // from class: io.appmetrica.analytics.impl.Jg$$ExternalSyntheticLambda0
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return Jg.a(Jg.this, (Ag) obj, (Ag) obj2);
                }
            };
            Iterator it2 = list.iterator();
            if (!it2.hasNext()) {
                throw new NoSuchElementException();
            }
            Ag ag4 = (Ag) it2.next();
            while (it2.hasNext()) {
                Ag ag5 = (Ag) it2.next();
                if (comparator.compare(ag4, ag5) < 0) {
                    ag4 = ag5;
                }
            }
            ag = ag4;
        }
        InterfaceC0431mb interfaceC0431mb = this.c;
        JSONObject jSONObject = new JSONObject();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator it3 = list.iterator();
        while (it3.hasNext()) {
            Ag ag6 = (Ag) it3.next();
            arrayList.add(new JSONObject().put(Constants.REFERRER, ag6.f339a).put("install_timestamp_seconds", ag6.c).put("click_timestamp_seconds", ag6.b).put("source", ag6.d.f1172a));
        }
        interfaceC0431mb.reportEvent("several_filled_referrers", jSONObject.put("candidates", io.a((Collection) arrayList) ? null : new JSONArray((Collection) arrayList)).put("chosen", new JSONObject().put(Constants.REFERRER, ag.f339a).put("install_timestamp_seconds", ag.c).put("click_timestamp_seconds", ag.b).put("source", ag.d.f1172a)).putOpt("install_time", packageInfo != null ? Long.valueOf(packageInfo.firstInstallTime) : null).toString());
        return ag;
    }

    public /* synthetic */ Jg(Context context) {
        this(context, new SafePackageManager(), AbstractC0595t1.a());
    }

    public static final int a(Jg jg, Ag ag, Ag ag2) {
        int sign = MathKt.getSign(ag.c - ag2.c);
        return sign == 0 ? ((Number) jg.d.a(ag.d)).intValue() - ((Number) jg.d.a(ag2.d)).intValue() : sign;
    }
}
