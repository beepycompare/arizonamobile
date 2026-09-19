package io.appmetrica.analytics.impl;

import android.os.FileObserver;
import android.text.TextUtils;
import io.appmetrica.analytics.coreapi.internal.backport.Consumer;
import java.io.File;
/* renamed from: io.appmetrica.analytics.impl.u6  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class FileObserverC0628u6 extends FileObserver {

    /* renamed from: a  reason: collision with root package name */
    public final Consumer f1228a;
    public final File b;
    public final C0684wa c;

    public FileObserverC0628u6(File file, C0680w6 c0680w6, C0684wa c0684wa) {
        super(file.getAbsolutePath(), 8);
        this.f1228a = c0680w6;
        this.b = file;
        this.c = c0684wa;
    }

    @Override // android.os.FileObserver
    public final void onEvent(int i, String str) {
        if (i != 8 || TextUtils.isEmpty(str)) {
            return;
        }
        Consumer consumer = this.f1228a;
        C0684wa c0684wa = this.c;
        File file = this.b;
        c0684wa.getClass();
        consumer.consume(new File(file, str));
    }
}
