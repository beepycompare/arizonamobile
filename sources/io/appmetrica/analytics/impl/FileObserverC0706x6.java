package io.appmetrica.analytics.impl;

import android.os.FileObserver;
import android.text.TextUtils;
import io.appmetrica.analytics.coreapi.internal.backport.Consumer;
import java.io.File;
/* renamed from: io.appmetrica.analytics.impl.x6  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class FileObserverC0706x6 extends FileObserver {

    /* renamed from: a  reason: collision with root package name */
    public final Consumer f1118a;
    public final File b;
    public final C0610ta c;

    public FileObserverC0706x6(File file, C0756z6 c0756z6, C0610ta c0610ta) {
        super(file.getAbsolutePath(), 8);
        this.f1118a = c0756z6;
        this.b = file;
        this.c = c0610ta;
    }

    @Override // android.os.FileObserver
    public final void onEvent(int i, String str) {
        if (i != 8 || TextUtils.isEmpty(str)) {
            return;
        }
        Consumer consumer = this.f1118a;
        C0610ta c0610ta = this.c;
        File file = this.b;
        c0610ta.getClass();
        consumer.consume(new File(file, str));
    }
}
