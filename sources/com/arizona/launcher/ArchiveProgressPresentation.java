package com.arizona.launcher;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: ArchiveProgressPresentation.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0080\u0081\u0002\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/arizona/launcher/ArchiveProgressPresentation;", "", "showsTransferDetails", "", "<init>", "(Ljava/lang/String;IZ)V", "getShowsTransferDetails", "()Z", "DOWNLOADING", "WAITING_FOR_NETWORK", "VERIFYING", "EXTRACTING", "INSTALLING", "Companion", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ArchiveProgressPresentation {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ArchiveProgressPresentation[] $VALUES;
    public static final Companion Companion;
    private final boolean showsTransferDetails;
    public static final ArchiveProgressPresentation DOWNLOADING = new ArchiveProgressPresentation("DOWNLOADING", 0, true);
    public static final ArchiveProgressPresentation WAITING_FOR_NETWORK = new ArchiveProgressPresentation("WAITING_FOR_NETWORK", 1, false);
    public static final ArchiveProgressPresentation VERIFYING = new ArchiveProgressPresentation("VERIFYING", 2, false);
    public static final ArchiveProgressPresentation EXTRACTING = new ArchiveProgressPresentation("EXTRACTING", 3, false);
    public static final ArchiveProgressPresentation INSTALLING = new ArchiveProgressPresentation("INSTALLING", 4, false);

    private static final /* synthetic */ ArchiveProgressPresentation[] $values() {
        return new ArchiveProgressPresentation[]{DOWNLOADING, WAITING_FOR_NETWORK, VERIFYING, EXTRACTING, INSTALLING};
    }

    public static EnumEntries<ArchiveProgressPresentation> getEntries() {
        return $ENTRIES;
    }

    public static ArchiveProgressPresentation valueOf(String str) {
        return (ArchiveProgressPresentation) Enum.valueOf(ArchiveProgressPresentation.class, str);
    }

    public static ArchiveProgressPresentation[] values() {
        return (ArchiveProgressPresentation[]) $VALUES.clone();
    }

    private ArchiveProgressPresentation(String str, int i, boolean z) {
        this.showsTransferDetails = z;
    }

    public final boolean getShowsTransferDetails() {
        return this.showsTransferDetails;
    }

    static {
        ArchiveProgressPresentation[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
        Companion = new Companion(null);
    }

    /* compiled from: ArchiveProgressPresentation.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¨\u0006\b"}, d2 = {"Lcom/arizona/launcher/ArchiveProgressPresentation$Companion;", "", "<init>", "()V", "fromWirePhase", "Lcom/arizona/launcher/ArchiveProgressPresentation;", TypedValues.CycleType.S_WAVE_PHASE, "", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ArchiveProgressPresentation fromWirePhase(String str) {
            if (str != null) {
                switch (str.hashCode()) {
                    case 16877926:
                        if (str.equals("WAITING_FOR_NETWORK")) {
                            return ArchiveProgressPresentation.WAITING_FOR_NETWORK;
                        }
                        return null;
                    case 183181625:
                        if (str.equals("COMPLETE")) {
                            return ArchiveProgressPresentation.INSTALLING;
                        }
                        return null;
                    case 464552472:
                        if (!str.equals("RETIRING")) {
                            return null;
                        }
                        break;
                    case 941831738:
                        if (str.equals("DOWNLOADING")) {
                            return ArchiveProgressPresentation.DOWNLOADING;
                        }
                        return null;
                    case 1090724009:
                        if (str.equals("VERIFYING")) {
                            return ArchiveProgressPresentation.VERIFYING;
                        }
                        return null;
                    case 1236650945:
                        if (str.equals("EXTRACTING")) {
                            return ArchiveProgressPresentation.EXTRACTING;
                        }
                        return null;
                    case 1504310437:
                        if (!str.equals("COMMITTING")) {
                            return null;
                        }
                        break;
                    default:
                        return null;
                }
                return ArchiveProgressPresentation.INSTALLING;
            }
            return null;
        }
    }
}
