package io.appmetrica.analytics.coreutils.internal.io;

import coil3.util.UtilsKt;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
import io.appmetrica.analytics.coreutils.internal.buffering.BatchProcessor;
import io.appmetrica.analytics.coreutils.internal.buffering.DeferredBatchExecutor;
import io.appmetrica.analytics.coreutils.internal.buffering.LastValueTaskBuffer;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.FilesKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002J\u0006\u0010\u0007\u001a\u00020\u0004J\u0006\u0010\b\u001a\u00020\u0004¨\u0006\u0011"}, d2 = {"Lio/appmetrica/analytics/coreutils/internal/io/BufferedFileWriter;", "", "", "value", "", "writeString", "readString", "flush", "flushAsync", "Lio/appmetrica/analytics/coreapi/internal/executors/IHandlerExecutor;", "executor", "", "delayMillis", "Ljava/io/File;", UtilsKt.SCHEME_FILE, "<init>", "(Lio/appmetrica/analytics/coreapi/internal/executors/IHandlerExecutor;JLjava/io/File;)V", "core-utils_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes5.dex */
public final class BufferedFileWriter {

    /* renamed from: a  reason: collision with root package name */
    private final File f362a;
    private final Object b = new Object();
    private String c;
    private final DeferredBatchExecutor d;

    public BufferedFileWriter(IHandlerExecutor iHandlerExecutor, long j, File file) {
        this.f362a = file;
        this.d = new DeferredBatchExecutor(iHandlerExecutor, new LastValueTaskBuffer(), new BatchProcessor() { // from class: io.appmetrica.analytics.coreutils.internal.io.BufferedFileWriter$$ExternalSyntheticLambda0
            @Override // io.appmetrica.analytics.coreutils.internal.buffering.BatchProcessor
            public final void processBatch(List list) {
                BufferedFileWriter.a(BufferedFileWriter.this, list);
            }
        }, j, "[BufferedFileWriter-" + file.getName() + AbstractJsonLexerKt.END_LIST);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(BufferedFileWriter bufferedFileWriter, List list) {
        String str = (String) CollectionsKt.first((List<? extends Object>) list);
        try {
            File parentFile = bufferedFileWriter.f362a.getParentFile();
            if (parentFile != null) {
                if (parentFile.exists()) {
                    parentFile = null;
                }
                if (parentFile != null) {
                    parentFile.mkdirs();
                }
            }
            FilesKt.writeText$default(bufferedFileWriter.f362a, str, null, 2, null);
            synchronized (bufferedFileWriter.b) {
                bufferedFileWriter.c = null;
                Unit unit = Unit.INSTANCE;
            }
        } catch (Exception unused) {
        }
    }

    public final void flush() {
        this.d.flush();
    }

    public final void flushAsync() {
        this.d.flushAsync();
    }

    public final String readString() {
        String str;
        synchronized (this.b) {
            str = this.c;
            if (str == null) {
                str = null;
                try {
                    if (this.f362a.exists()) {
                        str = FilesKt.readText$default(this.f362a, null, 1, null);
                    }
                } catch (Exception unused) {
                }
                if (str != null) {
                    this.c = str;
                }
            }
        }
        return str;
    }

    public final void writeString(String str) {
        synchronized (this.b) {
            this.c = str;
            Unit unit = Unit.INSTANCE;
        }
        DeferredBatchExecutor.submit$default(this.d, str, false, 2, null);
    }
}
