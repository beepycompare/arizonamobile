package io.appmetrica.analytics.impl;

import android.os.FileObserver;
import android.text.TextUtils;
import io.appmetrica.analytics.coreapi.internal.backport.Consumer;
import java.io.File;
/* renamed from: io.appmetrica.analytics.impl.e6  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class FileObserverC0215e6 extends FileObserver {

    /* renamed from: a  reason: collision with root package name */
    public final Consumer f973a;
    public final File b;
    public final C0116aa c;

    public FileObserverC0215e6(File file, C0267g6 c0267g6, C0116aa c0116aa) {
        super(file.getAbsolutePath(), 8);
        this.f973a = c0267g6;
        this.b = file;
        this.c = c0116aa;
    }

    @Override // android.os.FileObserver
    public final void onEvent(int i, String str) {
        if (i != 8 || TextUtils.isEmpty(str)) {
            return;
        }
        Consumer consumer = this.f973a;
        C0116aa c0116aa = this.c;
        File file = this.b;
        c0116aa.getClass();
        consumer.consume(new File(file, str));
    }
}
