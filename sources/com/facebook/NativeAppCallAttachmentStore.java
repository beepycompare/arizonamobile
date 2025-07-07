package com.facebook;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import com.facebook.NativeAppCallContentProvider;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Map;
import java.util.UUID;
/* loaded from: classes3.dex */
public final class NativeAppCallAttachmentStore implements NativeAppCallContentProvider.AttachmentDataSource {
    static final String ATTACHMENTS_DIR_NAME = "com.facebook.NativeAppCallAttachmentStore.files";
    private static final String TAG = "com.facebook.NativeAppCallAttachmentStore";
    private static File attachmentsDirectory;

    static File getAttachmentsDirectory(Context context) {
        File file;
        synchronized (NativeAppCallAttachmentStore.class) {
            try {
                if (attachmentsDirectory == null) {
                    attachmentsDirectory = new File(context.getCacheDir(), ATTACHMENTS_DIR_NAME);
                }
                file = attachmentsDirectory;
            } catch (Throwable th) {
                throw th;
            }
        }
        return file;
    }

    public void addAttachmentsForCall(Context context, UUID uuid, Map<String, Bitmap> map) {
        Validate.notNull(context, "context");
        Validate.notNull(uuid, "callId");
        Validate.containsNoNulls(map.values(), "imageAttachments");
        Validate.containsNoNullOrEmpty(map.keySet(), "imageAttachments");
        if (map.size() == 0) {
            return;
        }
        if (attachmentsDirectory == null) {
            cleanupAllAttachments(context);
        }
        ensureAttachmentsDirectoryExists(context);
        ArrayList<File> arrayList = new ArrayList();
        try {
            for (Map.Entry<String, Bitmap> entry : map.entrySet()) {
                Bitmap value = entry.getValue();
                File attachmentFile = getAttachmentFile(uuid, entry.getKey(), true);
                arrayList.add(attachmentFile);
                FileOutputStream fileOutputStream = new FileOutputStream(attachmentFile);
                value.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
                Utility.closeQuietly(fileOutputStream);
            }
        } catch (IOException e) {
            Log.e(TAG, "Got unexpected exception:" + e);
            for (File file : arrayList) {
                try {
                    file.delete();
                } catch (Exception unused) {
                }
            }
            throw new FacebookException(e);
        }
    }

    void cleanupAllAttachments(Context context) {
        Utility.deleteDirectory(getAttachmentsDirectory(context));
    }

    public void cleanupAttachmentsForCall(Context context, UUID uuid) {
        Utility.deleteDirectory(getAttachmentsDirectoryForCall(uuid, false));
    }

    File ensureAttachmentsDirectoryExists(Context context) {
        File attachmentsDirectory2 = getAttachmentsDirectory(context);
        attachmentsDirectory2.mkdirs();
        return attachmentsDirectory2;
    }

    File getAttachmentFile(UUID uuid, String str, boolean z) throws IOException {
        File attachmentsDirectoryForCall = getAttachmentsDirectoryForCall(uuid, z);
        if (attachmentsDirectoryForCall == null) {
            return null;
        }
        try {
            return new File(attachmentsDirectoryForCall, URLEncoder.encode(str, "UTF-8"));
        } catch (UnsupportedEncodingException unused) {
            return null;
        }
    }

    File getAttachmentsDirectoryForCall(UUID uuid, boolean z) {
        if (attachmentsDirectory == null) {
            return null;
        }
        File file = new File(attachmentsDirectory, uuid.toString());
        if (z && !file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    @Override // com.facebook.NativeAppCallContentProvider.AttachmentDataSource
    public File openAttachment(UUID uuid, String str) throws FileNotFoundException {
        if (Utility.isNullOrEmpty(str) || uuid == null) {
            throw new FileNotFoundException();
        }
        try {
            return getAttachmentFile(uuid, str, false);
        } catch (IOException unused) {
            throw new FileNotFoundException();
        }
    }
}
