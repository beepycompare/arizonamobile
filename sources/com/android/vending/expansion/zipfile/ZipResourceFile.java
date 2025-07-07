package com.android.vending.expansion.zipfile;

import android.content.res.AssetFileDescriptor;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Collection;
import java.util.HashMap;
import java.util.Vector;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import kotlin.UShort;
/* loaded from: classes3.dex */
public class ZipResourceFile {
    static final boolean LOGV = false;
    static final String LOG_TAG = "zipro";
    static final int kCDECRC = 16;
    static final int kCDECommentLen = 32;
    static final int kCDECompLen = 20;
    static final int kCDEExtraLen = 30;
    static final int kCDELen = 46;
    static final int kCDELocalOffset = 42;
    static final int kCDEMethod = 10;
    static final int kCDEModWhen = 12;
    static final int kCDENameLen = 28;
    static final int kCDESignature = 33639248;
    static final int kCDEUncompLen = 24;
    static final int kCompressDeflated = 8;
    static final int kCompressStored = 0;
    static final int kEOCDFileOffset = 16;
    static final int kEOCDLen = 22;
    static final int kEOCDNumEntries = 8;
    static final int kEOCDSignature = 101010256;
    static final int kEOCDSize = 12;
    static final int kLFHExtraLen = 28;
    static final int kLFHLen = 30;
    static final int kLFHNameLen = 26;
    static final int kLFHSignature = 67324752;
    static final int kMaxCommentLen = 65535;
    static final int kMaxEOCDSearch = 65557;
    static final int kZipEntryAdj = 10000;
    private HashMap<String, ZipEntryRO> mHashMap = new HashMap<>();
    public HashMap<File, ZipFile> mZipFiles = new HashMap<>();
    ByteBuffer mLEByteBuffer = ByteBuffer.allocate(4);

    /* loaded from: classes3.dex */
    public static final class ZipEntryRO {
        public long mCRC32;
        public long mCompressedLength;
        public final File mFile;
        public final String mFileName;
        public long mLocalHdrOffset;
        public int mMethod;
        public long mOffset = -1;
        public long mUncompressedLength;
        public long mWhenModified;
        public final String mZipFileName;

        public ZipEntryRO(String str, File file, String str2) {
            this.mFileName = str2;
            this.mZipFileName = str;
            this.mFile = file;
        }

        public AssetFileDescriptor getAssetFileDescriptor() {
            if (this.mMethod == 0) {
                try {
                    return new AssetFileDescriptor(ParcelFileDescriptor.open(this.mFile, 268435456), getOffset(), this.mUncompressedLength);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                    return null;
                }
            }
            return null;
        }

        public long getOffset() {
            return this.mOffset;
        }

        public File getZipFile() {
            return this.mFile;
        }

        public String getZipFileName() {
            return this.mZipFileName;
        }

        public boolean isUncompressed() {
            return this.mMethod == 0;
        }

