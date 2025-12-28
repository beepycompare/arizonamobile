package io.appmetrica.analytics.impl;

import java.util.HashMap;
import java.util.LinkedList;
/* loaded from: classes5.dex */
public final class Y8 extends Gf {

    /* renamed from: a  reason: collision with root package name */
    public final C0577si f860a;
    public final HashMap b;
    public final C0538r4 c;

    public Y8(Y4 y4) {
        C0577si c0577si = new C0577si(y4);
        this.f860a = c0577si;
        this.c = new C0538r4(c0577si);
        this.b = a();
    }

    public final HashMap a() {
        HashMap hashMap = new HashMap();
        hashMap.put(EnumC0164cb.EVENT_TYPE_ACTIVATION, new C0281h(this.f860a));
        hashMap.put(EnumC0164cb.EVENT_TYPE_START, new Fl(this.f860a));
        hashMap.put(EnumC0164cb.EVENT_TYPE_REGULAR, new Hg(this.f860a));
        C0344jb c0344jb = new C0344jb(this.f860a);
        hashMap.put(EnumC0164cb.EVENT_TYPE_EXCEPTION_USER_PROTOBUF, c0344jb);
        hashMap.put(EnumC0164cb.EVENT_TYPE_EXCEPTION_USER_CUSTOM_PROTOBUF, c0344jb);
        hashMap.put(EnumC0164cb.EVENT_TYPE_SEND_REFERRER, c0344jb);
        hashMap.put(EnumC0164cb.EVENT_TYPE_CUSTOM_EVENT, c0344jb);
        EnumC0164cb enumC0164cb = EnumC0164cb.EVENT_TYPE_SET_SESSION_EXTRA;
        C0577si c0577si = this.f860a;
        hashMap.put(enumC0164cb, new Al(c0577si, c0577si.t));
        hashMap.put(EnumC0164cb.EVENT_TYPE_APP_OPEN, new Og(this.f860a));
        hashMap.put(EnumC0164cb.EVENT_TYPE_PURGE_BUFFER, new Sf(this.f860a));
        hashMap.put(EnumC0164cb.EVENT_TYPE_CURRENT_SESSION_NATIVE_CRASH_PROTOBUF, new C0590t6(this.f860a));
        hashMap.put(EnumC0164cb.EVENT_TYPE_PREV_SESSION_NATIVE_CRASH_PROTOBUF, new C0674wf(this.f860a));
        hashMap.put(EnumC0164cb.EVENT_TYPE_EXCEPTION_UNHANDLED_FROM_FILE, new Wn(this.f860a));
        hashMap.put(EnumC0164cb.EVENT_TYPE_PREV_SESSION_EXCEPTION_UNHANDLED_FROM_FILE, new C0699xf(this.f860a));
        hashMap.put(EnumC0164cb.EVENT_TYPE_EXCEPTION_UNHANDLED_PROTOBUF, new Vn(this.f860a));
        hashMap.put(EnumC0164cb.EVENT_TYPE_ANR, c0344jb);
        EnumC0164cb enumC0164cb2 = EnumC0164cb.EVENT_TYPE_APP_ENVIRONMENT_UPDATED;
        C0577si c0577si2 = this.f860a;
        hashMap.put(enumC0164cb2, new Al(c0577si2, c0577si2.e));
        EnumC0164cb enumC0164cb3 = EnumC0164cb.EVENT_TYPE_APP_ENVIRONMENT_CLEARED;
        C0577si c0577si3 = this.f860a;
        hashMap.put(enumC0164cb3, new Al(c0577si3, c0577si3.f));
        hashMap.put(EnumC0164cb.EVENT_TYPE_SEND_USER_PROFILE, c0344jb);
        EnumC0164cb enumC0164cb4 = EnumC0164cb.EVENT_TYPE_SET_USER_PROFILE_ID;
        C0577si c0577si4 = this.f860a;
        hashMap.put(enumC0164cb4, new Al(c0577si4, c0577si4.k));
        hashMap.put(EnumC0164cb.EVENT_TYPE_SEND_REVENUE_EVENT, c0344jb);
        hashMap.put(EnumC0164cb.EVENT_TYPE_SEND_AD_REVENUE_EVENT, c0344jb);
        hashMap.put(EnumC0164cb.EVENT_TYPE_CLEANUP, c0344jb);
        hashMap.put(EnumC0164cb.EVENT_TYPE_SEND_ECOMMERCE_EVENT, c0344jb);
        hashMap.put(EnumC0164cb.EVENT_TYPE_WEBVIEW_SYNC, c0344jb);
        hashMap.put(EnumC0164cb.EVENT_CLIENT_EXTERNAL_ATTRIBUTION, new F9(this.f860a));
        return hashMap;
    }

    public final C0577si b() {
        return this.f860a;
    }

    public final void a(EnumC0164cb enumC0164cb, AbstractC0495pa abstractC0495pa) {
        this.b.put(enumC0164cb, abstractC0495pa);
    }

    @Override // io.appmetrica.analytics.impl.Gf
    public final X8 a(int i) {
        LinkedList linkedList = new LinkedList();
        EnumC0164cb a2 = EnumC0164cb.a(i);
        C0538r4 c0538r4 = this.c;
        if (c0538r4 != null) {
            c0538r4.a(a2, linkedList);
        }
        AbstractC0495pa abstractC0495pa = (AbstractC0495pa) this.b.get(a2);
        if (abstractC0495pa != null) {
            abstractC0495pa.a(linkedList);
        }
        return new W8(linkedList);
    }

    public final AbstractC0495pa a(EnumC0164cb enumC0164cb) {
        return (AbstractC0495pa) this.b.get(enumC0164cb);
    }
}
