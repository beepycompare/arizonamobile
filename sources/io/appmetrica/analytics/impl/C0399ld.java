package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.time.SystemTimeProvider;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import org.json.JSONArray;
import org.json.JSONObject;
/* renamed from: io.appmetrica.analytics.impl.ld  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0399ld implements Yj {

    /* renamed from: a  reason: collision with root package name */
    public final InterfaceC0731yl f990a;
    public final String b;
    public final SystemTimeProvider c;
    public final List d;
    public final String e;
    public final long f;

    public C0399ld(InterfaceC0731yl interfaceC0731yl, String str, SystemTimeProvider systemTimeProvider, List<C0322id> list) {
        this.f990a = interfaceC0731yl;
        this.b = str;
        this.c = systemTimeProvider;
        this.d = list;
        this.e = str.toUpperCase(Locale.ROOT) + "_STATUS";
        this.f = TimeUnit.DAYS.toMillis(1L);
    }

    public final Xj a() {
        Ad ad;
        if (this.d.isEmpty()) {
            return null;
        }
        List sortedWith = CollectionsKt.sortedWith(this.d, new C0373kd());
        String c = ((Fd) this.f990a).c(this.e, (String) null);
        if (c != null) {
            try {
                JSONObject jSONObject = new JSONObject(c);
                JSONArray jSONArray = jSONObject.getJSONArray("modulesStatus");
                IntRange until = RangesKt.until(0, jSONArray.length());
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(until, 10));
                Iterator<Integer> it = until.iterator();
                while (it.hasNext()) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(((IntIterator) it).nextInt());
                    arrayList.add(new C0322id(jSONObject2.getString("moduleName"), jSONObject2.getBoolean("loaded")));
                }
                ad = new Ad(arrayList, jSONObject.getLong("lastSendTime"));
            } catch (Throwable unused) {
                ad = new Ad(CollectionsKt.emptyList(), 0L);
            }
        } else {
            ad = null;
        }
        long currentTimeMillis = this.c.currentTimeMillis();
        if (ad == null || currentTimeMillis - ad.b > this.f || !Intrinsics.areEqual(sortedWith, ad.f396a)) {
            Ad ad2 = new Ad(sortedWith, currentTimeMillis);
            InterfaceC0731yl interfaceC0731yl = this.f990a;
            Fd fd = (Fd) interfaceC0731yl;
            InterfaceC0731yl interfaceC0731yl2 = (InterfaceC0731yl) fd.b(fd.f(this.e), ad2.a());
            return new Xj(this.b + "_status", ad2.a());
        }
        return null;
    }

    public /* synthetic */ C0399ld(InterfaceC0731yl interfaceC0731yl, String str, SystemTimeProvider systemTimeProvider, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(interfaceC0731yl, str, (i & 4) != 0 ? new SystemTimeProvider() : systemTimeProvider, list);
    }
}
