package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.backport.Consumer;
import java.io.File;
/* renamed from: io.appmetrica.analytics.impl.vg  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0666vg implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final File f1251a;
    public final Consumer b;

    public RunnableC0666vg(File file, C0682w6 c0682w6) {
        this.f1251a = file;
        this.b = c0682w6;
    }

    @Override // java.lang.Runnable
    public final void run() {
        File[] listFiles;
        if (!this.f1251a.exists() || !this.f1251a.isDirectory() || (listFiles = this.f1251a.listFiles()) == null || listFiles.length == 0) {
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
