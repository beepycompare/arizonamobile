package com.arizona.launcher.updater.archive.orchestrator;

import com.arizona.launcher.updater.archive.manifest.ArchiveManifestParser;
import com.arizona.launcher.updater.archive.manifest.OriginalTzArchiveManifestParser;
import com.arizona.launcher.updater.archive.model.ArchiveGpu;
import com.arizona.launcher.updater.archive.model.ArchiveManifest;
import com.arizona.launcher.updater.archive.orchestrator.ArchiveManifestCandidate;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ArchiveManifestResolver.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000Ê\u0001\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\u0003\u0010\u0000¨\u0006\u000e"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveManifestCandidateParser;", "", "v2Parser", "Lcom/arizona/launcher/updater/archive/manifest/ArchiveManifestParser;", "originalTzParser", "Lcom/arizona/launcher/updater/archive/manifest/OriginalTzArchiveManifestParser;", "<init>", "(Lcom/arizona/launcher/updater/archive/manifest/ArchiveManifestParser;Lcom/arizona/launcher/updater/archive/manifest/OriginalTzArchiveManifestParser;)V", "parse", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveManifestCandidate;", "response", "", "selectedGpu", "Lcom/arizona/launcher/updater/archive/model/ArchiveGpu;", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ArchiveManifestCandidateParser {
    public static final int $stable = OriginalTzArchiveManifestParser.$stable | ArchiveManifestParser.$stable;
    private final OriginalTzArchiveManifestParser originalTzParser;
    private final ArchiveManifestParser v2Parser;

    public ArchiveManifestCandidateParser() {
        this(null, null, 3, null);
    }

    public ArchiveManifestCandidateParser(ArchiveManifestParser v2Parser, OriginalTzArchiveManifestParser originalTzParser) {
        Intrinsics.checkNotNullParameter(v2Parser, "v2Parser");
        Intrinsics.checkNotNullParameter(originalTzParser, "originalTzParser");
        this.v2Parser = v2Parser;
        this.originalTzParser = originalTzParser;
    }

    public /* synthetic */ ArchiveManifestCandidateParser(ArchiveManifestParser archiveManifestParser, OriginalTzArchiveManifestParser originalTzArchiveManifestParser, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new ArchiveManifestParser() : archiveManifestParser, (i & 2) != 0 ? new OriginalTzArchiveManifestParser() : originalTzArchiveManifestParser);
    }

    public final ArchiveManifestCandidate parse(String response, ArchiveGpu selectedGpu) {
        Intrinsics.checkNotNullParameter(response, "response");
        Intrinsics.checkNotNullParameter(selectedGpu, "selectedGpu");
        ArchiveManifest parseOrNull = this.v2Parser.parseOrNull(response, selectedGpu);
        if (parseOrNull != null) {
            return new ArchiveManifestCandidate.Resolved(parseOrNull);
        }
        return new ArchiveManifestCandidate.OriginalTz(this.originalTzParser.parse(response, selectedGpu));
    }
}
