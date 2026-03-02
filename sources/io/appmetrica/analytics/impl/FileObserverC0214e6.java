package io.appmetrica.analytics.impl;

import android.os.FileObserver;
import android.text.TextUtils;
import io.appmetrica.analytics.coreapi.internal.backport.Consumer;
import java.io.File;
/* renamed from: io.appmetrica.analytics.impl.e6  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class FileObserverC0214e6 extends FileObserver {

    /* renamed from: a  reason: collision with root package name */
    public final Consumer f972a;
    public final File b;
    public final C0115aa c;

    public FileObserverC0214e6(File file, C0266g6 c0266g6, C0115aa c0115aa) {
        super(file.getAbsolutePath(), 8);
        this.f972a = c0266g6;
        this.b = file;
        this.c = c0115aa;
    }

    @Override // android.os.FileObserver
    public final void onEvent(int i, String str) {
        if (i != 8 || TextUtils.isEmpty(str)) {
            return;
        }
        Consumer consumer = this.f972a;
        C0115aa c0115aa = this.c;
        File file = this.b;
        c0115aa.getClass();
        consumer.consume(new File(file, str));
    }
}
