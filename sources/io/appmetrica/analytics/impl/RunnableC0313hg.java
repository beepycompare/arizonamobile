package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.backport.Consumer;
import java.io.File;
/* renamed from: io.appmetrica.analytics.impl.hg  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0313hg implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final File f885a;
    public final Consumer b;

    public RunnableC0313hg(File file, C6 c6) {
        this.f885a = file;
        this.b = c6;
    }

    @Override // java.lang.Runnable
    public final void run() {
        File[] listFiles;
        if (!this.f885a.exists() || !this.f885a.isDirectory() || (listFiles = this.f885a.listFiles()) == null || listFiles.length == 0) {
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
