package kotlin.io.path;

import com.google.android.vending.expansion.downloader.impl.DownloaderService;
import java.nio.file.FileSystemLoopException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequenceScope;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PathTreeWalk.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlin/sequences/SequenceScope;", "Ljava/nio/file/Path;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kotlin.io.path.PathTreeWalk$dfsIterator$1", f = "PathTreeWalk.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}, l = {191, DownloaderService.STATUS_QUEUED_FOR_WIFI, 210, 216}, m = "invokeSuspend", n = {"$this$iterator", "stack", "entriesReader", "startNode", "this_$iv", "$this$yieldIfNeeded$iv", "path$iv", "$i$f$yieldIfNeeded", "$this$iterator", "stack", "entriesReader", "startNode", "this_$iv", "$this$yieldIfNeeded$iv", "path$iv", "$i$f$yieldIfNeeded", "$this$iterator", "stack", "entriesReader", "startNode", "topNode", "topIterator", "pathNode", "this_$iv", "$this$yieldIfNeeded$iv", "path$iv", "$i$f$yieldIfNeeded", "$this$iterator", "stack", "entriesReader", "startNode", "topNode", "topIterator", "pathNode", "this_$iv", "$this$yieldIfNeeded$iv", "path$iv", "$i$f$yieldIfNeeded"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "I$0"})
/* loaded from: classes5.dex */
public final class PathTreeWalk$dfsIterator$1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super Path>, Continuation<? super Unit>, Object> {
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    Object L$8;
    Object L$9;
    int label;
    final /* synthetic */ PathTreeWalk this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PathTreeWalk$dfsIterator$1(PathTreeWalk pathTreeWalk, Continuation<? super PathTreeWalk$dfsIterator$1> continuation) {
        super(2, continuation);
        this.this$0 = pathTreeWalk;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        PathTreeWalk$dfsIterator$1 pathTreeWalk$dfsIterator$1 = new PathTreeWalk$dfsIterator$1(this.this$0, continuation);
        pathTreeWalk$dfsIterator$1.L$0 = obj;
        return pathTreeWalk$dfsIterator$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(SequenceScope<? super Path> sequenceScope, Continuation<? super Unit> continuation) {
        return ((PathTreeWalk$dfsIterator$1) create(sequenceScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x01a9, code lost:
        if (r1.yield(r12, r16) == r2) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x02c6, code lost:
        if (r1.yield(r14, r16) == r2) goto L26;
     */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x025d  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x02d3  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:60:0x026b -> B:39:0x01af). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:66:0x02c6 -> B:68:0x02c9). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:69:0x02cc -> B:68:0x02c9). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:70:0x02ce -> B:68:0x02c9). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        ArrayDeque arrayDeque;
        DirectoryEntriesReader directoryEntriesReader;
        boolean followLinks;
        PathNode pathNode;
        Path path;
        Path path2;
        Object keyOf;
        PathTreeWalk pathTreeWalk;
        Path path3;
        boolean createsCycle;
        PathTreeWalk pathTreeWalk2;
        ArrayDeque arrayDeque2;
        PathNode pathNode2;
        DirectoryEntriesReader directoryEntriesReader2;
        Path path4;
        DirectoryEntriesReader directoryEntriesReader3;
        PathNode pathNode3;
        LinkOption[] linkOptionArr;
        Path path5;
        PathTreeWalk pathTreeWalk3;
        PathNode pathNode4;
        LinkOption[] linkOptionArr2;
        ArrayDeque arrayDeque3;
        DirectoryEntriesReader directoryEntriesReader4;
        PathNode pathNode5;
        PathNode pathNode6;
        PathTreeWalk pathTreeWalk4;
        Path path6;
        boolean createsCycle2;
        SequenceScope sequenceScope = (SequenceScope) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        char c = 4;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            arrayDeque = new ArrayDeque();
            followLinks = this.this$0.getFollowLinks();
            directoryEntriesReader = new DirectoryEntriesReader(followLinks);
            path = this.this$0.start;
            path2 = this.this$0.start;
            keyOf = PathTreeWalkKt.keyOf(path2, this.this$0.getLinkOptions());
            pathNode = new PathNode(path, keyOf, null);
            pathTreeWalk = this.this$0;
            path3 = pathNode.getPath();
            if (pathNode.getParent() != null) {
                PathsKt.checkFileName(path3);
            }
            LinkOption[] linkOptions = pathTreeWalk.getLinkOptions();
            LinkOption[] linkOptionArr3 = (LinkOption[]) Arrays.copyOf(linkOptions, linkOptions.length);
            if (Files.isDirectory(path3, (LinkOption[]) Arrays.copyOf(linkOptionArr3, linkOptionArr3.length))) {
                createsCycle = PathTreeWalkKt.createsCycle(pathNode);
                if (!createsCycle) {
                    if (pathTreeWalk.getIncludeDirectories()) {
                        this.L$0 = sequenceScope;
                        this.L$1 = arrayDeque;
                        this.L$2 = directoryEntriesReader;
                        this.L$3 = pathNode;
                        this.L$4 = pathTreeWalk;
                        this.L$5 = SpillingKt.nullOutSpilledVariable(sequenceScope);
                        this.L$6 = path3;
                        this.I$0 = 0;
                        this.label = 1;
                        if (sequenceScope.yield(path3, this) != coroutine_suspended) {
                            pathTreeWalk2 = pathTreeWalk;
                            arrayDeque2 = arrayDeque;
                            pathNode2 = pathNode;
                            directoryEntriesReader2 = directoryEntriesReader;
                            path4 = path3;
                        }
                    }
                    LinkOption[] linkOptions2 = pathTreeWalk.getLinkOptions();
                    linkOptionArr = (LinkOption[]) Arrays.copyOf(linkOptions2, linkOptions2.length);
                    if (Files.isDirectory(path3, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length))) {
                        pathNode.setContentIterator(directoryEntriesReader.readEntries(pathNode).iterator());
                        arrayDeque.addLast(pathNode);
                    }
                    directoryEntriesReader3 = directoryEntriesReader;
                    pathNode3 = pathNode;
                    if (arrayDeque.isEmpty()) {
                    }
                } else {
                    throw new FileSystemLoopException(path3.toString());
                }
            } else {
                if (Files.exists(path3, (LinkOption[]) Arrays.copyOf(new LinkOption[]{LinkOption.NOFOLLOW_LINKS}, 1))) {
                    this.L$0 = sequenceScope;
                    this.L$1 = arrayDeque;
                    this.L$2 = directoryEntriesReader;
                    this.L$3 = SpillingKt.nullOutSpilledVariable(pathNode);
                    this.L$4 = SpillingKt.nullOutSpilledVariable(pathTreeWalk);
                    this.L$5 = SpillingKt.nullOutSpilledVariable(sequenceScope);
                    this.L$6 = SpillingKt.nullOutSpilledVariable(path3);
                    this.I$0 = 0;
                    this.label = 2;
                }
                directoryEntriesReader3 = directoryEntriesReader;
                pathNode3 = pathNode;
                if (arrayDeque.isEmpty()) {
                }
            }
            return coroutine_suspended;
        } else if (i == 1) {
            path4 = (Path) this.L$6;
            SequenceScope sequenceScope2 = (SequenceScope) this.L$5;
            pathTreeWalk2 = (PathTreeWalk) this.L$4;
            pathNode2 = (PathNode) this.L$3;
            directoryEntriesReader2 = (DirectoryEntriesReader) this.L$2;
            arrayDeque2 = (ArrayDeque) this.L$1;
            ResultKt.throwOnFailure(obj);
        } else if (i == 2) {
            Path path7 = (Path) this.L$6;
            SequenceScope sequenceScope3 = (SequenceScope) this.L$5;
            PathTreeWalk pathTreeWalk5 = (PathTreeWalk) this.L$4;
            pathNode3 = (PathNode) this.L$3;
            directoryEntriesReader3 = (DirectoryEntriesReader) this.L$2;
            arrayDeque = (ArrayDeque) this.L$1;
            ResultKt.throwOnFailure(obj);
            if (arrayDeque.isEmpty()) {
            }
        } else if (i == 3) {
            path6 = (Path) this.L$9;
            SequenceScope sequenceScope4 = (SequenceScope) this.L$8;
            pathTreeWalk4 = (PathTreeWalk) this.L$7;
            pathNode6 = (PathNode) this.L$6;
            Iterator it = (Iterator) this.L$5;
            PathNode pathNode7 = (PathNode) this.L$4;
            pathNode5 = (PathNode) this.L$3;
            directoryEntriesReader4 = (DirectoryEntriesReader) this.L$2;
            arrayDeque3 = (ArrayDeque) this.L$1;
            ResultKt.throwOnFailure(obj);
            ArrayDeque arrayDeque4 = arrayDeque3;
            pathNode4 = pathNode6;
            arrayDeque = arrayDeque4;
            path5 = path6;
            pathTreeWalk3 = pathTreeWalk4;
            pathNode3 = pathNode5;
            directoryEntriesReader3 = directoryEntriesReader4;
            LinkOption[] linkOptions3 = pathTreeWalk3.getLinkOptions();
            linkOptionArr2 = (LinkOption[]) Arrays.copyOf(linkOptions3, linkOptions3.length);
            if (Files.isDirectory(path5, (LinkOption[]) Arrays.copyOf(linkOptionArr2, linkOptionArr2.length))) {
            }
            c = 4;
            if (arrayDeque.isEmpty()) {
            }
        } else if (i != 4) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            Path path8 = (Path) this.L$9;
            SequenceScope sequenceScope5 = (SequenceScope) this.L$8;
            PathTreeWalk pathTreeWalk6 = (PathTreeWalk) this.L$7;
            PathNode pathNode8 = (PathNode) this.L$6;
            Iterator it2 = (Iterator) this.L$5;
            PathNode pathNode9 = (PathNode) this.L$4;
            pathNode3 = (PathNode) this.L$3;
            directoryEntriesReader3 = (DirectoryEntriesReader) this.L$2;
            arrayDeque = (ArrayDeque) this.L$1;
            ResultKt.throwOnFailure(obj);
            char c2 = 4;
            c = c2;
            if (arrayDeque.isEmpty()) {
                PathNode pathNode10 = (PathNode) arrayDeque.last();
                Iterator<PathNode> contentIterator = pathNode10.getContentIterator();
                Intrinsics.checkNotNull(contentIterator);
                if (contentIterator.hasNext()) {
                    pathNode4 = contentIterator.next();
                    pathTreeWalk3 = this.this$0;
                    path5 = pathNode4.getPath();
                    if (pathNode4.getParent() != null) {
                        PathsKt.checkFileName(path5);
                    }
                    LinkOption[] linkOptions4 = pathTreeWalk3.getLinkOptions();
                    LinkOption[] linkOptionArr4 = (LinkOption[]) Arrays.copyOf(linkOptions4, linkOptions4.length);
                    if (Files.isDirectory(path5, (LinkOption[]) Arrays.copyOf(linkOptionArr4, linkOptionArr4.length))) {
                        createsCycle2 = PathTreeWalkKt.createsCycle(pathNode4);
                        if (!createsCycle2) {
                            if (pathTreeWalk3.getIncludeDirectories()) {
                                this.L$0 = sequenceScope;
                                this.L$1 = arrayDeque;
                                this.L$2 = directoryEntriesReader3;
                                this.L$3 = SpillingKt.nullOutSpilledVariable(pathNode3);
                                this.L$4 = SpillingKt.nullOutSpilledVariable(pathNode10);
                                this.L$5 = SpillingKt.nullOutSpilledVariable(contentIterator);
                                this.L$6 = pathNode4;
                                this.L$7 = pathTreeWalk3;
                                this.L$8 = SpillingKt.nullOutSpilledVariable(sequenceScope);
                                this.L$9 = path5;
                                this.I$0 = 0;
                                this.label = 3;
                                if (sequenceScope.yield(path5, this) != coroutine_suspended) {
                                    arrayDeque3 = arrayDeque;
                                    pathNode6 = pathNode4;
                                    pathNode5 = pathNode3;
                                    directoryEntriesReader4 = directoryEntriesReader3;
                                    pathTreeWalk4 = pathTreeWalk3;
                                    path6 = path5;
                                    ArrayDeque arrayDeque42 = arrayDeque3;
                                    pathNode4 = pathNode6;
                                    arrayDeque = arrayDeque42;
                                    path5 = path6;
                                    pathTreeWalk3 = pathTreeWalk4;
                                    pathNode3 = pathNode5;
                                    directoryEntriesReader3 = directoryEntriesReader4;
                                }
                            }
                            LinkOption[] linkOptions32 = pathTreeWalk3.getLinkOptions();
                            linkOptionArr2 = (LinkOption[]) Arrays.copyOf(linkOptions32, linkOptions32.length);
                            if (Files.isDirectory(path5, (LinkOption[]) Arrays.copyOf(linkOptionArr2, linkOptionArr2.length))) {
                                pathNode4.setContentIterator(directoryEntriesReader3.readEntries(pathNode4).iterator());
                                arrayDeque.addLast(pathNode4);
                            }
                            c = 4;
                            if (arrayDeque.isEmpty()) {
                                return Unit.INSTANCE;
                            }
                        } else {
                            throw new FileSystemLoopException(path5.toString());
                        }
                    } else if (Files.exists(path5, (LinkOption[]) Arrays.copyOf(new LinkOption[]{LinkOption.NOFOLLOW_LINKS}, 1))) {
                        this.L$0 = sequenceScope;
                        this.L$1 = arrayDeque;
                        this.L$2 = directoryEntriesReader3;
                        this.L$3 = SpillingKt.nullOutSpilledVariable(pathNode3);
                        this.L$4 = SpillingKt.nullOutSpilledVariable(pathNode10);
                        this.L$5 = SpillingKt.nullOutSpilledVariable(contentIterator);
                        this.L$6 = SpillingKt.nullOutSpilledVariable(pathNode4);
                        this.L$7 = SpillingKt.nullOutSpilledVariable(pathTreeWalk3);
                        this.L$8 = SpillingKt.nullOutSpilledVariable(sequenceScope);
                        this.L$9 = SpillingKt.nullOutSpilledVariable(path5);
                        this.I$0 = 0;
                        c2 = 4;
                        this.label = 4;
                    } else {
                        c2 = 4;
                    }
                    return coroutine_suspended;
                }
                c2 = c;
                arrayDeque.removeLast();
                c = c2;
                if (arrayDeque.isEmpty()) {
                }
            }
        }
        path3 = path4;
        directoryEntriesReader = directoryEntriesReader2;
        pathNode = pathNode2;
        arrayDeque = arrayDeque2;
        pathTreeWalk = pathTreeWalk2;
        LinkOption[] linkOptions22 = pathTreeWalk.getLinkOptions();
        linkOptionArr = (LinkOption[]) Arrays.copyOf(linkOptions22, linkOptions22.length);
        if (Files.isDirectory(path3, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length))) {
        }
        directoryEntriesReader3 = directoryEntriesReader;
        pathNode3 = pathNode;
        if (arrayDeque.isEmpty()) {
        }
    }
}
