package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreutils.internal.io.FileUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
/* renamed from: io.appmetrica.analytics.impl.h7  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0290h7 {

    /* renamed from: a  reason: collision with root package name */
    public final P6 f907a;
    public final List b;
    public final boolean c;

    public C0290h7(P6 p6, ArrayList arrayList, boolean z) {
        this.f907a = p6;
        this.b = arrayList;
        this.c = z;
    }

    public final String a(Context context, InterfaceC0212e7 interfaceC0212e7) {
        File parentFile;
        try {
            File a2 = this.f907a.a(context, interfaceC0212e7.b());
            if (!a2.exists() && (parentFile = a2.getParentFile()) != null && (parentFile.exists() || parentFile.mkdirs())) {
                a(context, interfaceC0212e7.a(), a2);
            }
            return a2.getPath();
        } catch (Throwable unused) {
            return interfaceC0212e7.b();
        }
    }

    public final void a(Context context, String str, File file) {
        List<P6> list = this.b;
        if ((list instanceof Collection) && list.isEmpty()) {
            return;
        }
        for (P6 p6 : list) {
            File a2 = p6.a(context, str);
            if (a2.exists()) {
                try {
                    if (this.c) {
                        FileUtils.copyToNullable(a2, file);
                    } else {
                        FileUtils.move(a2, file);
                    }
                    String path = a2.getPath();
                    String path2 = file.getPath();
                    for (String str2 : CollectionsKt.listOf((Object[]) new String[]{"-journal", "-shm", "-wal"})) {
                        File file2 = new File(path + str2);
                        File file3 = new File(path2 + str2);
                        if (this.c) {
                            FileUtils.copyToNullable(file2, file3);
                        } else {
                            FileUtils.move(file2, file3);
                        }
                    }
                    return;
                } catch (Throwable unused) {
                    continue;
                }
            }
        }
    }
}
