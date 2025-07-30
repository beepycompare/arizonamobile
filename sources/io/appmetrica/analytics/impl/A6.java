package io.appmetrica.analytics.impl;

import android.os.FileObserver;
import android.text.TextUtils;
import io.appmetrica.analytics.coreapi.internal.backport.Consumer;
import java.io.File;
/* loaded from: classes4.dex */
public final class A6 extends FileObserver {

    /* renamed from: a  reason: collision with root package name */
    public final Consumer f333a;
    public final File b;
    public final C0654va c;

    public A6(File file, C6 c6, C0654va c0654va) {
        super(file.getAbsolutePath(), 8);
        this.f333a = c6;
        this.b = file;
        this.c = c0654va;
    }

    @Override // android.os.FileObserver
    public final void onEvent(int i, String str) {
        if (i != 8 || TextUtils.isEmpty(str)) {
            return;
        }
        Consumer consumer = this.f333a;
        C0654va c0654va = this.c;
        File file = this.b;
        c0654va.getClass();
        consumer.consume(new File(file, str));
    }
}
