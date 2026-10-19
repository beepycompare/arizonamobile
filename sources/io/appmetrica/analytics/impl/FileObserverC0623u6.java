package io.appmetrica.analytics.impl;

import android.os.FileObserver;
import android.text.TextUtils;
import io.appmetrica.analytics.coreapi.internal.backport.Consumer;
import java.io.File;
/* renamed from: io.appmetrica.analytics.impl.u6  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class FileObserverC0623u6 extends FileObserver {

    /* renamed from: a  reason: collision with root package name */
    public final Consumer f1231a;
    public final File b;
    public final C0679wa c;

    public FileObserverC0623u6(File file, C0675w6 c0675w6, C0679wa c0679wa) {
        super(file.getAbsolutePath(), 8);
        this.f1231a = c0675w6;
        this.b = file;
        this.c = c0679wa;
    }

    @Override // android.os.FileObserver
    public final void onEvent(int i, String str) {
        if (i != 8 || TextUtils.isEmpty(str)) {
            return;
        }
        Consumer consumer = this.f1231a;
        C0679wa c0679wa = this.c;
        File file = this.b;
        c0679wa.getClass();
        consumer.consume(new File(file, str));
    }
}
