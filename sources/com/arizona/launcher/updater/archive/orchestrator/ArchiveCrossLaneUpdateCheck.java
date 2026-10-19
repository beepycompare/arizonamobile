package com.arizona.launcher.updater.archive.orchestrator;

import androidx.media3.extractor.text.ttml.TtmlNode;
import com.arizona.launcher.updater.archive.model.ArchiveGpu;
import com.arizona.launcher.updater.archive.model.ArchiveManifest;
import com.arizona.launcher.updater.archive.orchestrator.ArchiveGenerationMigrationResult;
import com.arizona.launcher.updater.archive.orchestrator.ArchiveUpdateCheckDecision;
import com.arizona.launcher.updater.archive.orchestrator.ArchiveUpdateCheckRemoteStage;
import com.arizona.launcher.updater.archive.state.ArchiveStateLoadResult;
import com.arizona.launcher.updater.archive.state.ArchiveUpdaterState;
import com.arizona.launcher.updater.archive.state.DurableArchiveStateStore;
import com.arizona.launcher.updater.archive.transaction.ArchiveOwnedPath;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ArchiveCrossLaneUpdateCheck.kt */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001:\u0002/0B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J¤\u0001\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00102\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00102\b\b\u0002\u0010\u0018\u001a\u00020\u00102\u000e\b\u0002\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u0010H\u0086@¢\u0006\u0002\u0010\u001fJ2\u0010 \u001a\u00020!2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010#2\u0006\u0010%\u001a\u00020\u0010H\u0082@¢\u0006\u0002\u0010&J\u001c\u0010'\u001a\u0004\u0018\u00010(2\u0006\u0010)\u001a\u00020#2\b\u0010*\u001a\u0004\u0018\u00010#H\u0002J,\u0010+\u001a\u0004\u0018\u00010(2\u0006\u0010)\u001a\u00020#2\b\u0010*\u001a\u0004\u0018\u00010#2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\nH\u0002Ê\u0001\f\b2\u0012\b\b3\u0012\u0004\b\u0003\u0010\u0002¨\u00061"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveCrossLaneUpdateCheck;", "", "<init>", "()V", "prepare", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveCrossLaneUpdateCheckResult;", "baseCoordinator", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveUpdateCheckCoordinator;", "viceCoordinator", "baseStateStore", "Lcom/arizona/launcher/updater/archive/state/DurableArchiveStateStore;", "viceStateStore", "baseResponse", "", "viceResponse", "viceEnabled", "", "selectedGpu", "Lcom/arizona/launcher/updater/archive/model/ArchiveGpu;", "serverBaseUrl", "allowCleanBootstrap", "bootstrapPrefetcher", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveBootstrapPrefetcher;", "baseMetadataAuditValidatedForFinalization", "viceMetadataAuditValidatedForFinalization", "nowEpochMs", "Lkotlin/Function0;", "", "migration", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveGenerationMigration;", "forceNoAdoption", "(Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveUpdateCheckCoordinator;Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveUpdateCheckCoordinator;Lcom/arizona/launcher/updater/archive/state/DurableArchiveStateStore;Lcom/arizona/launcher/updater/archive/state/DurableArchiveStateStore;Ljava/lang/String;Ljava/lang/String;ZLcom/arizona/launcher/updater/archive/model/ArchiveGpu;Ljava/lang/String;ZLcom/arizona/launcher/updater/archive/orchestrator/ArchiveBootstrapPrefetcher;ZZLkotlin/jvm/functions/Function0;Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveGenerationMigration;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "migrationGate", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveCrossLaneUpdateCheck$MigrationGate;", "baseRemote", "Lcom/arizona/launcher/updater/archive/model/ArchiveManifest;", "viceRemote", "viceContentAvailable", "(Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveGenerationMigration;Lcom/arizona/launcher/updater/archive/model/ArchiveManifest;Lcom/arizona/launcher/updater/archive/model/ArchiveManifest;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "desiredOnlyCollision", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveUpdateCheckDecision$Block;", TtmlNode.RUBY_BASE, "vice", "laneCollisionBlock", "loadState", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveCrossLaneUpdateCheck$LaneStateLoad;", "store", "LaneStateLoad", "MigrationGate", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ArchiveCrossLaneUpdateCheck {
    public static final int $stable = 0;
    public static final ArchiveCrossLaneUpdateCheck INSTANCE = new ArchiveCrossLaneUpdateCheck();

    private ArchiveCrossLaneUpdateCheck() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x080b  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x082a  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x08c8  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x01eb  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x09ea  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0a01  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0263  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0a08  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x02ac  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x0a8a  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x0aa6  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0328  */
    /* JADX WARN: Removed duplicated region for block: B:198:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0390  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0430  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0446  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x04e4  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x050a  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x052a  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0560  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0667  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0691  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0698  */
    /* JADX WARN: Type inference failed for: r11v32 */
    /* JADX WARN: Type inference failed for: r11v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v42, types: [int] */
    /* JADX WARN: Type inference failed for: r1v49, types: [int] */
    /* JADX WARN: Type inference failed for: r1v9, types: [int] */
    /* JADX WARN: Type inference failed for: r35v0, types: [com.arizona.launcher.updater.archive.orchestrator.ArchiveCrossLaneUpdateCheck] */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v13, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r4v16 */
    /* JADX WARN: Type inference failed for: r4v54, types: [int] */
    /* JADX WARN: Type inference failed for: r4v61 */
    /* JADX WARN: Type inference failed for: r5v18 */
    /* JADX WARN: Type inference failed for: r5v23, types: [int] */
    /* JADX WARN: Type inference failed for: r7v17 */
    /* JADX WARN: Type inference failed for: r7v20, types: [int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object prepare(ArchiveUpdateCheckCoordinator archiveUpdateCheckCoordinator, ArchiveUpdateCheckCoordinator archiveUpdateCheckCoordinator2, DurableArchiveStateStore durableArchiveStateStore, DurableArchiveStateStore durableArchiveStateStore2, String str, String str2, boolean z, ArchiveGpu archiveGpu, String str3, boolean z2, ArchiveBootstrapPrefetcher archiveBootstrapPrefetcher, boolean z3, boolean z4, Function0<Long> function0, ArchiveGenerationMigration archiveGenerationMigration, boolean z5, Continuation<? super ArchiveCrossLaneUpdateCheckResult> continuation) {
        ArchiveCrossLaneUpdateCheck$prepare$1 archiveCrossLaneUpdateCheck$prepare$1;
        ArchiveCrossLaneUpdateCheck$prepare$1 archiveCrossLaneUpdateCheck$prepare$12;
        boolean z6;
        ArchiveUpdateCheckCoordinator archiveUpdateCheckCoordinator3;
        DurableArchiveStateStore durableArchiveStateStore3;
        DurableArchiveStateStore durableArchiveStateStore4;
        String str4;
        ArchiveGpu archiveGpu2;
        String str5;
        boolean z7;
        boolean z8;
        Function0<Long> function02;
        ArchiveGenerationMigration archiveGenerationMigration2;
        boolean z9;
        boolean z10;
        Object obj;
        ArchiveUpdateCheckCoordinator archiveUpdateCheckCoordinator4;
        boolean z11;
        boolean z12;
        ArchiveBootstrapPrefetcher archiveBootstrapPrefetcher2;
        String str6;
        boolean z13;
        ArchiveUpdateCheckRemoteStage archiveUpdateCheckRemoteStage;
        String str7;
        Function0<Long> function03;
        ArchiveUpdateCheckCoordinator archiveUpdateCheckCoordinator5;
        Object obj2;
        ArchiveGenerationMigration archiveGenerationMigration3;
        Object migrationGate;
        ArchiveCrossLaneUpdateCheck$prepare$1 archiveCrossLaneUpdateCheck$prepare$13;
        ArchiveUpdateCheckRemoteStage archiveUpdateCheckRemoteStage2;
        ArchiveManifest archiveManifest;
        ArchiveGenerationMigration archiveGenerationMigration4;
        ArchiveGpu archiveGpu3;
        ArchiveBootstrapPrefetcher archiveBootstrapPrefetcher3;
        Object obj3;
        boolean z14;
        ArchiveUpdateCheckCoordinator archiveUpdateCheckCoordinator6;
        String str8;
        String str9;
        ArchiveUpdateCheckCoordinator archiveUpdateCheckCoordinator7;
        String str10;
        ArchiveCrossLaneUpdateCheck$prepare$1 archiveCrossLaneUpdateCheck$prepare$14;
        Object obj4;
        ArchiveGpu archiveGpu4;
        String str11;
        String str12;
        ArchiveBootstrapPrefetcher archiveBootstrapPrefetcher4;
        ArchiveGenerationMigration archiveGenerationMigration5;
        boolean z15;
        ArchiveUpdateCheckCoordinator archiveUpdateCheckCoordinator8;
        ArchiveManifest archiveManifest2;
        Object obj5;
        Function0<Long> function04;
        ArchiveUpdateCheckRemoteStage archiveUpdateCheckRemoteStage3;
        int i;
        MigrationGate migrationGate2;
        boolean z16;
        ArchiveUpdateCheckRemoteStage archiveUpdateCheckRemoteStage4;
        ArchiveUpdateCheckRemoteStage archiveUpdateCheckRemoteStage5;
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z20;
        ArchiveUpdaterState state;
        ArchiveUpdaterState state2;
        boolean z21;
        boolean z22;
        ArchiveCrossLaneHandoffDecision evaluate;
        boolean z23;
        boolean z24;
        Object migrationGate3;
        ArchiveGenerationMigration archiveGenerationMigration6;
        ArchiveCrossLaneUpdateCheck$prepare$1 archiveCrossLaneUpdateCheck$prepare$15;
        Object obj6;
        Object obj7;
        boolean z25;
        String str13;
        Function0<Long> function05;
        ArchiveUpdaterState archiveUpdaterState;
        ArchiveUpdaterState archiveUpdaterState2;
        DurableArchiveStateStore durableArchiveStateStore5;
        DurableArchiveStateStore durableArchiveStateStore6;
        ArchiveManifest archiveManifest3;
        String str14;
        ArchiveUpdateCheckRemoteStage archiveUpdateCheckRemoteStage6;
        ArchiveManifest archiveManifest4;
        ArchiveCrossLaneHandoffDecision archiveCrossLaneHandoffDecision;
        boolean z26;
        ArchiveUpdateCheckCoordinator archiveUpdateCheckCoordinator9;
        int i2;
        boolean z27;
        int i3;
        MigrationGate migrationGate4;
        Function0<Long> function06;
        ArchiveUpdateCheckCoordinator archiveUpdateCheckCoordinator10;
        boolean z28;
        boolean z29;
        int i4;
        String str15;
        ArchiveManifest archiveManifest5;
        boolean z30;
        ArchiveUpdateCheckCoordinator archiveUpdateCheckCoordinator11;
        boolean z31;
        Object obj8;
        int i5;
        int i6;
        ArchiveUpdateCheckDecision archiveUpdateCheckDecision;
        ArchiveUpdateCheckDecision archiveUpdateCheckDecision2;
        ArchiveUpdateCheckDecision archiveUpdateCheckDecision3;
        if (continuation instanceof ArchiveCrossLaneUpdateCheck$prepare$1) {
            archiveCrossLaneUpdateCheck$prepare$1 = (ArchiveCrossLaneUpdateCheck$prepare$1) continuation;
            if ((archiveCrossLaneUpdateCheck$prepare$1.label & Integer.MIN_VALUE) != 0) {
                archiveCrossLaneUpdateCheck$prepare$1.label -= Integer.MIN_VALUE;
                archiveCrossLaneUpdateCheck$prepare$12 = archiveCrossLaneUpdateCheck$prepare$1;
                Object obj9 = archiveCrossLaneUpdateCheck$prepare$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (archiveCrossLaneUpdateCheck$prepare$12.label) {
                    case 0:
                        z6 = false;
                        ResultKt.throwOnFailure(obj9);
                        boolean z32 = !((archiveGenerationMigration == null || archiveGenerationMigration.getReuseLocalJournalIndex()) ? false : true);
                        boolean z33 = z2 && (archiveGenerationMigration == null || !archiveGenerationMigration.getSuppressCleanBootstrap());
                        archiveCrossLaneUpdateCheck$prepare$12.L$0 = archiveUpdateCheckCoordinator;
                        archiveUpdateCheckCoordinator3 = archiveUpdateCheckCoordinator2;
                        archiveCrossLaneUpdateCheck$prepare$12.L$1 = archiveUpdateCheckCoordinator3;
                        durableArchiveStateStore3 = durableArchiveStateStore;
                        archiveCrossLaneUpdateCheck$prepare$12.L$2 = durableArchiveStateStore3;
                        durableArchiveStateStore4 = durableArchiveStateStore2;
                        archiveCrossLaneUpdateCheck$prepare$12.L$3 = durableArchiveStateStore4;
                        archiveCrossLaneUpdateCheck$prepare$12.L$4 = SpillingKt.nullOutSpilledVariable(str);
                        archiveCrossLaneUpdateCheck$prepare$12.L$5 = str2;
                        archiveCrossLaneUpdateCheck$prepare$12.L$6 = archiveGpu;
                        archiveCrossLaneUpdateCheck$prepare$12.L$7 = str3;
                        archiveCrossLaneUpdateCheck$prepare$12.L$8 = SpillingKt.nullOutSpilledVariable(archiveBootstrapPrefetcher);
                        archiveCrossLaneUpdateCheck$prepare$12.L$9 = function0;
                        archiveCrossLaneUpdateCheck$prepare$12.L$10 = archiveGenerationMigration;
                        archiveCrossLaneUpdateCheck$prepare$12.Z$0 = z;
                        archiveCrossLaneUpdateCheck$prepare$12.Z$1 = z2;
                        archiveCrossLaneUpdateCheck$prepare$12.Z$2 = z3;
                        archiveCrossLaneUpdateCheck$prepare$12.Z$3 = z4;
                        archiveCrossLaneUpdateCheck$prepare$12.Z$4 = z5;
                        archiveCrossLaneUpdateCheck$prepare$12.I$0 = z32 ? 1 : 0;
                        archiveCrossLaneUpdateCheck$prepare$12.label = 1;
                        Object resolveRemoteCheck = archiveUpdateCheckCoordinator.resolveRemoteCheck(str, archiveGpu, str3, z33, archiveBootstrapPrefetcher, z32, archiveCrossLaneUpdateCheck$prepare$12);
                        if (resolveRemoteCheck == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        str4 = str2;
                        archiveGpu2 = archiveGpu;
                        str5 = str3;
                        z7 = z2;
                        z8 = z4;
                        function02 = function0;
                        archiveGenerationMigration2 = archiveGenerationMigration;
                        z9 = true;
                        z10 = z;
                        obj = resolveRemoteCheck;
                        archiveUpdateCheckCoordinator4 = archiveUpdateCheckCoordinator;
                        z11 = z3;
                        z12 = z5;
                        archiveBootstrapPrefetcher2 = archiveBootstrapPrefetcher;
                        str6 = str;
                        z13 = z32;
                        archiveUpdateCheckRemoteStage = (ArchiveUpdateCheckRemoteStage) obj;
                        if (!(archiveUpdateCheckRemoteStage instanceof ArchiveUpdateCheckRemoteStage.Completed)) {
                            return new ArchiveCrossLaneUpdateCheckResult(((ArchiveUpdateCheckRemoteStage.Completed) archiveUpdateCheckRemoteStage).getDecision(), null, null, false, 14, null);
                        }
                        Intrinsics.checkNotNull(archiveUpdateCheckRemoteStage, "null cannot be cast to non-null type com.arizona.launcher.updater.archive.orchestrator.ArchiveUpdateCheckRemoteStage.Resolved");
                        ArchiveManifest remote = ((ArchiveUpdateCheckRemoteStage.Resolved) archiveUpdateCheckRemoteStage).getRemote();
                        if (z10 && str4 != null) {
                            boolean z34 = z13 ? z9 : z6;
                            archiveCrossLaneUpdateCheck$prepare$12.L$0 = archiveUpdateCheckCoordinator4;
                            archiveCrossLaneUpdateCheck$prepare$12.L$1 = archiveUpdateCheckCoordinator3;
                            archiveCrossLaneUpdateCheck$prepare$12.L$2 = durableArchiveStateStore3;
                            archiveCrossLaneUpdateCheck$prepare$12.L$3 = durableArchiveStateStore4;
                            archiveCrossLaneUpdateCheck$prepare$12.L$4 = SpillingKt.nullOutSpilledVariable(str6);
                            archiveCrossLaneUpdateCheck$prepare$12.L$5 = SpillingKt.nullOutSpilledVariable(str4);
                            archiveCrossLaneUpdateCheck$prepare$12.L$6 = SpillingKt.nullOutSpilledVariable(archiveGpu2);
                            archiveCrossLaneUpdateCheck$prepare$12.L$7 = SpillingKt.nullOutSpilledVariable(str5);
                            archiveCrossLaneUpdateCheck$prepare$12.L$8 = SpillingKt.nullOutSpilledVariable(archiveBootstrapPrefetcher2);
                            archiveCrossLaneUpdateCheck$prepare$12.L$9 = function02;
                            archiveCrossLaneUpdateCheck$prepare$12.L$10 = archiveGenerationMigration2;
                            archiveCrossLaneUpdateCheck$prepare$12.L$11 = SpillingKt.nullOutSpilledVariable(archiveUpdateCheckRemoteStage);
                            archiveCrossLaneUpdateCheck$prepare$12.L$12 = remote;
                            archiveCrossLaneUpdateCheck$prepare$12.Z$0 = z10;
                            archiveCrossLaneUpdateCheck$prepare$12.Z$1 = z7;
                            archiveCrossLaneUpdateCheck$prepare$12.Z$2 = z11;
                            archiveCrossLaneUpdateCheck$prepare$12.Z$3 = z8;
                            archiveCrossLaneUpdateCheck$prepare$12.Z$4 = z12;
                            archiveCrossLaneUpdateCheck$prepare$12.I$0 = z13 ? 1 : 0;
                            archiveCrossLaneUpdateCheck$prepare$12.label = 4;
                            ArchiveUpdateCheckCoordinator archiveUpdateCheckCoordinator12 = archiveUpdateCheckCoordinator3;
                            Object resolveRemoteCheck$default = ArchiveUpdateCheckCoordinator.resolveRemoteCheck$default(archiveUpdateCheckCoordinator12, str4, archiveGpu2, str5, false, null, z34, archiveCrossLaneUpdateCheck$prepare$12, 24, null);
                            archiveUpdateCheckCoordinator7 = archiveUpdateCheckCoordinator12;
                            String str16 = str4;
                            str10 = str5;
                            archiveCrossLaneUpdateCheck$prepare$14 = archiveCrossLaneUpdateCheck$prepare$12;
                            Function0<Long> function07 = function02;
                            obj4 = coroutine_suspended;
                            archiveGpu4 = archiveGpu2;
                            if (resolveRemoteCheck$default == obj4) {
                                return obj4;
                            }
                            str11 = str16;
                            str12 = str6;
                            archiveBootstrapPrefetcher4 = archiveBootstrapPrefetcher2;
                            archiveGenerationMigration5 = archiveGenerationMigration2;
                            z15 = z11;
                            archiveUpdateCheckCoordinator8 = archiveUpdateCheckCoordinator4;
                            archiveManifest2 = remote;
                            obj5 = resolveRemoteCheck$default;
                            function04 = function07;
                            archiveUpdateCheckRemoteStage3 = archiveUpdateCheckRemoteStage;
                            z16 = z13;
                            archiveUpdateCheckRemoteStage4 = (ArchiveUpdateCheckRemoteStage) obj5;
                            Object obj10 = obj4;
                            if (!(archiveUpdateCheckRemoteStage4 instanceof ArchiveUpdateCheckRemoteStage.Completed)) {
                                ArchiveUpdateCheckRemoteStage.Completed completed = (ArchiveUpdateCheckRemoteStage.Completed) archiveUpdateCheckRemoteStage4;
                                return new ArchiveCrossLaneUpdateCheckResult(completed.getDecision(), completed.getDecision(), Boxing.boxBoolean(z9), false, 8, null);
                            }
                            Intrinsics.checkNotNull(archiveUpdateCheckRemoteStage4, "null cannot be cast to non-null type com.arizona.launcher.updater.archive.orchestrator.ArchiveUpdateCheckRemoteStage.Resolved");
                            ArchiveManifest remote2 = ((ArchiveUpdateCheckRemoteStage.Resolved) archiveUpdateCheckRemoteStage4).getRemote();
                            if (archiveGenerationMigration5 != null) {
                                archiveUpdateCheckRemoteStage5 = archiveUpdateCheckRemoteStage4;
                                z17 = z9;
                                if (archiveGenerationMigration5.getDestructiveCleanup() == z17) {
                                    z18 = z17;
                                    if (z18) {
                                        z19 = z18;
                                        LaneStateLoad loadState = loadState(durableArchiveStateStore3);
                                        z20 = z16;
                                        if (loadState instanceof LaneStateLoad.Failed) {
                                            return ((LaneStateLoad.Failed) loadState).getResult();
                                        }
                                        if (!(loadState instanceof LaneStateLoad.Ready)) {
                                            throw new NoWhenBranchMatchedException();
                                        }
                                        state = ((LaneStateLoad.Ready) loadState).getState();
                                        LaneStateLoad loadState2 = loadState(durableArchiveStateStore4);
                                        if (loadState2 instanceof LaneStateLoad.Failed) {
                                            return ((LaneStateLoad.Failed) loadState2).getResult();
                                        }
                                        if (!(loadState2 instanceof LaneStateLoad.Ready)) {
                                            throw new NoWhenBranchMatchedException();
                                        }
                                        state2 = ((LaneStateLoad.Ready) loadState2).getState();
                                        try {
                                            z21 = z12;
                                            z22 = z8;
                                            evaluate = ArchiveCrossLaneOwnershipHandoff.INSTANCE.evaluate(ArchiveLaneOwnership.INSTANCE.proofsFromManifest(archiveManifest2), ArchiveLaneOwnership.INSTANCE.proofsFromManifest(remote2), state, state2);
                                            if (!evaluate.isValid()) {
                                                return new ArchiveCrossLaneUpdateCheckResult(new ArchiveUpdateCheckDecision.Block(ArchiveUpdateCheckBlockCode.STATE_INVALID, new ArchiveContentCollisionException(evaluate.getCollisions()).getMessage()), null, Boxing.boxBoolean(true), false, 10, null);
                                            }
                                        } catch (IllegalArgumentException e) {
                                            return new ArchiveCrossLaneUpdateCheckResult(new ArchiveUpdateCheckDecision.Block(ArchiveUpdateCheckBlockCode.STATE_INVALID, e.getMessage()), null, Boxing.boxBoolean(true), false, 10, null);
                                        }
                                    } else {
                                        boolean z35 = z17;
                                        ArchiveUpdateCheckDecision.Block desiredOnlyCollision = desiredOnlyCollision(archiveManifest2, remote2);
                                        if (desiredOnlyCollision != null) {
                                            return new ArchiveCrossLaneUpdateCheckResult(desiredOnlyCollision, null, Boxing.boxBoolean(z35), false, 10, null);
                                        }
                                        z22 = z8;
                                        z21 = z12;
                                        z20 = z16;
                                        z19 = z18;
                                        state2 = null;
                                        evaluate = null;
                                        state = null;
                                    }
                                    archiveCrossLaneUpdateCheck$prepare$14.L$0 = archiveUpdateCheckCoordinator8;
                                    archiveCrossLaneUpdateCheck$prepare$14.L$1 = archiveUpdateCheckCoordinator7;
                                    archiveCrossLaneUpdateCheck$prepare$14.L$2 = durableArchiveStateStore3;
                                    archiveCrossLaneUpdateCheck$prepare$14.L$3 = durableArchiveStateStore4;
                                    archiveCrossLaneUpdateCheck$prepare$14.L$4 = SpillingKt.nullOutSpilledVariable(str12);
                                    archiveCrossLaneUpdateCheck$prepare$14.L$5 = SpillingKt.nullOutSpilledVariable(str11);
                                    archiveCrossLaneUpdateCheck$prepare$14.L$6 = SpillingKt.nullOutSpilledVariable(archiveGpu4);
                                    archiveCrossLaneUpdateCheck$prepare$14.L$7 = SpillingKt.nullOutSpilledVariable(str10);
                                    archiveCrossLaneUpdateCheck$prepare$14.L$8 = SpillingKt.nullOutSpilledVariable(archiveBootstrapPrefetcher4);
                                    archiveCrossLaneUpdateCheck$prepare$14.L$9 = function04;
                                    archiveCrossLaneUpdateCheck$prepare$14.L$10 = SpillingKt.nullOutSpilledVariable(archiveGenerationMigration5);
                                    archiveCrossLaneUpdateCheck$prepare$14.L$11 = SpillingKt.nullOutSpilledVariable(archiveUpdateCheckRemoteStage3);
                                    archiveCrossLaneUpdateCheck$prepare$14.L$12 = archiveManifest2;
                                    archiveCrossLaneUpdateCheck$prepare$14.L$13 = SpillingKt.nullOutSpilledVariable(archiveUpdateCheckRemoteStage5);
                                    archiveCrossLaneUpdateCheck$prepare$14.L$14 = remote2;
                                    archiveCrossLaneUpdateCheck$prepare$14.L$15 = state;
                                    archiveCrossLaneUpdateCheck$prepare$14.L$16 = state2;
                                    archiveCrossLaneUpdateCheck$prepare$14.L$17 = evaluate;
                                    archiveCrossLaneUpdateCheck$prepare$14.Z$0 = z10;
                                    archiveCrossLaneUpdateCheck$prepare$14.Z$1 = z7;
                                    archiveCrossLaneUpdateCheck$prepare$14.Z$2 = z15;
                                    z23 = z22;
                                    archiveCrossLaneUpdateCheck$prepare$14.Z$3 = z23;
                                    z24 = z21;
                                    archiveCrossLaneUpdateCheck$prepare$14.Z$4 = z24;
                                    ArchiveUpdateCheckCoordinator archiveUpdateCheckCoordinator13 = archiveUpdateCheckCoordinator8;
                                    archiveCrossLaneUpdateCheck$prepare$14.I$0 = z20;
                                    archiveCrossLaneUpdateCheck$prepare$14.I$1 = z19 ? 1 : 0;
                                    archiveCrossLaneUpdateCheck$prepare$14.label = 5;
                                    ArchiveCrossLaneUpdateCheck$prepare$1 archiveCrossLaneUpdateCheck$prepare$16 = archiveCrossLaneUpdateCheck$prepare$14;
                                    ArchiveManifest archiveManifest6 = archiveManifest2;
                                    ArchiveGenerationMigration archiveGenerationMigration7 = archiveGenerationMigration5;
                                    migrationGate3 = migrationGate(archiveGenerationMigration7, archiveManifest6, remote2, true, archiveCrossLaneUpdateCheck$prepare$16);
                                    archiveGenerationMigration6 = archiveGenerationMigration7;
                                    archiveCrossLaneUpdateCheck$prepare$15 = archiveCrossLaneUpdateCheck$prepare$16;
                                    obj6 = obj10;
                                    if (migrationGate3 != obj6) {
                                        boolean z36 = z10;
                                        obj7 = migrationGate3;
                                        z25 = z36;
                                        str13 = str12;
                                        function05 = function04;
                                        archiveUpdaterState = state2;
                                        archiveUpdaterState2 = state;
                                        durableArchiveStateStore5 = durableArchiveStateStore3;
                                        durableArchiveStateStore6 = durableArchiveStateStore4;
                                        archiveManifest3 = archiveManifest6;
                                        str14 = str11;
                                        archiveUpdateCheckRemoteStage6 = archiveUpdateCheckRemoteStage5;
                                        archiveManifest4 = remote2;
                                        archiveCrossLaneHandoffDecision = evaluate;
                                        z26 = z7;
                                        archiveUpdateCheckCoordinator9 = archiveUpdateCheckCoordinator13;
                                        i2 = z19;
                                        z27 = z15;
                                        i3 = z20;
                                        migrationGate4 = (MigrationGate) obj7;
                                        String str17 = str14;
                                        if (!(migrationGate4 instanceof MigrationGate.Blocked)) {
                                            return ((MigrationGate.Blocked) migrationGate4).getResult();
                                        }
                                        if (!(migrationGate4 instanceof MigrationGate.Open)) {
                                            throw new NoWhenBranchMatchedException();
                                        }
                                        boolean z37 = (z24 || ((MigrationGate.Open) migrationGate4).getDisallowExistingAdoption()) ? true : z6;
                                        if (i2 == 0 && archiveCrossLaneHandoffDecision != null && !archiveCrossLaneHandoffDecision.getTransfers().isEmpty()) {
                                            if (archiveUpdaterState2 == null || archiveUpdaterState == null) {
                                                return new ArchiveCrossLaneUpdateCheckResult(new ArchiveUpdateCheckDecision.Block(ArchiveUpdateCheckBlockCode.STATE_INVALID, "cross-lane ownership handoff requires committed BASE and VICE journals"), null, Boxing.boxBoolean(true), false, 10, null);
                                            }
                                            try {
                                                ArchiveCrossLaneOwnershipHandoff.INSTANCE.persist(durableArchiveStateStore5, durableArchiveStateStore6, archiveUpdaterState2, archiveUpdaterState, archiveCrossLaneHandoffDecision.getTransfers(), function05.invoke().longValue());
                                            } catch (IllegalStateException e2) {
                                                return new ArchiveCrossLaneUpdateCheckResult(new ArchiveUpdateCheckDecision.Block(ArchiveUpdateCheckBlockCode.STATE_INVALID, e2.getMessage()), null, Boxing.boxBoolean(true), false, 10, null);
                                            } catch (Exception e3) {
                                                return new ArchiveCrossLaneUpdateCheckResult(new ArchiveUpdateCheckDecision.Block(ArchiveUpdateCheckBlockCode.STATE_IO_FAILED, "unable to persist cross-lane ownership handoff: " + e3.getMessage()), null, Boxing.boxBoolean(true), false, 10, null);
                                            }
                                        }
                                        archiveCrossLaneUpdateCheck$prepare$15.L$0 = SpillingKt.nullOutSpilledVariable(archiveUpdateCheckCoordinator9);
                                        archiveCrossLaneUpdateCheck$prepare$15.L$1 = archiveUpdateCheckCoordinator7;
                                        archiveCrossLaneUpdateCheck$prepare$15.L$2 = SpillingKt.nullOutSpilledVariable(durableArchiveStateStore5);
                                        archiveCrossLaneUpdateCheck$prepare$15.L$3 = SpillingKt.nullOutSpilledVariable(durableArchiveStateStore6);
                                        archiveCrossLaneUpdateCheck$prepare$15.L$4 = SpillingKt.nullOutSpilledVariable(str13);
                                        archiveCrossLaneUpdateCheck$prepare$15.L$5 = SpillingKt.nullOutSpilledVariable(str17);
                                        archiveCrossLaneUpdateCheck$prepare$15.L$6 = SpillingKt.nullOutSpilledVariable(archiveGpu4);
                                        archiveCrossLaneUpdateCheck$prepare$15.L$7 = SpillingKt.nullOutSpilledVariable(str10);
                                        archiveCrossLaneUpdateCheck$prepare$15.L$8 = SpillingKt.nullOutSpilledVariable(archiveBootstrapPrefetcher4);
                                        archiveCrossLaneUpdateCheck$prepare$15.L$9 = SpillingKt.nullOutSpilledVariable(function05);
                                        archiveCrossLaneUpdateCheck$prepare$15.L$10 = SpillingKt.nullOutSpilledVariable(archiveGenerationMigration6);
                                        archiveCrossLaneUpdateCheck$prepare$15.L$11 = SpillingKt.nullOutSpilledVariable(archiveUpdateCheckRemoteStage3);
                                        archiveCrossLaneUpdateCheck$prepare$15.L$12 = SpillingKt.nullOutSpilledVariable(archiveManifest3);
                                        archiveCrossLaneUpdateCheck$prepare$15.L$13 = SpillingKt.nullOutSpilledVariable(archiveUpdateCheckRemoteStage6);
                                        archiveCrossLaneUpdateCheck$prepare$15.L$14 = archiveManifest4;
                                        archiveCrossLaneUpdateCheck$prepare$15.L$15 = SpillingKt.nullOutSpilledVariable(archiveUpdaterState2);
                                        archiveCrossLaneUpdateCheck$prepare$15.L$16 = SpillingKt.nullOutSpilledVariable(archiveUpdaterState);
                                        archiveCrossLaneUpdateCheck$prepare$15.L$17 = SpillingKt.nullOutSpilledVariable(archiveCrossLaneHandoffDecision);
                                        archiveCrossLaneUpdateCheck$prepare$15.Z$0 = z25;
                                        archiveCrossLaneUpdateCheck$prepare$15.Z$1 = z26;
                                        archiveCrossLaneUpdateCheck$prepare$15.Z$2 = z27;
                                        archiveCrossLaneUpdateCheck$prepare$15.Z$3 = z23;
                                        archiveCrossLaneUpdateCheck$prepare$15.Z$4 = z24;
                                        archiveCrossLaneUpdateCheck$prepare$15.I$0 = i3;
                                        archiveCrossLaneUpdateCheck$prepare$15.I$1 = i2;
                                        archiveCrossLaneUpdateCheck$prepare$15.I$2 = z37 ? 1 : 0;
                                        archiveCrossLaneUpdateCheck$prepare$15.label = 6;
                                        Object finishRemoteCheck = archiveUpdateCheckCoordinator9.finishRemoteCheck(archiveManifest3, z27, z37, archiveCrossLaneUpdateCheck$prepare$15);
                                        if (finishRemoteCheck != obj6) {
                                            int i7 = i3;
                                            function06 = function05;
                                            archiveUpdateCheckCoordinator10 = archiveUpdateCheckCoordinator9;
                                            z28 = z26;
                                            z29 = z23;
                                            i4 = i7;
                                            int i8 = i2;
                                            str15 = str17;
                                            archiveManifest5 = archiveManifest4;
                                            z30 = z25;
                                            archiveUpdateCheckCoordinator11 = archiveUpdateCheckCoordinator7;
                                            z31 = z27;
                                            obj8 = finishRemoteCheck;
                                            i5 = i8;
                                            i6 = z37;
                                            archiveUpdateCheckDecision = (ArchiveUpdateCheckDecision) obj8;
                                            String str18 = str15;
                                            if (archiveUpdateCheckDecision instanceof ArchiveUpdateCheckDecision.UseArchive) {
                                                return new ArchiveCrossLaneUpdateCheckResult(archiveUpdateCheckDecision, null, Boxing.boxBoolean(true), false, 10, null);
                                            }
                                            boolean z38 = i6 != 0 ? true : z6;
                                            archiveCrossLaneUpdateCheck$prepare$15.L$0 = SpillingKt.nullOutSpilledVariable(archiveUpdateCheckCoordinator10);
                                            archiveCrossLaneUpdateCheck$prepare$15.L$1 = SpillingKt.nullOutSpilledVariable(archiveUpdateCheckCoordinator11);
                                            archiveCrossLaneUpdateCheck$prepare$15.L$2 = SpillingKt.nullOutSpilledVariable(durableArchiveStateStore5);
                                            archiveCrossLaneUpdateCheck$prepare$15.L$3 = SpillingKt.nullOutSpilledVariable(durableArchiveStateStore6);
                                            archiveCrossLaneUpdateCheck$prepare$15.L$4 = SpillingKt.nullOutSpilledVariable(str13);
                                            archiveCrossLaneUpdateCheck$prepare$15.L$5 = SpillingKt.nullOutSpilledVariable(str18);
                                            archiveCrossLaneUpdateCheck$prepare$15.L$6 = SpillingKt.nullOutSpilledVariable(archiveGpu4);
                                            archiveCrossLaneUpdateCheck$prepare$15.L$7 = SpillingKt.nullOutSpilledVariable(str10);
                                            archiveCrossLaneUpdateCheck$prepare$15.L$8 = SpillingKt.nullOutSpilledVariable(archiveBootstrapPrefetcher4);
                                            archiveCrossLaneUpdateCheck$prepare$15.L$9 = SpillingKt.nullOutSpilledVariable(function06);
                                            archiveCrossLaneUpdateCheck$prepare$15.L$10 = SpillingKt.nullOutSpilledVariable(archiveGenerationMigration6);
                                            archiveCrossLaneUpdateCheck$prepare$15.L$11 = SpillingKt.nullOutSpilledVariable(archiveUpdateCheckRemoteStage3);
                                            archiveCrossLaneUpdateCheck$prepare$15.L$12 = SpillingKt.nullOutSpilledVariable(archiveManifest3);
                                            archiveCrossLaneUpdateCheck$prepare$15.L$13 = SpillingKt.nullOutSpilledVariable(archiveUpdateCheckRemoteStage6);
                                            archiveCrossLaneUpdateCheck$prepare$15.L$14 = SpillingKt.nullOutSpilledVariable(archiveManifest5);
                                            archiveCrossLaneUpdateCheck$prepare$15.L$15 = SpillingKt.nullOutSpilledVariable(archiveUpdaterState2);
                                            archiveCrossLaneUpdateCheck$prepare$15.L$16 = SpillingKt.nullOutSpilledVariable(archiveUpdaterState);
                                            archiveCrossLaneUpdateCheck$prepare$15.L$17 = SpillingKt.nullOutSpilledVariable(archiveCrossLaneHandoffDecision);
                                            archiveCrossLaneUpdateCheck$prepare$15.L$18 = archiveUpdateCheckDecision;
                                            archiveCrossLaneUpdateCheck$prepare$15.Z$0 = z30;
                                            archiveCrossLaneUpdateCheck$prepare$15.Z$1 = z28;
                                            archiveCrossLaneUpdateCheck$prepare$15.Z$2 = z31;
                                            archiveCrossLaneUpdateCheck$prepare$15.Z$3 = z29;
                                            archiveCrossLaneUpdateCheck$prepare$15.Z$4 = z24;
                                            archiveCrossLaneUpdateCheck$prepare$15.I$0 = i4;
                                            archiveCrossLaneUpdateCheck$prepare$15.I$1 = i5;
                                            archiveCrossLaneUpdateCheck$prepare$15.I$2 = i6;
                                            archiveCrossLaneUpdateCheck$prepare$15.label = 7;
                                            obj9 = archiveUpdateCheckCoordinator11.finishRemoteCheck(archiveManifest5, z29, z38, archiveCrossLaneUpdateCheck$prepare$15);
                                            if (obj9 != obj6) {
                                                archiveUpdateCheckDecision2 = archiveUpdateCheckDecision;
                                                archiveUpdateCheckDecision3 = (ArchiveUpdateCheckDecision) obj9;
                                                if (archiveUpdateCheckDecision3 instanceof ArchiveUpdateCheckDecision.Block) {
                                                    archiveUpdateCheckDecision2 = archiveUpdateCheckDecision3;
                                                }
                                                return new ArchiveCrossLaneUpdateCheckResult(archiveUpdateCheckDecision2, archiveUpdateCheckDecision3, Boxing.boxBoolean(true), false, 8, null);
                                            }
                                        }
                                    }
                                    return obj6;
                                }
                            } else {
                                archiveUpdateCheckRemoteStage5 = archiveUpdateCheckRemoteStage4;
                                z17 = z9;
                            }
                            z18 = z6;
                            if (z18) {
                            }
                            archiveCrossLaneUpdateCheck$prepare$14.L$0 = archiveUpdateCheckCoordinator8;
                            archiveCrossLaneUpdateCheck$prepare$14.L$1 = archiveUpdateCheckCoordinator7;
                            archiveCrossLaneUpdateCheck$prepare$14.L$2 = durableArchiveStateStore3;
                            archiveCrossLaneUpdateCheck$prepare$14.L$3 = durableArchiveStateStore4;
                            archiveCrossLaneUpdateCheck$prepare$14.L$4 = SpillingKt.nullOutSpilledVariable(str12);
                            archiveCrossLaneUpdateCheck$prepare$14.L$5 = SpillingKt.nullOutSpilledVariable(str11);
                            archiveCrossLaneUpdateCheck$prepare$14.L$6 = SpillingKt.nullOutSpilledVariable(archiveGpu4);
                            archiveCrossLaneUpdateCheck$prepare$14.L$7 = SpillingKt.nullOutSpilledVariable(str10);
                            archiveCrossLaneUpdateCheck$prepare$14.L$8 = SpillingKt.nullOutSpilledVariable(archiveBootstrapPrefetcher4);
                            archiveCrossLaneUpdateCheck$prepare$14.L$9 = function04;
                            archiveCrossLaneUpdateCheck$prepare$14.L$10 = SpillingKt.nullOutSpilledVariable(archiveGenerationMigration5);
                            archiveCrossLaneUpdateCheck$prepare$14.L$11 = SpillingKt.nullOutSpilledVariable(archiveUpdateCheckRemoteStage3);
                            archiveCrossLaneUpdateCheck$prepare$14.L$12 = archiveManifest2;
                            archiveCrossLaneUpdateCheck$prepare$14.L$13 = SpillingKt.nullOutSpilledVariable(archiveUpdateCheckRemoteStage5);
                            archiveCrossLaneUpdateCheck$prepare$14.L$14 = remote2;
                            archiveCrossLaneUpdateCheck$prepare$14.L$15 = state;
                            archiveCrossLaneUpdateCheck$prepare$14.L$16 = state2;
                            archiveCrossLaneUpdateCheck$prepare$14.L$17 = evaluate;
                            archiveCrossLaneUpdateCheck$prepare$14.Z$0 = z10;
                            archiveCrossLaneUpdateCheck$prepare$14.Z$1 = z7;
                            archiveCrossLaneUpdateCheck$prepare$14.Z$2 = z15;
                            z23 = z22;
                            archiveCrossLaneUpdateCheck$prepare$14.Z$3 = z23;
                            z24 = z21;
                            archiveCrossLaneUpdateCheck$prepare$14.Z$4 = z24;
                            ArchiveUpdateCheckCoordinator archiveUpdateCheckCoordinator132 = archiveUpdateCheckCoordinator8;
                            archiveCrossLaneUpdateCheck$prepare$14.I$0 = z20;
                            archiveCrossLaneUpdateCheck$prepare$14.I$1 = z19 ? 1 : 0;
                            archiveCrossLaneUpdateCheck$prepare$14.label = 5;
                            ArchiveCrossLaneUpdateCheck$prepare$1 archiveCrossLaneUpdateCheck$prepare$162 = archiveCrossLaneUpdateCheck$prepare$14;
                            ArchiveManifest archiveManifest62 = archiveManifest2;
                            ArchiveGenerationMigration archiveGenerationMigration72 = archiveGenerationMigration5;
                            migrationGate3 = migrationGate(archiveGenerationMigration72, archiveManifest62, remote2, true, archiveCrossLaneUpdateCheck$prepare$162);
                            archiveGenerationMigration6 = archiveGenerationMigration72;
                            archiveCrossLaneUpdateCheck$prepare$15 = archiveCrossLaneUpdateCheck$prepare$162;
                            obj6 = obj10;
                            if (migrationGate3 != obj6) {
                            }
                            return obj6;
                        }
                        String str19 = str4;
                        str7 = str5;
                        function03 = function02;
                        archiveUpdateCheckCoordinator5 = archiveUpdateCheckCoordinator3;
                        obj2 = coroutine_suspended;
                        ArchiveGpu archiveGpu5 = archiveGpu2;
                        if (archiveGenerationMigration2 != null) {
                            archiveGenerationMigration3 = archiveGenerationMigration2;
                            if (archiveGenerationMigration2.getDestructiveCleanup()) {
                                ArchiveUpdateCheckDecision.Block desiredOnlyCollision2 = desiredOnlyCollision(remote, null);
                                if (desiredOnlyCollision2 != null) {
                                    return new ArchiveCrossLaneUpdateCheckResult(desiredOnlyCollision2, null, null, false, 14, null);
                                }
                                archiveCrossLaneUpdateCheck$prepare$12.L$0 = archiveUpdateCheckCoordinator4;
                                archiveCrossLaneUpdateCheck$prepare$12.L$1 = SpillingKt.nullOutSpilledVariable(archiveUpdateCheckCoordinator5);
                                archiveCrossLaneUpdateCheck$prepare$12.L$2 = SpillingKt.nullOutSpilledVariable(durableArchiveStateStore3);
                                archiveCrossLaneUpdateCheck$prepare$12.L$3 = SpillingKt.nullOutSpilledVariable(durableArchiveStateStore4);
                                archiveCrossLaneUpdateCheck$prepare$12.L$4 = SpillingKt.nullOutSpilledVariable(str6);
                                archiveCrossLaneUpdateCheck$prepare$12.L$5 = SpillingKt.nullOutSpilledVariable(str19);
                                archiveCrossLaneUpdateCheck$prepare$12.L$6 = SpillingKt.nullOutSpilledVariable(archiveGpu5);
                                archiveCrossLaneUpdateCheck$prepare$12.L$7 = SpillingKt.nullOutSpilledVariable(str7);
                                archiveCrossLaneUpdateCheck$prepare$12.L$8 = SpillingKt.nullOutSpilledVariable(archiveBootstrapPrefetcher2);
                                archiveCrossLaneUpdateCheck$prepare$12.L$9 = SpillingKt.nullOutSpilledVariable(function03);
                                archiveCrossLaneUpdateCheck$prepare$12.L$10 = SpillingKt.nullOutSpilledVariable(archiveGenerationMigration3);
                                archiveCrossLaneUpdateCheck$prepare$12.L$11 = SpillingKt.nullOutSpilledVariable(archiveUpdateCheckRemoteStage);
                                archiveCrossLaneUpdateCheck$prepare$12.L$12 = remote;
                                archiveCrossLaneUpdateCheck$prepare$12.Z$0 = z10;
                                archiveCrossLaneUpdateCheck$prepare$12.Z$1 = z7;
                                archiveCrossLaneUpdateCheck$prepare$12.Z$2 = z11;
                                archiveCrossLaneUpdateCheck$prepare$12.Z$3 = z8;
                                archiveCrossLaneUpdateCheck$prepare$12.Z$4 = z12;
                                archiveCrossLaneUpdateCheck$prepare$12.I$0 = z13 ? 1 : 0;
                                archiveCrossLaneUpdateCheck$prepare$12.label = 2;
                                migrationGate = migrationGate(archiveGenerationMigration3, remote, null, false, archiveCrossLaneUpdateCheck$prepare$12);
                                ArchiveGenerationMigration archiveGenerationMigration8 = archiveGenerationMigration3;
                                archiveCrossLaneUpdateCheck$prepare$13 = archiveCrossLaneUpdateCheck$prepare$12;
                                if (migrationGate != obj2) {
                                    return obj2;
                                }
                                archiveUpdateCheckRemoteStage2 = archiveUpdateCheckRemoteStage;
                                archiveManifest = remote;
                                archiveGenerationMigration4 = archiveGenerationMigration8;
                                archiveGpu3 = archiveGpu5;
                                archiveBootstrapPrefetcher3 = archiveBootstrapPrefetcher2;
                                obj3 = migrationGate;
                                z14 = z11;
                                archiveUpdateCheckCoordinator6 = archiveUpdateCheckCoordinator4;
                                str8 = str19;
                                str9 = str6;
                                i = z13;
                                migrationGate2 = (MigrationGate) obj3;
                                if (migrationGate2 instanceof MigrationGate.Blocked) {
                                    if (migrationGate2 instanceof MigrationGate.Open) {
                                        ?? r4 = (z12 || ((MigrationGate.Open) migrationGate2).getDisallowExistingAdoption()) ? 1 : z6;
                                        archiveCrossLaneUpdateCheck$prepare$13.L$0 = SpillingKt.nullOutSpilledVariable(archiveUpdateCheckCoordinator6);
                                        archiveCrossLaneUpdateCheck$prepare$13.L$1 = SpillingKt.nullOutSpilledVariable(archiveUpdateCheckCoordinator5);
                                        archiveCrossLaneUpdateCheck$prepare$13.L$2 = SpillingKt.nullOutSpilledVariable(durableArchiveStateStore3);
                                        archiveCrossLaneUpdateCheck$prepare$13.L$3 = SpillingKt.nullOutSpilledVariable(durableArchiveStateStore4);
                                        archiveCrossLaneUpdateCheck$prepare$13.L$4 = SpillingKt.nullOutSpilledVariable(str9);
                                        archiveCrossLaneUpdateCheck$prepare$13.L$5 = SpillingKt.nullOutSpilledVariable(str8);
                                        archiveCrossLaneUpdateCheck$prepare$13.L$6 = SpillingKt.nullOutSpilledVariable(archiveGpu3);
                                        archiveCrossLaneUpdateCheck$prepare$13.L$7 = SpillingKt.nullOutSpilledVariable(str7);
                                        archiveCrossLaneUpdateCheck$prepare$13.L$8 = SpillingKt.nullOutSpilledVariable(archiveBootstrapPrefetcher3);
                                        archiveCrossLaneUpdateCheck$prepare$13.L$9 = SpillingKt.nullOutSpilledVariable(function03);
                                        archiveCrossLaneUpdateCheck$prepare$13.L$10 = SpillingKt.nullOutSpilledVariable(archiveGenerationMigration4);
                                        archiveCrossLaneUpdateCheck$prepare$13.L$11 = SpillingKt.nullOutSpilledVariable(archiveUpdateCheckRemoteStage2);
                                        archiveCrossLaneUpdateCheck$prepare$13.L$12 = SpillingKt.nullOutSpilledVariable(archiveManifest);
                                        archiveCrossLaneUpdateCheck$prepare$13.Z$0 = z10;
                                        archiveCrossLaneUpdateCheck$prepare$13.Z$1 = z7;
                                        archiveCrossLaneUpdateCheck$prepare$13.Z$2 = z14;
                                        archiveCrossLaneUpdateCheck$prepare$13.Z$3 = z8;
                                        archiveCrossLaneUpdateCheck$prepare$13.Z$4 = z12;
                                        archiveCrossLaneUpdateCheck$prepare$13.I$0 = i;
                                        archiveCrossLaneUpdateCheck$prepare$13.I$1 = r4;
                                        archiveCrossLaneUpdateCheck$prepare$13.label = 3;
                                        Object finishRemoteCheck2 = archiveUpdateCheckCoordinator6.finishRemoteCheck(archiveManifest, z14, r4, archiveCrossLaneUpdateCheck$prepare$13);
                                        if (finishRemoteCheck2 == obj2) {
                                            return obj2;
                                        }
                                        obj9 = finishRemoteCheck2;
                                        ArchiveUpdateCheckDecision archiveUpdateCheckDecision4 = (ArchiveUpdateCheckDecision) obj9;
                                        return !(archiveUpdateCheckDecision4 instanceof ArchiveUpdateCheckDecision.UseArchive) ? new ArchiveCrossLaneUpdateCheckResult(archiveUpdateCheckDecision4, null, Boxing.boxBoolean(z6), true, 2, null) : new ArchiveCrossLaneUpdateCheckResult(archiveUpdateCheckDecision4, null, null, false, 14, null);
                                    }
                                    throw new NoWhenBranchMatchedException();
                                }
                                return ((MigrationGate.Blocked) migrationGate2).getResult();
                            }
                        } else {
                            archiveGenerationMigration3 = archiveGenerationMigration2;
                        }
                        ArchiveUpdateCheckDecision.Block laneCollisionBlock = laneCollisionBlock(remote, null, durableArchiveStateStore3, durableArchiveStateStore4);
                        if (laneCollisionBlock != null) {
                            return new ArchiveCrossLaneUpdateCheckResult(laneCollisionBlock, null, null, false, 14, null);
                        }
                        archiveCrossLaneUpdateCheck$prepare$12.L$0 = archiveUpdateCheckCoordinator4;
                        archiveCrossLaneUpdateCheck$prepare$12.L$1 = SpillingKt.nullOutSpilledVariable(archiveUpdateCheckCoordinator5);
                        archiveCrossLaneUpdateCheck$prepare$12.L$2 = SpillingKt.nullOutSpilledVariable(durableArchiveStateStore3);
                        archiveCrossLaneUpdateCheck$prepare$12.L$3 = SpillingKt.nullOutSpilledVariable(durableArchiveStateStore4);
                        archiveCrossLaneUpdateCheck$prepare$12.L$4 = SpillingKt.nullOutSpilledVariable(str6);
                        archiveCrossLaneUpdateCheck$prepare$12.L$5 = SpillingKt.nullOutSpilledVariable(str19);
                        archiveCrossLaneUpdateCheck$prepare$12.L$6 = SpillingKt.nullOutSpilledVariable(archiveGpu5);
                        archiveCrossLaneUpdateCheck$prepare$12.L$7 = SpillingKt.nullOutSpilledVariable(str7);
                        archiveCrossLaneUpdateCheck$prepare$12.L$8 = SpillingKt.nullOutSpilledVariable(archiveBootstrapPrefetcher2);
                        archiveCrossLaneUpdateCheck$prepare$12.L$9 = SpillingKt.nullOutSpilledVariable(function03);
                        archiveCrossLaneUpdateCheck$prepare$12.L$10 = SpillingKt.nullOutSpilledVariable(archiveGenerationMigration3);
                        archiveCrossLaneUpdateCheck$prepare$12.L$11 = SpillingKt.nullOutSpilledVariable(archiveUpdateCheckRemoteStage);
                        archiveCrossLaneUpdateCheck$prepare$12.L$12 = remote;
                        archiveCrossLaneUpdateCheck$prepare$12.Z$0 = z10;
                        archiveCrossLaneUpdateCheck$prepare$12.Z$1 = z7;
                        archiveCrossLaneUpdateCheck$prepare$12.Z$2 = z11;
                        archiveCrossLaneUpdateCheck$prepare$12.Z$3 = z8;
                        archiveCrossLaneUpdateCheck$prepare$12.Z$4 = z12;
                        archiveCrossLaneUpdateCheck$prepare$12.I$0 = z13 ? 1 : 0;
                        archiveCrossLaneUpdateCheck$prepare$12.label = 2;
                        migrationGate = migrationGate(archiveGenerationMigration3, remote, null, false, archiveCrossLaneUpdateCheck$prepare$12);
                        ArchiveGenerationMigration archiveGenerationMigration82 = archiveGenerationMigration3;
                        archiveCrossLaneUpdateCheck$prepare$13 = archiveCrossLaneUpdateCheck$prepare$12;
                        if (migrationGate != obj2) {
                        }
                        break;
                    case 1:
                        z6 = false;
                        z9 = true;
                        ?? r1 = archiveCrossLaneUpdateCheck$prepare$12.I$0;
                        boolean z39 = archiveCrossLaneUpdateCheck$prepare$12.Z$4;
                        z8 = archiveCrossLaneUpdateCheck$prepare$12.Z$3;
                        boolean z40 = archiveCrossLaneUpdateCheck$prepare$12.Z$2;
                        boolean z41 = archiveCrossLaneUpdateCheck$prepare$12.Z$1;
                        z10 = archiveCrossLaneUpdateCheck$prepare$12.Z$0;
                        str4 = (String) archiveCrossLaneUpdateCheck$prepare$12.L$5;
                        String str20 = (String) archiveCrossLaneUpdateCheck$prepare$12.L$4;
                        DurableArchiveStateStore durableArchiveStateStore7 = (DurableArchiveStateStore) archiveCrossLaneUpdateCheck$prepare$12.L$3;
                        DurableArchiveStateStore durableArchiveStateStore8 = (DurableArchiveStateStore) archiveCrossLaneUpdateCheck$prepare$12.L$2;
                        ArchiveUpdateCheckCoordinator archiveUpdateCheckCoordinator14 = (ArchiveUpdateCheckCoordinator) archiveCrossLaneUpdateCheck$prepare$12.L$1;
                        ResultKt.throwOnFailure(obj9);
                        archiveUpdateCheckCoordinator4 = (ArchiveUpdateCheckCoordinator) archiveCrossLaneUpdateCheck$prepare$12.L$0;
                        z11 = z40;
                        function02 = (Function0) archiveCrossLaneUpdateCheck$prepare$12.L$9;
                        z7 = z41;
                        archiveGenerationMigration2 = (ArchiveGenerationMigration) archiveCrossLaneUpdateCheck$prepare$12.L$10;
                        z12 = z39;
                        str6 = str20;
                        obj = obj9;
                        archiveBootstrapPrefetcher2 = (ArchiveBootstrapPrefetcher) archiveCrossLaneUpdateCheck$prepare$12.L$8;
                        archiveGpu2 = (ArchiveGpu) archiveCrossLaneUpdateCheck$prepare$12.L$6;
                        z13 = r1;
                        durableArchiveStateStore4 = durableArchiveStateStore7;
                        archiveUpdateCheckCoordinator3 = archiveUpdateCheckCoordinator14;
                        str5 = (String) archiveCrossLaneUpdateCheck$prepare$12.L$7;
                        durableArchiveStateStore3 = durableArchiveStateStore8;
                        archiveUpdateCheckRemoteStage = (ArchiveUpdateCheckRemoteStage) obj;
                        if (!(archiveUpdateCheckRemoteStage instanceof ArchiveUpdateCheckRemoteStage.Completed)) {
                        }
                        break;
                    case 2:
                        z6 = false;
                        int i9 = archiveCrossLaneUpdateCheck$prepare$12.I$0;
                        boolean z42 = archiveCrossLaneUpdateCheck$prepare$12.Z$4;
                        boolean z43 = archiveCrossLaneUpdateCheck$prepare$12.Z$3;
                        boolean z44 = archiveCrossLaneUpdateCheck$prepare$12.Z$2;
                        boolean z45 = archiveCrossLaneUpdateCheck$prepare$12.Z$1;
                        boolean z46 = archiveCrossLaneUpdateCheck$prepare$12.Z$0;
                        String str21 = (String) archiveCrossLaneUpdateCheck$prepare$12.L$5;
                        String str22 = (String) archiveCrossLaneUpdateCheck$prepare$12.L$4;
                        DurableArchiveStateStore durableArchiveStateStore9 = (DurableArchiveStateStore) archiveCrossLaneUpdateCheck$prepare$12.L$3;
                        DurableArchiveStateStore durableArchiveStateStore10 = (DurableArchiveStateStore) archiveCrossLaneUpdateCheck$prepare$12.L$2;
                        ArchiveUpdateCheckCoordinator archiveUpdateCheckCoordinator15 = (ArchiveUpdateCheckCoordinator) archiveCrossLaneUpdateCheck$prepare$12.L$1;
                        archiveUpdateCheckCoordinator6 = (ArchiveUpdateCheckCoordinator) archiveCrossLaneUpdateCheck$prepare$12.L$0;
                        ResultKt.throwOnFailure(obj9);
                        obj3 = obj9;
                        obj2 = coroutine_suspended;
                        function03 = (Function0) archiveCrossLaneUpdateCheck$prepare$12.L$9;
                        archiveBootstrapPrefetcher3 = (ArchiveBootstrapPrefetcher) archiveCrossLaneUpdateCheck$prepare$12.L$8;
                        str7 = (String) archiveCrossLaneUpdateCheck$prepare$12.L$7;
                        archiveGpu3 = (ArchiveGpu) archiveCrossLaneUpdateCheck$prepare$12.L$6;
                        i = i9;
                        durableArchiveStateStore4 = durableArchiveStateStore9;
                        durableArchiveStateStore3 = durableArchiveStateStore10;
                        archiveGenerationMigration4 = (ArchiveGenerationMigration) archiveCrossLaneUpdateCheck$prepare$12.L$10;
                        archiveCrossLaneUpdateCheck$prepare$13 = archiveCrossLaneUpdateCheck$prepare$12;
                        archiveUpdateCheckCoordinator5 = archiveUpdateCheckCoordinator15;
                        z7 = z45;
                        z14 = z44;
                        z8 = z43;
                        str8 = str21;
                        archiveManifest = (ArchiveManifest) archiveCrossLaneUpdateCheck$prepare$12.L$12;
                        z10 = z46;
                        archiveUpdateCheckRemoteStage2 = (ArchiveUpdateCheckRemoteStage) archiveCrossLaneUpdateCheck$prepare$12.L$11;
                        z12 = z42;
                        str9 = str22;
                        migrationGate2 = (MigrationGate) obj3;
                        if (migrationGate2 instanceof MigrationGate.Blocked) {
                        }
                        break;
                    case 3:
                        z6 = false;
                        int i10 = archiveCrossLaneUpdateCheck$prepare$12.I$1;
                        int i11 = archiveCrossLaneUpdateCheck$prepare$12.I$0;
                        boolean z47 = archiveCrossLaneUpdateCheck$prepare$12.Z$4;
                        boolean z48 = archiveCrossLaneUpdateCheck$prepare$12.Z$3;
                        boolean z49 = archiveCrossLaneUpdateCheck$prepare$12.Z$2;
                        boolean z50 = archiveCrossLaneUpdateCheck$prepare$12.Z$1;
                        boolean z51 = archiveCrossLaneUpdateCheck$prepare$12.Z$0;
                        ArchiveManifest archiveManifest7 = (ArchiveManifest) archiveCrossLaneUpdateCheck$prepare$12.L$12;
                        ArchiveUpdateCheckRemoteStage archiveUpdateCheckRemoteStage7 = (ArchiveUpdateCheckRemoteStage) archiveCrossLaneUpdateCheck$prepare$12.L$11;
                        ArchiveGenerationMigration archiveGenerationMigration9 = (ArchiveGenerationMigration) archiveCrossLaneUpdateCheck$prepare$12.L$10;
                        Function0 function08 = (Function0) archiveCrossLaneUpdateCheck$prepare$12.L$9;
                        ArchiveBootstrapPrefetcher archiveBootstrapPrefetcher5 = (ArchiveBootstrapPrefetcher) archiveCrossLaneUpdateCheck$prepare$12.L$8;
                        String str23 = (String) archiveCrossLaneUpdateCheck$prepare$12.L$7;
                        ArchiveGpu archiveGpu6 = (ArchiveGpu) archiveCrossLaneUpdateCheck$prepare$12.L$6;
                        String str24 = (String) archiveCrossLaneUpdateCheck$prepare$12.L$5;
                        String str25 = (String) archiveCrossLaneUpdateCheck$prepare$12.L$4;
                        DurableArchiveStateStore durableArchiveStateStore11 = (DurableArchiveStateStore) archiveCrossLaneUpdateCheck$prepare$12.L$3;
                        DurableArchiveStateStore durableArchiveStateStore12 = (DurableArchiveStateStore) archiveCrossLaneUpdateCheck$prepare$12.L$2;
                        ArchiveUpdateCheckCoordinator archiveUpdateCheckCoordinator16 = (ArchiveUpdateCheckCoordinator) archiveCrossLaneUpdateCheck$prepare$12.L$1;
                        ArchiveUpdateCheckCoordinator archiveUpdateCheckCoordinator17 = (ArchiveUpdateCheckCoordinator) archiveCrossLaneUpdateCheck$prepare$12.L$0;
                        ResultKt.throwOnFailure(obj9);
                        ArchiveUpdateCheckDecision archiveUpdateCheckDecision42 = (ArchiveUpdateCheckDecision) obj9;
                        if (!(archiveUpdateCheckDecision42 instanceof ArchiveUpdateCheckDecision.UseArchive)) {
                        }
                        break;
                    case 4:
                        z6 = false;
                        z9 = true;
                        ?? r12 = archiveCrossLaneUpdateCheck$prepare$12.I$0;
                        boolean z52 = archiveCrossLaneUpdateCheck$prepare$12.Z$4;
                        z8 = archiveCrossLaneUpdateCheck$prepare$12.Z$3;
                        boolean z53 = archiveCrossLaneUpdateCheck$prepare$12.Z$2;
                        boolean z54 = archiveCrossLaneUpdateCheck$prepare$12.Z$1;
                        z10 = archiveCrossLaneUpdateCheck$prepare$12.Z$0;
                        ArchiveManifest archiveManifest8 = (ArchiveManifest) archiveCrossLaneUpdateCheck$prepare$12.L$12;
                        String str26 = (String) archiveCrossLaneUpdateCheck$prepare$12.L$7;
                        ArchiveGpu archiveGpu7 = (ArchiveGpu) archiveCrossLaneUpdateCheck$prepare$12.L$6;
                        String str27 = (String) archiveCrossLaneUpdateCheck$prepare$12.L$5;
                        String str28 = (String) archiveCrossLaneUpdateCheck$prepare$12.L$4;
                        DurableArchiveStateStore durableArchiveStateStore13 = (DurableArchiveStateStore) archiveCrossLaneUpdateCheck$prepare$12.L$3;
                        DurableArchiveStateStore durableArchiveStateStore14 = (DurableArchiveStateStore) archiveCrossLaneUpdateCheck$prepare$12.L$2;
                        ArchiveUpdateCheckCoordinator archiveUpdateCheckCoordinator18 = (ArchiveUpdateCheckCoordinator) archiveCrossLaneUpdateCheck$prepare$12.L$1;
                        archiveUpdateCheckCoordinator8 = (ArchiveUpdateCheckCoordinator) archiveCrossLaneUpdateCheck$prepare$12.L$0;
                        ResultKt.throwOnFailure(obj9);
                        z12 = z52;
                        archiveManifest2 = archiveManifest8;
                        str10 = str26;
                        archiveGpu4 = archiveGpu7;
                        archiveUpdateCheckRemoteStage3 = (ArchiveUpdateCheckRemoteStage) archiveCrossLaneUpdateCheck$prepare$12.L$11;
                        archiveGenerationMigration5 = (ArchiveGenerationMigration) archiveCrossLaneUpdateCheck$prepare$12.L$10;
                        archiveCrossLaneUpdateCheck$prepare$14 = archiveCrossLaneUpdateCheck$prepare$12;
                        archiveBootstrapPrefetcher4 = (ArchiveBootstrapPrefetcher) archiveCrossLaneUpdateCheck$prepare$12.L$8;
                        z16 = r12;
                        durableArchiveStateStore3 = durableArchiveStateStore14;
                        archiveUpdateCheckCoordinator7 = archiveUpdateCheckCoordinator18;
                        z7 = z54;
                        str11 = str27;
                        str12 = str28;
                        z15 = z53;
                        obj4 = coroutine_suspended;
                        obj5 = obj9;
                        function04 = (Function0) archiveCrossLaneUpdateCheck$prepare$12.L$9;
                        durableArchiveStateStore4 = durableArchiveStateStore13;
                        archiveUpdateCheckRemoteStage4 = (ArchiveUpdateCheckRemoteStage) obj5;
                        Object obj102 = obj4;
                        if (!(archiveUpdateCheckRemoteStage4 instanceof ArchiveUpdateCheckRemoteStage.Completed)) {
                        }
                        break;
                    case 5:
                        z6 = false;
                        int i12 = archiveCrossLaneUpdateCheck$prepare$12.I$1;
                        int i13 = archiveCrossLaneUpdateCheck$prepare$12.I$0;
                        boolean z55 = archiveCrossLaneUpdateCheck$prepare$12.Z$4;
                        boolean z56 = archiveCrossLaneUpdateCheck$prepare$12.Z$3;
                        boolean z57 = archiveCrossLaneUpdateCheck$prepare$12.Z$2;
                        boolean z58 = archiveCrossLaneUpdateCheck$prepare$12.Z$1;
                        boolean z59 = archiveCrossLaneUpdateCheck$prepare$12.Z$0;
                        archiveUpdateCheckRemoteStage6 = (ArchiveUpdateCheckRemoteStage) archiveCrossLaneUpdateCheck$prepare$12.L$13;
                        archiveManifest3 = (ArchiveManifest) archiveCrossLaneUpdateCheck$prepare$12.L$12;
                        ArchiveUpdateCheckRemoteStage archiveUpdateCheckRemoteStage8 = (ArchiveUpdateCheckRemoteStage) archiveCrossLaneUpdateCheck$prepare$12.L$11;
                        ArchiveGenerationMigration archiveGenerationMigration10 = (ArchiveGenerationMigration) archiveCrossLaneUpdateCheck$prepare$12.L$10;
                        Function0<Long> function09 = (Function0) archiveCrossLaneUpdateCheck$prepare$12.L$9;
                        ArchiveBootstrapPrefetcher archiveBootstrapPrefetcher6 = (ArchiveBootstrapPrefetcher) archiveCrossLaneUpdateCheck$prepare$12.L$8;
                        String str29 = (String) archiveCrossLaneUpdateCheck$prepare$12.L$7;
                        ArchiveGpu archiveGpu8 = (ArchiveGpu) archiveCrossLaneUpdateCheck$prepare$12.L$6;
                        String str30 = (String) archiveCrossLaneUpdateCheck$prepare$12.L$5;
                        String str31 = (String) archiveCrossLaneUpdateCheck$prepare$12.L$4;
                        DurableArchiveStateStore durableArchiveStateStore15 = (DurableArchiveStateStore) archiveCrossLaneUpdateCheck$prepare$12.L$3;
                        DurableArchiveStateStore durableArchiveStateStore16 = (DurableArchiveStateStore) archiveCrossLaneUpdateCheck$prepare$12.L$2;
                        ArchiveUpdateCheckCoordinator archiveUpdateCheckCoordinator19 = (ArchiveUpdateCheckCoordinator) archiveCrossLaneUpdateCheck$prepare$12.L$1;
                        ResultKt.throwOnFailure(obj9);
                        archiveUpdateCheckCoordinator9 = (ArchiveUpdateCheckCoordinator) archiveCrossLaneUpdateCheck$prepare$12.L$0;
                        z25 = z59;
                        obj7 = obj9;
                        archiveManifest4 = (ArchiveManifest) archiveCrossLaneUpdateCheck$prepare$12.L$14;
                        z24 = z55;
                        archiveUpdateCheckRemoteStage3 = archiveUpdateCheckRemoteStage8;
                        archiveGenerationMigration6 = archiveGenerationMigration10;
                        archiveBootstrapPrefetcher4 = archiveBootstrapPrefetcher6;
                        str10 = str29;
                        archiveGpu4 = archiveGpu8;
                        str13 = str31;
                        durableArchiveStateStore6 = durableArchiveStateStore15;
                        durableArchiveStateStore5 = durableArchiveStateStore16;
                        archiveCrossLaneHandoffDecision = (ArchiveCrossLaneHandoffDecision) archiveCrossLaneUpdateCheck$prepare$12.L$17;
                        archiveUpdaterState = (ArchiveUpdaterState) archiveCrossLaneUpdateCheck$prepare$12.L$16;
                        archiveUpdaterState2 = (ArchiveUpdaterState) archiveCrossLaneUpdateCheck$prepare$12.L$15;
                        z23 = z56;
                        z27 = z57;
                        z26 = z58;
                        archiveCrossLaneUpdateCheck$prepare$15 = archiveCrossLaneUpdateCheck$prepare$12;
                        i2 = i12;
                        function05 = function09;
                        archiveUpdateCheckCoordinator7 = archiveUpdateCheckCoordinator19;
                        i3 = i13;
                        obj6 = coroutine_suspended;
                        str14 = str30;
                        migrationGate4 = (MigrationGate) obj7;
                        String str172 = str14;
                        if (!(migrationGate4 instanceof MigrationGate.Blocked)) {
                        }
                        break;
                    case 6:
                        int i14 = archiveCrossLaneUpdateCheck$prepare$12.I$2;
                        int i15 = archiveCrossLaneUpdateCheck$prepare$12.I$1;
                        int i16 = archiveCrossLaneUpdateCheck$prepare$12.I$0;
                        boolean z60 = archiveCrossLaneUpdateCheck$prepare$12.Z$4;
                        boolean z61 = archiveCrossLaneUpdateCheck$prepare$12.Z$3;
                        boolean z62 = archiveCrossLaneUpdateCheck$prepare$12.Z$2;
                        boolean z63 = archiveCrossLaneUpdateCheck$prepare$12.Z$1;
                        boolean z64 = archiveCrossLaneUpdateCheck$prepare$12.Z$0;
                        z6 = false;
                        ArchiveManifest archiveManifest9 = (ArchiveManifest) archiveCrossLaneUpdateCheck$prepare$12.L$12;
                        ArchiveUpdateCheckRemoteStage archiveUpdateCheckRemoteStage9 = (ArchiveUpdateCheckRemoteStage) archiveCrossLaneUpdateCheck$prepare$12.L$11;
                        ArchiveGenerationMigration archiveGenerationMigration11 = (ArchiveGenerationMigration) archiveCrossLaneUpdateCheck$prepare$12.L$10;
                        Function0<Long> function010 = (Function0) archiveCrossLaneUpdateCheck$prepare$12.L$9;
                        ArchiveBootstrapPrefetcher archiveBootstrapPrefetcher7 = (ArchiveBootstrapPrefetcher) archiveCrossLaneUpdateCheck$prepare$12.L$8;
                        String str32 = (String) archiveCrossLaneUpdateCheck$prepare$12.L$7;
                        ArchiveGpu archiveGpu9 = (ArchiveGpu) archiveCrossLaneUpdateCheck$prepare$12.L$6;
                        String str33 = (String) archiveCrossLaneUpdateCheck$prepare$12.L$5;
                        String str34 = (String) archiveCrossLaneUpdateCheck$prepare$12.L$4;
                        DurableArchiveStateStore durableArchiveStateStore17 = (DurableArchiveStateStore) archiveCrossLaneUpdateCheck$prepare$12.L$3;
                        DurableArchiveStateStore durableArchiveStateStore18 = (DurableArchiveStateStore) archiveCrossLaneUpdateCheck$prepare$12.L$2;
                        ArchiveUpdateCheckCoordinator archiveUpdateCheckCoordinator20 = (ArchiveUpdateCheckCoordinator) archiveCrossLaneUpdateCheck$prepare$12.L$1;
                        ResultKt.throwOnFailure(obj9);
                        i4 = i16;
                        z28 = z63;
                        obj8 = obj9;
                        z30 = z64;
                        archiveUpdateCheckRemoteStage3 = archiveUpdateCheckRemoteStage9;
                        archiveGenerationMigration6 = archiveGenerationMigration11;
                        archiveBootstrapPrefetcher4 = archiveBootstrapPrefetcher7;
                        str10 = str32;
                        archiveGpu4 = archiveGpu9;
                        durableArchiveStateStore6 = durableArchiveStateStore17;
                        durableArchiveStateStore5 = durableArchiveStateStore18;
                        archiveCrossLaneHandoffDecision = (ArchiveCrossLaneHandoffDecision) archiveCrossLaneUpdateCheck$prepare$12.L$17;
                        archiveUpdaterState = (ArchiveUpdaterState) archiveCrossLaneUpdateCheck$prepare$12.L$16;
                        archiveUpdaterState2 = (ArchiveUpdaterState) archiveCrossLaneUpdateCheck$prepare$12.L$15;
                        archiveManifest5 = (ArchiveManifest) archiveCrossLaneUpdateCheck$prepare$12.L$14;
                        archiveManifest3 = archiveManifest9;
                        str13 = str34;
                        z24 = z60;
                        archiveUpdateCheckRemoteStage6 = (ArchiveUpdateCheckRemoteStage) archiveCrossLaneUpdateCheck$prepare$12.L$13;
                        z29 = z61;
                        archiveCrossLaneUpdateCheck$prepare$15 = archiveCrossLaneUpdateCheck$prepare$12;
                        function06 = function010;
                        str15 = str33;
                        z31 = z62;
                        i5 = i15;
                        obj6 = coroutine_suspended;
                        i6 = i14;
                        archiveUpdateCheckCoordinator10 = (ArchiveUpdateCheckCoordinator) archiveCrossLaneUpdateCheck$prepare$12.L$0;
                        archiveUpdateCheckCoordinator11 = archiveUpdateCheckCoordinator20;
                        archiveUpdateCheckDecision = (ArchiveUpdateCheckDecision) obj8;
                        String str182 = str15;
                        if (archiveUpdateCheckDecision instanceof ArchiveUpdateCheckDecision.UseArchive) {
                        }
                        break;
                    case 7:
                        int i17 = archiveCrossLaneUpdateCheck$prepare$12.I$2;
                        int i18 = archiveCrossLaneUpdateCheck$prepare$12.I$1;
                        int i19 = archiveCrossLaneUpdateCheck$prepare$12.I$0;
                        boolean z65 = archiveCrossLaneUpdateCheck$prepare$12.Z$4;
                        boolean z66 = archiveCrossLaneUpdateCheck$prepare$12.Z$3;
                        boolean z67 = archiveCrossLaneUpdateCheck$prepare$12.Z$2;
                        boolean z68 = archiveCrossLaneUpdateCheck$prepare$12.Z$1;
                        boolean z69 = archiveCrossLaneUpdateCheck$prepare$12.Z$0;
                        archiveUpdateCheckDecision2 = (ArchiveUpdateCheckDecision) archiveCrossLaneUpdateCheck$prepare$12.L$18;
                        ArchiveCrossLaneHandoffDecision archiveCrossLaneHandoffDecision2 = (ArchiveCrossLaneHandoffDecision) archiveCrossLaneUpdateCheck$prepare$12.L$17;
                        ArchiveUpdaterState archiveUpdaterState3 = (ArchiveUpdaterState) archiveCrossLaneUpdateCheck$prepare$12.L$16;
                        ArchiveUpdaterState archiveUpdaterState4 = (ArchiveUpdaterState) archiveCrossLaneUpdateCheck$prepare$12.L$15;
                        ArchiveManifest archiveManifest10 = (ArchiveManifest) archiveCrossLaneUpdateCheck$prepare$12.L$14;
                        ArchiveUpdateCheckRemoteStage archiveUpdateCheckRemoteStage10 = (ArchiveUpdateCheckRemoteStage) archiveCrossLaneUpdateCheck$prepare$12.L$13;
                        ArchiveManifest archiveManifest11 = (ArchiveManifest) archiveCrossLaneUpdateCheck$prepare$12.L$12;
                        ArchiveUpdateCheckRemoteStage archiveUpdateCheckRemoteStage11 = (ArchiveUpdateCheckRemoteStage) archiveCrossLaneUpdateCheck$prepare$12.L$11;
                        ArchiveGenerationMigration archiveGenerationMigration12 = (ArchiveGenerationMigration) archiveCrossLaneUpdateCheck$prepare$12.L$10;
                        Function0 function011 = (Function0) archiveCrossLaneUpdateCheck$prepare$12.L$9;
                        ArchiveBootstrapPrefetcher archiveBootstrapPrefetcher8 = (ArchiveBootstrapPrefetcher) archiveCrossLaneUpdateCheck$prepare$12.L$8;
                        String str35 = (String) archiveCrossLaneUpdateCheck$prepare$12.L$7;
                        ArchiveGpu archiveGpu10 = (ArchiveGpu) archiveCrossLaneUpdateCheck$prepare$12.L$6;
                        String str36 = (String) archiveCrossLaneUpdateCheck$prepare$12.L$5;
                        String str37 = (String) archiveCrossLaneUpdateCheck$prepare$12.L$4;
                        DurableArchiveStateStore durableArchiveStateStore19 = (DurableArchiveStateStore) archiveCrossLaneUpdateCheck$prepare$12.L$3;
                        DurableArchiveStateStore durableArchiveStateStore20 = (DurableArchiveStateStore) archiveCrossLaneUpdateCheck$prepare$12.L$2;
                        ArchiveUpdateCheckCoordinator archiveUpdateCheckCoordinator21 = (ArchiveUpdateCheckCoordinator) archiveCrossLaneUpdateCheck$prepare$12.L$1;
                        ArchiveUpdateCheckCoordinator archiveUpdateCheckCoordinator22 = (ArchiveUpdateCheckCoordinator) archiveCrossLaneUpdateCheck$prepare$12.L$0;
                        ResultKt.throwOnFailure(obj9);
                        archiveUpdateCheckDecision3 = (ArchiveUpdateCheckDecision) obj9;
                        if (archiveUpdateCheckDecision3 instanceof ArchiveUpdateCheckDecision.Block) {
                        }
                        return new ArchiveCrossLaneUpdateCheckResult(archiveUpdateCheckDecision2, archiveUpdateCheckDecision3, Boxing.boxBoolean(true), false, 8, null);
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        archiveCrossLaneUpdateCheck$prepare$1 = new ArchiveCrossLaneUpdateCheck$prepare$1(this, continuation);
        archiveCrossLaneUpdateCheck$prepare$12 = archiveCrossLaneUpdateCheck$prepare$1;
        Object obj92 = archiveCrossLaneUpdateCheck$prepare$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (archiveCrossLaneUpdateCheck$prepare$12.label) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0086  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object migrationGate(ArchiveGenerationMigration archiveGenerationMigration, ArchiveManifest archiveManifest, ArchiveManifest archiveManifest2, boolean z, Continuation<? super MigrationGate> continuation) {
        ArchiveCrossLaneUpdateCheck$migrationGate$1 archiveCrossLaneUpdateCheck$migrationGate$1;
        int i;
        boolean z2;
        ArchiveGenerationMigrationResult archiveGenerationMigrationResult;
        if (continuation instanceof ArchiveCrossLaneUpdateCheck$migrationGate$1) {
            archiveCrossLaneUpdateCheck$migrationGate$1 = (ArchiveCrossLaneUpdateCheck$migrationGate$1) continuation;
            if ((archiveCrossLaneUpdateCheck$migrationGate$1.label & Integer.MIN_VALUE) != 0) {
                archiveCrossLaneUpdateCheck$migrationGate$1.label -= Integer.MIN_VALUE;
                Object obj = archiveCrossLaneUpdateCheck$migrationGate$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = archiveCrossLaneUpdateCheck$migrationGate$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    if (archiveGenerationMigration == null) {
                        return new MigrationGate.Open(false);
                    }
                    archiveCrossLaneUpdateCheck$migrationGate$1.L$0 = SpillingKt.nullOutSpilledVariable(archiveGenerationMigration);
                    archiveCrossLaneUpdateCheck$migrationGate$1.L$1 = SpillingKt.nullOutSpilledVariable(archiveManifest);
                    archiveCrossLaneUpdateCheck$migrationGate$1.L$2 = SpillingKt.nullOutSpilledVariable(archiveManifest2);
                    archiveCrossLaneUpdateCheck$migrationGate$1.Z$0 = z;
                    archiveCrossLaneUpdateCheck$migrationGate$1.label = 1;
                    Object afterRemotesValidated = archiveGenerationMigration.afterRemotesValidated(archiveManifest, archiveManifest2, archiveCrossLaneUpdateCheck$migrationGate$1);
                    if (afterRemotesValidated == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    z2 = z;
                    obj = afterRemotesValidated;
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    z2 = archiveCrossLaneUpdateCheck$migrationGate$1.Z$0;
                    ArchiveManifest archiveManifest3 = (ArchiveManifest) archiveCrossLaneUpdateCheck$migrationGate$1.L$2;
                    ArchiveManifest archiveManifest4 = (ArchiveManifest) archiveCrossLaneUpdateCheck$migrationGate$1.L$1;
                    ArchiveGenerationMigration archiveGenerationMigration2 = (ArchiveGenerationMigration) archiveCrossLaneUpdateCheck$migrationGate$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                archiveGenerationMigrationResult = (ArchiveGenerationMigrationResult) obj;
                if (!Intrinsics.areEqual(archiveGenerationMigrationResult, ArchiveGenerationMigrationResult.NotRequired.INSTANCE)) {
                    return new MigrationGate.Open(false);
                }
                if (Intrinsics.areEqual(archiveGenerationMigrationResult, ArchiveGenerationMigrationResult.Prepared.INSTANCE)) {
                    return new MigrationGate.Open(true);
                }
                if (!(archiveGenerationMigrationResult instanceof ArchiveGenerationMigrationResult.Blocked)) {
                    throw new NoWhenBranchMatchedException();
                }
                return new MigrationGate.Blocked(new ArchiveCrossLaneUpdateCheckResult(((ArchiveGenerationMigrationResult.Blocked) archiveGenerationMigrationResult).getDecision(), null, z2 ? Boxing.boxBoolean(true) : null, false, 10, null));
            }
        }
        archiveCrossLaneUpdateCheck$migrationGate$1 = new ArchiveCrossLaneUpdateCheck$migrationGate$1(this, continuation);
        Object obj2 = archiveCrossLaneUpdateCheck$migrationGate$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = archiveCrossLaneUpdateCheck$migrationGate$1.label;
        if (i != 0) {
        }
        archiveGenerationMigrationResult = (ArchiveGenerationMigrationResult) obj2;
        if (!Intrinsics.areEqual(archiveGenerationMigrationResult, ArchiveGenerationMigrationResult.NotRequired.INSTANCE)) {
        }
    }

    private final ArchiveUpdateCheckDecision.Block desiredOnlyCollision(ArchiveManifest archiveManifest, ArchiveManifest archiveManifest2) {
        try {
            ArchiveContentCollisionGuard archiveContentCollisionGuard = ArchiveContentCollisionGuard.INSTANCE;
            List<ArchiveOwnedPath> fromManifest = ArchiveLaneOwnership.INSTANCE.fromManifest(archiveManifest);
            List<ArchiveOwnedPath> fromManifest2 = archiveManifest2 != null ? ArchiveLaneOwnership.INSTANCE.fromManifest(archiveManifest2) : null;
            if (fromManifest2 == null) {
                fromManifest2 = CollectionsKt.emptyList();
            }
            ArchiveContentCollisionGuard.validate$default(archiveContentCollisionGuard, fromManifest, fromManifest2, null, null, 12, null).requireValid();
            return null;
        } catch (IllegalArgumentException e) {
            return new ArchiveUpdateCheckDecision.Block(ArchiveUpdateCheckBlockCode.STATE_INVALID, e.getMessage());
        }
    }

    private final ArchiveUpdateCheckDecision.Block laneCollisionBlock(ArchiveManifest archiveManifest, ArchiveManifest archiveManifest2, DurableArchiveStateStore durableArchiveStateStore, DurableArchiveStateStore durableArchiveStateStore2) {
        try {
            ArchiveContentCollisionGuard archiveContentCollisionGuard = ArchiveContentCollisionGuard.INSTANCE;
            List<ArchiveOwnedPath> fromManifest = ArchiveLaneOwnership.INSTANCE.fromManifest(archiveManifest);
            List<ArchiveOwnedPath> fromManifest2 = archiveManifest2 != null ? ArchiveLaneOwnership.INSTANCE.fromManifest(archiveManifest2) : null;
            if (fromManifest2 == null) {
                fromManifest2 = CollectionsKt.emptyList();
            }
            archiveContentCollisionGuard.validate(fromManifest, fromManifest2, ArchiveLaneOwnership.INSTANCE.fromLoaded(durableArchiveStateStore.load()), ArchiveLaneOwnership.INSTANCE.fromLoaded(durableArchiveStateStore2.load())).requireValid();
            return null;
        } catch (IllegalArgumentException e) {
            return new ArchiveUpdateCheckDecision.Block(ArchiveUpdateCheckBlockCode.STATE_INVALID, e.getMessage());
        }
    }

    private final LaneStateLoad loadState(DurableArchiveStateStore durableArchiveStateStore) {
        try {
            ArchiveStateLoadResult load = durableArchiveStateStore.load();
            if (Intrinsics.areEqual(load, ArchiveStateLoadResult.Missing.INSTANCE)) {
                return new LaneStateLoad.Ready(null);
            }
            if (load instanceof ArchiveStateLoadResult.Loaded) {
                return new LaneStateLoad.Ready(((ArchiveStateLoadResult.Loaded) load).getState());
            }
            if (!(load instanceof ArchiveStateLoadResult.Corrupt)) {
                throw new NoWhenBranchMatchedException();
            }
            return new LaneStateLoad.Failed(new ArchiveCrossLaneUpdateCheckResult(new ArchiveUpdateCheckDecision.Block(ArchiveUpdateCheckBlockCode.STATE_CORRUPT, ((ArchiveStateLoadResult.Corrupt) load).getReason()), null, true, false, 10, null));
        } catch (Exception e) {
            return new LaneStateLoad.Failed(new ArchiveCrossLaneUpdateCheckResult(new ArchiveUpdateCheckDecision.Block(ArchiveUpdateCheckBlockCode.STATE_IO_FAILED, e.getMessage()), null, true, false, 10, null));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ArchiveCrossLaneUpdateCheck.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\br\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0082\u0001\u0002\u0004\u0005¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveCrossLaneUpdateCheck$LaneStateLoad;", "", "Ready", "Failed", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveCrossLaneUpdateCheck$LaneStateLoad$Failed;", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveCrossLaneUpdateCheck$LaneStateLoad$Ready;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public interface LaneStateLoad {

        /* compiled from: ArchiveCrossLaneUpdateCheck.kt */
        @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007Ê\u0001\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\u0003\u0010\u0000¨\u0006\u0012"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveCrossLaneUpdateCheck$LaneStateLoad$Ready;", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveCrossLaneUpdateCheck$LaneStateLoad;", RemoteConfigConstants.ResponseFieldKey.STATE, "Lcom/arizona/launcher/updater/archive/state/ArchiveUpdaterState;", "<init>", "(Lcom/arizona/launcher/updater/archive/state/ArchiveUpdaterState;)V", "getState", "()Lcom/arizona/launcher/updater/archive/state/ArchiveUpdaterState;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
        /* loaded from: classes3.dex */
        public static final class Ready implements LaneStateLoad {
            public static final int $stable = ArchiveUpdaterState.$stable;
            private final ArchiveUpdaterState state;

            public static /* synthetic */ Ready copy$default(Ready ready, ArchiveUpdaterState archiveUpdaterState, int i, Object obj) {
                if ((i & 1) != 0) {
                    archiveUpdaterState = ready.state;
                }
                return ready.copy(archiveUpdaterState);
            }

            public final ArchiveUpdaterState component1() {
                return this.state;
            }

            public final Ready copy(ArchiveUpdaterState archiveUpdaterState) {
                return new Ready(archiveUpdaterState);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Ready) && Intrinsics.areEqual(this.state, ((Ready) obj).state);
            }

            public int hashCode() {
                ArchiveUpdaterState archiveUpdaterState = this.state;
                if (archiveUpdaterState == null) {
                    return 0;
                }
                return archiveUpdaterState.hashCode();
            }

            public String toString() {
                return "Ready(state=" + this.state + ")";
            }

            public Ready(ArchiveUpdaterState archiveUpdaterState) {
                this.state = archiveUpdaterState;
            }

            public final ArchiveUpdaterState getState() {
                return this.state;
            }
        }

        /* compiled from: ArchiveCrossLaneUpdateCheck.kt */
        @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007Ê\u0001\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0012"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveCrossLaneUpdateCheck$LaneStateLoad$Failed;", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveCrossLaneUpdateCheck$LaneStateLoad;", "result", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveCrossLaneUpdateCheckResult;", "<init>", "(Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveCrossLaneUpdateCheckResult;)V", "getResult", "()Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveCrossLaneUpdateCheckResult;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
        /* loaded from: classes3.dex */
        public static final class Failed implements LaneStateLoad {
            public static final int $stable = 0;
            private final ArchiveCrossLaneUpdateCheckResult result;

            public static /* synthetic */ Failed copy$default(Failed failed, ArchiveCrossLaneUpdateCheckResult archiveCrossLaneUpdateCheckResult, int i, Object obj) {
                if ((i & 1) != 0) {
                    archiveCrossLaneUpdateCheckResult = failed.result;
                }
                return failed.copy(archiveCrossLaneUpdateCheckResult);
            }

            public final ArchiveCrossLaneUpdateCheckResult component1() {
                return this.result;
            }

            public final Failed copy(ArchiveCrossLaneUpdateCheckResult result) {
                Intrinsics.checkNotNullParameter(result, "result");
                return new Failed(result);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Failed) && Intrinsics.areEqual(this.result, ((Failed) obj).result);
            }

            public int hashCode() {
                return this.result.hashCode();
            }

            public String toString() {
                return "Failed(result=" + this.result + ")";
            }

            public Failed(ArchiveCrossLaneUpdateCheckResult result) {
                Intrinsics.checkNotNullParameter(result, "result");
                this.result = result;
            }

            public final ArchiveCrossLaneUpdateCheckResult getResult() {
                return this.result;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ArchiveCrossLaneUpdateCheck.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\br\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0082\u0001\u0002\u0004\u0005¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveCrossLaneUpdateCheck$MigrationGate;", "", "Blocked", "Open", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveCrossLaneUpdateCheck$MigrationGate$Blocked;", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveCrossLaneUpdateCheck$MigrationGate$Open;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public interface MigrationGate {

        /* compiled from: ArchiveCrossLaneUpdateCheck.kt */
        @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007Ê\u0001\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0012"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveCrossLaneUpdateCheck$MigrationGate$Blocked;", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveCrossLaneUpdateCheck$MigrationGate;", "result", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveCrossLaneUpdateCheckResult;", "<init>", "(Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveCrossLaneUpdateCheckResult;)V", "getResult", "()Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveCrossLaneUpdateCheckResult;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
        /* loaded from: classes3.dex */
        public static final class Blocked implements MigrationGate {
            public static final int $stable = 0;
            private final ArchiveCrossLaneUpdateCheckResult result;

            public static /* synthetic */ Blocked copy$default(Blocked blocked, ArchiveCrossLaneUpdateCheckResult archiveCrossLaneUpdateCheckResult, int i, Object obj) {
                if ((i & 1) != 0) {
                    archiveCrossLaneUpdateCheckResult = blocked.result;
                }
                return blocked.copy(archiveCrossLaneUpdateCheckResult);
            }

            public final ArchiveCrossLaneUpdateCheckResult component1() {
                return this.result;
            }

            public final Blocked copy(ArchiveCrossLaneUpdateCheckResult result) {
                Intrinsics.checkNotNullParameter(result, "result");
                return new Blocked(result);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Blocked) && Intrinsics.areEqual(this.result, ((Blocked) obj).result);
            }

            public int hashCode() {
                return this.result.hashCode();
            }

            public String toString() {
                return "Blocked(result=" + this.result + ")";
            }

            public Blocked(ArchiveCrossLaneUpdateCheckResult result) {
                Intrinsics.checkNotNullParameter(result, "result");
                this.result = result;
            }

            public final ArchiveCrossLaneUpdateCheckResult getResult() {
                return this.result;
            }
        }

        /* compiled from: ArchiveCrossLaneUpdateCheck.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0083\u0004J\n\u0010\r\u001a\u00020\u000eHÖ\u0081\u0004J\n\u0010\u000f\u001a\u00020\u0010HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007Ê\u0001\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0011"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveCrossLaneUpdateCheck$MigrationGate$Open;", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveCrossLaneUpdateCheck$MigrationGate;", "disallowExistingAdoption", "", "<init>", "(Z)V", "getDisallowExistingAdoption", "()Z", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
        /* loaded from: classes3.dex */
        public static final class Open implements MigrationGate {
            public static final int $stable = 0;
            private final boolean disallowExistingAdoption;

            public static /* synthetic */ Open copy$default(Open open, boolean z, int i, Object obj) {
                if ((i & 1) != 0) {
                    z = open.disallowExistingAdoption;
                }
                return open.copy(z);
            }

            public final boolean component1() {
                return this.disallowExistingAdoption;
            }

            public final Open copy(boolean z) {
                return new Open(z);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Open) && this.disallowExistingAdoption == ((Open) obj).disallowExistingAdoption;
            }

            public int hashCode() {
                return Boolean.hashCode(this.disallowExistingAdoption);
            }

            public String toString() {
                return "Open(disallowExistingAdoption=" + this.disallowExistingAdoption + ")";
            }

            public Open(boolean z) {
                this.disallowExistingAdoption = z;
            }

            public final boolean getDisallowExistingAdoption() {
                return this.disallowExistingAdoption;
            }
        }
    }
}
