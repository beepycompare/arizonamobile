package io.appmetrica.analytics.impl;

import java.util.HashMap;
import java.util.LinkedList;
/* loaded from: classes5.dex */
public final class X8 extends Ff {

    /* renamed from: a  reason: collision with root package name */
    public final C0556ri f851a;
    public final HashMap b;
    public final C0518q4 c;

    public X8(X4 x4) {
        C0556ri c0556ri = new C0556ri(x4);
        this.f851a = c0556ri;
        this.c = new C0518q4(c0556ri);
        this.b = a();
    }

    public final HashMap a() {
        HashMap hashMap = new HashMap();
        hashMap.put(EnumC0143bb.EVENT_TYPE_ACTIVATION, new C0286h(this.f851a));
        hashMap.put(EnumC0143bb.EVENT_TYPE_START, new El(this.f851a));
        hashMap.put(EnumC0143bb.EVENT_TYPE_REGULAR, new Gg(this.f851a));
        C0324ib c0324ib = new C0324ib(this.f851a);
        hashMap.put(EnumC0143bb.EVENT_TYPE_EXCEPTION_USER_PROTOBUF, c0324ib);
        hashMap.put(EnumC0143bb.EVENT_TYPE_EXCEPTION_USER_CUSTOM_PROTOBUF, c0324ib);
        hashMap.put(EnumC0143bb.EVENT_TYPE_SEND_REFERRER, c0324ib);
        hashMap.put(EnumC0143bb.EVENT_TYPE_CUSTOM_EVENT, c0324ib);
        EnumC0143bb enumC0143bb = EnumC0143bb.EVENT_TYPE_SET_SESSION_EXTRA;
        C0556ri c0556ri = this.f851a;
        hashMap.put(enumC0143bb, new C0759zl(c0556ri, c0556ri.t));
        hashMap.put(EnumC0143bb.EVENT_TYPE_APP_OPEN, new Ng(this.f851a));
        hashMap.put(EnumC0143bb.EVENT_TYPE_PURGE_BUFFER, new Rf(this.f851a));
        hashMap.put(EnumC0143bb.EVENT_TYPE_CURRENT_SESSION_NATIVE_CRASH_PROTOBUF, new C0569s6(this.f851a));
        hashMap.put(EnumC0143bb.EVENT_TYPE_PREV_SESSION_NATIVE_CRASH_PROTOBUF, new C0653vf(this.f851a));
        hashMap.put(EnumC0143bb.EVENT_TYPE_EXCEPTION_UNHANDLED_FROM_FILE, new Vn(this.f851a));
        hashMap.put(EnumC0143bb.EVENT_TYPE_PREV_SESSION_EXCEPTION_UNHANDLED_FROM_FILE, new C0678wf(this.f851a));
        hashMap.put(EnumC0143bb.EVENT_TYPE_EXCEPTION_UNHANDLED_PROTOBUF, new Un(this.f851a));
        hashMap.put(EnumC0143bb.EVENT_TYPE_ANR, c0324ib);
        EnumC0143bb enumC0143bb2 = EnumC0143bb.EVENT_TYPE_APP_ENVIRONMENT_UPDATED;
        C0556ri c0556ri2 = this.f851a;
        hashMap.put(enumC0143bb2, new C0759zl(c0556ri2, c0556ri2.e));
        EnumC0143bb enumC0143bb3 = EnumC0143bb.EVENT_TYPE_APP_ENVIRONMENT_CLEARED;
        C0556ri c0556ri3 = this.f851a;
        hashMap.put(enumC0143bb3, new C0759zl(c0556ri3, c0556ri3.f));
        hashMap.put(EnumC0143bb.EVENT_TYPE_SEND_USER_PROFILE, c0324ib);
        EnumC0143bb enumC0143bb4 = EnumC0143bb.EVENT_TYPE_SET_USER_PROFILE_ID;
        C0556ri c0556ri4 = this.f851a;
        hashMap.put(enumC0143bb4, new C0759zl(c0556ri4, c0556ri4.k));
        hashMap.put(EnumC0143bb.EVENT_TYPE_SEND_REVENUE_EVENT, c0324ib);
        hashMap.put(EnumC0143bb.EVENT_TYPE_SEND_AD_REVENUE_EVENT, c0324ib);
        hashMap.put(EnumC0143bb.EVENT_TYPE_CLEANUP, c0324ib);
        hashMap.put(EnumC0143bb.EVENT_TYPE_SEND_ECOMMERCE_EVENT, c0324ib);
        hashMap.put(EnumC0143bb.EVENT_TYPE_WEBVIEW_SYNC, c0324ib);
        hashMap.put(EnumC0143bb.EVENT_CLIENT_EXTERNAL_ATTRIBUTION, new E9(this.f851a));
        return hashMap;
    }

    public final C0556ri b() {
        return this.f851a;
    }

    public final void a(EnumC0143bb enumC0143bb, AbstractC0474oa abstractC0474oa) {
        this.b.put(enumC0143bb, abstractC0474oa);
    }

    @Override // io.appmetrica.analytics.impl.Ff
    public final W8 a(int i) {
        LinkedList linkedList = new LinkedList();
        EnumC0143bb a2 = EnumC0143bb.a(i);
        C0518q4 c0518q4 = this.c;
        if (c0518q4 != null) {
            c0518q4.a(a2, linkedList);
        }
        AbstractC0474oa abstractC0474oa = (AbstractC0474oa) this.b.get(a2);
        if (abstractC0474oa != null) {
            abstractC0474oa.a(linkedList);
        }
        return new V8(linkedList);
    }

    public final AbstractC0474oa a(EnumC0143bb enumC0143bb) {
        return (AbstractC0474oa) this.b.get(enumC0143bb);
    }
}
