package kotlin.io.path;

import com.google.android.vending.expansion.downloader.impl.DownloaderService;
import java.nio.file.FileSystemLoopException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.util.Arrays;
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
import kotlin.sequences.SequenceScope;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PathTreeWalk.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlin/sequences/SequenceScope;", "Ljava/nio/file/Path;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kotlin.io.path.PathTreeWalk$bfsIterator$1", f = "PathTreeWalk.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1}, l = {191, DownloaderService.STATUS_QUEUED_FOR_WIFI}, m = "invokeSuspend", n = {"$this$iterator", "queue", "entriesReader", "pathNode", "this_$iv", "$this$yieldIfNeeded$iv", "path$iv", "$i$f$yieldIfNeeded", "$this$iterator", "queue", "entriesReader", "pathNode", "this_$iv", "$this$yieldIfNeeded$iv", "path$iv", "$i$f$yieldIfNeeded"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "I$0"})
/* loaded from: classes5.dex */
public final class PathTreeWalk$bfsIterator$1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super Path>, Continuation<? super Unit>, Object> {
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    int label;
    final /* synthetic */ PathTreeWalk this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PathTreeWalk$bfsIterator$1(PathTreeWalk pathTreeWalk, Continuation<? super PathTreeWalk$bfsIterator$1> continuation) {
        super(2, continuation);
        this.this$0 = pathTreeWalk;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        PathTreeWalk$bfsIterator$1 pathTreeWalk$bfsIterator$1 = new PathTreeWalk$bfsIterator$1(this.this$0, continuation);
        pathTreeWalk$bfsIterator$1.L$0 = obj;
        return pathTreeWalk$bfsIterator$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(SequenceScope<? super Path> sequenceScope, Continuation<? super Unit> continuation) {
        return ((PathTreeWalk$bfsIterator$1) create(sequenceScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x010d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x010b -> B:11:0x0086). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x010d -> B:11:0x0086). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        DirectoryEntriesReader directoryEntriesReader;
        boolean followLinks;
        Path path;
        Path path2;
        Object keyOf;
        ArrayDeque arrayDeque;
        PathTreeWalk pathTreeWalk;
        Path path3;
        PathNode pathNode;
        LinkOption[] linkOptionArr;
        ArrayDeque arrayDeque2;
        DirectoryEntriesReader directoryEntriesReader2;
        PathTreeWalk pathTreeWalk2;
        Path path4;
        boolean createsCycle;
        SequenceScope sequenceScope = (SequenceScope) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            ArrayDeque arrayDeque3 = new ArrayDeque();
            followLinks = this.this$0.getFollowLinks();
            directoryEntriesReader = new DirectoryEntriesReader(followLinks);
            path = this.this$0.start;
            path2 = this.this$0.start;
            keyOf = PathTreeWalkKt.keyOf(path2, this.this$0.getLinkOptions());
            arrayDeque3.addLast(new PathNode(path, keyOf, null));
            arrayDeque = arrayDeque3;
        } else if (i == 1) {
            path4 = (Path) this.L$6;
            SequenceScope sequenceScope2 = (SequenceScope) this.L$5;
            pathTreeWalk2 = (PathTreeWalk) this.L$4;
            pathNode = (PathNode) this.L$3;
            directoryEntriesReader2 = (DirectoryEntriesReader) this.L$2;
            arrayDeque2 = (ArrayDeque) this.L$1;
            ResultKt.throwOnFailure(obj);
            DirectoryEntriesReader directoryEntriesReader3 = directoryEntriesReader2;
            path3 = path4;
            directoryEntriesReader = directoryEntriesReader3;
            pathTreeWalk = pathTreeWalk2;
            arrayDeque = arrayDeque2;
            LinkOption[] linkOptions = pathTreeWalk.getLinkOptions();
            linkOptionArr = (LinkOption[]) Arrays.copyOf(linkOptions, linkOptions.length);
            if (Files.isDirectory(path3, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length))) {
                arrayDeque.addAll(directoryEntriesReader.readEntries(pathNode));
            }
        } else if (i != 2) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            Path path5 = (Path) this.L$6;
            SequenceScope sequenceScope3 = (SequenceScope) this.L$5;
            PathTreeWalk pathTreeWalk3 = (PathTreeWalk) this.L$4;
            PathNode pathNode2 = (PathNode) this.L$3;
            directoryEntriesReader = (DirectoryEntriesReader) this.L$2;
            arrayDeque = (ArrayDeque) this.L$1;
            ResultKt.throwOnFailure(obj);
        }
        while (!arrayDeque.isEmpty()) {
            pathNode = (PathNode) arrayDeque.removeFirst();
            pathTreeWalk = this.this$0;
            path3 = pathNode.getPath();
            if (pathNode.getParent() != null) {
                PathsKt.checkFileName(path3);
            }
            LinkOption[] linkOptions2 = pathTreeWalk.getLinkOptions();
            LinkOption[] linkOptionArr2 = (LinkOption[]) Arrays.copyOf(linkOptions2, linkOptions2.length);
            if (Files.isDirectory(path3, (LinkOption[]) Arrays.copyOf(linkOptionArr2, linkOptionArr2.length))) {
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
                            directoryEntriesReader2 = directoryEntriesReader;
                            path4 = path3;
                            arrayDeque2 = arrayDeque;
                            pathTreeWalk2 = pathTreeWalk;
                            DirectoryEntriesReader directoryEntriesReader32 = directoryEntriesReader2;
                            path3 = path4;
                            directoryEntriesReader = directoryEntriesReader32;
                            pathTreeWalk = pathTreeWalk2;
                            arrayDeque = arrayDeque2;
                        }
                    }
                    LinkOption[] linkOptions3 = pathTreeWalk.getLinkOptions();
                    linkOptionArr = (LinkOption[]) Arrays.copyOf(linkOptions3, linkOptions3.length);
                    if (Files.isDirectory(path3, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length))) {
                    }
                    while (!arrayDeque.isEmpty()) {
                    }
                } else {
                    throw new FileSystemLoopException(path3.toString());
                }
            } else if (Files.exists(path3, (LinkOption[]) Arrays.copyOf(new LinkOption[]{LinkOption.NOFOLLOW_LINKS}, 1))) {
                this.L$0 = sequenceScope;
                this.L$1 = arrayDeque;
                this.L$2 = directoryEntriesReader;
                this.L$3 = SpillingKt.nullOutSpilledVariable(pathNode);
                this.L$4 = SpillingKt.nullOutSpilledVariable(pathTreeWalk);
                this.L$5 = SpillingKt.nullOutSpilledVariable(sequenceScope);
                this.L$6 = SpillingKt.nullOutSpilledVariable(path3);
                this.I$0 = 0;
                this.label = 2;
                if (sequenceScope.yield(path3, this) == coroutine_suspended) {
                }
            }
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }
}
