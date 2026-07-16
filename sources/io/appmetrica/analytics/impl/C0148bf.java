package io.appmetrica.analytics.impl;

import android.content.Context;
import com.google.android.vending.expansion.downloader.Constants;
import io.appmetrica.analytics.coreutils.internal.io.FileUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Locale;
import java.util.UUID;
import kotlin.text.StringsKt;
/* renamed from: io.appmetrica.analytics.impl.bf  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0148bf {

    /* renamed from: a  reason: collision with root package name */
    public final Context f910a;
    public final Ro b;
    public final So c;

    public C0148bf(Context context) {
        this(context, new Ro(), new So());
    }

    public final String a(String str) {
        try {
            this.c.getClass();
            if (!So.a(str)) {
                this.b.getClass();
                str = StringsKt.replace$default(UUID.randomUUID().toString(), Constants.FILENAME_SEQUENCE_SEPARATOR, "", false, 4, (Object) null).toLowerCase(Locale.US);
            }
            File fileFromSdkStorage = FileUtils.getFileFromSdkStorage(this.f910a, "uuid.dat");
            if (fileFromSdkStorage != null && str != null) {
                AbstractC0402lb.a(str, new FileOutputStream(fileFromSdkStorage));
            }
            return str;
        } catch (Throwable unused) {
            return null;
        }
    }

    public C0148bf(Context context, Ro ro, So so) {
        this.f910a = context;
        this.b = ro;
        this.c = so;
    }

    public final void a() {
        File fileFromAppStorage;
        File fileFromSdkStorage = FileUtils.getFileFromSdkStorage(this.f910a, "uuid.dat");
        if (fileFromSdkStorage == null || fileFromSdkStorage.exists() || (fileFromAppStorage = FileUtils.getFileFromAppStorage(this.f910a, "uuid.dat")) == null || !fileFromAppStorage.exists()) {
            return;
        }
        FileUtils.copyToNullable(fileFromAppStorage, fileFromSdkStorage);
    }
}
