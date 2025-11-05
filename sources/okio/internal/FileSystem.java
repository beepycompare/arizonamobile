package okio.internal;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequenceScope;
import kotlin.sequences.SequencesKt;
import okio.BufferedSink;
import okio.FileMetadata;
import okio.Okio;
import okio.Path;
import okio.Source;
/* compiled from: FileSystem.kt */
@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000\u001a\u0014\u0010\u0005\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000\u001a\u001c\u0010\u0007\u001a\u00020\b*\u00020\u00022\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0006H\u0000\u001a\u001c\u0010\u000b\u001a\u00020\b*\u00020\u00022\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0004H\u0000\u001a\u001c\u0010\u000e\u001a\u00020\b*\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0006H\u0000\u001a\"\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u0012*\u00020\u00022\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0006H\u0000\u001aF\u0010\u0014\u001a\u00020\b*\b\u0012\u0004\u0012\u00020\u00040\u00152\u0006\u0010\u0016\u001a\u00020\u00022\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00040\u00182\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0006H\u0080@¢\u0006\u0002\u0010\u001a\u001a\u0016\u0010\u001b\u001a\u0004\u0018\u00010\u0004*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000¨\u0006\u001c"}, d2 = {"commonMetadata", "Lokio/FileMetadata;", "Lokio/FileSystem;", "path", "Lokio/Path;", "commonExists", "", "commonCreateDirectories", "", "dir", "mustCreate", "commonCopy", "source", TypedValues.AttributesType.S_TARGET, "commonDeleteRecursively", "fileOrDirectory", "mustExist", "commonListRecursively", "Lkotlin/sequences/Sequence;", "followSymlinks", "collectRecursively", "Lkotlin/sequences/SequenceScope;", "fileSystem", "stack", "Lkotlin/collections/ArrayDeque;", "postorder", "(Lkotlin/sequences/SequenceScope;Lokio/FileSystem;Lkotlin/collections/ArrayDeque;Lokio/Path;ZZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "symlinkTarget", "okio"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* renamed from: okio.internal.-FileSystem  reason: invalid class name */
/* loaded from: classes5.dex */
public final class FileSystem {
    public static final FileMetadata commonMetadata(okio.FileSystem fileSystem, Path path) throws IOException {
        Intrinsics.checkNotNullParameter(fileSystem, "<this>");
        Intrinsics.checkNotNullParameter(path, "path");
        FileMetadata metadataOrNull = fileSystem.metadataOrNull(path);
        if (metadataOrNull != null) {
            return metadataOrNull;
        }
        throw new FileNotFoundException("no such file: " + path);
    }

    public static final boolean commonExists(okio.FileSystem fileSystem, Path path) throws IOException {
        Intrinsics.checkNotNullParameter(fileSystem, "<this>");
        Intrinsics.checkNotNullParameter(path, "path");
        return fileSystem.metadataOrNull(path) != null;
    }

    public static final void commonCreateDirectories(okio.FileSystem fileSystem, Path dir, boolean z) throws IOException {
        Intrinsics.checkNotNullParameter(fileSystem, "<this>");
        Intrinsics.checkNotNullParameter(dir, "dir");
        ArrayDeque arrayDeque = new ArrayDeque();
        for (Path path = dir; path != null && !fileSystem.exists(path); path = path.parent()) {
            arrayDeque.addFirst(path);
        }
        if (z && arrayDeque.isEmpty()) {
            throw new IOException(dir + " already exists.");
        }
        Iterator it = arrayDeque.iterator();
        while (it.hasNext()) {
            okio.FileSystem.createDirectory$default(fileSystem, (Path) it.next(), false, 2, null);
        }
    }

    public static final void commonDeleteRecursively(okio.FileSystem fileSystem, Path fileOrDirectory, boolean z) throws IOException {
        Intrinsics.checkNotNullParameter(fileSystem, "<this>");
        Intrinsics.checkNotNullParameter(fileOrDirectory, "fileOrDirectory");
        Iterator it = SequencesKt.sequence(new FileSystem$commonDeleteRecursively$sequence$1(fileSystem, fileOrDirectory, null)).iterator();
        while (it.hasNext()) {
            fileSystem.delete((Path) it.next(), z && !it.hasNext());
        }
    }

    public static final Sequence<Path> commonListRecursively(okio.FileSystem fileSystem, Path dir, boolean z) throws IOException {
        Intrinsics.checkNotNullParameter(fileSystem, "<this>");
        Intrinsics.checkNotNullParameter(dir, "dir");
        return SequencesKt.sequence(new FileSystem$commonListRecursively$1(dir, fileSystem, z, null));
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x00cc, code lost:
        if (r17.yield(r1, r4) == r5) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0113, code lost:
        if (r0 != false) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0115, code lost:
        if (r11 != 0) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0117, code lost:
        r6.addLast(r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x011e, code lost:
        r13 = r1;
        r1 = r6;
        r6 = r3.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0192, code lost:
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0193, code lost:
        r12 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x01ce, code lost:
        if (r10.yield(r1, r4) == r5) goto L32;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x012a A[Catch: all -> 0x018e, TRY_LEAVE, TryCatch #2 {all -> 0x018e, blocks: (B:49:0x0124, B:51:0x012a), top: B:81:0x0124 }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01d4  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:57:0x0176 -> B:19:0x008b). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object collectRecursively(SequenceScope<? super Path> sequenceScope, okio.FileSystem fileSystem, ArrayDeque<Path> arrayDeque, Path path, boolean z, boolean z2, Continuation<? super Unit> continuation) {
        FileSystem$collectRecursively$1 fileSystem$collectRecursively$1;
        int i;
        okio.FileSystem fileSystem2;
        ArrayDeque<Path> arrayDeque2;
        boolean z3;
        SequenceScope<? super Path> sequenceScope2;
        boolean z4;
        okio.FileSystem fileSystem3;
        List<Path> listOrNull;
        int i2;
        Path path2;
        ArrayDeque<Path> arrayDeque3;
        boolean z5;
        ArrayDeque<Path> arrayDeque4;
        boolean z6;
        FileSystem$collectRecursively$1 fileSystem$collectRecursively$12;
        okio.FileSystem fileSystem4;
        SequenceScope<? super Path> sequenceScope3;
        Path path3 = path;
        boolean z7 = z2;
        if (continuation instanceof FileSystem$collectRecursively$1) {
            fileSystem$collectRecursively$1 = (FileSystem$collectRecursively$1) continuation;
            if ((fileSystem$collectRecursively$1.label & Integer.MIN_VALUE) != 0) {
                fileSystem$collectRecursively$1.label -= Integer.MIN_VALUE;
                Object obj = fileSystem$collectRecursively$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = fileSystem$collectRecursively$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    if (z7) {
                        fileSystem2 = fileSystem;
                        arrayDeque2 = arrayDeque;
                        z3 = z;
                    } else {
                        fileSystem$collectRecursively$1.L$0 = sequenceScope;
                        fileSystem2 = fileSystem;
                        fileSystem$collectRecursively$1.L$1 = fileSystem2;
                        arrayDeque2 = arrayDeque;
                        fileSystem$collectRecursively$1.L$2 = arrayDeque2;
                        fileSystem$collectRecursively$1.L$3 = path3;
                        z3 = z;
                        fileSystem$collectRecursively$1.Z$0 = z3;
                        fileSystem$collectRecursively$1.Z$1 = z7;
                        fileSystem$collectRecursively$1.label = 1;
                    }
                    boolean z8 = z3;
                    sequenceScope2 = sequenceScope;
                    z4 = z8;
                    fileSystem3 = fileSystem2;
                } else if (i == 1) {
                    boolean z9 = fileSystem$collectRecursively$1.Z$1;
                    boolean z10 = fileSystem$collectRecursively$1.Z$0;
                    Path path4 = (Path) fileSystem$collectRecursively$1.L$3;
                    arrayDeque2 = (ArrayDeque) fileSystem$collectRecursively$1.L$2;
                    fileSystem3 = (okio.FileSystem) fileSystem$collectRecursively$1.L$1;
                    sequenceScope2 = (SequenceScope) fileSystem$collectRecursively$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    z7 = z9;
                    z4 = z10;
                    path3 = path4;
                } else if (i != 2) {
                    if (i == 3) {
                        boolean z11 = fileSystem$collectRecursively$1.Z$1;
                        boolean z12 = fileSystem$collectRecursively$1.Z$0;
                        List list = (List) fileSystem$collectRecursively$1.L$4;
                        Path path5 = (Path) fileSystem$collectRecursively$1.L$3;
                        ArrayDeque arrayDeque5 = (ArrayDeque) fileSystem$collectRecursively$1.L$2;
                        okio.FileSystem fileSystem5 = (okio.FileSystem) fileSystem$collectRecursively$1.L$1;
                        SequenceScope sequenceScope4 = (SequenceScope) fileSystem$collectRecursively$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    int i3 = fileSystem$collectRecursively$1.I$0;
                    boolean z13 = fileSystem$collectRecursively$1.Z$1;
                    boolean z14 = fileSystem$collectRecursively$1.Z$0;
                    Path path6 = (Path) fileSystem$collectRecursively$1.L$7;
                    Iterator<Path> it = (Iterator) fileSystem$collectRecursively$1.L$6;
                    Path path7 = (Path) fileSystem$collectRecursively$1.L$5;
                    List<Path> list2 = (List) fileSystem$collectRecursively$1.L$4;
                    Path path8 = (Path) fileSystem$collectRecursively$1.L$3;
                    ArrayDeque<Path> arrayDeque6 = (ArrayDeque) fileSystem$collectRecursively$1.L$2;
                    okio.FileSystem fileSystem6 = (okio.FileSystem) fileSystem$collectRecursively$1.L$1;
                    SequenceScope<? super Path> sequenceScope5 = (SequenceScope) fileSystem$collectRecursively$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                        i2 = i3;
                        z4 = z14;
                        z7 = z13;
                        ArrayDeque<Path> arrayDeque7 = arrayDeque6;
                        path2 = path7;
                        fileSystem3 = fileSystem6;
                        Path path9 = path8;
                        listOrNull = list2;
                        sequenceScope2 = sequenceScope5;
                        try {
                            if (!it.hasNext()) {
                                try {
                                    Path next = it.next();
                                    fileSystem$collectRecursively$1.L$0 = sequenceScope2;
                                    fileSystem$collectRecursively$1.L$1 = fileSystem3;
                                    fileSystem$collectRecursively$1.L$2 = arrayDeque7;
                                    fileSystem$collectRecursively$1.L$3 = path9;
                                    fileSystem$collectRecursively$1.L$4 = SpillingKt.nullOutSpilledVariable(listOrNull);
                                    fileSystem$collectRecursively$1.L$5 = SpillingKt.nullOutSpilledVariable(path2);
                                    fileSystem$collectRecursively$1.L$6 = it;
                                    fileSystem$collectRecursively$1.L$7 = SpillingKt.nullOutSpilledVariable(next);
                                    fileSystem$collectRecursively$1.Z$0 = z4;
                                    fileSystem$collectRecursively$1.Z$1 = z7;
                                    fileSystem$collectRecursively$1.I$0 = i2;
                                    fileSystem$collectRecursively$1.label = 2;
                                    Object collectRecursively = collectRecursively(sequenceScope3, fileSystem4, arrayDeque4, next, z5, z6, fileSystem$collectRecursively$12);
                                    sequenceScope5 = sequenceScope3;
                                    fileSystem$collectRecursively$1 = fileSystem$collectRecursively$12;
                                    if (collectRecursively != coroutine_suspended) {
                                        z4 = z5;
                                        z7 = z6;
                                        arrayDeque7 = arrayDeque4;
                                        fileSystem3 = fileSystem4;
                                        sequenceScope2 = sequenceScope5;
                                        if (!it.hasNext()) {
                                            SequenceScope<? super Path> sequenceScope6 = sequenceScope2;
                                            okio.FileSystem fileSystem7 = fileSystem3;
                                            ArrayDeque<Path> arrayDeque8 = arrayDeque7;
                                            arrayDeque8.removeLast();
                                            arrayDeque2 = arrayDeque8;
                                            fileSystem3 = fileSystem7;
                                            sequenceScope2 = sequenceScope6;
                                            z7 = z7;
                                            path3 = path9;
                                            if (!z7) {
                                                return Unit.INSTANCE;
                                            }
                                            fileSystem$collectRecursively$1.L$0 = SpillingKt.nullOutSpilledVariable(sequenceScope2);
                                            fileSystem$collectRecursively$1.L$1 = SpillingKt.nullOutSpilledVariable(fileSystem3);
                                            fileSystem$collectRecursively$1.L$2 = SpillingKt.nullOutSpilledVariable(arrayDeque2);
                                            fileSystem$collectRecursively$1.L$3 = SpillingKt.nullOutSpilledVariable(path3);
                                            fileSystem$collectRecursively$1.L$4 = SpillingKt.nullOutSpilledVariable(listOrNull);
                                            fileSystem$collectRecursively$1.L$5 = null;
                                            fileSystem$collectRecursively$1.L$6 = null;
                                            fileSystem$collectRecursively$1.L$7 = null;
                                            fileSystem$collectRecursively$1.Z$0 = z4;
                                            fileSystem$collectRecursively$1.Z$1 = z7;
                                            fileSystem$collectRecursively$1.label = 3;
                                        }
                                    }
                                    return coroutine_suspended;
                                } catch (Throwable th) {
                                    th = th;
                                    arrayDeque3 = arrayDeque4;
                                    arrayDeque6 = arrayDeque3;
                                    arrayDeque6.removeLast();
                                    throw th;
                                }
                                z5 = z4;
                                arrayDeque4 = arrayDeque7;
                                z6 = z7;
                                fileSystem$collectRecursively$12 = fileSystem$collectRecursively$1;
                                fileSystem4 = fileSystem3;
                                sequenceScope3 = sequenceScope2;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            arrayDeque3 = arrayDeque7;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        arrayDeque6.removeLast();
                        throw th;
                    }
                }
                listOrNull = fileSystem3.listOrNull(path3);
                if (listOrNull == null) {
                    listOrNull = CollectionsKt.emptyList();
                }
                if (!listOrNull.isEmpty()) {
                    i2 = 0;
                    path2 = path3;
                    while (true) {
                        if (z4 && arrayDeque2.contains(path2)) {
                            throw new IOException("symlink cycle at " + path3);
                        }
                        Path symlinkTarget = symlinkTarget(fileSystem3, path2);
                        if (symlinkTarget == null) {
                            break;
                        }
                        i2++;
                        path2 = symlinkTarget;
                    }
                }
                if (!z7) {
                }
            }
        }
        fileSystem$collectRecursively$1 = new FileSystem$collectRecursively$1(continuation);
        Object obj2 = fileSystem$collectRecursively$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = fileSystem$collectRecursively$1.label;
        if (i != 0) {
        }
        listOrNull = fileSystem3.listOrNull(path3);
        if (listOrNull == null) {
        }
        if (!listOrNull.isEmpty()) {
        }
        if (!z7) {
        }
    }

    public static final Path symlinkTarget(okio.FileSystem fileSystem, Path path) throws IOException {
        Intrinsics.checkNotNullParameter(fileSystem, "<this>");
        Intrinsics.checkNotNullParameter(path, "path");
        Path symlinkTarget = fileSystem.metadata(path).getSymlinkTarget();
        if (symlinkTarget == null) {
            return null;
        }
        Path parent = path.parent();
        Intrinsics.checkNotNull(parent);
        return parent.resolve(symlinkTarget);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v8, types: [java.lang.Long] */
    public static final void commonCopy(okio.FileSystem fileSystem, Path source, Path target) throws IOException {
        Long valueOf;
        Intrinsics.checkNotNullParameter(fileSystem, "<this>");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(target, "target");
        Source source2 = fileSystem.source(source);
        Throwable th = null;
        try {
            Source source3 = source2;
            BufferedSink buffer = Okio.buffer(okio.FileSystem.sink$default(fileSystem, target, false, 2, null));
            valueOf = Long.valueOf(buffer.writeAll(source3));
            if (buffer != null) {
                try {
                    buffer.close();
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            th = null;
        } catch (Throwable th3) {
            th = th3;
            if (source2 != null) {
                try {
                    source2.close();
                } catch (Throwable th4) {
                    ExceptionsKt.addSuppressed(th, th4);
                }
            }
        }
        if (th == null) {
            ?? valueOf2 = Long.valueOf(valueOf.longValue());
            if (source2 != null) {
                try {
                    source2.close();
                } catch (Throwable th5) {
                    th = th5;
                }
            }
            Throwable th6 = th;
            th = valueOf2;
            th = th6;
            if (th != null) {
                throw th;
            }
            return;
        }
        throw th;
    }
}
