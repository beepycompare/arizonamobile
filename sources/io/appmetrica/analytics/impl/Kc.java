package io.appmetrica.analytics.impl;

import android.content.Context;
import android.util.SparseArray;
import io.appmetrica.analytics.AppMetrica;
/* loaded from: classes5.dex */
public abstract class Kc {
    public abstract void a(int i);

    public final synchronized void a(Context context) {
        int b = b();
        int libraryApiLevel = AppMetrica.getLibraryApiLevel();
        if (b != libraryApiLevel) {
            if (b < libraryApiLevel) {
                SparseArray c = c();
                while (true) {
                    b++;
                    if (b > libraryApiLevel) {
                        break;
                    }
                    Jc jc = (Jc) c.get(b);
                    if (jc != null) {
                        jc.a(context);
                    }
                }
            }
            a(libraryApiLevel);
        }
    }

    public abstract int b();

    public abstract SparseArray c();

    public final int a() {
        return AppMetrica.getLibraryApiLevel();
    }
}
