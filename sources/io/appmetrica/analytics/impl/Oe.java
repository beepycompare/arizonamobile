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
public final class Oe {

    /* renamed from: a  reason: collision with root package name */
    public final Context f580a;
    public final lo b;
    public final mo c;

    public Oe(Context context) {
        this(context, new lo(), new mo());
    }

    public final String a(String str) {
        try {
            this.c.getClass();
            if (!mo.a(str)) {
                this.b.getClass();
                str = StringsKt.replace$default(UUID.randomUUID().toString(), Constants.FILENAME_SEQUENCE_SEPARATOR, "", false, 4, (Object) null).toLowerCase(Locale.US);
            }
            File fileFromSdkStorage = FileUtils.getFileFromSdkStorage(this.f580a, "uuid.dat");
            if (fileFromSdkStorage != null && str != null) {
                AbstractC0230eb.a(str, new FileOutputStream(fileFromSdkStorage));
            }
            return str;
        } catch (Throwable unused) {
            return null;
        }
    }

    public Oe(Context context, lo loVar, mo moVar) {
        this.f580a = context;
        this.b = loVar;
        this.c = moVar;
    }

    public final void a() {
        File fileFromAppStorage;
        File fileFromSdkStorage = FileUtils.getFileFromSdkStorage(this.f580a, "uuid.dat");
        if (fileFromSdkStorage == null || fileFromSdkStorage.exists() || (fileFromAppStorage = FileUtils.getFileFromAppStorage(this.f580a, "uuid.dat")) == null || !fileFromAppStorage.exists()) {
            return;
        }
        FileUtils.copyToNullable(fileFromAppStorage, fileFromSdkStorage);
    }
}
