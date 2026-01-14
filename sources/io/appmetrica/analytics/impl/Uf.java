package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.backport.Consumer;
import java.io.File;
/* loaded from: classes5.dex */
public final class Uf implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final File f813a;
    public final Consumer b;

    public Uf(File file, C0267g6 c0267g6) {
        this.f813a = file;
        this.b = c0267g6;
    }

    @Override // java.lang.Runnable
    public final void run() {
        File[] listFiles;
        if (!this.f813a.exists() || !this.f813a.isDirectory() || (listFiles = this.f813a.listFiles()) == null || listFiles.length == 0) {
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
