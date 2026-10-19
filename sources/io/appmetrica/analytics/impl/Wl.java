package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
/* loaded from: classes5.dex */
public final class Wl {

    /* renamed from: a  reason: collision with root package name */
    public final C0191dd f835a;
    public final C0165cd b;

    public Wl(PublicLogger publicLogger, String str) {
        this(new C0191dd(str, publicLogger), new C0165cd(str, publicLogger));
    }

    public final synchronized boolean a(C0268gd c0268gd, String str, String str2) {
        int size = c0268gd.size();
        int i = this.f835a.c.f511a;
        if (size >= i && (i != c0268gd.size() || !c0268gd.containsKey(str))) {
            C0191dd c0191dd = this.f835a;
            c0191dd.d.warning("The %s has reached the limit of %d items. Item with key %s will be ignored", c0191dd.e, Integer.valueOf(c0191dd.c.f511a), str);
            return false;
        }
        this.b.getClass();
        int i2 = c0268gd.f1001a;
        if (str2 != null) {
            i2 += str2.length();
        }
        if (c0268gd.containsKey(str)) {
            String str3 = (String) c0268gd.get(str);
            if (str3 != null) {
                i2 -= str3.length();
            }
        } else {
            i2 += str.length();
        }
        if (i2 > 4500) {
            C0165cd c0165cd = this.b;
            c0165cd.b.warning("The %s has reached the total size limit that equals %d symbols. Item with key %s will be ignored", c0165cd.f930a, 4500, str);
            return false;
        }
        c0268gd.put(str, str2);
        return true;
    }

    public final boolean b(C0268gd c0268gd, String str, String str2) {
        if (c0268gd != null) {
            String a2 = this.f835a.f949a.a(str);
            String a3 = this.f835a.b.a(str2);
            if (!c0268gd.containsKey(a2)) {
                if (a3 != null) {
                    return a(c0268gd, a2, a3);
                }
                return false;
            }
            String str3 = (String) c0268gd.get(a2);
            if (a3 == null || !a3.equals(str3)) {
                return a(c0268gd, a2, a3);
            }
            return false;
        }
        return false;
    }

    public Wl(C0191dd c0191dd, C0165cd c0165cd) {
        this.f835a = c0191dd;
        this.b = c0165cd;
    }
}
