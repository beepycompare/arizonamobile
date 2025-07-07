package io.appmetrica.analytics.impl;

import java.util.ArrayList;
/* loaded from: classes4.dex */
public abstract class Bn {
    /* JADX WARN: Removed duplicated region for block: B:18:0x0044  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static An a(Throwable th, int i, int i2) {
        StackTraceElement[] stackTraceElementArr;
        An an;
        String name = th.getClass().getName();
        String message = th.getMessage();
        try {
            stackTraceElementArr = th.getStackTrace();
        } catch (Throwable unused) {
            stackTraceElementArr = new StackTraceElement[0];
        }
        ArrayList arrayList = new ArrayList(stackTraceElementArr.length);
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            arrayList.add(new Al(stackTraceElement));
        }
        Throwable cause = th.getCause();
        ArrayList arrayList2 = null;
        if (cause != null) {
            if (i2 >= i) {
                cause = null;
            }
            if (cause != null) {
                an = a(cause, 30, i2 + 1);
                if (i2 < i) {
                    Throwable[] suppressed = th.getSuppressed();
                    arrayList2 = new ArrayList(suppressed.length);
                    for (Throwable th2 : suppressed) {
                        arrayList2.add(a(th2, 1, i2));
                    }
                }
                return new An(name, message, arrayList, an, arrayList2);
            }
        }
        an = null;
        if (i2 < i) {
        }
        return new An(name, message, arrayList, an, arrayList2);
    }
}
