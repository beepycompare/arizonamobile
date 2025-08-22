package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.backport.Consumer;
import java.io.File;
/* renamed from: io.appmetrica.analytics.impl.mg  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0434mg implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final File f968a;
    public final Consumer b;

    public RunnableC0434mg(File file, C6 c6) {
        this.f968a = file;
        this.b = c6;
    }

    @Override // java.lang.Runnable
    public final void run() {
        File[] listFiles;
        if (!this.f968a.exists() || !this.f968a.isDirectory() || (listFiles = this.f968a.listFiles()) == null || listFiles.length == 0) {
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
