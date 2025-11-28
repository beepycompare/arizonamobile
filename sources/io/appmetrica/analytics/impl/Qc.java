package io.appmetrica.analytics.impl;

import android.content.Context;
import android.util.SparseArray;
import io.appmetrica.analytics.AppMetrica;
/* loaded from: classes5.dex */
public abstract class Qc {
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
                    Pc pc = (Pc) c.get(b);
                    if (pc != null) {
                        pc.a(context);
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
