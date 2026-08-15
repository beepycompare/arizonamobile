package io.appmetrica.analytics.impl;

import android.os.FileObserver;
import android.text.TextUtils;
import io.appmetrica.analytics.coreapi.internal.backport.Consumer;
import java.io.File;
/* renamed from: io.appmetrica.analytics.impl.u6  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class FileObserverC0629u6 extends FileObserver {

    /* renamed from: a  reason: collision with root package name */
    public final Consumer f1228a;
    public final File b;
    public final C0685wa c;

    public FileObserverC0629u6(File file, C0681w6 c0681w6, C0685wa c0685wa) {
        super(file.getAbsolutePath(), 8);
        this.f1228a = c0681w6;
        this.b = file;
        this.c = c0685wa;
    }

    @Override // android.os.FileObserver
    public final void onEvent(int i, String str) {
        if (i != 8 || TextUtils.isEmpty(str)) {
            return;
        }
        Consumer consumer = this.f1228a;
        C0685wa c0685wa = this.c;
        File file = this.b;
        c0685wa.getClass();
        consumer.consume(new File(file, str));
    }
}
