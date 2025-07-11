package io.appmetrica.analytics.impl;

import android.content.Context;
import com.google.android.vending.expansion.downloader.Constants;
import io.appmetrica.analytics.coreutils.internal.io.FileUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Locale;
import java.util.UUID;
import kotlin.text.StringsKt;
/* loaded from: classes4.dex */
public final class Me {

    /* renamed from: a  reason: collision with root package name */
    public final Context f537a;
    public final io b;
    public final jo c;

    public Me(Context context) {
        this(context, new io(), new jo());
    }

    public final String a(String str) {
        try {
            this.c.getClass();
            if (!jo.a(str)) {
                this.b.getClass();
                str = StringsKt.replace$default(UUID.randomUUID().toString(), Constants.FILENAME_SEQUENCE_SEPARATOR, "", false, 4, (Object) null).toLowerCase(Locale.US);
            }
            File fileFromSdkStorage = FileUtils.getFileFromSdkStorage(this.f537a, "uuid.dat");
            if (fileFromSdkStorage != null && str != null) {
                AbstractC0179cb.a(str, new FileOutputStream(fileFromSdkStorage));
            }
            return str;
        } catch (Throwable unused) {
            return null;
        }
    }

    public Me(Context context, io ioVar, jo joVar) {
        this.f537a = context;
        this.b = ioVar;
        this.c = joVar;
    }

    public final void a() {
        File fileFromAppStorage;
        File fileFromSdkStorage = FileUtils.getFileFromSdkStorage(this.f537a, "uuid.dat");
        if (fileFromSdkStorage == null || fileFromSdkStorage.exists() || (fileFromAppStorage = FileUtils.getFileFromAppStorage(this.f537a, "uuid.dat")) == null || !fileFromAppStorage.exists()) {
            return;
        }
        FileUtils.copyToNullable(fileFromAppStorage, fileFromSdkStorage);
    }
}
