package io.appmetrica.analytics.impl;

import android.os.FileObserver;
import android.text.TextUtils;
import io.appmetrica.analytics.coreapi.internal.backport.Consumer;
import java.io.File;
/* renamed from: io.appmetrica.analytics.impl.f6  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class FileObserverC0237f6 extends FileObserver {

    /* renamed from: a  reason: collision with root package name */
    public final Consumer f885a;
    public final File b;
    public final C0138ba c;

    public FileObserverC0237f6(File file, C0289h6 c0289h6, C0138ba c0138ba) {
        super(file.getAbsolutePath(), 8);
        this.f885a = c0289h6;
        this.b = file;
        this.c = c0138ba;
    }

    @Override // android.os.FileObserver
    public final void onEvent(int i, String str) {
        if (i != 8 || TextUtils.isEmpty(str)) {
            return;
        }
        Consumer consumer = this.f885a;
        C0138ba c0138ba = this.c;
        File file = this.b;
        c0138ba.getClass();
        consumer.consume(new File(file, str));
    }
}
