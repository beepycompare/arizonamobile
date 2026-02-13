package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.StartupParamsCallback;
import io.appmetrica.analytics.coreutils.internal.time.SystemTimeProvider;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
/* renamed from: io.appmetrica.analytics.impl.cm  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC0180cm {

    /* renamed from: a  reason: collision with root package name */
    public static final Set f944a = SetsKt.setOf((Object[]) new String[]{"appmetrica_clids", StartupParamsCallback.APPMETRICA_DEVICE_ID_HASH, StartupParamsCallback.APPMETRICA_DEVICE_ID, "appmetrica_get_ad_url", "appmetrica_report_ad_url", StartupParamsCallback.APPMETRICA_UUID});
    public static final SystemTimeProvider b = new SystemTimeProvider();
    public static final C3 c = new C3();

    public static final boolean a(String str) {
        return !(str == null || str.length() == 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00ae A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00ae A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0017 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final boolean a(C0257fm c0257fm, Collection collection, Map map, Function0 function0) {
        boolean a2;
        if (collection != null && !collection.isEmpty() && !collection.isEmpty()) {
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                switch (str.hashCode()) {
                    case -1367801046:
                        if (!str.equals(StartupParamsCallback.APPMETRICA_UUID)) {
                            if (c0257fm.w) {
                                return false;
                            }
                            if (b.currentTimeSeconds() > c0257fm.o + c0257fm.z.f539a) {
                                return false;
                            }
                        } else {
                            a2 = a(c0257fm.d);
                            if (a2) {
                                return false;
                            }
                        }
                    case 155670667:
                        if (str.equals("appmetrica_get_ad_url")) {
                            a2 = a(c0257fm.i);
                            if (a2) {
                            }
                        } else if (c0257fm.w) {
                        }
                        break;
                    case 299713912:
                        if (str.equals(StartupParamsCallback.APPMETRICA_DEVICE_ID_HASH)) {
                            a2 = a(c0257fm.b);
                            if (a2) {
                            }
                        } else if (c0257fm.w) {
                        }
                        break;
                    case 530949152:
                        if (str.equals("appmetrica_clids")) {
                            c.getClass();
                            a2 = C3.a(map, c0257fm, (C0741z3) function0.invoke());
                            if (a2) {
                            }
                        } else if (c0257fm.w) {
                        }
                        break;
                    case 703740463:
                        if (str.equals("appmetrica_report_ad_url")) {
                            a2 = a(c0257fm.j);
                            if (a2) {
                            }
                        } else if (c0257fm.w) {
                        }
                        break;
                    case 1117383061:
                        if (str.equals(StartupParamsCallback.APPMETRICA_DEVICE_ID)) {
                            a2 = a(c0257fm.f999a);
                            if (a2) {
                            }
                        } else if (c0257fm.w) {
                        }
                        break;
                    default:
                        if (c0257fm.w) {
                        }
                        break;
                }
            }
        }
        return true;
    }
}
