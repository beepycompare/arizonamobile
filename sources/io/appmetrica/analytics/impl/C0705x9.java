package io.appmetrica.analytics.impl;

import java.util.HashMap;
import java.util.LinkedList;
/* renamed from: io.appmetrica.analytics.impl.x9  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0705x9 extends Zf {

    /* renamed from: a  reason: collision with root package name */
    public final Ni f1148a;
    public final HashMap b;
    public final O4 c;

    public C0705x9(C0651v5 c0651v5) {
        Ni ni = new Ni(c0651v5);
        this.f1148a = ni;
        this.c = new O4(ni);
        this.b = a();
    }

    public final HashMap a() {
        HashMap hashMap = new HashMap();
        hashMap.put(Bb.EVENT_TYPE_ACTIVATION, new C0289h(this.f1148a));
        hashMap.put(Bb.EVENT_TYPE_START, new Nl(this.f1148a));
        hashMap.put(Bb.EVENT_TYPE_REGULAR, new C0178ch(this.f1148a));
        Ib ib = new Ib(this.f1148a);
        hashMap.put(Bb.EVENT_TYPE_EXCEPTION_USER_PROTOBUF, ib);
        hashMap.put(Bb.EVENT_TYPE_EXCEPTION_USER_CUSTOM_PROTOBUF, ib);
        hashMap.put(Bb.EVENT_TYPE_SEND_REFERRER, ib);
        hashMap.put(Bb.EVENT_TYPE_CUSTOM_EVENT, ib);
        Bb bb = Bb.EVENT_TYPE_SET_SESSION_EXTRA;
        Ni ni = this.f1148a;
        hashMap.put(bb, new Il(ni, ni.t));
        hashMap.put(Bb.EVENT_TYPE_APP_OPEN, new C0358jh(this.f1148a));
        hashMap.put(Bb.EVENT_TYPE_PURGE_BUFFER, new C0461ng(this.f1148a));
        hashMap.put(Bb.EVENT_TYPE_CURRENT_SESSION_NATIVE_CRASH_PROTOBUF, new R6(this.f1148a));
        hashMap.put(Bb.EVENT_TYPE_PREV_SESSION_NATIVE_CRASH_PROTOBUF, new Pf(this.f1148a));
        hashMap.put(Bb.EVENT_TYPE_EXCEPTION_UNHANDLED_FROM_FILE, new C0159bo(this.f1148a));
        hashMap.put(Bb.EVENT_TYPE_PREV_SESSION_EXCEPTION_UNHANDLED_FROM_FILE, new Qf(this.f1148a));
        hashMap.put(Bb.EVENT_TYPE_EXCEPTION_UNHANDLED_PROTOBUF, new C0133ao(this.f1148a));
        hashMap.put(Bb.EVENT_TYPE_ANR, ib);
        Bb bb2 = Bb.EVENT_TYPE_APP_ENVIRONMENT_UPDATED;
        Ni ni2 = this.f1148a;
        hashMap.put(bb2, new Il(ni2, ni2.e));
        Bb bb3 = Bb.EVENT_TYPE_APP_ENVIRONMENT_CLEARED;
        Ni ni3 = this.f1148a;
        hashMap.put(bb3, new Il(ni3, ni3.f));
        hashMap.put(Bb.EVENT_TYPE_SEND_USER_PROFILE, ib);
        Bb bb4 = Bb.EVENT_TYPE_SET_USER_PROFILE_ID;
        Ni ni4 = this.f1148a;
        hashMap.put(bb4, new Il(ni4, ni4.k));
        hashMap.put(Bb.EVENT_TYPE_SEND_REVENUE_EVENT, ib);
        hashMap.put(Bb.EVENT_TYPE_SEND_AD_REVENUE_EVENT, ib);
        hashMap.put(Bb.EVENT_TYPE_CLEANUP, ib);
        hashMap.put(Bb.EVENT_TYPE_SEND_ECOMMERCE_EVENT, ib);
        hashMap.put(Bb.EVENT_TYPE_WEBVIEW_SYNC, ib);
        hashMap.put(Bb.EVENT_CLIENT_EXTERNAL_ATTRIBUTION, new C0222ea(this.f1148a));
        return hashMap;
    }

    public final Ni b() {
        return this.f1148a;
    }

    public final void a(Bb bb, Oa oa) {
        this.b.put(bb, oa);
    }

    @Override // io.appmetrica.analytics.impl.Zf
    public final AbstractC0680w9 a(int i) {
        LinkedList linkedList = new LinkedList();
        Bb a2 = Bb.a(i);
        O4 o4 = this.c;
        if (o4 != null) {
            o4.a(a2, linkedList);
        }
        Oa oa = (Oa) this.b.get(a2);
        if (oa != null) {
            oa.a(linkedList);
        }
        return new C0655v9(linkedList);
    }

    public final Oa a(Bb bb) {
        return (Oa) this.b.get(bb);
    }
}
