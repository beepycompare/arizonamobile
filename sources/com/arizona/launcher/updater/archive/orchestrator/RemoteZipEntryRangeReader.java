package com.arizona.launcher.updater.archive.orchestrator;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.arizona.launcher.updater.archive.io.ArchiveDirectoryCreator;
import com.arizona.launcher.updater.archive.io.ArchiveStorageFailureClassifier;
import com.arizona.launcher.updater.archive.io.JvmArchiveDirectoryCreator;
import com.arizona.launcher.updater.archive.orchestrator.ArchiveByteRangeResult;
import com.arizona.launcher.updater.archive.orchestrator.ArchiveByteRangeStreamResult;
import com.arizona.launcher.updater.archive.orchestrator.RemoteZipEntryPreparationResult;
import com.arizona.launcher.updater.archive.orchestrator.RemoteZipEntryReadResult;
import com.arizona.launcher.updater.archive.range.RemoteZipEntry;
import com.arizona.launcher.updater.archive.range.StrongEtag;
import com.arizona.launcher.updater.archive.state.ArchivePackageFileRecord;
import com.google.android.vending.expansion.downloader.DownloaderServiceMarshaller;
import com.google.common.base.Ascii;
import com.google.firebase.analytics.FirebaseAnalytics;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CodingErrorAction;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.zip.CRC32;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import okhttp3.internal.ws.WebSocketProtocol;
/* compiled from: RemoteZipEntryRangeReader.kt */
@Metadata(d1 = {"\u0000²\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\f\n\u0002\u0010\u0016\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u0000 R2\u00020\u0001:\u0005NOPQRB#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ(\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u0011H\u0086@¢\u0006\u0002\u0010\u0012JF\u0010\u0013\u001a\u00020\u00142\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0010\u001a\u00020\u00112\u0014\b\u0002\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00190\u0018H\u0086@¢\u0006\u0002\u0010\u001aJ<\u0010\u001b\u001a\u00020\u00142\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0015\u001a\u00020\u00162\u0014\b\u0002\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00190\u0018H\u0086@¢\u0006\u0002\u0010\u001eJ8\u0010\u001f\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00112\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0002J\"\u0010'\u001a\u00020(2\u0006\u0010\f\u001a\u00020\r2\b\u0010)\u001a\u0004\u0018\u00010*2\u0006\u0010+\u001a\u00020$H\u0002J\u0014\u0010,\u001a\u00020-*\u00020.2\u0006\u0010\"\u001a\u00020\u0011H\u0002J\u0014\u0010,\u001a\u00020-*\u00020/2\u0006\u0010\"\u001a\u00020\u0011H\u0002J$\u00100\u001a\u0002012\u0006\u00102\u001a\u0002032\b\u00104\u001a\u0004\u0018\u00010$2\b\b\u0002\u0010\"\u001a\u00020\u0011H\u0002J\u0012\u00105\u001a\u0004\u0018\u0001062\u0006\u00107\u001a\u000208H\u0002J\u0010\u00109\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u001a\u0010:\u001a\u0004\u0018\u00010$2\u0006\u0010;\u001a\u0002082\u0006\u0010<\u001a\u00020&H\u0002J\u0010\u0010=\u001a\u00020(2\u0006\u0010>\u001a\u000208H\u0002J\u001a\u0010?\u001a\u0004\u0018\u00010-2\u0006\u0010@\u001a\u00020!2\u0006\u0010A\u001a\u000208H\u0002J\u0010\u0010B\u001a\u00020\u00192\u0006\u0010@\u001a\u00020!H\u0002J\u001b\u0010C\u001a\u0004\u0018\u00010\u00112\n\u0010D\u001a\u00020E\"\u00020\u0011H\u0002¢\u0006\u0002\u0010FJ\u0018\u0010G\u001a\u00020\u00112\u0006\u0010H\u001a\u00020\u00112\u0006\u0010I\u001a\u00020\u0011H\u0002J\u0018\u0010J\u001a\u00020&2\u0006\u00107\u001a\u0002082\u0006\u0010K\u001a\u00020&H\u0002J\u0018\u0010L\u001a\u00020\u00112\u0006\u00107\u001a\u0002082\u0006\u0010K\u001a\u00020&H\u0002J\f\u0010M\u001a\u00020$*\u000208H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000Ê\u0001\f\bT\u0012\b\bU\u0012\u0004\b\u0003\u0010\u0002¨\u0006S"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/RemoteZipEntryRangeReader;", "", "byteRangeSource", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveByteRangeSource;", "streamer", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveByteRangeStreamer;", "directoryCreator", "Lcom/arizona/launcher/updater/archive/io/ArchiveDirectoryCreator;", "<init>", "(Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveByteRangeSource;Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveByteRangeStreamer;Lcom/arizona/launcher/updater/archive/io/ArchiveDirectoryCreator;)V", "prepare", "Lcom/arizona/launcher/updater/archive/orchestrator/RemoteZipEntryPreparationResult;", "session", "Lcom/arizona/launcher/updater/archive/orchestrator/RemoteZipEntryRangeSession;", "entry", "Lcom/arizona/launcher/updater/archive/range/RemoteZipEntry;", "nextLocalHeaderOffset", "", "(Lcom/arizona/launcher/updater/archive/orchestrator/RemoteZipEntryRangeSession;Lcom/arizona/launcher/updater/archive/range/RemoteZipEntry;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readToFile", "Lcom/arizona/launcher/updater/archive/orchestrator/RemoteZipEntryReadResult;", FirebaseAnalytics.Param.DESTINATION, "Ljava/io/File;", "onProgress", "Lkotlin/Function1;", "", "(Lcom/arizona/launcher/updater/archive/orchestrator/RemoteZipEntryRangeSession;Lcom/arizona/launcher/updater/archive/range/RemoteZipEntry;Ljava/io/File;JLkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readPreparedToFile", "prepared", "Lcom/arizona/launcher/updater/archive/orchestrator/RemoteZipPreparedEntry;", "(Lcom/arizona/launcher/updater/archive/orchestrator/RemoteZipEntryRangeSession;Lcom/arizona/launcher/updater/archive/orchestrator/RemoteZipPreparedEntry;Ljava/io/File;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeDecompressed", "compressed", "Ljava/io/InputStream;", "fetchedBytes", "expectedName", "", "extraLength", "", "sameRepresentation", "", "observed", "Lcom/arizona/launcher/updater/archive/range/StrongEtag;", "effectiveUrl", "toReadFailure", "Lcom/arizona/launcher/updater/archive/orchestrator/RemoteZipEntryReadResult$Failure;", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveByteRangeResult$Failure;", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveByteRangeStreamResult$Failure;", "preparationFailure", "Lcom/arizona/launcher/updater/archive/orchestrator/RemoteZipEntryPreparationResult$Failure;", "code", "Lcom/arizona/launcher/updater/archive/orchestrator/RemoteZipEntryReadErrorCode;", "detail", "parseLocalHeader", "Lcom/arizona/launcher/updater/archive/orchestrator/RemoteZipEntryRangeReader$ParsedLocalHeader;", "bytes", "", "nameByteLength", "decodeName", "nameBytes", DownloaderServiceMarshaller.PARAMS_FLAGS, "containsZip64Extra", "extra", "readFully", "input", "buffer", "drain", "addOrNull", "values", "", "([J)Ljava/lang/Long;", "addOrSaturating", "first", "second", "u16", TypedValues.CycleType.S_WAVE_OFFSET, "u32", "toLowerHex", "ParsedLocalHeader", "LimitedCompressedStream", "ProgressInputStream", "EntryReadAbort", "Companion", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class RemoteZipEntryRangeReader {
    public static final int $stable = 0;
    @Deprecated
    public static final int BUFFER_SIZE = 65536;
    private static final Charset CP437;
    private static final Companion Companion = new Companion(null);
    @Deprecated
    public static final int DATA_DESCRIPTOR_FLAG = 8;
    @Deprecated
    public static final int EXTRA_FIELD_HEADER_SIZE = 4;
    @Deprecated
    public static final String HEX_DIGITS = "0123456789abcdef";
    @Deprecated
    public static final int LOCAL_HEADER_FIXED_SIZE = 30;
    @Deprecated
    public static final long LOCAL_HEADER_SIGNATURE = 67324752;
    @Deprecated
    public static final int UTF8_FLAG = 2048;
    @Deprecated
    public static final int ZIP64_EXTRA_FIELD_ID = 1;
    private final ArchiveByteRangeSource byteRangeSource;
    private final ArchiveDirectoryCreator directoryCreator;
    private final ArchiveByteRangeStreamer streamer;

    public RemoteZipEntryRangeReader(ArchiveByteRangeSource byteRangeSource, ArchiveByteRangeStreamer streamer, ArchiveDirectoryCreator directoryCreator) {
        Intrinsics.checkNotNullParameter(byteRangeSource, "byteRangeSource");
        Intrinsics.checkNotNullParameter(streamer, "streamer");
        Intrinsics.checkNotNullParameter(directoryCreator, "directoryCreator");
        this.byteRangeSource = byteRangeSource;
        this.streamer = streamer;
        this.directoryCreator = directoryCreator;
    }

    public /* synthetic */ RemoteZipEntryRangeReader(ArchiveByteRangeSource archiveByteRangeSource, ArchiveByteRangeStreamer archiveByteRangeStreamer, JvmArchiveDirectoryCreator jvmArchiveDirectoryCreator, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(archiveByteRangeSource, (i & 2) != 0 ? ArchiveManifestResolverKt.asBufferedStreamer(archiveByteRangeSource) : archiveByteRangeStreamer, (i & 4) != 0 ? JvmArchiveDirectoryCreator.INSTANCE : jvmArchiveDirectoryCreator);
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0245  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00ca  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object prepare(RemoteZipEntryRangeSession remoteZipEntryRangeSession, RemoteZipEntry remoteZipEntry, long j, Continuation<? super RemoteZipEntryPreparationResult> continuation) {
        RemoteZipEntryRangeReader$prepare$1 remoteZipEntryRangeReader$prepare$1;
        int i;
        long j2;
        RemoteZipEntry remoteZipEntry2;
        long j3;
        RemoteZipEntryRangeSession remoteZipEntryRangeSession2;
        ArchiveByteRangeResult archiveByteRangeResult;
        if (continuation instanceof RemoteZipEntryRangeReader$prepare$1) {
            remoteZipEntryRangeReader$prepare$1 = (RemoteZipEntryRangeReader$prepare$1) continuation;
            if ((remoteZipEntryRangeReader$prepare$1.label & Integer.MIN_VALUE) != 0) {
                remoteZipEntryRangeReader$prepare$1.label -= Integer.MIN_VALUE;
                Object obj = remoteZipEntryRangeReader$prepare$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = remoteZipEntryRangeReader$prepare$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    if (remoteZipEntry.isDirectory()) {
                        return preparationFailure$default(this, RemoteZipEntryReadErrorCode.LOCAL_HEADER_MISMATCH, "directory entries cannot be fetched", 0L, 4, null);
                    }
                    Long addOrNull = addOrNull(remoteZipEntry.getLocalHeaderOffset(), 30);
                    if (addOrNull == null) {
                        return preparationFailure$default(this, RemoteZipEntryReadErrorCode.LOCAL_HEADER_INVALID, "local header offset overflow", 0L, 4, null);
                    }
                    long longValue = addOrNull.longValue();
                    if (longValue > remoteZipEntryRangeSession.getArchiveSize() || longValue > remoteZipEntryRangeSession.getCentralDirectoryOffset()) {
                        return preparationFailure$default(this, RemoteZipEntryReadErrorCode.LOCAL_HEADER_INVALID, "local header exceeds central directory", 0L, 4, null);
                    }
                    ArchiveByteRangeSource archiveByteRangeSource = this.byteRangeSource;
                    ArchiveByteRangeRequest archiveByteRangeRequest = new ArchiveByteRangeRequest(remoteZipEntryRangeSession.getPackageId(), remoteZipEntryRangeSession.getRequestUrl(), remoteZipEntry.getLocalHeaderOffset(), longValue - 1, remoteZipEntryRangeSession.getArchiveSize(), remoteZipEntryRangeSession.getFence());
                    remoteZipEntryRangeReader$prepare$1.L$0 = remoteZipEntryRangeSession;
                    remoteZipEntryRangeReader$prepare$1.L$1 = remoteZipEntry;
                    j2 = j;
                    remoteZipEntryRangeReader$prepare$1.J$0 = j2;
                    remoteZipEntryRangeReader$prepare$1.J$1 = longValue;
                    remoteZipEntryRangeReader$prepare$1.label = 1;
                    obj = archiveByteRangeSource.fetch(archiveByteRangeRequest, remoteZipEntryRangeReader$prepare$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    remoteZipEntry2 = remoteZipEntry;
                    j3 = longValue;
                    remoteZipEntryRangeSession2 = remoteZipEntryRangeSession;
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    long j4 = remoteZipEntryRangeReader$prepare$1.J$1;
                    long j5 = remoteZipEntryRangeReader$prepare$1.J$0;
                    remoteZipEntryRangeSession2 = (RemoteZipEntryRangeSession) remoteZipEntryRangeReader$prepare$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    j2 = j5;
                    remoteZipEntry2 = (RemoteZipEntry) remoteZipEntryRangeReader$prepare$1.L$1;
                    j3 = j4;
                }
                archiveByteRangeResult = (ArchiveByteRangeResult) obj;
                if (archiveByteRangeResult instanceof ArchiveByteRangeResult.Success) {
                    if (!(archiveByteRangeResult instanceof ArchiveByteRangeResult.Failure)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    RemoteZipEntryReadResult.Failure readFailure = toReadFailure((ArchiveByteRangeResult.Failure) archiveByteRangeResult, 0L);
                    return preparationFailure(readFailure.getCode(), readFailure.getDetail(), readFailure.getFetchedBytes());
                }
                ArchiveByteRangeResponse response = ((ArchiveByteRangeResult.Success) archiveByteRangeResult).getResponse();
                long length = response.getBytes().length;
                if (!sameRepresentation(remoteZipEntryRangeSession2, response.getStrongEtag(), response.getEffectiveUrl())) {
                    return preparationFailure(RemoteZipEntryReadErrorCode.REPRESENTATION_CHANGED, "ZIP representation changed before local header", length);
                }
                if (response.getBytes().length != 30) {
                    return preparationFailure(RemoteZipEntryReadErrorCode.LOCAL_HEADER_INVALID, "local header length mismatch", length);
                }
                ParsedLocalHeader parseLocalHeader = parseLocalHeader(response.getBytes());
                if (parseLocalHeader == null) {
                    return preparationFailure(RemoteZipEntryReadErrorCode.LOCAL_HEADER_INVALID, "malformed local header", length);
                }
                if (parseLocalHeader.getSignature() != LOCAL_HEADER_SIGNATURE || parseLocalHeader.getMethod() != remoteZipEntry2.getMethod() || parseLocalHeader.getFlags() != remoteZipEntry2.getFlags() || parseLocalHeader.getNameLength() != nameByteLength(remoteZipEntry2)) {
                    return preparationFailure(RemoteZipEntryReadErrorCode.LOCAL_HEADER_MISMATCH, "local header does not match central directory", length);
                }
                boolean z = (parseLocalHeader.getFlags() & 8) != 0;
                if (!z && (parseLocalHeader.getCrc32() != remoteZipEntry2.getCrc32() || parseLocalHeader.getCompressedSize() != remoteZipEntry2.getCompressedSize() || parseLocalHeader.getSize() != remoteZipEntry2.getSize())) {
                    return preparationFailure(RemoteZipEntryReadErrorCode.LOCAL_HEADER_MISMATCH, "local header size/CRC does not match central directory", length);
                }
                if (z && ((parseLocalHeader.getCrc32() != 0 && parseLocalHeader.getCrc32() != remoteZipEntry2.getCrc32()) || ((parseLocalHeader.getCompressedSize() != 0 && parseLocalHeader.getCompressedSize() != remoteZipEntry2.getCompressedSize()) || (parseLocalHeader.getSize() != 0 && parseLocalHeader.getSize() != remoteZipEntry2.getSize())))) {
                    return preparationFailure(RemoteZipEntryReadErrorCode.LOCAL_HEADER_MISMATCH, "data-descriptor local header disagrees with central directory", length);
                }
                Long addOrNull2 = addOrNull(parseLocalHeader.getNameLength(), parseLocalHeader.getExtraLength(), remoteZipEntry2.getCompressedSize());
                if (addOrNull2 != null) {
                    Long addOrNull3 = addOrNull(j3, addOrNull2.longValue());
                    if (addOrNull3 == null) {
                        return preparationFailure(RemoteZipEntryReadErrorCode.LOCAL_HEADER_INVALID, "entry payload end overflow", length);
                    }
                    long longValue2 = addOrNull3.longValue();
                    if (longValue2 > remoteZipEntryRangeSession2.getArchiveSize() || longValue2 > remoteZipEntryRangeSession2.getCentralDirectoryOffset() || longValue2 > j2) {
                        return preparationFailure(RemoteZipEntryReadErrorCode.LOCAL_HEADER_INVALID, "entry payload overlaps later ZIP structures", length);
                    }
                    return new RemoteZipEntryPreparationResult.Success(new RemoteZipPreparedEntry(remoteZipEntry2, j3, longValue2, parseLocalHeader.getNameLength(), parseLocalHeader.getExtraLength()), length);
                }
                return preparationFailure(RemoteZipEntryReadErrorCode.LOCAL_HEADER_INVALID, "entry payload length overflow", length);
            }
        }
        remoteZipEntryRangeReader$prepare$1 = new RemoteZipEntryRangeReader$prepare$1(this, continuation);
        Object obj2 = remoteZipEntryRangeReader$prepare$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = remoteZipEntryRangeReader$prepare$1.label;
        if (i != 0) {
        }
        archiveByteRangeResult = (ArchiveByteRangeResult) obj2;
        if (archiveByteRangeResult instanceof ArchiveByteRangeResult.Success) {
        }
    }

    public static /* synthetic */ Object prepare$default(RemoteZipEntryRangeReader remoteZipEntryRangeReader, RemoteZipEntryRangeSession remoteZipEntryRangeSession, RemoteZipEntry remoteZipEntry, long j, Continuation continuation, int i, Object obj) {
        if ((i & 4) != 0) {
            j = remoteZipEntryRangeSession.getCentralDirectoryOffset();
        }
        return remoteZipEntryRangeReader.prepare(remoteZipEntryRangeSession, remoteZipEntry, j, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0132  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object readToFile(RemoteZipEntryRangeSession remoteZipEntryRangeSession, RemoteZipEntry remoteZipEntry, File file, long j, Function1<? super Long, Unit> function1, Continuation<? super RemoteZipEntryReadResult> continuation) {
        RemoteZipEntryRangeReader$readToFile$1 remoteZipEntryRangeReader$readToFile$1;
        int i;
        final Function1<? super Long, Unit> function12;
        RemoteZipEntry remoteZipEntry2;
        long j2;
        File file2;
        RemoteZipEntryRangeSession remoteZipEntryRangeSession2;
        RemoteZipEntryPreparationResult remoteZipEntryPreparationResult;
        RemoteZipEntryPreparationResult.Success success;
        RemoteZipEntryReadResult remoteZipEntryReadResult;
        if (continuation instanceof RemoteZipEntryRangeReader$readToFile$1) {
            remoteZipEntryRangeReader$readToFile$1 = (RemoteZipEntryRangeReader$readToFile$1) continuation;
            if ((remoteZipEntryRangeReader$readToFile$1.label & Integer.MIN_VALUE) != 0) {
                remoteZipEntryRangeReader$readToFile$1.label -= Integer.MIN_VALUE;
                RemoteZipEntryRangeReader$readToFile$1 remoteZipEntryRangeReader$readToFile$12 = remoteZipEntryRangeReader$readToFile$1;
                Object obj = remoteZipEntryRangeReader$readToFile$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = remoteZipEntryRangeReader$readToFile$12.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    remoteZipEntryRangeReader$readToFile$12.L$0 = remoteZipEntryRangeSession;
                    remoteZipEntryRangeReader$readToFile$12.L$1 = SpillingKt.nullOutSpilledVariable(remoteZipEntry);
                    remoteZipEntryRangeReader$readToFile$12.L$2 = file;
                    function12 = function1;
                    remoteZipEntryRangeReader$readToFile$12.L$3 = function12;
                    remoteZipEntryRangeReader$readToFile$12.J$0 = j;
                    remoteZipEntryRangeReader$readToFile$12.label = 1;
                    obj = prepare(remoteZipEntryRangeSession, remoteZipEntry, j, remoteZipEntryRangeReader$readToFile$12);
                    if (obj != coroutine_suspended) {
                        remoteZipEntry2 = remoteZipEntry;
                        j2 = j;
                        file2 = file;
                        remoteZipEntryRangeSession2 = remoteZipEntryRangeSession;
                    }
                    return coroutine_suspended;
                } else if (i != 1) {
                    if (i == 2) {
                        long j3 = remoteZipEntryRangeReader$readToFile$12.J$0;
                        success = (RemoteZipEntryPreparationResult.Success) remoteZipEntryRangeReader$readToFile$12.L$4;
                        Function1 function13 = (Function1) remoteZipEntryRangeReader$readToFile$12.L$3;
                        File file3 = (File) remoteZipEntryRangeReader$readToFile$12.L$2;
                        RemoteZipEntry remoteZipEntry3 = (RemoteZipEntry) remoteZipEntryRangeReader$readToFile$12.L$1;
                        RemoteZipEntryRangeSession remoteZipEntryRangeSession3 = (RemoteZipEntryRangeSession) remoteZipEntryRangeReader$readToFile$12.L$0;
                        ResultKt.throwOnFailure(obj);
                        remoteZipEntryReadResult = (RemoteZipEntryReadResult) obj;
                        if (!(remoteZipEntryReadResult instanceof RemoteZipEntryReadResult.Success)) {
                            RemoteZipEntryReadResult.Success success2 = (RemoteZipEntryReadResult.Success) remoteZipEntryReadResult;
                            return RemoteZipEntryReadResult.Success.copy$default(success2, null, addOrSaturating(success.getFetchedBytes(), success2.getFetchedBytes()), 1, null);
                        } else if (!(remoteZipEntryReadResult instanceof RemoteZipEntryReadResult.Failure)) {
                            throw new NoWhenBranchMatchedException();
                        } else {
                            RemoteZipEntryReadResult.Failure failure = (RemoteZipEntryReadResult.Failure) remoteZipEntryReadResult;
                            return RemoteZipEntryReadResult.Failure.copy$default(failure, null, null, addOrSaturating(success.getFetchedBytes(), failure.getFetchedBytes()), 3, null);
                        }
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    long j4 = remoteZipEntryRangeReader$readToFile$12.J$0;
                    file2 = (File) remoteZipEntryRangeReader$readToFile$12.L$2;
                    remoteZipEntry2 = (RemoteZipEntry) remoteZipEntryRangeReader$readToFile$12.L$1;
                    remoteZipEntryRangeSession2 = (RemoteZipEntryRangeSession) remoteZipEntryRangeReader$readToFile$12.L$0;
                    ResultKt.throwOnFailure(obj);
                    function12 = (Function1) remoteZipEntryRangeReader$readToFile$12.L$3;
                    j2 = j4;
                }
                remoteZipEntryPreparationResult = (RemoteZipEntryPreparationResult) obj;
                if (remoteZipEntryPreparationResult instanceof RemoteZipEntryPreparationResult.Success) {
                    if (!(remoteZipEntryPreparationResult instanceof RemoteZipEntryPreparationResult.Failure)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    RemoteZipEntryPreparationResult.Failure failure2 = (RemoteZipEntryPreparationResult.Failure) remoteZipEntryPreparationResult;
                    return new RemoteZipEntryReadResult.Failure(failure2.getCode(), failure2.getDetail(), failure2.getFetchedBytes());
                }
                final RemoteZipEntryPreparationResult.Success success3 = (RemoteZipEntryPreparationResult.Success) remoteZipEntryPreparationResult;
                function12.invoke(Boxing.boxLong(success3.getFetchedBytes()));
                RemoteZipPreparedEntry prepared = success3.getPrepared();
                Function1<? super Long, Unit> function14 = new Function1() { // from class: com.arizona.launcher.updater.archive.orchestrator.RemoteZipEntryRangeReader$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return RemoteZipEntryRangeReader.readToFile$lambda$1(Function1.this, this, success3, ((Long) obj2).longValue());
                    }
                };
                remoteZipEntryRangeReader$readToFile$12.L$0 = SpillingKt.nullOutSpilledVariable(remoteZipEntryRangeSession2);
                remoteZipEntryRangeReader$readToFile$12.L$1 = SpillingKt.nullOutSpilledVariable(remoteZipEntry2);
                remoteZipEntryRangeReader$readToFile$12.L$2 = SpillingKt.nullOutSpilledVariable(file2);
                remoteZipEntryRangeReader$readToFile$12.L$3 = SpillingKt.nullOutSpilledVariable(function12);
                remoteZipEntryRangeReader$readToFile$12.L$4 = success3;
                remoteZipEntryRangeReader$readToFile$12.J$0 = j2;
                remoteZipEntryRangeReader$readToFile$12.label = 2;
                Object readPreparedToFile = readPreparedToFile(remoteZipEntryRangeSession2, prepared, file2, function14, remoteZipEntryRangeReader$readToFile$12);
                if (readPreparedToFile != coroutine_suspended) {
                    success = success3;
                    obj = readPreparedToFile;
                    remoteZipEntryReadResult = (RemoteZipEntryReadResult) obj;
                    if (!(remoteZipEntryReadResult instanceof RemoteZipEntryReadResult.Success)) {
                    }
                }
                return coroutine_suspended;
            }
        }
        remoteZipEntryRangeReader$readToFile$1 = new RemoteZipEntryRangeReader$readToFile$1(this, continuation);
        RemoteZipEntryRangeReader$readToFile$1 remoteZipEntryRangeReader$readToFile$122 = remoteZipEntryRangeReader$readToFile$1;
        Object obj2 = remoteZipEntryRangeReader$readToFile$122.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = remoteZipEntryRangeReader$readToFile$122.label;
        if (i != 0) {
        }
        remoteZipEntryPreparationResult = (RemoteZipEntryPreparationResult) obj2;
        if (remoteZipEntryPreparationResult instanceof RemoteZipEntryPreparationResult.Success) {
        }
    }

    public static /* synthetic */ Object readToFile$default(RemoteZipEntryRangeReader remoteZipEntryRangeReader, RemoteZipEntryRangeSession remoteZipEntryRangeSession, RemoteZipEntry remoteZipEntry, File file, long j, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 8) != 0) {
            j = remoteZipEntryRangeSession.getCentralDirectoryOffset();
        }
        return remoteZipEntryRangeReader.readToFile(remoteZipEntryRangeSession, remoteZipEntry, file, j, (i & 16) != 0 ? new Function1() { // from class: com.arizona.launcher.updater.archive.orchestrator.RemoteZipEntryRangeReader$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj2) {
                Unit unit;
                ((Long) obj2).longValue();
                unit = Unit.INSTANCE;
                return unit;
            }
        } : function1, continuation);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit readToFile$lambda$1(Function1 function1, RemoteZipEntryRangeReader remoteZipEntryRangeReader, RemoteZipEntryPreparationResult.Success success, long j) {
        function1.invoke(Long.valueOf(remoteZipEntryRangeReader.addOrSaturating(success.getFetchedBytes(), j)));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x014c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object readPreparedToFile(RemoteZipEntryRangeSession remoteZipEntryRangeSession, RemoteZipPreparedEntry remoteZipPreparedEntry, final File file, final Function1<? super Long, Unit> function1, Continuation<? super RemoteZipEntryReadResult> continuation) {
        RemoteZipEntryRangeReader$readPreparedToFile$1 remoteZipEntryRangeReader$readPreparedToFile$1;
        int i;
        final Ref.LongRef longRef;
        final RemoteZipPreparedEntry remoteZipPreparedEntry2;
        RemoteZipEntryRangeSession remoteZipEntryRangeSession2;
        File file2;
        Object stream;
        Ref.ObjectRef objectRef;
        RemoteZipEntryReadResult remoteZipEntryReadResult;
        RemoteZipEntryRangeReader remoteZipEntryRangeReader = this;
        if (continuation instanceof RemoteZipEntryRangeReader$readPreparedToFile$1) {
            remoteZipEntryRangeReader$readPreparedToFile$1 = (RemoteZipEntryRangeReader$readPreparedToFile$1) continuation;
            if ((remoteZipEntryRangeReader$readPreparedToFile$1.label & Integer.MIN_VALUE) != 0) {
                remoteZipEntryRangeReader$readPreparedToFile$1.label -= Integer.MIN_VALUE;
                RemoteZipEntryRangeReader$readPreparedToFile$1 remoteZipEntryRangeReader$readPreparedToFile$12 = remoteZipEntryRangeReader$readPreparedToFile$1;
                Object obj = remoteZipEntryRangeReader$readPreparedToFile$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = remoteZipEntryRangeReader$readPreparedToFile$12.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    final RemoteZipEntry entry = remoteZipPreparedEntry.getEntry();
                    File parentFile = file.getParentFile();
                    if (parentFile != null && !parentFile.isDirectory() && !remoteZipEntryRangeReader.directoryCreator.createDirectories(parentFile)) {
                        return new RemoteZipEntryReadResult.Failure(RemoteZipEntryReadErrorCode.IO_ERROR, null, 0L, 6, null);
                    }
                    if (file.exists() && !file.delete()) {
                        return new RemoteZipEntryReadResult.Failure(RemoteZipEntryReadErrorCode.IO_ERROR, null, 0L, 6, null);
                    }
                    if (remoteZipPreparedEntry.getPayloadLength() == 0) {
                        return remoteZipEntryRangeReader.writeDecompressed(file, entry, new ByteArrayInputStream(new byte[0]), 0L, entry.getPath(), remoteZipPreparedEntry.getExtraLength());
                    }
                    final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
                    longRef = new Ref.LongRef();
                    ArchiveByteRangeStreamer archiveByteRangeStreamer = remoteZipEntryRangeReader.streamer;
                    ArchiveByteRangeRequest archiveByteRangeRequest = new ArchiveByteRangeRequest(remoteZipEntryRangeSession.getPackageId(), remoteZipEntryRangeSession.getRequestUrl(), remoteZipPreparedEntry.getPayloadStart(), remoteZipPreparedEntry.getPayloadEndExclusive() - 1, remoteZipEntryRangeSession.getArchiveSize(), remoteZipEntryRangeSession.getFence());
                    remoteZipPreparedEntry2 = remoteZipPreparedEntry;
                    Function1<? super InputStream, Unit> function12 = new Function1() { // from class: com.arizona.launcher.updater.archive.orchestrator.RemoteZipEntryRangeReader$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return RemoteZipEntryRangeReader.readPreparedToFile$lambda$1(RemoteZipEntryRangeReader.this, file, entry, remoteZipPreparedEntry2, objectRef2, longRef, function1, (InputStream) obj2);
                        }
                    };
                    remoteZipEntryRangeReader = this;
                    remoteZipEntryRangeSession2 = remoteZipEntryRangeSession;
                    remoteZipEntryRangeReader$readPreparedToFile$12.L$0 = remoteZipEntryRangeSession2;
                    remoteZipEntryRangeReader$readPreparedToFile$12.L$1 = remoteZipPreparedEntry2;
                    file2 = file;
                    remoteZipEntryRangeReader$readPreparedToFile$12.L$2 = file2;
                    remoteZipEntryRangeReader$readPreparedToFile$12.L$3 = SpillingKt.nullOutSpilledVariable(function1);
                    remoteZipEntryRangeReader$readPreparedToFile$12.L$4 = SpillingKt.nullOutSpilledVariable(entry);
                    remoteZipEntryRangeReader$readPreparedToFile$12.L$5 = SpillingKt.nullOutSpilledVariable(parentFile);
                    remoteZipEntryRangeReader$readPreparedToFile$12.L$6 = objectRef2;
                    remoteZipEntryRangeReader$readPreparedToFile$12.L$7 = longRef;
                    remoteZipEntryRangeReader$readPreparedToFile$12.label = 1;
                    stream = archiveByteRangeStreamer.stream(archiveByteRangeRequest, function12, remoteZipEntryRangeReader$readPreparedToFile$12);
                    if (stream == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    objectRef = objectRef2;
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    Ref.LongRef longRef2 = (Ref.LongRef) remoteZipEntryRangeReader$readPreparedToFile$12.L$7;
                    objectRef = (Ref.ObjectRef) remoteZipEntryRangeReader$readPreparedToFile$12.L$6;
                    File file3 = (File) remoteZipEntryRangeReader$readPreparedToFile$12.L$5;
                    RemoteZipEntry remoteZipEntry = (RemoteZipEntry) remoteZipEntryRangeReader$readPreparedToFile$12.L$4;
                    Function1 function13 = (Function1) remoteZipEntryRangeReader$readPreparedToFile$12.L$3;
                    ResultKt.throwOnFailure(obj);
                    stream = obj;
                    remoteZipEntryRangeSession2 = (RemoteZipEntryRangeSession) remoteZipEntryRangeReader$readPreparedToFile$12.L$0;
                    longRef = longRef2;
                    file2 = (File) remoteZipEntryRangeReader$readPreparedToFile$12.L$2;
                    remoteZipPreparedEntry2 = (RemoteZipPreparedEntry) remoteZipEntryRangeReader$readPreparedToFile$12.L$1;
                }
                ArchiveByteRangeStreamResult archiveByteRangeStreamResult = (ArchiveByteRangeStreamResult) stream;
                remoteZipEntryReadResult = (RemoteZipEntryReadResult) objectRef.element;
                if (!(remoteZipEntryReadResult instanceof RemoteZipEntryReadResult.Failure)) {
                    file2.delete();
                    return RemoteZipEntryReadResult.Failure.copy$default((RemoteZipEntryReadResult.Failure) remoteZipEntryReadResult, null, null, longRef.element, 3, null);
                } else if (archiveByteRangeStreamResult instanceof ArchiveByteRangeStreamResult.Success) {
                    ArchiveByteRangeStreamResult.Success success = (ArchiveByteRangeStreamResult.Success) archiveByteRangeStreamResult;
                    if (!remoteZipEntryRangeReader.sameRepresentation(remoteZipEntryRangeSession2, success.getStrongEtag(), success.getEffectiveUrl())) {
                        file2.delete();
                        return new RemoteZipEntryReadResult.Failure(RemoteZipEntryReadErrorCode.REPRESENTATION_CHANGED, "ZIP representation changed during entry payload", longRef.element);
                    } else if (success.getByteCount() != remoteZipPreparedEntry2.getPayloadLength() || longRef.element != remoteZipPreparedEntry2.getPayloadLength()) {
                        file2.delete();
                        return new RemoteZipEntryReadResult.Failure(RemoteZipEntryReadErrorCode.RANGE_FAILED, "entry payload length mismatch", longRef.element);
                    } else if (remoteZipEntryReadResult instanceof RemoteZipEntryReadResult.Success) {
                        return RemoteZipEntryReadResult.Success.copy$default((RemoteZipEntryReadResult.Success) remoteZipEntryReadResult, null, longRef.element, 1, null);
                    } else {
                        return new RemoteZipEntryReadResult.Failure(RemoteZipEntryReadErrorCode.IO_ERROR, null, longRef.element, 2, null);
                    }
                } else if (!(archiveByteRangeStreamResult instanceof ArchiveByteRangeStreamResult.Failure)) {
                    throw new NoWhenBranchMatchedException();
                } else {
                    file2.delete();
                    return remoteZipEntryRangeReader.toReadFailure((ArchiveByteRangeStreamResult.Failure) archiveByteRangeStreamResult, longRef.element);
                }
            }
        }
        remoteZipEntryRangeReader$readPreparedToFile$1 = new RemoteZipEntryRangeReader$readPreparedToFile$1(remoteZipEntryRangeReader, continuation);
        RemoteZipEntryRangeReader$readPreparedToFile$1 remoteZipEntryRangeReader$readPreparedToFile$122 = remoteZipEntryRangeReader$readPreparedToFile$1;
        Object obj2 = remoteZipEntryRangeReader$readPreparedToFile$122.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = remoteZipEntryRangeReader$readPreparedToFile$122.label;
        if (i != 0) {
        }
        ArchiveByteRangeStreamResult archiveByteRangeStreamResult2 = (ArchiveByteRangeStreamResult) stream;
        remoteZipEntryReadResult = (RemoteZipEntryReadResult) objectRef.element;
        if (!(remoteZipEntryReadResult instanceof RemoteZipEntryReadResult.Failure)) {
        }
    }

    public static /* synthetic */ Object readPreparedToFile$default(RemoteZipEntryRangeReader remoteZipEntryRangeReader, RemoteZipEntryRangeSession remoteZipEntryRangeSession, RemoteZipPreparedEntry remoteZipPreparedEntry, File file, Function1 function1, Continuation continuation, int i, Object obj) {
        Function1 function12 = function1;
        if ((i & 8) != 0) {
            function12 = new Function1() { // from class: com.arizona.launcher.updater.archive.orchestrator.RemoteZipEntryRangeReader$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    Unit unit;
                    ((Long) obj2).longValue();
                    unit = Unit.INSTANCE;
                    return unit;
                }
            };
        }
        return remoteZipEntryRangeReader.readPreparedToFile(remoteZipEntryRangeSession, remoteZipPreparedEntry, file, function12, continuation);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Type inference failed for: r12v1, types: [T, com.arizona.launcher.updater.archive.orchestrator.RemoteZipEntryReadResult] */
    public static final Unit readPreparedToFile$lambda$1(RemoteZipEntryRangeReader remoteZipEntryRangeReader, File file, RemoteZipEntry remoteZipEntry, RemoteZipPreparedEntry remoteZipPreparedEntry, Ref.ObjectRef objectRef, final Ref.LongRef longRef, final Function1 function1, InputStream input) {
        Intrinsics.checkNotNullParameter(input, "input");
        ProgressInputStream progressInputStream = new ProgressInputStream(input, new Function1() { // from class: com.arizona.launcher.updater.archive.orchestrator.RemoteZipEntryRangeReader$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit readPreparedToFile$lambda$1$0;
                readPreparedToFile$lambda$1$0 = RemoteZipEntryRangeReader.readPreparedToFile$lambda$1$0(Ref.LongRef.this, function1, ((Long) obj).longValue());
                return readPreparedToFile$lambda$1$0;
            }
        });
        ?? writeDecompressed = remoteZipEntryRangeReader.writeDecompressed(file, remoteZipEntry, progressInputStream, 0L, remoteZipEntry.getPath(), remoteZipPreparedEntry.getExtraLength());
        objectRef.element = writeDecompressed;
        if (writeDecompressed instanceof RemoteZipEntryReadResult.Failure) {
            remoteZipEntryRangeReader.drain(progressInputStream);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit readPreparedToFile$lambda$1$0(Ref.LongRef longRef, Function1 function1, long j) {
        longRef.element = j;
        function1.invoke(Long.valueOf(j));
        return Unit.INSTANCE;
    }

    private final RemoteZipEntryReadResult writeDecompressed(File file, RemoteZipEntry remoteZipEntry, InputStream inputStream, long j, String str, int i) {
        long j2;
        RemoteZipEntry remoteZipEntry2 = remoteZipEntry;
        byte[] bArr = new byte[(int) nameByteLength(remoteZipEntry2)];
        RemoteZipEntryReadResult.Failure readFully = readFully(inputStream, bArr);
        if (readFully != null) {
            return RemoteZipEntryReadResult.Failure.copy$default(readFully, null, null, j, 3, null);
        }
        String decodeName = decodeName(bArr, remoteZipEntry2.getFlags());
        if (decodeName == null) {
            return new RemoteZipEntryReadResult.Failure(RemoteZipEntryReadErrorCode.LOCAL_HEADER_MISMATCH, "entry name encoding is invalid", j);
        }
        if (!Intrinsics.areEqual(decodeName, str)) {
            return new RemoteZipEntryReadResult.Failure(RemoteZipEntryReadErrorCode.LOCAL_HEADER_MISMATCH, "local header name does not match central directory", j);
        }
        byte[] bArr2 = new byte[i];
        RemoteZipEntryReadResult.Failure readFully2 = readFully(inputStream, bArr2);
        if (readFully2 != null) {
            return RemoteZipEntryReadResult.Failure.copy$default(readFully2, null, null, j, 3, null);
        }
        if (containsZip64Extra(bArr2)) {
            return new RemoteZipEntryReadResult.Failure(RemoteZipEntryReadErrorCode.LOCAL_HEADER_INVALID, "ZIP64 local extra is unsupported", j);
        }
        CRC32 crc32 = new CRC32();
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        Inflater inflater = remoteZipEntry2.getMethod() == 8 ? new Inflater(true) : null;
        try {
            try {
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    try {
                        FileOutputStream fileOutputStream2 = fileOutputStream;
                        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream2, 65536);
                        byte[] bArr3 = new byte[65536];
                        if (remoteZipEntry2.getMethod() != 0) {
                            Inflater inflater2 = inflater == null ? new Inflater(true) : inflater;
                            LimitedCompressedStream limitedCompressedStream = new LimitedCompressedStream(inputStream, remoteZipEntry2.getCompressedSize());
                            byte[] bArr4 = new byte[65536];
                            j2 = 0;
                            while (true) {
                                if (inflater2.finished()) {
                                    break;
                                } else if (inflater2.needsInput()) {
                                    int read = limitedCompressedStream.read(bArr4);
                                    if (read < 0) {
                                        if (!inflater2.finished()) {
                                            throw new EntryReadAbort(new RemoteZipEntryReadResult.Failure(RemoteZipEntryReadErrorCode.ENTRY_DATA_CORRUPT, null, j, 2, null));
                                        }
                                    } else if (read != 0) {
                                        inflater2.setInput(bArr4, 0, read);
                                    }
                                } else {
                                    try {
                                        int inflate = inflater2.inflate(bArr3);
                                        if (inflate != 0) {
                                            byte[] bArr5 = bArr4;
                                            long j3 = inflate;
                                            if (j2 > remoteZipEntry2.getSize() - j3) {
                                                throw new EntryReadAbort(new RemoteZipEntryReadResult.Failure(RemoteZipEntryReadErrorCode.ENTRY_SIZE_MISMATCH, null, j, 2, null));
                                            }
                                            bufferedOutputStream.write(bArr3, 0, inflate);
                                            crc32.update(bArr3, 0, inflate);
                                            messageDigest.update(bArr3, 0, inflate);
                                            j2 += j3;
                                            remoteZipEntry2 = remoteZipEntry;
                                            bArr4 = bArr5;
                                        } else if (inflater2.finished()) {
                                            break;
                                        } else if (!inflater2.needsInput()) {
                                            throw new EntryReadAbort(new RemoteZipEntryReadResult.Failure(RemoteZipEntryReadErrorCode.ENTRY_DATA_CORRUPT, null, j, 2, null));
                                        }
                                    } catch (DataFormatException unused) {
                                        throw new EntryReadAbort(new RemoteZipEntryReadResult.Failure(RemoteZipEntryReadErrorCode.ENTRY_DATA_CORRUPT, null, j, 2, null));
                                    }
                                }
                            }
                            if (limitedCompressedStream.getRemaining() == 0) {
                                try {
                                    if (inflater2.getRemaining() == 0 && inflater2.finished()) {
                                    }
                                } catch (Throwable th) {
                                    th = th;
                                    try {
                                        throw th;
                                    } finally {
                                    }
                                }
                            }
                            throw new EntryReadAbort(new RemoteZipEntryReadResult.Failure(RemoteZipEntryReadErrorCode.ENTRY_DATA_CORRUPT, null, j, 2, null));
                        }
                        LimitedCompressedStream limitedCompressedStream2 = new LimitedCompressedStream(inputStream, remoteZipEntry2.getCompressedSize());
                        j2 = 0;
                        while (true) {
                            int read2 = limitedCompressedStream2.read(bArr3);
                            if (read2 >= 0) {
                                if (read2 != 0) {
                                    long j4 = read2;
                                    if (j2 > remoteZipEntry2.getSize() - j4) {
                                        throw new EntryReadAbort(new RemoteZipEntryReadResult.Failure(RemoteZipEntryReadErrorCode.ENTRY_SIZE_MISMATCH, null, j, 2, null));
                                    }
                                    bufferedOutputStream.write(bArr3, 0, read2);
                                    crc32.update(bArr3, 0, read2);
                                    messageDigest.update(bArr3, 0, read2);
                                    j2 += j4;
                                }
                            } else if (limitedCompressedStream2.getRemaining() != 0) {
                                throw new EntryReadAbort(new RemoteZipEntryReadResult.Failure(RemoteZipEntryReadErrorCode.ENTRY_DATA_CORRUPT, null, j, 2, null));
                            }
                        }
                        long j5 = j2;
                        bufferedOutputStream.flush();
                        fileOutputStream2.getFD().sync();
                        Unit unit = Unit.INSTANCE;
                        try {
                            CloseableKt.closeFinally(fileOutputStream, null);
                            if (inflater != null) {
                                inflater.end();
                            }
                            if (j5 != remoteZipEntry.getSize()) {
                                file.delete();
                                return new RemoteZipEntryReadResult.Failure(RemoteZipEntryReadErrorCode.ENTRY_SIZE_MISMATCH, null, j, 2, null);
                            } else if (crc32.getValue() != remoteZipEntry.getCrc32()) {
                                file.delete();
                                return new RemoteZipEntryReadResult.Failure(RemoteZipEntryReadErrorCode.ENTRY_CRC32_MISMATCH, null, j, 2, null);
                            } else {
                                String target = remoteZipEntry.getTarget();
                                long value = crc32.getValue();
                                byte[] digest = messageDigest.digest();
                                Intrinsics.checkNotNullExpressionValue(digest, "digest(...)");
                                return new RemoteZipEntryReadResult.Success(new ArchivePackageFileRecord(target, j5, value, toLowerHex(digest)), j);
                            }
                        } catch (IOException e) {
                            e = e;
                            file.delete();
                            RemoteZipEntryReadResult.Failure failure = new RemoteZipEntryReadResult.Failure(ArchiveStorageFailureClassifier.INSTANCE.isNoSpace(e) ? RemoteZipEntryReadErrorCode.NO_SPACE_LEFT : RemoteZipEntryReadErrorCode.IO_ERROR, null, j, 2, null);
                            if (inflater != null) {
                                inflater.end();
                            }
                            return failure;
                        } catch (SecurityException unused2) {
                            file.delete();
                            RemoteZipEntryReadResult.Failure failure2 = new RemoteZipEntryReadResult.Failure(RemoteZipEntryReadErrorCode.IO_ERROR, null, j, 2, null);
                            if (inflater != null) {
                                inflater.end();
                            }
                            return failure2;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (EntryReadAbort e2) {
                    file.delete();
                    RemoteZipEntryReadResult.Failure result = e2.getResult();
                    if (inflater != null) {
                        inflater.end();
                    }
                    return result;
                }
            } catch (Throwable th3) {
                if (inflater != null) {
                    inflater.end();
                }
                throw th3;
            }
        } catch (IOException e3) {
            e = e3;
        } catch (SecurityException unused3) {
        }
    }

    private final boolean sameRepresentation(RemoteZipEntryRangeSession remoteZipEntryRangeSession, StrongEtag strongEtag, String str) {
        return Intrinsics.areEqual(strongEtag, remoteZipEntryRangeSession.getFence()) && Intrinsics.areEqual(str, remoteZipEntryRangeSession.getEffectiveUrl());
    }

    private final RemoteZipEntryReadResult.Failure toReadFailure(ArchiveByteRangeResult.Failure failure, long j) {
        RemoteZipEntryReadErrorCode remoteZipEntryReadErrorCode;
        if (failure.getCode() == ArchiveByteRangeErrorCode.HTTP_STATUS && CollectionsKt.contains(SetsKt.setOf((Object[]) new Integer[]{200, 412, 416}), failure.getHttpStatus())) {
            remoteZipEntryReadErrorCode = RemoteZipEntryReadErrorCode.REPRESENTATION_CHANGED;
        } else {
            remoteZipEntryReadErrorCode = RemoteZipEntryReadErrorCode.RANGE_FAILED;
        }
        String[] strArr = new String[3];
        strArr[0] = failure.getCode().name();
        Integer httpStatus = failure.getHttpStatus();
        strArr[1] = httpStatus != null ? String.valueOf(httpStatus.intValue()) : null;
        strArr[2] = failure.getDetail();
        return new RemoteZipEntryReadResult.Failure(remoteZipEntryReadErrorCode, CollectionsKt.joinToString$default(CollectionsKt.listOfNotNull((Object[]) strArr), StringUtils.PROCESS_POSTFIX_DELIMITER, null, null, 0, null, null, 62, null), j);
    }

    private final RemoteZipEntryReadResult.Failure toReadFailure(ArchiveByteRangeStreamResult.Failure failure, long j) {
        RemoteZipEntryReadErrorCode remoteZipEntryReadErrorCode;
        if (failure.getCode() == ArchiveByteRangeErrorCode.HTTP_STATUS && CollectionsKt.contains(SetsKt.setOf((Object[]) new Integer[]{200, 412, 416}), failure.getHttpStatus())) {
            remoteZipEntryReadErrorCode = RemoteZipEntryReadErrorCode.REPRESENTATION_CHANGED;
        } else {
            remoteZipEntryReadErrorCode = RemoteZipEntryReadErrorCode.RANGE_FAILED;
        }
        String[] strArr = new String[3];
        strArr[0] = failure.getCode().name();
        Integer httpStatus = failure.getHttpStatus();
        strArr[1] = httpStatus != null ? String.valueOf(httpStatus.intValue()) : null;
        strArr[2] = failure.getDetail();
        return new RemoteZipEntryReadResult.Failure(remoteZipEntryReadErrorCode, CollectionsKt.joinToString$default(CollectionsKt.listOfNotNull((Object[]) strArr), StringUtils.PROCESS_POSTFIX_DELIMITER, null, null, 0, null, null, 62, null), j);
    }

    static /* synthetic */ RemoteZipEntryPreparationResult.Failure preparationFailure$default(RemoteZipEntryRangeReader remoteZipEntryRangeReader, RemoteZipEntryReadErrorCode remoteZipEntryReadErrorCode, String str, long j, int i, Object obj) {
        if ((i & 4) != 0) {
            j = 0;
        }
        return remoteZipEntryRangeReader.preparationFailure(remoteZipEntryReadErrorCode, str, j);
    }

    private final RemoteZipEntryPreparationResult.Failure preparationFailure(RemoteZipEntryReadErrorCode remoteZipEntryReadErrorCode, String str, long j) {
        return new RemoteZipEntryPreparationResult.Failure(remoteZipEntryReadErrorCode, str, j);
    }

    private final ParsedLocalHeader parseLocalHeader(byte[] bArr) {
        if (bArr.length < 30) {
            return null;
        }
        return new ParsedLocalHeader(u32(bArr, 0), u16(bArr, 6), u16(bArr, 8), u32(bArr, 14), u32(bArr, 18), u32(bArr, 22), u16(bArr, 26), u16(bArr, 28));
    }

    private final long nameByteLength(RemoteZipEntry remoteZipEntry) {
        Charset charset = (remoteZipEntry.getFlags() & 2048) != 0 ? StandardCharsets.UTF_8 : CP437;
        String path = remoteZipEntry.getPath();
        Intrinsics.checkNotNull(charset);
        byte[] bytes = path.getBytes(charset);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        return bytes.length;
    }

    private final String decodeName(byte[] bArr, int i) {
        try {
            return ((i & 2048) != 0 ? StandardCharsets.UTF_8 : CP437).newDecoder().onMalformedInput(CodingErrorAction.REPORT).onUnmappableCharacter(CodingErrorAction.REPORT).decode(ByteBuffer.wrap(bArr)).toString();
        } catch (CharacterCodingException unused) {
            return null;
        }
    }

    private final boolean containsZip64Extra(byte[] bArr) {
        int i = 0;
        while (true) {
            int i2 = i + 4;
            if (i2 > bArr.length) {
                return i != bArr.length;
            }
            int u16 = u16(bArr, i);
            int u162 = u16(bArr, i + 2);
            if (u162 > bArr.length - i2 || u16 == 1) {
                return true;
            }
            i = u162 + i2;
        }
    }

    private final RemoteZipEntryReadResult.Failure readFully(InputStream inputStream, byte[] bArr) {
        int i = 0;
        while (i < bArr.length) {
            int read = inputStream.read(bArr, i, bArr.length - i);
            if (read < 0) {
                return new RemoteZipEntryReadResult.Failure(RemoteZipEntryReadErrorCode.LOCAL_HEADER_INVALID, "truncated local header name or extra", 0L, 4, null);
            }
            if (read != 0) {
                i += read;
            }
        }
        return null;
    }

    private final void drain(InputStream inputStream) {
        do {
        } while (inputStream.read(new byte[65536]) >= 0);
    }

    private final Long addOrNull(long... jArr) {
        try {
            long j = 0L;
            for (long j2 : jArr) {
                j = Long.valueOf(Math.addExact(j.longValue(), j2));
            }
            return j;
        } catch (ArithmeticException unused) {
            return null;
        }
    }

    private final long addOrSaturating(long j, long j2) {
        Long addOrNull = addOrNull(j, j2);
        if (addOrNull != null) {
            return addOrNull.longValue();
        }
        return Long.MAX_VALUE;
    }

    private final int u16(byte[] bArr, int i) {
        return (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8);
    }

    private final long u32(byte[] bArr, int i) {
        return ((u16(bArr, i + 2) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 16) | (u16(bArr, i) & WebSocketProtocol.PAYLOAD_SHORT_MAX);
    }

    private final String toLowerHex(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b : bArr) {
            sb.append("0123456789abcdef".charAt((b & 255) >>> 4));
            sb.append("0123456789abcdef".charAt(b & Ascii.SI));
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: RemoteZipEntryRangeReader.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0005¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003JY\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u0005HÆ\u0001J\u0014\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010$\u001a\u00020\u0005HÖ\u0081\u0004J\n\u0010%\u001a\u00020&HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011R\u0011\u0010\u000b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011¨\u0006'"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/RemoteZipEntryRangeReader$ParsedLocalHeader;", "", "signature", "", DownloaderServiceMarshaller.PARAMS_FLAGS, "", FirebaseAnalytics.Param.METHOD, "crc32", "compressedSize", "size", "nameLength", "extraLength", "<init>", "(JIIJJJII)V", "getSignature", "()J", "getFlags", "()I", "getMethod", "getCrc32", "getCompressedSize", "getSize", "getNameLength", "getExtraLength", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "toString", "", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class ParsedLocalHeader {
        private final long compressedSize;
        private final long crc32;
        private final int extraLength;
        private final int flags;
        private final int method;
        private final int nameLength;
        private final long signature;
        private final long size;

        public static /* synthetic */ ParsedLocalHeader copy$default(ParsedLocalHeader parsedLocalHeader, long j, int i, int i2, long j2, long j3, long j4, int i3, int i4, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                j = parsedLocalHeader.signature;
            }
            return parsedLocalHeader.copy(j, (i5 & 2) != 0 ? parsedLocalHeader.flags : i, (i5 & 4) != 0 ? parsedLocalHeader.method : i2, (i5 & 8) != 0 ? parsedLocalHeader.crc32 : j2, (i5 & 16) != 0 ? parsedLocalHeader.compressedSize : j3, (i5 & 32) != 0 ? parsedLocalHeader.size : j4, (i5 & 64) != 0 ? parsedLocalHeader.nameLength : i3, (i5 & 128) != 0 ? parsedLocalHeader.extraLength : i4);
        }

        public final long component1() {
            return this.signature;
        }

        public final int component2() {
            return this.flags;
        }

        public final int component3() {
            return this.method;
        }

        public final long component4() {
            return this.crc32;
        }

        public final long component5() {
            return this.compressedSize;
        }

        public final long component6() {
            return this.size;
        }

        public final int component7() {
            return this.nameLength;
        }

        public final int component8() {
            return this.extraLength;
        }

        public final ParsedLocalHeader copy(long j, int i, int i2, long j2, long j3, long j4, int i3, int i4) {
            return new ParsedLocalHeader(j, i, i2, j2, j3, j4, i3, i4);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ParsedLocalHeader) {
                ParsedLocalHeader parsedLocalHeader = (ParsedLocalHeader) obj;
                return this.signature == parsedLocalHeader.signature && this.flags == parsedLocalHeader.flags && this.method == parsedLocalHeader.method && this.crc32 == parsedLocalHeader.crc32 && this.compressedSize == parsedLocalHeader.compressedSize && this.size == parsedLocalHeader.size && this.nameLength == parsedLocalHeader.nameLength && this.extraLength == parsedLocalHeader.extraLength;
            }
            return false;
        }

        public int hashCode() {
            return (((((((((((((Long.hashCode(this.signature) * 31) + Integer.hashCode(this.flags)) * 31) + Integer.hashCode(this.method)) * 31) + Long.hashCode(this.crc32)) * 31) + Long.hashCode(this.compressedSize)) * 31) + Long.hashCode(this.size)) * 31) + Integer.hashCode(this.nameLength)) * 31) + Integer.hashCode(this.extraLength);
        }

        public String toString() {
            long j = this.signature;
            int i = this.flags;
            int i2 = this.method;
            long j2 = this.crc32;
            long j3 = this.compressedSize;
            long j4 = this.size;
            int i3 = this.nameLength;
            return "ParsedLocalHeader(signature=" + j + ", flags=" + i + ", method=" + i2 + ", crc32=" + j2 + ", compressedSize=" + j3 + ", size=" + j4 + ", nameLength=" + i3 + ", extraLength=" + this.extraLength + ")";
        }

        public ParsedLocalHeader(long j, int i, int i2, long j2, long j3, long j4, int i3, int i4) {
            this.signature = j;
            this.flags = i;
            this.method = i2;
            this.crc32 = j2;
            this.compressedSize = j3;
            this.size = j4;
            this.nameLength = i3;
            this.extraLength = i4;
        }

        public final long getSignature() {
            return this.signature;
        }

        public final int getFlags() {
            return this.flags;
        }

        public final int getMethod() {
            return this.method;
        }

        public final long getCrc32() {
            return this.crc32;
        }

        public final long getCompressedSize() {
            return this.compressedSize;
        }

        public final long getSize() {
            return this.size;
        }

        public final int getNameLength() {
            return this.nameLength;
        }

        public final int getExtraLength() {
            return this.extraLength;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: RemoteZipEntryRangeReader.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u000b\u001a\u00020\fH\u0016J \u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0011"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/RemoteZipEntryRangeReader$LimitedCompressedStream;", "Ljava/io/InputStream;", "delegate", "expectedBytes", "", "<init>", "(Ljava/io/InputStream;J)V", "value", "remaining", "getRemaining", "()J", "read", "", "buffer", "", TypedValues.CycleType.S_WAVE_OFFSET, "length", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class LimitedCompressedStream extends InputStream {
        private final InputStream delegate;
        private long remaining;

        public LimitedCompressedStream(InputStream delegate, long j) {
            Intrinsics.checkNotNullParameter(delegate, "delegate");
            this.delegate = delegate;
            this.remaining = j;
        }

        public final long getRemaining() {
            return this.remaining;
        }

        @Override // java.io.InputStream
        public int read() {
            int read;
            if (this.remaining > 0 && (read = this.delegate.read()) >= 0) {
                this.remaining--;
                return read;
            }
            return -1;
        }

        @Override // java.io.InputStream
        public int read(byte[] buffer, int i, int i2) {
            Intrinsics.checkNotNullParameter(buffer, "buffer");
            long j = this.remaining;
            if (j <= 0 || i2 <= 0) {
                return j <= 0 ? -1 : 0;
            }
            int read = this.delegate.read(buffer, i, (int) Math.min(i2, j));
            if (read < 0) {
                return -1;
            }
            this.remaining -= read;
            return read;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: RemoteZipEntryRangeReader.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\n\u001a\u00020\u000bH\u0016J \u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000bH\u0016J\u0018\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0005H\u0002R\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/RemoteZipEntryRangeReader$ProgressInputStream;", "Ljava/io/InputStream;", "delegate", "onProgress", "Lkotlin/Function1;", "", "", "<init>", "(Ljava/io/InputStream;Lkotlin/jvm/functions/Function1;)V", "consumed", "read", "", "buffer", "", TypedValues.CycleType.S_WAVE_OFFSET, "length", "safeAdd", "first", "second", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class ProgressInputStream extends InputStream {
        private long consumed;
        private final InputStream delegate;
        private final Function1<Long, Unit> onProgress;

        /* JADX WARN: Multi-variable type inference failed */
        public ProgressInputStream(InputStream delegate, Function1<? super Long, Unit> onProgress) {
            Intrinsics.checkNotNullParameter(delegate, "delegate");
            Intrinsics.checkNotNullParameter(onProgress, "onProgress");
            this.delegate = delegate;
            this.onProgress = onProgress;
        }

        @Override // java.io.InputStream
        public int read() {
            int read = this.delegate.read();
            if (read >= 0) {
                long safeAdd = safeAdd(this.consumed, 1L);
                this.consumed = safeAdd;
                this.onProgress.invoke(Long.valueOf(safeAdd));
            }
            return read;
        }

        @Override // java.io.InputStream
        public int read(byte[] buffer, int i, int i2) {
            Intrinsics.checkNotNullParameter(buffer, "buffer");
            int read = this.delegate.read(buffer, i, i2);
            if (read > 0) {
                long safeAdd = safeAdd(this.consumed, read);
                this.consumed = safeAdd;
                this.onProgress.invoke(Long.valueOf(safeAdd));
            }
            return read;
        }

        private final long safeAdd(long j, long j2) {
            try {
                return Math.addExact(j, j2);
            } catch (ArithmeticException unused) {
                return Long.MAX_VALUE;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: RemoteZipEntryRangeReader.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/RemoteZipEntryRangeReader$EntryReadAbort;", "Ljava/io/IOException;", "result", "Lcom/arizona/launcher/updater/archive/orchestrator/RemoteZipEntryReadResult$Failure;", "<init>", "(Lcom/arizona/launcher/updater/archive/orchestrator/RemoteZipEntryReadResult$Failure;)V", "getResult", "()Lcom/arizona/launcher/updater/archive/orchestrator/RemoteZipEntryReadResult$Failure;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class EntryReadAbort extends IOException {
        private final RemoteZipEntryReadResult.Failure result;

        public final RemoteZipEntryReadResult.Failure getResult() {
            return this.result;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public EntryReadAbort(RemoteZipEntryReadResult.Failure result) {
            super(r0 == null ? result.getCode().name() : r0);
            Intrinsics.checkNotNullParameter(result, "result");
            String detail = result.getDetail();
            this.result = result;
        }
    }

    /* compiled from: RemoteZipEntryRangeReader.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/RemoteZipEntryRangeReader$Companion;", "", "<init>", "()V", "LOCAL_HEADER_SIGNATURE", "", "LOCAL_HEADER_FIXED_SIZE", "", "EXTRA_FIELD_HEADER_SIZE", "ZIP64_EXTRA_FIELD_ID", "UTF8_FLAG", "DATA_DESCRIPTOR_FLAG", "BUFFER_SIZE", "HEX_DIGITS", "", "CP437", "Ljava/nio/charset/Charset;", "getCP437", "()Ljava/nio/charset/Charset;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Charset getCP437() {
            return RemoteZipEntryRangeReader.CP437;
        }
    }

    static {
        Charset forName = Charset.forName("IBM437");
        Intrinsics.checkNotNullExpressionValue(forName, "forName(...)");
        CP437 = forName;
    }
}
