package io.appmetrica.analytics.impl;

import android.os.FileObserver;
import android.text.TextUtils;
import io.appmetrica.analytics.coreapi.internal.backport.Consumer;
import java.io.File;
/* renamed from: io.appmetrica.analytics.impl.x6  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class FileObserverC0698x6 extends FileObserver {

    /* renamed from: a  reason: collision with root package name */
    public final Consumer f1119a;
    public final File b;
    public final C0602ta c;

    public FileObserverC0698x6(File file, C0748z6 c0748z6, C0602ta c0602ta) {
        super(file.getAbsolutePath(), 8);
        this.f1119a = c0748z6;
        this.b = file;
        this.c = c0602ta;
    }

    @Override // android.os.FileObserver
    public final void onEvent(int i, String str) {
        if (i != 8 || TextUtils.isEmpty(str)) {
            return;
        }
        Consumer consumer = this.f1119a;
        C0602ta c0602ta = this.c;
        File file = this.b;
        c0602ta.getClass();
        consumer.consume(new File(file, str));
    }
}
