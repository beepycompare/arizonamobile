package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.backport.Consumer;
import java.io.File;
/* loaded from: classes5.dex */
public final class Vf implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final File f822a;
    public final Consumer b;

    public Vf(File file, C0288h6 c0288h6) {
        this.f822a = file;
        this.b = c0288h6;
    }

    @Override // java.lang.Runnable
    public final void run() {
        File[] listFiles;
        if (!this.f822a.exists() || !this.f822a.isDirectory() || (listFiles = this.f822a.listFiles()) == null || listFiles.length == 0) {
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