        public void setOffsetFromFile(RandomAccessFile randomAccessFile, ByteBuffer byteBuffer) throws IOException {
            long j = this.mLocalHdrOffset;
            try {
                randomAccessFile.seek(j);
                randomAccessFile.readFully(byteBuffer.array());
                if (byteBuffer.getInt(0) != ZipResourceFile.kLFHSignature) {
                    Log.w(ZipResourceFile.LOG_TAG, "didn't find signature at start of lfh");
                    throw new IOException();
                }
                this.mOffset = j + 30 + (byteBuffer.getShort(26) & UShort.MAX_VALUE) + (byteBuffer.getShort(28) & UShort.MAX_VALUE);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
    }

    public ZipResourceFile(String str) throws IOException {
        addPatchFile(str);
    }

    private static int read4LE(RandomAccessFile randomAccessFile) throws EOFException, IOException {
        return swapEndian(randomAccessFile.readInt());
    }

    private static int swapEndian(int i) {
        return ((i & 255) << 24) + ((65280 & i) << 8) + ((16711680 & i) >>> 8) + ((i >>> 24) & 255);
    }

    private static int swapEndian(short s) {
        return ((s & 65280) >>> 8) | ((s & 255) << 8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addPatchFile(String str) throws IOException {
        String str2 = str;
        File file = new File(str2);
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
        long length = randomAccessFile.length();
        if (length < 22) {
            throw new IOException();
        }
        long j = 65557 > length ? length : 65557L;
        randomAccessFile.seek(0L);
        int read4LE = read4LE(randomAccessFile);
        if (read4LE == kEOCDSignature) {
            Log.i(LOG_TAG, "Found Zip archive, but it looks empty");
            throw new IOException();
        } else if (read4LE != kLFHSignature) {
            Log.v(LOG_TAG, "Not a Zip archive");
            throw new IOException();
        } else {
            randomAccessFile.seek(length - j);
            ByteBuffer allocate = ByteBuffer.allocate((int) j);
            byte[] array = allocate.array();
            randomAccessFile.readFully(array);
            allocate.order(ByteOrder.LITTLE_ENDIAN);
            int length2 = array.length - 22;
            while (length2 >= 0 && (array[length2] != 80 || allocate.getInt(length2) != kEOCDSignature)) {
                length2--;
            }
            if (length2 < 0) {
                Log.d(LOG_TAG, "Zip: EOCD not found, " + str2 + " is not zip");
            }
            short s = allocate.getShort(length2 + 8);
            long j2 = 4294967295L;
            long j3 = allocate.getInt(length2 + 12) & 4294967295L;
            long j4 = allocate.getInt(length2 + 16) & 4294967295L;
            if (j4 + j3 > length) {
                Log.w(LOG_TAG, "bad offsets (dir " + j4 + ", size " + j3 + ", eocd " + length2 + ")");
                throw new IOException();
            } else if (s == 0) {
                Log.w(LOG_TAG, "empty archive?");
                throw new IOException();
            } else {
                MappedByteBuffer map = randomAccessFile.getChannel().map(FileChannel.MapMode.READ_ONLY, j4, j3);
                map.order(ByteOrder.LITTLE_ENDIAN);
                short s2 = UShort.MAX_VALUE;
                byte[] bArr = new byte[65535];
                ByteBuffer allocate2 = ByteBuffer.allocate(30);
                allocate2.order(ByteOrder.LITTLE_ENDIAN);
                int i = 0;
                int i2 = 0;
                int i3 = 0;
                while (i2 < s) {
                    short s3 = s2;
                    if (map.getInt(i3) != kCDESignature) {
                        Log.w(LOG_TAG, "Missed a central dir sig (at " + i3 + ")");
                        throw new IOException();
                    }
                    int i4 = map.getShort(i3 + 28) & s3;
                    short s4 = map.getShort(i3 + 30);
                    long j5 = j2;
                    short s5 = map.getShort(i3 + 32);
                    map.position(i3 + 46);
                    map.get(bArr, i, i4);
                    map.position(i);
                    String str3 = new String(bArr, i, i4);
                    ZipEntryRO zipEntryRO = new ZipEntryRO(str2, file, str3);
                    zipEntryRO.mMethod = map.getShort(i3 + 10) & s3;
                    zipEntryRO.mWhenModified = map.getInt(i3 + 12) & j5;
                    zipEntryRO.mCRC32 = map.getLong(i3 + 16) & j5;
                    zipEntryRO.mCompressedLength = map.getLong(i3 + 20) & j5;
                    zipEntryRO.mUncompressedLength = map.getLong(i3 + 24) & j5;
                    zipEntryRO.mLocalHdrOffset = map.getInt(i3 + 42) & j5;
                    allocate2.clear();
                    zipEntryRO.setOffsetFromFile(randomAccessFile, allocate2);
                    this.mHashMap.put(str3, zipEntryRO);
                    i3 += i4 + 46 + (s4 & s3) + (s5 & s3);
                    i2++;
                    str2 = str;
                    s2 = s3;
                    j2 = j5;
                    file = file;
                    i = 0;
                }
            }
        }
    }

    public ZipEntryRO[] getAllEntries() {
        Collection<ZipEntryRO> values = this.mHashMap.values();
        return (ZipEntryRO[]) values.toArray(new ZipEntryRO[values.size()]);
    }

    public AssetFileDescriptor getAssetFileDescriptor(String str) {
        ZipEntryRO zipEntryRO = this.mHashMap.get(str);
        if (zipEntryRO != null) {
            return zipEntryRO.getAssetFileDescriptor();
        }
        return null;
    }

    ZipEntryRO[] getEntriesAt(String str) {
        Vector vector = new Vector();
        Collection<ZipEntryRO> values = this.mHashMap.values();
        if (str == null) {
            str = "";
        }
        int length = str.length();
        for (ZipEntryRO zipEntryRO : values) {
            if (zipEntryRO.mFileName.startsWith(str) && -1 == zipEntryRO.mFileName.indexOf(47, length)) {
                vector.add(zipEntryRO);
            }
        }
        return (ZipEntryRO[]) vector.toArray(new ZipEntryRO[vector.size()]);
    }

    public InputStream getInputStream(String str) throws IOException {
        ZipEntryRO zipEntryRO = this.mHashMap.get(str);
        if (zipEntryRO != null) {
            if (zipEntryRO.isUncompressed()) {
                return zipEntryRO.getAssetFileDescriptor().createInputStream();
            }
            ZipFile zipFile = this.mZipFiles.get(zipEntryRO.getZipFile());
            if (zipFile == null) {
                zipFile = new ZipFile(zipEntryRO.getZipFile(), 1);
                this.mZipFiles.put(zipEntryRO.getZipFile(), zipFile);
            }
            ZipEntry entry = zipFile.getEntry(str);
            if (entry != null) {
                return zipFile.getInputStream(entry);
            }
            return null;
        }
        return null;
    }
}
