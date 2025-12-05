package androidx.datastore.core;

import android.content.Context;
import androidx.datastore.core.util.DirectBootUtil_androidKt;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: DeviceProtectedDataStoreFile.android.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"deviceProtectedDataStoreFile", "Ljava/io/File;", "Landroid/content/Context;", "fileName", "", "datastore-core"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DeviceProtectedDataStoreFile {
    public static final File deviceProtectedDataStoreFile(Context context, String fileName) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        return new File(DirectBootUtil_androidKt.requireDeviceProtectedStorageContext(context).getFilesDir(), "datastore/" + fileName);
    }
}
