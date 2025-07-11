package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.backport.Consumer;
import java.io.File;
/* renamed from: io.appmetrica.analytics.impl.fg  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0260fg implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final File f839a;
    public final Consumer b;

    public RunnableC0260fg(File file, C0748z6 c0748z6) {
        this.f839a = file;
        this.b = c0748z6;
    }

    @Override // java.lang.Runnable
    public final void run() {
        File[] listFiles;
        if (!this.f839a.exists() || !this.f839a.isDirectory() || (listFiles = this.f839a.listFiles()) == null || listFiles.length == 0) {
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
