package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.backport.Consumer;
import java.io.File;
/* renamed from: io.appmetrica.analytics.impl.fg  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0268fg implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final File f838a;
    public final Consumer b;

    public RunnableC0268fg(File file, C0756z6 c0756z6) {
        this.f838a = file;
        this.b = c0756z6;
    }

    @Override // java.lang.Runnable
    public final void run() {
        File[] listFiles;
        if (!this.f838a.exists() || !this.f838a.isDirectory() || (listFiles = this.f838a.listFiles()) == null || listFiles.length == 0) {
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
