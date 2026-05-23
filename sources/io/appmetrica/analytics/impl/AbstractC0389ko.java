package io.appmetrica.analytics.impl;

import java.util.ArrayList;
/* renamed from: io.appmetrica.analytics.impl.ko  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC0389ko {
    /* JADX WARN: Removed duplicated region for block: B:18:0x0044  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static C0363jo a(Throwable th, int i, int i2) {
        StackTraceElement[] stackTraceElementArr;
        C0363jo c0363jo;
        String name = th.getClass().getName();
        String message = th.getMessage();
        try {
            stackTraceElementArr = th.getStackTrace();
        } catch (Throwable unused) {
            stackTraceElementArr = new StackTraceElement[0];
        }
        ArrayList arrayList = new ArrayList(stackTraceElementArr.length);
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            arrayList.add(new C0258fm(stackTraceElement));
        }
        Throwable cause = th.getCause();
        ArrayList arrayList2 = null;
        if (cause != null) {
            if (i2 >= i) {
                cause = null;
            }
            if (cause != null) {
                c0363jo = a(cause, 30, i2 + 1);
                if (i2 < i) {
                    Throwable[] suppressed = th.getSuppressed();
                    arrayList2 = new ArrayList(suppressed.length);
                    for (Throwable th2 : suppressed) {
                        arrayList2.add(a(th2, 1, i2));
                    }
                }
                return new C0363jo(name, message, arrayList, c0363jo, arrayList2);
            }
        }
        c0363jo = null;
        if (i2 < i) {
        }
        return new C0363jo(name, message, arrayList, c0363jo, arrayList2);
    }
}
