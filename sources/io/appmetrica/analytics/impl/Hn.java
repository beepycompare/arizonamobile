package io.appmetrica.analytics.impl;

import java.util.ArrayList;
/* loaded from: classes5.dex */
public abstract class Hn {
    /* JADX WARN: Removed duplicated region for block: B:18:0x0044  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Gn a(Throwable th, int i, int i2) {
        StackTraceElement[] stackTraceElementArr;
        Gn gn;
        String name = th.getClass().getName();
        String message = th.getMessage();
        try {
            stackTraceElementArr = th.getStackTrace();
        } catch (Throwable unused) {
            stackTraceElementArr = new StackTraceElement[0];
        }
        ArrayList arrayList = new ArrayList(stackTraceElementArr.length);
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            arrayList.add(new Dl(stackTraceElement));
        }
        Throwable cause = th.getCause();
        ArrayList arrayList2 = null;
        if (cause != null) {
            if (i2 >= i) {
                cause = null;
            }
            if (cause != null) {
                gn = a(cause, 30, i2 + 1);
                if (i2 < i) {
                    Throwable[] suppressed = th.getSuppressed();
                    arrayList2 = new ArrayList(suppressed.length);
                    for (Throwable th2 : suppressed) {
                        arrayList2.add(a(th2, 1, i2));
                    }
                }
                return new Gn(name, message, arrayList, gn, arrayList2);
            }
        }
        gn = null;
        if (i2 < i) {
        }
        return new Gn(name, message, arrayList, gn, arrayList2);
    }
}
