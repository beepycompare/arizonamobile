package com.arizona.launcher.updater.archive.orchestrator;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ArchiveCrossLaneUpdateCheck.kt */
@Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* synthetic */ class ArchiveCrossLaneUpdateCheck$prepare$2 extends FunctionReferenceImpl implements Function0<Long> {
    public static final ArchiveCrossLaneUpdateCheck$prepare$2 INSTANCE = new ArchiveCrossLaneUpdateCheck$prepare$2();

    ArchiveCrossLaneUpdateCheck$prepare$2() {
        super(0, System.class, "currentTimeMillis", "currentTimeMillis()J", 0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final Long invoke() {
        return Long.valueOf(System.currentTimeMillis());
    }
}
