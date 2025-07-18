package okhttp3;

import androidx.collection.SieveCacheKt;
import androidx.media3.extractor.text.ttml.TtmlNode;
import coil3.network.internal.UtilsKt;
import com.google.common.net.HttpHeaders;
import java.io.Closeable;
import java.io.File;
import java.io.Flushable;
import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import okhttp3.Headers;
import okhttp3.Response;
import okhttp3.internal._UtilCommonKt;
import okhttp3.internal.cache.CacheRequest;
import okhttp3.internal.cache.CacheStrategy;
import okhttp3.internal.cache.DiskLruCache;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.http.HttpMethod;
import okhttp3.internal.http.StatusLine;
import okhttp3.internal.platform.Platform;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.FileSystem;
import okio.ForwardingSink;
import okio.ForwardingSource;
import okio.Okio;
import okio.Path;
import okio.Sink;
import okio.Source;
/* compiled from: Cache.kt */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010)\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 L2\u00020\u00012\u00020\u0002:\u0004IJKLB)\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fB!\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u000b\u0010\rB\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u000e\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u000b\u0010\u000fJ\u0017\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010%\u001a\u00020&H\u0000¢\u0006\u0002\b'J\u0017\u0010(\u001a\u0004\u0018\u00010)2\u0006\u0010*\u001a\u00020$H\u0000¢\u0006\u0002\b+J\u0015\u0010,\u001a\u00020-2\u0006\u0010%\u001a\u00020&H\u0000¢\u0006\u0002\b.J\u001d\u0010/\u001a\u00020-2\u0006\u00100\u001a\u00020$2\u0006\u00101\u001a\u00020$H\u0000¢\u0006\u0002\b2J\u0016\u00103\u001a\u00020-2\f\u00104\u001a\b\u0018\u000105R\u00020\u0011H\u0002J\u0006\u00106\u001a\u00020-J\u0006\u00107\u001a\u00020-J\u0006\u00108\u001a\u00020-J\f\u00109\u001a\b\u0012\u0004\u0012\u00020;0:J\u0006\u0010\u001a\u001a\u00020\u0015J\u0006\u0010\u0014\u001a\u00020\u0015J\u0006\u0010<\u001a\u00020\u0006J\u0006\u0010\u0005\u001a\u00020\u0006J\b\u0010=\u001a\u00020-H\u0016J\b\u0010>\u001a\u00020-H\u0016J\r\u0010\u0003\u001a\u00020\u000eH\u0007¢\u0006\u0002\bBJ\u0015\u0010C\u001a\u00020-2\u0006\u0010D\u001a\u00020EH\u0000¢\u0006\u0002\bFJ\r\u0010G\u001a\u00020-H\u0000¢\u0006\u0002\bHJ\u0006\u0010\u001d\u001a\u00020\u0015J\u0006\u0010\u001e\u001a\u00020\u0015J\u0006\u0010\u001f\u001a\u00020\u0015R\u0014\u0010\u0010\u001a\u00020\u0011X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0015X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u0015X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019R\u000e\u0010\u001d\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010 \u001a\u00020!8F¢\u0006\u0006\u001a\u0004\b \u0010\"R\u0011\u0010\u0003\u001a\u00020\u000e8G¢\u0006\u0006\u001a\u0004\b\u0003\u0010?R\u0011\u0010@\u001a\u00020\u00048G¢\u0006\u0006\u001a\u0004\b@\u0010A¨\u0006M"}, d2 = {"Lokhttp3/Cache;", "Ljava/io/Closeable;", "Ljava/io/Flushable;", "directory", "Lokio/Path;", "maxSize", "", "fileSystem", "Lokio/FileSystem;", "taskRunner", "Lokhttp3/internal/concurrent/TaskRunner;", "<init>", "(Lokio/Path;JLokio/FileSystem;Lokhttp3/internal/concurrent/TaskRunner;)V", "(Lokio/FileSystem;Lokio/Path;J)V", "Ljava/io/File;", "(Ljava/io/File;J)V", "cache", "Lokhttp3/internal/cache/DiskLruCache;", "getCache$okhttp", "()Lokhttp3/internal/cache/DiskLruCache;", "writeSuccessCount", "", "getWriteSuccessCount$okhttp", "()I", "setWriteSuccessCount$okhttp", "(I)V", "writeAbortCount", "getWriteAbortCount$okhttp", "setWriteAbortCount$okhttp", "networkCount", "hitCount", "requestCount", "isClosed", "", "()Z", "get", "Lokhttp3/Response;", "request", "Lokhttp3/Request;", "get$okhttp", "put", "Lokhttp3/internal/cache/CacheRequest;", "response", "put$okhttp", "remove", "", "remove$okhttp", "update", "cached", "network", "update$okhttp", "abortQuietly", "editor", "Lokhttp3/internal/cache/DiskLruCache$Editor;", "initialize", "delete", "evictAll", "urls", "", "", "size", "flush", "close", "()Ljava/io/File;", "directoryPath", "()Lokio/Path;", "-deprecated_directory", "trackResponse", "cacheStrategy", "Lokhttp3/internal/cache/CacheStrategy;", "trackResponse$okhttp", "trackConditionalCacheHit", "trackConditionalCacheHit$okhttp", "RealCacheRequest", "Entry", "CacheResponseBody", "Companion", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class Cache implements Closeable, Flushable {
    public static final Companion Companion = new Companion(null);
    private static final int ENTRY_BODY = 1;
    private static final int ENTRY_COUNT = 2;
    private static final int ENTRY_METADATA = 0;
    private static final int VERSION = 201105;
    private final DiskLruCache cache;
    private int hitCount;
    private int networkCount;
    private int requestCount;
    private int writeAbortCount;
    private int writeSuccessCount;

    @JvmStatic
    public static final String key(HttpUrl httpUrl) {
        return Companion.key(httpUrl);
    }

    public Cache(Path directory, long j, FileSystem fileSystem, TaskRunner taskRunner) {
        Intrinsics.checkNotNullParameter(directory, "directory");
        Intrinsics.checkNotNullParameter(fileSystem, "fileSystem");
        Intrinsics.checkNotNullParameter(taskRunner, "taskRunner");
        this.cache = new DiskLruCache(fileSystem, directory, VERSION, 2, j, taskRunner);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Cache(FileSystem fileSystem, Path directory, long j) {
        this(directory, j, fileSystem, TaskRunner.INSTANCE);
        Intrinsics.checkNotNullParameter(fileSystem, "fileSystem");
        Intrinsics.checkNotNullParameter(directory, "directory");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Cache(File directory, long j) {
        this(FileSystem.SYSTEM, Path.Companion.get$default(Path.Companion, directory, false, 1, (Object) null), j);
        Intrinsics.checkNotNullParameter(directory, "directory");
    }

    public final DiskLruCache getCache$okhttp() {
        return this.cache;
    }

    public final int getWriteSuccessCount$okhttp() {
        return this.writeSuccessCount;
    }

    public final void setWriteSuccessCount$okhttp(int i) {
        this.writeSuccessCount = i;
    }

    public final int getWriteAbortCount$okhttp() {
        return this.writeAbortCount;
    }

    public final void setWriteAbortCount$okhttp(int i) {
        this.writeAbortCount = i;
    }

    public final boolean isClosed() {
        return this.cache.isClosed();
    }

    public final Response get$okhttp(Request request) {
        Intrinsics.checkNotNullParameter(request, "request");
        try {
            DiskLruCache.Snapshot snapshot = this.cache.get(Companion.key(request.url()));
            if (snapshot == null) {
                return null;
            }
            try {
                Entry entry = new Entry(snapshot.getSource(0));
                Response response = entry.response(snapshot);
                if (entry.matches(request, response)) {
                    return response;
                }
                _UtilCommonKt.closeQuietly(response.body());
                return null;
            } catch (IOException unused) {
                _UtilCommonKt.closeQuietly(snapshot);
                return null;
            }
        } catch (IOException unused2) {
        }
    }

    public final CacheRequest put$okhttp(Response response) {
        DiskLruCache.Editor editor;
        Intrinsics.checkNotNullParameter(response, "response");
        String method = response.request().method();
        if (HttpMethod.invalidatesCache(response.request().method())) {
            try {
                remove$okhttp(response.request());
            } catch (IOException unused) {
            }
            return null;
        } else if (!Intrinsics.areEqual(method, UtilsKt.HTTP_METHOD_GET)) {
            return null;
        } else {
            Companion companion = Companion;
            if (companion.hasVaryAll(response)) {
                return null;
            }
            Entry entry = new Entry(response);
            try {
                editor = DiskLruCache.edit$default(this.cache, companion.key(response.request().url()), 0L, 2, null);
                if (editor == null) {
                    return null;
                }
                try {
                    entry.writeTo(editor);
                    return new RealCacheRequest(this, editor);
                } catch (IOException unused2) {
                    abortQuietly(editor);
                    return null;
                }
            } catch (IOException unused3) {
                editor = null;
            }
        }
    }

    public final void remove$okhttp(Request request) throws IOException {
        Intrinsics.checkNotNullParameter(request, "request");
        this.cache.remove(Companion.key(request.url()));
    }

    public final void update$okhttp(Response cached, Response network) {
        DiskLruCache.Editor editor;
        Intrinsics.checkNotNullParameter(cached, "cached");
        Intrinsics.checkNotNullParameter(network, "network");
        Entry entry = new Entry(network);
        ResponseBody body = cached.body();
        Intrinsics.checkNotNull(body, "null cannot be cast to non-null type okhttp3.Cache.CacheResponseBody");
        try {
            editor = ((CacheResponseBody) body).getSnapshot().edit();
            if (editor == null) {
                return;
            }
            try {
                entry.writeTo(editor);
                editor.commit();
            } catch (IOException unused) {
                abortQuietly(editor);
            }
        } catch (IOException unused2) {
            editor = null;
        }
    }

    private final void abortQuietly(DiskLruCache.Editor editor) {
        if (editor != null) {
            try {
                editor.abort();
            } catch (IOException unused) {
            }
        }
    }

    public final void initialize() throws IOException {
        this.cache.initialize();
    }

    public final void delete() throws IOException {
        this.cache.delete();
    }

    public final void evictAll() throws IOException {
        this.cache.evictAll();
    }

    public final Iterator<String> urls() throws IOException {
        return new Cache$urls$1(this);
    }

    public final synchronized int writeAbortCount() {
        return this.writeAbortCount;
    }

    public final synchronized int writeSuccessCount() {
        return this.writeSuccessCount;
    }

    public final long size() throws IOException {
        return this.cache.size();
    }

    public final long maxSize() {
        return this.cache.getMaxSize();
    }

    @Override // java.io.Flushable
    public void flush() throws IOException {
        this.cache.flush();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.cache.close();
    }

    public final File directory() {
        return this.cache.getDirectory().toFile();
    }

    public final Path directoryPath() {
        return this.cache.getDirectory();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "directory", imports = {}))
    /* renamed from: -deprecated_directory  reason: not valid java name */
    public final File m10237deprecated_directory() {
        return this.cache.getDirectory().toFile();
    }

    public final synchronized void trackResponse$okhttp(CacheStrategy cacheStrategy) {
        Intrinsics.checkNotNullParameter(cacheStrategy, "cacheStrategy");
        this.requestCount++;
        if (cacheStrategy.getNetworkRequest() != null) {
            this.networkCount++;
        } else if (cacheStrategy.getCacheResponse() != null) {
            this.hitCount++;
        }
    }

    public final synchronized void trackConditionalCacheHit$okhttp() {
        this.hitCount++;
    }

    public final synchronized int networkCount() {
        return this.networkCount;
    }

    public final synchronized int hitCount() {
        return this.hitCount;
    }

    public final synchronized int requestCount() {
        return this.requestCount;
    }

    /* compiled from: Cache.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\u0002\u001a\u00060\u0003R\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\t\u001a\u00020\bH\u0016R\u0012\u0010\u0002\u001a\u00060\u0003R\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lokhttp3/Cache$RealCacheRequest;", "Lokhttp3/internal/cache/CacheRequest;", "editor", "Lokhttp3/internal/cache/DiskLruCache$Editor;", "Lokhttp3/internal/cache/DiskLruCache;", "<init>", "(Lokhttp3/Cache;Lokhttp3/internal/cache/DiskLruCache$Editor;)V", "cacheOut", "Lokio/Sink;", TtmlNode.TAG_BODY, "done", "", "getDone", "()Z", "setDone", "(Z)V", "abort", "", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    private final class RealCacheRequest implements CacheRequest {
        private final Sink body;
        private final Sink cacheOut;
        private boolean done;
        private final DiskLruCache.Editor editor;
        final /* synthetic */ Cache this$0;

        public RealCacheRequest(final Cache cache, DiskLruCache.Editor editor) {
            Intrinsics.checkNotNullParameter(editor, "editor");
            this.this$0 = cache;
            this.editor = editor;
            Sink newSink = editor.newSink(1);
            this.cacheOut = newSink;
            this.body = new ForwardingSink(newSink) { // from class: okhttp3.Cache.RealCacheRequest.1
                @Override // okio.ForwardingSink, okio.Sink, java.io.Closeable, java.lang.AutoCloseable
                public void close() throws IOException {
                    Cache cache2 = Cache.this;
                    RealCacheRequest realCacheRequest = this;
                    synchronized (cache2) {
                        if (realCacheRequest.getDone()) {
                            return;
                        }
                        realCacheRequest.setDone(true);
                        cache2.setWriteSuccessCount$okhttp(cache2.getWriteSuccessCount$okhttp() + 1);
                        super.close();
                        this.editor.commit();
                    }
                }
            };
        }

        public final boolean getDone() {
            return this.done;
        }

        public final void setDone(boolean z) {
            this.done = z;
        }

        @Override // okhttp3.internal.cache.CacheRequest
        public void abort() {
            Cache cache = this.this$0;
            synchronized (cache) {
                if (this.done) {
                    return;
                }
                this.done = true;
                cache.setWriteAbortCount$okhttp(cache.getWriteAbortCount$okhttp() + 1);
                _UtilCommonKt.closeQuietly(this.cacheOut);
                try {
                    this.editor.abort();
                } catch (IOException unused) {
                }
            }
        }

        @Override // okhttp3.internal.cache.CacheRequest
        public Sink body() {
            return this.body;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Cache.kt */
    @Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u0000 .2\u00020\u0001:\u0001.B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0011\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bJ\u0012\u0010\u001a\u001a\u00020\u001b2\n\u0010\u001c\u001a\u00060\u001dR\u00020\u001eJ\u0016\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 2\u0006\u0010\"\u001a\u00020#H\u0002J\u001e\u0010$\u001a\u00020\u001b2\u0006\u0010%\u001a\u00020&2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020!0 H\u0002J\u0016\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010\u0006\u001a\u00020\u0007J\u0012\u0010\u0006\u001a\u00020\u00072\n\u0010,\u001a\u00060-R\u00020\u001eR\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lokhttp3/Cache$Entry;", "", "rawSource", "Lokio/Source;", "<init>", "(Lokio/Source;)V", "response", "Lokhttp3/Response;", "(Lokhttp3/Response;)V", "url", "Lokhttp3/HttpUrl;", "varyHeaders", "Lokhttp3/Headers;", "requestMethod", "", "protocol", "Lokhttp3/Protocol;", "code", "", "message", "responseHeaders", "handshake", "Lokhttp3/Handshake;", "sentRequestMillis", "", "receivedResponseMillis", "writeTo", "", "editor", "Lokhttp3/internal/cache/DiskLruCache$Editor;", "Lokhttp3/internal/cache/DiskLruCache;", "readCertificateList", "", "Ljava/security/cert/Certificate;", "source", "Lokio/BufferedSource;", "writeCertList", "sink", "Lokio/BufferedSink;", "certificates", "matches", "", "request", "Lokhttp3/Request;", "snapshot", "Lokhttp3/internal/cache/DiskLruCache$Snapshot;", "Companion", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Entry {
        private final int code;
        private final Handshake handshake;
        private final String message;
        private final Protocol protocol;
        private final long receivedResponseMillis;
        private final String requestMethod;
        private final Headers responseHeaders;
        private final long sentRequestMillis;
        private final HttpUrl url;
        private final Headers varyHeaders;
        public static final Companion Companion = new Companion(null);
        private static final String SENT_MILLIS = Platform.Companion.get().getPrefix() + "-Sent-Millis";
        private static final String RECEIVED_MILLIS = Platform.Companion.get().getPrefix() + "-Received-Millis";

        public Entry(Source rawSource) throws IOException {
            TlsVersion tlsVersion;
            Intrinsics.checkNotNullParameter(rawSource, "rawSource");
            Source source = rawSource;
            try {
                Source source2 = source;
                BufferedSource buffer = Okio.buffer(rawSource);
                String readUtf8LineStrict = buffer.readUtf8LineStrict();
                HttpUrl parse = HttpUrl.Companion.parse(readUtf8LineStrict);
                if (parse == null) {
                    IOException iOException = new IOException("Cache corruption for " + readUtf8LineStrict);
                    Platform.Companion.get().log("cache corruption", 5, iOException);
                    throw iOException;
                }
                this.url = parse;
                this.requestMethod = buffer.readUtf8LineStrict();
                Headers.Builder builder = new Headers.Builder();
                int readInt$okhttp = Cache.Companion.readInt$okhttp(buffer);
                for (int i = 0; i < readInt$okhttp; i++) {
                    builder.addLenient$okhttp(buffer.readUtf8LineStrict());
                }
                this.varyHeaders = builder.build();
                StatusLine parse2 = StatusLine.Companion.parse(buffer.readUtf8LineStrict());
                this.protocol = parse2.protocol;
                this.code = parse2.code;
                this.message = parse2.message;
                Headers.Builder builder2 = new Headers.Builder();
                int readInt$okhttp2 = Cache.Companion.readInt$okhttp(buffer);
                for (int i2 = 0; i2 < readInt$okhttp2; i2++) {
                    builder2.addLenient$okhttp(buffer.readUtf8LineStrict());
                }
                String str = SENT_MILLIS;
                String str2 = builder2.get(str);
                String str3 = RECEIVED_MILLIS;
                String str4 = builder2.get(str3);
                builder2.removeAll(str);
                builder2.removeAll(str3);
                this.sentRequestMillis = str2 != null ? Long.parseLong(str2) : 0L;
                this.receivedResponseMillis = str4 != null ? Long.parseLong(str4) : 0L;
                this.responseHeaders = builder2.build();
                if (this.url.isHttps()) {
                    String readUtf8LineStrict2 = buffer.readUtf8LineStrict();
                    if (readUtf8LineStrict2.length() > 0) {
                        throw new IOException("expected \"\" but was \"" + readUtf8LineStrict2 + '\"');
                    }
                    CipherSuite forJavaName = CipherSuite.Companion.forJavaName(buffer.readUtf8LineStrict());
                    List<Certificate> readCertificateList = readCertificateList(buffer);
                    List<Certificate> readCertificateList2 = readCertificateList(buffer);
                    if (!buffer.exhausted()) {
                        tlsVersion = TlsVersion.Companion.forJavaName(buffer.readUtf8LineStrict());
                    } else {
                        tlsVersion = TlsVersion.SSL_3_0;
                    }
                    this.handshake = Handshake.Companion.get(tlsVersion, forJavaName, readCertificateList, readCertificateList2);
                } else {
                    this.handshake = null;
                }
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(source, null);
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(source, th);
                    throw th2;
                }
            }
        }

        public Entry(Response response) {
            Intrinsics.checkNotNullParameter(response, "response");
            this.url = response.request().url();
            this.varyHeaders = Cache.Companion.varyHeaders(response);
            this.requestMethod = response.request().method();
            this.protocol = response.protocol();
            this.code = response.code();
            this.message = response.message();
            this.responseHeaders = response.headers();
            this.handshake = response.handshake();
            this.sentRequestMillis = response.sentRequestAtMillis();
            this.receivedResponseMillis = response.receivedResponseAtMillis();
        }

        public final void writeTo(DiskLruCache.Editor editor) throws IOException {
            Intrinsics.checkNotNullParameter(editor, "editor");
            BufferedSink buffer = Okio.buffer(editor.newSink(0));
            try {
                BufferedSink bufferedSink = buffer;
                bufferedSink.writeUtf8(this.url.toString()).writeByte(10);
                bufferedSink.writeUtf8(this.requestMethod).writeByte(10);
                bufferedSink.writeDecimalLong(this.varyHeaders.size()).writeByte(10);
                int size = this.varyHeaders.size();
                for (int i = 0; i < size; i++) {
                    bufferedSink.writeUtf8(this.varyHeaders.name(i)).writeUtf8(": ").writeUtf8(this.varyHeaders.value(i)).writeByte(10);
                }
                bufferedSink.writeUtf8(new StatusLine(this.protocol, this.code, this.message).toString()).writeByte(10);
                bufferedSink.writeDecimalLong(this.responseHeaders.size() + 2).writeByte(10);
                int size2 = this.responseHeaders.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    bufferedSink.writeUtf8(this.responseHeaders.name(i2)).writeUtf8(": ").writeUtf8(this.responseHeaders.value(i2)).writeByte(10);
                }
                bufferedSink.writeUtf8(SENT_MILLIS).writeUtf8(": ").writeDecimalLong(this.sentRequestMillis).writeByte(10);
                bufferedSink.writeUtf8(RECEIVED_MILLIS).writeUtf8(": ").writeDecimalLong(this.receivedResponseMillis).writeByte(10);
                if (this.url.isHttps()) {
                    bufferedSink.writeByte(10);
                    Handshake handshake = this.handshake;
                    Intrinsics.checkNotNull(handshake);
                    bufferedSink.writeUtf8(handshake.cipherSuite().javaName()).writeByte(10);
                    writeCertList(bufferedSink, this.handshake.peerCertificates());
                    writeCertList(bufferedSink, this.handshake.localCertificates());
                    bufferedSink.writeUtf8(this.handshake.tlsVersion().javaName()).writeByte(10);
                }
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(buffer, null);
            } finally {
            }
        }

        private final List<Certificate> readCertificateList(BufferedSource bufferedSource) throws IOException {
            int readInt$okhttp = Cache.Companion.readInt$okhttp(bufferedSource);
            if (readInt$okhttp == -1) {
                return CollectionsKt.emptyList();
            }
            try {
                CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
                ArrayList arrayList = new ArrayList(readInt$okhttp);
                for (int i = 0; i < readInt$okhttp; i++) {
                    String readUtf8LineStrict = bufferedSource.readUtf8LineStrict();
                    Buffer buffer = new Buffer();
                    ByteString decodeBase64 = ByteString.Companion.decodeBase64(readUtf8LineStrict);
                    if (decodeBase64 == null) {
                        throw new IOException("Corrupt certificate in cache entry");
                    }
                    buffer.write(decodeBase64);
                    arrayList.add(certificateFactory.generateCertificate(buffer.inputStream()));
                }
                return arrayList;
            } catch (CertificateException e) {
                throw new IOException(e.getMessage());
            }
        }

        private final void writeCertList(BufferedSink bufferedSink, List<? extends Certificate> list) throws IOException {
            try {
                bufferedSink.writeDecimalLong(list.size()).writeByte(10);
                for (Certificate certificate : list) {
                    byte[] encoded = certificate.getEncoded();
                    ByteString.Companion companion = ByteString.Companion;
                    Intrinsics.checkNotNull(encoded);
                    bufferedSink.writeUtf8(ByteString.Companion.of$default(companion, encoded, 0, 0, 3, null).base64()).writeByte(10);
                }
            } catch (CertificateEncodingException e) {
                throw new IOException(e.getMessage());
            }
        }

        public final boolean matches(Request request, Response response) {
            Intrinsics.checkNotNullParameter(request, "request");
            Intrinsics.checkNotNullParameter(response, "response");
            return Intrinsics.areEqual(this.url, request.url()) && Intrinsics.areEqual(this.requestMethod, request.method()) && Cache.Companion.varyMatches(response, this.varyHeaders, request);
        }

        public final Response response(DiskLruCache.Snapshot snapshot) {
            Intrinsics.checkNotNullParameter(snapshot, "snapshot");
            String str = this.responseHeaders.get("Content-Type");
            String str2 = this.responseHeaders.get("Content-Length");
            return new Response.Builder().request(new Request(this.url, this.varyHeaders, this.requestMethod, null, 8, null)).protocol(this.protocol).code(this.code).message(this.message).headers(this.responseHeaders).body(new CacheResponseBody(snapshot, str, str2)).handshake(this.handshake).sentRequestAtMillis(this.sentRequestMillis).receivedResponseAtMillis(this.receivedResponseMillis).build();
        }

        /* compiled from: Cache.kt */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lokhttp3/Cache$Entry$Companion;", "", "<init>", "()V", "SENT_MILLIS", "", "RECEIVED_MILLIS", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Cache.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B'\u0012\n\u0010\u0002\u001a\u00060\u0003R\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\n\u0010\u0005\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u0007\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\rH\u0016R\u0015\u0010\u0002\u001a\u00060\u0003R\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lokhttp3/Cache$CacheResponseBody;", "Lokhttp3/ResponseBody;", "snapshot", "Lokhttp3/internal/cache/DiskLruCache$Snapshot;", "Lokhttp3/internal/cache/DiskLruCache;", "contentType", "", "contentLength", "<init>", "(Lokhttp3/internal/cache/DiskLruCache$Snapshot;Ljava/lang/String;Ljava/lang/String;)V", "getSnapshot", "()Lokhttp3/internal/cache/DiskLruCache$Snapshot;", "bodySource", "Lokio/BufferedSource;", "Lokhttp3/MediaType;", "", "source", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class CacheResponseBody extends ResponseBody {
        private final BufferedSource bodySource;
        private final String contentLength;
        private final String contentType;
        private final DiskLruCache.Snapshot snapshot;

        public final DiskLruCache.Snapshot getSnapshot() {
            return this.snapshot;
        }

        public CacheResponseBody(DiskLruCache.Snapshot snapshot, String str, String str2) {
            Intrinsics.checkNotNullParameter(snapshot, "snapshot");
            this.snapshot = snapshot;
            this.contentType = str;
            this.contentLength = str2;
            this.bodySource = Okio.buffer(new ForwardingSource(snapshot.getSource(1)) { // from class: okhttp3.Cache.CacheResponseBody.1
                @Override // okio.ForwardingSource, okio.Source, java.io.Closeable, java.lang.AutoCloseable
                public void close() throws IOException {
                    this.getSnapshot().close();
                    super.close();
                }
            });
        }

        @Override // okhttp3.ResponseBody
        public MediaType contentType() {
            String str = this.contentType;
            if (str != null) {
                return MediaType.Companion.parse(str);
            }
            return null;
        }

        @Override // okhttp3.ResponseBody
        public long contentLength() {
            String str = this.contentLength;
            if (str != null) {
                return _UtilCommonKt.toLongOrDefault(str, -1L);
            }
            return -1L;
        }

        @Override // okhttp3.ResponseBody
        public BufferedSource source() {
            return this.bodySource;
        }
    }

    /* compiled from: Cache.kt */
    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u0015\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000fH\u0000¢\u0006\u0002\b\u0010J\u001e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018J\n\u0010\u0019\u001a\u00020\u0012*\u00020\u0014J\u0012\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\n0\u001b*\u00020\u0016H\u0002J\n\u0010\u001c\u001a\u00020\u0016*\u00020\u0014J\u0018\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u0016H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lokhttp3/Cache$Companion;", "", "<init>", "()V", "VERSION", "", "ENTRY_METADATA", "ENTRY_BODY", "ENTRY_COUNT", "key", "", "url", "Lokhttp3/HttpUrl;", "readInt", "source", "Lokio/BufferedSource;", "readInt$okhttp", "varyMatches", "", "cachedResponse", "Lokhttp3/Response;", "cachedRequest", "Lokhttp3/Headers;", "newRequest", "Lokhttp3/Request;", "hasVaryAll", "varyFields", "", "varyHeaders", "requestHeaders", "responseHeaders", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final String key(HttpUrl url) {
            Intrinsics.checkNotNullParameter(url, "url");
            return ByteString.Companion.encodeUtf8(url.toString()).md5().hex();
        }

        public final int readInt$okhttp(BufferedSource source) throws IOException {
            Intrinsics.checkNotNullParameter(source, "source");
            try {
                long readDecimalLong = source.readDecimalLong();
                String readUtf8LineStrict = source.readUtf8LineStrict();
                if (readDecimalLong < 0 || readDecimalLong > SieveCacheKt.NodeLinkMask || readUtf8LineStrict.length() > 0) {
                    throw new IOException("expected an int but was \"" + readDecimalLong + readUtf8LineStrict + '\"');
                }
                return (int) readDecimalLong;
            } catch (NumberFormatException e) {
                throw new IOException(e.getMessage());
            }
        }

        public final boolean varyMatches(Response cachedResponse, Headers cachedRequest, Request newRequest) {
            Intrinsics.checkNotNullParameter(cachedResponse, "cachedResponse");
            Intrinsics.checkNotNullParameter(cachedRequest, "cachedRequest");
            Intrinsics.checkNotNullParameter(newRequest, "newRequest");
            Set<String> varyFields = varyFields(cachedResponse.headers());
            if ((varyFields instanceof Collection) && varyFields.isEmpty()) {
                return true;
            }
            for (String str : varyFields) {
                if (!Intrinsics.areEqual(cachedRequest.values(str), newRequest.headers(str))) {
                    return false;
                }
            }
            return true;
        }

        public final boolean hasVaryAll(Response response) {
            Intrinsics.checkNotNullParameter(response, "<this>");
            return varyFields(response.headers()).contains("*");
        }

        private final Set<String> varyFields(Headers headers) {
            int size = headers.size();
            TreeSet treeSet = null;
            for (int i = 0; i < size; i++) {
                if (StringsKt.equals(HttpHeaders.VARY, headers.name(i), true)) {
                    String value = headers.value(i);
                    if (treeSet == null) {
                        treeSet = new TreeSet(StringsKt.getCASE_INSENSITIVE_ORDER(StringCompanionObject.INSTANCE));
                    }
                    for (String str : StringsKt.split$default((CharSequence) value, new char[]{AbstractJsonLexerKt.COMMA}, false, 0, 6, (Object) null)) {
                        treeSet.add(StringsKt.trim((CharSequence) str).toString());
                    }
                }
            }
            return treeSet == null ? SetsKt.emptySet() : treeSet;
        }

        public final Headers varyHeaders(Response response) {
            Intrinsics.checkNotNullParameter(response, "<this>");
            Response networkResponse = response.networkResponse();
            Intrinsics.checkNotNull(networkResponse);
            return varyHeaders(networkResponse.request().headers(), response.headers());
        }

        private final Headers varyHeaders(Headers headers, Headers headers2) {
            Set<String> varyFields = varyFields(headers2);
            if (varyFields.isEmpty()) {
                return Headers.EMPTY;
            }
            Headers.Builder builder = new Headers.Builder();
            int size = headers.size();
            for (int i = 0; i < size; i++) {
                String name = headers.name(i);
                if (varyFields.contains(name)) {
                    builder.add(name, headers.value(i));
                }
            }
            return builder.build();
        }
    }
}
