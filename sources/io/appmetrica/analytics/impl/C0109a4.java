package io.appmetrica.analytics.impl;

import android.content.Context;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
/* renamed from: io.appmetrica.analytics.impl.a4  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0109a4 {

    /* renamed from: a  reason: collision with root package name */
    public final Object f902a;
    public final C0188d5 b;
    public final HashMap c;
    public final C0498pa d;
    public final Context e;
    public final C0316i4 f;

    public C0109a4(Context context, C0188d5 c0188d5) {
        this(context, c0188d5, new C0316i4());
    }

    public final InterfaceC0238f4 a(P3 p3, C0492p4 c0492p4) {
        InterfaceC0238f4 interfaceC0238f4;
        synchronized (this.f902a) {
            interfaceC0238f4 = (InterfaceC0238f4) this.c.get(p3);
            if (interfaceC0238f4 == null) {
                this.f.getClass();
                interfaceC0238f4 = C0316i4.a(p3).a(this.e, this.b, p3, c0492p4);
                this.c.put(p3, interfaceC0238f4);
                this.d.a(new Z3(p3.b, p3.c, p3.d), p3);
            }
        }
        return interfaceC0238f4;
    }

    public C0109a4(Context context, C0188d5 c0188d5, C0316i4 c0316i4) {
        this.f902a = new Object();
        this.c = new HashMap();
        this.d = new C0498pa();
        this.e = context.getApplicationContext();
        this.b = c0188d5;
        this.f = c0316i4;
    }

    public final void a(String str, Integer num, String str2) {
        synchronized (this.f902a) {
            C0498pa c0498pa = this.d;
            Collection<P3> collection = (Collection) c0498pa.f1177a.remove(new Z3(str, num, str2));
            if (!lo.a(collection)) {
                collection.size();
                ArrayList arrayList = new ArrayList(collection.size());
                for (P3 p3 : collection) {
                    arrayList.add((InterfaceC0238f4) this.c.remove(p3));
                }
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((InterfaceC0238f4) it.next()).a();
                }
            }
        }
    }
}
