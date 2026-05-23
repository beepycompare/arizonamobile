package io.appmetrica.analytics.coreutils.internal.io;

import android.database.Cursor;
import java.io.Closeable;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001J\u000e\u0010\u0004\u001a\u00020\u0003*\u0004\u0018\u00010\u0002H\u0007J\u000e\u0010\u0004\u001a\u00020\u0003*\u0004\u0018\u00010\u0005H\u0007¨\u0006\u0006"}, d2 = {"Lio/appmetrica/analytics/coreutils/internal/io/CloseableUtils;", "", "Ljava/io/Closeable;", "", "closeSafely", "Landroid/database/Cursor;", "core-utils_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes5.dex */
public final class CloseableUtils {
    public static final CloseableUtils INSTANCE = new CloseableUtils();

    private CloseableUtils() {
    }

    @JvmStatic
    public static final void closeSafely(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }

    @JvmStatic
    public static final void closeSafely(Cursor cursor) {
        if (cursor != null) {
            try {
                cursor.close();
            } catch (Throwable unused) {
            }
        }
    }
}
