package com.androidplot.util;

import android.os.Trace;
/* loaded from: classes3.dex */
public abstract class APTrace {
    public static void begin(String str) {
        Trace.beginSection(str);
    }

    public static void end() {
        Trace.endSection();
    }
}
