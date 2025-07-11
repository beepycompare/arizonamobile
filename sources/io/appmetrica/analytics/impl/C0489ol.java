package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
/* renamed from: io.appmetrica.analytics.impl.ol  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0489ol {

    /* renamed from: a  reason: collision with root package name */
    public final Vc f979a;
    public final Uc b;

    public C0489ol(PublicLogger publicLogger, String str) {
        this(new Vc(str, publicLogger), new Uc(str, publicLogger));
    }

    public final synchronized boolean a(Yc yc, String str, String str2) {
        int size = yc.size();
        int i = this.f979a.c.f455a;
        if (size >= i && (i != yc.size() || !yc.containsKey(str))) {
            Vc vc = this.f979a;
            vc.d.warning("The %s has reached the limit of %d items. Item with key %s will be ignored", vc.e, Integer.valueOf(vc.c.f455a), str);
            return false;
        }
        this.b.getClass();
        int i2 = yc.f721a;
        if (str2 != null) {
            i2 += str2.length();
        }
        if (yc.containsKey(str)) {
            String str3 = (String) yc.get(str);
            if (str3 != null) {
                i2 -= str3.length();
            }
        } else {
            i2 += str.length();
        }
        if (i2 > 4500) {
            Uc uc = this.b;
            uc.b.warning("The %s has reached the total size limit that equals %d symbols. Item with key %s will be ignored", uc.f659a, 4500, str);
            return false;
        }
        yc.put(str, str2);
        return true;
    }

    public final boolean b(Yc yc, String str, String str2) {
        if (yc != null) {
            String a2 = this.f979a.f672a.a(str);
            String a3 = this.f979a.b.a(str2);
            if (!yc.containsKey(a2)) {
                if (a3 != null) {
                    return a(yc, a2, a3);
                }
                return false;
            }
            String str3 = (String) yc.get(a2);
            if (a3 == null || !a3.equals(str3)) {
                return a(yc, a2, a3);
            }
            return false;
        }
        return false;
    }

    public C0489ol(Vc vc, Uc uc) {
        this.f979a = vc;
        this.b = uc;
    }
}
