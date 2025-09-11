package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.backport.Consumer;
import java.io.File;
/* renamed from: io.appmetrica.analytics.impl.qg  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0538qg implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final File f1050a;
    public final Consumer b;

    public RunnableC0538qg(File file, F6 f6) {
        this.f1050a = file;
        this.b = f6;
    }

    @Override // java.lang.Runnable
    public final void run() {
        File[] listFiles;
        if (!this.f1050a.exists() || !this.f1050a.isDirectory() || (listFiles = this.f1050a.listFiles()) == null || listFiles.length == 0) {
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
