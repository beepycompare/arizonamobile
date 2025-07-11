package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreutils.internal.io.FileUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
/* renamed from: io.appmetrica.analytics.impl.s7  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0574s7 {

    /* renamed from: a  reason: collision with root package name */
    public final InterfaceC0123a7 f1040a;
    public final List b;
    public final boolean c;

    public C0574s7(InterfaceC0123a7 interfaceC0123a7, ArrayList arrayList, boolean z) {
        this.f1040a = interfaceC0123a7;
        this.b = arrayList;
        this.c = z;
    }

    public final String a(Context context, InterfaceC0500p7 interfaceC0500p7) {
        File parentFile;
        try {
            File a2 = this.f1040a.a(context, interfaceC0500p7.b());
            if (!a2.exists() && (parentFile = a2.getParentFile()) != null && (parentFile.exists() || parentFile.mkdirs())) {
                a(context, interfaceC0500p7.a(), a2);
            }
            return a2.getPath();
        } catch (Throwable unused) {
            return interfaceC0500p7.b();
        }
    }

    public final void a(Context context, String str, File file) {
        List<InterfaceC0123a7> list = this.b;
        if ((list instanceof Collection) && list.isEmpty()) {
            return;
        }
        for (InterfaceC0123a7 interfaceC0123a7 : list) {
            File a2 = interfaceC0123a7.a(context, str);
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
