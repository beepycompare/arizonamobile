package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.backport.Consumer;
import java.io.File;
/* loaded from: classes5.dex */
public final class Uf implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final File f812a;
    public final Consumer b;

    public Uf(File file, C0266g6 c0266g6) {
        this.f812a = file;
        this.b = c0266g6;
    }

    @Override // java.lang.Runnable
    public final void run() {
        File[] listFiles;
        if (!this.f812a.exists() || !this.f812a.isDirectory() || (listFiles = this.f812a.listFiles()) == null || listFiles.length == 0) {
            return;
        }
        for (File file : listFiles) {
            try {
                this.b.consume(file);
            } catch (Throwable unused) {
            }
        }
    }
}
