package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
/* loaded from: classes5.dex */
public final class Wl {

    /* renamed from: a  reason: collision with root package name */
    public final C0197dd f832a;
    public final C0171cd b;

    public Wl(PublicLogger publicLogger, String str) {
        this(new C0197dd(str, publicLogger), new C0171cd(str, publicLogger));
    }

    public final synchronized boolean a(C0274gd c0274gd, String str, String str2) {
        int size = c0274gd.size();
        int i = this.f832a.c.f508a;
        if (size >= i && (i != c0274gd.size() || !c0274gd.containsKey(str))) {
            C0197dd c0197dd = this.f832a;
            c0197dd.d.warning("The %s has reached the limit of %d items. Item with key %s will be ignored", c0197dd.e, Integer.valueOf(c0197dd.c.f508a), str);
            return false;
        }
        this.b.getClass();
        int i2 = c0274gd.f998a;
        if (str2 != null) {
            i2 += str2.length();
        }
        if (c0274gd.containsKey(str)) {
            String str3 = (String) c0274gd.get(str);
            if (str3 != null) {
                i2 -= str3.length();
            }
        } else {
            i2 += str.length();
        }
        if (i2 > 4500) {
            C0171cd c0171cd = this.b;
            c0171cd.b.warning("The %s has reached the total size limit that equals %d symbols. Item with key %s will be ignored", c0171cd.f927a, 4500, str);
            return false;
        }
        c0274gd.put(str, str2);
        return true;
    }

    public final boolean b(C0274gd c0274gd, String str, String str2) {
        if (c0274gd != null) {
            String a2 = this.f832a.f946a.a(str);
            String a3 = this.f832a.b.a(str2);
            if (!c0274gd.containsKey(a2)) {
                if (a3 != null) {
                    return a(c0274gd, a2, a3);
                }
                return false;
            }
            String str3 = (String) c0274gd.get(a2);
            if (a3 == null || !a3.equals(str3)) {
                return a(c0274gd, a2, a3);
            }
            return false;
        }
        return false;
    }

    public Wl(C0197dd c0197dd, C0171cd c0171cd) {
        this.f832a = c0197dd;
        this.b = c0171cd;
    }
}
