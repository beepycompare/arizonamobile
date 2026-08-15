package com.arizona.launcher.updater.archive.model;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: ArchivePackage.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\b¨\u0006\n"}, d2 = {"Lcom/arizona/launcher/updater/archive/model/ArchivePackageType;", "", "wireName", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getWireName", "()Ljava/lang/String;", "ARCHIVE", "Companion", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ArchivePackageType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ArchivePackageType[] $VALUES;
    public static final ArchivePackageType ARCHIVE = new ArchivePackageType("ARCHIVE", 0, "archive");
    public static final Companion Companion;
    private final String wireName;

    private static final /* synthetic */ ArchivePackageType[] $values() {
        return new ArchivePackageType[]{ARCHIVE};
    }

    public static EnumEntries<ArchivePackageType> getEntries() {
        return $ENTRIES;
    }

    public static ArchivePackageType valueOf(String str) {
        return (ArchivePackageType) Enum.valueOf(ArchivePackageType.class, str);
    }

    public static ArchivePackageType[] values() {
        return (ArchivePackageType[]) $VALUES.clone();
    }

    private ArchivePackageType(String str, int i, String str2) {
        this.wireName = str2;
    }

    public final String getWireName() {
        return this.wireName;
    }

    static {
        ArchivePackageType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
        Companion = new Companion(null);
    }

    /* compiled from: ArchivePackage.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/arizona/launcher/updater/archive/model/ArchivePackageType$Companion;", "", "<init>", "()V", "fromWireName", "Lcom/arizona/launcher/updater/archive/model/ArchivePackageType;", "value", "", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ArchivePackageType fromWireName(String value) {
            Object obj;
            Intrinsics.checkNotNullParameter(value, "value");
            Iterator<E> it = ArchivePackageType.getEntries().iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (Intrinsics.areEqual(((ArchivePackageType) obj).getWireName(), value)) {
                    break;
                }
            }
            return (ArchivePackageType) obj;
        }
    }
}
