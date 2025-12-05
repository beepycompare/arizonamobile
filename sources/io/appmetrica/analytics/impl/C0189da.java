package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreutils.internal.io.FileUtils;
import java.io.File;
import kotlin.Unit;
/* renamed from: io.appmetrica.analytics.impl.da  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0189da {

    /* renamed from: a  reason: collision with root package name */
    public volatile Boolean f930a;

    public final void a(Context context) {
        if (this.f930a == null) {
            synchronized (this) {
                if (this.f930a == null) {
                    boolean z = false;
                    try {
                        File fileFromAppStorage = FileUtils.getFileFromAppStorage(context, "uuid.dat");
                        boolean exists = fileFromAppStorage != null ? fileFromAppStorage.exists() : false;
                        File fileFromSdkStorage = FileUtils.getFileFromSdkStorage(context, "uuid.dat");
                        boolean exists2 = fileFromSdkStorage != null ? fileFromSdkStorage.exists() : false;
                        if (exists || exists2) {
                            z = true;
                        }
                    } catch (Throwable unused) {
                    }
                    this.f930a = Boolean.valueOf(z);
                }
                Unit unit = Unit.INSTANCE;
            }
        }
    }
}
