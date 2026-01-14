package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreutils.internal.io.FileUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
/* loaded from: classes5.dex */
public final class Z6 {

    /* renamed from: a  reason: collision with root package name */
    public final I6 f881a;
    public final List b;
    public final boolean c;

    public Z6(I6 i6, ArrayList arrayList, boolean z) {
        this.f881a = i6;
        this.b = arrayList;
        this.c = z;
    }

    public final String a(Context context, X6 x6) {
        File parentFile;
        try {
            File a2 = this.f881a.a(context, x6.b());
            if (!a2.exists() && (parentFile = a2.getParentFile()) != null && (parentFile.exists() || parentFile.mkdirs())) {
                a(context, x6.a(), a2);
            }
            return a2.getPath();
        } catch (Throwable unused) {
            return x6.b();
        }
    }

    public final void a(Context context, String str, File file) {
        List<I6> list = this.b;
        if ((list instanceof Collection) && list.isEmpty()) {
            return;
        }
        for (I6 i6 : list) {
            File a2 = i6.a(context, str);
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
