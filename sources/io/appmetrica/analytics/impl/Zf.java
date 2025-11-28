package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.backport.Consumer;
import java.io.File;
/* loaded from: classes5.dex */
public final class Zf implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final File f787a;
    public final Consumer b;

    public Zf(File file, C0442n6 c0442n6) {
        this.f787a = file;
        this.b = c0442n6;
    }

    @Override // java.lang.Runnable
    public final void run() {
        File[] listFiles;
        if (!this.f787a.exists() || !this.f787a.isDirectory() || (listFiles = this.f787a.listFiles()) == null || listFiles.length == 0) {
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
