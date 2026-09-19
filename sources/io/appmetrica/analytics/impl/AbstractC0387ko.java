package io.appmetrica.analytics.impl;

import java.util.ArrayList;
/* renamed from: io.appmetrica.analytics.impl.ko  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC0387ko {
    /* JADX WARN: Removed duplicated region for block: B:18:0x0044  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static C0361jo a(Throwable th, int i, int i2) {
        StackTraceElement[] stackTraceElementArr;
        C0361jo c0361jo;
        String name = th.getClass().getName();
        String message = th.getMessage();
        try {
            stackTraceElementArr = th.getStackTrace();
        } catch (Throwable unused) {
            stackTraceElementArr = new StackTraceElement[0];
        }
        ArrayList arrayList = new ArrayList(stackTraceElementArr.length);
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            arrayList.add(new C0256fm(stackTraceElement));
        }
        Throwable cause = th.getCause();
        ArrayList arrayList2 = null;
        if (cause != null) {
            if (i2 >= i) {
                cause = null;
            }
            if (cause != null) {
                c0361jo = a(cause, 30, i2 + 1);
                if (i2 < i) {
                    Throwable[] suppressed = th.getSuppressed();
                    arrayList2 = new ArrayList(suppressed.length);
                    for (Throwable th2 : suppressed) {
                        arrayList2.add(a(th2, 1, i2));
                    }
                }
                return new C0361jo(name, message, arrayList, c0361jo, arrayList2);
            }
        }
        c0361jo = null;
        if (i2 < i) {
        }
        return new C0361jo(name, message, arrayList, c0361jo, arrayList2);
    }
}
