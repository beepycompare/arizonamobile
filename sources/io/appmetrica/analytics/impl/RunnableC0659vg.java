package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.backport.Consumer;
import java.io.File;
/* renamed from: io.appmetrica.analytics.impl.vg  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0659vg implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final File f1254a;
    public final Consumer b;

    public RunnableC0659vg(File file, C0675w6 c0675w6) {
        this.f1254a = file;
        this.b = c0675w6;
    }

    @Override // java.lang.Runnable
    public final void run() {
        File[] listFiles;
        if (!this.f1254a.exists() || !this.f1254a.isDirectory() || (listFiles = this.f1254a.listFiles()) == null || listFiles.length == 0) {
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
