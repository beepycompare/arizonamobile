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
/* renamed from: io.appmetrica.analytics.impl.fd  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0244fd implements Uj {

    /* renamed from: a  reason: collision with root package name */
    public final InterfaceC0656vl f890a;
    public final String b;
    public final SystemTimeProvider c;
    public final List d;
    public final String e;
    public final long f;

    public C0244fd(InterfaceC0656vl interfaceC0656vl, String str, SystemTimeProvider systemTimeProvider, List<C0167cd> list) {
        this.f890a = interfaceC0656vl;
        this.b = str;
        this.c = systemTimeProvider;
        this.d = list;
        this.e = str.toUpperCase(Locale.ROOT) + "_STATUS";
        this.f = TimeUnit.DAYS.toMillis(1L);
    }

    public final Tj a() {
        C0623ud c0623ud;
        if (this.d.isEmpty()) {
            return null;
        }
        List sortedWith = CollectionsKt.sortedWith(this.d, new C0218ed());
        String c = ((AbstractC0748zd) this.f890a).c(this.e, (String) null);
        if (c != null) {
            try {
                JSONObject jSONObject = new JSONObject(c);
                JSONArray jSONArray = jSONObject.getJSONArray("modulesStatus");
                IntRange until = RangesKt.until(0, jSONArray.length());
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(until, 10));
                Iterator<Integer> it = until.iterator();
                while (it.hasNext()) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(((IntIterator) it).nextInt());
                    arrayList.add(new C0167cd(jSONObject2.getString("moduleName"), jSONObject2.getBoolean("loaded")));
                }
                c0623ud = new C0623ud(arrayList, jSONObject.getLong("lastSendTime"));
            } catch (Throwable unused) {
                c0623ud = new C0623ud(CollectionsKt.emptyList(), 0L);
            }
        } else {
            c0623ud = null;
        }
        long currentTimeMillis = this.c.currentTimeMillis();
        if (c0623ud == null || currentTimeMillis - c0623ud.b > this.f || !Intrinsics.areEqual(sortedWith, c0623ud.f1149a)) {
            C0623ud c0623ud2 = new C0623ud(sortedWith, currentTimeMillis);
            InterfaceC0656vl interfaceC0656vl = this.f890a;
            AbstractC0748zd abstractC0748zd = (AbstractC0748zd) interfaceC0656vl;
            InterfaceC0656vl interfaceC0656vl2 = (InterfaceC0656vl) abstractC0748zd.b(abstractC0748zd.f(this.e), c0623ud2.a());
            return new Tj(this.b + "_status", c0623ud2.a());
        }
        return null;
    }

    public /* synthetic */ C0244fd(InterfaceC0656vl interfaceC0656vl, String str, SystemTimeProvider systemTimeProvider, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(interfaceC0656vl, str, (i & 4) != 0 ? new SystemTimeProvider() : systemTimeProvider, list);
    }
}
