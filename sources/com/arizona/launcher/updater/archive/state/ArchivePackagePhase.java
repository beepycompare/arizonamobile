package com.arizona.launcher.updater.archive.state;

import java.lang.annotation.Annotation;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.internal.EnumsKt;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: ArchivePackagePhase.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\b\u0087\u0081\u0002\u0018\u0000 \u000f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000fB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0010\b\u0004\u0012\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0004j\u0010\b\u0007\u0012\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007j\u0010\b\b\u0012\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\bj\u0010\b\t\u0012\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\tj\u0010\b\n\u0012\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\nj\u0010\b\u000b\u0012\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u000bj\u0010\b\f\u0012\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\fj\u0010\b\r\u0012\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\rj\u0010\b\u000e\u0012\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u000eÊ\u0001\u0002\b\u0011¨\u0006\u0010"}, d2 = {"Lcom/arizona/launcher/updater/archive/state/ArchivePackagePhase;", "", "<init>", "(Ljava/lang/String;I)V", "PLANNED", "Lkotlinx/serialization/SerialName;", "value", "DOWNLOADING", "DOWNLOADED", "VERIFYING", "VERIFIED", "EXTRACTING", "EXTRACTED", "COMMITTING", "COMMITTED", "Companion", "app", "Lkotlinx/serialization/Serializable;"}, k = 1, mv = {2, 4, 0}, xi = 48)
@Serializable
/* loaded from: classes3.dex */
public final class ArchivePackagePhase {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ArchivePackagePhase[] $VALUES;
    private static final Lazy<KSerializer<Object>> $cachedSerializer$delegate;
    public static final Companion Companion;
    @SerialName("PLANNED")
    public static final ArchivePackagePhase PLANNED = new ArchivePackagePhase("PLANNED", 0);
    @SerialName("DOWNLOADING")
    public static final ArchivePackagePhase DOWNLOADING = new ArchivePackagePhase("DOWNLOADING", 1);
    @SerialName("DOWNLOADED")
    public static final ArchivePackagePhase DOWNLOADED = new ArchivePackagePhase("DOWNLOADED", 2);
    @SerialName("VERIFYING")
    public static final ArchivePackagePhase VERIFYING = new ArchivePackagePhase("VERIFYING", 3);
    @SerialName("VERIFIED")
    public static final ArchivePackagePhase VERIFIED = new ArchivePackagePhase("VERIFIED", 4);
    @SerialName("EXTRACTING")
    public static final ArchivePackagePhase EXTRACTING = new ArchivePackagePhase("EXTRACTING", 5);
    @SerialName("EXTRACTED")
    public static final ArchivePackagePhase EXTRACTED = new ArchivePackagePhase("EXTRACTED", 6);
    @SerialName("COMMITTING")
    public static final ArchivePackagePhase COMMITTING = new ArchivePackagePhase("COMMITTING", 7);
    @SerialName("COMMITTED")
    public static final ArchivePackagePhase COMMITTED = new ArchivePackagePhase("COMMITTED", 8);

    private static final /* synthetic */ ArchivePackagePhase[] $values() {
        return new ArchivePackagePhase[]{PLANNED, DOWNLOADING, DOWNLOADED, VERIFYING, VERIFIED, EXTRACTING, EXTRACTED, COMMITTING, COMMITTED};
    }

    public static EnumEntries<ArchivePackagePhase> getEntries() {
        return $ENTRIES;
    }

    public static ArchivePackagePhase valueOf(String str) {
        return (ArchivePackagePhase) Enum.valueOf(ArchivePackagePhase.class, str);
    }

    public static ArchivePackagePhase[] values() {
        return (ArchivePackagePhase[]) $VALUES.clone();
    }

    /* compiled from: ArchivePackagePhase.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/arizona/launcher/updater/archive/state/ArchivePackagePhase$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/arizona/launcher/updater/archive/state/ArchivePackagePhase;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        private final /* synthetic */ KSerializer get$cachedSerializer() {
            return (KSerializer) ArchivePackagePhase.$cachedSerializer$delegate.getValue();
        }

        public final KSerializer<ArchivePackagePhase> serializer() {
            return get$cachedSerializer();
        }
    }

    private ArchivePackagePhase(String str, int i) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _init_$_anonymous_() {
        return EnumsKt.createAnnotatedEnumSerializer("com.arizona.launcher.updater.archive.state.ArchivePackagePhase", values(), new String[]{"PLANNED", "DOWNLOADING", "DOWNLOADED", "VERIFYING", "VERIFIED", "EXTRACTING", "EXTRACTED", "COMMITTING", "COMMITTED"}, new Annotation[][]{null, null, null, null, null, null, null, null, null}, null);
    }

    static {
        ArchivePackagePhase[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
        Companion = new Companion(null);
        $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.arizona.launcher.updater.archive.state.ArchivePackagePhase$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KSerializer _init_$_anonymous_;
                _init_$_anonymous_ = ArchivePackagePhase._init_$_anonymous_();
                return _init_$_anonymous_;
            }
        });
    }
}
