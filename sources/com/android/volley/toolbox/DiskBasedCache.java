package com.android.volley.toolbox;

import android.os.SystemClock;
import android.text.TextUtils;
import com.android.volley.Cache;
import com.android.volley.Header;
import com.android.volley.VolleyLog;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public class DiskBasedCache implements Cache {
    private static final int CACHE_MAGIC = 538247942;
    private static final int DEFAULT_DISK_USAGE_BYTES = 5242880;
    static final float HYSTERESIS_FACTOR = 0.9f;
    private final Map<String, CacheHeader> mEntries;
    private final int mMaxCacheSizeInBytes;
    private final FileSupplier mRootDirectorySupplier;
    private long mTotalSize;

    /* loaded from: classes3.dex */
    public interface FileSupplier {
        File get();
    }

    public DiskBasedCache(final File file, int i) {
        this.mEntries = new LinkedHashMap(16, 0.75f, true);
        this.mTotalSize = 0L;
        this.mRootDirectorySupplier = new FileSupplier() { // from class: com.android.volley.toolbox.DiskBasedCache.1
            @Override // com.android.volley.toolbox.DiskBasedCache.FileSupplier
            public File get() {
                return file;
            }
        };
        this.mMaxCacheSizeInBytes = i;
    }

    public DiskBasedCache(FileSupplier fileSupplier, int i) {
        this.mEntries = new LinkedHashMap(16, 0.75f, true);
        this.mTotalSize = 0L;
        this.mRootDirectorySupplier = fileSupplier;
        this.mMaxCacheSizeInBytes = i;
    }

    public DiskBasedCache(File file) {
        this(file, (int) DEFAULT_DISK_USAGE_BYTES);
    }

    public DiskBasedCache(FileSupplier fileSupplier) {
        this(fileSupplier, (int) DEFAULT_DISK_USAGE_BYTES);
    }

    @Override // com.android.volley.Cache
    public synchronized void clear() {
        File[] listFiles = this.mRootDirectorySupplier.get().listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                file.delete();
            }
        }
        this.mEntries.clear();
        this.mTotalSize = 0L;
        VolleyLog.d("Cache cleared.", new Object[0]);
    }

    @Override // com.android.volley.Cache
    public synchronized Cache.Entry get(String str) {
        CacheHeader cacheHeader = this.mEntries.get(str);
        if (cacheHeader == null) {
            return null;
        }
        File fileForKey = getFileForKey(str);
        try {
            CountingInputStream countingInputStream = new CountingInputStream(new BufferedInputStream(createInputStream(fileForKey)), fileForKey.length());
            try {
                CacheHeader readHeader = CacheHeader.readHeader(countingInputStream);
                if (!TextUtils.equals(str, readHeader.key)) {
                    VolleyLog.d("%s: key=%s, found=%s", fileForKey.getAbsolutePath(), str, readHeader.key);
                    removeEntry(str);
                    return null;
                }
                return cacheHeader.toCacheEntry(streamToBytes(countingInputStream, countingInputStream.bytesRemaining()));
            } finally {
                countingInputStream.close();
            }
        } catch (IOException e) {
            VolleyLog.d("%s: %s", fileForKey.getAbsolutePath(), e.toString());
            remove(str);
            return null;
        }
    }

    @Override // com.android.volley.Cache
    public synchronized void initialize() {
        File file = this.mRootDirectorySupplier.get();
        if (!file.exists()) {
            if (!file.mkdirs()) {
                VolleyLog.e("Unable to create cache dir %s", file.getAbsolutePath());
            }
            return;
        }
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return;
        }
        for (File file2 : listFiles) {
            try {
                long length = file2.length();
                CountingInputStream countingInputStream = new CountingInputStream(new BufferedInputStream(createInputStream(file2)), length);
                try {
                    CacheHeader readHeader = CacheHeader.readHeader(countingInputStream);
                    readHeader.size = length;
                    putEntry(readHeader.key, readHeader);
                    countingInputStream.close();
                } catch (Throwable th) {
                    countingInputStream.close();
                    throw th;
                    break;
                }
            } catch (IOException unused) {
                file2.delete();
            }
        }
    }

    @Override // com.android.volley.Cache
    public synchronized void invalidate(String str, boolean z) {
        Cache.Entry entry = get(str);
        if (entry != null) {
            entry.softTtl = 0L;
            if (z) {
                entry.ttl = 0L;
            }
            put(str, entry);
        }
    }

    @Override // com.android.volley.Cache
    public synchronized void put(String str, Cache.Entry entry) {
        BufferedOutputStream bufferedOutputStream;
        CacheHeader cacheHeader;
        if (this.mTotalSize + entry.data.length > this.mMaxCacheSizeInBytes) {
            if (entry.data.length > this.mMaxCacheSizeInBytes * HYSTERESIS_FACTOR) {
                return;
            }
        }
        File fileForKey = getFileForKey(str);
        try {
            bufferedOutputStream = new BufferedOutputStream(createOutputStream(fileForKey));
            cacheHeader = new CacheHeader(str, entry);
        } catch (IOException unused) {
            if (!fileForKey.delete()) {
                VolleyLog.d("Could not clean up file %s", fileForKey.getAbsolutePath());
            }
            initializeIfRootDirectoryDeleted();
        }
        if (!cacheHeader.writeHeader(bufferedOutputStream)) {
            bufferedOutputStream.close();
            VolleyLog.d("Failed to write header for %s", fileForKey.getAbsolutePath());
            throw new IOException();
        }
        bufferedOutputStream.write(entry.data);
        bufferedOutputStream.close();
        cacheHeader.size = fileForKey.length();
        putEntry(str, cacheHeader);
        pruneIfNeeded();
    }

    @Override // com.android.volley.Cache
    public synchronized void remove(String str) {
        boolean delete = getFileForKey(str).delete();
        removeEntry(str);
        if (!delete) {
            VolleyLog.d("Could not delete cache entry for key=%s, filename=%s", str, getFilenameForKey(str));
        }
    }

    private String getFilenameForKey(String str) {
        int length = str.length() / 2;
        return String.valueOf(str.substring(0, length).hashCode()) + String.valueOf(str.substring(length).hashCode());
    }

    public File getFileForKey(String str) {
        return new File(this.mRootDirectorySupplier.get(), getFilenameForKey(str));
    }

    private void initializeIfRootDirectoryDeleted() {
        if (this.mRootDirectorySupplier.get().exists()) {
            return;
        }
        VolleyLog.d("Re-initializing cache after external clearing.", new Object[0]);
        this.mEntries.clear();
        this.mTotalSize = 0L;
        initialize();
    }

    private void pruneIfNeeded() {
        if (this.mTotalSize < this.mMaxCacheSizeInBytes) {
            return;
        }
        int i = 0;
        if (VolleyLog.DEBUG) {
            VolleyLog.v("Pruning old cache entries.", new Object[0]);
        }
        long j = this.mTotalSize;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        Iterator<Map.Entry<String, CacheHeader>> it = this.mEntries.entrySet().iterator();
        while (it.hasNext()) {
            CacheHeader value = it.next().getValue();
            if (getFileForKey(value.key).delete()) {
                this.mTotalSize -= value.size;
            } else {
                VolleyLog.d("Could not delete cache entry for key=%s, filename=%s", value.key, getFilenameForKey(value.key));
            }
            it.remove();
            i++;
            if (((float) this.mTotalSize) < this.mMaxCacheSizeInBytes * HYSTERESIS_FACTOR) {
                break;
            }
        }
        if (VolleyLog.DEBUG) {
            VolleyLog.v("pruned %d files, %d bytes, %d ms", Integer.valueOf(i), Long.valueOf(this.mTotalSize - j), Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime));
        }
    }

    private void putEntry(String str, CacheHeader cacheHeader) {
        if (!this.mEntries.containsKey(str)) {
            this.mTotalSize += cacheHeader.size;
        } else {
            this.mTotalSize += cacheHeader.size - this.mEntries.get(str).size;
        }
        this.mEntries.put(str, cacheHeader);
    }

    private void removeEntry(String str) {
        CacheHeader remove = this.mEntries.remove(str);
        if (remove != null) {
            this.mTotalSize -= remove.size;
        }
    }

    static byte[] streamToBytes(CountingInputStream countingInputStream, long j) throws IOException {
        long bytesRemaining = countingInputStream.bytesRemaining();
        if (j >= 0 && j <= bytesRemaining) {
            int i = (int) j;
            if (i == j) {
                byte[] bArr = new byte[i];
                new DataInputStream(countingInputStream).readFully(bArr);
                return bArr;
            }
        }
        throw new IOException("streamToBytes length=" + j + ", maxLength=" + bytesRemaining);
    }

    InputStream createInputStream(File file) throws FileNotFoundException {
        return new FileInputStream(file);
    }

    OutputStream createOutputStream(File file) throws FileNotFoundException {
        return new FileOutputStream(file);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class CacheHeader {
        final List<Header> allResponseHeaders;
        final String etag;
        final String key;
        final long lastModified;
        final long serverDate;
        long size;
        final long softTtl;
        final long ttl;

        private CacheHeader(String str, String str2, long j, long j2, long j3, long j4, List<Header> list) {
            this.key = str;
            this.etag = "".equals(str2) ? null : str2;
            this.serverDate = j;
            this.lastModified = j2;
            this.ttl = j3;
            this.softTtl = j4;
            this.allResponseHeaders = list;
        }

        CacheHeader(String str, Cache.Entry entry) {
            this(str, entry.etag, entry.serverDate, entry.lastModified, entry.ttl, entry.softTtl, getAllResponseHeaders(entry));
        }

        private static List<Header> getAllResponseHeaders(Cache.Entry entry) {
            if (entry.allResponseHeaders != null) {
                return entry.allResponseHeaders;
            }
            return HttpHeaderParser.toAllHeaderList(entry.responseHeaders);
        }

        static CacheHeader readHeader(CountingInputStream countingInputStream) throws IOException {
            if (DiskBasedCache.readInt(countingInputStream) != DiskBasedCache.CACHE_MAGIC) {
                throw new IOException();
            }
            return new CacheHeader(DiskBasedCache.readString(countingInputStream), DiskBasedCache.readString(countingInputStream), DiskBasedCache.readLong(countingInputStream), DiskBasedCache.readLong(countingInputStream), DiskBasedCache.readLong(countingInputStream), DiskBasedCache.readLong(countingInputStream), DiskBasedCache.readHeaderList(countingInputStream));
        }

        Cache.Entry toCacheEntry(byte[] bArr) {
            Cache.Entry entry = new Cache.Entry();
            entry.data = bArr;
            entry.etag = this.etag;
            entry.serverDate = this.serverDate;
            entry.lastModified = this.lastModified;
            entry.ttl = this.ttl;
            entry.softTtl = this.softTtl;
            entry.responseHeaders = HttpHeaderParser.toHeaderMap(this.allResponseHeaders);
            entry.allResponseHeaders = Collections.unmodifiableList(this.allResponseHeaders);
            return entry;
        }

        boolean writeHeader(OutputStream outputStream) {
            try {
                DiskBasedCache.writeInt(outputStream, DiskBasedCache.CACHE_MAGIC);
                DiskBasedCache.writeString(outputStream, this.key);
                String str = this.etag;
                if (str == null) {
                    str = "";
                }
                DiskBasedCache.writeString(outputStream, str);
                DiskBasedCache.writeLong(outputStream, this.serverDate);
                DiskBasedCache.writeLong(outputStream, this.lastModified);
                DiskBasedCache.writeLong(outputStream, this.ttl);
                DiskBasedCache.writeLong(outputStream, this.softTtl);
                DiskBasedCache.writeHeaderList(this.allResponseHeaders, outputStream);
                outputStream.flush();
                return true;
            } catch (IOException e) {
                VolleyLog.d("%s", e.toString());
                return false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class CountingInputStream extends FilterInputStream {
        private long bytesRead;
        private final long length;

        CountingInputStream(InputStream inputStream, long j) {
            super(inputStream);
            this.length = j;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read() throws IOException {
            int read = super.read();
            if (read != -1) {
                this.bytesRead++;
            }
            return read;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] bArr, int i, int i2) throws IOException {
            int read = super.read(bArr, i, i2);
            if (read != -1) {
                this.bytesRead += read;
            }
            return read;
        }

        long bytesRead() {
            return this.bytesRead;
        }

        long bytesRemaining() {
            return this.length - this.bytesRead;
        }
    }

    private static int read(InputStream inputStream) throws IOException {
        int read = inputStream.read();
        if (read != -1) {
            return read;
        }
        throw new EOFException();
    }

    static void writeInt(OutputStream outputStream, int i) throws IOException {
        outputStream.write(i & 255);
        outputStream.write((i >> 8) & 255);
        outputStream.write((i >> 16) & 255);
        outputStream.write((i >> 24) & 255);
    }

    static int readInt(InputStream inputStream) throws IOException {
        return (read(inputStream) << 24) | read(inputStream) | (read(inputStream) << 8) | (read(inputStream) << 16);
    }

    static void writeLong(OutputStream outputStream, long j) throws IOException {
        outputStream.write((byte) j);
        outputStream.write((byte) (j >>> 8));
        outputStream.write((byte) (j >>> 16));
        outputStream.write((byte) (j >>> 24));
        outputStream.write((byte) (j >>> 32));
        outputStream.write((byte) (j >>> 40));
        outputStream.write((byte) (j >>> 48));
        outputStream.write((byte) (j >>> 56));
    }

    static long readLong(InputStream inputStream) throws IOException {
        return (read(inputStream) & 255) | ((read(inputStream) & 255) << 8) | ((read(inputStream) & 255) << 16) | ((read(inputStream) & 255) << 24) | ((read(inputStream) & 255) << 32) | ((read(inputStream) & 255) << 40) | ((read(inputStream) & 255) << 48) | ((255 & read(inputStream)) << 56);
    }

    static void writeString(OutputStream outputStream, String str) throws IOException {
        byte[] bytes = str.getBytes("UTF-8");
        writeLong(outputStream, bytes.length);
        outputStream.write(bytes, 0, bytes.length);
    }

    static String readString(CountingInputStream countingInputStream) throws IOException {
        return new String(streamToBytes(countingInputStream, readLong(countingInputStream)), "UTF-8");
    }

    static void writeHeaderList(List<Header> list, OutputStream outputStream) throws IOException {
        if (list != null) {
            writeInt(outputStream, list.size());
            for (Header header : list) {
                writeString(outputStream, header.getName());
                writeString(outputStream, header.getValue());
            }
            return;
        }
        writeInt(outputStream, 0);
    }

    static List<Header> readHeaderList(CountingInputStream countingInputStream) throws IOException {
        int readInt = readInt(countingInputStream);
        if (readInt < 0) {
            throw new IOException("readHeaderList size=" + readInt);
        }
        List<Header> emptyList = readInt == 0 ? Collections.emptyList() : new ArrayList<>();
        for (int i = 0; i < readInt; i++) {
            emptyList.add(new Header(readString(countingInputStream).intern(), readString(countingInputStream).intern()));
        }
        return emptyList;
    }
}
