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
/* renamed from: io.appmetrica.analytics.impl.ed  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0221ed implements Tj {

    /* renamed from: a  reason: collision with root package name */
    public final InterfaceC0633ul f982a;
    public final String b;
    public final SystemTimeProvider c;
    public final List d;
    public final String e;
    public final long f;

    public C0221ed(InterfaceC0633ul interfaceC0633ul, String str, SystemTimeProvider systemTimeProvider, List<C0144bd> list) {
        this.f982a = interfaceC0633ul;
        this.b = str;
        this.c = systemTimeProvider;
        this.d = list;
        this.e = str.toUpperCase(Locale.ROOT) + "_STATUS";
        this.f = TimeUnit.DAYS.toMillis(1L);
    }

    public final Sj a() {
        C0600td c0600td;
        if (this.d.isEmpty()) {
            return null;
        }
        List sortedWith = CollectionsKt.sortedWith(this.d, new C0196dd());
        String c = ((AbstractC0725yd) this.f982a).c(this.e, (String) null);
        if (c != null) {
            try {
                JSONObject jSONObject = new JSONObject(c);
                JSONArray jSONArray = jSONObject.getJSONArray("modulesStatus");
                IntRange until = RangesKt.until(0, jSONArray.length());
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(until, 10));
                Iterator<Integer> it = until.iterator();
                while (it.hasNext()) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(((IntIterator) it).nextInt());
                    arrayList.add(new C0144bd(jSONObject2.getString("moduleName"), jSONObject2.getBoolean("loaded")));
                }
                c0600td = new C0600td(arrayList, jSONObject.getLong("lastSendTime"));
            } catch (Throwable unused) {
                c0600td = new C0600td(CollectionsKt.emptyList(), 0L);
            }
        } else {
            c0600td = null;
        }
        long currentTimeMillis = this.c.currentTimeMillis();
        if (c0600td == null || currentTimeMillis - c0600td.b > this.f || !Intrinsics.areEqual(sortedWith, c0600td.f1241a)) {
            C0600td c0600td2 = new C0600td(sortedWith, currentTimeMillis);
            InterfaceC0633ul interfaceC0633ul = this.f982a;
            AbstractC0725yd abstractC0725yd = (AbstractC0725yd) interfaceC0633ul;
            InterfaceC0633ul interfaceC0633ul2 = (InterfaceC0633ul) abstractC0725yd.b(abstractC0725yd.f(this.e), c0600td2.a());
            return new Sj(this.b + "_status", c0600td2.a());
        }
        return null;
    }

    public /* synthetic */ C0221ed(InterfaceC0633ul interfaceC0633ul, String str, SystemTimeProvider systemTimeProvider, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(interfaceC0633ul, str, (i & 4) != 0 ? new SystemTimeProvider() : systemTimeProvider, list);
    }
}
