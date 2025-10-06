package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreutils.internal.io.FileUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
/* renamed from: io.appmetrica.analytics.impl.z7  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0754z7 {

    /* renamed from: a  reason: collision with root package name */
    public final InterfaceC0298h7 f1186a;
    public final List b;
    public final boolean c;

    public C0754z7(InterfaceC0298h7 interfaceC0298h7, ArrayList arrayList, boolean z) {
        this.f1186a = interfaceC0298h7;
        this.b = arrayList;
        this.c = z;
    }

    public final String a(Context context, InterfaceC0679w7 interfaceC0679w7) {
        File parentFile;
        try {
            File a2 = this.f1186a.a(context, interfaceC0679w7.b());
            if (!a2.exists() && (parentFile = a2.getParentFile()) != null && (parentFile.exists() || parentFile.mkdirs())) {
                a(context, interfaceC0679w7.a(), a2);
            }
            return a2.getPath();
        } catch (Throwable unused) {
            return interfaceC0679w7.b();
        }
    }

    public final void a(Context context, String str, File file) {
        List<InterfaceC0298h7> list = this.b;
        if ((list instanceof Collection) && list.isEmpty()) {
            return;
        }
        for (InterfaceC0298h7 interfaceC0298h7 : list) {
            File a2 = interfaceC0298h7.a(context, str);
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
