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
public final class Ue {

    /* renamed from: a  reason: collision with root package name */
    public final Context f701a;
    public final uo b;
    public final vo c;

    public Ue(Context context) {
        this(context, new uo(), new vo());
    }

    public final String a(String str) {
        try {
            this.c.getClass();
            if (!vo.a(str)) {
                this.b.getClass();
                str = StringsKt.replace$default(UUID.randomUUID().toString(), Constants.FILENAME_SEQUENCE_SEPARATOR, "", false, 4, (Object) null).toLowerCase(Locale.US);
            }
            File fileFromSdkStorage = FileUtils.getFileFromSdkStorage(this.f701a, "uuid.dat");
            if (fileFromSdkStorage != null && str != null) {
                AbstractC0353jb.a(str, new FileOutputStream(fileFromSdkStorage));
            }
            return str;
        } catch (Throwable unused) {
            return null;
        }
    }

    public Ue(Context context, uo uoVar, vo voVar) {
        this.f701a = context;
        this.b = uoVar;
        this.c = voVar;
    }

    public final void a() {
        File fileFromAppStorage;
        File fileFromSdkStorage = FileUtils.getFileFromSdkStorage(this.f701a, "uuid.dat");
        if (fileFromSdkStorage == null || fileFromSdkStorage.exists() || (fileFromAppStorage = FileUtils.getFileFromAppStorage(this.f701a, "uuid.dat")) == null || !fileFromAppStorage.exists()) {
            return;
        }
        FileUtils.copyToNullable(fileFromAppStorage, fileFromSdkStorage);
    }
}
