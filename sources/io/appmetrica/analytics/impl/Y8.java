package io.appmetrica.analytics.impl;

import java.util.HashMap;
import java.util.LinkedList;
/* loaded from: classes5.dex */
public final class Y8 extends Gf {

    /* renamed from: a  reason: collision with root package name */
    public final C0578si f762a;
    public final HashMap b;
    public final C0539r4 c;

    public Y8(Y4 y4) {
        C0578si c0578si = new C0578si(y4);
        this.f762a = c0578si;
        this.c = new C0539r4(c0578si);
        this.b = a();
    }

    public final HashMap a() {
        HashMap hashMap = new HashMap();
        hashMap.put(EnumC0165cb.EVENT_TYPE_ACTIVATION, new C0282h(this.f762a));
        hashMap.put(EnumC0165cb.EVENT_TYPE_START, new Fl(this.f762a));
        hashMap.put(EnumC0165cb.EVENT_TYPE_REGULAR, new Hg(this.f762a));
        C0345jb c0345jb = new C0345jb(this.f762a);
        hashMap.put(EnumC0165cb.EVENT_TYPE_EXCEPTION_USER_PROTOBUF, c0345jb);
        hashMap.put(EnumC0165cb.EVENT_TYPE_EXCEPTION_USER_CUSTOM_PROTOBUF, c0345jb);
        hashMap.put(EnumC0165cb.EVENT_TYPE_SEND_REFERRER, c0345jb);
        hashMap.put(EnumC0165cb.EVENT_TYPE_CUSTOM_EVENT, c0345jb);
        EnumC0165cb enumC0165cb = EnumC0165cb.EVENT_TYPE_SET_SESSION_EXTRA;
        C0578si c0578si = this.f762a;
        hashMap.put(enumC0165cb, new Al(c0578si, c0578si.t));
        hashMap.put(EnumC0165cb.EVENT_TYPE_APP_OPEN, new Og(this.f762a));
        hashMap.put(EnumC0165cb.EVENT_TYPE_PURGE_BUFFER, new Sf(this.f762a));
        hashMap.put(EnumC0165cb.EVENT_TYPE_CURRENT_SESSION_NATIVE_CRASH_PROTOBUF, new C0591t6(this.f762a));
        hashMap.put(EnumC0165cb.EVENT_TYPE_PREV_SESSION_NATIVE_CRASH_PROTOBUF, new C0675wf(this.f762a));
        hashMap.put(EnumC0165cb.EVENT_TYPE_EXCEPTION_UNHANDLED_FROM_FILE, new Wn(this.f762a));
        hashMap.put(EnumC0165cb.EVENT_TYPE_PREV_SESSION_EXCEPTION_UNHANDLED_FROM_FILE, new C0700xf(this.f762a));
        hashMap.put(EnumC0165cb.EVENT_TYPE_EXCEPTION_UNHANDLED_PROTOBUF, new Vn(this.f762a));
        hashMap.put(EnumC0165cb.EVENT_TYPE_ANR, c0345jb);
        EnumC0165cb enumC0165cb2 = EnumC0165cb.EVENT_TYPE_APP_ENVIRONMENT_UPDATED;
        C0578si c0578si2 = this.f762a;
        hashMap.put(enumC0165cb2, new Al(c0578si2, c0578si2.e));
        EnumC0165cb enumC0165cb3 = EnumC0165cb.EVENT_TYPE_APP_ENVIRONMENT_CLEARED;
        C0578si c0578si3 = this.f762a;
        hashMap.put(enumC0165cb3, new Al(c0578si3, c0578si3.f));
        hashMap.put(EnumC0165cb.EVENT_TYPE_SEND_USER_PROFILE, c0345jb);
        EnumC0165cb enumC0165cb4 = EnumC0165cb.EVENT_TYPE_SET_USER_PROFILE_ID;
        C0578si c0578si4 = this.f762a;
        hashMap.put(enumC0165cb4, new Al(c0578si4, c0578si4.k));
        hashMap.put(EnumC0165cb.EVENT_TYPE_SEND_REVENUE_EVENT, c0345jb);
        hashMap.put(EnumC0165cb.EVENT_TYPE_SEND_AD_REVENUE_EVENT, c0345jb);
        hashMap.put(EnumC0165cb.EVENT_TYPE_CLEANUP, c0345jb);
        hashMap.put(EnumC0165cb.EVENT_TYPE_SEND_ECOMMERCE_EVENT, c0345jb);
        hashMap.put(EnumC0165cb.EVENT_TYPE_WEBVIEW_SYNC, c0345jb);
        hashMap.put(EnumC0165cb.EVENT_CLIENT_EXTERNAL_ATTRIBUTION, new F9(this.f762a));
        return hashMap;
    }

    public final C0578si b() {
        return this.f762a;
    }

    public final void a(EnumC0165cb enumC0165cb, AbstractC0496pa abstractC0496pa) {
        this.b.put(enumC0165cb, abstractC0496pa);
    }

    @Override // io.appmetrica.analytics.impl.Gf
    public final X8 a(int i) {
        LinkedList linkedList = new LinkedList();
        EnumC0165cb a2 = EnumC0165cb.a(i);
        C0539r4 c0539r4 = this.c;
        if (c0539r4 != null) {
            c0539r4.a(a2, linkedList);
        }
        AbstractC0496pa abstractC0496pa = (AbstractC0496pa) this.b.get(a2);
        if (abstractC0496pa != null) {
            abstractC0496pa.a(linkedList);
        }
        return new W8(linkedList);
    }

    public final AbstractC0496pa a(EnumC0165cb enumC0165cb) {
        return (AbstractC0496pa) this.b.get(enumC0165cb);
    }
}
