package com.android.vending.expansion.zipfile;

import android.content.ContentProvider;
import android.content.ContentProviderOperation;
import android.content.ContentProviderResult;
import android.content.ContentValues;
import android.content.Context;
import android.content.OperationApplicationException;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.res.AssetFileDescriptor;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.android.vending.expansion.zipfile.ZipResourceFile;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public abstract class APEZProvider extends ContentProvider {
    public static final int COMPLEN_IDX = 5;
    public static final int COMPTYPE_IDX = 7;
    public static final int CRC_IDX = 4;
    public static final int FILEID_IDX = 0;
    public static final int FILENAME_IDX = 1;
    public static final int MOD_IDX = 3;
    private static final String NO_FILE = "N";
    public static final int UNCOMPLEN_IDX = 6;
    public static final int ZIPFILE_IDX = 2;
    private ZipResourceFile mAPKExtensionFile;
    private boolean mInit;
    public static final String FILEID = "_id";
    public static final String FILENAME = "ZPFN";
    public static final String ZIPFILE = "ZFIL";
    public static final String MODIFICATION = "ZMOD";
    public static final String CRC32 = "ZCRC";
    public static final String COMPRESSEDLEN = "ZCOL";
    public static final String UNCOMPRESSEDLEN = "ZUNL";
    public static final String COMPRESSIONTYPE = "ZTYP";
    public static final String[] ALL_FIELDS = {FILEID, FILENAME, ZIPFILE, MODIFICATION, CRC32, COMPRESSEDLEN, UNCOMPRESSEDLEN, COMPRESSIONTYPE};
    public static final int[] ALL_FIELDS_INT = {0, 1, 2, 3, 4, 5, 6, 7};

    private boolean initIfNecessary() {
        int i;
        if (!this.mInit) {
            Context context = getContext();
            PackageManager packageManager = context.getPackageManager();
            ProviderInfo resolveContentProvider = packageManager.resolveContentProvider(getAuthority(), 128);
            try {
                int i2 = packageManager.getPackageInfo(context.getPackageName(), 0).versionCode;
                String[] strArr = null;
                if (resolveContentProvider.metaData != null) {
                    int i3 = resolveContentProvider.metaData.getInt("mainVersion", i2);
                    int i4 = resolveContentProvider.metaData.getInt("patchVersion", i2);
                    String string = resolveContentProvider.metaData.getString("mainFilename", "N");
                    if ("N" != string) {
                        String string2 = resolveContentProvider.metaData.getString("patchFilename", "N");
                        strArr = "N" != string2 ? new String[]{string, string2} : new String[]{string};
                    }
                    i = i4;
                    i2 = i3;
                } else {
                    i = i2;
                }
                try {
                    this.mAPKExtensionFile = strArr == null ? APKExpansionSupport.getAPKExpansionZipFile(context, i2, i) : APKExpansionSupport.getResourceZipFile(strArr);
                    this.mInit = true;
                    return true;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (PackageManager.NameNotFoundException e2) {
                e2.printStackTrace();
            }
        }
        return false;
    }

    @Override // android.content.ContentProvider
    public ContentProviderResult[] applyBatch(ArrayList<ContentProviderOperation> arrayList) throws OperationApplicationException {
        initIfNecessary();
        return super.applyBatch(arrayList);
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    public abstract String getAuthority();

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        return "vnd.android.cursor.item/asset";
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return true;
    }

    @Override // android.content.ContentProvider
    public AssetFileDescriptor openAssetFile(Uri uri, String str) throws FileNotFoundException {
        initIfNecessary();
        String encodedPath = uri.getEncodedPath();
        if (encodedPath.startsWith(RemoteSettings.FORWARD_SLASH_STRING)) {
            encodedPath = encodedPath.substring(1);
        }
        return this.mAPKExtensionFile.getAssetFileDescriptor(encodedPath);
    }

    @Override // android.content.ContentProvider
    public ParcelFileDescriptor openFile(Uri uri, String str) throws FileNotFoundException {
        initIfNecessary();
        AssetFileDescriptor openAssetFile = openAssetFile(uri, str);
        if (openAssetFile != null) {
            return openAssetFile.getParcelFileDescriptor();
        }
        return null;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        int[] iArr;
        Object valueOf;
        long j;
        initIfNecessary();
        ZipResourceFile zipResourceFile = this.mAPKExtensionFile;
        ZipResourceFile.ZipEntryRO[] allEntries = zipResourceFile == null ? new ZipResourceFile.ZipEntryRO[0] : zipResourceFile.getAllEntries();
        if (strArr == null) {
            iArr = ALL_FIELDS_INT;
            strArr = ALL_FIELDS;
        } else {
            int length = strArr.length;
            iArr = new int[length];
            for (int i = 0; i < length; i++) {
                if (strArr[i].equals(FILEID)) {
                    iArr[i] = 0;
                } else if (strArr[i].equals(FILENAME)) {
                    iArr[i] = 1;
                } else if (strArr[i].equals(ZIPFILE)) {
                    iArr[i] = 2;
                } else if (strArr[i].equals(MODIFICATION)) {
                    iArr[i] = 3;
                } else if (strArr[i].equals(CRC32)) {
                    iArr[i] = 4;
                } else if (strArr[i].equals(COMPRESSEDLEN)) {
                    iArr[i] = 5;
                } else if (strArr[i].equals(UNCOMPRESSEDLEN)) {
                    iArr[i] = 6;
                } else if (!strArr[i].equals(COMPRESSIONTYPE)) {
                    throw new RuntimeException();
                } else {
                    iArr[i] = 7;
                }
            }
        }
        MatrixCursor matrixCursor = new MatrixCursor(strArr, allEntries.length);
        int length2 = iArr.length;
        for (ZipResourceFile.ZipEntryRO zipEntryRO : allEntries) {
            MatrixCursor.RowBuilder newRow = matrixCursor.newRow();
            for (int i2 = 0; i2 < length2; i2++) {
                switch (iArr[i2]) {
                    case 0:
                        valueOf = Integer.valueOf(i2);
                        newRow.add(valueOf);
                        break;
                    case 1:
                        valueOf = zipEntryRO.mFileName;
                        newRow.add(valueOf);
                        break;
                    case 2:
                        valueOf = zipEntryRO.getZipFileName();
                        newRow.add(valueOf);
                        break;
                    case 3:
                        j = zipEntryRO.mWhenModified;
                        valueOf = Long.valueOf(j);
                        newRow.add(valueOf);
                        break;
                    case 4:
                        j = zipEntryRO.mCRC32;
                        valueOf = Long.valueOf(j);
                        newRow.add(valueOf);
                        break;
                    case 5:
                        j = zipEntryRO.mCompressedLength;
                        valueOf = Long.valueOf(j);
                        newRow.add(valueOf);
                        break;
                    case 6:
                        j = zipEntryRO.mUncompressedLength;
                        valueOf = Long.valueOf(j);
                        newRow.add(valueOf);
                        break;
                    case 7:
                        valueOf = Integer.valueOf(zipEntryRO.mMethod);
                        newRow.add(valueOf);
                        break;
                }
            }
        }
        return matrixCursor;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}
