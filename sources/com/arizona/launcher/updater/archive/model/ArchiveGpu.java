package com.arizona.launcher.updater.archive.model;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: ArchiveGpu.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/arizona/launcher/updater/archive/model/ArchiveGpu;", "", "wireName", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getWireName", "()Ljava/lang/String;", "ADRENO", "MALI", "POWERVR", "Companion", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ArchiveGpu {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ArchiveGpu[] $VALUES;
    public static final Companion Companion;
    private final String wireName;
    public static final ArchiveGpu ADRENO = new ArchiveGpu("ADRENO", 0, "adreno");
    public static final ArchiveGpu MALI = new ArchiveGpu("MALI", 1, "mali");
    public static final ArchiveGpu POWERVR = new ArchiveGpu("POWERVR", 2, "powervr");

    private static final /* synthetic */ ArchiveGpu[] $values() {
        return new ArchiveGpu[]{ADRENO, MALI, POWERVR};
    }

    public static EnumEntries<ArchiveGpu> getEntries() {
        return $ENTRIES;
    }

    public static ArchiveGpu valueOf(String str) {
        return (ArchiveGpu) Enum.valueOf(ArchiveGpu.class, str);
    }

    public static ArchiveGpu[] values() {
        return (ArchiveGpu[]) $VALUES.clone();
    }

    private ArchiveGpu(String str, int i, String str2) {
        this.wireName = str2;
    }

    public final String getWireName() {
        return this.wireName;
    }

    static {
        ArchiveGpu[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
        Companion = new Companion(null);
    }

    /* compiled from: ArchiveGpu.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/arizona/launcher/updater/archive/model/ArchiveGpu$Companion;", "", "<init>", "()V", "fromWireName", "Lcom/arizona/launcher/updater/archive/model/ArchiveGpu;", "value", "", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ArchiveGpu fromWireName(String value) {
            Object obj;
            Intrinsics.checkNotNullParameter(value, "value");
            Iterator<E> it = ArchiveGpu.getEntries().iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (Intrinsics.areEqual(((ArchiveGpu) obj).getWireName(), value)) {
                    break;
                }
            }
            return (ArchiveGpu) obj;
        }
    }
}
