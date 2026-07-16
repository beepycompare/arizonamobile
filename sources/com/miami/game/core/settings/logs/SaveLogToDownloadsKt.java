package com.miami.game.core.settings.logs;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import androidx.core.content.FileProvider;
import coil3.util.UtilsKt;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: saveLogToDownloads.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\u001e\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"copyToDownloads", "Landroid/net/Uri;", "Landroid/content/Context;", UtilsKt.SCHEME_FILE, "Ljava/io/File;", "displayName", "", "settings"}, k = 2, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SaveLogToDownloadsKt {
    public static /* synthetic */ Uri copyToDownloads$default(Context context, File file, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = file.getName();
            Intrinsics.checkNotNullExpressionValue(str, "getName(...)");
        }
        return copyToDownloads(context, file, str);
    }

    public static final Uri copyToDownloads(Context context, File file, String displayName) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(displayName, "displayName");
        if (!file.exists() || file.length() <= 0) {
            return null;
        }
        if (Build.VERSION.SDK_INT >= 29) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("_display_name", displayName);
            contentValues.put("mime_type", "text/plain");
            contentValues.put("is_pending", (Integer) 1);
            ContentResolver contentResolver = context.getContentResolver();
            Uri contentUri = MediaStore.Downloads.getContentUri("external_primary");
            Intrinsics.checkNotNullExpressionValue(contentUri, "getContentUri(...)");
            Uri insert = contentResolver.insert(contentUri, contentValues);
            if (insert == null) {
                return null;
            }
            try {
                try {
                    OutputStream openOutputStream = contentResolver.openOutputStream(insert, "w");
                    if (openOutputStream != null) {
                        OutputStream outputStream = openOutputStream;
                        OutputStream outputStream2 = outputStream;
                        FileInputStream fileInputStream = new FileInputStream(file);
                        ByteStreamsKt.copyTo$default(fileInputStream, outputStream2, 0, 2, null);
                        CloseableKt.closeFinally(fileInputStream, null);
                        CloseableKt.closeFinally(outputStream, null);
                        contentValues.clear();
                        contentValues.put("is_pending", (Integer) 0);
                        contentResolver.update(insert, contentValues, null, null);
                        return insert;
                    }
                    return null;
                } catch (Exception unused) {
                    Result.Companion companion = Result.Companion;
                    Result.m9898constructorimpl(Integer.valueOf(contentResolver.delete(insert, null, null)));
                    return null;
                }
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                Result.m9898constructorimpl(ResultKt.createFailure(th));
                return null;
            }
        }
        File externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        if (!externalStoragePublicDirectory.exists()) {
            externalStoragePublicDirectory.mkdirs();
        }
        File file2 = new File(externalStoragePublicDirectory, displayName);
        try {
            FileInputStream fileInputStream2 = new FileInputStream(file);
            FileInputStream fileInputStream3 = fileInputStream2;
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            try {
                ByteStreamsKt.copyTo$default(fileInputStream3, fileOutputStream, 0, 2, null);
                CloseableKt.closeFinally(fileOutputStream, null);
                CloseableKt.closeFinally(fileInputStream2, null);
                return FileProvider.getUriForFile(context, context.getPackageName() + ".fileprovider", file2);
            } catch (Throwable th2) {
                try {
                    throw th2;
                } catch (Throwable th3) {
                    CloseableKt.closeFinally(fileOutputStream, th2);
                    throw th3;
                }
            }
        } catch (Exception unused2) {
            return null;
        }
    }
}
