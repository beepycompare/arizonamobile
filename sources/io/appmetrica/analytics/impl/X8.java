package io.appmetrica.analytics.impl;

import java.util.HashMap;
import java.util.LinkedList;
/* loaded from: classes5.dex */
public final class X8 extends Ff {

    /* renamed from: a  reason: collision with root package name */
    public final C0555ri f850a;
    public final HashMap b;
    public final C0517q4 c;

    public X8(X4 x4) {
        C0555ri c0555ri = new C0555ri(x4);
        this.f850a = c0555ri;
        this.c = new C0517q4(c0555ri);
        this.b = a();
    }

    public final HashMap a() {
        HashMap hashMap = new HashMap();
        hashMap.put(EnumC0142bb.EVENT_TYPE_ACTIVATION, new C0285h(this.f850a));
        hashMap.put(EnumC0142bb.EVENT_TYPE_START, new El(this.f850a));
        hashMap.put(EnumC0142bb.EVENT_TYPE_REGULAR, new Gg(this.f850a));
        C0323ib c0323ib = new C0323ib(this.f850a);
        hashMap.put(EnumC0142bb.EVENT_TYPE_EXCEPTION_USER_PROTOBUF, c0323ib);
        hashMap.put(EnumC0142bb.EVENT_TYPE_EXCEPTION_USER_CUSTOM_PROTOBUF, c0323ib);
        hashMap.put(EnumC0142bb.EVENT_TYPE_SEND_REFERRER, c0323ib);
        hashMap.put(EnumC0142bb.EVENT_TYPE_CUSTOM_EVENT, c0323ib);
        EnumC0142bb enumC0142bb = EnumC0142bb.EVENT_TYPE_SET_SESSION_EXTRA;
        C0555ri c0555ri = this.f850a;
        hashMap.put(enumC0142bb, new C0758zl(c0555ri, c0555ri.t));
        hashMap.put(EnumC0142bb.EVENT_TYPE_APP_OPEN, new Ng(this.f850a));
        hashMap.put(EnumC0142bb.EVENT_TYPE_PURGE_BUFFER, new Rf(this.f850a));
        hashMap.put(EnumC0142bb.EVENT_TYPE_CURRENT_SESSION_NATIVE_CRASH_PROTOBUF, new C0568s6(this.f850a));
        hashMap.put(EnumC0142bb.EVENT_TYPE_PREV_SESSION_NATIVE_CRASH_PROTOBUF, new C0652vf(this.f850a));
        hashMap.put(EnumC0142bb.EVENT_TYPE_EXCEPTION_UNHANDLED_FROM_FILE, new Vn(this.f850a));
        hashMap.put(EnumC0142bb.EVENT_TYPE_PREV_SESSION_EXCEPTION_UNHANDLED_FROM_FILE, new C0677wf(this.f850a));
        hashMap.put(EnumC0142bb.EVENT_TYPE_EXCEPTION_UNHANDLED_PROTOBUF, new Un(this.f850a));
        hashMap.put(EnumC0142bb.EVENT_TYPE_ANR, c0323ib);
        EnumC0142bb enumC0142bb2 = EnumC0142bb.EVENT_TYPE_APP_ENVIRONMENT_UPDATED;
        C0555ri c0555ri2 = this.f850a;
        hashMap.put(enumC0142bb2, new C0758zl(c0555ri2, c0555ri2.e));
        EnumC0142bb enumC0142bb3 = EnumC0142bb.EVENT_TYPE_APP_ENVIRONMENT_CLEARED;
        C0555ri c0555ri3 = this.f850a;
        hashMap.put(enumC0142bb3, new C0758zl(c0555ri3, c0555ri3.f));
        hashMap.put(EnumC0142bb.EVENT_TYPE_SEND_USER_PROFILE, c0323ib);
        EnumC0142bb enumC0142bb4 = EnumC0142bb.EVENT_TYPE_SET_USER_PROFILE_ID;
        C0555ri c0555ri4 = this.f850a;
        hashMap.put(enumC0142bb4, new C0758zl(c0555ri4, c0555ri4.k));
        hashMap.put(EnumC0142bb.EVENT_TYPE_SEND_REVENUE_EVENT, c0323ib);
        hashMap.put(EnumC0142bb.EVENT_TYPE_SEND_AD_REVENUE_EVENT, c0323ib);
        hashMap.put(EnumC0142bb.EVENT_TYPE_CLEANUP, c0323ib);
        hashMap.put(EnumC0142bb.EVENT_TYPE_SEND_ECOMMERCE_EVENT, c0323ib);
        hashMap.put(EnumC0142bb.EVENT_TYPE_WEBVIEW_SYNC, c0323ib);
        hashMap.put(EnumC0142bb.EVENT_CLIENT_EXTERNAL_ATTRIBUTION, new E9(this.f850a));
        return hashMap;
    }

    public final C0555ri b() {
        return this.f850a;
    }

    public final void a(EnumC0142bb enumC0142bb, AbstractC0473oa abstractC0473oa) {
        this.b.put(enumC0142bb, abstractC0473oa);
    }

    @Override // io.appmetrica.analytics.impl.Ff
    public final W8 a(int i) {
        LinkedList linkedList = new LinkedList();
        EnumC0142bb a2 = EnumC0142bb.a(i);
        C0517q4 c0517q4 = this.c;
        if (c0517q4 != null) {
            c0517q4.a(a2, linkedList);
        }
        AbstractC0473oa abstractC0473oa = (AbstractC0473oa) this.b.get(a2);
        if (abstractC0473oa != null) {
            abstractC0473oa.a(linkedList);
        }
        return new V8(linkedList);
    }

    public final AbstractC0473oa a(EnumC0142bb enumC0142bb) {
        return (AbstractC0473oa) this.b.get(enumC0142bb);
    }
}
