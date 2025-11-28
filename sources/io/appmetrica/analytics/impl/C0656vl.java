package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
/* renamed from: io.appmetrica.analytics.impl.vl  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0656vl {

    /* renamed from: a  reason: collision with root package name */
    public final Jc f1174a;
    public final Ic b;

    public C0656vl(PublicLogger publicLogger, String str) {
        this(new Jc(str, publicLogger), new Ic(str, publicLogger));
    }

    public final synchronized boolean a(Mc mc, String str, String str2) {
        int size = mc.size();
        int i = this.f1174a.c.f1125a;
        if (size >= i && (i != mc.size() || !mc.containsKey(str))) {
            Jc jc = this.f1174a;
            jc.d.warning("The %s has reached the limit of %d items. Item with key %s will be ignored", jc.e, Integer.valueOf(jc.c.f1125a), str);
            return false;
        }
        this.b.getClass();
        int i2 = mc.f590a;
        if (str2 != null) {
            i2 += str2.length();
        }
        if (mc.containsKey(str)) {
            String str3 = (String) mc.get(str);
            if (str3 != null) {
                i2 -= str3.length();
            }
        } else {
            i2 += str.length();
        }
        if (i2 > 4500) {
            Ic ic = this.b;
            ic.b.warning("The %s has reached the total size limit that equals %d symbols. Item with key %s will be ignored", ic.f526a, 4500, str);
            return false;
        }
        mc.put(str, str2);
        return true;
    }

    public final boolean b(Mc mc, String str, String str2) {
        if (mc != null) {
            String a2 = this.f1174a.f545a.a(str);
            String a3 = this.f1174a.b.a(str2);
            if (!mc.containsKey(a2)) {
                if (a3 != null) {
                    return a(mc, a2, a3);
                }
                return false;
            }
            String str3 = (String) mc.get(a2);
            if (a3 == null || !a3.equals(str3)) {
                return a(mc, a2, a3);
            }
            return false;
        }
        return false;
    }

    public C0656vl(Jc jc, Ic ic) {
        this.f1174a = jc;
        this.b = ic;
    }
}
