package io.appmetrica.analytics.impl;

import android.os.FileObserver;
import android.text.TextUtils;
import io.appmetrica.analytics.coreapi.internal.backport.Consumer;
import java.io.File;
/* loaded from: classes4.dex */
public final class A6 extends FileObserver {

    /* renamed from: a  reason: collision with root package name */
    public final Consumer f332a;
    public final File b;
    public final C0655va c;

    public A6(File file, C6 c6, C0655va c0655va) {
        super(file.getAbsolutePath(), 8);
        this.f332a = c6;
        this.b = file;
        this.c = c0655va;
    }

    @Override // android.os.FileObserver
    public final void onEvent(int i, String str) {
        if (i != 8 || TextUtils.isEmpty(str)) {
            return;
        }
        Consumer consumer = this.f332a;
        C0655va c0655va = this.c;
        File file = this.b;
        c0655va.getClass();
        consumer.consume(new File(file, str));
    }
}
