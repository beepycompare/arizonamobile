package io.appmetrica.analytics.impl;

import android.os.FileObserver;
import android.text.TextUtils;
import io.appmetrica.analytics.coreapi.internal.backport.Consumer;
import java.io.File;
/* loaded from: classes4.dex */
public final class D6 extends FileObserver {

    /* renamed from: a  reason: collision with root package name */
    public final Consumer f404a;
    public final File b;
    public final Aa c;

    public D6(File file, F6 f6, Aa aa) {
        super(file.getAbsolutePath(), 8);
        this.f404a = f6;
        this.b = file;
        this.c = aa;
    }

    @Override // android.os.FileObserver
    public final void onEvent(int i, String str) {
        if (i != 8 || TextUtils.isEmpty(str)) {
            return;
        }
        Consumer consumer = this.f404a;
        Aa aa = this.c;
        File file = this.b;
        aa.getClass();
        consumer.consume(new File(file, str));
    }
}
