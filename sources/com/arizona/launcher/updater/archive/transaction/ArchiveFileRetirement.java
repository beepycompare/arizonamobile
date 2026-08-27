package com.arizona.launcher.updater.archive.transaction;

import com.arizona.launcher.updater.archive.io.ArchiveFsNodeType;
import com.arizona.launcher.updater.archive.transaction.ArchiveRetirementResult;
import com.arizona.launcher.updater.archive.transaction.ArchiveTrashCleanupResult;
import com.facebook.internal.AnalyticsEvents;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
/* compiled from: ArchiveFileRetirement.kt */
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u0000 G2\u00020\u0001:\u0006BCDEFGB\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001c\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eJ\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\fJ\u0015\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH\u0000¢\u0006\u0002\b\u0013J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u0003H\u0002J,\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\f0\u001d2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\f0\u001dH\u0002J.\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010\u001a\u001a\u00020!2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\f0\u001d2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\f0\u001dH\u0002J\u0018\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00032\u0006\u0010%\u001a\u00020\u0003H\u0002J(\u0010&\u001a\b\u0012\u0004\u0012\u00020\f0\u001d*\b\u0012\u0004\u0012\u00020\f0\u001d2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010'\u001a\u00020(H\u0002J\n\u0010)\u001a\u0004\u0018\u00010 H\u0002J\u0012\u0010*\u001a\u0004\u0018\u00010 2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0018\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u00032\u0006\u0010.\u001a\u00020\fH\u0002J\u0010\u0010/\u001a\u00020,2\u0006\u00100\u001a\u00020\u0003H\u0002J\u0010\u00101\u001a\u00020#2\u0006\u00102\u001a\u00020\u0003H\u0002J \u00103\u001a\u00020#2\u0006\u00104\u001a\u00020\u00032\u0006\u00105\u001a\u00020\u00032\u0006\u00106\u001a\u000207H\u0002J\u0018\u00108\u001a\u00020\u00032\u0006\u0010-\u001a\u00020\u00032\u0006\u0010.\u001a\u00020\fH\u0002J\u0018\u00109\u001a\u00020(2\u0006\u00100\u001a\u00020\u00032\u0006\u0010-\u001a\u00020\u0003H\u0002J\u0018\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020=2\u0006\u0010\u0016\u001a\u00020\u000fH\u0002J@\u0010>\u001a\u00020 2\u0006\u0010<\u001a\u00020=2\u0006\u0010\u0016\u001a\u00020\u000f2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\f0\u001d2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\f0\u001d2\n\b\u0002\u0010?\u001a\u0004\u0018\u00010\fH\u0002J\f\u0010@\u001a\u00020 *\u00020AH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0002\u001a\n \b*\u0004\u0018\u00010\u00030\u0003X\u0082\u0004¢\u0006\u0002\n\u0000Ê\u0001\f\bI\u0012\b\bJ\u0012\u0004\b\u0003\u0010\u0000¨\u0006H"}, d2 = {"Lcom/arizona/launcher/updater/archive/transaction/ArchiveFileRetirement;", "", "gameRoot", "Ljava/io/File;", "fileOps", "Lcom/arizona/launcher/updater/archive/transaction/ArchiveRetirementFileOps;", "<init>", "(Ljava/io/File;Lcom/arizona/launcher/updater/archive/transaction/ArchiveRetirementFileOps;)V", "kotlin.jvm.PlatformType", "quarantine", "Lcom/arizona/launcher/updater/archive/transaction/ArchiveRetirementResult;", "transactionId", "", ArchiveFileRetirement.TRASH_ROOT, "", "Lcom/arizona/launcher/updater/archive/transaction/ArchiveOwnedPath;", "cleanupTrash", "Lcom/arizona/launcher/updater/archive/transaction/ArchiveTrashCleanupResult;", "transactionTrashRoot", "transactionTrashRoot$app", "inspectAction", "Lcom/arizona/launcher/updater/archive/transaction/ArchiveFileRetirement$ActionInspection;", "owned", "trashRoot", "moveOne", "Lcom/arizona/launcher/updater/archive/transaction/ArchiveFileRetirement$MoveOutcome;", "action", "Lcom/arizona/launcher/updater/archive/transaction/ArchiveFileRetirement$RetirementAction$Move;", "quarantined", "", "alreadyQuarantined", "finishAlreadyQuarantined", "Lcom/arizona/launcher/updater/archive/transaction/ArchiveRetirementResult$Failure;", "Lcom/arizona/launcher/updater/archive/transaction/ArchiveFileRetirement$RetirementAction$AlreadyQuarantined;", "syncCompletedRename", "", "source", "trash", "afterCompletedRename", "renameCompleted", "", "validateGameRoot", "validateTransactionId", "inspectWithoutFollowing", "Lcom/arizona/launcher/updater/archive/io/ArchiveFsNodeType;", "root", "relativePath", "inspectAbsoluteWithoutFollowing", "candidate", "ensureDirectoryChain", "directory", "cleanupNode", "node", "deletionRoot", "counter", "Lcom/arizona/launcher/updater/archive/transaction/ArchiveFileRetirement$CleanupCounter;", "child", "isWithin", "failed", "Lcom/arizona/launcher/updater/archive/transaction/ArchiveFileRetirement$ActionInspection$Failed;", "code", "Lcom/arizona/launcher/updater/archive/transaction/ArchiveRetirementErrorCode;", "operationFailure", "detail", "toResult", "Lcom/arizona/launcher/updater/archive/transaction/ArchiveFileRetirement$RetirementFailure;", "RetirementAction", "ActionInspection", "MoveOutcome", "CleanupCounter", "RetirementFailure", "Companion", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ArchiveFileRetirement {
    @Deprecated
    public static final String TRANSACTIONS_ROOT = "transactions";
    @Deprecated
    public static final String TRASH_ROOT = "retired";
    @Deprecated
    public static final String WORK_ROOT = ".archive-installing";
    private final ArchiveRetirementFileOps fileOps;
    private final File gameRoot;
    private static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private static final Regex TRANSACTION_ID = new Regex("[A-Za-z0-9][A-Za-z0-9._-]{0,95}");

    /* compiled from: ArchiveFileRetirement.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ArchiveFsNodeType.values().length];
            try {
                iArr[ArchiveFsNodeType.ABSENT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ArchiveFsNodeType.DIRECTORY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ArchiveFsNodeType.SYMBOLIC_LINK.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ArchiveFsNodeType.REGULAR_FILE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[ArchiveFsNodeType.OTHER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public ArchiveFileRetirement(File gameRoot, ArchiveRetirementFileOps fileOps) {
        Intrinsics.checkNotNullParameter(gameRoot, "gameRoot");
        Intrinsics.checkNotNullParameter(fileOps, "fileOps");
        this.fileOps = fileOps;
        this.gameRoot = gameRoot.getAbsoluteFile();
    }

    public /* synthetic */ ArchiveFileRetirement(File file, AndroidArchiveRetirementFileOps androidArchiveRetirementFileOps, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(file, (i & 2) != 0 ? AndroidArchiveRetirementFileOps.INSTANCE : androidArchiveRetirementFileOps);
    }

    public final ArchiveRetirementResult quarantine(String transactionId, Iterable<ArchiveOwnedPath> retired) {
        Intrinsics.checkNotNullParameter(transactionId, "transactionId");
        Intrinsics.checkNotNullParameter(retired, "retired");
        ArchiveRetirementResult.Failure validateTransactionId = validateTransactionId(transactionId);
        if (validateTransactionId != null) {
            return validateTransactionId;
        }
        try {
            List<ArchiveOwnedPath> list = CollectionsKt.toList(ArchiveOwnershipDiffPlanner.INSTANCE.validatedOwnership(retired, "retired ownership").values());
            ArchiveRetirementResult.Failure validateGameRoot = validateGameRoot();
            if (validateGameRoot != null) {
                return validateGameRoot;
            }
            File transactionTrashRoot$app = transactionTrashRoot$app(transactionId);
            ArrayList arrayList = new ArrayList(list.size());
            for (ArchiveOwnedPath archiveOwnedPath : list) {
                ActionInspection inspectAction = inspectAction(archiveOwnedPath, transactionTrashRoot$app);
                if (!(inspectAction instanceof ActionInspection.Ready)) {
                    if (inspectAction instanceof ActionInspection.Failed) {
                        return ((ActionInspection.Failed) inspectAction).getFailure();
                    }
                    throw new NoWhenBranchMatchedException();
                }
                arrayList.add(((ActionInspection.Ready) inspectAction).getAction());
            }
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            Iterator it = arrayList.iterator();
            Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
            while (it.hasNext()) {
                Object next = it.next();
                Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                RetirementAction retirementAction = (RetirementAction) next;
                if (!(retirementAction instanceof RetirementAction.AlreadyAbsent)) {
                    if (retirementAction instanceof RetirementAction.AlreadyQuarantined) {
                        RetirementAction.AlreadyQuarantined alreadyQuarantined = (RetirementAction.AlreadyQuarantined) retirementAction;
                        ArchiveRetirementResult.Failure finishAlreadyQuarantined = finishAlreadyQuarantined(alreadyQuarantined, arrayList2, arrayList3);
                        if (finishAlreadyQuarantined != null) {
                            return finishAlreadyQuarantined;
                        }
                        arrayList3.add(alreadyQuarantined.getOwned().getRelativePath());
                    } else if (!(retirementAction instanceof RetirementAction.Move)) {
                        throw new NoWhenBranchMatchedException();
                    } else {
                        RetirementAction.Move move = (RetirementAction.Move) retirementAction;
                        MoveOutcome moveOne = moveOne(move, arrayList2, arrayList3);
                        if (Intrinsics.areEqual(moveOne, MoveOutcome.Moved.INSTANCE)) {
                            arrayList2.add(move.getOwned().getRelativePath());
                        } else if (Intrinsics.areEqual(moveOne, MoveOutcome.AlreadyAbsent.INSTANCE)) {
                            continue;
                        } else if (Intrinsics.areEqual(moveOne, MoveOutcome.AlreadyQuarantined.INSTANCE)) {
                            arrayList3.add(move.getOwned().getRelativePath());
                        } else if (moveOne instanceof MoveOutcome.Failed) {
                            return ((MoveOutcome.Failed) moveOne).getFailure();
                        } else {
                            throw new NoWhenBranchMatchedException();
                        }
                    }
                }
            }
            return new ArchiveRetirementResult.Success(arrayList2, arrayList3);
        } catch (ArchiveOwnershipException e) {
            return new ArchiveRetirementResult.Failure(ArchiveRetirementErrorCode.INVALID_OWNERSHIP, e.getRelativePath(), e.getMessage(), null, null, 24, null);
        }
    }

    public final ArchiveTrashCleanupResult cleanupTrash(String transactionId) {
        Intrinsics.checkNotNullParameter(transactionId, "transactionId");
        ArchiveRetirementResult.Failure validateTransactionId = validateTransactionId(transactionId);
        if (validateTransactionId != null) {
            return new ArchiveTrashCleanupResult.Failure(validateTransactionId.getCode(), validateTransactionId.getRelativePath(), validateTransactionId.getDetail(), 0, 8, null);
        }
        ArchiveRetirementResult.Failure validateGameRoot = validateGameRoot();
        if (validateGameRoot != null) {
            return new ArchiveTrashCleanupResult.Failure(validateGameRoot.getCode(), validateGameRoot.getRelativePath(), validateGameRoot.getDetail(), 0, 8, null);
        }
        File transactionTrashRoot$app = transactionTrashRoot$app(transactionId);
        try {
            int i = WhenMappings.$EnumSwitchMapping$0[inspectAbsoluteWithoutFollowing(transactionTrashRoot$app).ordinal()];
            if (i != 1) {
                if (i == 2) {
                    CleanupCounter cleanupCounter = new CleanupCounter(0, 1, null);
                    cleanupNode(transactionTrashRoot$app, transactionTrashRoot$app, cleanupCounter);
                    return new ArchiveTrashCleanupResult.Success(cleanupCounter.getDeletedFiles());
                }
                if (i != 3 && i != 4 && i != 5) {
                    throw new NoWhenBranchMatchedException();
                }
                return new ArchiveTrashCleanupResult.Failure(ArchiveRetirementErrorCode.UNSAFE_FILESYSTEM_NODE, null, "Transaction trash root is not a real directory", 0, 10, null);
            }
            return new ArchiveTrashCleanupResult.Success(0);
        } catch (RetirementFailure e) {
            return new ArchiveTrashCleanupResult.Failure(e.getCode(), e.getRelativePath(), e.getMessage(), e.getDeletedFiles());
        } catch (IOException e2) {
            return new ArchiveTrashCleanupResult.Failure(ArchiveRetirementErrorCode.IO_ERROR, null, e2.getMessage(), 0, 10, null);
        } catch (SecurityException e3) {
            return new ArchiveTrashCleanupResult.Failure(ArchiveRetirementErrorCode.IO_ERROR, null, e3.getMessage(), 0, 10, null);
        }
    }

    public final File transactionTrashRoot$app(String transactionId) {
        Intrinsics.checkNotNullParameter(transactionId, "transactionId");
        return new File(this.gameRoot, ".archive-installing/transactions/" + transactionId + "/retired");
    }

    private final ActionInspection inspectAction(ArchiveOwnedPath archiveOwnedPath, File file) {
        try {
            File gameRoot = this.gameRoot;
            Intrinsics.checkNotNullExpressionValue(gameRoot, "gameRoot");
            File child = child(gameRoot, archiveOwnedPath.getRelativePath());
            File child2 = child(file, archiveOwnedPath.getRelativePath());
            ArchiveFsNodeType inspectAbsoluteWithoutFollowing = inspectAbsoluteWithoutFollowing(child);
            ArchiveFsNodeType inspectAbsoluteWithoutFollowing2 = inspectAbsoluteWithoutFollowing(child2);
            if (inspectAbsoluteWithoutFollowing == ArchiveFsNodeType.REGULAR_FILE && inspectAbsoluteWithoutFollowing2 == ArchiveFsNodeType.ABSENT) {
                return new ActionInspection.Ready(new RetirementAction.Move(archiveOwnedPath, child, child2));
            }
            if (inspectAbsoluteWithoutFollowing == ArchiveFsNodeType.ABSENT && inspectAbsoluteWithoutFollowing2 == ArchiveFsNodeType.REGULAR_FILE) {
                return new ActionInspection.Ready(new RetirementAction.AlreadyQuarantined(archiveOwnedPath, child, child2));
            }
            if (inspectAbsoluteWithoutFollowing == ArchiveFsNodeType.ABSENT && inspectAbsoluteWithoutFollowing2 == ArchiveFsNodeType.ABSENT) {
                return new ActionInspection.Ready(new RetirementAction.AlreadyAbsent(archiveOwnedPath));
            }
            if (inspectAbsoluteWithoutFollowing != ArchiveFsNodeType.REGULAR_FILE && inspectAbsoluteWithoutFollowing != ArchiveFsNodeType.ABSENT) {
                return failed(ArchiveRetirementErrorCode.SOURCE_NOT_REGULAR, archiveOwnedPath);
            }
            return failed(ArchiveRetirementErrorCode.TRASH_CONFLICT, archiveOwnedPath);
        } catch (RetirementFailure e) {
            return new ActionInspection.Failed(toResult(e));
        } catch (IOException e2) {
            return new ActionInspection.Failed(new ArchiveRetirementResult.Failure(ArchiveRetirementErrorCode.IO_ERROR, archiveOwnedPath.getRelativePath(), e2.getMessage(), null, null, 24, null));
        }
    }

    private final MoveOutcome moveOne(RetirementAction.Move move, List<String> list, List<String> list2) {
        File parentFile;
        ArchiveRetirementErrorCode archiveRetirementErrorCode;
        try {
            parentFile = move.getTrash().getParentFile();
        } catch (RetirementFailure e) {
            e = e;
        } catch (IOException e2) {
            e = e2;
        } catch (SecurityException e3) {
            e = e3;
        }
        try {
            if (parentFile != null) {
                ensureDirectoryChain(parentFile);
                ArchiveFsNodeType inspectAbsoluteWithoutFollowing = inspectAbsoluteWithoutFollowing(move.getSource());
                ArchiveFsNodeType inspectAbsoluteWithoutFollowing2 = inspectAbsoluteWithoutFollowing(move.getTrash());
                if (inspectAbsoluteWithoutFollowing == ArchiveFsNodeType.ABSENT && inspectAbsoluteWithoutFollowing2 == ArchiveFsNodeType.REGULAR_FILE) {
                    ArchiveRetirementResult.Failure finishAlreadyQuarantined = finishAlreadyQuarantined(new RetirementAction.AlreadyQuarantined(move.getOwned(), move.getSource(), move.getTrash()), list, list2);
                    if (finishAlreadyQuarantined == null) {
                        return MoveOutcome.AlreadyQuarantined.INSTANCE;
                    }
                    return new MoveOutcome.Failed(finishAlreadyQuarantined);
                } else if (inspectAbsoluteWithoutFollowing != ArchiveFsNodeType.REGULAR_FILE) {
                    if (inspectAbsoluteWithoutFollowing == ArchiveFsNodeType.ABSENT && inspectAbsoluteWithoutFollowing2 == ArchiveFsNodeType.ABSENT) {
                        return MoveOutcome.AlreadyAbsent.INSTANCE;
                    }
                    if (inspectAbsoluteWithoutFollowing == ArchiveFsNodeType.ABSENT) {
                        archiveRetirementErrorCode = ArchiveRetirementErrorCode.SOURCE_MISSING;
                    } else {
                        archiveRetirementErrorCode = ArchiveRetirementErrorCode.SOURCE_NOT_REGULAR;
                    }
                    return new MoveOutcome.Failed(operationFailure$default(this, archiveRetirementErrorCode, move.getOwned(), list, list2, null, 16, null));
                } else if (inspectAbsoluteWithoutFollowing2 != ArchiveFsNodeType.ABSENT) {
                    return new MoveOutcome.Failed(operationFailure$default(this, ArchiveRetirementErrorCode.TRASH_CONFLICT, move.getOwned(), list, list2, null, 16, null));
                } else {
                    this.fileOps.atomicRename(move.getSource(), move.getTrash());
                    syncCompletedRename(move.getSource(), move.getTrash());
                    return MoveOutcome.Moved.INSTANCE;
                }
            }
            return new MoveOutcome.Failed(operationFailure$default(this, ArchiveRetirementErrorCode.UNSAFE_FILESYSTEM_NODE, move.getOwned(), list, list2, null, 16, null));
        } catch (RetirementFailure e4) {
            e = e4;
            RetirementFailure retirementFailure = e;
            return new MoveOutcome.Failed(operationFailure(retirementFailure.getCode(), move.getOwned(), afterCompletedRename(list, move, false), list2, retirementFailure.getMessage()));
        } catch (IOException e5) {
            e = e5;
            return new MoveOutcome.Failed(operationFailure(ArchiveRetirementErrorCode.IO_ERROR, move.getOwned(), afterCompletedRename(list, move, false), list2, e.getMessage()));
        } catch (SecurityException e6) {
            e = e6;
            return new MoveOutcome.Failed(operationFailure(ArchiveRetirementErrorCode.IO_ERROR, move.getOwned(), afterCompletedRename(list, move, false), list2, e.getMessage()));
        }
    }

    private final ArchiveRetirementResult.Failure finishAlreadyQuarantined(RetirementAction.AlreadyQuarantined alreadyQuarantined, List<String> list, List<String> list2) {
        try {
            syncCompletedRename(alreadyQuarantined.getSource(), alreadyQuarantined.getTrash());
            return null;
        } catch (IOException e) {
            return operationFailure(ArchiveRetirementErrorCode.IO_ERROR, alreadyQuarantined.getOwned(), list, CollectionsKt.plus((Collection<? extends String>) list2, alreadyQuarantined.getOwned().getRelativePath()), e.getMessage());
        } catch (SecurityException e2) {
            return operationFailure(ArchiveRetirementErrorCode.IO_ERROR, alreadyQuarantined.getOwned(), list, CollectionsKt.plus((Collection<? extends String>) list2, alreadyQuarantined.getOwned().getRelativePath()), e2.getMessage());
        }
    }

    private final void syncCompletedRename(File file, File file2) {
        this.fileOps.syncFile(file2);
        File parentFile = file.getParentFile();
        if (parentFile != null) {
            this.fileOps.syncDirectory(parentFile);
        }
        File parentFile2 = file2.getParentFile();
        if (parentFile2 != null) {
            this.fileOps.syncDirectory(parentFile2);
        }
    }

    private final List<String> afterCompletedRename(List<String> list, RetirementAction.Move move, boolean z) {
        return z ? CollectionsKt.plus((Collection<? extends String>) list, move.getOwned().getRelativePath()) : list;
    }

    private final ArchiveRetirementResult.Failure validateGameRoot() {
        try {
            ArchiveRetirementFileOps archiveRetirementFileOps = this.fileOps;
            File gameRoot = this.gameRoot;
            Intrinsics.checkNotNullExpressionValue(gameRoot, "gameRoot");
            if (archiveRetirementFileOps.nodeType(gameRoot) == ArchiveFsNodeType.DIRECTORY) {
                return null;
            }
            return new ArchiveRetirementResult.Failure(ArchiveRetirementErrorCode.GAME_ROOT_INVALID, null, "Game root is not a real directory", null, null, 26, null);
        } catch (IOException e) {
            return new ArchiveRetirementResult.Failure(ArchiveRetirementErrorCode.IO_ERROR, null, e.getMessage(), null, null, 26, null);
        }
    }

    private final ArchiveRetirementResult.Failure validateTransactionId(String str) {
        if (TRANSACTION_ID.matches(str)) {
            return null;
        }
        return new ArchiveRetirementResult.Failure(ArchiveRetirementErrorCode.INVALID_TRANSACTION_ID, null, "Transaction id is unsafe", null, null, 26, null);
    }

    private final ArchiveFsNodeType inspectWithoutFollowing(File file, String str) {
        int i = 0;
        List<String> split$default = StringsKt.split$default((CharSequence) str, new char[]{'/'}, false, 0, 6, (Object) null);
        for (String str2 : split$default) {
            int i2 = i + 1;
            File file2 = new File(file, str2);
            ArchiveFsNodeType nodeType = this.fileOps.nodeType(file2);
            int i3 = WhenMappings.$EnumSwitchMapping$0[nodeType.ordinal()];
            if (i3 != 1) {
                if (i3 == 2) {
                    String str3 = str;
                    if (i != CollectionsKt.getLastIndex(split$default)) {
                        i = i2;
                        str = str3;
                        file = file2;
                    }
                } else {
                    if (i3 != 3) {
                        if (i3 != 4) {
                            if (i3 != 5) {
                                throw new NoWhenBranchMatchedException();
                            }
                        } else if (i != CollectionsKt.getLastIndex(split$default)) {
                            throw new RetirementFailure(ArchiveRetirementErrorCode.UNSAFE_FILESYSTEM_NODE, str, "A file is used as a parent directory", 0, 8, null);
                        }
                    }
                    throw new RetirementFailure(ArchiveRetirementErrorCode.UNSAFE_FILESYSTEM_NODE, str, "Symbolic link or special node in managed path", 0, 8, null);
                }
                return nodeType;
            }
            return ArchiveFsNodeType.ABSENT;
        }
        return ArchiveFsNodeType.ABSENT;
    }

    private final ArchiveFsNodeType inspectAbsoluteWithoutFollowing(File file) {
        File absoluteFile = file.getAbsoluteFile();
        Intrinsics.checkNotNullExpressionValue(absoluteFile, "getAbsoluteFile(...)");
        File gameRoot = this.gameRoot;
        Intrinsics.checkNotNullExpressionValue(gameRoot, "gameRoot");
        File relativeToOrNull = FilesKt.relativeToOrNull(absoluteFile, gameRoot);
        if (relativeToOrNull == null) {
            throw new RetirementFailure(ArchiveRetirementErrorCode.UNSAFE_FILESYSTEM_NODE, null, "Managed path escapes game root", 0, 10, null);
        }
        String path = relativeToOrNull.getPath();
        Intrinsics.checkNotNullExpressionValue(path, "getPath(...)");
        String replace$default = StringsKt.replace$default(path, File.separatorChar, '/', false, 4, (Object) null);
        if (replace$default.length() != 0) {
            File gameRoot2 = this.gameRoot;
            Intrinsics.checkNotNullExpressionValue(gameRoot2, "gameRoot");
            return inspectWithoutFollowing(gameRoot2, replace$default);
        }
        ArchiveRetirementFileOps archiveRetirementFileOps = this.fileOps;
        File gameRoot3 = this.gameRoot;
        Intrinsics.checkNotNullExpressionValue(gameRoot3, "gameRoot");
        return archiveRetirementFileOps.nodeType(gameRoot3);
    }

    private final void ensureDirectoryChain(File file) {
        File absoluteFile = file.getAbsoluteFile();
        Intrinsics.checkNotNullExpressionValue(absoluteFile, "getAbsoluteFile(...)");
        File gameRoot = this.gameRoot;
        Intrinsics.checkNotNullExpressionValue(gameRoot, "gameRoot");
        File relativeToOrNull = FilesKt.relativeToOrNull(absoluteFile, gameRoot);
        if (relativeToOrNull == null) {
            throw new RetirementFailure(ArchiveRetirementErrorCode.UNSAFE_FILESYSTEM_NODE, null, "Trash parent escapes game root", 0, 10, null);
        }
        File file2 = this.gameRoot;
        String path = relativeToOrNull.getPath();
        Intrinsics.checkNotNullExpressionValue(path, "getPath(...)");
        char[] cArr = {File.separatorChar};
        ArrayList<String> arrayList = new ArrayList();
        for (Object obj : StringsKt.split$default((CharSequence) path, cArr, false, 0, 6, (Object) null)) {
            if (((String) obj).length() > 0) {
                arrayList.add(obj);
            }
        }
        for (String str : arrayList) {
            File file3 = new File(file2, str);
            int i = WhenMappings.$EnumSwitchMapping$0[this.fileOps.nodeType(file3).ordinal()];
            if (i == 1) {
                File parentFile = file3.getParentFile();
                if (parentFile == null) {
                    throw new RetirementFailure(ArchiveRetirementErrorCode.UNSAFE_FILESYSTEM_NODE, null, "Trash directory has no parent", 0, 10, null);
                }
                this.fileOps.createDirectory(file3);
                if (this.fileOps.nodeType(file3) != ArchiveFsNodeType.DIRECTORY) {
                    throw new RetirementFailure(ArchiveRetirementErrorCode.UNSAFE_FILESYSTEM_NODE, null, "Created trash path is not a directory", 0, 10, null);
                }
                this.fileOps.syncDirectory(parentFile);
            } else if (i != 2) {
                if (i != 3 && i != 4 && i != 5) {
                    throw new NoWhenBranchMatchedException();
                }
                throw new RetirementFailure(ArchiveRetirementErrorCode.UNSAFE_FILESYSTEM_NODE, null, "Non-directory node in transaction trash path", 0, 10, null);
            }
            file2 = file3;
        }
    }

    private final void cleanupNode(File file, File file2, CleanupCounter cleanupCounter) {
        if (!isWithin(file, file2)) {
            throw new RetirementFailure(ArchiveRetirementErrorCode.UNSAFE_FILESYSTEM_NODE, null, "Cleanup path escapes transaction trash", cleanupCounter.getDeletedFiles(), 2, null);
        }
        int i = WhenMappings.$EnumSwitchMapping$0[this.fileOps.nodeType(file).ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i == 4) {
                        this.fileOps.deleteRegularFile(file);
                        cleanupCounter.setDeletedFiles(cleanupCounter.getDeletedFiles() + 1);
                        File parentFile = file.getParentFile();
                        if (parentFile != null) {
                            this.fileOps.syncDirectory(parentFile);
                            return;
                        }
                        return;
                    } else if (i != 5) {
                        throw new NoWhenBranchMatchedException();
                    }
                }
                throw new RetirementFailure(ArchiveRetirementErrorCode.UNSAFE_FILESYSTEM_NODE, null, "Refusing to follow or delete non-regular trash node", cleanupCounter.getDeletedFiles(), 2, null);
            }
            for (File file3 : this.fileOps.listChildren(file)) {
                File parentFile2 = file3.getParentFile();
                if (!Intrinsics.areEqual(parentFile2 != null ? parentFile2.getAbsoluteFile() : null, file.getAbsoluteFile())) {
                    throw new RetirementFailure(ArchiveRetirementErrorCode.UNSAFE_FILESYSTEM_NODE, null, "Filesystem returned a child outside transaction trash", cleanupCounter.getDeletedFiles(), 2, null);
                }
                File absoluteFile = file3.getAbsoluteFile();
                Intrinsics.checkNotNullExpressionValue(absoluteFile, "getAbsoluteFile(...)");
                cleanupNode(absoluteFile, file2, cleanupCounter);
            }
            this.fileOps.deleteEmptyDirectory(file);
            File parentFile3 = file.getParentFile();
            if (parentFile3 != null) {
                this.fileOps.syncDirectory(parentFile3);
            }
        }
    }

    private final File child(File file, String str) {
        for (String str2 : StringsKt.split$default((CharSequence) str, new char[]{'/'}, false, 0, 6, (Object) null)) {
            file = new File(file, str2);
        }
        return file;
    }

    private final boolean isWithin(File file, File file2) {
        String path = file2.getAbsoluteFile().getPath();
        Intrinsics.checkNotNullExpressionValue(path, "getPath(...)");
        String trimEnd = StringsKt.trimEnd(path, File.separatorChar);
        String path2 = file.getAbsoluteFile().getPath();
        if (!Intrinsics.areEqual(path2, trimEnd)) {
            Intrinsics.checkNotNull(path2);
            if (!StringsKt.startsWith$default(path2, trimEnd + File.separator, false, 2, (Object) null)) {
                return false;
            }
        }
        return true;
    }

    private final ActionInspection.Failed failed(ArchiveRetirementErrorCode archiveRetirementErrorCode, ArchiveOwnedPath archiveOwnedPath) {
        return new ActionInspection.Failed(new ArchiveRetirementResult.Failure(archiveRetirementErrorCode, archiveOwnedPath.getRelativePath(), null, null, null, 28, null));
    }

    static /* synthetic */ ArchiveRetirementResult.Failure operationFailure$default(ArchiveFileRetirement archiveFileRetirement, ArchiveRetirementErrorCode archiveRetirementErrorCode, ArchiveOwnedPath archiveOwnedPath, List list, List list2, String str, int i, Object obj) {
        if ((i & 16) != 0) {
            str = null;
        }
        return archiveFileRetirement.operationFailure(archiveRetirementErrorCode, archiveOwnedPath, list, list2, str);
    }

    private final ArchiveRetirementResult.Failure operationFailure(ArchiveRetirementErrorCode archiveRetirementErrorCode, ArchiveOwnedPath archiveOwnedPath, List<String> list, List<String> list2, String str) {
        return new ArchiveRetirementResult.Failure(archiveRetirementErrorCode, archiveOwnedPath.getRelativePath(), str, CollectionsKt.toList(list), CollectionsKt.toList(list2));
    }

    private final ArchiveRetirementResult.Failure toResult(RetirementFailure retirementFailure) {
        return new ArchiveRetirementResult.Failure(retirementFailure.getCode(), retirementFailure.getRelativePath(), retirementFailure.getMessage(), null, null, 24, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ArchiveFileRetirement.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\br\u0018\u00002\u00020\u0001:\u0003\u0006\u0007\bR\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\u0082\u0001\u0003\t\n\u000b¨\u0006\fÀ\u0006\u0003"}, d2 = {"Lcom/arizona/launcher/updater/archive/transaction/ArchiveFileRetirement$RetirementAction;", "", "owned", "Lcom/arizona/launcher/updater/archive/transaction/ArchiveOwnedPath;", "getOwned", "()Lcom/arizona/launcher/updater/archive/transaction/ArchiveOwnedPath;", "AlreadyAbsent", "Move", "AlreadyQuarantined", "Lcom/arizona/launcher/updater/archive/transaction/ArchiveFileRetirement$RetirementAction$AlreadyAbsent;", "Lcom/arizona/launcher/updater/archive/transaction/ArchiveFileRetirement$RetirementAction$AlreadyQuarantined;", "Lcom/arizona/launcher/updater/archive/transaction/ArchiveFileRetirement$RetirementAction$Move;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public interface RetirementAction {
        ArchiveOwnedPath getOwned();

        /* compiled from: ArchiveFileRetirement.kt */
        @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007Ê\u0001\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\u0003\u0010\u0000¨\u0006\u0012"}, d2 = {"Lcom/arizona/launcher/updater/archive/transaction/ArchiveFileRetirement$RetirementAction$AlreadyAbsent;", "Lcom/arizona/launcher/updater/archive/transaction/ArchiveFileRetirement$RetirementAction;", "owned", "Lcom/arizona/launcher/updater/archive/transaction/ArchiveOwnedPath;", "<init>", "(Lcom/arizona/launcher/updater/archive/transaction/ArchiveOwnedPath;)V", "getOwned", "()Lcom/arizona/launcher/updater/archive/transaction/ArchiveOwnedPath;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
        /* loaded from: classes3.dex */
        public static final class AlreadyAbsent implements RetirementAction {
            public static final int $stable = ArchiveOwnedPath.$stable;
            private final ArchiveOwnedPath owned;

            public static /* synthetic */ AlreadyAbsent copy$default(AlreadyAbsent alreadyAbsent, ArchiveOwnedPath archiveOwnedPath, int i, Object obj) {
                if ((i & 1) != 0) {
                    archiveOwnedPath = alreadyAbsent.owned;
                }
                return alreadyAbsent.copy(archiveOwnedPath);
            }

            public final ArchiveOwnedPath component1() {
                return this.owned;
            }

            public final AlreadyAbsent copy(ArchiveOwnedPath owned) {
                Intrinsics.checkNotNullParameter(owned, "owned");
                return new AlreadyAbsent(owned);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof AlreadyAbsent) && Intrinsics.areEqual(this.owned, ((AlreadyAbsent) obj).owned);
            }

            public int hashCode() {
                return this.owned.hashCode();
            }

            public String toString() {
                return "AlreadyAbsent(owned=" + this.owned + ")";
            }

            public AlreadyAbsent(ArchiveOwnedPath owned) {
                Intrinsics.checkNotNullParameter(owned, "owned");
                this.owned = owned;
            }

            @Override // com.arizona.launcher.updater.archive.transaction.ArchiveFileRetirement.RetirementAction
            public ArchiveOwnedPath getOwned() {
                return this.owned;
            }
        }

        /* compiled from: ArchiveFileRetirement.kt */
        @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0083\u0004J\n\u0010\u0016\u001a\u00020\u0017HÖ\u0081\u0004J\n\u0010\u0018\u001a\u00020\u0019HÖ\u0081\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fÊ\u0001\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\u0003\u0010\u0000¨\u0006\u001a"}, d2 = {"Lcom/arizona/launcher/updater/archive/transaction/ArchiveFileRetirement$RetirementAction$Move;", "Lcom/arizona/launcher/updater/archive/transaction/ArchiveFileRetirement$RetirementAction;", "owned", "Lcom/arizona/launcher/updater/archive/transaction/ArchiveOwnedPath;", "source", "Ljava/io/File;", "trash", "<init>", "(Lcom/arizona/launcher/updater/archive/transaction/ArchiveOwnedPath;Ljava/io/File;Ljava/io/File;)V", "getOwned", "()Lcom/arizona/launcher/updater/archive/transaction/ArchiveOwnedPath;", "getSource", "()Ljava/io/File;", "getTrash", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
        /* loaded from: classes3.dex */
        public static final class Move implements RetirementAction {
            public static final int $stable = 8;
            private final ArchiveOwnedPath owned;
            private final File source;
            private final File trash;

            public static /* synthetic */ Move copy$default(Move move, ArchiveOwnedPath archiveOwnedPath, File file, File file2, int i, Object obj) {
                if ((i & 1) != 0) {
                    archiveOwnedPath = move.owned;
                }
                if ((i & 2) != 0) {
                    file = move.source;
                }
                if ((i & 4) != 0) {
                    file2 = move.trash;
                }
                return move.copy(archiveOwnedPath, file, file2);
            }

            public final ArchiveOwnedPath component1() {
                return this.owned;
            }

            public final File component2() {
                return this.source;
            }

            public final File component3() {
                return this.trash;
            }

            public final Move copy(ArchiveOwnedPath owned, File source, File trash) {
                Intrinsics.checkNotNullParameter(owned, "owned");
                Intrinsics.checkNotNullParameter(source, "source");
                Intrinsics.checkNotNullParameter(trash, "trash");
                return new Move(owned, source, trash);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof Move) {
                    Move move = (Move) obj;
                    return Intrinsics.areEqual(this.owned, move.owned) && Intrinsics.areEqual(this.source, move.source) && Intrinsics.areEqual(this.trash, move.trash);
                }
                return false;
            }

            public int hashCode() {
                return (((this.owned.hashCode() * 31) + this.source.hashCode()) * 31) + this.trash.hashCode();
            }

            public String toString() {
                ArchiveOwnedPath archiveOwnedPath = this.owned;
                File file = this.source;
                return "Move(owned=" + archiveOwnedPath + ", source=" + file + ", trash=" + this.trash + ")";
            }

            public Move(ArchiveOwnedPath owned, File source, File trash) {
                Intrinsics.checkNotNullParameter(owned, "owned");
                Intrinsics.checkNotNullParameter(source, "source");
                Intrinsics.checkNotNullParameter(trash, "trash");
                this.owned = owned;
                this.source = source;
                this.trash = trash;
            }

            @Override // com.arizona.launcher.updater.archive.transaction.ArchiveFileRetirement.RetirementAction
            public ArchiveOwnedPath getOwned() {
                return this.owned;
            }

            public final File getSource() {
                return this.source;
            }

            public final File getTrash() {
                return this.trash;
            }
        }

        /* compiled from: ArchiveFileRetirement.kt */
        @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0083\u0004J\n\u0010\u0016\u001a\u00020\u0017HÖ\u0081\u0004J\n\u0010\u0018\u001a\u00020\u0019HÖ\u0081\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fÊ\u0001\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\u0003\u0010\u0000¨\u0006\u001a"}, d2 = {"Lcom/arizona/launcher/updater/archive/transaction/ArchiveFileRetirement$RetirementAction$AlreadyQuarantined;", "Lcom/arizona/launcher/updater/archive/transaction/ArchiveFileRetirement$RetirementAction;", "owned", "Lcom/arizona/launcher/updater/archive/transaction/ArchiveOwnedPath;", "source", "Ljava/io/File;", "trash", "<init>", "(Lcom/arizona/launcher/updater/archive/transaction/ArchiveOwnedPath;Ljava/io/File;Ljava/io/File;)V", "getOwned", "()Lcom/arizona/launcher/updater/archive/transaction/ArchiveOwnedPath;", "getSource", "()Ljava/io/File;", "getTrash", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
        /* loaded from: classes3.dex */
        public static final class AlreadyQuarantined implements RetirementAction {
            public static final int $stable = 8;
            private final ArchiveOwnedPath owned;
            private final File source;
            private final File trash;

            public static /* synthetic */ AlreadyQuarantined copy$default(AlreadyQuarantined alreadyQuarantined, ArchiveOwnedPath archiveOwnedPath, File file, File file2, int i, Object obj) {
                if ((i & 1) != 0) {
                    archiveOwnedPath = alreadyQuarantined.owned;
                }
                if ((i & 2) != 0) {
                    file = alreadyQuarantined.source;
                }
                if ((i & 4) != 0) {
                    file2 = alreadyQuarantined.trash;
                }
                return alreadyQuarantined.copy(archiveOwnedPath, file, file2);
            }

            public final ArchiveOwnedPath component1() {
                return this.owned;
            }

            public final File component2() {
                return this.source;
            }

            public final File component3() {
                return this.trash;
            }

            public final AlreadyQuarantined copy(ArchiveOwnedPath owned, File source, File trash) {
                Intrinsics.checkNotNullParameter(owned, "owned");
                Intrinsics.checkNotNullParameter(source, "source");
                Intrinsics.checkNotNullParameter(trash, "trash");
                return new AlreadyQuarantined(owned, source, trash);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof AlreadyQuarantined) {
                    AlreadyQuarantined alreadyQuarantined = (AlreadyQuarantined) obj;
                    return Intrinsics.areEqual(this.owned, alreadyQuarantined.owned) && Intrinsics.areEqual(this.source, alreadyQuarantined.source) && Intrinsics.areEqual(this.trash, alreadyQuarantined.trash);
                }
                return false;
            }

            public int hashCode() {
                return (((this.owned.hashCode() * 31) + this.source.hashCode()) * 31) + this.trash.hashCode();
            }

            public String toString() {
                ArchiveOwnedPath archiveOwnedPath = this.owned;
                File file = this.source;
                return "AlreadyQuarantined(owned=" + archiveOwnedPath + ", source=" + file + ", trash=" + this.trash + ")";
            }

            public AlreadyQuarantined(ArchiveOwnedPath owned, File source, File trash) {
                Intrinsics.checkNotNullParameter(owned, "owned");
                Intrinsics.checkNotNullParameter(source, "source");
                Intrinsics.checkNotNullParameter(trash, "trash");
                this.owned = owned;
                this.source = source;
                this.trash = trash;
            }

            @Override // com.arizona.launcher.updater.archive.transaction.ArchiveFileRetirement.RetirementAction
            public ArchiveOwnedPath getOwned() {
                return this.owned;
            }

            public final File getSource() {
                return this.source;
            }

            public final File getTrash() {
                return this.trash;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ArchiveFileRetirement.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\br\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0082\u0001\u0002\u0004\u0005¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lcom/arizona/launcher/updater/archive/transaction/ArchiveFileRetirement$ActionInspection;", "", "Ready", AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_FAILED, "Lcom/arizona/launcher/updater/archive/transaction/ArchiveFileRetirement$ActionInspection$Failed;", "Lcom/arizona/launcher/updater/archive/transaction/ArchiveFileRetirement$ActionInspection$Ready;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public interface ActionInspection {

        /* compiled from: ArchiveFileRetirement.kt */
        @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007Ê\u0001\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\u0003\u0010\u0000¨\u0006\u0012"}, d2 = {"Lcom/arizona/launcher/updater/archive/transaction/ArchiveFileRetirement$ActionInspection$Ready;", "Lcom/arizona/launcher/updater/archive/transaction/ArchiveFileRetirement$ActionInspection;", "action", "Lcom/arizona/launcher/updater/archive/transaction/ArchiveFileRetirement$RetirementAction;", "<init>", "(Lcom/arizona/launcher/updater/archive/transaction/ArchiveFileRetirement$RetirementAction;)V", "getAction", "()Lcom/arizona/launcher/updater/archive/transaction/ArchiveFileRetirement$RetirementAction;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
        /* loaded from: classes3.dex */
        public static final class Ready implements ActionInspection {
            public static final int $stable = 8;
            private final RetirementAction action;

            public static /* synthetic */ Ready copy$default(Ready ready, RetirementAction retirementAction, int i, Object obj) {
                if ((i & 1) != 0) {
                    retirementAction = ready.action;
                }
                return ready.copy(retirementAction);
            }

            public final RetirementAction component1() {
                return this.action;
            }

            public final Ready copy(RetirementAction action) {
                Intrinsics.checkNotNullParameter(action, "action");
                return new Ready(action);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Ready) && Intrinsics.areEqual(this.action, ((Ready) obj).action);
            }

            public int hashCode() {
                return this.action.hashCode();
            }

            public String toString() {
                return "Ready(action=" + this.action + ")";
            }

            public Ready(RetirementAction action) {
                Intrinsics.checkNotNullParameter(action, "action");
                this.action = action;
            }

            public final RetirementAction getAction() {
                return this.action;
            }
        }

        /* compiled from: ArchiveFileRetirement.kt */
        @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007Ê\u0001\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0012"}, d2 = {"Lcom/arizona/launcher/updater/archive/transaction/ArchiveFileRetirement$ActionInspection$Failed;", "Lcom/arizona/launcher/updater/archive/transaction/ArchiveFileRetirement$ActionInspection;", "failure", "Lcom/arizona/launcher/updater/archive/transaction/ArchiveRetirementResult$Failure;", "<init>", "(Lcom/arizona/launcher/updater/archive/transaction/ArchiveRetirementResult$Failure;)V", "getFailure", "()Lcom/arizona/launcher/updater/archive/transaction/ArchiveRetirementResult$Failure;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
        /* loaded from: classes3.dex */
        public static final class Failed implements ActionInspection {
            public static final int $stable = 0;
            private final ArchiveRetirementResult.Failure failure;

            public static /* synthetic */ Failed copy$default(Failed failed, ArchiveRetirementResult.Failure failure, int i, Object obj) {
                if ((i & 1) != 0) {
                    failure = failed.failure;
                }
                return failed.copy(failure);
            }

            public final ArchiveRetirementResult.Failure component1() {
                return this.failure;
            }

            public final Failed copy(ArchiveRetirementResult.Failure failure) {
                Intrinsics.checkNotNullParameter(failure, "failure");
                return new Failed(failure);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Failed) && Intrinsics.areEqual(this.failure, ((Failed) obj).failure);
            }

            public int hashCode() {
                return this.failure.hashCode();
            }

            public String toString() {
                return "Failed(failure=" + this.failure + ")";
            }

            public Failed(ArchiveRetirementResult.Failure failure) {
                Intrinsics.checkNotNullParameter(failure, "failure");
                this.failure = failure;
            }

            public final ArchiveRetirementResult.Failure getFailure() {
                return this.failure;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ArchiveFileRetirement.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\br\u0018\u00002\u00020\u0001:\u0004\u0002\u0003\u0004\u0005\u0082\u0001\u0004\u0006\u0007\b\t¨\u0006\nÀ\u0006\u0003"}, d2 = {"Lcom/arizona/launcher/updater/archive/transaction/ArchiveFileRetirement$MoveOutcome;", "", "Moved", "AlreadyAbsent", "AlreadyQuarantined", AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_FAILED, "Lcom/arizona/launcher/updater/archive/transaction/ArchiveFileRetirement$MoveOutcome$AlreadyAbsent;", "Lcom/arizona/launcher/updater/archive/transaction/ArchiveFileRetirement$MoveOutcome$AlreadyQuarantined;", "Lcom/arizona/launcher/updater/archive/transaction/ArchiveFileRetirement$MoveOutcome$Failed;", "Lcom/arizona/launcher/updater/archive/transaction/ArchiveFileRetirement$MoveOutcome$Moved;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public interface MoveOutcome {

        /* compiled from: ArchiveFileRetirement.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004Ê\u0001\f\b\r\u0012\b\b\u000e\u0012\u0004\b\u0003\u0010\u0002¨\u0006\f"}, d2 = {"Lcom/arizona/launcher/updater/archive/transaction/ArchiveFileRetirement$MoveOutcome$Moved;", "Lcom/arizona/launcher/updater/archive/transaction/ArchiveFileRetirement$MoveOutcome;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
        /* loaded from: classes3.dex */
        public static final class Moved implements MoveOutcome {
            public static final int $stable = 0;
            public static final Moved INSTANCE = new Moved();

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof Moved) {
                    Moved moved = (Moved) obj;
                    return true;
                }
                return false;
            }

            public int hashCode() {
                return 1857365115;
            }

            public String toString() {
                return "Moved";
            }

            private Moved() {
            }
        }

        /* compiled from: ArchiveFileRetirement.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004Ê\u0001\f\b\r\u0012\b\b\u000e\u0012\u0004\b\u0003\u0010\u0002¨\u0006\f"}, d2 = {"Lcom/arizona/launcher/updater/archive/transaction/ArchiveFileRetirement$MoveOutcome$AlreadyAbsent;", "Lcom/arizona/launcher/updater/archive/transaction/ArchiveFileRetirement$MoveOutcome;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
        /* loaded from: classes3.dex */
        public static final class AlreadyAbsent implements MoveOutcome {
            public static final int $stable = 0;
            public static final AlreadyAbsent INSTANCE = new AlreadyAbsent();

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof AlreadyAbsent) {
                    AlreadyAbsent alreadyAbsent = (AlreadyAbsent) obj;
                    return true;
                }
                return false;
            }

            public int hashCode() {
                return 2045148025;
            }

            public String toString() {
                return "AlreadyAbsent";
            }

            private AlreadyAbsent() {
            }
        }

        /* compiled from: ArchiveFileRetirement.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004Ê\u0001\f\b\r\u0012\b\b\u000e\u0012\u0004\b\u0003\u0010\u0002¨\u0006\f"}, d2 = {"Lcom/arizona/launcher/updater/archive/transaction/ArchiveFileRetirement$MoveOutcome$AlreadyQuarantined;", "Lcom/arizona/launcher/updater/archive/transaction/ArchiveFileRetirement$MoveOutcome;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
        /* loaded from: classes3.dex */
        public static final class AlreadyQuarantined implements MoveOutcome {
            public static final int $stable = 0;
            public static final AlreadyQuarantined INSTANCE = new AlreadyQuarantined();

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof AlreadyQuarantined) {
                    AlreadyQuarantined alreadyQuarantined = (AlreadyQuarantined) obj;
                    return true;
                }
                return false;
            }

            public int hashCode() {
                return 242010038;
            }

            public String toString() {
                return "AlreadyQuarantined";
            }

            private AlreadyQuarantined() {
            }
        }

        /* compiled from: ArchiveFileRetirement.kt */
        @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007Ê\u0001\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0012"}, d2 = {"Lcom/arizona/launcher/updater/archive/transaction/ArchiveFileRetirement$MoveOutcome$Failed;", "Lcom/arizona/launcher/updater/archive/transaction/ArchiveFileRetirement$MoveOutcome;", "failure", "Lcom/arizona/launcher/updater/archive/transaction/ArchiveRetirementResult$Failure;", "<init>", "(Lcom/arizona/launcher/updater/archive/transaction/ArchiveRetirementResult$Failure;)V", "getFailure", "()Lcom/arizona/launcher/updater/archive/transaction/ArchiveRetirementResult$Failure;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
        /* loaded from: classes3.dex */
        public static final class Failed implements MoveOutcome {
            public static final int $stable = 0;
            private final ArchiveRetirementResult.Failure failure;

            public static /* synthetic */ Failed copy$default(Failed failed, ArchiveRetirementResult.Failure failure, int i, Object obj) {
                if ((i & 1) != 0) {
                    failure = failed.failure;
                }
                return failed.copy(failure);
            }

            public final ArchiveRetirementResult.Failure component1() {
                return this.failure;
            }

            public final Failed copy(ArchiveRetirementResult.Failure failure) {
                Intrinsics.checkNotNullParameter(failure, "failure");
                return new Failed(failure);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Failed) && Intrinsics.areEqual(this.failure, ((Failed) obj).failure);
            }

            public int hashCode() {
                return this.failure.hashCode();
            }

            public String toString() {
                return "Failed(failure=" + this.failure + ")";
            }

            public Failed(ArchiveRetirementResult.Failure failure) {
                Intrinsics.checkNotNullParameter(failure, "failure");
                this.failure = failure;
            }

            public final ArchiveRetirementResult.Failure getFailure() {
                return this.failure;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ArchiveFileRetirement.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u000f\u001a\u00020\u0010HÖ\u0081\u0004R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\u0011"}, d2 = {"Lcom/arizona/launcher/updater/archive/transaction/ArchiveFileRetirement$CleanupCounter;", "", "deletedFiles", "", "<init>", "(I)V", "getDeletedFiles", "()I", "setDeletedFiles", "component1", "copy", "equals", "", "other", "hashCode", "toString", "", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class CleanupCounter {
        private int deletedFiles;

        public CleanupCounter() {
            this(0, 1, null);
        }

        public static /* synthetic */ CleanupCounter copy$default(CleanupCounter cleanupCounter, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = cleanupCounter.deletedFiles;
            }
            return cleanupCounter.copy(i);
        }

        public final int component1() {
            return this.deletedFiles;
        }

        public final CleanupCounter copy(int i) {
            return new CleanupCounter(i);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof CleanupCounter) && this.deletedFiles == ((CleanupCounter) obj).deletedFiles;
        }

        public int hashCode() {
            return Integer.hashCode(this.deletedFiles);
        }

        public String toString() {
            return "CleanupCounter(deletedFiles=" + this.deletedFiles + ")";
        }

        public CleanupCounter(int i) {
            this.deletedFiles = i;
        }

        public /* synthetic */ CleanupCounter(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? 0 : i);
        }

        public final int getDeletedFiles() {
            return this.deletedFiles;
        }

        public final void setDeletedFiles(int i) {
            this.deletedFiles = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ArchiveFileRetirement.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\b\u0002\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/arizona/launcher/updater/archive/transaction/ArchiveFileRetirement$RetirementFailure;", "Ljava/io/IOException;", "code", "Lcom/arizona/launcher/updater/archive/transaction/ArchiveRetirementErrorCode;", "relativePath", "", "message", "deletedFiles", "", "<init>", "(Lcom/arizona/launcher/updater/archive/transaction/ArchiveRetirementErrorCode;Ljava/lang/String;Ljava/lang/String;I)V", "getCode", "()Lcom/arizona/launcher/updater/archive/transaction/ArchiveRetirementErrorCode;", "getRelativePath", "()Ljava/lang/String;", "getDeletedFiles", "()I", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class RetirementFailure extends IOException {
        private final ArchiveRetirementErrorCode code;
        private final int deletedFiles;
        private final String relativePath;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RetirementFailure(ArchiveRetirementErrorCode code, String str, String str2, int i) {
            super(str2);
            Intrinsics.checkNotNullParameter(code, "code");
            this.code = code;
            this.relativePath = str;
            this.deletedFiles = i;
        }

        public /* synthetic */ RetirementFailure(ArchiveRetirementErrorCode archiveRetirementErrorCode, String str, String str2, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(archiveRetirementErrorCode, (i2 & 2) != 0 ? null : str, (i2 & 4) != 0 ? null : str2, (i2 & 8) != 0 ? 0 : i);
        }

        public final ArchiveRetirementErrorCode getCode() {
            return this.code;
        }

        public final String getRelativePath() {
            return this.relativePath;
        }

        public final int getDeletedFiles() {
            return this.deletedFiles;
        }
    }

    /* compiled from: ArchiveFileRetirement.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/arizona/launcher/updater/archive/transaction/ArchiveFileRetirement$Companion;", "", "<init>", "()V", "WORK_ROOT", "", "TRANSACTIONS_ROOT", "TRASH_ROOT", "TRANSACTION_ID", "Lkotlin/text/Regex;", "getTRANSACTION_ID", "()Lkotlin/text/Regex;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Regex getTRANSACTION_ID() {
            return ArchiveFileRetirement.TRANSACTION_ID;
        }
    }
}
