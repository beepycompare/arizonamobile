package io.appmetrica.analytics.impl;

import android.os.FileObserver;
import android.text.TextUtils;
import io.appmetrica.analytics.coreapi.internal.backport.Consumer;
import java.io.File;
/* renamed from: io.appmetrica.analytics.impl.l6  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class FileObserverC0392l6 extends FileObserver {

    /* renamed from: a  reason: collision with root package name */
    public final Consumer f985a;
    public final File b;
    public final C0293ha c;

    public FileObserverC0392l6(File file, C0442n6 c0442n6, C0293ha c0293ha) {
        super(file.getAbsolutePath(), 8);
        this.f985a = c0442n6;
        this.b = file;
        this.c = c0293ha;
    }

    @Override // android.os.FileObserver
    public final void onEvent(int i, String str) {
        if (i != 8 || TextUtils.isEmpty(str)) {
            return;
        }
        Consumer consumer = this.f985a;
        C0293ha c0293ha = this.c;
        File file = this.b;
        c0293ha.getClass();
        consumer.consume(new File(file, str));
    }
}
