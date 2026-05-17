package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.backport.Consumer;
import java.io.File;
/* loaded from: classes5.dex */
public final class Uf implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final File f817a;
    public final Consumer b;

    public Uf(File file, C0266g6 c0266g6) {
        this.f817a = file;
        this.b = c0266g6;
    }

    @Override // java.lang.Runnable
    public final void run() {
        File[] listFiles;
        if (!this.f817a.exists() || !this.f817a.isDirectory() || (listFiles = this.f817a.listFiles()) == null || listFiles.length == 0) {
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
