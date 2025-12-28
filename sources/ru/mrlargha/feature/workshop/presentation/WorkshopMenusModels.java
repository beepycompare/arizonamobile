package ru.mrlargha.feature.workshop.presentation;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: WorkshopResponse.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\b\u0016\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005¢\u0006\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010¨\u0006\u0016"}, d2 = {"Lru/mrlargha/feature/workshop/presentation/WorkshopMenusModels;", "", "id", "", "menuName", "", "desc", "rightFieldName", "leftFieldName", "mainFieldName", "buttonName", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()I", "getMenuName", "()Ljava/lang/String;", "getDesc", "getRightFieldName", "getLeftFieldName", "getMainFieldName", "getButtonName", "workshop_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes6.dex */
public class WorkshopMenusModels {
    private final String buttonName;
    private final String desc;
    private final int id;
    private final String leftFieldName;
    private final String mainFieldName;
    private final String menuName;
    private final String rightFieldName;

    public WorkshopMenusModels(int i, String menuName, String desc, String rightFieldName, String leftFieldName, String mainFieldName, String buttonName) {
        Intrinsics.checkNotNullParameter(menuName, "menuName");
        Intrinsics.checkNotNullParameter(desc, "desc");
        Intrinsics.checkNotNullParameter(rightFieldName, "rightFieldName");
        Intrinsics.checkNotNullParameter(leftFieldName, "leftFieldName");
        Intrinsics.checkNotNullParameter(mainFieldName, "mainFieldName");
        Intrinsics.checkNotNullParameter(buttonName, "buttonName");
        this.id = i;
        this.menuName = menuName;
        this.desc = desc;
        this.rightFieldName = rightFieldName;
        this.leftFieldName = leftFieldName;
        this.mainFieldName = mainFieldName;
        this.buttonName = buttonName;
    }

    public final int getId() {
        return this.id;
    }

    public final String getMenuName() {
        return this.menuName;
    }

    public final String getDesc() {
        return this.desc;
    }

    public final String getRightFieldName() {
        return this.rightFieldName;
    }

    public final String getLeftFieldName() {
        return this.leftFieldName;
    }

    public final String getMainFieldName() {
        return this.mainFieldName;
    }

    public final String getButtonName() {
        return this.buttonName;
    }
}
