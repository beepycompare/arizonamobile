package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreutils.internal.io.FileUtils;
import java.io.File;
import kotlin.io.FilesKt;
/* renamed from: io.appmetrica.analytics.impl.ca  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0163ca implements Co {

    /* renamed from: a  reason: collision with root package name */
    public final Context f911a;
    public final String b;

    public C0163ca(Context context, String str) {
        this.f911a = context;
        this.b = str;
    }

    @Override // io.appmetrica.analytics.impl.Co
    public final String a() {
        try {
            File fileFromSdkStorage = FileUtils.getFileFromSdkStorage(this.f911a, this.b);
            if (fileFromSdkStorage != null) {
                fileFromSdkStorage.exists();
                File fileFromAppStorage = FileUtils.getFileFromAppStorage(this.f911a, this.b);
                if (fileFromAppStorage != null) {
                    FileUtils.copyToNullable(fileFromAppStorage, fileFromSdkStorage);
                }
                return FilesKt.readText$default(fileFromSdkStorage, null, 1, null);
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // io.appmetrica.analytics.impl.Co
    public final void a(String str) {
        try {
            File fileFromSdkStorage = FileUtils.getFileFromSdkStorage(this.f911a, this.b);
            if (fileFromSdkStorage != null) {
                FilesKt.writeText$default(fileFromSdkStorage, str, null, 2, null);
            }
        } catch (Throwable unused) {
        }
    }
}
