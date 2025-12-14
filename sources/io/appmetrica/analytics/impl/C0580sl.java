package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
/* renamed from: io.appmetrica.analytics.impl.sl  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0580sl {

    /* renamed from: a  reason: collision with root package name */
    public final Dc f1220a;
    public final Cc b;

    public C0580sl(PublicLogger publicLogger, String str) {
        this(new Dc(str, publicLogger), new Cc(str, publicLogger));
    }

    public final synchronized boolean a(Gc gc, String str, String str2) {
        int size = gc.size();
        int i = this.f1220a.c.f1119a;
        if (size >= i && (i != gc.size() || !gc.containsKey(str))) {
            Dc dc = this.f1220a;
            dc.d.warning("The %s has reached the limit of %d items. Item with key %s will be ignored", dc.e, Integer.valueOf(dc.c.f1119a), str);
            return false;
        }
        this.b.getClass();
        int i2 = gc.f589a;
        if (str2 != null) {
            i2 += str2.length();
        }
        if (gc.containsKey(str)) {
            String str3 = (String) gc.get(str);
            if (str3 != null) {
                i2 -= str3.length();
            }
        } else {
            i2 += str.length();
        }
        if (i2 > 4500) {
            Cc cc = this.b;
            cc.b.warning("The %s has reached the total size limit that equals %d symbols. Item with key %s will be ignored", cc.f526a, 4500, str);
            return false;
        }
        gc.put(str, str2);
        return true;
    }

    public final boolean b(Gc gc, String str, String str2) {
        if (gc != null) {
            String a2 = this.f1220a.f540a.a(str);
            String a3 = this.f1220a.b.a(str2);
            if (!gc.containsKey(a2)) {
                if (a3 != null) {
                    return a(gc, a2, a3);
                }
                return false;
            }
            String str3 = (String) gc.get(a2);
            if (a3 == null || !a3.equals(str3)) {
                return a(gc, a2, a3);
            }
            return false;
        }
        return false;
    }

    public C0580sl(Dc dc, Cc cc) {
        this.f1220a = dc;
        this.b = cc;
    }
}
