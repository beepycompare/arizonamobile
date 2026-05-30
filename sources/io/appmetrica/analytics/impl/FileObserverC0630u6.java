package io.appmetrica.analytics.impl;

import android.os.FileObserver;
import android.text.TextUtils;
import io.appmetrica.analytics.coreapi.internal.backport.Consumer;
import java.io.File;
/* renamed from: io.appmetrica.analytics.impl.u6  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class FileObserverC0630u6 extends FileObserver {

    /* renamed from: a  reason: collision with root package name */
    public final Consumer f1226a;
    public final File b;
    public final C0686wa c;

    public FileObserverC0630u6(File file, C0682w6 c0682w6, C0686wa c0686wa) {
        super(file.getAbsolutePath(), 8);
        this.f1226a = c0682w6;
        this.b = file;
        this.c = c0686wa;
    }

    @Override // android.os.FileObserver
    public final void onEvent(int i, String str) {
        if (i != 8 || TextUtils.isEmpty(str)) {
            return;
        }
        Consumer consumer = this.f1226a;
        C0686wa c0686wa = this.c;
        File file = this.b;
        c0686wa.getClass();
        consumer.consume(new File(file, str));
    }
}
